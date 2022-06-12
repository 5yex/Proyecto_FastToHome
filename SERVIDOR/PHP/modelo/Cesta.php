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
    
    public function agregar() {
        $sql = "INSERT INTO cesta (Cantidad, id_pedido, id_producto) VALUES (:cant, :ped, :pro)";
        
        $sentencia = $this->dblink->prepare($sql);
        
        $cantidad = $this->getCantidad();
        $id_pedido = $this->getId_pedido();
        $id_producto = $this->getId_producto();
        
        $sentencia->bindParam(":cant", $cantidad);
        $sentencia->bindParam(":ped", $this->id_pedido);
        $sentencia->bindParam(":pro", $this->id_producto);
        
        $resultado = $sentencia->execute();

        if ($resultado != 1) {
            //ocurrio un error al insertar
            printf('aaa');
            return FALSE;
        }

        //Insertó correctamente
        return TRUE;
    }
    
    public function obtenerCestaPedido(){
        $sql = "SELECT * FROMN cesta WHERE id_pedido = :id_ped";
        
        $sentencia = $this->dblink->prepare($sql);
        
        $id_pedido = $this->getId_pedido();
        
        $sentencia->bindParam(":ped", $id_pedido);
        
        $sentencia->execute();
        return $sentencia->fetchAll(PDO::FETCH_OBJ);
        
    }

}
