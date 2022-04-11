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
    private $fecha_hora;
    private $estado;
    private $total;
    private $transporte;
    
    public function getId_pedido() {
        return $this->id_pedido;
    }

    public function getId_usuario() {
        return $this->id_usuario;
    }

    public function getId_negocio() {
        return $this->id_negocio;
    }

    public function getFecha_hora() {
        return $this->fecha_hora;
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

    public function setFecha_hora($fecha_hora): void {
        $this->fecha_hora = $fehca_hora;
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
    
    public function agregar() {
        $sql = "INSERT INTO pedido (id_usuario, id_negocio, fecha_hora, estado, total, transporte) VALUES (:usu, :neg, :fec_hora, :est, :tot, :tra)";
       
        $sentencia = $this->dblink->prepare($sql);
        
        $id_usuario = $this->getId_usuario();
        $id_negocio = $this->getId_negocio();
        $fecha_hora = $this->getFecha_hora();
        $estado = $this->getEstado();
        $total = $this->getTotal();
        $transporte = $this->getTransporte();
        
        $sentencia->bindParam(":usu", $id_usuario);
        $sentencia->bindParam(":neg", $id_negocio);
        $sentencia->bindParam(":fec_hora", $fecha_hora);
        $sentencia->bindParam(":est", $estado);
        $sentencia->bindParam(":tot", $total);
        $sentencia->bindParam(":tra", $transporte);
        
        $resultado = $sentencia->execute();

        if ($resultado != 1) {
            //ocurrio un error al insertar
            printf('aaa');
            return FALSE;
        }

        //Insertó correctamente
        return TRUE;
    }
}
