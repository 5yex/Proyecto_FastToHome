<?php

if (empty($_POST["DATA"])) {
    mandarRespuesta(true, 'error en parametros');
} else {

    $peticion = json_decode($_POST["DATA"]);

    switch ($peticion->comando) {

        case 'nuevo_usuario';
            nuevoUsuario(json_decode($peticion->datos));
            break;
        default;
            mandarRespuesta(true, 'comando no  reconocido');
            break;
    }
}

function nuevoUsuario($datos) {
    require_once '../modelo/usuario.php';
//creamos usuario y los pasamos sus datos al objeto;
    $usuario = new usuario();
    $usuario->setNombre($datos->nombre);
    $usuario->setDni($datos->dni);
    $usuario->setEmail($datos->email);
    $usuario->setId_direccion($datos->id_direccion);
    $usuario->setTlf($datos->tlf);
    $usuario->setRol($datos->rol);
    $usuario->setPassword($datos->password);
//realizamos la accion

    if ($usuario->agregar()) {
        mandarRespuesta(false, 'Se ha realizado la insercion de un usuario');
    } else {
        mandarRespuesta(true, 'Error en el usuario');
    }
}

function mandarRespuesta($error, $datos) {
    require_once '../modelo/Respuesta.php';
    $respuesta = new Respuesta($error, $datos);
    echo json_encode($respuesta);
}
