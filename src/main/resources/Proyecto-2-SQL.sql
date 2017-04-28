DROP DATABASE IF EXISTS uliving;
create database uliving;
use uliving;


create table Aseo(
id_Aseo integer not null primary key,
id_residencia integer not null,
compañia_Aseo varchar(30) not null,
fecha_Inicio_Contrato date not null,
fecha_Final_Contrato date not null,
precio_Aseo integer not null,
constraint id_Residencia foreign key(id_Residencia) references Residencia(id_Residencia)
);

create table Estudiantes(
id_Estudiante integer not null primary key,
id_Asignar_Habitacion integer not null,
nombre varchar(30) not null,
edad integer not null,
telefono integer not null,
carrera varchar(50) not null,
universidad varchar(50) not null,
foreign key(id_Asignar_Habitacion) references Asignar_Habitacion(id_Asignar_Habitacion)
);

create table Asignar_Habitacion(
id_Asignar_Habitacion integer not null primary key,
id_Estudiante integer not null,
id_Habitacion integer not null,
fecha_Asignacion date not null,
fecha_Final_Asignacion date not null,
foreign key(id_Estudiante) references Estudiantes(id_Estudiante),
foreign key(id_Habitacion) references Habitacion(id_Habitacion)
);

create table Habitacion(
id_Habitacion integer not null primary key,
id_Residencia integer not null,
numero_Camas integer not null,
valor_Habitacion integer not null,
foreign key(id_Residencia) references Residencia(id_Residencia)
);

create table Residencia(
id_Residencia integer not null primary key,
propietario varchar(30) not null,
direccion varchar(30) not null,
fecha_Inicio_Contrato date not null,
fecha_Final_Contrato date not null,
numero_Habitacion integer not null
);

create table Proveedores(
id_Proveedores integer not null primary key,
nombre varchar(30) not null,
tipo_proveedor varchar(30) not null,
telefono integer not null
);