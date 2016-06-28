package model;
// Generated 28-jun-2016 9:50:55 by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Reporte generated by hbm2java
 */
@Entity
@Table(name="reporte"
    ,catalog="objetosperdidos"
)
public class Reporte  implements java.io.Serializable {

	private static final long serialVersionUID = 9105233517828191623L;
	private Integer idReporte;
     private Usuarios usuarios;
     private String tituloReporte;
     private String fotoReporte;
     private String descripcion;
     private String estadoReporte;
     private String celularContacto;
     private String correoContacto;

    public Reporte() {
    }

	
    public Reporte(Usuarios usuarios, String tituloReporte, String fotoReporte, String descripcion, String estadoReporte) {
        this.usuarios = usuarios;
        this.tituloReporte = tituloReporte;
        this.fotoReporte = fotoReporte;
        this.descripcion = descripcion;
        this.estadoReporte = estadoReporte;
    }
    public Reporte(Usuarios usuarios, String tituloReporte, String fotoReporte, String descripcion, String estadoReporte, String celularContacto, String correoContacto) {
       this.usuarios = usuarios;
       this.tituloReporte = tituloReporte;
       this.fotoReporte = fotoReporte;
       this.descripcion = descripcion;
       this.estadoReporte = estadoReporte;
       this.celularContacto = celularContacto;
       this.correoContacto = correoContacto;
    }
   
    @Id @GeneratedValue(strategy=IDENTITY)
    @Column(name="ID_REPORTE", unique=true, nullable=false)
    public Integer getIdReporte() {
        return this.idReporte;
    }
    
    public void setIdReporte(Integer idReporte) {
        this.idReporte = idReporte;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="USERNAME", nullable=false)
    public Usuarios getUsuarios() {
        return this.usuarios;
    }
    
    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }

    
    @Column(name="TITULO_REPORTE", nullable=false, length=100)
    public String getTituloReporte() {
        return this.tituloReporte;
    }
    
    public void setTituloReporte(String tituloReporte) {
        this.tituloReporte = tituloReporte;
    }

    
    @Column(name="FOTO_REPORTE", nullable=false, length=200)
    public String getFotoReporte() {
        return this.fotoReporte;
    }
    
    public void setFotoReporte(String fotoReporte) {
        this.fotoReporte = fotoReporte;
    }

    
    @Column(name="DESCRIPCION", nullable=false, length=300)
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    
    @Column(name="ESTADO_REPORTE", nullable=false, length=5)
    public String getEstadoReporte() {
        return this.estadoReporte;
    }
    
    public void setEstadoReporte(String estadoReporte) {
        this.estadoReporte = estadoReporte;
    }

    
    @Column(name="CELULAR_CONTACTO", length=20)
    public String getCelularContacto() {
        return this.celularContacto;
    }
    
    public void setCelularContacto(String celularContacto) {
        this.celularContacto = celularContacto;
    }

    
    @Column(name="CORREO_CONTACTO", length=50)
    public String getCorreoContacto() {
        return this.correoContacto;
    }
    
    public void setCorreoContacto(String correoContacto) {
        this.correoContacto = correoContacto;
    }




}

