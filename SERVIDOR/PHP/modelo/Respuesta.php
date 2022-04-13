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
    private $error;
    private $datos;
   

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
