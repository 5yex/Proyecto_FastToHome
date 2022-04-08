<?php
    require_once '../modelo/Producto.php';
    $objUsuario = new Articulo();
    $codigo= $_POST["codigo"];
    $objUsuario->setCodigo($codigo);
    $resultado = $objUsuario->listarCodigo();
    $respuesta = array(
        "codigo"=>$resultado
    );
    echo json_encode($respuesta);   
?>
