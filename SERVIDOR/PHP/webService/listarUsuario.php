<?php
    require_once '../modelo/usuario.php';
    $objUsuario = new ;
    //$codigo= $_POST["codigo"];
    $objUsuario->setCodigo($codigo);
    $resultado = $objUsuario->listarCodigo();
    $respuesta = array(
        "codigo"=>$resultado
    );
    echo json_encode($respuesta);   
?>
