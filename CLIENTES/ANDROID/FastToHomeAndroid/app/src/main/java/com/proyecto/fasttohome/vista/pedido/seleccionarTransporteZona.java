package com.proyecto.fasttohome.vista.pedido;

import static com.google.android.gms.location.LocationRequest.PRIORITY_HIGH_ACCURACY;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;

import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.Dash;
import com.google.android.gms.maps.model.Dot;
import com.google.android.gms.maps.model.Gap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PatternItem;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.maps.android.PolyUtil;
import com.proyecto.fasttohome.R;
import com.proyecto.fasttohome.modelo.Direccion;
import com.proyecto.fasttohome.modelo.Pedido;
import com.proyecto.fasttohome.modelo.Peticion;
import com.proyecto.fasttohome.modelo.Usuario;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class seleccionarTransporteZona extends AppCompatActivity implements OnMapReadyCallback, LocationListener {
    private FusedLocationProviderClient fusedLocationClient;
    MapView mapView;
    GoogleMap mMap;
    MarkerOptions marker;
    Button pedirDron, pedirRepartidor;
    TextView servicio;
    Polygon polygonDron;
    Polygon polygonReparto;
    FusedLocationProviderClient mFusedLocationClient;
    LatLng coordenadasActuales;
    Usuario user;
    Pedido pedido;
    Direccion direccion;
    boolean pararUbicacion;

    // Initializing other items
    // from layout file
    TextView latitudeTextView, longitTextView;
    int PERMISSION_ID = 44;

    @SuppressLint("MissingPermission")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccionar_transporte_zona);
        pararUbicacion = false;
        pedirDron = (Button) findViewById(R.id.btTransporteDron);
        pedirRepartidor = (Button) findViewById(R.id.btTransporteRepartidor);
        servicio = (TextView) findViewById(R.id.servicio);
        mapView = (MapView) findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(seleccionarTransporteZona.this);
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

        //RECEPCION DEL ACTIVITY ANTERIOR
        user = (Usuario) getIntent().getExtras().getSerializable("user");
        direccion = (Direccion) getIntent().getExtras().getSerializable("direccion");

        View.OnClickListener listener = view -> {
            updateDireccion(view);
        };
        pedirDron.setOnClickListener(listener);
        pedirRepartidor.setOnClickListener(listener);
        getLastLocation();
    }


    private void updateDireccion(View view) {
        if(coordenadasActuales != null){
            pararUbicacion=true;
            direccion.setCoordenadas(coordenadasActuales.latitude+","+coordenadasActuales.longitude);
            System.out.println(direccion.getJSON());
            String url = getString(R.string.apiUrl);
            RequestQueue queue = Volley.newRequestQueue(seleccionarTransporteZona.this);
            StringRequest request = new StringRequest(Request.Method.POST, url, response -> {
                System.out.println(response);
                try {
                    JSONObject resp = new JSONObject(response);
                    if ((resp.getBoolean("error")) == true) {
                        throw new VolleyError(resp.getString("datos"));
                    } else {
                        comenzarPedido(view);
                    }
                } catch (JSONException | VolleyError e) {
                    Toast.makeText(seleccionarTransporteZona.this, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }, error -> Toast.makeText(seleccionarTransporteZona.this, "ERROR DE CONEXIÓN = " + error, Toast.LENGTH_SHORT).show()) {
                @Override
                protected Map<String, String> getParams() {
                    Map<String, String> params = new HashMap<String, String>();
                    params.put("DATA", new Peticion("actualizar_direccion", direccion.getJSON()).getJSON());
                    return params;
                }
            };
            queue.add(request);

        }
    }

    private void comenzarPedido(View view) {
        System.out.println("comenzar pedido");
        pedido = new Pedido();
        pedido.setEstado("pendiente_pago");
        if (view.getId() == R.id.btTransporteDron) {
            pedido.setTransporte("dron");
        } else {
            pedido.setTransporte("repartidor");
        }
        Intent i = new Intent(this, PantallaDeNegocios.class);
        i.putExtra("user", user);
        i.putExtra("pedido", pedido);
        startActivity(i);
    }


    @SuppressLint("MissingPermission")
    private void getLastLocation() {
        if (!pararUbicacion) {
            if (checkPermissions()) {
                if (isLocationEnabled()) {
                    mFusedLocationClient.getCurrentLocation(PRIORITY_HIGH_ACCURACY, null).addOnCompleteListener(new OnCompleteListener<Location>() {
                        @Override
                        public void onComplete(@NonNull Task<Location> task) {
                            Location location = task.getResult();
                            updateMapa(location);
                        }
                    });
                } else {
                    Toast.makeText(this, "Please turn on" + " your location...", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                    startActivity(intent);
                }
            } else {
                // if permissions aren't available,
                // request for permissions
                requestPermissions();
            }
        }
    }

    private void updateMapa(Location location) {
        if (location == null) {
            getLastLocation();
        } else {
            coordenadasActuales = new LatLng(location.getLatitude(), location.getLongitude());
            mMap.addMarker(marker.position(coordenadasActuales));
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(coordenadasActuales, 14F));
            Handler handler = new Handler();
            //Hilo para actualizar recursivamente
            comprobarServicio(coordenadasActuales);
            if (!pararUbicacion) {
                final Runnable r = new Runnable() {
                    public void run() {
                        getLastLocation();
                    }
                };
                handler.postDelayed(r, 1500);
            }
        }
    }

    private void comprobarServicio(LatLng actual) {
        boolean estaEnAreaDron = PolyUtil.containsLocation(actual, polygonDron.getPoints(), true);
        boolean estaEnAreaRepartior = PolyUtil.containsLocation(actual, polygonReparto.getPoints(), true);

        if (estaEnAreaDron) {
            pedirDron.setEnabled(true);
        } else {
            pedirDron.setEnabled(false);
        }
        if (estaEnAreaRepartior) {
            pedirRepartidor.setEnabled(true);
        } else {
            pedirRepartidor.setEnabled(false);
        }

        if (!pedirDron.isEnabled() && !pedirRepartidor.isEnabled()) {
            servicio.setText(getString(R.string.servicioNoDisponible));
        } else {
            servicio.setText(getString(R.string.servicioDisponible));
        }
    }


    // method to check for permissions
    private boolean checkPermissions() {
        return ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED;
    }

    // method to request for permissions
    private void requestPermissions() {
        ActivityCompat.requestPermissions(this, new String[]{
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION}, PERMISSION_ID);
    }

    // method to check
    // if location is enabled
    private boolean isLocationEnabled() {
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) || locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
    }

    // If everything is alright then
    @Override
    public void
    onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PERMISSION_ID) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                getLastLocation();
            } else {
                super.onBackPressed();
            }
        }
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {

        mMap = googleMap;
        polygonDron = mMap.addPolygon(new PolygonOptions()
                .clickable(true)
                .add(new LatLng(38.9403638, -5.8632235),
                        new LatLng(38.9559078, -5.841610),
                        new LatLng(38.9641799, -5.841169),
                        new LatLng(38.9664046, -5.8663748),
                        new LatLng(38.9620667, -5.9148691),
                        new LatLng(38.930187, -5.895466)));
        polygonDron.setTag("alpha");
        stylePolygon(polygonDron);

        polygonReparto = mMap.addPolygon(new PolygonOptions()
                .clickable(true)
                .add(new LatLng(38.9490172, -5.8563517),
                        new LatLng(38.9595173, -5.8558423),
                        new LatLng(38.9581207, -5.8659363),
                        new LatLng(38.9567343, -5.8721024),
                        new LatLng(38.9539541, -5.8714152),
                        new LatLng(38.946887, -5.8592669)));
        // Store a data object with the polygon, used here to indicate an arbitrary type.
        polygonReparto.setTag("beta");
        stylePolygon(polygonReparto);
        marker = new MarkerOptions().position(new LatLng(0, 0));
        getLastLocation();

        // Add a marker in Sydney and move the camera

    }

    // [START maps_poly_activity_style_polygon]
    private static final int COLOR_WHITE_ARGB = 0xffffffff;
    private static final int COLOR_DARK_GREEN_ARGB = 0xff388E3C;
    private static final int COLOR_LIGHT_GREEN_ARGB = 0xff81C784;
    private static final int COLOR_DARK_ORANGE_ARGB = 0xffF57F17;
    private static final int COLOR_LIGHT_ORANGE_ARGB = 0xffF9A825;
    private static final int COLOR_BLACK_ARGB = 0xff000000;
    private static final int POLYGON_STROKE_WIDTH_PX = 8;
    private static final int PATTERN_DASH_LENGTH_PX = 20;
    private static final PatternItem DASH = new Dash(PATTERN_DASH_LENGTH_PX);
    // [END maps_poly_activity_style_polyline]

    // [START maps_poly_activity_on_polyline_click]
    private static final int PATTERN_GAP_LENGTH_PX = 20;
    private static final PatternItem DOT = new Dot();
    private static final PatternItem GAP = new Gap(PATTERN_GAP_LENGTH_PX);

    // Create a stroke pattern of a gap followed by a dot.
    private static final List<PatternItem> PATTERN_POLYLINE_DOTTED = Arrays.asList(GAP, DOT);

    // Create a stroke pattern of a gap followed by a dash.
    private static final List<PatternItem> PATTERN_POLYGON_ALPHA = Arrays.asList(GAP, DASH);

    // Create a stroke pattern of a dot followed by a gap, a dash, and another gap.
    private static final List<PatternItem> PATTERN_POLYGON_BETA = Arrays.asList(DOT, GAP, DASH, GAP);

    /**
     * Styles the polygon, based on type.
     *
     * @param polygon The polygon object that needs styling.
     */
    private void stylePolygon(Polygon polygon) {
        String type = "";
        // Get the data object stored with the polygon.
        if (polygon.getTag() != null) {
            type = polygon.getTag().toString();
        }

        List<PatternItem> pattern = null;
        int strokeColor = COLOR_BLACK_ARGB;
        int fillColor = COLOR_WHITE_ARGB;

        switch (type) {
            // If no type is given, allow the API to use the default.
            case "alpha":
                // Apply a stroke pattern to render a dashed line, and define colors.
                pattern = PATTERN_POLYGON_ALPHA;
                strokeColor = COLOR_DARK_GREEN_ARGB;
                fillColor = COLOR_LIGHT_GREEN_ARGB;
                break;
            case "beta":
                // Apply a stroke pattern to render a line of dots and dashes, and define colors.
                pattern = PATTERN_POLYGON_BETA;
                strokeColor = COLOR_DARK_ORANGE_ARGB;
                fillColor = COLOR_LIGHT_ORANGE_ARGB;
                break;
        }

        polygon.setStrokePattern(pattern);
        polygon.setStrokeWidth(POLYGON_STROKE_WIDTH_PX);
        polygon.setStrokeColor(strokeColor);
        polygon.setFillColor(fillColor);
    }


    @Override
    public void onResume() {
        mapView.onResume();
        if (checkPermissions()) {
            getLastLocation();
        }
        super.onResume();
    }

    @Override
    public void onPause() {
        pararUbicacion = true;
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onDestroy() {
        pararUbicacion = true;
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    @Override
    public void onLocationChanged(@NonNull Location location) {
    }
}