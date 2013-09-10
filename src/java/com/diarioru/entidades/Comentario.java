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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author dev-pai-20
 */
@Entity
@Table(name = "COMENTARIO")
public class Comentario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "COMENTARIO_ID")
    private Integer comentarioId;
    
    @Column(name = "COMENTARIO")
    private String comentario;
    
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    
    @Column(name = "PADRE_ID")
    private String padreId;
    
    @JoinColumn(name = "USUARIO_ID", referencedColumnName = "USUARIO_ID")
    @ManyToOne
    private Usuario usuario;

    public Comentario() {
    }

    public Comentario(Integer comentarioId) {
        this.comentarioId = comentarioId;
    }

    public Integer getComentarioId() {
        return comentarioId;
    }

    public void setComentarioId(Integer comentarioId) {
        this.comentarioId = comentarioId;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getPadreId() {
        return padreId;
    }

    public void setPadreId(String padreId) {
        this.padreId = padreId.toUpperCase();
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
        hash += (comentarioId != null ? comentarioId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comentario)) {
            return false;
        }
        Comentario other = (Comentario) object;
        if ((this.comentarioId == null && other.comentarioId != null) || (this.comentarioId != null && !this.comentarioId.equals(other.comentarioId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Utp.Comentario[ comentarioId=" + comentarioId + " ]";
    }
    
}
