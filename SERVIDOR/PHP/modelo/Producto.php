<?php
require_once '../controlador/conexion.php';
/**
 * Description of Producto
 *
 * @author Jesus
 */
class Producto extends Conexion{
    private $id_producto;
    private $id_negocio;
    private $nombre;
    private $precio;
    private $descripcion;
    private $stock;
    
    public function __construct() {
        
    }
    
    public function getId_producto() {
        return $this->id_producto;
    }

    public function getId_negocio() {
        return $this->id_negocio;
    }

    public function getNombre() {
        return $this->nombre;
    }

    public function getPrecio() {
        return $this->precio;
    }

    public function getDescripcion() {
        return $this->descripcion;
    }

    public function getStock() {
        return $this->stock;
    }

    public function setId_producto($id_producto): void {
        $this->id_producto = $id_producto;
    }

    public function setId_negocio($id_negocio): void {
        $this->id_negocio = $id_negocio;
    }

    public function setNombre($nombre): void {
        $this->nombre = $nombre;
    }

    public function setPrecio($precio): void {
        $this->precio = $precio;
    }

    public function setDescripcion($descripcion): void {
        $this->descripcion = $descripcion;
    }

    public function setStock($stock): void {
        $this->stock = $stock;
    }



}
