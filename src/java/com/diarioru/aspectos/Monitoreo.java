/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diarioru.aspectos;

import com.diarioru.entidades.Itemdiario;
import java.util.List;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 *
 * @author dev-pai-20
 */
@Aspect
@Component
public class Monitoreo {
    
//    @Before("execution (* ItemDiarioServiceInterface.listarItems(*))")
//    @Before("within (@org.springframework.stereotype.Service *)")
//    @Before("execution(* com.diarioru.servicios.RequerimientoServiceInterface.listarRequerimientos())")
    @Before("execution(java.util.List com.diarioru.servicios.RequerimientoServiceInterface.listarRequerimientos())")
    public void monitoreaItemDiario(JoinPoint joinPoint){
        System.out.println("Ejecutando metodo del DAO : " + joinPoint.toString());
    }
    
    @Around("execution(java.util.List com.diarioru.servicios.RequerimientoServiceInterface.listarRequerimientos())")
    public List<Itemdiario> modificaListaItemDiario(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("******** MONITOREO POR ASPECTOS **********************************************************");
        Object lista = joinPoint.getArgs();
        System.out.println(lista.toString());        
        List<Itemdiario> listaItems = (List<Itemdiario>) joinPoint.proceed();
        System.out.println("Cantidad de items : " + listaItems.size());
        System.out.println("******************************************************************************************");        
        return listaItems;
    }
}
