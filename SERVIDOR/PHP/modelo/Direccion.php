<?php
require_once '../controlador/conexion.php';

/**
 * 
 * 
 */
class Direccion extends Conexion{
    private $id_direccion;
    private $calle;
    private $numero;
    private $ciudad;
    private $provincia;
    private $codigo_postal;
    private $otros;
    private $coordenadas;
    
    public function getId_direccion() {
        return $this->id_direccion;
    }

    public function getCalle() {
        return $this->calle;
    }

    public function getNumero() {
        return $this->numero;
    }

    public function getCiudad() {
        return $this->ciudad;
    }

    public function getProvincia() {
        return $this->provincia;
    }

    public function getCodigo_postal() {
        return $this->codigo_postal;
    }

    public function getOtros() {
        return $this->otros;
    }

    public function getCoordenadas() {
        return $this->coordenadas;
    }

    public function setId_direccion($id_direccion): void {
        $this->id_direccion = $id_direccion;
    }

    public function setCalle($calle): void {
        $this->calle = $calle;
    }

    public function setNumero($numero): void {
        $this->numero = $numero;
    }

    public function setCiudad($ciudad): void {
        $this->ciudad = $ciudad;
    }

    public function setProvincia($provincia): void {
        $this->provincia = $provincia;
    }

    public function setCodigo_postal($codigo_postal): void {
        $this->codigo_postal = $codigo_postal;
    }

    public function setOtros($otros): void {
        $this->otros = $otros;
    }

    public function setCoordenadas($coordenadas): void {
        $this->coordenadas = $coordenadas;
    }

    public function agregar(){
        $sql = "INSERT INTO direccion (Calle, Numero, Ciudad, CP, Otros, Coordenadas) VALUES (:calle, :num, :ciu, :cp, :otros, :coor)";
        
        $sentencia = $this->dblink->prepare($sql);
        
        $calle = $this->getCalle();
        $numero = $this->getNumero();
        $ciudad = $this->getCiudad();
        $codigo_postal = $this->getCodigo_postal();
        $otros = $this->getOtros();
        $coordenadas = $this->getCoordenadas();
        
        $sentencia->bindParam(":calle", $calle);
        $sentencia->bindParam(":num", $numero);
        $sentencia->bindParam(":ciu", $ciudad);
        $sentencia->bindParam(":cp", $codigo_postal);
        $sentencia->bindParam(":otros", $otros);
        $sentencia->bindParam(":coor", $coordenadas);
        
        $resultado = $sentencia->execute();
 
        if ($resultado != 1) {
            return FALSE;
        }
        //Insert?? correctamente
        return TRUE;
    }
    
    public function agregarConId(){
        $resultado = $this->agregar();
        if ($resultado) {
            $sql = "SELECT LAST_INSERT_ID(id) as 'last_id' FROM direccion ORDER BY id DESC LIMIT 1";
            $sentencia = $this->dblink->prepare($sql);
            $resultado = $sentencia->execute();
            return $sentencia->fetchAll(PDO::FETCH_OBJ);
        }
        return -1;
    }
    
    public function obtenerDireccionPorId(){
        $sql = "SELECT * FROM direccion WHERE id = :id_dir";
        
        $sentencia = $this->dblink->prepare($sql);

        $id_direccion = $this->getId_direccion();
        $sentencia->bindParam(":id_dir", $id_direccion);

        $sentencia->execute();
        return $sentencia->fetchAll(PDO::FETCH_OBJ);
    }
    
    public function actualizarDireccion(){
        $sql = "UPDATE direccion SET Calle = :calle, Numero = :num, Ciudad = :ciu, CP = :cp, Otros = :otros, Coordenadas = :coor WHERE id = :id_dir";
        
        $sentencia = $this->dblink->prepare($sql);
        
        $id_direccion = $this->getId_direccion();
        $calle = $this->getCalle();
        $numero = $this->getNumero();
        $ciudad = $this->getCiudad();
        $codigo_postal = $this->getCodigo_postal();
        $otros = $this->getOtros();
        $coordenadas = $this->getCoordenadas();
        
        $sentencia->bindParam(":id_dir", $id_direccion);
        $sentencia->bindParam(":calle", $calle);
        $sentencia->bindParam(":num", $numero);
        $sentencia->bindParam(":ciu", $ciudad);
        $sentencia->bindParam(":cp", $codigo_postal);
        $sentencia->bindParam(":otros", $otros);
        $sentencia->bindParam(":coor", $coordenadas);
        
        $resultado = $sentencia->execute();
 
        if ($resultado != 1) {
            return FALSE;
        }
        //Insert?? correctamente
        return TRUE;
    }
    
}
