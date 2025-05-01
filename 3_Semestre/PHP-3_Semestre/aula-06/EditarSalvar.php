<?php
require(conexao.php);
if(isset($_POST['update']))
{
    $codigo = $_POST['cod'];
    $nome = $_POST['nome'];
    $senha = $_POST['senha'];
    $email = $_POST['email'];
    $cpf = $_POST['cpf'];
    $data = $_POST['data'];

    $sql="update usuarios set nome='$nome',senha='$senha',email='$email',cpf='$cpf',data='$data' where codigo='$codigo'";
    $res = $conn->query($sql);
}
header('Location:listar.php')
?>