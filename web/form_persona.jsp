<%-- 
    Document   : crear_persona
    Created on : 15/05/2016, 10:13:26 PM
    Author     : hikaru
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="static/css/bootstrap.css">
    </head>
    <body class="container">
        <h2 class="text-center text-primary">Formulario</h2>
        <form method="POST" action="PersonaControl" name="frmAddPersona" class="form-horizontal">
            <input type="hidden" name="id" value="<c:out value="${persona.id_persona}"/>"/>
            Nombres: <input type="text" name="nombres"  class="form-control"
                            value="<c:out value="${persona.nombres}"/>"/>
            Apellidos: <input type="text" name="apellidos" class="form-control"
                            value="<c:out value="${persona.apellidos}"/>"/>
            Celular: <input type="text" name="celular" class="form-control"
                            value="<c:out value="${persona.celular}"/>"/>
            Dni: <input type="text" name="dni" class="form-control"
                            value="<c:out value="${persona.dni}"/>"/>
            <button type="submit" class="btn btn-success">Guardar</button>
        </form>
    </body>
</html>
