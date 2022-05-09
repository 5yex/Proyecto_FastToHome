<?php

require_once '../controlador/conexion.php';

/**
 * Description of usuario
 *
 * @author jmcbg
 */
class usuario extends conexion {

    private $id;
    private $nombre;
    private $dni;
    private $email;
    private $tlf;
    private $rol;
    private $id_direccion;
    private $password;

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

        $sql = "INSERT INTO usuarios (Nombre, apellidos, Dni, Email, tlf, Rol, direccion_id, password) VALUES (:nom, :apellidos,:dni, :email, :tlf, :rol, :dir, :pass)";

        $sentencia = $this->dblink->prepare($sql);

        // $stmt->bindParam(':name', $userName);
        $nombre = $this->getNombre();
        $dni = $this->getDni();
        $email = $this->getEmail();
        $tlf = $this->getTlf();
        $rol = $this->getRol();
        $id_direccion = $this->getId_direccion();
        $password = $this->getPassword();

        $sentencia->bindParam(":nom", $nombre);
        $sentencia->bindParam(":dni", $dni);
        $sentencia->bindParam(":email", $email);
        $sentencia->bindParam(":tlf", $tlf);
        $sentencia->bindParam(":rol", $rol);
        $sentencia->bindParam(":dir", $id_direccion);
        $sentencia->bindParam(":pass", $password);

        // $sentencia->bindParam(":fot", $this->getFoto() );
        $resultado = $sentencia->execute();

        if ($resultado != 1) {
            //ocurrio un error al insertar
            printf('aaa');
            return FALSE;
        }

        //Insertó correctamente
        return TRUE;
    }

    public function obtenerIdMercader() {

        $sql = "SELECT id FROM usuarios where Dni like :dni AND rol = 'mercader'";

        $sentencia = $this->dblink->prepare($sql);

        $dni = $this->getDni();

        $sentencia->bindParam(":dni", $dni);

        $sentencia->execute();
        return $sentencia->fetchAll(PDO::FETCH_OBJ);
    }

    public function obtenerIdCliente() {

        $sql = "SELECT id FROM usuarios where Dni like :dni AND rol = 'cliente'";

        $sentencia = $this->dblink->prepare($sql);

        $dni = $this->getDni();

        $sentencia->bindParam(":dni", $dni);

        $sentencia->execute();
        return $sentencia->fetchAll(PDO::FETCH_OBJ);
    }

    public function getHash() {
        $sql = "SELECT password,id FROM usuarios where Email like :email";

        $sentencia = $this->dblink->prepare($sql);

        $email = $this->getEmail();

        $sentencia->bindParam(":email", $email);

        $sentencia->execute();
        return $sentencia->fetchAll(PDO::FETCH_OBJ);
    }

    public function usuarioCompleto() {
        $sql = "SELECT * FROM usuarios where id like :id and password like :pass ";

        $sentencia = $this->dblink->prepare($sql);

        $id = $this->getId();
        $sentencia->bindParam(":id", $id);

        $pass = $this->getPassword();
        $sentencia->bindParam(":pass", $pass);

        $sentencia->execute();
        return $sentencia->fetchAll(PDO::FETCH_OBJ);
    }
    
    public function actualizarUsuario() {
        
        $sql = "UPDATE usuarios SET ";
        
        $sentencia = $this->dblink->prepare($sql);

        // $stmt->bindParam(':name', $userName);
        $nombre = $this->getNombre();
        $dni = $this->getDni();
        $email = $this->getEmail();
        $tlf = $this->getTlf();
        $rol = $this->getRol();
        //$id_direccion = $this->getId_direccion();
        $password = $this->getPassword();

        $sentencia->bindParam(":nom", $nombre);
        $sentencia->bindParam(":dni", $dni);
        $sentencia->bindParam(":email", $email);
        $sentencia->bindParam(":tlf", $tlf);
        $sentencia->bindParam(":rol", $rol);
        //$sentencia->bindParam(":dir", $id_direccion);
        $sentencia->bindParam(":pass", $password);

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
