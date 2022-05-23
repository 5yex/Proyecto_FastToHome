<?php
require_once '../controlador/conexion.php';

/**
 * 
 * 
 */
class Imagen extends Conexion{
    private $id_imagen;
    private $url_imagen;
    private $b64_imagen;
    

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
        //Insertó correctamente
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
        //Insertó correctamente
        return TRUE;
    }
    
}
