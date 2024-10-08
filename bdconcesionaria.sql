CREATE DATABASE bdconcesionaria;
USE bdconcesionaria;

-- Tabla Cliente
CREATE TABLE cliente (
    idcliente INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    correo VARCHAR(100) NOT NULL,
    telefono VARCHAR(15)
);

-- Tabla Vehiculo
CREATE TABLE vehiculo (
    idvehiculo INT AUTO_INCREMENT PRIMARY KEY,
    marca VARCHAR(100) NOT NULL,
    modelo VARCHAR(100) NOT NULL,
    anio INT NOT NULL,
    precio DECIMAL(10,2) NOT NULL
);

-- Tabla Venta
CREATE TABLE venta (
    idventa INT AUTO_INCREMENT PRIMARY KEY,
    fecha DATE NOT NULL,
    idcliente INT,
    idvehiculo INT,
    montototal DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (idcliente) REFERENCES cliente(idcliente),
    FOREIGN KEY (idvehiculo) REFERENCES vehiculo(idvehiculo)
);

-- Tabla Empleado
CREATE TABLE empleado (
    idempleado INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    puesto VARCHAR(100) NOT NULL,
    sueldo DECIMAL(10,2) NOT NULL
);

-- Tabla Servicio
CREATE TABLE servicio (
    idservicio INT AUTO_INCREMENT PRIMARY KEY,
    tiposervicio VARCHAR(100) NOT NULL,
    precio DECIMAL(10,2) NOT NULL
);

-- Insertar datos en la tabla Cliente
INSERT INTO cliente (nombre, apellido, correo, telefono) VALUES
('Juan', 'Pérez', 'juan.perez@mail.com', '555-1234'),
('Ana', 'González', 'ana.gonzalez@mail.com', '555-5678'),
('Luis', 'Ramírez', 'luis.ramirez@mail.com', '555-8765');

-- Insertar datos en la tabla Vehiculo
INSERT INTO vehiculo (marca, modelo, anio, precio) VALUES
('Toyota', 'Corolla', 2021, 20000.00),
('Honda', 'Civic', 2020, 22000.00),
('Ford', 'Mustang', 2019, 30000.00);

-- Insertar datos en la tabla Venta
INSERT INTO venta (fecha, idcliente, idvehiculo, montototal) VALUES
('2024-10-01', 1, 1, 20000.00),
('2024-10-02', 2, 2, 22000.00),
('2024-10-03', 3, 3, 30000.00);

-- Insertar datos en la tabla Empleado
INSERT INTO empleado (nombre, puesto, sueldo) VALUES
('Carlos', 'Vendedor', 1500.00),
('Marta', 'Gerente', 2500.00),
('Raúl', 'Mecánico', 1800.00);

-- Insertar datos en la tabla Servicio
INSERT INTO servicio (tiposervicio, precio) VALUES
('Cambio de Aceite', 50.00),
('Alineación y Balanceo', 100.00),
('Revisión General', 150.00);

DROP DATABASE bdconcesionaria;