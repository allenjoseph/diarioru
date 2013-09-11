/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diarioru.negocio;

import com.diarioru.dao.SprintDaoInterface;
import com.diarioru.entidades.Sprint;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author dev-pai-20
 */
@Component
public class SprintImplements implements SprintInterface{

    @Autowired
    SprintDaoInterface sprintDaoInterface;
    
    @Override
    public Sprint obtenerSprint(){
        return sprintDaoInterface.obtenerSprint();        
    }

    @Override
    public List<Sprint> listarSprints() {
        return sprintDaoInterface.listarSprints();
    }
}
