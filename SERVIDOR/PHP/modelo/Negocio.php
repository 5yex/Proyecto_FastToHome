<?php

require_once '../controlador/conexion.php';

/**
 * Description of Negocio
 *
 * @author Jesus
 */
class Negocio extends Conexion {

    private $id_negocio;
    private $id_direccion;
    private $id_categoria;
    private $id_mercader;
    private $nombre;
    private $descripcion;

    public function getId_negocio() {
        return $this->id_negocio;
    }

    public function getId_direccion() {
        return $this->id_direccion;
    }

    public function getId_categoria() {
        return $this->id_categoria;
    }

    public function getId_mercader() {
        return $this->id_mercader;
    }

    public function getNombre() {
        return $this->nombre;
    }

    public function getDescripcion() {
        return $this->descripcion;
    }

    public function setId_negocio($id_negocio): void {
        $this->id_negocio = $id_negocio;
    }

    public function setId_direccion($id_direccion): void {
        $this->id_direccion = $id_direccion;
    }

    public function setId_categoria($id_categoria): void {
        $this->id_categoria = $id_categoria;
    }

    public function setId_mercader($id_mercader): void {
        $this->id_mercader = $id_mercader;
    }

    public function setNombre($nombre): void {
        $this->nombre = $nombre;
    }

    public function setDescripcion($descripcion): void {
        $this->descripcion = $descripcion;
    }

    public function agregar() {
        $sql = "INSERT INTO negocio (id_categoria, id_direccion, id_mercader, Nombre, Descripcion) VALUES (:cat, :dir, :mer, :nom, :des)";

        $sentencia = $this->dblink->prepare($sql);

        $id_categoria = $this->getId_categoria();
        $id_direccion = $this->getId_direccion();
        $id_mercader = $this->getId_mercader();
        $nombre = $this->getNombre();
        $descripcion = $this->getDescripcion();

        $sentencia->bindParam(":cat", $id_categoria);
        $sentencia->bindParam(":dir", $id_direccion);
        $sentencia->bindParam(":mer", $id_mercader);
        $sentencia->bindParam(":nom", $nombre);
        $sentencia->bindParam(":des", $descripcion);

        $resultado = $sentencia->execute();

        if ($resultado != 1) {
            //ocurrio un error al insertar
            return FALSE;
        }

        //Insertó correctamente
        return TRUE;
    }
    
    public function obtenerIdNegocio(){
        $sql = "SELECT id FROM negocio WHERE Nombre = :nom";
        
        $sentencia = $this->dblink->prepare($sql);
        
        $nombre = $this->getNombre();
        
        $sentencia->bindParam(":nom", $nombre);
        
        $sentencia->execute();            
        return $sentencia->fetchAll(PDO::FETCH_OBJ);
        
        
    }
    
    
    public function obtenerNegocioDeMercader(){
        $sql = "SELECT * FROM negocio WHERE id_mercader = :id";
        
        $sentencia = $this->dblink->prepare($sql);
        
        $nombre = $this->getNombre();
        
        $sentencia->bindParam(":id", $id);
        
        $sentencia->execute();            
        return $sentencia->fetchAll(PDO::FETCH_OBJ);        
    }

    public function modificar() {
        $sql = "UPDATE negocio set id_direccion = :dir, id_mercader = :mer, Nombre = :nom, Descripcion = :des where id = :id_neg";

        /*$sentencia = $this->dblink->prepare($sql);
        $marca = $this->getMarca();
        $propietario = $this->getPropietario();
        $precio = $this->getPrecio();

        // $stmt->bindParam(':name', $userName);
        $sentencia->bindParam(":marca", $marca);
        $sentencia->bindParam(":pre", $precio);
        $sentencia->bindParam(":prop", $propietario);
        // $sentencia->bindParam(":fot", $this->getFoto() );
        $resultado = $sentencia->execute();

        if ($resultado != 1) {
            //ocurrio un error al borrar
            return FALSE;
        }

        //InsertÃ³ correctamente
        return TRUE;*/
    }
    
    

}
