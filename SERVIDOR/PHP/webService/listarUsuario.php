<?php

// $sentencia->bindParam(":nom", $this->getNombre());
//        $sentencia->bindParam(":dni", $this->getDni());
//        $sentencia->bindParam(":email", $this->getEmail());
//        $sentencia->bindParam(":tlf", $this->getTlf());
//        $sentencia->bindParam(":rol", $this->getRol());
//        $sentencia->bindParam(":dir", $this->getId_direccion());
//        $sentencia->bindParam(":pass", $this->getPassword());


require_once '../modelo/usuario.php';
$usuario = new usuario();
$dni = $_POST["dni"];
$email = $_POST["email"];
$dni = $_POST["dni"];
$tlf = $_POST["tlf"];
$rol = $_POST["rol"];
$direccion = $_POST["dir"];
$password = $_POST["pass"];

$objUsuario->setCodigo($codigo);
$resultado = $objUsuario->listarCodigo();
$respuesta = array(
    "codigo" => $resultado
);
echo json_encode($respuesta);
?>
