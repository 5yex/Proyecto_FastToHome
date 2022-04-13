<?php

require_once '../modelo/Respuesta.php';

if (empty($_POST["DATA"])) {
    $error = true;
    $datos = "llamada a api malformada";
    $respuesta = new Respuesta();
    echo json_encode($respuesta);
} else {
   
}