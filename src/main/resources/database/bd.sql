DROP DATABASE IF EXISTS hotelapi;
CREATE DATABASE hotelapi;
USE hotelapi;
CREATE TABLE Hotel (
	id_hotel int not null auto_increment primary key,
	nombre varchar(50) not null,
	descripcion varchar(50) not null,
	categoria varchar(50) not null,
	piscina boolean not null,
	localidad varchar(50) not null
);
CREATE TABLE Habitacion (
	id_habitacion int not null auto_increment primary key,
	tamanio int not null,
	precio_noche double not null,
	desayuno boolean not null,
	ocupada boolean not null,
	id_hotel int not null,
	FOREIGN KEY (id_hotel) REFERENCES Hotel(id_hotel) ON DELETE CASCADE
);
CREATE TABLE USER(
                     username VARCHAR(50) PRIMARY KEY,
                     password VARCHAR(50) NOT NULL
);

INSERT INTO USER(username, password) VALUES ('juan', 'juan');
