<?php
session_start(); // Inicia a sessão para que ela possa ser destruída

// Destroi todas as variáveis de sessão
$_SESSION = array();

// Se a sessão for usada com cookies, também é necessário invalidar o cookie de sessão.
// Isso garante que a sessão não seja reutilizada.
// Nota: Isso apagará o cookie de sessão e não os outros cookies.
if (ini_get("session.use_cookies")) {
    $params = session_get_cookie_params();
    setcookie(session_name(), '', time() - 42000,
        $params["path"], $params["domain"],
        $params["secure"], $params["httponly"]
    );
}

// Finalmente, destrói a sessão.
session_destroy();

// Redireciona o usuário para a página de login
header("Location: login.php");
exit();
?>