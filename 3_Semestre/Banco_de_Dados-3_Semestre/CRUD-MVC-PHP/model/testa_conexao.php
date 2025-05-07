<?php
require_once("banco.php");  

$banco = new Banco();
echo $banco->verificaConexao();
?>