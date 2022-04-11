<?php
require_once '../controlador/conexion.php';

/**
 * Description of Pedido
 *
 * @author Jesus
 */
class Pedido extends Conexion{
    private $id_pedido;
    private $id_usuario;
    private $id_negocio;
    private $fehca_hora;
    private $estado;
    private $total;
    private $transporte;
    
    public function __construct() {
        
    }
    
    public function getId_pedido() {
        return $this->id_pedido;
    }

    public function getId_usuario() {
        return $this->id_usuario;
    }

    public function getId_negocio() {
        return $this->id_negocio;
    }

    public function getFehca_hora() {
        return $this->fehca_hora;
    }

    public function getEstado() {
        return $this->estado;
    }

    public function getTotal() {
        return $this->total;
    }

    public function getTransporte() {
        return $this->transporte;
    }

    public function setId_pedido($id_pedido): void {
        $this->id_pedido = $id_pedido;
    }

    public function setId_usuario($id_usuario): void {
        $this->id_usuario = $id_usuario;
    }

    public function setId_negocio($id_negocio): void {
        $this->id_negocio = $id_negocio;
    }

    public function setFehca_hora($fehca_hora): void {
        $this->fehca_hora = $fehca_hora;
    }

    public function setEstado($estado): void {
        $this->estado = $estado;
    }

    public function setTotal($total): void {
        $this->total = $total;
    }

    public function setTransporte($transporte): void {
        $this->transporte = $transporte;
    }
    
    
}
