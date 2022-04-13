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
    $datos = json_decode($datos);
    require_once '../modelo/usuario.php';
//creamos usuario y los pasamos sus datos al objeto;
    $usuario = new usuario();
    $usuario->setNombre($nombre);
    $usuario->setDni($dni);
    $usuario->setEmail($email);
    $usuario->setId_direccion($id_direccion);
    $usuario->setTlf($tlf);
    $usuario->setRol($rol);
    $usuario->setPassword($password);
//realizamos la accion
    $resultado = $usuario->agregar();
}

function mandarRespuesta($error, $datos) {
    require_once '../modelo/Respuesta.php';
    $respuesta = new Respuesta($error, $datos);
    echo json_encode($respuesta);
}
