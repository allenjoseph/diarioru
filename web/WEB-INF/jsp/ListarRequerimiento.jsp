<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                    <table class="table table-striped table-bordered table-hover table-condensed">
                        <thead>
                            <tr>
                                <th>Fecha</th>
                                <th>Requerimiento</th>
                                <th>Titulo</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="requerimiento" items="${requerimientos}">
                                <tr>
                                    <td>${requerimiento.fecha_creacion}</td>
                                    <td><b>${requerimiento.codigo}</b></td>
                                    <td>${requerimiento.titulo}</td>
                                </tr>
                            </c:forEach>                    
                        </tbody>
                    </table>
                </section>
            </div>
            <div class="row-fluid">
                <footer></footer>
            </div>
        </div>

    </body>
</html>
