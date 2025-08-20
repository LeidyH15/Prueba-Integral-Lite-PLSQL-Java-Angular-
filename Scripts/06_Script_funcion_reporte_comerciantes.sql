-- ================================================================
-- SCRIPT: FUNCION obtener_comerciantes_activos
-- OBJETIVO: Retornar un cursor referenciado con información detallada
--           de comerciantes activos, incluyendo métricas calculadas
-- AUTORA: Leidy Stephania Hernández Varón
-- FECHA: 2025-08-20
-- ================================================================

-- 🔹 PAQUETE DE DEFINICIÓN
CREATE OR REPLACE PACKAGE pkg_reportes IS

    -- Tipo de registro que representa la estructura del reporte
    TYPE comerciante_rec IS RECORD (
        Nombre              VARCHAR2(150),
        Municipio           VARCHAR2(100),
        Telefono            VARCHAR2(20),
        Correo              VARCHAR2(100),
        FechaRegistro       DATE,
        Estado              VARCHAR2(10),
        CantEstablecimientos NUMBER,
        TotalIngresos       NUMBER(12,2),
        TotalEmpleados      NUMBER
    );

    -- Cursor referenciado que retorna registros del tipo anterior
    TYPE comerciante_cursor IS REF CURSOR RETURN comerciante_rec;

    -- Función principal que retorna el cursor con comerciantes activos
    FUNCTION obtener_comerciantes_activos RETURN comerciante_cursor;

END pkg_reportes;
/
-- ================================================================

-- 🔹 CUERPO DEL PAQUETE
CREATE OR REPLACE PACKAGE BODY pkg_reportes IS

    FUNCTION obtener_comerciantes_activos RETURN comerciante_cursor IS
        c_cursor comerciante_cursor;
    BEGIN
        -- Apertura del cursor con la consulta enriquecida
        OPEN c_cursor FOR
            SELECT
                c.Nombre_RazonSocial,
                c.Municipio,
                c.Telefono,
                c.Correo,
                c.FechaRegistro,
                c.Estado,
                COUNT(e.EstablecimientoID) AS CantEstablecimientos,
                NVL(SUM(e.Ingresos), 0) AS TotalIngresos,
                NVL(SUM(e.NumEmpleados), 0) AS TotalEmpleados
            FROM Comerciante c
            LEFT JOIN Establecimiento e
                ON c.ComercianteID = e.ComercianteID
            WHERE c.Estado = 'Activo'
            GROUP BY
                c.Nombre_RazonSocial,
                c.Municipio,
                c.Telefono,
                c.Correo,
                c.FechaRegistro,
                c.Estado
            ORDER BY COUNT(e.EstablecimientoID) DESC;

        RETURN c_cursor;
    END obtener_comerciantes_activos;

END pkg_reportes;
/
-- ================================================================

-- 🔹 BLOQUE DE PRUEBA OPCIONAL
-- Este bloque permite validar la función desde SQL*Plus o SQL Developer

DECLARE
    v_cursor pkg_reportes.comerciante_cursor;
    v_registro pkg_reportes.comerciante_rec;
BEGIN
    v_cursor := pkg_reportes.obtener_comerciantes_activos;

    LOOP
        FETCH v_cursor INTO v_registro;
        EXIT WHEN v_cursor%NOTFOUND;

        DBMS_OUTPUT.PUT_LINE(
            'Comerciante: ' || v_registro.Nombre ||
            ' | Municipio: ' || v_registro.Municipio ||
            ' | Establecimientos: ' || v_registro.CantEstablecimientos ||
            ' | Ingresos: ' || v_registro.TotalIngresos ||
            ' | Empleados: ' || v_registro.TotalEmpleados
        );
    END LOOP;

    CLOSE v_cursor;
END;
/
-- ================================================================
-- FIN DEL SCRIPT
-- ================================================================
