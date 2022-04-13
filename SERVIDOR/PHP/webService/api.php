<?php

if (empty($_POST["DATA"])) {
    mandarRespuesta(true, 'error en parametros');
   
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
    echo json_encode($respuesta);
     
}
