/*COMANDO CREATE DATABASE*/
CREATE DATABASE SCFData;


/* COMANDO USE*/
use scfdata;


/* COMANDOS DE CREATE TABLE*/
create table Funcionario(
codFunc int auto_increment primary key,
nomeFunc varchar(200),
cpfFunc varchar (20),
cnhFunc varchar (20)
);

CREATE TABLE Caminhao (

codVeic int auto_increment primary key,
modVeic varchar (200),
anoVeic varchar (20),
placaVeic varchar (20)
);

CREATE TABLE FuncionarioCaminhao (
atCodFunc int,
atCodVeic int
);

/* COMANDOS ALTER TABLE */

ALTER TABLE FuncionarioCaminhao add constraint fk_funcionario  foreign key (atCodFunc) references Funcionario(codFunc);
ALTER TABLE FuncionarioCaminhao add constraint fk_veiculo  foreign key (atcodVeic) references Caminhao(codVeic);

/* COMANDOS DE SELECT */
select * from Funcionario;
select * from Caminhao;
select * from FuncionarioCaminhao;

/*COMANDOS DROP TABLE */

drop table caminhao;
drop table FuncionarioCaminhao;

