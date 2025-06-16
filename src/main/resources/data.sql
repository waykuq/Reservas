DROP TABLE IF EXISTS TipoUsuario;
DROP TABLE IF EXISTS Usuario;
DROP TABLE IF EXISTS Administrador;
DROP TABLE IF EXISTS Cliente;
DROP TABLE IF EXISTS Especialista;
DROP TABLE IF EXISTS Especialidad;
DROP TABLE IF EXISTS Disponibilidad;
DROP TABLE IF EXISTS Cita;

-- Tabla TipoUsuario
CREATE TABLE TipoUsuario (
                             id_tipo_usuario INT AUTO_INCREMENT PRIMARY KEY,
                             nombre ENUM('Cliente', 'Administrador', 'Especialista') NOT NULL,
                             estado BOOLEAN DEFAULT TRUE
);

-- Tabla Usuario
CREATE TABLE Usuario (
                         id_usuario INT AUTO_INCREMENT PRIMARY KEY,
                         id_tipo_usuario INT NOT NULL,
                         dni VARCHAR(8) NOT NULL UNIQUE,
                         nombres VARCHAR(50) NOT NULL,
                         apellidos VARCHAR(50) NOT NULL,
                         correo VARCHAR(50) NOT NULL UNIQUE,
                         contraseña VARCHAR(255) NOT NULL,
                         telefono VARCHAR(15),
                         fecha_inscripcion DATE DEFAULT (CURRENT_DATE),
                         estado BOOLEAN DEFAULT TRUE,
                         FOREIGN KEY (id_tipo_usuario) REFERENCES TipoUsuario(id_tipo_usuario) ON DELETE RESTRICT ON UPDATE CASCADE
);

-- Tabla Especialidad
CREATE TABLE Especialidad (
                              id_especialidad INT AUTO_INCREMENT PRIMARY KEY,
                              nombre VARCHAR(100) NOT NULL
);

-- Tabla Cliente
CREATE TABLE Cliente (
                         id_cliente INT AUTO_INCREMENT PRIMARY KEY,
                         id_usuario INT NOT NULL UNIQUE,
                         FOREIGN KEY (id_usuario) REFERENCES Usuario(id_usuario) ON DELETE CASCADE ON UPDATE CASCADE
);

-- Tabla Administrador
CREATE TABLE Administrador (
                               id_admin INT AUTO_INCREMENT PRIMARY KEY,
                               id_usuario INT NOT NULL UNIQUE,
                               FOREIGN KEY (id_usuario) REFERENCES Usuario(id_usuario) ON DELETE CASCADE ON UPDATE CASCADE
);

-- Tabla Especialista
CREATE TABLE Especialista (
                              id_especialista INT AUTO_INCREMENT PRIMARY KEY,
                              id_usuario INT NOT NULL UNIQUE,
                              id_especialidad INT NOT NULL,
                              FOREIGN KEY (id_usuario) REFERENCES Usuario(id_usuario) ON DELETE CASCADE ON UPDATE CASCADE,
                              FOREIGN KEY (id_especialidad) REFERENCES Especialidad(id_especialidad) ON DELETE RESTRICT ON UPDATE CASCADE
);

-- Tabla Disponibilidad
CREATE TABLE Disponibilidad (
                                id_disponibilidad INT AUTO_INCREMENT PRIMARY KEY,
                                id_especialista INT NOT NULL,
                                fecha DATE NOT NULL,
                                hora_inicio TIME NOT NULL,
                                hora_fin TIME NOT NULL,
                                FOREIGN KEY (id_especialista) REFERENCES Especialista(id_especialista) ON DELETE CASCADE ON UPDATE CASCADE
);

-- Tabla Cita
CREATE TABLE Cita (
                      id_cita INT AUTO_INCREMENT PRIMARY KEY,
                      id_cliente INT NOT NULL,
                      id_especialista INT NOT NULL,
                      id_especialidad INT NOT NULL,
                      fecha DATE NOT NULL,
                      hora TIME NOT NULL,
                      nota TEXT,
                      estado ENUM('Programada', 'Reprogramada', 'Completada', 'Cancelada') DEFAULT 'Programada',
                      FOREIGN KEY (id_cliente) REFERENCES Cliente(id_cliente) ON DELETE RESTRICT ON UPDATE CASCADE,
                      FOREIGN KEY (id_especialista) REFERENCES Especialista(id_especialista) ON DELETE RESTRICT ON UPDATE CASCADE,
                      FOREIGN KEY (id_especialidad) REFERENCES Especialidad(id_especialidad) ON DELETE RESTRICT ON UPDATE CASCADE
);

-- -----------------------------------------------------------------------------------------------------------------------------------------
-- DATOS DE PRUEBA

-- Script de datos de prueba para DB_RESERVAS - Consultorio Psicológico
USE DB_RESERVAS;

-- Insertar tipos de usuario
INSERT INTO TipoUsuario (nombre, estado) VALUES
                                             ('Administrador', TRUE),
                                             ('Especialista', TRUE),
                                             ('Cliente', TRUE);

-- Insertar especialidades psicológicas
INSERT INTO Especialidad (nombre) VALUES
                                      ('Psicología Clínica'),
                                      ('Psicología Infantil y Adolescente'),
                                      ('Psicología de Pareja y Familia'),
                                      ('Psicología Organizacional'),
                                      ('Neuropsicología'),
                                      ('Psicología del Deporte'),
                                      ('Terapia Cognitivo-Conductual'),
                                      ('Psicoanálisis');

-- Insertar usuarios (1 Administrador)
INSERT INTO Usuario (id_tipo_usuario, dni, nombres, apellidos, correo, contraseña, telefono, fecha_inscripcion, estado) VALUES
    (1, '12345678', 'Carlos', 'Mendoza García', 'admin@consultorio.com', 'admin123', '987654321', '2024-01-15', TRUE);

-- Insertar usuarios especialistas
INSERT INTO Usuario (id_tipo_usuario, dni, nombres, apellidos, correo, contraseña, telefono, fecha_inscripcion, estado) VALUES
-- Psicología Clínica (3 especialistas)
(2, '23456789', 'María Elena', 'Rodríguez Vásquez', 'mrodriguez@consultorio.com', 'psi123', '987123456', '2024-02-01', TRUE),
(2, '34567890', 'José Antonio', 'Fernández Huamán', 'jfernandez@consultorio.com', 'psi123', '987234567', '2024-02-01', TRUE),
(2, '45678901', 'Ana Lucía', 'Torres Quispe', 'atorres@consultorio.com', 'psi123', '987345678', '2024-02-01', TRUE),

-- Psicología Infantil (2 especialistas)
(2, '56789012', 'Carmen Rosa', 'Morales Chávez', 'cmorales@consultorio.com', 'psi123', '987456789', '2024-02-05', TRUE),
(2, '67890123', 'Luis Miguel', 'Paredes Rojas', 'lparedes@consultorio.com', 'psi123', '987567890', '2024-02-05', TRUE),

-- Psicología de Pareja (2 especialistas)
(2, '78901234', 'Patricia', 'Salazar Medina', 'psalazar@consultorio.com', 'psi123', '987678901', '2024-02-10', TRUE),
(2, '89012345', 'Ricardo', 'Gutierrez Mamani', 'rgutierrez@consultorio.com', 'psi123', '987789012', '2024-02-10', TRUE),

-- Psicología Organizacional (1 especialista)
(2, '90123456', 'Sofía', 'Herrera Ccopa', 'sherrera@consultorio.com', 'psi123', '987890123', '2024-02-15', TRUE),

-- Neuropsicología (2 especialistas)
(2, '01234567', 'Diego', 'Castillo Ponce', 'dcastillo@consultorio.com', 'psi123', '987901234', '2024-02-20', TRUE),
(2, '11234567', 'Verónica', 'Ramírez Apaza', 'vramirez@consultorio.com', 'psi123', '987012345', '2024-02-20', TRUE),

-- Psicología del Deporte (1 especialista)
(2, '21234567', 'Fernando', 'Vargas Soto', 'fvargas@consultorio.com', 'psi123', '987123457', '2024-02-25', TRUE),

-- Terapia Cognitivo-Conductual (2 especialistas)
(2, '31234567', 'Isabella', 'Jiménez Flores', 'ijimenez@consultorio.com', 'psi123', '987234568', '2024-03-01', TRUE),
(2, '41234567', 'Alejandro', 'Ramos Condori', 'aramos@consultorio.com', 'psi123', '987345679', '2024-03-01', TRUE),

-- Psicoanálisis (1 especialista)
(2, '51234567', 'Gabriela', 'Montoya Cruz', 'gmontoya@consultorio.com', 'psi123', '987456780', '2024-03-05', TRUE);

-- Insertar usuarios clientes (20 clientes)
INSERT INTO Usuario (id_tipo_usuario, dni, nombres, apellidos, correo, contraseña, telefono, fecha_inscripcion, estado) VALUES
                                                                                                                            (3, '61234567', 'Andrea', 'López Pérez', 'alopez@email.com', 'cliente123', '987111111', '2024-03-01', TRUE),
                                                                                                                            (3, '71234567', 'Miguel', 'Sánchez García', 'msanchez@email.com', 'cliente123', '987222222', '2024-03-02', TRUE),
                                                                                                                            (3, '81234567', 'Claudia', 'Martínez Rojas', 'cmartinez@email.com', 'cliente123', '987333333', '2024-03-03', TRUE),
                                                                                                                            (3, '91234567', 'Roberto', 'González Quispe', 'rgonzalez@email.com', 'cliente123', '987444444', '2024-03-04', TRUE),
                                                                                                                            (3, '10234567', 'Paola', 'Díaz Huamán', 'pdiaz@email.com', 'cliente123', '987555555', '2024-03-05', TRUE),
                                                                                                                            (3, '20234567', 'Javier', 'Ruiz Mamani', 'jruiz@email.com', 'cliente123', '987666666', '2024-03-06', TRUE),
                                                                                                                            (3, '30234567', 'Melissa', 'Vega Chávez', 'mvega@email.com', 'cliente123', '987777777', '2024-03-07', TRUE),
                                                                                                                            (3, '40234567', 'Daniel', 'Cruz Medina', 'dcruz@email.com', 'cliente123', '987888888', '2024-03-08', TRUE),
                                                                                                                            (3, '50234567', 'Natalia', 'Flores Ccopa', 'nflores@email.com', 'cliente123', '987999999', '2024-03-09', TRUE),
                                                                                                                            (3, '60234567', 'Óscar', 'Moreno Ponce', 'omoreno@email.com', 'cliente123', '987000000', '2024-03-10', TRUE),
                                                                                                                            (3, '70234567', 'Vanessa', 'Ortega Apaza', 'vortega@email.com', 'cliente123', '987111222', '2024-03-11', TRUE),
                                                                                                                            (3, '80234567', 'Raúl', 'Peña Soto', 'rpena@email.com', 'cliente123', '987222333', '2024-03-12', TRUE),
                                                                                                                            (3, '90234567', 'Lorena', 'Aguilar Flores', 'laguilar@email.com', 'cliente123', '987333444', '2024-03-13', TRUE),
                                                                                                                            (3, '11134567', 'Arturo', 'Mendez Condori', 'amendez@email.com', 'cliente123', '987444555', '2024-03-14', TRUE),
                                                                                                                            (3, '22134567', 'Fiorella', 'Campos Cruz', 'fcampos@email.com', 'cliente123', '987555666', '2024-03-15', TRUE),
                                                                                                                            (3, '33134567', 'Marcos', 'Silva Vargas', 'msilva@email.com', 'cliente123', '987666777', '2024-03-16', TRUE),
                                                                                                                            (3, '44134567', 'Karla', 'Romero Jiménez', 'kromero@email.com', 'cliente123', '987777888', '2024-03-17', TRUE),
                                                                                                                            (3, '55134567', 'Sergio', 'Navarro Ramos', 'snavarro@email.com', 'cliente123', '987888999', '2024-03-18', TRUE),
                                                                                                                            (3, '66134567', 'Mónica', 'Heredia Montoya', 'mheredia@email.com', 'cliente123', '987999000', '2024-03-19', TRUE),
                                                                                                                            (3, '77134567', 'Emilio', 'Carrillo López', 'ecarrillo@email.com', 'cliente123', '987000111', '2024-03-20', TRUE);

-- Insertar administrador
INSERT INTO Administrador (id_usuario) VALUES (1);

-- Insertar especialistas con sus especialidades
INSERT INTO Especialista (id_usuario, id_especialidad) VALUES
-- Psicología Clínica
(2, 1), (3, 1), (4, 1),
-- Psicología Infantil
(5, 2), (6, 2),
-- Psicología de Pareja
(7, 3), (8, 3),
-- Psicología Organizacional
(9, 4),
-- Neuropsicología
(10, 5), (11, 5),
-- Psicología del Deporte
(12, 6),
-- Terapia Cognitivo-Conductual
(13, 7), (14, 7),
-- Psicoanálisis
(15, 8);

-- Insertar clientes
INSERT INTO Cliente (id_usuario) VALUES
                                     (16), (17), (18), (19), (20), (21), (22), (23), (24), (25),
                                     (26), (27), (28), (29), (30), (31), (32), (33), (34), (35);

-- Insertar disponibilidades para especialistas (próximos 3 meses, bloques de 1 hora, 9:00-18:00)
-- Especialista 1 (María Elena - Psicología Clínica)
INSERT INTO Disponibilidad (id_especialista, fecha, hora_inicio, hora_fin) VALUES
                                                                               (1, '2024-06-17', '09:00:00', '10:00:00'),
                                                                               (1, '2024-06-17', '10:00:00', '11:00:00'),
                                                                               (1, '2024-06-17', '11:00:00', '12:00:00'),
                                                                               (1, '2024-06-17', '14:00:00', '15:00:00'),
                                                                               (1, '2024-06-17', '15:00:00', '16:00:00'),
                                                                               (1, '2024-06-18', '09:00:00', '10:00:00'),
                                                                               (1, '2024-06-18', '10:00:00', '11:00:00'),
                                                                               (1, '2024-06-18', '16:00:00', '17:00:00'),
                                                                               (1, '2024-06-18', '17:00:00', '18:00:00'),
                                                                               (1, '2024-06-21', '09:00:00', '10:00:00'),
                                                                               (1, '2024-06-21', '11:00:00', '12:00:00'),
                                                                               (1, '2024-06-21', '14:00:00', '15:00:00'),

-- Especialista 2 (José Antonio - Psicología Clínica)
                                                                               (2, '2024-06-17', '14:00:00', '15:00:00'),
                                                                               (2, '2024-06-17', '15:00:00', '16:00:00'),
                                                                               (2, '2024-06-17', '16:00:00', '17:00:00'),
                                                                               (2, '2024-06-19', '09:00:00', '10:00:00'),
                                                                               (2, '2024-06-19', '10:00:00', '11:00:00'),
                                                                               (2, '2024-06-19', '11:00:00', '12:00:00'),
                                                                               (2, '2024-06-20', '14:00:00', '15:00:00'),
                                                                               (2, '2024-06-20', '15:00:00', '16:00:00'),

-- Especialista 4 (Carmen Rosa - Psicología Infantil)
                                                                               (4, '2024-06-18', '09:00:00', '10:00:00'),
                                                                               (4, '2024-06-18', '10:00:00', '11:00:00'),
                                                                               (4, '2024-06-18', '11:00:00', '12:00:00'),
                                                                               (4, '2024-06-19', '14:00:00', '15:00:00'),
                                                                               (4, '2024-06-19', '15:00:00', '16:00:00'),
                                                                               (4, '2024-06-22', '09:00:00', '10:00:00'),
                                                                               (4, '2024-06-22', '10:00:00', '11:00:00'),

-- Especialista 6 (Patricia - Psicología de Pareja)
                                                                               (6, '2024-06-17', '16:00:00', '17:00:00'),
                                                                               (6, '2024-06-17', '17:00:00', '18:00:00'),
                                                                               (6, '2024-06-20', '09:00:00', '10:00:00'),
                                                                               (6, '2024-06-20', '10:00:00', '11:00:00'),
                                                                               (6, '2024-06-21', '15:00:00', '16:00:00'),
                                                                               (6, '2024-06-21', '16:00:00', '17:00:00'),

-- Especialista 9 (Diego - Neuropsicología)
                                                                               (9, '2024-06-19', '09:00:00', '10:00:00'),
                                                                               (9, '2024-06-19', '11:00:00', '12:00:00'),
                                                                               (9, '2024-06-19', '14:00:00', '15:00:00'),
                                                                               (9, '2024-06-22', '09:00:00', '10:00:00'),
                                                                               (9, '2024-06-22', '14:00:00', '15:00:00'),
                                                                               (9, '2024-06-22', '15:00:00', '16:00:00');

-- Insertar citas (solo en horarios donde hay disponibilidad)
INSERT INTO Cita (id_cliente, id_especialista, id_especialidad, fecha, hora, nota, estado) VALUES
-- Citas programadas (60%)
(1, 1, 1, '2024-06-17', '09:00:00', 'Primera consulta por ansiedad', 'Programada'),
(2, 1, 1, '2024-06-17', '10:00:00', 'Seguimiento de terapia', 'Programada'),
(3, 2, 1, '2024-06-17', '14:00:00', 'Evaluación psicológica', 'Programada'),
(4, 4, 2, '2024-06-18', '09:00:00', 'Terapia infantil - problemas de conducta', 'Programada'),
(5, 6, 3, '2024-06-17', '16:00:00', 'Terapia de pareja', 'Programada'),
(6, 9, 5, '2024-06-19', '09:00:00', 'Evaluación neuropsicológica', 'Programada'),
(7, 1, 1, '2024-06-18', '09:00:00', 'Consulta por depresión', 'Programada'),
(8, 2, 1, '2024-06-19', '09:00:00', 'Terapia cognitiva', 'Programada'),
(9, 4, 2, '2024-06-18', '10:00:00', 'Sesión de juego terapéutico', 'Programada'),
(10, 6, 3, '2024-06-20', '09:00:00', 'Comunicación en pareja', 'Programada'),
(11, 1, 1, '2024-06-21', '09:00:00', 'Control de estrés', 'Programada'),
(12, 9, 5, '2024-06-22', '09:00:00', 'Rehabilitación cognitiva', 'Programada'),

-- Citas completadas (25%)
(13, 1, 1, '2024-06-17', '11:00:00', 'Sesión de relajación', 'Completada'),
(14, 2, 1, '2024-06-17', '15:00:00', 'Terapia grupal', 'Completada'),
(15, 4, 2, '2024-06-19', '14:00:00', 'Orientación a padres', 'Completada'),
(16, 6, 3, '2024-06-21', '15:00:00', 'Resolución de conflictos', 'Completada'),
(17, 9, 5, '2024-06-19', '11:00:00', 'Test neuropsicológico', 'Completada'),

-- Citas canceladas (10%)
(18, 1, 1, '2024-06-17', '14:00:00', 'Cancelada por el paciente', 'Cancelada'),
(19, 2, 1, '2024-06-19', '10:00:00', 'Emergencia familiar', 'Cancelada'),

-- Citas reprogramadas (5%)
(20, 4, 2, '2024-06-18', '11:00:00', 'Reprogramada por lluvia', 'Reprogramada');

-- Mostrar resumen de datos insertados
SELECT 'Datos insertados correctamente' AS Resultado;
SELECT COUNT(*) AS 'Total Usuarios' FROM Usuario;
SELECT COUNT(*) AS 'Total Especialistas' FROM Especialista;
SELECT COUNT(*) AS 'Total Clientes' FROM Cliente;
SELECT COUNT(*) AS 'Total Especialidades' FROM Especialidad;
SELECT COUNT(*) AS 'Total Disponibilidades' FROM Disponibilidad;
SELECT COUNT(*) AS 'Total Citas' FROM Cita;
SELECT estado, COUNT(*) AS 'Cantidad' FROM Cita GROUP BY estado;