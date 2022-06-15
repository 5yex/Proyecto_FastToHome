<?php
    class conexion {
        var $dblink;
                
        function __construct() {
           $servidor = "mysql:host=localhost;dbname=fasttohome";
           $usuario = "root";
           $clave = "";
            
            //$servidor = "mysql:host=serviex.duckdns.org;dbname=pf";
           // $usuario = "proyecto";
           // $clave = "123456";
            
            
            $this->dblink = new PDO($servidor, $usuario, $clave);
            $this->dblink->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
            $this->dblink->exec("SET NAMES utf8");
        }   
}
?>