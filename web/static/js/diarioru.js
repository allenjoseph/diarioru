/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

$(function() {
    darFormatoFechas();

    $(".datepicker").datepicker({
        format: 'dd/mm/yyyy',
        language: 'es',
        autoclose: true
    }).on('changeDate',function(ev){
        $(this).siblings().val(ev.date);
    });

    $('#sugerencia-btn').on('click', function() {
        var tipo = $("#sugerencia-select").val();
        var descripcion = $("#sugerencia-text").val();
        var cont = $("#sugerencia-table").data("cont");

        var html = "<tr>\n\
                <td><input type='hidden' name='sugerencias[" + cont + "].referencia' value='" + tipo + "'>" + tipo + "</td>\n\
                <td><input type='hidden' name='sugerencias[" + cont + "].comentario' value='" + descripcion + "'>" + descripcion + "</td>\n\
                <td><div class='btn-group'>\n\
                    <button class='btn btn-mini'><i class='icon-pencil'></i></button>\n\
                    <button class='btn btn-mini'><i class='icon-trash'></i></button>\n\
                </div></td>\n\
                </tr>";

        $("#sugerencia-table").data("cont", cont + 1);
        $("#sugerencia-table").append(html);
    });
});

function darFormatoFechas() {
    $(".datepicker").each(function() {
        var fecha = new Date($(this).val());
        if (isNaN(fecha.getTime())) {
            fecha = '01/01/2013';
        } else {
            fecha = formatFecha(fecha);
        }
        $(this).val(fecha);
    });
}

function formatFecha(date) {
    var val = {
        d: date.getUTCDate(),
        m: date.getUTCMonth() + 1,
        yyyy: date.getUTCFullYear()
    };
    val.dd = (val.d < 10 ? '0' : '') + val.d;
    val.mm = (val.m < 10 ? '0' : '') + val.m;

    return val.dd + "/" + val.mm + "/" + val.yyyy;
}

