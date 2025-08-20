--RETO 1:
-- Tabla: Usuario
CREATE TABLE Usuario (
    UsuarioID NUMBER PRIMARY KEY,
    Nombre VARCHAR2(100) NOT NULL,
    Correo VARCHAR2(100) UNIQUE NOT NULL,
    Contraseña VARCHAR2(100) NOT NULL,
    Rol VARCHAR2(50) NOT NULL CHECK (Rol IN ('Administrador', 'Auxiliar'))
);

-- Tabla: Comerciante
CREATE TABLE Comerciante (
    ComercianteID NUMBER PRIMARY KEY,
    Nombre_RazonSocial VARCHAR2(150) NOT NULL,
    Municipio VARCHAR2(100) NOT NULL,
    Telefono VARCHAR2(20),
    Correo VARCHAR2(100),
    FechaRegistro DATE DEFAULT SYSDATE,
    Estado VARCHAR2(10) CHECK (Estado IN ('Activo', 'Inactivo')),
    FechaActualizacion DATE,
    UsuarioID NUMBER,
    FOREIGN KEY (UsuarioID) REFERENCES Usuario(UsuarioID)
);

-- Tabla: Establecimiento
CREATE TABLE Establecimiento (
    EstablecimientoID NUMBER PRIMARY KEY,
    Nombre VARCHAR2(150) NOT NULL,
    Ingresos NUMBER(12,2),
    NumEmpleados NUMBER,
    ComercianteID NUMBER NOT NULL,
    FechaActualizacion DATE,
    UsuarioID NUMBER,
    FOREIGN KEY (ComercianteID) REFERENCES Comerciante(ComercianteID),
    FOREIGN KEY (UsuarioID) REFERENCES Usuario(UsuarioID)
);
