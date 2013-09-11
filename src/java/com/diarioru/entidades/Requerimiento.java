/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diarioru.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author dev-pai-20
 */
@Entity
@Table(name = "UTDREPA", schema = "UTP")
@NamedQueries({
    @NamedQuery(name = "Requerimiento.findAll", query = "SELECT r FROM Requerimiento r"),
    @NamedQuery(name = "Requerimiento.findByCCodreq", query = "SELECT r FROM Requerimiento r WHERE r.codigo = :codigo"),
    @NamedQuery(name = "Requerimiento.findByCDesreq", query = "SELECT r FROM Requerimiento r WHERE r.descripcion = :descripcion"),
    @NamedQuery(name = "Requerimiento.findByDFecreq", query = "SELECT r FROM Requerimiento r WHERE r.fecha_creacion = :fecha_creacion"),
    @NamedQuery(name = "Requerimiento.findByNValreq", query = "SELECT r FROM Requerimiento r WHERE r.valor = :valor"),
    @NamedQuery(name = "Requerimiento.findByCCodest", query = "SELECT r FROM Requerimiento r WHERE r.estado = :estado"),
    @NamedQuery(name = "Requerimiento.findByCReqcod", query = "SELECT r FROM Requerimiento r WHERE r.tipo = :tipo")})
public class Requerimiento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "C_CODREQ")
    private String codigo;
    
    @Basic(optional = false)
    @Column(name = "C_DESREQ")
    private String descripcion;
    
    @Basic(optional = false)
    @Column(name = "D_FECREQ")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha_creacion;
    
    @Basic(optional = false)
    @Column(name = "N_VALREQ")
    private int valor;
    
    @Basic(optional = false)
    @Column(name = "C_CODEST")
    private String estado;
    
    @Column(name = "C_REQCOD")
    private String tipo;
    
    @JoinColumn(name = "C_CODUSU", referencedColumnName = "C_CODUSU")
    @ManyToOne(optional = false)
    private Usuario usuario;

    public Requerimiento() {
    }

    public Requerimiento(String codigo) {
        this.codigo = codigo;
    }

    public Requerimiento(String codigo, String descripcion, Date fecha_creacion, int valor, String estado) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.fecha_creacion = fecha_creacion;
        this.valor = valor;
        this.estado = estado;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo.toUpperCase();
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion.toUpperCase();
    }

    public Date getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado.toUpperCase();
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo.toUpperCase();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Requerimiento)) {
            return false;
        }
        Requerimiento other = (Requerimiento) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Utp.Requerimiento[ codigo=" + codigo + " ]";
    }
    
}
