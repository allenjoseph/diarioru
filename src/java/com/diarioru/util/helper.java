/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diarioru.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author dev-pai-20
 */
public class helper {
    static DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    
    static String formatearFecha(Calendar fecha){
        return dateFormat.format(fecha);
    }
}
