<?php
require_once '../controlador/conexion.php';

/**
 * Description of Negocio
 *
 * @author Jesus
 */
class Negocio extends Conexion{
    private $id_negocio;
    private $id_direccion;
    private $id_categoria;
    private $id_mercader;
    private $nombre;
    private $descripcion;
    
    public function __construct() {
        
    }
    
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

    public function setId_ciudad($id_ciudad): void {
        $this->id_direccion = $id_ciudad;
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


}
