create table pessoa(
 
id BIGINT not null auto_increment primary key,
nome varchar(255),
telefone varchar(20),
telcelular varchar(20),
email varchar(255),
rua varchar (255),
cidade varchar(50),
uf char(2),
bairro varchar(50)
cep char(8));
