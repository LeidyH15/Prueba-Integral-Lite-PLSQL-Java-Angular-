--RETO 2:
-- Trigger para Comerciante
CREATE OR REPLACE TRIGGER trg_auditoria_comerciante
BEFORE UPDATE ON Comerciante
FOR EACH ROW
BEGIN
    :NEW.FechaActualizacion := SYSDATE;
END;
/

-- Trigger para Establecimiento
CREATE OR REPLACE TRIGGER trg_auditoria_establecimiento
BEFORE UPDATE ON Establecimiento
FOR EACH ROW
BEGIN
    :NEW.FechaActualizacion := SYSDATE;
END;
/
