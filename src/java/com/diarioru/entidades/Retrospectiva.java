/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diarioru.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author allen
 */
@Entity
@Table(name = "RETROSPECTIVA", schema = "avelasco")
@NamedQueries({
    @NamedQuery(name = "Retrospectiva.findAll", query = "SELECT u FROM Retrospectiva u"),
    @NamedQuery(name = "Retrospectiva.findByRetrospectivaId", query = "SELECT u FROM Retrospectiva u WHERE u.retrospectivaId = :retrospectivaId"),
    @NamedQuery(name = "Retrospectiva.findByTipo", query = "SELECT u FROM Retrospectiva u WHERE u.tipo = :tipo")})
public class Retrospectiva implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(name = "retrospectiva_id")
    private Integer retrospectivaId;
    
    @Basic(optional = false)
    @Column(name = "tipo")
    private String tipo;
    
    @Basic(optional = false)
    @Lob
    @Column(name = "comentario")
    private String comentario;
    
    @JoinColumn(name = "usuario_id", referencedColumnName = "usuario_id")
    @ManyToOne(optional = false)
    private Usuario usuario;    
       
    public Retrospectiva() {
    }

    public Integer getRetrospectivaId() {
        return retrospectivaId;
    }

    public void setRetrospectivaId(Integer retrospectivaId) {
        this.retrospectivaId = retrospectivaId;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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
    
    @Override
    public String toString() {
        return "com.diarioru.entidades.Retrospectiva[ retrospectivaId=" + retrospectivaId + " ]";
    }
    
}
