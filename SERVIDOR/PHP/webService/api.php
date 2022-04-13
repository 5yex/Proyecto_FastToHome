<?php

if (empty($_POST["DATA"])) {
    mandarRespuesta(true, 'error en parametros');
} else {

    $peticion = json_decode($_POST["DATA"]);

    switch ($peticion->comando) {
     
        case 'nuevo_usuario';
            nuevoUsuario();
            break;
        default;
            mandarRespuesta(true, 'comando no  reconocido');

            break;
    }
}

function mandarRespuesta($error, $datos) {
    require_once '../modelo/Respuesta.php';
    $respuesta = new Respuesta($error, $datos);
    echo json_encode($respuesta);
}


function nuevoUsuario($parametros){
    
}
