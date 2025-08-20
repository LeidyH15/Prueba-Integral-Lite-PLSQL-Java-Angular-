--PAQUETE PLSQL
-- Paquete: pkg_comercio
CREATE OR REPLACE PACKAGE pkg_comercio AS
    PROCEDURE registrar_comerciante(
        p_nombre IN VARCHAR2,
        p_municipio IN VARCHAR2,
        p_telefono IN VARCHAR2,
        p_correo IN VARCHAR2,
        p_usuario_id IN NUMBER
    );

    PROCEDURE registrar_establecimiento(
        p_nombre IN VARCHAR2,
        p_ingresos IN NUMBER,
        p_num_empleados IN NUMBER,
        p_comerciante_id IN NUMBER,
        p_usuario_id IN NUMBER
    );
END pkg_comercio;
/

CREATE OR REPLACE PACKAGE BODY pkg_comercio AS

    PROCEDURE registrar_comerciante(
        p_nombre IN VARCHAR2,
        p_municipio IN VARCHAR2,
        p_telefono IN VARCHAR2,
        p_correo IN VARCHAR2,
        p_usuario_id IN NUMBER
    ) IS
    BEGIN
        INSERT INTO Comerciante (
            ComercianteID, Nombre_RazonSocial, Municipio, Telefono, Correo,
            FechaRegistro, Estado, FechaActualizacion, UsuarioID
        ) VALUES (
            Comerciante_seq.NEXTVAL, p_nombre, p_municipio, p_telefono, p_correo,
            SYSDATE, 'Activo', SYSDATE, p_usuario_id
        );
    END;

    PROCEDURE registrar_establecimiento(
        p_nombre IN VARCHAR2,
        p_ingresos IN NUMBER,
        p_num_empleados IN NUMBER,
        p_comerciante_id IN NUMBER,
        p_usuario_id IN NUMBER
    ) IS
    BEGIN
        INSERT INTO Establecimiento (
            EstablecimientoID, Nombre, Ingresos, NumEmpleados,
            ComercianteID, FechaActualizacion, UsuarioID
        ) VALUES (
            Establecimiento_seq.NEXTVAL, p_nombre, p_ingresos, p_num_empleados,
            p_comerciante_id, SYSDATE, p_usuario_id
        );
    END;

END pkg_comercio;
/
