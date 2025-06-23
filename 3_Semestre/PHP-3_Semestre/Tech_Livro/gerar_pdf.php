<?php
session_start();
require_once 'conexao.php'; // Inclui o arquivo de conexão com o banco de dados

// Inclui o autoloader do Composer para carregar a biblioteca Dompdf
// Certifique-se de que o caminho para 'vendor/autoload.php' está correto.
// Ele deve estar na mesma pasta ou em um nível acima, dependendo da sua estrutura.
require_once 'vendor/autoload.php';

use Dompdf\Dompdf;
use Dompdf\Options;

// Verifica se o usuário está logado. Se não, redireciona para a página de login.
// Esta é a primeira verificação crucial.
if (!isset($_SESSION['logged_in']) || $_SESSION['logged_in'] !== true) {
    // Redireciona para o login se não estiver logado.
    header("Location: login.php");
    exit();
}

// 1. Obter os dados dos livros do banco de dados
$livros = [];
try {
    $stmt = $pdo->query("SELECT id, titulo, autor, ano_publicacao, preco FROM livros ORDER BY titulo ASC");
    $livros = $stmt->fetchAll(PDO::FETCH_ASSOC);
} catch (PDOException $e) {
    // Em caso de erro ao carregar do banco, exibe uma mensagem e encerra.
    die("Erro ao carregar livros para o PDF: " . $e->getMessage());
}

// 2. Gerar o conteúdo HTML que será convertido em PDF
// Este é o HTML que a Dompdf transformará em PDF.
$html = '
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Relatório de Livros - Tech_Livro</title>
    <style>
        body { font-family: sans-serif; margin: 20px; }
        h1 { color: #6a4d1b; text-align: center; margin-bottom: 30px; }
        table { width: 100%; border-collapse: collapse; margin-top: 20px; }
        th, td { border: 1px solid #ddd; padding: 8px; text-align: left; }
        th { background-color: #6a4d1b; color: white; }
        tr:nth-child(even) { background-color: #f2f2f2; }
        .footer {
            font-size: 0.8em;
            color: #555;
            text-align: center;
            position: fixed;
            bottom: 0;
            width: 100%;
        }
    </style>
</head>
<body>
    <h1>Relatório de Livros Cadastrados</h1>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Título</th>
                <th>Autor</th>
                <th>Ano</th>
                <th>Preço</th>
            </tr>
        </thead>
        <tbody>';

if (empty($livros)) {
    $html .= '<tr><td colspan="5" style="text-align: center;">Nenhum livro cadastrado.</td></tr>';
} else {
    foreach ($livros as $livro) {
        $html .= '
            <tr>
                <td>' . htmlspecialchars($livro['id']) . '</td>
                <td>' . htmlspecialchars($livro['titulo']) . '</td>
                <td>' . htmlspecialchars($livro['autor']) . '</td>
                <td>' . htmlspecialchars($livro['ano_publicacao']) . '</td>
                <td>R$ ' . number_format($livro['preco'], 2, ',', '.') . '</td>
            </tr>';
    }
}

$html .= '
        </tbody>
    </table>
    <div class="footer">
        Gerado em ' . date('d/m/Y H:i:s') . ' por Tech_Livro
    </div>
</body>
</html>';

// 3. Configurar e instanciar Dompdf
$options = new Options();
$options->set('isHtml5ParserEnabled', true);
$options->set('isRemoteEnabled', true); // Habilite se tiver CSS externo ou imagens remotas

$dompdf = new Dompdf($options);
$dompdf->loadHtml($html);

// Opcional: Definir o tamanho do papel e a orientação
$dompdf->setPaper('A4', 'portrait');

// 4. Renderizar o HTML como PDF
$dompdf->render();

// 5. Enviar o PDF para o navegador
// 'livros_cadastrados.pdf' é o nome do arquivo que será baixado.
// 'Attachment' => true força o download. 'Attachment' => false exibe no navegador.
$dompdf->stream("livros_cadastrados.pdf", array("Attachment" => true));

exit(); // Impede que qualquer outro conteúdo PHP seja processado e corrompa o PDF
?>