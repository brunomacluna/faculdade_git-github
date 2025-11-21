-- Limpar tabelas (opcional - apenas para desenvolvimento)
DELETE FROM pergunta_palavra_chave;
DELETE FROM palavra_chave;
DELETE FROM resposta;
DELETE FROM pergunta;
DELETE FROM usuario;

-- Inserir usuários de teste
INSERT INTO usuario (email, nome, senha) VALUES
('admin@teste.com', 'Administrador', '123456'),
('usuario@teste.com', 'Usuário Comum', '123456'),
('joao@email.com', 'João Silva', 'senha123');

-- Inserir perguntas iniciais
INSERT INTO pergunta (id, texto, apagada) VALUES
(1, 'Qual é a capital do Brasil?', false),
(2, 'Como funciona o Spring Boot?', false),
(3, 'O que é JWT?', false);

-- Inserir palavras-chave
INSERT INTO palavra_chave (palavra_chave) VALUES
('geografia'),
('capital'),
('programação'),
('spring'),
('segurança'),
('jwt'),
('java');

-- Associar perguntas com palavras-chave
INSERT INTO pergunta_palavra_chave (pergunta_id, palavra_chave_id) VALUES
(1, 'geografia'),
(1, 'capital'),
(2, 'programação'),
(2, 'spring'),
(2, 'java'),
(3, 'segurança'),
(3, 'jwt'),
(3, 'programação');

-- Inserir respostas iniciais
INSERT INTO resposta (id, texto, apagada, id_pergunta) VALUES
(1, 'A capital do Brasil é Brasília', false, 1),
(2, 'Spring Boot é um framework Java para criar aplicações standalone', false, 2),
(3, 'JWT significa JSON Web Token e é usado para autenticação', false, 3);