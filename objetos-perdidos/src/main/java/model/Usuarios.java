package model;
// Generated 25-jun-2016 11:56:38 by Hibernate Tools 4.3.1


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Usuarios generated by hbm2java
 */
@Entity
@Table(name="usuarios"
    ,catalog="objetosperdidos"
)
public class Usuarios  implements java.io.Serializable {


     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
     private String pass;
     private String nombreCompleto;
     private String perfil;
     private Date ultimoIngreso;
     private String correoElectronico;

    public Usuarios() {
    }

	
    public Usuarios(String username) {
        this.username = username;
    }
    public Usuarios(String username, String pass, String nombreCompleto, String perfil, Date ultimoIngreso, String correoElectronico) {
       this.username = username;
       this.pass = pass;
       this.nombreCompleto = nombreCompleto;
       this.perfil = perfil;
       this.ultimoIngreso = ultimoIngreso;
       this.correoElectronico = correoElectronico;
    }
   
     @Id 

    
    @Column(name="USERNAME", unique=true, nullable=false, length=50)
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }

    
    @Column(name="PASS", length=50)
    public String getPass() {
        return this.pass;
    }
    
    public void setPass(String pass) {
        this.pass = pass;
    }

    
    @Column(name="NOMBRE_COMPLETO", length=50)
    public String getNombreCompleto() {
        return this.nombreCompleto;
    }
    
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    
    @Column(name="PERFIL", length=5)
    public String getPerfil() {
        return this.perfil;
    }
    
    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="ULTIMO_INGRESO", length=19)
    public Date getUltimoIngreso() {
        return this.ultimoIngreso;
    }
    
    public void setUltimoIngreso(Date ultimoIngreso) {
        this.ultimoIngreso = ultimoIngreso;
    }

    
    @Column(name="CORREO_ELECTRONICO", length=30)
    public String getCorreoElectronico() {
        return this.correoElectronico;
    }
    
    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }




}


