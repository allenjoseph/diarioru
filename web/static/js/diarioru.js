/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

$(function() {
    $('#sugerencia-btn').on('click', function() {
        var tipo = $("#sugerencia-select").val();
        var descripcion = $("#sugerencia-text").val();
        var cont = $("#sugerencia-table").data("cont");
        
        var html = "<tr>\n\
                <td><input type='hidden' name='sugerencias["+cont+"].referencia' value='"+tipo+"'>" + tipo + "</td>\n\
                <td><input type='hidden' name='sugerencias["+cont+"].comentario' value='"+descripcion+"'>" + descripcion + "</td>\n\
                <td><div class='btn-group'>\n\
                    <button class='btn btn-mini'><i class='icon-pencil'></i></button>\n\
                    <button class='btn btn-mini'><i class='icon-trash'></i></button>\n\
                </div></td>\n\
                </tr>";
        
        $("#sugerencia-table").data("cont",cont+1);
        $("#sugerencia-table").append(html);
    });
});


