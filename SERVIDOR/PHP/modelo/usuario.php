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
    private $apellidos;
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

    public function getApellidos() {
        return $this->apellidos;
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

    public function setApellidos($apellidos): void {
        $this->apellidos = $apellidos;
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

        $sql = "INSERT INTO usuarios (Nombre, apellidos, Dni, Email, tlf, Rol, direccion_id, password) VALUES (:nom, :ape,:dni, :email, :tlf, :rol, :dir, :pass)";

        $sentencia = $this->dblink->prepare($sql);

        // $stmt->bindParam(':name', $userName);
        $nombre = $this->getNombre();
        $apellidos = $this->getApellidos();
        $dni = $this->getDni();
        $email = $this->getEmail();
        $tlf = $this->getTlf();
        $rol = $this->getRol();
        $id_direccion = $this->getId_direccion();
        $password = $this->getPassword();

        $sentencia->bindParam(":nom", $nombre);
        $sentencia->bindParam(":ape",$apellidos);
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

        //Insert?? correctamente
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
    
    public function todosLosUsuarios(){
        $sql = "SELECT * FROM usuarios";
        
        $sentencia = $this->dblink->prepare($sql);
        
        $sentencia->execute();
        return $sentencia->fetchAll(PDO::FETCH_OBJ);
        
    }
    
    public function todosUsuariosClientes() {
        $sql = "SELECT * FROM usuarios WHERE Rol = 'cliente'";
        
        $sentencia = $this->dblink->prepare($sql);
        
        $sentencia->execute();
        return $sentencia->fetchAll(PDO::FETCH_OBJ);
    }
    
    
    public function todosUsuariosAdministrador() {
        $sql = "SELECT * FROM usuarios WHERE Rol = 'admin'";
        
        $sentencia = $this->dblink->prepare($sql);
        
        $sentencia->execute();
        return $sentencia->fetchAll(PDO::FETCH_OBJ);
    }
    
    public function todosUsuariosMercader() {
        $sql = "SELECT * FROM usuarios WHERE Rol = 'mercader'";
        
        $sentencia = $this->dblink->prepare($sql);
        
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

        $sql = "UPDATE IGNORE usuarios SET Nombre = :nom, apellidos = :ape, Dni = :dni, Email = :email, tlf = :tlf, password = :pass WHERE id = :id_user";

        $sentencia = $this->dblink->prepare($sql);

        // $stmt->bindParam(':name', $userName);
        $nombre = $this->getNombre();
        $apellidos = $this->getApellidos();
        $dni = $this->getDni();
        $email = $this->getEmail();
        $tlf = $this->getTlf();
        //$rol = $this->getRol();
        $id = $this->getId();
        $password = $this->getPassword();

        $sentencia->bindParam(":nom", $nombre);
        $sentencia->bindParam(":ape",$apellidos);
        $sentencia->bindParam(":dni", $dni);
        $sentencia->bindParam(":email", $email);
        $sentencia->bindParam(":tlf", $tlf);
        //$sentencia->bindParam(":rol", $rol);
        $sentencia->bindParam(":id_user", $id);
        $sentencia->bindParam(":pass", $password);

        // $sentencia->bindParam(":fot", $this->getFoto() );
        $resultado = $sentencia->execute();

        if ($resultado != 1) {
            //ocurrio un error al insertar
            return FALSE;
        }

        //Insert?? correctamente
        return TRUE;
    }
    
    public function asignarRolMerdader() {
        $sql = "UPDATE usuarios SET Rol = 'mercader' WHERE id = :id_user";
        
        $sentencia = $this->dblink->prepare($sql);
        
        $id = $this->getId();
        
        $sentencia->bindParam(":id_user", $id);
        
        $resultado = $sentencia->execute();

        if ($resultado != 1) {
            //ocurrio un error al insertar
            return FALSE;
        }

        //Insert?? correctamente
        return TRUE;
    }
    
    public function asignarRolCliente() {
        $sql = "UPDATE usuarios SET Rol = 'cliente' WHERE id = :id_user";
        
        $sentencia = $this->dblink->prepare($sql);
        
        $id = $this->getId();
        
        $sentencia->bindParam(":id_user", $id);
        
        $resultado = $sentencia->execute();

        if ($resultado != 1) {
            //ocurrio un error al insertar
            return FALSE;
        }

        //Insert?? correctamente
        return TRUE;
    }
    
    public function asignarRolAdministrador() {
        $sql = "UPDATE usuarios SET Rol = 'admin' WHERE id = :id_user";
        
        $sentencia = $this->dblink->prepare($sql);
        
        $id = $this->getId();
        
        $sentencia->bindParam(":id_user", $id);
        
        $resultado = $sentencia->execute();

        if ($resultado != 1) {
            //ocurrio un error al insertar
            return FALSE;
        }

        //Insert?? correctamente
        return TRUE;
    }
    
    public function usuarioPorSuId(){
        $sql = "SELECT * FROM usuarios where id = :id";

        $sentencia = $this->dblink->prepare($sql);

        $id = $this->getId();
        $sentencia->bindParam(":id", $id);

        $sentencia->execute();
        return $sentencia->fetchAll(PDO::FETCH_OBJ);
    }

}
