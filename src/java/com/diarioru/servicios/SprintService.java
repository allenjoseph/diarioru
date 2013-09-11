/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diarioru.servicios;

import com.diarioru.entidades.Sprint;
import com.diarioru.negocio.SprintInterface;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author dev-pai-20
 */
@Service
public class SprintService implements SprintServiceInterface{

    @Autowired
    SprintInterface sprintInterface;
    
    @Override
    public Sprint obtenerSprint() {
        return sprintInterface.obtenerSprint();
    }
    
    @Override
    public List<Sprint> listarSprints(){
        return sprintInterface.listarSprints();
    }
}
