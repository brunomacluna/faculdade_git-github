<?php
if(!empty($_GET['codigo']))
{
include_once('conexao.php');

$codigo = $_GET['codigo'];
$sql = "select * from usuarios where codigo='$codigo'";
$res = $conn->query($sql);
if ($res->num_rows>0)
{$sqlDelete = 'delete from usuarios where codigo="$codigo"';
$result = $conn -> query($sqlDelete);
}
}
header('Location:listar.php')
?>