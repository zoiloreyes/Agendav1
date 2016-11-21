CREATE TABLE contacto(
	id_contacto INT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
	nombre VARCHAR(30) NOT NULL,
	apellido VARCHAR(40),
	lugar_trabajo VARCHAR(100),
	telefono VARCHAR(10),
	correo VARCHAR(100),
	imagen VARCHAR(300)
);
