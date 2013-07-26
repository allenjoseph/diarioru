/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diarioru.entidades;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author allen
 */
@Entity
@Table(name = "REQUERIMIENTO", schema = "avelasco")
@NamedQueries({
    @NamedQuery(name = "Requerimiento.findAll", query = "SELECT r FROM Requerimiento r"),
    @NamedQuery(name = "Requerimiento.findByRequerimientoId", query = "SELECT r FROM Requerimiento r WHERE r.requerimientoId = :requerimientoId"),
    @NamedQuery(name = "Requerimiento.findByCodigo", query = "SELECT r FROM Requerimiento r WHERE r.codigo = :codigo"),
    @NamedQuery(name = "Requerimiento.findByTitulo", query = "SELECT r FROM Requerimiento r WHERE r.titulo = :titulo")})
public class Requerimiento implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(name = "requerimiento_id")
    private Integer requerimientoId;
    
    @Basic(optional = false)
    @Column(name = "codigo")
    private String codigo;
    
    @Basic(optional = false)
    @Column(name = "titulo")
    private String titulo;
    
    @Basic(optional = false)
    @Column(name = "tipo")
    private String tipo;
    
    @Basic(optional = false)
    @Column(name = "correlativo")
    private Integer correlativo;
    
    @Basic(optional = false)
    @Column(name = "anio")
    private Integer anio;
    
    @Basic(optional = false)
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.DATE)
    private Date fecha_creacion;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "requerimiento")
    private List<Itemdiario> itemdiarioList;

    public Requerimiento() {
        this.fecha_creacion = new Date();
    }

    public Requerimiento(Integer requerimientoId) {
        this.requerimientoId = requerimientoId;
    }

    public Requerimiento(Integer requerimientoId, String codigo, String titulo) {
        this.requerimientoId = requerimientoId;
        this.codigo = codigo;
        this.titulo = titulo;
    }

    public Integer getRequerimientoId() {
        return requerimientoId;
    }

    public void setRequerimientoId(Integer requerimientoId) {
        this.requerimientoId = requerimientoId;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Itemdiario> getItemdiarioList() {
        return itemdiarioList;
    }

    public void setItemdiarioList(List<Itemdiario> itemdiarioList) {
        this.itemdiarioList = itemdiarioList;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getCorrelativo() {
        return correlativo;
    }

    public void setCorrelativo(Integer correlativo) {
        this.correlativo = correlativo;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public Date getFecha_creacion() {        
        return fecha_creacion;
    }

    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

        
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (requerimientoId != null ? requerimientoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Requerimiento)) {
            return false;
        }
        Requerimiento other = (Requerimiento) object;
        if ((this.requerimientoId == null && other.requerimientoId != null) || (this.requerimientoId != null && !this.requerimientoId.equals(other.requerimientoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.diarioru.entidades.Requerimiento[ requerimientoId=" + requerimientoId + " ]";
    }
    
}
