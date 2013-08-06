<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="c_rt" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE HTML>
<html lang="es">
    <head>
        <meta charset="UTF-8"/>           
        <title>Diario UTI</title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <blockquote>
                    <header class="span12">
                        <h1>DIARIO UTI</h1>
                    </header>
                </blockquote>                
            </div>            
            <div class="row">
                <section class="span12">
                    <form class="form-horizontal" method="POST" action="<c:url value="j_spring_security_check"/>" >
                        <div class="control-group">
                            <label class="control-label" for="inputEmail">Usuario</label>
                            <div class="controls">
                                <input type="text" id="inputEmail" name="j_username" placeholder="Nombre de usuario">
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label" for="inputPassword">Password</label>
                            <div class="controls">
                                <input type="password" id="inputPassword" name="j_password" placeholder="Password">
                            </div>
                        </div>
                        <div class="control-group">
                            <div class="controls">
                                <button type="submit" class="btn btn-success">Ingresar</button>
                            </div>
                        </div>
                        <div class="control-group">
                            <div class="controls">
                                <c:if test="${not empty error}">
                                    <div class="alert alert-error span3" style="margin-left: 0">
                                        ${SPRING_SECURITY_LAST_EXCEPTION.message}
                                    </div>
                                </c:if>
                            </div>

                        </div>
                    </form>
                </section>
            </div>
            <div class="row-fluid">
                <footer></footer>
            </div>
        </div>        
        <link type="text/css" href="<c:url value="static/css/bootstrap.min.css"/>" rel="stylesheet"/>       
        <script type="text/javascript" src="<c:url value="static/js/jquery-1.10.2.min.js"/>" ></script>
        <script type="text/javascript" src="<c:url value="static/js/bootstrap.min.js"/>" ></script>
    </body>
</html>
