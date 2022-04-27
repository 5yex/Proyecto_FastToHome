<?php

if (empty($_POST["DATA"])) {
    mandarRespuesta(true, 'error en parametros');
} else {
    $peticion = json_decode($_POST["DATA"]);

    switch ($peticion->comando) {

        case 'nuevo_usuario';
            nuevoUsuario(json_decode($peticion->datos));
            break;
        case 'nuevo_producto';
            nuevoProducto(json_decode($peticion->datos));
            break;
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
        mandarRespuesta(true, 'sql error');
    }
}

function nuevoProducto($datos){
    require_once '../modelo/Producto.php';
    try{
        $producto = new Producto();
        $producto->setId_negocio($datos->id_negocio);
        $producto->setNombre($datos->nombre);
        $producto->setPrecio($datos->precio);
        $producto->setDescripcion($datos->descripcion);
        $producto->setStock($datos->stock);
        
        if($producto->agregar()){
            mandarRespuesta(false, 'Se ha realizado la insercion de un producto');
        } else {
            mandarRespuesta(true, 'Error en la inserccion del producto');
        }
    }catch (PDOException $ex) {
        mandarRespuesta(true, 'sql error');
    }
}

function nuevaDireccion($datos){
    require_once '../modelo/Direccion.php';
    try{
        $direccion = new Producto();
        $direccion->setId_negocio($datos->id_negocio);
        $direccion->setNombre($datos->nombre);
        $direccion->setPrecio($datos->precio);
        $direccion->setDescripcion($datos->descripcion);
        $direccion->setStock($datos->stock);
        
        if($direccion->agregar()){
            mandarRespuesta(false, 'Se ha realizado la insercion de un producto');
        } else {
            mandarRespuesta(true, 'Error en la inserccion del producto');
        }
    }catch (PDOException $ex) {
        mandarRespuesta(true, 'sql error');
    }
}

function mandarRespuesta($error, $datos) {
    require_once '../modelo/Respuesta.php';
    $respuesta = new Respuesta($error, $datos);
    echo json_encode($respuesta);
}
