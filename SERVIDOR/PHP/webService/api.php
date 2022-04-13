<?php

require_once '../modelo/Respuesta.php';

if (empty($_POST["DATA"])) {
    $error = true;
    $datos = "llamada a api malformada";
    $respuesta = new Respuesta($error, $datos);
    echo json_encode($respuesta);
} else {
   
}