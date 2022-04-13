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
    private $tipo; // tipos: DATOS, CONFIMRACION
    private $datos; // Si es datos, habrá un array de datos, si es Confirmacion habrá si o no.
    public function __construct($tipo, $datos) {
        $this->tipo = $tipo;
        $this->datos = $datos;
    }
    public function getTipo() {
        return $this->tipo;
    }

    public function getDatos() {
        return $this->datos;
    }

    public function setTipo($tipo): void {
        $this->tipo = $tipo;
    }

    public function setDatos($datos): void {
        $this->datos = $datos;
    }


}
