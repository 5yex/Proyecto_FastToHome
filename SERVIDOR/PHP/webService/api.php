<?php

if (empty($_POST["DATA"])) {
    mandarRespuesta(true, 'error en parametros');
    echo($json);
} else {
    switch ($_POST["DATA"]) {
        case 'tuborg';
        case 'carlsberg';
        case 'heineken';
            echo 'Good choice';
            break;
        default;
            echo 'Please make a new selection...';
            break;
    }
}

function mandarRespuesta($error, $datos) {
    require_once '../modelo/Respuesta.php';
    $respuesta = new Respuesta($error, $datos);
    $json = json_encode($respuesta);
}
