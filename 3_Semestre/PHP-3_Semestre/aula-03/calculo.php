<?php 
    $nome = $_POST['nome'];
    $nota1 = $_POST['nota1'];
    $nota2 = $_POST['nota2'];
    $nota3 = $_POST['nota3'];
   
    $media = ($nota1 + $nota2 + $nota3) / 3;
    echo "A média é: $media<br><br>";
    if($media>=6){
        echo ("O aluno <b>$nome</b> está <font color='green'>Aprovado</font>");
    }else if($media > 4 && $media < 6) {
        echo ("O aluno <b>$nome</b> está de <font color='blue'><b>Recuperação<b></font>");
    } else {
        echo ("O aluno <b>$nome</b> está <font color='red'><b>Reprovado</b></font>");
    }
    
    //echo "<h1> Informações do aluno</h1>";
    //echo "<hr>";
    //echo "O aluno <b>$nome</b> ficou com a média: <font color='blue'> $media";
?>