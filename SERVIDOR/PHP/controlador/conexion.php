<?php
    class Conexion {
        var $dblink;
                
        function __construct() {
            $servidor = "mysql:host=localhost;dbname=pf";
            $usuario = "root";
            $clave = "";
            
            $this->dblink = new PDO($servidor, $usuario, $clave);
            $this->dblink->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
            $this->dblink->exec("SET NAMES utf8");
        }   
}
?>