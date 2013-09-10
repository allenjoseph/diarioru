/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

$(function(){
    $.ajax({
        url : '/obtenerUsuarios.json',
        dataType : 'json',
        success : function(data){
            alert(data);
        }
    });
});


