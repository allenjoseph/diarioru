/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diarioru.dao;

import com.diarioru.entidades.Sprint;
import java.util.List;

/**
 *
 * @author dev-pai-20
 */
public interface SprintDaoInterface {
    
    public Sprint obtenerSprint();
    
    public List<Sprint> listarSprints();
}
