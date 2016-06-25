drop database if exists pull;
create database pull;
	use pull;

create table usuario(
	idUser int primary key auto_increment,
	nomUser varchar(200) not null,
	passUser varchar(200) not null
)engine=innodb;



create table mensajes(
	idMensaje int primary key auto_increment,
	mensaje text not null,
	fecha date not null,
	hora time not null,
	idUser int, foreign key (idUser) references usuario(idUser)
)engine=innodb;
