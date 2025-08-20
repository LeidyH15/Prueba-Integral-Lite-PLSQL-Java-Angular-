-- ============================================================
-- Script: 03_datos_semilla.sql
-- Descripción: Inserción de datos semilla para evaluación Reto 03
-- Autor: Leidy Stephania Hernández Varón
-- Fecha: 2025-08-20
-- ============================================================

-- =================================
-- Usuarios (2 registros, 1 por rol)
-- =================================
INSERT INTO Usuario (UsuarioID, Nombre, Correo, Rol)
VALUES (1, 'Leidy Hernández', 'leidy.admin@correo.com', 'ADMIN');

INSERT INTO Usuario (UsuarioID, Nombre, Correo, Rol)
VALUES (2, 'Carlos Ruiz', 'carlos.operador@correo.com', 'OPERADOR');

-- =====================================
-- Comerciantes (5 registros aleatorios)
-- =====================================
INSERT INTO Comerciante (ComercianteID, Nombre, Estado, Municipio, UsuarioID)
VALUES (101, 'Frutas del Valle S.A.S', 'Activo', 'Cali', 1);

INSERT INTO Comerciante (ComercianteID, Nombre, Estado, Municipio, UsuarioID)
VALUES (102, 'Carnes Tolima Ltda', 'Activo', 'Ibagué', 2);

INSERT INTO Comerciante (ComercianteID, Nombre, Estado, Municipio, UsuarioID)
VALUES (103, 'Panadería La Espiga', 'Inactivo', 'Espinal', 1);

INSERT INTO Comerciante (ComercianteID, Nombre, Estado, Municipio, UsuarioID)
VALUES (104, 'Lácteos Andinos', 'Activo', 'Armenia', 2);

INSERT INTO Comerciante (ComercianteID, Nombre, Estado, Municipio, UsuarioID)
VALUES (105, 'Verduras Express', 'Inactivo', 'Neiva', 1);

-- ==================================================================
-- 🏬 Establecimientos (10 registros distribuidos aleatoriamente)
-- ==================================================================

-- Comerciante 101: 3 establecimientos
INSERT INTO Establecimiento (EstablecimientoID, Nombre, ComercianteID, UsuarioID)
VALUES (1001, 'Sucursal Norte', 101, 1);

INSERT INTO Establecimiento (EstablecimientoID, Nombre, ComercianteID, UsuarioID)
VALUES (1002, 'Sucursal Sur', 101, 2);

INSERT INTO Establecimiento (EstablecimientoID, Nombre, ComercianteID, UsuarioID)
VALUES (1003, 'Sucursal Centro', 101, 1);

-- Comerciante 102: 1 establecimiento
INSERT INTO Establecimiento (EstablecimientoID, Nombre, ComercianteID, UsuarioID)
VALUES (1004, 'Punto Ibagué', 102, 2);

-- Comerciante 103: 2 establecimientos
INSERT INTO Establecimiento (EstablecimientoID, Nombre, ComercianteID, UsuarioID)
VALUES (1005, 'Panadería Principal', 103, 1);

INSERT INTO Establecimiento (EstablecimientoID, Nombre, ComercianteID, UsuarioID)
VALUES (1006, 'Sucursal Espinal', 103, 2);

-- Comerciante 104: 3 establecimientos
INSERT INTO Establecimiento (EstablecimientoID, Nombre, ComercianteID, UsuarioID)
VALUES (1007, 'Bodega Armenia', 104, 1);

INSERT INTO Establecimiento (EstablecimientoID, Nombre, ComercianteID, UsuarioID)
VALUES (1008, 'Sucursal Sur', 104, 2);

INSERT INTO Establecimiento (EstablecimientoID, Nombre, ComercianteID, UsuarioID)
VALUES (1009, 'Sucursal Norte', 104, 1);

-- Comerciante 105: 1 establecimiento
INSERT INTO Establecimiento (EstablecimientoID, Nombre, ComercianteID, UsuarioID)
VALUES (1010, 'Punto Neiva', 105, 2);

-- ======================================
-- ✅ Validación rápida
-- ======================================
-- SELECT COUNT(*) FROM Usuario;
-- SELECT COUNT(*) FROM Comerciante;
-- SELECT COUNT(*) FROM Establecimiento;
-- SELECT ComercianteID, COUNT(*) AS TotalEstablecimientos FROM Establecimiento GROUP BY ComercianteID;
