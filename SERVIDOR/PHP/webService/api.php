<?php

if (empty($_POST["DATA"])) {
    mandarRespuesta(true, 'error en parametros');
} else {
    $peticion = json_decode($_POST["DATA"]);

    switch ($peticion->comando) {
        //Casos de usarios
        case 'obtener_usuarios';
            obtenerTodosLosUsuarios(json_decode($peticion->datos));
            break;
        case 'obtener_usuarios_clientes';
            obtenerUsuariosClientes(json_decode($peticion->datos));
            break;
        case 'getUsuario';
            getUsuario(json_decode($peticion->datos));
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
        //Casos de producto
        case 'nuevo_producto';
            nuevoProducto(json_decode($peticion->datos));
            break;
        //Casos dirección
        case 'nueva_direccion';
            nuevaDireccion(json_decode($peticion->datos));
            break;
        //Casos negocio
        case 'get_id_negocio';
            obtenerIdNegocio(json_decode($peticion->datos));
            break;
        case 'obtener_productos_negocio';
            obtenerProductosNegocio($peticion->datos);
            break;
        case 'negocio_de_mercader';
            obtenerNegocioDeMercader(json_decode($peticion->datos));
            break;
        case 'obtener_pedidos_pagados';
            obtenerPedidosNegocioPagados(json_decode($peticion->datos));
            break;
        case 'obtener_pedidos_en_preparacion';
            obtenerPedidosNegocioEnPreparacion(json_decode($peticion->datos));
            break;
        case 'obtener_categorias';
            obtenerCategorias(json_decode($datos->datos));
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
        $usuario->setApellidos($datos->apellidos);
        $usuario->setDni($datos->dni);
        $usuario->setEmail($datos->email);
        //$usuario->setId_direccion($datos->id_direccion);
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

        if ($producto->agregar()) {
            mandarRespuesta(false, 'Se ha realizado la insercion de un producto');
        } else {
            mandarRespuesta(true, 'Error en la inserccion del producto');
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
        $direccion->setProvincia($datos->provincia);
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

function obtenerProductosNegocio($datos){
    require_once '../modelo/Producto.php';
    try {
        $producto = new Producto();
        $producto->setId_negocio($datos->id_negocio);
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
        //$usuario->setId_direccion($datos->id_direccion);
        $usuario->setTlf($datos->tlf);
        $usuario->setRol($datos->rol);
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

function obtenerTodosLosUsuarios($datos){
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

function obtenerUsuariosClientes($datos){
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

function obtenerPedidosNegocioPagados($datos){
    require_once '../modelo/Pedido.php';
    
    try{
        $pedido = new Pedido();
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

function mandarRespuesta($error, $datos) {
    require_once '../modelo/Respuesta.php';
    $respuesta = new Respuesta($error, $datos);
    echo json_encode($respuesta);
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