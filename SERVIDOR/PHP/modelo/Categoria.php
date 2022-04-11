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

}