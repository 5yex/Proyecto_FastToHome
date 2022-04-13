<?php

require_once '../modelo/Respuesta.php';

if (empty($_POST["DATA"])) {
    $respuesta = new Respuesta();
    $respuesta ->setError(true);
    $respuesta ->setDatos('llamada a api malformada');
    
    
    $json = json_encode($respuesta);
    print_r($json);
} else {
   
}