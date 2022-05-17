<?php
require_once '../controlador/conexion.php';

class Categoria extends Conexion{
    private $id_categoria;
    private $nombre;
    
    public function getId_categoria() {
        return $this->id_categoria;
    }

    public function getNombre() {
        return $this->nombre;
    }

    public function setId_categoria($id_categoria): void {
        $this->id_categoria = $id_categoria;
    }

    public function setNombre($nombre): void {
        $this->nombre = $nombre;
    }
    
    public function agregar() {
        $sql = "INSERT INTO categoria_negocio (Nombre) VALUES (:nom)";
        
        $sentencia = $this->dblink->prepare($sql);
        
        $nombre = $this->getNombre();
        
        $sentencia->bindParam(":nom", $nombre);
        
        $resultado = $sentencia->execute();

        if ($resultado != 1) {
            //ocurrio un error al insertar
            printf('aaa');
            return FALSE;
        }

        //Insertó correctamente
        return TRUE;
    }
    
    public function obtenerIdCategoria(){
        $sql = "SELECT id FROM categoria_negocio WHERE Nombre = :nom";
        $sentencia = $this->dblink->prepare($sql);
        $nombre = $this->getNombre();
        $sentencia->bindParam(":nom", $nombre);
        $sentencia->execute();            
        return $sentencia->fetchAll(PDO::FETCH_OBJ);
    }  
    
    public function obtenerCategorias(){
        $sql = "SELECT * FROM categoria_negocio";
        $sentencia = $this->dblink->prepare($sql);
        $sentencia->execute();            
        return $sentencia->fetchAll(PDO::FETCH_OBJ);
    }  
    
    public function borrarCategoria(){
        $sql = "DELETE FROM categoria_negocio WHERE Nombre = :nom";
        
        $sentencia = $this->dblink->prepare($sql);
        $nombre = $this->getNombre();
        
        $sentencia->bindParam(":nom", $nombre);
        
        $resultado = $sentencia->execute();

        if ($resultado != 1) {
            //ocurrio un error al insertar
            printf('aaa');
            return FALSE;
        }

        //Borró correctamente
        return TRUE;
    }
}