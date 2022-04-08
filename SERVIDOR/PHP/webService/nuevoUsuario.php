<?php

// $sentencia->bindParam(":nom", $this->getNombre());
//        $sentencia->bindParam(":dni", $this->getDni());
//        $sentencia->bindParam(":email", $this->getEmail());
//        $sentencia->bindParam(":tlf", $this->getTlf());
//        $sentencia->bindParam(":rol", $this->getRol());
//        $sentencia->bindParam(":dir", $this->getId_direccion());
//        $sentencia->bindParam(":pass", $this->getPassword());


require_once '../modelo/usuario.php';

//obtenemos parametro
$nombre = $_POST["nom"];
$dni = $_POST["dni"];
$email = $_POST["email"];
$tlf = $_POST["tlf"];
$rol = $_POST["rol"];
$id_direccion = $_POST["dir"];
$password = $_POST["pass"];

//creamos usuario y los pasamos sus datos al objeto;
$usuario = new usuario();
$usuario->setNombre($nombre);
$usuario->setDni($dni);
$usuario->setEmail($email);
$usuario->setId_direccion($id_direccion);
$usuario->setTlf($tlf);
$usuario->setRol($rol);
$usuario->setPassword($password);
//realizamos la accion
$resultado = $usuario->agregar();

//generamos la respuesta en json
$respuesta = array(
    "codigo" => $resultado
);
echo json_encode($respuesta);
?>
