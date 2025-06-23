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
$livro = null; // Variável para armazenar os dados do livro a ser editado

// --- Lógica para CARREGAR os dados do livro ---
if (isset($_GET['id']) && is_numeric($_GET['id'])) {
    $id = (int)$_GET['id'];
    try {
        $stmt = $pdo->prepare("SELECT id, titulo, autor, ano_publicacao, preco FROM livros WHERE id = :id");
        $stmt->bindParam(':id', $id);
        $stmt->execute();
        $livro = $stmt->fetch(PDO::FETCH_ASSOC);

        if (!$livro) {
            $message = "Livro não encontrado.";
            $message_type = 'error';
        }
    } catch (PDOException $e) {
        $message = "Erro ao carregar livro: " . $e->getMessage();
        $message_type = 'error';
    }
} else if ($_SERVER['REQUEST_METHOD'] !== 'POST') {
    // Se não há ID na URL e não é um POST (primeiro acesso sem ID), redireciona
    header("Location: crud.php");
    exit();
}


// --- Lógica para ATUALIZAR Livro ---
if ($_SERVER['REQUEST_METHOD'] === 'POST' && isset($_POST['action']) && $_POST['action'] === 'update') {
    $id = (int)$_POST['id'];
    $titulo = trim($_POST['titulo']);
    $autor = trim($_POST['autor']);
    $ano_publicacao = (int)$_POST['ano_publicacao'];
    $preco = (float)str_replace(',', '.', $_POST['preco']);

    if (empty($titulo) || empty($autor) || empty($ano_publicacao) || empty($preco)) {
        $message = "Por favor, preencha todos os campos para atualizar o livro.";
        $message_type = 'error';
        // Recarrega o livro com os dados enviados para manter o formulário preenchido
        $livro = ['id' => $id, 'titulo' => $titulo, 'autor' => $autor, 'ano_publicacao' => $ano_publicacao, 'preco' => $preco];
    } else {
        try {
            $stmt = $pdo->prepare("UPDATE livros SET titulo = :titulo, autor = :autor, ano_publicacao = :ano_publicacao, preco = :preco WHERE id = :id");
            $stmt->bindParam(':titulo', $titulo);
            $stmt->bindParam(':autor', $autor);
            $stmt->bindParam(':ano_publicacao', $ano_publicacao);
            $stmt->bindParam(':preco', $preco);
            $stmt->bindParam(':id', $id);

            if ($stmt->execute()) {
                $message = "Livro '$titulo' atualizado com sucesso!";
                $message_type = 'success';
                // Após a atualização, recarrega os dados do livro para o formulário
                $stmt = $pdo->prepare("SELECT id, titulo, autor, ano_publicacao, preco FROM livros WHERE id = :id");
                $stmt->bindParam(':id', $id);
                $stmt->execute();
                $livro = $stmt->fetch(PDO::FETCH_ASSOC);
            } else {
                $message = "Erro ao atualizar o livro.";
                $message_type = 'error';
            }
        } catch (PDOException $e) {
            $message = "Erro no banco de dados ao atualizar: " . $e->getMessage();
            $message_type = 'error';
        }
    }
}

// Se o livro ainda não foi carregado (e não é um POST de erro de validação), e o ID existe
if (!$livro && isset($id)) {
    // Tenta carregar novamente caso seja um erro de submissão do formulário
    try {
        $stmt = $pdo->prepare("SELECT id, titulo, autor, ano_publicacao, preco FROM livros WHERE id = :id");
        $stmt->bindParam(':id', $id);
        $stmt->execute();
        $livro = $stmt->fetch(PDO::FETCH_ASSOC);
    } catch (PDOException $e) {
        // Ignora, a mensagem de erro já foi definida ou será definida.
    }
}

?>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Editar Livro - Tech_Livro</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <header>
        <h1>Tech_Livro - Editar Livro</h1>
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

        <div class="edit-form-section">
            <?php if ($livro): ?>
                <h2>Editando Livro: <?php echo htmlspecialchars($livro['titulo']); ?></h2>
                <form action="editar_livro.php" method="post">
                    <input type="hidden" name="action" value="update">
                    <input type="hidden" name="id" value="<?php echo htmlspecialchars($livro['id']); ?>">
                    <div>
                        <label for="titulo">Título:</label>
                        <input type="text" id="titulo" name="titulo" value="<?php echo htmlspecialchars($livro['titulo']); ?>" required>
                    </div>
                    <div>
                        <label for="autor">Autor:</label>
                        <input type="text" id="autor" name="autor" value="<?php echo htmlspecialchars($livro['autor']); ?>" required>
                    </div>
                    <div>
                        <label for="ano_publicacao">Ano de Publicação:</label>
                        <input type="number" id="ano_publicacao" name="ano_publicacao" value="<?php echo htmlspecialchars($livro['ano_publicacao']); ?>" required min="1000" max="<?php echo date('Y'); ?>">
                    </div>
                    <div>
                        <label for="preco">Preço:</label>
                        <input type="text" id="preco" name="preco" value="<?php echo htmlspecialchars(str_replace('.', ',', $livro['preco'])); ?>" required pattern="^\d+([,\.]\d{1,2})?$" placeholder="Ex: 99,99">
                        <small>Use vírgula ou ponto como separador decimal.</small>
                    </div>
                    <div class="form-actions">
                        <a href="crud.php" class="button back-button-styled">Voltar</a> <button type="submit" class="save-button">Salvar Alterações</button>
                    </div>
                </form>
            <?php else: ?>
                <p>Nenhum livro selecionado para edição ou livro não encontrado.</p>
                <div class="form-actions" style="justify-content: center;"> <a href="crud.php" class="button back-button-styled">Voltar</a>
                </div>
            <?php endif; ?>
        </div>
    </main>

    <footer>
        <p>&copy; <?php echo date("Y"); ?> Tech_Livro</p>
    </footer>
</body>
</html>