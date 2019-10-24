create database bar;
use bar;

CREATE TABLE enderecos (
    id int not null auto_increment,
    rua varchar(150) not null,
    numero int not null,
    complemento varchar(100),
    cidade varchar(100) not null,
    estado varchar(2) not null,
    cep int not null,
    regiao varchar(12) not null,
    PRIMARY KEY (id)
);

insert into enderecos (rua,numero,complemento,cidade,estado,cep,regiao) values ('Avenida Sem Denominação VinteLoteamento Amazonas','1439','','Macapá','AP','68909697','Norte');
insert into enderecos (rua,numero,complemento,cidade,estado,cep,regiao) values ('1004 Sul Alameda 8','2909','','Palmas','TO','77023520','Norte');
insert into enderecos (rua,numero,complemento,cidade,estado,cep,regiao) values ('Rua Aleixo Bortolotto','964','','Campinas','SP','13065320','Sudeste');
insert into enderecos (rua,numero,complemento,cidade,estado,cep,regiao) values ('Rua Vicente Decara Neto','1317','','São Paulo','SP','05819000','Sudeste');
insert into enderecos (rua,numero,complemento,cidade,estado,cep,regiao) values ('Rua Maceió','273','','Salvador','BA','40800400','Nordeste');
insert into enderecos (rua,numero,complemento,cidade,estado,cep,regiao) values ('Rua Mário Lúcio Costa','1051','','Barbacena','MG','36201484','Sudeste');
insert into enderecos (rua,numero,complemento,cidade,estado,cep,regiao) values ('Rua São João','1858','','Sinop','MT','78559138','Centro-Oeste');
insert into enderecos (rua,numero,complemento,cidade,estado,cep,regiao) values ('Rua Doze','668','','Rio de Janeiro','RJ','21863560','Sudeste');
insert into enderecos (rua,numero,complemento,cidade,estado,cep,regiao) values ('Rua Antônio Jorge Cecyn','3393','','Joinville','SC','89226260','Sul');
insert into enderecos (rua,numero,complemento,cidade,estado,cep,regiao) values ('QE 7 Bloco K','1088','','Brasília','DF','71020117','Centro-Oeste');
insert into enderecos (rua,numero,complemento,cidade,estado,cep,regiao) values ('Avenida Sete de Setembro','2164','de 2592 a 2806 - lado par','Cacoal','RO','76964094','Norte');
insert into enderecos (rua,numero,complemento,cidade,estado,cep,regiao) values ('Rua dos Canários','495','','Serra','ES','29168470','Sudeste');
insert into enderecos (rua,numero,complemento,cidade,estado,cep,regiao) values ('Rua Tomé de Souza','1951','','Paulo Afonso','BA','48603390','Nordeste');
insert into enderecos (rua,numero,complemento,cidade,estado,cep,regiao) values ('Rua Hélio Heleno Júnior','2238','','Cachoeiro de Itapemirim','ES','29301380','Sudeste');
insert into enderecos (rua,numero,complemento,cidade,estado,cep,regiao) values ('Estrada Rio Santa Maria do Rio Doce','3248','','Colatina','ES','29702775','Sudeste');
insert into enderecos (rua,numero,complemento,cidade,estado,cep,regiao) values ('Rua Rádio Novo Tempo','1075','','São Lourenço da Mata','PE','54727020','Nordeste');
insert into enderecos (rua,numero,complemento,cidade,estado,cep,regiao) values ('Rua Odilon Nunes','3791','lado par','Teresina','PI','64028520','Nordeste');
insert into enderecos (rua,numero,complemento,cidade,estado,cep,regiao) values ('Avenida Paulo Sérgio','3162','(Lot. Sol Nascente)','Macapá','AP','68909131','Norte');
insert into enderecos (rua,numero,complemento,cidade,estado,cep,regiao) values ('Rua Raul Pires Barbosa','3454','até 749/750','Campo Grande','MS','79040150','Centro-Oeste');
insert into enderecos (rua,numero,complemento,cidade,estado,cep,regiao) values ('Rua Joaquim Gonçalves','2665','','Limeira','SP','13481531','Sudeste');
insert into enderecos (rua,numero,complemento,cidade,estado,cep,regiao) values ('Estrada Caxumba','64','','Teresópolis','RJ','25980300','Sudeste');
insert into enderecos (rua,numero,complemento,cidade,estado,cep,regiao) values ('Avenida Paraíba','1373','','Macapá','AP','68908280','Norte');
insert into enderecos (rua,numero,complemento,cidade,estado,cep,regiao) values ('Rua Evangélica','2224','','Cariacica','ES','29155352','8');

CREATE TABLE filiais (
    id int not null auto_increment,
    nome varchar(100),
    id_endereco int,
    PRIMARY KEY (id),
    foreign key (id_endereco) references enderecos(id)
);

insert into filiais(nome, id_endereco) values ('Palmeirinha','2');
insert into filiais(nome, id_endereco) values ('Campinho','3');
insert into filiais(nome, id_endereco) values ('Paulista','4');
insert into filiais(nome, id_endereco) values ('Salvo','5');
insert into filiais(nome, id_endereco) values ('Bar do Sinop','7');
insert into filiais(nome, id_endereco) values ('Cantinho','9');

CREATE TABLE usuarios (
    id int not null auto_increment,
    email varchar(100),
    sexo varchar(1),
    senha varchar(50),
    nome varchar(100),
    id_filial int,
    cargo int,
    PRIMARY KEY (id),
    foreign key(id_filial) references filiais(id)
);

insert into usuarios(email, sexo, senha, nome, id_filial, cargo) values('vitor.santos@gmail,com','M','123456','Vitor Luiz','1','1');
insert into usuarios(email, sexo, senha, nome, id_filial, cargo) values('','F','123456','Victoria','2','1');
insert into usuarios(email, sexo, senha, nome, id_filial, cargo) values('','F','123456','Milena','3','1');
insert into usuarios(email, sexo, senha, nome, id_filial, cargo) values('','M','123456','Yago','4','1');
insert into usuarios(email, sexo, senha, nome, id_filial, cargo) values('matheus.j.m@live.com','M','123456','Matheus','5','1');

CREATE TABLE fornecedores (
    id int not null auto_increment,
    nome_fantasia varchar(150),
    nome_empresarial varchar(150),
    id_endereco int,
    PRIMARY KEY (id),
    foreign key  (id_endereco) references enderecos(id)
);

insert into fornecedores(nome_fantasia, nome_empresarial, id_endereco) values ('Atacadão','Atacadão SA',6);
insert into fornecedores(nome_fantasia, nome_empresarial, id_endereco) values ('Carrefour','Carrefour SA',12);
insert into fornecedores(nome_fantasia, nome_empresarial, id_endereco) values ('Extra','Extra SA',10);

CREATE TABLE categorias(
    id int not null auto_increment,
    nome varchar(100),
    enabled boolean,
    PRIMARY key(id)
);

insert into categorias(nome) values ('Bebida Alcoólica');
insert into categorias(nome) values ('Bebida Não Alcoólica');
insert into categorias(nome) values ('Porções');
insert into categorias(nome) values ('Pratos');

CREATE TABLE produtos (
    id int not null auto_increment,
    nome varchar(100) not null,
    id_categoria int not null,
    tamanho varchar(100),
    sabor varchar(100),
    preco_venda double,
    enabled boolean,
    PRIMARY KEY (id),
    foreign key  (id_categoria) references categorias(id)
);

insert into produtos(nome, id_categoria, tamanho, sabor, preco_venda, enabled) values ('Coca-Cola',2,'Lata - 330ml','Normal',3.0,1);
insert into produtos(nome, id_categoria, tamanho, sabor, preco_venda, enabled) values ('Coca-Cola',2,'Lata - 330ml','Diet',3.1,1);
insert into produtos(nome, id_categoria, tamanho, sabor, preco_venda, enabled) values ('Coca-Cola',2,'Lata - 330ml','Zero',3.2,1);
insert into produtos(nome, id_categoria, tamanho, sabor, preco_venda, enabled) values ('Coca-Cola',2,'Garrafa - 660ml','Normal',3.4,1);
insert into produtos(nome, id_categoria, tamanho, sabor, preco_venda, enabled) values ('Coca-Cola',2,'Garrafa - 660ml','Zero',3.5,1);
insert into produtos(nome, id_categoria, tamanho, sabor, preco_venda, enabled) values ('Corona',1,'Garrafa - 350ml','',5,1);
insert into produtos(nome, id_categoria, tamanho, sabor, preco_venda, enabled) values ('Original',1,'Garrafa - 600ml','',6,1);
insert into produtos(nome, id_categoria, tamanho, sabor, preco_venda, enabled) values ('Batata-Frita',3,'Pequena','Normal',12,1);
insert into produtos(nome, id_categoria, tamanho, sabor, preco_venda, enabled) values ('Batata-Frita',3,'Pequena','Chedar e Bacon',15,1);
insert into produtos(nome, id_categoria, tamanho, sabor, preco_venda, enabled) values ('Batata-Frita',3,'Média','Normal',20,1);
insert into produtos(nome, id_categoria, tamanho, sabor, preco_venda, enabled) values ('Batata-Frita',3,'Média','Chedar e Bacon',22,1);

CREATE TABLE vendas (
    id int not null auto_increment,
    id_usuario int,
    id_filial int not null,
    tipo_pagamento varchar(50) not null,
    PRIMARY KEY (id),
    foreign key (id_usuario) references usuarios(id),
    foreign key (id_filial) references filiais(id)
);
CREATE TABLE produtos_vendas (
    id int not null auto_increment,
    id_venda int not null,
    id_produto int not null,
    qtde int not null,
    valor_unidade double not null,
    PRIMARY KEY (id),
    foreign key  (id_venda) references vendas(id),
    foreign key  (id_produto) references produtos(id)
);

CREATE TABLE compras_produtos (
    id int not null auto_increment,
    id_fornecedor int not null,
    id_usuario int not null,
    PRIMARY KEY (id),
    foreign key (id_fornecedor) references fornecedores(id),
    foreign key (id_usuario) references usuarios(id)
);
CREATE TABLE compras_produtos_produtos(
    id int not null auto_increment,
    id_compra_produto int,
    id_produto int,
    qtde int not null,
    valor_unidade double not null,
    PRIMARY key(id),
    foreign key (id_compra_produto) references compras_produtos(id),
    foreign key (id_produto) references produtos(id)
);
CREATE TABLE clientes (
    id int not null auto_increment,
    nome varchar(50),
    telefone varchar(50),
    dt_nascimento date,
    PRIMARY KEY (id)
);
insert into clientes(nome, telefone, dt_nascimento) values ('Milena',  12345678, 02/11/1997);
insert into clientes(nome, telefone, dt_nascimento) values ('Matheus', 12345678, 17/10/1995);
insert into clientes(nome, telefone, dt_nascimento) values ('Vitor',   12345678, 01/01/1996);
insert into clientes(nome, telefone, dt_nascimento) values ('Vitoria', 12345678, 02/10/1998);

CREATE TABLE comandas (
    id int not null auto_increment,
    id_venda int,
    id_cliente int,
    PRIMARY KEY (id),
    foreign key (id_venda) references vendas(id),
    foreign key (id_cliente) references clientes(id)
);