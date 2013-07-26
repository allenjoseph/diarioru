/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diarioru.servicios;

import java.util.Date;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 *
 * @author dev-pai-20
 */

@Component(value = "QuartzService")
public class QuartzService {
    
    public void MensajeProgramado(){        
        System.out.println("La Hora es :"+new Date());
    }
}
