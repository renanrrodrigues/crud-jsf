create database db_jpa;

select * from rua;
select * from coluna;
select * from nivel;
select * from sequencia;
select * from categoria;
select * from produto;

insert into rua (id, nome) values (1, 'Rua 1A');

insert into coluna (id, rua_id) values (1, 1);

insert into nivel (id, coluna_id, rua_id) values (1, 1, 1);

insert into sequencia (id, coluna_id, nivel_id, rua_id) values (1, 1, 1, 1);

insert into categoria (id, nome) values (1, 'Categoria 1');

insert into produto (id, nome, categoria_id) values (1, 'Produto 1', 1);


-- inserindo dados para testar
insert into rua (id, nome) values ('1A');




