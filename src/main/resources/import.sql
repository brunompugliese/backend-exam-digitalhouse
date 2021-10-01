-- Creando roles de usuario y admin
INSERT INTO ROLES(ID, NOMBRE) VALUES (1, 'ROLE_ADMIN'), (2, 'ROLE_USUARIO');

-- Creando usuarios correspondientes
INSERT INTO USUARIOS(ID, CONTRASENIA, NOMBRE) VALUES (1, 'admin', 'admin'), (2, 'user', 'user');

-- Creando las relaciones
INSERT INTO USUARIO_ROL(ID_USUARIO, ID_ROL) VALUES (1, 1), (2, 2);
