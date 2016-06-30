CREATE DATABASE OBJETOSPERDIDOS;

USE OBJETOSPERDIDOS;



CREATE TABLE USUARIOS
(

USERNAME varchar (50) primary key,
PASS varchar (50),
NOMBRE_COMPLETO varchar (50),
CEDULA VARCHAR (20),
CELULAR VARCHAR (20),
PERFIL varchar(5),
CORREO_ELECTRONICO VARCHAR (30),
FECHA_REGISTRO DATETIME,
IMAGEN_PERFIL VARCHAR (200)

);


INSERT INTO USUARIOS(username, pass, nombre_completo, cedula, celular, perfil, correo_electronico, fecha_registro, imagen_perfil) 
values ('vicgp91', '123456', 'Vicente González', '9-736-1038', '65593467', '5', 'vicgp_24@hotmail.com', now() , '----');

delete from usuarios where username = 'vicgp91'

select * from usuarios


CREATE TABLE REPORTE (
  ID_REPORTE INT NOT NULL AUTO_INCREMENT,
  TITULO_REPORTE varchar(100) NOT NULL,
  FOTO_REPORTE varchar(200) NOT NULL,
  DESCRIPCION varchar(300) NOT NULL,
  USERNAME varchar (50) NOT NULL,
  ESTADO_REPORTE VARCHAR(5) NOT NULL,
  CEDULA_ENTREGADO VARCHAR (20) NULL,
  FECHA_ENTREGADO datetime NULL,
  CELULAR_CONTACTO VARCHAR (20) NULL,
  CORREO_CONTACTO VARCHAR (50) NULL,
  primary key (ID_REPORTE),
  FOREIGN KEY (USERNAME) REFERENCES USUARIOS(USERNAME)
);



select * from REPORTE where id_reporte =1


