/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diarioru.servicios;

import com.diarioru.mybatis.MyBatisMapperInterface;
import com.diarioru.mybatis.ParamObtenerId;
import com.diarioru.mybatis.ParamSiguienteCorrelativo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author dev-pai-20
 */
@Service
public class MyBatisService implements MyBatisServiceInterface{
    
    @Autowired
    private MyBatisMapperInterface mapper;

    @Override
    public Integer ObtenerId(String tabla) {
        ParamObtenerId param = new ParamObtenerId();
        param.setNombre_tabla(tabla);
        mapper.ObtenerId(param);
        return param.getNext_val();
    }   
    
    @Override
    public Integer SiguienteCorrelativo(String tipo){
        ParamSiguienteCorrelativo param = new ParamSiguienteCorrelativo();
        param.setTipo_requerimiento(tipo);
        mapper.SiguienteCorrelativo(param);
        return param.getSiguiente_correlativo();
    }
    
}
