/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diarioru.mybatis;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;

/**
 *
 * @author dev-pai-20
 */
public interface MyBatisMapperInterface {

    @Select(value = "{ #{next_val, mode=OUT, jdbcType=NUMERIC} = call avelasco.maestrodiarioru.obtenerSiguienteId(#{nombre_tabla, mode=IN, jdbcType=VARCHAR })}")
    @Options(statementType = StatementType.CALLABLE)
    public Object ObtenerId(ParamObtenerId param);
    
    @Select(value = "{ #{siguiente_correlativo, mode=OUT, jdbcType=NUMERIC} = call avelasco.maestrodiarioru.obtenerCorrelativoReq(#{tipo_requerimiento, mode=IN, jdbcType=VARCHAR })}")
    @Options(statementType = StatementType.CALLABLE)
    public Object SiguienteCorrelativo(ParamSiguienteCorrelativo param);
}
