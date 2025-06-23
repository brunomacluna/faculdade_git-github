create database tech_livro;

use tech_livro;

create table usuarios (
    id int auto_increment primary key,
    username varchar(50) not null unique,
    senha varchar(255) not null
);

create table livros (
    id int auto_increment primary key,
    autor varchar(100) not null,
    titulo varchar(255) not null,
    preco decimal(10, 2) not null
);

alter table livros
add column ano_publicacao int;