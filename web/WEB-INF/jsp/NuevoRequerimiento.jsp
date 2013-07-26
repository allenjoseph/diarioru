<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE HTML>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <link href="static/css/bootstrap.min.css" rel="stylesheet"/>
        <script src="static/js/jquery-1.10.2.min.js"></script>
        <script src="static/js/bootstrap.min.js"></script>
        <title>Diario UTI</title>
    </head>

    <body>
        <div class="container-fluid">
            <div class="row-fluid">
                <header>
                    <h1>Diario UTI</h1>
                </header>
            </div>
            <div class="row-fluid">
                <nav class="span3">
                    <ul class="nav nav-list">
                        <li class="nav-header">Requerimiento</li>
                        <li><a href="diario.html">comentario diario</a></li>
                        <li class="active"><a href="requerimiento.html">generar requerimiento</a></li>
                        <li class="nav-header">Retrospectiva</li>
                        <li><a href="#">lo bueno</a></li>
                        <li><a href="#">lo feo o malo</a></li>
                        <li><a href="#">sugerencias e ideas</a></li>
                    </ul>
                </nav>
                <section class="span9">
                    <blockquote>
                        <h3>Nuevo Requerimiento</h3>
                    </blockquote>
                    <form:form method="post" action="requerimiento-item.html" class="form-horizontal" commandName="requerimiento">
                        <div class="control-group">
                            <label class="control-label" >Tipo</label>
                            <div class="controls">
                                <form:select path="tipo" cssClass="input-xlarge">
                                    <option value="RU">REQUERIMIENTO DE USUARIO</option>
                                    <option value="RE">REQUERIMIENTO DE ERROR</option>
                                </form:select>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label" >Titulo</label>
                            <div class="controls">
                                <form:textarea path="titulo" placeholder="Ingresa el titulo para el requerimiento" cssClass="input-xxlarge"/>
                            </div>
                        </div>
                        <div class="control-group">
                            <div class="controls">
                                <button type="submit" class="btn btn-success">Registrar Requerimiento</button>                                
                            </div>
                        </div>
                    </form:form>
                    <blockquote>
                        <h3>Requerimientos</h3>
                    </blockquote>
                    <form:form method="post" action="listar-requerimiento.html" class="form-horizontal">      
                        <div class="control-group">
                            <div class="controls">
                                <button type="submit" class="btn">Listar Requerimientos</button>                              
                            </div>
                        </div>
                    </form:form>
                </section>
            </div>
            <div class="row-fluid">
                <footer></footer>
            </div>
        </div>

    </body>
</html>
