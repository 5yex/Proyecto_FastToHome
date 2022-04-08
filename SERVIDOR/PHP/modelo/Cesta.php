<?php
require_once '../controlador/conexion.php';

/**
 * Description of Cesta
 *
 * @author Jesus
 */
class Cesta extends Conexion{
    private $id_cesta;
    private $cantidad;
    private $id_pedido;
    private $id_producto;
    
    public function __construct() {
        
    }
    
    public function getId_cesta() {
        return $this->id_cesta;
    }

    public function getCantidad() {
        return $this->cantidad;
    }

    public function getId_pedido() {
        return $this->id_pedido;
    }

    public function getId_producto() {
        return $this->id_producto;
    }

    public function setId_cesta($id_cesta): void {
        $this->id_cesta = $id_cesta;
    }

    public function setCantidad($cantidad): void {
        $this->cantidad = $cantidad;
    }

    public function setId_pedido($id_pedido): void {
        $this->id_pedido = $id_pedido;
    }

    public function setId_producto($id_producto): void {
        $this->id_producto = $id_producto;
    }

}
