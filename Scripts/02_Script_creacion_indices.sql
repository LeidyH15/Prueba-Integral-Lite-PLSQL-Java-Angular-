--Scripts Incides
-- Índice para búsqueda rápida por correo en Usuario
CREATE INDEX idx_usuario_correo ON Usuario(Correo);

-- Índice para búsqueda por estado en Comerciante
CREATE INDEX idx_comerciante_estado ON Comerciante(Estado);

-- Índice para búsqueda por municipio en Comerciante
CREATE INDEX idx_comerciante_municipio ON Comerciante(Municipio);

-- Índice para búsqueda por ComercianteID en Establecimiento (FK)
CREATE INDEX idx_establecimiento_comerciante ON Establecimiento(ComercianteID);

-- Índice para búsqueda por UsuarioID en Comerciante (auditoría)
CREATE INDEX idx_comerciante_usuario ON Comerciante(UsuarioID);

-- Índice para búsqueda por UsuarioID en Establecimiento (auditoría)
CREATE INDEX idx_establecimiento_usuario ON Establecimiento(UsuarioID);
