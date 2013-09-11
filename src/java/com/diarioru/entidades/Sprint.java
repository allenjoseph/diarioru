/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diarioru.entidades;

import com.diarioru.entidades.embedded.SprintPK;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "SPRINT", schema = "UTP")
@NamedQueries({
    @NamedQuery(name = "Sprint.findAll", query = "SELECT s FROM Sprint s"),
    @NamedQuery(name = "Sprint.findByProducto", query = "SELECT s FROM Sprint s WHERE s.sprintPK.producto = :producto"),
    @NamedQuery(name = "Sprint.findByRelease", query = "SELECT s FROM Sprint s WHERE s.sprintPK.release = :release"),
    @NamedQuery(name = "Sprint.findByNumero", query = "SELECT s FROM Sprint s WHERE s.sprintPK.numero = :numero"),
    @NamedQuery(name = "Sprint.findByFecha", query = "SELECT s FROM Sprint s WHERE s.fecha = :fecha")})
public class Sprint implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SprintPK sprintPK;
    
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    
    @JoinColumn(name = "USUARIO_ID", referencedColumnName = "C_CODUSU")
    @ManyToOne
    private Usuario usuario;

    public Sprint() {
    }

    public Sprint(SprintPK sprintPK) {
        this.sprintPK = sprintPK;
    }

    public Sprint(String producto, int release, int numero) {
        this.sprintPK = new SprintPK(producto, release, numero);
    }

    public SprintPK getSprintPK() {
        return sprintPK;
    }

    public void setSprintPK(SprintPK sprintPK) {
        this.sprintPK = sprintPK;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
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
        hash += (sprintPK != null ? sprintPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sprint)) {
            return false;
        }
        Sprint other = (Sprint) object;
        if ((this.sprintPK == null && other.sprintPK != null) || (this.sprintPK != null && !this.sprintPK.equals(other.sprintPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Utp.Sprint[ sprintPK=" + sprintPK + " ]";
    }
    
}
