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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author allen
 */
@Entity
@Table(name = "ITEMDIARIO", schema = "avelasco")
@NamedQueries({
    @NamedQuery(name = "Itemdiario.findAll", query = "SELECT i FROM Itemdiario i"),
    @NamedQuery(name = "Itemdiario.findByItemdiarioId", query = "SELECT i FROM Itemdiario i WHERE i.itemdiarioId = :itemdiarioId"),
    @NamedQuery(name = "Itemdiario.findByFecha", query = "SELECT i FROM Itemdiario i WHERE i.fecha = :fecha")})
public class Itemdiario implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(name = "itemdiario_id")
    private Integer itemdiarioId;
    
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    
    @Basic(optional = false)
    @Lob
    @Column(name = "comentario")
    private String comentario;
    
    @JoinColumn(name = "usuario_id", referencedColumnName = "C_CODUSU")
    @ManyToOne(optional = false)
    private Usuario usuario;
    
    @JoinColumn(name = "requerimiento_id", referencedColumnName = "C_CODREQ")
    @ManyToOne(optional = false)
    private Requerimiento requerimiento;
    
    public Itemdiario() {
        this.fecha = new Date();
    }

    public Itemdiario(Integer itemdiarioId) {
        this.itemdiarioId = itemdiarioId;
    }

    public Itemdiario(Integer itemdiarioId, Date fecha, String comentario) {
        this.itemdiarioId = itemdiarioId;
        this.fecha = fecha;
        this.comentario = comentario;
    }

    public Integer getItemdiarioId() {
        return itemdiarioId;
    }

    public void setItemdiarioId(Integer itemdiarioId) {
        this.itemdiarioId = itemdiarioId;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Requerimiento getRequerimiento() {
        return requerimiento;
    }

    public void setRequerimiento(Requerimiento requerimiento) {
        this.requerimiento = requerimiento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itemdiarioId != null ? itemdiarioId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Itemdiario)) {
            return false;
        }
        Itemdiario other = (Itemdiario) object;
        if ((this.itemdiarioId == null && other.itemdiarioId != null) || (this.itemdiarioId != null && !this.itemdiarioId.equals(other.itemdiarioId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.diarioru.entidades.Itemdiario[ itemdiarioId=" + itemdiarioId + " ]";
    }
    
}
