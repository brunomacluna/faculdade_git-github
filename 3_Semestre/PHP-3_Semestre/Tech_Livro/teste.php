<?php

// Inclui o arquivo de conexão com o banco de dados
require_once 'conexao.php';

// Se a conexão foi bem-sucedida, a variável $pdo estará disponível
// E nenhuma mensagem de erro fatal foi exibida por conexao.php
if (isset($pdo)) {
    echo "Conexão com o banco de dados 'Tech_Livro' realizada com sucesso!";
    echo "<br><br>";
    echo "Você pode deletar este arquivo 'teste.php' agora.";
} else {
    // Isso só deve acontecer se houver um problema grave em conexao.php que não gerou die()
    echo "Falha na conexão. Verifique o arquivo conexao.php.";
}

?>