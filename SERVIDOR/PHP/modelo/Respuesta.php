<?php

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Scripting/PHPClass.php to edit this template
 */

/**
 * Description of Respuesta
 *
 * @author jmcbg
 */
class Respuesta {
    
    //no tiene atributos privados debido a problemas con la comversión a json
    
    var $error;
    var $datos;
   
    public function __construct($error, $datos) {
        $this->error = $error;
        $this->datos = $datos;
    }

    public function getError() {
        return $this->error;
    }

    public function getDatos() {
        return $this->datos;
    }

    public function setError($error): void {
        $this->error = $error;
    }

    public function setDatos($datos): void {
        $this->datos = $datos;
    }



}
