<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE HTML>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <link href="../static/css/bootstrap.min.css" rel="stylesheet"/>
        <link href="../static/css/estilos.css" rel="stylesheet"/>
        <script src="../static/js/jquery-1.10.2.min.js"></script>
        <script src="../static/js/bootstrap.min.js"></script>
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
                    <table class="table table-striped table-bordered table-hover table-condensed">
                        <thead>
                            <tr>
                                <th>Producto</th>
                                <th>Release</th>
                                <th>Sprint</th>
                                <th>Fecha Creacion</th>
                                <th>Usuario</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="sprint" items="${sprints}">
                                <tr>
                                    <td>${sprint.sprintPK.producto}</td>
                                    <td>Release ${sprint.sprintPK.release}</td>
                                    <td>Sprint ${sprint.sprintPK.numero}</td>
                                    <td>${sprint.fecha}</td>
                                    <td>${sprint.usuario.codigo}</td>
                                </tr>
                            </c:forEach>                    
                        </tbody>
                    </table>
                </section>
            </div>
            <div class="row-fluid">
                <jsp:include page="tags/Footer.jsp"/>
            </div>
        </div>

    </body>
</html>
