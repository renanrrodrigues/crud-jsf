insert into dominio (id, nome) values (1, 'Banco de Dados');
insert into dominio (id, nome) values (2, 'LDAP');

insert into usuario (id, nome, login, senha, dominio_id, ultimoAcesso) values (1, 'Cal Lightman', 'cal', '123', 1, current_timestamp);
insert into usuario (id, nome, login, senha, dominio_id, ultimoAcesso) values (2, 'Gillian Foster', 'gillian', '123', 1, current_timestamp);
insert into usuario (id, nome, login, senha, dominio_id, ultimoAcesso) values (3, 'Ria Torres', 'ria', '123', 1, current_timestamp);
insert into usuario (id, nome, login, senha, dominio_id, ultimoAcesso) values (4, 'Eli Locker', 'eli', '123', 1, current_timestamp);
insert into usuario (id, nome, login, senha, dominio_id, ultimoAcesso) values (5, 'Emily Lightman', 'emily', '123', 1, current_timestamp);

insert into configuracao (id, usuario_id, recebernotificacoes, encerrarsessaoautomaticamente) values (1, 1, 'ldap://localhost:10389');


insert into usuario (id, nome, login, senha, ultimoAcesso) values (1, 'Cal Lightman', 'cal', '123', current_timestamp);
insert into usuario (id, nome, login, senha, ultimoAcesso) values (2, 'Gillian Foster', 'gillian', '123', current_timestamp);
insert into usuario (id, nome, login, senha, ultimoAcesso) values (3, 'Ria Torres', 'ria', '123', current_timestamp);
insert into usuario (id, nome, login, senha, ultimoAcesso) values (4, 'Eli Locker', 'eli', '123', current_timestamp);
insert into usuario (id, nome, login, senha, ultimoAcesso) values (5, 'Emily Lightman', 'emily', '123', current_timestamp);