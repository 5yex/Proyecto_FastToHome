<?php

if (empty($_POST["DATA"])) {
    mandarRespuesta(true, 'error en parametros');
} else {
    $peticion = json_decode($_POST["DATA"]);

    switch ($peticion->comando) {
        //Casos de usarios
        case 'obtener_usuarios';
            obtenerTodosLosUsuarios();
            break;
        case 'obtener_usuarios_clientes';
            obtenerUsuariosClientes();
            break;
        case 'obtener_usuarios_admin';
            obtenerUsuariosAdministrador();
            break;
        case 'obtener_usuarios_mercader';
            obtenerUsuariosMercader();
            break;
        case 'getUsuario';
            getUsuario(json_decode($peticion->datos));
            break;
        case 'obtener_usuario_por_su_id';
            obtenerUsuarioPorSuId(json_decode($peticion->datos));
            break;
        case 'nuevo_usuario';
            nuevoUsuario(json_decode($peticion->datos));
            break;
        case 'obtener_id_cliente';
            obtenerIdCliente(json_decode($peticion->datos));
            break;
        case 'getHash';
            getHash(json_decode($peticion->datos));
            break;
        case 'actualizar_usuario';
            actualizarUsuario(json_decode($peticion->datos));
            break;
        case 'asignar_rol_admin';
            asignarRolAdministrador(json_decode($peticion->datos));
            break;
        case 'asignar_rol_mercader';
            asignarRolMercader(json_decode($peticion->datos));
            break;
        case 'asignar_rol_cliente';
            asignarRolCliente(json_decode($peticion->datos));
            break;
        
        
        //Casos de producto
        case 'nuevo_producto';
            nuevoProducto(json_decode($peticion->datos));
            break;
        case 'obtener_productos_negocio';
            obtenerProductosNegocio(json_decode($peticion->datos));
            break;
        case 'obtener_datos_producto';
            obtenerDatosProducto(json_decode($peticion->datos));
            break;
        case 'actualizar_producto';
            actualizarProducto(json_decode($peticion->datos));
            break;
        case 'borrar_producto';
            borrarProducto(json_decode($peticion->datos));
            break;
            
        //Casos dirección
        case 'nueva_direccion';
            nuevaDireccion(json_decode($peticion->datos));
            break;
         case 'nueva_direccion_devuelve_id';
            nuevaDireccionDevuelveId(json_decode($peticion->datos));
            break;
        case 'obtener_direccion';
            obtenerDireccion(json_decode($peticion->datos));
            break;
        case 'actualizar_direccion';
            modificarDireccion(json_decode($peticion->datos));
            break;
            
            
        //Casos negocio
        case 'nuevo_negocio';
            nuevoNegocio(json_decode($peticion->datos));
            break;
        case 'get_id_negocio';
            obtenerIdNegocio(json_decode($peticion->datos));
            break;
        case 'obtener_todos_negocios';
            obtenerTodosNegocios();
            break;
        case 'negocio_de_mercader';
            obtenerNegocioDeMercader(json_decode($peticion->datos));
            break;
        case 'actualizar_negocio';
            actualizarNegocio(json_decode($peticion->datos));
            break;
        
        //Casos de pedidos
        case 'nuevo_pedido';
            hacerPedido(json_decode($peticion->datos));
            break;
        case 'obtener_pedido_unico';
            obtenerPedidoUnico(json_decode($peticion->datos));
            break;
        case 'obtener_pedidos_pagados';
            obtenerPedidosNegocioPagados(json_decode($peticion->datos));
            break;
        case 'obtener_pedidos_en_preparacion';
            obtenerPedidosNegocioEnPreparacion(json_decode($peticion->datos));
            break;
        case 'obtener_todos_pedidos';
            obtenerTodosPedidosNegocios(json_decode($peticion->datos));
            break;
        case 'actualizar_estado_pedido';
            actualizarEstadoPedido(json_decode($peticion->datos));
            break;
        case 'obtener_pedidos_cliente';
            obtenerPedidosCliente(json_decode($peticion->datos));
            break;
        
        //Casos de Categoria
        case 'nueva_categoria';
            nuevaCategoria(json_decode($peticion->datos));
            break;
        case 'obtener_categorias';
            obtenerCategorias();
            break;
        case 'obtener_id_categoria';
            obtenerCategoriaPorNombre(json_decode($peticion->datos));
            break;     
        
        //Casos de cesta
        case 'rellenar_cesta';
            rellenarCesta(json_decode($peticion->datos));
            break;
        case 'contenido_cesta_pedido';
            obtenerCestaPedido(json_decode($peticion->datos));
            break;
        
        //imagenes
        case 'nueva_imagen';
            nuevaImagen(json_decode($peticion->datos));
            break;
        case 'obtener_imagen_id';
            obtenerImagenPorId(json_decode($peticion->datos));
            break;
        case 'editar_imagen_id';
            editarImagenPorId(json_decode($peticion->datos));
            break;
        
        //Mandar Repuesta
        default;
            mandarRespuesta(true, 'comando no  reconocido');
            break;
    }
}

function nuevoUsuario($datos) {
    require_once '../modelo/usuario.php';
    try {
        $usuario = new usuario();
        $usuario->setNombre($datos->nombre);
        $usuario->setApellidos($datos->apellidos);
        $usuario->setDni($datos->dni);
        $usuario->setEmail($datos->email);
        $usuario->setId_direccion($datos->id_direccion);
        $usuario->setTlf($datos->tlf);
        $usuario->setRol($datos->rol);
        $usuario->setPassword($datos->password);

        if ($usuario->agregar()) {
            mandarRespuesta(false, 'Se ha realizado la insercion de un usuario');
        } else {
            mandarRespuesta(true, 'Error en el usuario');
        }
    } catch (PDOException $ex) {
        mandarRespuesta(true, $ex->getMessage());
    }
}

function nuevoProducto($datos) {
    require_once '../modelo/Producto.php';
    try {
        $producto = new Producto();
        $producto->setId_negocio($datos->id_negocio);
        $producto->setNombre($datos->nombre);
        $producto->setPrecio($datos->precio);
        $producto->setDescripcion($datos->descripcion);
        $producto->setStock($datos->stock);
        $producto->setId_imagen($datos->id_img);

        if ($producto->agregar()) {
            mandarRespuesta(false, 'Se ha realizado la insercion de un producto');
        } else {
            mandarRespuesta(true, 'Error en la inserccion del producto');
        }
    } catch (PDOException $ex) {
        mandarRespuesta(true, $ex->getMessage());
    }
}

function actualizarProducto($datos){
    require_once '../modelo/Producto.php';
    try {
        $producto = new Producto();
        $producto->setId_producto($datos->id_producto);
        $producto->setId_negocio($datos->id_negocio);
        $producto->setNombre($datos->nombre);
        $producto->setPrecio($datos->precio);
        $producto->setDescripcion($datos->descripcion);
        $producto->setStock($datos->stock);
        $producto->setId_imagen($datos->id_img);

        if ($producto->actualizarProducto()) {
            mandarRespuesta(false, 'Se ha realizado la actualización de un producto');
        } else {
            mandarRespuesta(true, 'Error en la actualización del producto');
        }
    } catch (PDOException $ex) {
        mandarRespuesta(true, $ex->getMessage());
    }
}

function borrarProducto($datos){
    require_once '../modelo/Producto.php';
    try {
        $producto = new Producto();
        $producto->setId_producto($datos->id_producto);

        if ($producto->borrarProducto()) {
            mandarRespuesta(false, 'Se ha realizado borrado el producto');
        } else {
            mandarRespuesta(true, 'Error en el borrado del producto');
        }
    } catch (PDOException $ex) {
        mandarRespuesta(true, $ex->getMessage());
    }
}


function nuevaDireccionDevuelveId($datos) {
    require_once '../modelo/Direccion.php';
    try {
        $direccion = new Direccion();
        $direccion->setCalle($datos->calle);
        $direccion->setNumero($datos->numero);
        $direccion->setCiudad($datos->ciudad);
        $direccion->setCodigo_postal($datos->codigo_postal);
        $direccion->setOtros($datos->otros);
        $direccion->setCoordenadas($datos->coordenadas);

        $respuesta = $direccion->agregarConId();
        
        if ($respuesta) {
            mandarRespuesta(false, $respuesta);
        } else {
            mandarRespuesta(true, 'Error fatal en el proceso obtencion de datos');
        } 
    } catch (PDOException $ex) {
        mandarRespuesta(true, $ex->getMessage());
    }
}


function nuevaDireccion($datos) {
    require_once '../modelo/Direccion.php';
    try {
        $direccion = new Direccion();
        $direccion->setCalle($datos->calle);
        $direccion->setNumero($datos->numero);
        $direccion->setCiudad($datos->ciudad);
        $direccion->setCodigo_postal($datos->codigo_postal);
        $direccion->setOtros($datos->otros);
        $direccion->setCoordenadas($datos->coordenadas);

        if ($direccion->agregar()) {
            mandarRespuesta(false, 'Se ha realizado la insercion de una direccion');
        } else {
            mandarRespuesta(true, 'Error en la inserccion de la direccion');
        }
    } catch (PDOException $ex) {
        mandarRespuesta(true, $ex->getMessage());
    }
}

function obtenerDireccion($datos){
    require_once '../modelo/Direccion.php';
    try {
        $direccion = new Direccion();
        $direccion->setId_direccion($datos->id_direccion);

        $respuesta = $direccion->obtenerDireccionPorId();
        if ($respuesta) {
            mandarRespuesta(false, $respuesta);
        } else {
            mandarRespuesta(true, 'Error en obtener la dirección');
        }
    } catch (PDOException $ex) {
        mandarRespuesta(true, $ex->getMessage());
    }
}

function modificarDireccion($datos){
    require_once '../modelo/Direccion.php';
    try {
        $direccion = new Direccion();
        $direccion->setId_direccion($datos->id_direccion);
        $direccion->setCalle($datos->calle);
        $direccion->setNumero($datos->numero);
        $direccion->setCiudad($datos->ciudad);
        $direccion->setCodigo_postal($datos->codigo_postal);
        $direccion->setOtros($datos->otros);
        $direccion->setCoordenadas($datos->coordenadas);

        if ($direccion->actualizarDireccion()) {
            mandarRespuesta(false, 'Se ha realizado actualización de una dirección');
        } else {
            mandarRespuesta(true, 'Error en la actualización de la dirección');
        }
    } catch (PDOException $ex) {
        mandarRespuesta(true, $ex->getMessage());
    }
}

function nuevoNegocio($datos){
    require_once '../modelo/Negocio.php';
    try {
        $negocio = new Negocio();
        $negocio->setId_categoria($datos->id_categoria);
        $negocio->setId_mercader($datos->id_mercader);
        $negocio->setNombre($datos->nombre);
        $negocio->setDescripcion($datos->descripcion);
        $negocio->setId_direccion($datos->id_direccion);
        $negocio->setId_imagen($datos->id_img);
        
        if ($negocio->agregar()) {
            mandarRespuesta(false, 'Se ha realizado la insercion de un negocio');
        } else {
            mandarRespuesta(true, 'Error en la inserccion de un negocio');
        }
    } catch (PDOException $ex) {
        mandarRespuesta(true, $ex->getMessage());
    }
}

function obtenerTodosNegocios(){
    require_once '../modelo/Negocio.php';
    try {
        $negocio = new Negocio();
        $respuesta = $negocio->obtenerTodosNegocios();
        if ($respuesta) {
            mandarRespuesta(false, $respuesta);
        } else {
            mandarRespuesta(true, 'Error fatal en el proceso obtencion de datos');
        }
    } catch (PDOException $ex) {
        mandarRespuesta(true, $ex->getMessage());
    }
}

function obtenerIdNegocio($datos) {
    require_once '../modelo/Negocio.php';
    try {
        $negocio = new Negocio();
        $negocio->setNombre($datos->nombre);
        $respuesta = $negocio->obtenerIdNegocio();
        if ($respuesta) {
            mandarRespuesta(false, $respuesta);
        } else {
            mandarRespuesta(true, 'Error en obtener el id del negocio');
        }
    } catch (PDOException $ex) {
        mandarRespuesta(true, $ex->getMessage());
    }
}


function obtenerNegocioDeMercader($datos) {
    require_once '../modelo/Negocio.php';
    try {
        $negocio = new Negocio();
        $negocio->setId_mercader($datos->id);
        $respuesta = $negocio->obtenerNegocioDeMercader();
        if ($respuesta) {
            mandarRespuesta(false, $respuesta);
        } else {
            mandarRespuesta(true, 'El mercader no tiene negocio');
        }
    } catch (PDOException $ex) {
        mandarRespuesta(true, $ex->getMessage());
    }
}

function actualizarNegocio($datos){
    require_once '../modelo/Negocio.php';
    try {
        $negocio = new Negocio();
        $negocio->setId_categoria($datos->id_categoria);
        $negocio->setNombre($datos->nombre);
        $negocio->setDescripcion($datos->descripcion);
        $negocio->setId_negocio($datos->id_negocio);
        $negocio->setId_imagen($datos->id_img);

        
        if ($negocio->modificarNegocio()) {
            mandarRespuesta(false, 'Se actualizó el negocio');
        } else {
            mandarRespuesta(true, 'No se actualizó el negocio');
        }
    } catch (PDOException $ex) {
        mandarRespuesta(true, $ex->getMessage());
    }
}

function obtenerProductosNegocio($datos){
    require_once '../modelo/Producto.php';
    require_once '../modelo/Negocio.php';

    try {
        $producto = new Producto();
        $id = $datos->id_negocio;
        $producto->setId_negocio($id);
        $respuesta = $producto->productosDeUnNegocio();       
        if ($respuesta) {
            mandarRespuesta(false, $respuesta);
        } else {
            mandarRespuesta(true, 'Error en la obtencion de los productos del negocio');
        }
    } catch (PDOException $ex) {
        mandarRespuesta(true, $ex->getMessage());
    }
}

function obtenerDatosProducto($datos){
    require_once '../modelo/Producto.php';
    
    try {
        $producto = new Producto();
        $producto->setId_producto($datos->id_producto);
        $respuesta = $producto->obtenerDatosProducto();       
        if ($respuesta) {
            mandarRespuesta(false, $respuesta);
        } else {
            mandarRespuesta(true, 'Error en la obtencion de los datos de un producto');
        }
    } catch (PDOException $ex) {
        mandarRespuesta(true, $ex->getMessage());
    }
}

function obtenerIdCliente($datos) {
    require_once '../modelo/usuario.php';
    try {
        $cliente = new usuario();
        $cliente->setDni($datos->dni);
        $respuesta = $cliente->obtenerIdCliente();
        if ($respuesta) {
            mandarRespuesta(false, $respuesta);
        } else {
            mandarRespuesta(true, 'Error en obtener el id del cliente');
        }
    } catch (PDOException $ex) {
        mandarRespuesta(true, $ex->getMessage());
    }
}

function getHash($datos) {
    require_once '../modelo/usuario.php';
    try {
        $cliente = new usuario();
        $cliente->setEmail($datos->email);
        $respuesta = $cliente->getHash();
        if ($respuesta) {
            mandarRespuesta(false, $respuesta);
        } else {
            mandarRespuesta(true, 'El usuario introducido no existe');
        }
    } catch (PDOException $ex) {
        mandarRespuesta(true, $ex->getMessage());
    }
}

function actualizarUsuario($datos) {
    require_once '../modelo/usuario.php';
    try {
        $usuario = new usuario();
        $usuario->setNombre($datos->nombre);
        $usuario->setApellidos($datos->apellidos);
        $usuario->setDni($datos->dni);
        $usuario->setEmail($datos->email);
        $usuario->setId($datos->id);
        $usuario->setTlf($datos->tlf);
        //$usuario->setRol($datos->rol);
        $usuario->setPassword($datos->password);

        if ($usuario->actualizarUsuario()) {
            mandarRespuesta(false, 'Se ha realizado la actualizacion de un usuario');
        } else {
            mandarRespuesta(true, 'Error al actualizar el usuario');
        }
    } catch (PDOException $ex) {
        mandarRespuesta(true, $ex->getMessage());
    }
}

function asignarRolMercader($datos){
    require_once '../modelo/usuario.php';
    try {
        $usuario = new usuario();
        
        $usuario->setId($datos->id);
        
        if ($usuario->asignarRolMerdader()) {
            mandarRespuesta(false, 'Se ha asignado el rol de mercader a un cliente');
        } else {
            mandarRespuesta(true, 'Error al asignar el rol de mercader');
        }
    } catch (PDOException $ex) {
        mandarRespuesta(true, $ex->getMessage());
    }
}

function asignarRolCliente($datos){
    require_once '../modelo/usuario.php';
    try {
        $usuario = new usuario();
        $usuario->setId($datos->id);
        if ($usuario->asignarRolCliente()) {
            mandarRespuesta(false, 'Se ha asignado el rol de CLiente a un a un usuario de mayor rango');
        } else {
            mandarRespuesta(true, 'Error al asignar el rol de mercader');
        }
    } catch (PDOException $ex) {
        mandarRespuesta(true, $ex->getMessage());
    }
}

function asignarRolAdministrador($datos){
    require_once '../modelo/usuario.php';
    try {
        $usuario = new usuario();
        
        $usuario->setId($datos->id);
        
        if ($usuario->asignarRolAdministrador()) {
            mandarRespuesta(false, 'Se ha asignado el rol de administrador a un cliente');
        } else {
            mandarRespuesta(true, 'Error al asignar el rol de administrador');
        }
    } catch (PDOException $ex) {
        mandarRespuesta(true, $ex->getMessage());
    }
}

function getUsuario($datos) {
    require_once '../modelo/usuario.php';
    try {
        $cliente = new usuario();
        $cliente->setId($datos->id);
        $cliente->setPassword($datos->password);
        $respuesta = $cliente->usuarioCompleto();
        if ($respuesta) {
            mandarRespuesta(false, $respuesta);
        } else {
            mandarRespuesta(true, 'Error fatal en el proceso obtencion de datos');
        }
    } catch (PDOException $ex) {
        mandarRespuesta(true, $ex->getMessage());
    }
}

function obtenerUsuarioPorSuId($datos) {
    require_once '../modelo/usuario.php';
    try {
        $cliente = new usuario();
        $cliente->setId($datos->id);
        $respuesta = $cliente->usuarioPorSuId();
        if ($respuesta) {
            mandarRespuesta(false, $respuesta);
        } else {
            mandarRespuesta(true, 'Error fatal en el proceso obtencion de datos');
        }
    } catch (PDOException $ex) {
        mandarRespuesta(true, $ex->getMessage());
    }
}

function obtenerTodosLosUsuarios(){
    require_once '../modelo/usuario.php';
    
    try {
        $cliente = new usuario();
        $respuesta = $cliente->todosLosUsuarios();
        if ($respuesta) {
            mandarRespuesta(false, $respuesta);
        } else {
            mandarRespuesta(true, 'Error fatal en el proceso obtencion de datos');
        }
    } catch (PDOException $ex) {
        mandarRespuesta(true, $ex->getMessage());
    }
}

function obtenerUsuariosClientes(){
    require_once '../modelo/usuario.php';
    
    try {
        $cliente = new usuario();
        $respuesta = $cliente->todosUsuariosClientes();
        if ($respuesta) {
            mandarRespuesta(false, $respuesta);
        } else {
            mandarRespuesta(true, 'Error fatal en el proceso obtencion de datos');
        }
    } catch (PDOException $ex) {
        mandarRespuesta(true, $ex->getMessage());
    }
}


function obtenerUsuariosAdministrador(){
    require_once '../modelo/usuario.php';
    
    try {
        $cliente = new usuario();
        $respuesta = $cliente->todosUsuariosAdministrador();
        if ($respuesta) {
            mandarRespuesta(false, $respuesta);
        } else {
            mandarRespuesta(true, 'Error fatal en el proceso obtencion de datos');
        }
    } catch (PDOException $ex) {
        mandarRespuesta(true, $ex->getMessage());
    }
}


function obtenerUsuariosMercader(){
    require_once '../modelo/usuario.php';
    
    try {
        $cliente = new usuario();
        $respuesta = $cliente->todosUsuariosMercader();
        if ($respuesta) {
            mandarRespuesta(false, $respuesta);
        } else {
            mandarRespuesta(true, 'Error fatal en el proceso obtencion de datos');
        }
    } catch (PDOException $ex) {
        mandarRespuesta(true, $ex->getMessage());
    }
}

function hacerPedido($datos){
    require_once '../modelo/Pedido.php';
    require_once '../modelo/Cesta.php';
    
    try{
        $dPedido = $datos[0];
        $pedido = new Pedido();
        $pedido->setEstado($dPedido->estado);
        $pedido->setId_usuario($dPedido->id_usuario);
        $pedido->setId_negocio($dPedido->id_negocio);
        $pedido->setFecha_hora((new DateTime())->format('Y-m-d H:i:s'));
        $pedido->setTotal($dPedido->total);
        $pedido->setTransporte($dPedido->transporte);
        $id_pedido = $pedido->agregarConId()[0]->last_id;
        $producto = new Cesta();
        $producto->setId_pedido($id_pedido);
        foreach ($datos[1]as $value) {
            $producto->setCantidad($value->cantidad);
            $producto->setId_producto($value->id_producto);
            $producto->agregar();
        }
        $pedido->setId_pedido($id_pedido);
        $pedido->setEstado("pagado");
        $pedido->actualizacionEstadoPedido();
        mandarRespuesta(false, 'Se realizó un pedido con exito');
    }catch (PDOException $ex) {
        mandarRespuesta(true, $ex->getMessage());
    }
    
}

function obtenerPedidoUnico($datos){
    require_once '../modelo/Pedido.php';
    
    try{
        $pedido = new Pedido();
        $pedido->setId_pedido($datos->id_pedido);
        $respuesta = $pedido->obtenerPedido();
        if ($respuesta) {
            mandarRespuesta(false, $respuesta);
        } else {
            mandarRespuesta(true, 'Error fatal en el proceso obtencion de datos');
        }        
    }catch (PDOException $ex) {
        mandarRespuesta(true, $ex->getMessage());
    }
}

function obtenerPedidosNegocioPagados($datos){
    require_once '../modelo/Pedido.php';
    
    try{
        $pedido = new Pedido();
        $pedido->setId_negocio($datos->id_negocio);
        $respuesta = $pedido->obtenerPedidosNegocioPagado();
        if ($respuesta) {
            mandarRespuesta(false, $respuesta);
        } else {
            mandarRespuesta(true, 'Error fatal en el proceso obtencion de datos');
        }        
    }catch (PDOException $ex) {
        mandarRespuesta(true, $ex->getMessage());
    }
}

function obtenerPedidosNegocioEnPreparacion($datos){
    require_once '../modelo/Pedido.php';
    
    try{
        $pedido = new Pedido();
        $pedido->setId_negocio($datos->id_negocio);
        $respuesta = $pedido->obtenerPedidosNegocioEnPreparacion();
        if ($respuesta) {
            mandarRespuesta(false, $respuesta);
        } else {
            mandarRespuesta(true, 'Error fatal en el proceso obtencion de datos');
        }        
    }catch (PDOException $ex) {
        mandarRespuesta(true, $ex->getMessage());
    }
}

function obtenerTodosPedidosNegocios($datos){
    require_once '../modelo/Pedido.php';
    
    try{
        $pedido = new Pedido();
        $pedido->setId_negocio($datos->id_negocio);
        $respuesta = $pedido->obtenerTodosPedidosNegocio();
        if ($respuesta) {
            mandarRespuesta(false, $respuesta);
        } else {
            mandarRespuesta(true, 'Error fatal en el proceso obtencion de datos');
        }        
    }catch (PDOException $ex) {
        mandarRespuesta(true, $ex->getMessage());
    }
}

function obtenerPedidosCliente($datos){
    require_once '../modelo/Pedido.php';
    
    try{
        $pedido = new Pedido();
        $pedido->setId_usuario($datos->id_usuario);
        $respuesta = $pedido->obtenerPedidosClientes();
        if ($respuesta) {
            mandarRespuesta(false, $respuesta);
        } else {
            mandarRespuesta(true, 'Error fatal en el proceso obtencion de datos');
        }        
    }catch (PDOException $ex) {
        mandarRespuesta(true, $ex->getMessage());
    }
}

function actualizarEstadoPedido($datos){
    require_once '../modelo/Pedido.php';
    
    try{
        $pedido = new Pedido();
        $pedido->setId_pedido($datos->id_pedido);
        $pedido->setEstado($datos->estado);
        
        if ($pedido->actualizacionEstadoPedido()) {
            mandarRespuesta(false, "Se actualizó el estado del pedido");
        } else {
            mandarRespuesta(true, 'Error en la actualización del estado del pedido');
        }        
    }catch (PDOException $ex) {
        mandarRespuesta(true, $ex->getMessage());
    }
}

function mandarRespuesta($error, $datos) {
    require_once '../modelo/Respuesta.php';
    $respuesta = new Respuesta($error, $datos);
    echo json_encode($respuesta);
}




function nuevaCategoria($datos){
    require_once '../modelo/Categoria.php';
    try {
        $categoria = new Categoria();
        $categoria->setNombre($datos->nombre);

        if ($categoria->agregar()) {
            mandarRespuesta(false, 'Se ha realizado la insercion de una categoria');
        } else {
            mandarRespuesta(true, 'Error en la inserccion de la categoria');
        }
    } catch (PDOException $ex) {
        mandarRespuesta(true, $ex->getMessage());
    }
    
}


function obtenerCategorias(){
    require_once '../modelo/Categoria.php';
    
    try {
        $categoria = new Categoria();
        $respuesta = $categoria->obtenerCategorias();
        if ($respuesta) {
            mandarRespuesta(false, $respuesta);
        } else {
            mandarRespuesta(true, 'Error fatal en el proceso obtencion de datos');
        }
    } catch (PDOException $ex) {
        mandarRespuesta(true, $ex->getMessage());
    }

}

function obtenerCategoriaPorNombre($datos){
    require_once '../modelo/Categoria.php';
    try {
        $categoria = new Categoria();
        $categoria->setNombre($datos->nombre);
        $respuesta = $categoria->obtenerIdCategoria();
        if ($respuesta) {
            mandarRespuesta(false, $respuesta);
        } else {
            mandarRespuesta(true, 'Error fatal en el proceso obtencion de datos');
        }
    } catch (PDOException $ex) {
        mandarRespuesta(true, $ex->getMessage());
    }
}

function nuevaImagen($datos){
    require_once '../modelo/Imagen.php';
    try {
        $imagen = new Imagen();
        $imagen->setB64_imagen($datos->b64_imagen);
        $imagen->setUrl_imagen($datos->url_imagen);
        $respuesta = $imagen->agregarConId();
        
        if ($respuesta) {
            mandarRespuesta(false, $respuesta);
        } else {
            mandarRespuesta(true, 'Error fatal en el proceso obtencion de datos');
        } 
        
    } catch (PDOException $ex) {
        mandarRespuesta(true, $ex->getMessage());
    }
}

function obtenerImagenPorId($datos){
    require_once '../modelo/Imagen.php';
    try {
        $imagen = new Imagen();
        $imagen->setId_imagen($datos->id);
        $respuesta = $imagen->obtenerImagenPorId();
        if ($respuesta) {
            mandarRespuesta(false, $respuesta);
        } else {
            mandarRespuesta(true, 'Error en obtener la Imagen');
        }
    } catch (PDOException $ex) {
        mandarRespuesta(true, $ex->getMessage());
    }
    
    
}


function editarImagenPorId($datos){
    require_once '../modelo/Imagen.php';
    try {
        $imagen = new Imagen();
        $imagen->setId_imagen($datos->id);
        $imagen->setB64_imagen($datos->b64_imagen);
        $respuesta = $imagen->editarImagenPorId();
        if ($respuesta) {
            mandarRespuesta(false, $respuesta);
        } else {
            mandarRespuesta(true, 'Error en editar la Imagen');
        }
    } catch (PDOException $ex) {
        mandarRespuesta(true, $ex->getMessage());
    }
    
    
}

function rellenarCesta($datos){
    require_once '../modelo/Cesta.php';
    try {
        $cesta = new Cesta();
        $cesta->setCantidad($cantidad);
        $cesta->setId_pedido($id_pedido);
        $cesta->setId_producto($id_producto);
        
        if ($cesta->agregar()) {
            mandarRespuesta(false, 'Se rellenó la cesta');
        } else {
            mandarRespuesta(true, 'Error al rellenar la cesta');
        }
        
    } catch (PDOException $ex) {
        mandarRespuesta(true, $ex->getMessage());
    }
}

function obtenerCestaPedido($datos){
    require_once '../modelo/Cesta.php';
    
    try {
        $cesta = new Cesta();
        $cesta->setId_pedido($datos->id_pedido);
        
        $respuesta = $cesta->obtenerCestaPedido();
        if ($respuesta) {
            mandarRespuesta(false, $respuesta);
        } else {
            mandarRespuesta(true, 'Error en obtener la cesta del pedido');
        }
        
    } catch (PDOException $ex) {
        mandarRespuesta(true, $ex->getMessage());
    }
}