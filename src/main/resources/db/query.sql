create database db_jpa;

drop table if exists nivel;
drop table if exists coluna;
drop table if exists rua;
drop table if exists produto;
drop table if exists categoria;




select * from rua;
select * from coluna;
select * from nivel;
select * from categoria;
select * from produto;

insert into rua (id, nome) values (1, 'Rua 1A');

insert into categoria (id, nome) values (1, 'Categoria 1');

insert into produto (id, nome, categoria_id) values (1, 'Produto 1', 1);


-- inserindo dados para testar
insert into rua (id, nome) values ('1A');




