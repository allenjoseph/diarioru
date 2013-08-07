/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diarioru.servicios;

/**
 *
 * @author allen
 */
public interface MyBatisServiceInterface {

    public Integer ObtenerId(String tabla);

    public Integer SiguienteCorrelativo(String tipo);
}
