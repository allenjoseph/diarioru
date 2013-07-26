<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>

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
                    <small>${user} - ${role}</small>
                </header>     
                <a href="<c:url value="/j_spring_security_logout"/>" class="pull-right btn btn-danger btn-mini ">Sacame de aqui!</a>
            </div>
            <hr/>    
            <div class="row-fluid">
                <nav class="span3">
                    <ul class="nav nav-list">
                        <li class="nav-header">Requerimiento</li>
                        <li class="active"><a href="diario.html">comentario diario</a></li>
                        <li><a href="requerimiento.html">generar requerimiento</a></li>
                        <li class="nav-header">Retrospectiva</li>
                        <li><a href="#">lo bueno</a></li>
                        <li><a href="#">lo feo o malo</a></li>
                        <li><a href="#">sugerencias e ideas</a></li>
                    </ul>
                </nav>
                <section class="span9">
                    <blockquote>
                        <h3>Nuevo Comentario</h3>
                    </blockquote>
                    <form:form method="post" action="diario-item.html" class="form-horizontal" commandName="item">
                        <div class="control-group">
                            <label class="control-label" for="inputEmail">Usuario</label>
                            <div class="controls">
                                <form:select path="usuario.usuarioId" cssClass="input-xlarge">
                                    <form:options items="${usuarios}" itemValue="usuarioId" itemLabel="nombre" />
                                </form:select>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label" for="inputPassword">Requerimiento</label>
                            <div class="controls">
                                <form:select path="requerimiento.requerimientoId">
                                    <form:options items="${requerimientos}" itemValue="requerimientoId" itemLabel="codigo" />
                                </form:select>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label" for="inputPassword">Comentario</label>
                            <div class="controls">
                                <form:textarea path="comentario" placeholder="Ingresa tu comentario diario" cssClass="input-xxlarge"/>
                            </div>
                        </div>
                        <div class="control-group">
                            <div class="controls">
                                <button type="submit" class="btn btn-success">Registrar Comentario</button>                                
                            </div>
                        </div>
                    </form:form>
                    <blockquote>
                        <h3>Comentarios</h3>
                    </blockquote>
                    <form:form method="post" action="listar-item.html" class="form-horizontal" commandName="item2">
                        <div class="control-group">
                            <label class="control-label" for="inputEmail">Usuario</label>
                            <div class="controls">
                                <form:select path="usuario.usuarioId" cssClass="input-xlarge">
                                    <form:options items="${usuarios}" itemValue="usuarioId" itemLabel="nombre" />
                                </form:select>                                
                            </div>
                        </div>   
                        <div class="control-group">
                            <label class="control-label" for="inputPassword">Requerimiento</label>
                            <div class="controls">
                                <form:select path="requerimiento.requerimientoId">
                                    <form:options items="${requerimientos}" itemValue="requerimientoId" itemLabel="codigo" />
                                </form:select>
                            </div>
                        </div>
                        <div class="control-group">
                            <div class="controls">
                                <button type="submit" class="btn">Listar Comentarios</button>                              
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
