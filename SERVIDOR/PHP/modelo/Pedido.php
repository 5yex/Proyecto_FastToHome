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
        $this->fecha_hora = $fecha_hora;
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
        $sql = "INSERT INTO pedido (id_usuario, id_negocio, fecha_hora, estado, total, transporte) VALUES (:usu, :neg, :fec_hora, 'pendiente_pago', :tot, :tra)";
       
        $sentencia = $this->dblink->prepare($sql);
        
        $id_usuario = $this->getId_usuario();
        $id_negocio = $this->getId_negocio();
        $fecha_hora = $this->getFecha_hora();
        $total = $this->getTotal();
        $transporte = $this->getTransporte();
        
        $sentencia->bindParam(":usu", $id_usuario);
        $sentencia->bindParam(":neg", $id_negocio);
        $sentencia->bindParam(":fec_hora", $fecha_hora);
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
    
    
    public function agregarConId() {
        $resultado = $this->agregar();
        if ($resultado) {
            $sql = "SELECT LAST_INSERT_ID(id) as 'last_id' FROM pedido ORDER BY id DESC LIMIT 1";
            $sentencia = $this->dblink->prepare($sql);
            $resultado = $sentencia->execute();
            return $sentencia->fetchAll(PDO::FETCH_OBJ);
        }
        return -1;
    }
    
    
    public function calcularTotalPedido(){
        
        $sql = "SELECT totalPrecioPedido(:id_ped)";
        
        $sentencia = $this->dblink->prepare($sql);
        
        $id_pedido = $this->getId_pedido();
        
        $sentencia->bindParam(":id_ped", $id_pedido);
        
        $sentencia->execute();            
        return $sentencia->fetchAll(PDO::FETCH_OBJ);
    }
    
    public function actualizacionEstadoPedido(){
        $sql = "CALL actualizarEstadoPedido(:est, :id_ped)";
        
        $sentencia = $this->dblink->prepare($sql);
        
        $id_pedido = $this->getId_pedido();
        $estado = $this->getEstado();
        
        $sentencia->bindParam(":id_ped", $id_pedido);
        $sentencia->bindParam(":est", $estado);
        
        $resultado = $sentencia->execute();

        if ($resultado != 1) {
            //ocurrio un error al insertar
            printf('aaa');
            return FALSE;
        }

        //Insertó correctamente
        return TRUE;
    }
    
    public function obtenerPedidosNegocioPagado(){
        $sql = "SELECT * FROM pedido WHERE id_negocio = :id_neg AND DATE(fecha_hora) = CURDATE() AND estado LIKE 'pagado'";
        
        $sentencia = $this->dblink->prepare($sql);

        $id_negocio = $this->getId_negocio();
        $sentencia->bindParam(":id_neg", $id_negocio);

        $sentencia->execute();
        return $sentencia->fetchAll(PDO::FETCH_OBJ);
        
    }
    
    public function obtenerPedido(){
        $sql = "SELECT * FROM pedido WHERE id = :id_pedido";
        
        $sentencia = $this->dblink->prepare($sql);

        $id_pedido = $this->getId_pedido();
        $sentencia->bindParam(":id_pedido", $id_pedido);

        $sentencia->execute();
        return $sentencia->fetchAll(PDO::FETCH_OBJ);
    }
    
    public function obtenerPedidosNegocioEnPreparacion(){
        $sql = "SELECT * FROM pedido WHERE id_negocio = :id_neg AND DATE(fecha_hora) = CURDATE() AND estado LIKE 'en_preparacion'";
        
        $sentencia = $this->dblink->prepare($sql);

        $id_negocio = $this->getId_negocio();
        $sentencia->bindParam(":id_neg", $id_negocio);

        $sentencia->execute();
        return $sentencia->fetchAll(PDO::FETCH_OBJ);
    }
    
    public function obtenerTodosPedidosNegocio(){
        $sql = "SELECT * FROM pedido WHERE id_negocio = :id_neg AND DATE(fecha_hora) = CURDATE()";
        
        $sentencia = $this->dblink->prepare($sql);

        $id_negocio = $this->getId_negocio();
        $sentencia->bindParam(":id_neg", $id_negocio);

        $sentencia->execute();
        return $sentencia->fetchAll(PDO::FETCH_OBJ);
    }
    
    public function obtenerPedidosClientes() {
        $sql = "SELECT * FROM pedido WHERE id_usuario = :id_user AND (estado like 'enviando' or estado like 'pagado' or estado like 'en_preparacion' OR estado like 'incidencia' ) order by id desc;";
        
        $sentencia = $this->dblink->prepare($sql);

        $sentencia->bindParam(":id_user", $this->id_usuario);

        $sentencia->execute();
        return $sentencia->fetchAll(PDO::FETCH_OBJ);
    }
}
