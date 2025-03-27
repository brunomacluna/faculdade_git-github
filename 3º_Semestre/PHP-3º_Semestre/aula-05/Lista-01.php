<?php
echo  '<h3>2 - Crie um array associativo com nomes de três amigos e suas idades. Exiba a idade de um amigo específico.</h3>';
$array2 = ["João" => 34, "Adonias" => 67, "Josias" => 14];
print_r($array2["Adonias"]);
echo '<br>';
echo '<br>';
echo '<hr>';

echo '<h3>3 - Dado um array de números, percorra-o e exiba apenas os valores maiores que 10.</h3>';

echo '<pre>';
$array3 = range(1, 20);
foreach ($array3 as $maiores) {
   if ($maiores > 10){
      echo $maiores . '<br>';
   }//fim if
}//fimm foreach
echo '</pre>';
echo '<hr>';

echo '<h3>4 - Crie uma array de números, adicione um novo número, remova o último número e exiba o array final.</h3>';
echo '<pre>';
$array4 = [10, 20, 30, 40, 50];
print_r($array4);
array_push($array4, 80);
print_r($array4);
array_pop($array4);
print_r($array4);
echo '</pre>';
echo '<hr>';

echo '<h3> 5 - Dado um array de números, utilize um foreach para somar todos os valores e exibir o resultado.</h3>';
echo '<pre>';
$array5 = [10, 20, 30, 40, 50];
print_r($array5);
$soma = 0;
foreach ($array5 as $numero) {
   $soma = $soma + $numero; 
}//fim foreach
echo "A soma do array 5 é: ". $soma;
echo '</pre>';
echo '<hr>';

echo '<h3>6 - Dado um array com 15 números, percorra-o usando um for ou foreach e exiba apenas os números pares.</h3>';
echo '<pre>';
$array6 = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15];
print_r($array6);
foreach ($array6 as $pares) {
   if ( $pares % 2 == 0){
     echo "Pares do array 6: " . $pares . '<br>';
   }//fim if
}//fim foreach
echo '</pre>';

echo '<h3>7 - Crie um array de números e use um loop para encontrar e exibir o maior e o menor valor.</h3>';
echo '<pre>';
$array7 = [10, 20, 30, 40, 50];
print_r($array7);
$max = 0;
$min = 9999;
foreach ($array7 as $num) {
   if ($max < $num) {
      $max = $num;
   }//fim if
   if ($min > $num) {
      $min = $num;
   }//fim if
}//fim foreach
echo "O maior número do array 7 é:" . $max . '<br>';
echo "O menor número do array 7 é:" . $min;
echo '</pre>';
echo '<hr>';

echo '<h3>8 - Dado um array com valores repetidos, utilize array_unique() para remover duplicatas e exiba o resultado.</h3>';
echo '<pre>';
$array8 = [10, 10, 20, 20, 30, 30, 40, 40,50, 50];
print_r($array8);
$array8_unique = array_unique($array8);
print_r($array8_unique);
echo '</pre>';
?>


