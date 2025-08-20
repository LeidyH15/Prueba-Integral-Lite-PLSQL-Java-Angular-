-- FECHA: 20 DE AGOSTO 2025
-- Prueba Integral Lite (PLSQL-Java-Angular)
--DATOS DE PRUEBA:

-- Usuarios
INSERT INTO Usuario (UsuarioID, Nombre, Correo) VALUES (1, 'Leidy Hernández', 'leidy.h@correo.com');
INSERT INTO Usuario (UsuarioID, Nombre, Correo) VALUES (2, 'Carlos Ruiz', 'carlos.ruiz@correo.com');

-- Comerciantes
INSERT INTO Comerciante (ComercianteID, Nombre, Estado, Municipio, UsuarioID) 
VALUES (101, 'Comercial Ruiz S.A.S', 'Activo', 'Ibagué', 1);

INSERT INTO Comerciante (ComercianteID, Nombre, Estado, Municipio, UsuarioID) 
VALUES (102, 'Distribuciones Tolima', 'Inactivo', 'Espinal', 2);

-- Establecimientos
INSERT INTO Establecimiento (EstablecimientoID, Nombre, ComercianteID, UsuarioID) 
VALUES (1001, 'Punto Norte', 101, 1);

INSERT INTO Establecimiento (EstablecimientoID, Nombre, ComercianteID, UsuarioID) 
VALUES (1002, 'Sucursal Centro', 101, 2);

INSERT INTO Establecimiento (EstablecimientoID, Nombre, ComercianteID, UsuarioID) 
VALUES (1003, 'Bodega Espinal', 102, 2);
