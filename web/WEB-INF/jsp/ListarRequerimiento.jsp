<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE HTML>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <link href="static/css/bootstrap.min.css" rel="stylesheet"/>
        <link href="static/css/estilos.css" rel="stylesheet"/>
        <script src="static/js/jquery-1.10.2.min.js"></script>
        <script src="static/js/bootstrap.min.js"></script>
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
                    <f:form method="post" action="listar-requerimiento.html" class="form-inline" commandName="item1">
                        <f:select path="usuario.codigo" cssClass="input-xlarge">
                            <f:options items="${usuarios}" itemValue="codigo" itemLabel="nombreCompleto" />
                        </f:select>
                        <button type="submit" class="btn">Filtrar</button>
                    </f:form>
                    <table class="table table-striped table-bordered table-hover table-condensed">
                        <thead>
                            <tr>
                                <th class="span2">Fecha</th>
                                <th>Requerimiento</th>
                                <th>Titulo</th>
                                <th>Usuario</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="requerimiento" items="${requerimientos}">
                                <tr>
                                    <td>${fn:substring(requerimiento.fecha_creacion,0,10)}</td>
                                    <td><b>${requerimiento.codigo}</b></td>
                                    <td>${requerimiento.descripcion}</td>
                                    <td>${requerimiento.usuario.codigo}</td>
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
