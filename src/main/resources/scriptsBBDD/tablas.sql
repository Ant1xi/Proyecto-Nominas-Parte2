CREATE TABLE Empleados (
    dni VARCHAR(9) PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    sexo CHAR(1) NOT NULL CHECK (sexo IN ('M','F')),
    categoria INT NOT NULL CHECK (categoria BETWEEN 1 AND 10),
    anyos INT NOT NULL CHECK (anyos >= 0 AND anyos <= 99)
);

CREATE TABLE Nominas (
    id_nomina INT AUTO_INCREMENT PRIMARY KEY,
    dni VARCHAR(9),
    sueldo DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (dni) REFERENCES Empleados(dni)
);
