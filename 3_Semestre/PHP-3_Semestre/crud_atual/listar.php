<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-SgOJa3DmI69IUzQ2PVdRZhwQ+dy64/BUtbMJw1MZ8t5HZApcHrRKUc4W0kG879m7" crossorigin="anonymous">
</head>
<body>
    <div class="container">
<?php
include('conexao.php');
print("<h1> Listagem de Usuários</h1>");
$sql = 'select * from usuarios';
$res = $conn->query($sql);
$qtde = $res ->num_rows;
if($qtde >0){
    print("<table class='table table-dark table-striped'>");
    print ("<tr>");
    print("<th> Código</th>");
    print("<th> Nome</th>");
    print("<th> Senha</th>");
    print("<th> Email</th>");
    print("<th> CPF</th>");
    print("<th> Data</th>");
    print("<th> Ações</th>");
    print ("</tr>");
while($row = $res->fetch_object()){
        print "<tr>";
        print"<td>".$row ->codigo."</td>";
        print"<td>".$row ->nome."</td>";
        print"<td>".$row ->senha."</td>";
        print"<td>".$row ->email."</td>";
        print"<td>".$row ->cpf."</td>";
        print"<td>".$row ->data."</td>";
        print"<td>
        <button class='btn btn-success' onclick=location.href='editar.php?codigo=$row->codigo'>Editar</button>
        <button class='btn btn-danger' onclick=location.href='deletar.php?codigo=$row->codigo'>Excluir</button>
        
        </td>";
       print "</tr>"; 
}
        print"</table>";}
    

  ?>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/js/bootstrap.bundle.min.js" integrity="sha384-k6d4wzSIapyDyv1kpU366/PK5hCdSbCRGRCMv+eplOQJWyd1fbcAu9OCUj5zNLiq" crossorigin="anonymous"></script>  
<a href="index.html">Voltar a principal</a>  
</div>
</body>
</html>