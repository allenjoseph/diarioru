/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diarioru.entidades.embedded;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author dev-pai-20
 */
@Embeddable
public class SprintPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "PRODUCTO")
    private String producto;
    
    @Basic(optional = false)
    @Column(name = "RELEASE")
    private int release;
    
    @Basic(optional = false)
    @Column(name = "NUMERO")
    private int numero;

    public SprintPK() {
    }

    public SprintPK(String producto, int release, int numero) {
        this.producto = producto;
        this.release = release;
        this.numero = numero;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getRelease() {
        return release;
    }

    public void setRelease(int release) {
        this.release = release;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (producto != null ? producto.hashCode() : 0);
        hash += (int) release;
        hash += (int) numero;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SprintPK)) {
            return false;
        }
        SprintPK other = (SprintPK) object;
        if ((this.producto == null && other.producto != null) || (this.producto != null && !this.producto.equals(other.producto))) {
            return false;
        }
        if (this.release != other.release) {
            return false;
        }
        if (this.numero != other.numero) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return producto + "-" + release + "-" + numero;
    }
    
}
