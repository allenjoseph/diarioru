<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE HTML>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <link href="static/css/bootstrap.min.css" rel="stylesheet"/>
        <link href="static/css/estilos.css" rel="stylesheet"/>
        <script src="static/js/jquery-1.10.2.min.js"></script>
        <script src="static/js/bootstrap.min.js"></script>
        <script src="static/js/diarioru.js"></script>
        <title>RU</title>
    </head>

    <body>
        <div class="container-fluid">
            <div class="row-fluid">                
                <jsp:include page="tags/Header.jsp"/>
            </div>                
            <div class="row-fluid">
                <nav class="span3 well">
                    <jsp:include page="tags/Menu.jsp"/>
                </nav>
                <section class="span9">
                    <blockquote>
                        <h3>Nueva Sugerencia</h3>
                    </blockquote>
                    <f:form method="post" action="add-sugerencia.html" class="form-horizontal" commandName="sugerencias">                        
                        <div class="form-inline">                            
                            <select class="span2" id="sugerencia-select">
                                <option value="POSITIVA">POSITIVA</option>
                                <option value="MEJORAR">MEJORAR</option>
                                <option value="IDEA">IDEA</option>
                            </select>
                            <input id="sugerencia-text" type="text" class="input-xxlarge" placeholder="Sugerenca">
                            <button id="sugerencia-btn" type="button" class="btn">Agregar</button>
                        </div>
                        <hr/>
                        <table id="sugerencia-table" class="table table-bordered table-condensed table-hover" data-cont="0">
                            <thead>
                                <tr>
                                    <th class="span2">Tipo</th>
                                    <th>Sugerencia</th>
                                    <th class="span1">Opciones</th>                                    
                                </tr>
                            </thead>                            
                            <tbody>
                            </tbody>
                        </table>
                        <button type="submit" class="btn btn-success offset9">Registrar Sugerencias</button>  
                    </f:form>
                    <hr/>
                    <blockquote>
                        <h3>Sugerencias</h3>
                    </blockquote>
                    <f:form method="post" action="listar-sugerencias.html" class="form-horizontal" commandName="sugerencia">
                        <div class="control-group">
                            <div class="controls">
                                <button type="submit" class="btn">Listar Sugerencias</button>                              
                            </div>
                        </div>
                    </f:form>
                </section>
            </div>
            <div class="row-fluid">
                <jsp:include page="tags/Footer.jsp"/>
            </div>
        </div>
    </body>
</html>
