<?php

require_once '../controlador/conexion.php';

/**
 * Description of usuario
 *
 * @author jmcbg
 */
class usuario extends Conexion {

    private $id;
    private $nombre;
    private $dni;
    private $email;
    private $tlf;
    private $rol;
    private $id_direccion;
    private $password;

    public function __construct() {
        
    }

    public function getId() {
        return $this->id;
    }

    public function getNombre() {
        return $this->nombre;
    }

    public function getDni() {
        return $this->dni;
    }

    public function getEmail() {
        return $this->email;
    }

    public function getTlf() {
        return $this->tlf;
    }

    public function getRol() {
        return $this->rol;
    }

    public function getId_direccion() {
        return $this->id_direccion;
    }

    public function getPassword() {
        return $this->password;
    }

    public function setId($id): void {
        $this->id = $id;
    }

    public function setNombre($nombre): void {
        $this->nombre = $nombre;
    }

    public function setDni($dni): void {
        $this->dni = $dni;
    }

    public function setEmail($email): void {
        $this->email = $email;
    }

    public function setTlf($tlf): void {
        $this->tlf = $tlf;
    }

    public function setRol($rol): void {
        $this->rol = $rol;
    }

    public function setId_direccion($id_direccion): void {
        $this->id_direccion = $id_direccion;
    }

    public function setPassword($password): void {
        $this->password = $password;
    }

    public function agregar() {
        //$sql = "insert into articulos(codigo, descripcion, precio) values(:cod, :des, :pre);";
        $sql = "INSERT INTO usuarios (Nombre, Dni, Email, tlf, Rol, id_direccion, password) VALUES (NULL, '', '', '', '', '', '', '')";
        $sentencia = $this->dblink->prepare($sql);
        $codigo = $this->getCodigo();
        $descripcion = $this->getDescripcion();
        $precio = $this->getPrecio();

        // $stmt->bindParam(':name', $userName);
        $sentencia->bindParam(":cod", $codigo);
        $sentencia->bindParam(":des", $descripcion);
        $sentencia->bindParam(":pre", $precio);

        // $sentencia->bindParam(":fot", $this->getFoto() );
        $resultado = $sentencia->execute();

        if ($resultado != 1) {
            //ocurrio un error al insertar
            return FALSE;
        }

        //Insertó correctamente
        return TRUE;
    }

}
