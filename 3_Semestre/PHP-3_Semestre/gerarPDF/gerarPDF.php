<?php
require_once __DIR__ . '/vendor/autoload.php';
require_once 'conexao.php';

use Dompdf\Dompdf;
use Dompdf\Options;

// Configurações do Dompdf
$options = new Options();
$options->set('defaultFont', 'Arial');
$dompdf = new Dompdf($options);

// Buscar dados do banco
$sql = "SELECT * FROM usuarios";
$stmt = $pdo->prepare($sql);
$stmt->execute();
$usuarios = $stmt->fetchAll(PDO::FETCH_ASSOC);

// Criar conteúdo HTML
$html = '
<h1 style="text-align: center;">Relatório de Usuários</h1>
<table border="1" width="100%" cellspacing="0" cellpadding="5">
    <thead>
        <tr>
            <th>ID</th>
            <th>Nome</th>
            <th>Email</th>
        </tr>
    </thead>
    <tbody>
';

foreach ($usuarios as $usuario) {
    $html .= '
        <tr>
            <td>' . $usuario['id'] . '</td>
            <td>' . $usuario['nome'] . '</td>
            <td>' . $usuario['email'] . '</td>
        </tr>
    ';
}

$html .= '
    </tbody>
</table>
';

// Gerar PDF
$dompdf->loadHtml($html);
$dompdf->setPaper('A4', 'portrait');
$dompdf->render();
$dompdf->stream("relatorio_usuarios.pdf", ["Attachment" => false]); // false = abre no navegador
?>
