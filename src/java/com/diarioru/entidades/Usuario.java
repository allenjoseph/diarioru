/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diarioru.entidades;

import com.diarioru.util.Helper;
import java.io.Serializable;
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

/**
 *
 * @author dev-pai-20
 */
@Entity
@Table(name = "UTMUSRE", schema = "UTP")
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByCCodusu", query = "SELECT u FROM Usuario u WHERE u.codigo = :codigo"),
    @NamedQuery(name = "Usuario.findByCNomusu", query = "SELECT u FROM Usuario u WHERE u.nombre = :nombre"),
    @NamedQuery(name = "Usuario.findByCApepat", query = "SELECT u FROM Usuario u WHERE u.apellidoPaterno = :apellidoPaterno"),
    @NamedQuery(name = "Usuario.findByCApemat", query = "SELECT u FROM Usuario u WHERE u.apellidoMaterno = :apellidoMaterno"),
    @NamedQuery(name = "Usuario.findByCPassdw", query = "SELECT u FROM Usuario u WHERE u.password = :password")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "C_CODUSU")
    private String codigo;
    @Column(name = "C_NOMUSU")
    private String nombre;
    @Column(name = "C_APEPAT")
    private String apellidoPaterno;
    @Column(name = "C_APEMAT")
    private String apellidoMaterno;
    @Column(name = "C_PASWRD")
    private String password;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigo")
    private List<Requerimiento> requerimientoList;
    @OneToMany(mappedBy = "usuario")
    private List<Comentario> comentarioList;

    public Usuario() {
    }

    public Usuario(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo.toUpperCase();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre.toUpperCase();
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno.toUpperCase();
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno.toUpperCase();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password){
        this.password = password.isEmpty() ? "" : Helper.md5(password);
    }

    public List<Requerimiento> getRequerimientoList() {
        return requerimientoList;
    }

    public void setRequerimientoList(List<Requerimiento> requerimientoList) {
        this.requerimientoList = requerimientoList;
    }

    public List<Comentario> getComentarioList() {
        return comentarioList;
    }

    public void setComentarioList(List<Comentario> comentarioList) {
        this.comentarioList = comentarioList;
    }

    public String getNombreCompleto() {
        return nombre + " " + apellidoPaterno;
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
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Utp.Usuario[ codigo=" + codigo + " ]";
    }
}
