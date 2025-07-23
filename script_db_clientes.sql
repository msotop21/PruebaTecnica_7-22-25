CREATE TABLE cliente (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    telefono VARCHAR(20),
    email VARCHAR(150) NOT NULL
);

CREATE TABLE direccion (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    calle VARCHAR(150),
    ciudad VARCHAR(100),
    pais VARCHAR(100),
    cliente_id BIGINT,
    CONSTRAINT fk_cliente FOREIGN KEY (cliente_id) REFERENCES cliente(id)
        ON DELETE CASCADE
);

INSERT INTO cliente (nombre, telefono,email) VALUES ('Carlos Pérez', '8096952121','carlos@empresa.com');

INSERT INTO direccion (calle, ciudad, pais, cliente_id)
VALUES 
  ('Calle 123', 'Santo Domingo', 'República Dominicana', 1),
  ('Av. Republica de Colombia 54', 'Santo Domingo Norte', 'República Dominicana', 1);