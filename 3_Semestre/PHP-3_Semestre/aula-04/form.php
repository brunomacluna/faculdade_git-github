<?php

$nome = $_POST['nome'];
$nota1 = $_POST['n1'];
$nota2 = $_POST['n2'];
$nota3 = $_POST['n3'];

$media = ($nota1 + $nota2 + $nota3) / 3;
$media_arredondada = round($media, 2);
echo ("O aluno ficou com a média: $media_arredondada");
echo "<hr>";

if ($media >= 6){
    echo ("Aluno <font color = 'green'>Aprovado</font>");
}elseif ($media >= 4) {
    echo ("Aluno <font color = 'orange'>Recuperação</font>");
}else {
    echo ("Aluno <font color = 'red'>Reprovado</font>");
}

?>