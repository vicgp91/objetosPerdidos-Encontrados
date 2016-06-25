create database OBJETOSPERDIDOS;

use OBJETOSPERDIDOS;


create table USUARIOS
(

USERNAME varchar (50) primary key,
PASS varchar (50),
NOMBRE_COMPLETO varchar (50),
PERFIL varchar(5),
ULTIMO_INGRESO DATETIME,
CORREO_ELECTRONICO VARCHAR (30)
)

select * from USUARIOS