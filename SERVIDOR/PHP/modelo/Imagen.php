<?php

require_once '../controlador/conexion.php';

/**
 * 
 * 
 */
class Imagen extends Conexion {

    private $id_imagen;
    private $url_imagen;
    private $b64_imagen;

    public function getId_imagen() {
        return $this->id_imagen;
    }

    public function getUrl_imagen() {
        return $this->url_imagen;
    }

    public function getB64_imagen() {
        return $this->b64_imagen;
    }

    public function setId_imagen($id_imagen): void {
        $this->id_imagen = $id_imagen;
    }

    public function setUrl_imagen($url_imagen): void {
        $this->url_imagen = $url_imagen;
    }

    public function setB64_imagen($b64_imagen): void {
        $this->b64_imagen = $b64_imagen;
    }

 
    public function agregar() {
        if (file_put_contents($this->url_imagen, base64_decode($this->b64_imagen)) !== false) {
            $sql = "INSERT INTO imagenes (url) VALUES (:url)";
            $sentencia = $this->dblink->prepare($sql);
            $url = $this->getUrl_imagen();
            $sentencia->bindParam(":url", $url);
            $resultado = $sentencia->execute();
            if ($resultado != 1) {
                return FALSE;
            }
            return TRUE;
        }
        return false;
    }

    public function agregarConId() {
        $resultado = $this->agregar();
        if ($resultado) {
            $sql = "SELECT LAST_INSERT_ID(id) as 'last_id' FROM imagenes ORDER BY id DESC LIMIT 1";
            $sentencia = $this->dblink->prepare($sql);
            $resultado = $sentencia->execute();
            return $sentencia->fetchAll(PDO::FETCH_OBJ);
        }
        return -1;
    }

    public function obtenerImagenPorId() {
        $sql = "SELECT url FROM imagenes WHERE id = :id";
        $sentencia = $this->dblink->prepare($sql);
        $id = $this->getId_imagen();
        $sentencia->bindParam(":id", $id);
        $sentencia->execute();
        $resultado = $sentencia->fetchAll(PDO::FETCH_OBJ);
        $url = $resultado[0]->url;
        $imgB64 = base64_encode(file_get_contents($url));
        return $imgB64;
    }

//    public function actualizarDireccion(){
//        $sql = "UPDATE direccion SET Calle = :calle, Numero = :num, Ciudad = :ciu, CP = :cp, Otros = :otros, Coordenadas = :coor WHERE id = :id_dir";
//        
//        $sentencia = $this->dblink->prepare($sql);
//        
//        $id_direccion = $this->getId_direccion();
//        $calle = $this->getCalle();
//        $numero = $this->getNumero();
//        $ciudad = $this->getCiudad();
//        $codigo_postal = $this->getCodigo_postal();
//        $otros = $this->getOtros();
//        $coordenadas = $this->getCoordenadas();
//        
//        $sentencia->bindParam(":id_dir", $id_direccion);
//        $sentencia->bindParam(":calle", $calle);
//        $sentencia->bindParam(":num", $numero);
//        $sentencia->bindParam(":ciu", $ciudad);
//        $sentencia->bindParam(":cp", $codigo_postal);
//        $sentencia->bindParam(":otros", $otros);
//        $sentencia->bindParam(":coor", $coordenadas);
//        
//        $resultado = $sentencia->execute();
// 
//        if ($resultado != 1) {
//            return FALSE;
//        }
//        //Insertó correctamente
//        return TRUE;
//    }
}
