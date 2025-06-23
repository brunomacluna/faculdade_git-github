<?php
session_start();
require_once 'conexao.php'; // Inclui o arquivo de conexão com o banco de dados

// Verifica se o usuário está logado. Se não, redireciona para a página de login.
if (!isset($_SESSION['logged_in']) || $_SESSION['logged_in'] !== true) {
    header("Location: login.php");
    exit();
}

$user_id = $_SESSION['user_id'];
$username = $_SESSION['username'];

$message = '';
$message_type = '';

// --- Lógica para ADICIONAR Livro ---
if ($_SERVER['REQUEST_METHOD'] === 'POST' && isset($_POST['action']) && $_POST['action'] === 'add') {
    $titulo = trim($_POST['titulo']);
    $autor = trim($_POST['autor']);
    $ano_publicacao = (int)$_POST['ano_publicacao']; // Cast para inteiro
    $preco = (float)str_replace(',', '.', $_POST['preco']); // Converte vírgula para ponto e cast para float

    if (empty($titulo) || empty($autor) || empty($ano_publicacao) || empty($preco)) {
        $message = "Por favor, preencha todos os campos para adicionar o livro.";
        $message_type = 'error';
    } else {
        try {
            $stmt = $pdo->prepare("INSERT INTO livros (titulo, autor, ano_publicacao, preco) VALUES (:titulo, :autor, :ano_publicacao, :preco)");
            $stmt->bindParam(':titulo', $titulo);
            $stmt->bindParam(':autor', $autor);
            $stmt->bindParam(':ano_publicacao', $ano_publicacao);
            $stmt->bindParam(':preco', $preco);

            if ($stmt->execute()) {
                $message = "Livro '$titulo' adicionado com sucesso!";
                $message_type = 'success';
            } else {
                $message = "Erro ao adicionar o livro.";
                $message_type = 'error';
            }
        } catch (PDOException $e) {
            $message = "Erro no banco de dados ao adicionar: " . $e->getMessage();
            $message_type = 'error';
        }
    }
}

// --- Lógica para EXCLUIR Livro ---
if (isset($_GET['action']) && $_GET['action'] === 'delete' && isset($_GET['id'])) {
    $id = (int)$_GET['id'];
    try {
        $stmt = $pdo->prepare("DELETE FROM livros WHERE id = :id");
        $stmt->bindParam(':id', $id);
        if ($stmt->execute()) {
            $message = "Livro excluído com sucesso!";
            $message_type = 'success';
        } else {
            $message = "Erro ao excluir o livro.";
            $message_type = 'error';
        }
    } catch (PDOException $e) {
        $message = "Erro no banco de dados ao excluir: " . $e->getMessage();
        $message_type = 'error';
    }
}


// --- Lógica para LISTAR Livros (sempre executado) ---
$livros = [];
try {
    $stmt = $pdo->query("SELECT id, titulo, autor, ano_publicacao, preco FROM livros ORDER BY titulo ASC");
    $livros = $stmt->fetchAll(PDO::FETCH_ASSOC);
} catch (PDOException $e) {
    $message = "Erro ao carregar livros: " . $e->getMessage();
    $message_type = 'error';
}
?>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>CRUD de Livros - Tech_Livro</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <header>
        <h1>Tech_Livro - Painel Administrativo</h1>
        <div class="header-right">
            <p>Olá, <?php echo htmlspecialchars($username); ?>!</p>
            <a href="logout.php" class="logout-button">Sair</a>
        </div>
    </header>

    <main>
        <?php if ($message): ?>
            <div class="message-box <?php echo $message_type; ?>">
                <?php echo htmlspecialchars($message); ?>
            </div>
        <?php endif; ?>

        <div class="form-section">
            <h2>Adicionar Novo Livro</h2>
            <form action="crud.php" method="post">
                <input type="hidden" name="action" value="add">
                <div>
                    <label for="titulo">Título:</label>
                    <input type="text" id="titulo" name="titulo" required>
                </div>
                <div>
                    <label for="autor">Autor:</label>
                    <input type="text" id="autor" name="autor" required>
                </div>
                <div>
                    <label for="ano_publicacao">Ano de Publicação:</label>
                    <input type="number" id="ano_publicacao" name="ano_publicacao" required min="1000" max="<?php echo date('Y'); ?>">
                </div>
                <div>
                    <label for="preco">Preço:</label>
                    <input type="text" id="preco" name="preco" required pattern="^\d+(\.\d{1,2})?$" placeholder="Ex: 99.99">
                    <small>Use ponto como separador decimal.</small>
                </div>
                <button type="submit">Adicionar Livro</button>
            </form>
        </div>

        <div class="table-header-controls">
            <h2>Livros Cadastrados</h2>
            <a href="gerar_pdf.php" class="pdf-button" target="_blank">Gerar PDF da Lista de Livros</a>
        </div>

        <div class="table-section">
            <?php if (empty($livros)): ?>
                <p>Nenhum livro cadastrado ainda.</p>
            <?php else: ?>
                <table>
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Título</th>
                            <th>Autor</th>
                            <th>Ano</th>
                            <th>Preço</th>
                            <th>Ações</th>
                        </tr>
                    </thead>
                    <tbody>
                        <?php foreach ($livros as $livro): ?>
                            <tr>
                                <td><?php echo htmlspecialchars($livro['id']); ?></td>
                                <td><?php echo htmlspecialchars($livro['titulo']); ?></td>
                                <td><?php echo htmlspecialchars($livro['autor']); ?></td>
                                <td><?php echo htmlspecialchars($livro['ano_publicacao']); ?></td>
                                <td>R$ <?php echo number_format($livro['preco'], 2, ',', '.'); ?></td>
                                <td class="action-buttons">
                                    <a href="editar_livro.php?id=<?php echo htmlspecialchars($livro['id']); ?>" class="edit-button">Editar</a>
                                    <a href="crud.php?action=delete&id=<?php echo htmlspecialchars($livro['id']); ?>" class="delete-button" onclick="return confirm('Tem certeza que deseja excluir este livro?');">Excluir</a>
                                </td>
                            </tr>
                        <?php endforeach; ?>
                    </tbody>
                </table>
            <?php endif; ?>
        </div>

    </main>

    <footer>
        <p>&copy; <?php echo date("Y"); ?> Tech_Livro</p>
    </footer>
</body>
</html>