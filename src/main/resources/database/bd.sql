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
	id_user int not null auto_increment primary key,
	username VARCHAR(50) Not Null,
	password VARCHAR(50) NOT NULL,
    token varchar(200)
);

INSERT INTO Hotel (nombre, descripcion, categoria, piscina, localidad)
VALUES 
('Hotel Sol', 'Hotel de playa con vistas al mar', '4 estrellas', true, 'Málaga'),
('Hotel Sierra', 'Hotel rural en plena montaña', '3 estrellas', false, 'Granada'),
('Hotel Urbano', 'Hotel moderno en el centro de la ciudad', '5 estrellas', true, 'Madrid'),
('Hotel Relax', 'Hotel boutique ideal para desconectar', '4 estrellas', false, 'Valencia'),
('Hotel Aventura', 'Hotel para amantes del deporte y la naturaleza', '3 estrellas', true, 'Bilbao');

INSERT INTO Habitacion (tamanio, precio_noche, desayuno, ocupada, id_hotel)
VALUES 
(1, 100.50, true, false, 1), -- Habitación en "Hotel Sol"
(2, 150.75, true, true, 1),
(1, 80.00, false, false, 2), -- Habitación en "Hotel Sierra"
(2, 50.00, false, true, 2),
(1, 200.00, true, false, 3), -- Habitación en "Hotel Urbano"
(2, 180.00, true, true, 3),
(1, 90.00, false, false, 4), -- Habitación en "Hotel Relax"
(2, 120.00, true, true, 4),
(1, 110.00, false, false, 5), -- Habitación en "Hotel Aventura"
(2, 130.00, true, true, 5);

INSERT INTO USER(username, password) VALUES ('juan', 'juan');
