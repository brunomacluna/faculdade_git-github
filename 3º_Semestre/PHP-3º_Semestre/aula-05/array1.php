<?php 

$array = array("Terça-feira", "Quarta-feira", "Quinta-feira");
print_r($array);

echo '<br>';
echo '<br>';
echo($array[1]);

echo '<br>';
echo '<br>';
echo'<hr>';
echo '<pre>';
$array2 = ["aula", "PHP", "HTML", "CSS"];
print_r($array2);
echo '</pre>';

echo '<br>';
echo '<br>';
echo'<hr>';
echo '<pre>';
$array3 = [];
$array3 [] = "ADS";
$array3 [] = "STI";
$array3 [] = "SI";
print_r($array3);
echo '</pre>';

echo '<br>';
echo '<br>';
echo'<hr>';
echo '<pre>';
$array4 = [1=>"iphone 16", 2=>"Galaxy", 3=>"Zenfone", 4=>"Xiaomi"];
print_r($array4);
echo '</pre>';
echo '<br>';
echo($array4[4]);

echo '<br>';
echo '<br>';
echo'<hr>';
echo '<pre>';
$array5 = range(1,10);
print_r($array5);
echo '</pre>';
echo '<br>';

echo '<br>';
echo '<br>';
echo'<hr>';
echo '<pre>';
$array5 = range('a','z');
print_r($array5);
echo '</pre>';
echo '<br>';

echo '<br>';
echo '<br>';
echo'<hr>';
echo '<pre>';
$array6 = ["São Paulo", "Brasilía", "Goiania", "Palmas"];
foreach($array6 as $cidade){
    echo $cidade.'<br>';
}     
echo '</pre>';
echo '<br>';

?>