create database Projeto_PHP;
use cadastro;

create table usuario(id int auto_increment primary key,
user varchar(100) not null unique,
senha varchar(255) not null);

insert into usuario values(null, 'root','root'),(null,'admin','admin');