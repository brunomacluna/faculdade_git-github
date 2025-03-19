<?php

$peso = $_POST['peso'];
$altura = $_POST['altura'];

$imc = $peso / ($altura ** 2);

if ($imc <= 18.5){
    echo ("<font color = 'yellow'>Abaixo do peso</font>");
}elseif ($imc <= 25){
    echo ("<font color = 'green'>Peso Normal</font>");
}elseif ($imc <= 30){
    echo ("<font color = 'yellow'>Acima do Peso</font>");
}elseif ($imc < 40){
    echo ("<font color = 'orange'>Obesidade</font>");
}else {
    echo ("<font color = 'red'>Obesidade Grave</font>");
}





?>