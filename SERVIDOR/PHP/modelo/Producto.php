<?php
require_once '../controlador/conexion.php';
/**
 * Description of Producto
 *
 * @author Jesus
 */
class Producto extends Conexion{
    private $id_producto;
    private $id_negocio;
    private $nombre;
    private $precio;
    private $descripcion;
    private $stock;
    private $id_imagen;
    
    public function getId_producto() {
        return $this->id_producto;
    }

    public function getId_negocio() {
        return $this->id_negocio;
    }

    public function getNombre() {
        return $this->nombre;
    }

    public function getPrecio() {
        return $this->precio;
    }

    public function getDescripcion() {
        return $this->descripcion;
    }

    public function getStock() {
        return $this->stock;
    }

    public function setId_producto($id_producto): void {
        $this->id_producto = $id_producto;
    }

    public function setId_negocio($id_negocio): void {
        $this->id_negocio = $id_negocio;
    }

    public function setNombre($nombre): void {
        $this->nombre = $nombre;
    }

    public function setPrecio($precio): void {
        $this->precio = $precio;
    }

    public function setDescripcion($descripcion): void {
        $this->descripcion = $descripcion;
    }

    public function setStock($stock): void {
        $this->stock = $stock;
    }
    
    public function getId_imagen() {
        return $this->id_imagen;
    }

    public function setId_imagen($id_imagen): void {
        $this->id_imagen = $id_imagen;
    }

    
    public function agregar() {
        //$sql = "insert into articulos(codigo, descripcion, precio) values(:cod, :des, :pre);";
        $sql = "INSERT INTO producto (id_negocio, Nombre, Precio, Descripcion, Stock, imagenes_id) VALUES (:neg, :nom, :pre, :descr, :stock, :id_img)";
        $sentencia = $this->dblink->prepare($sql);
        
        $id_negocio = $this->getId_negocio();
        $nombre = $this->getNombre();
        $precio = $this->getPrecio();
        $descripcion = $this->getDescripcion();
        $stock = $this->getStock();
        $id_imagen = $this->getId_imagen();
        
        // $stmt->bindParam(':name', $userName);
        $sentencia->bindParam(":neg", $id_negocio);
        $sentencia->bindParam(":nom", $nombre);
        $sentencia->bindParam(":pre", $precio);
        $sentencia->bindParam(":descr", $descripcion);
        $sentencia->bindParam(":stock", $stock);
        $sentencia->bindParam(":id_img", $id_imagen);
        
        

        // $sentencia->bindParam(":fot", $this->getFoto() );
        $resultado = $sentencia->execute();

        if ($resultado != 1) {
            return FALSE;
        }

        //Insertó correctamente
        return TRUE;
    }
    
    public function productosDeUnNegocio() {
        $sql = "SELECT p.id, p.id_negocio,p.Nombre,p.Precio,p.Descripcion,p.Stock,p.imagenes_id,i.url FROM producto p INNER JOIN imagenes i on p.imagenes_id = i.id WHERE id_negocio = 1 order by Nombre;";
        
        $sentencia = $this->dblink->prepare($sql);

        $id_negocio = $this->getId_negocio();
        $sentencia->bindParam(":id_neg", $id_negocio);

        $sentencia->execute();
        
        return $sentencia->fetchAll(PDO::FETCH_OBJ);
    }
    
    public function actualizarProducto(){
        $sql = "UPDATE IGNORE producto SET Nombre = :nom, Precio = :pre, Descripcion = :descr, Stock = :stock, imagenes_id = :id_img WHERE id = :id_prod";
        $sentencia = $this->dblink->prepare($sql);
        
        $id_producto = $this->getId_producto();
        $nombre = $this->getNombre();
        $precio = $this->getPrecio();
        $descripcion = $this->getDescripcion();
        $stock = $this->getStock();
        $id_imagen = $this->getId_imagen();
        
        if($id_imagen == 0){
            $id_imagen = null;
        }

        $sentencia->bindParam(":id_prod", $id_producto);
        $sentencia->bindParam(":nom", $nombre);
        $sentencia->bindParam(":pre", $precio);
        $sentencia->bindParam(":descr", $descripcion);
        $sentencia->bindParam(":stock", $stock);
        $sentencia->bindParam(":id_img",$id_imagen);
        
        

        // $sentencia->bindParam(":fot", $this->getFoto() );
        $resultado = $sentencia->execute();

        if ($resultado != 1) {
            //ocurrio un error al insertar
            printf('aaa');
            return FALSE;
        }
        
        return TRUE;
       
    }
    
    public function borrarProducto(){
        $sql= "DELETE FROM producto WHERE id = :id_prod";
        $sentencia = $this->dblink->prepare($sql);
        
        $id_producto = $this->getId_producto();
      
        $sentencia->bindParam(":id_prod", $id_producto);
        
        // $sentencia->bindParam(":fot", $this->getFoto() );
        $resultado = $sentencia->execute();

        if ($resultado != 1) {

            return FALSE;
        }
        
        return TRUE;
    }
    
    public function obtenerDatosProducto(){
        $sql = "SELECT * FROM producto WHERE id = :id_prod";
        
        $sentencia = $this->dblink->prepare($sql);

        $id_producto = $this->getId_producto();
        $sentencia->bindParam(":id_prod", $id_producto);

        $sentencia->execute();
        
        return $sentencia->fetchAll(PDO::FETCH_OBJ);
    }
}
