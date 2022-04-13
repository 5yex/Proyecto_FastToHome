<?php

if (empty($_POST["DATA"])) {
    mandarRespuesta(true, 'error en parametros');
} else {

    $peticion = json_decode($_POST["DATA"]);

    switch ($peticion["comando"]) {
        case 'tuborg';
        case 'carlsberg';
        case 'prueba';
            mandarRespuesta(false, 'todo correcto');
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
