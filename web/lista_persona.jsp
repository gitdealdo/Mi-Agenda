<%-- 
    Document   : lista_persona
    Created on : 15/05/2016, 08:37:01 PM
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
        <h2 class="text-center text-primary">Lista</h2>
        <table class="table">
            <thead>
                <tr>
                    <!--<th>#</th>-->
                    <th>Nombres</th>
                    <th>Apellidos</th>
                    <th>Dni</th>
                    <th>Celular</th>
                    <th colspan="2">Opciones</th>
                </tr>
            </thead>     
            <tbody>
                <c:forEach items="${personas}" var="p">
                    <tr>
                        <!--<td><c:out value="${p.id_persona}"/></td>-->
                        <td class="text-capitalize"><c:out value="${p.nombres}"/></td>
                        <td><c:out value="${p.apellidos}"/></td>
                        <td><c:out value="${p.dni}"/></td>
                        <td><c:out value="${p.celular}"/></td>
                        <td>
                            <a href="PersonaControl?action=edit&id=<c:out 
                                value="${p.id_persona}"/>" class="btn btn-sm btn-info">
                                <span class="glyphicon glyphicon-pencil"></span>
                            </a>
                            <a class="btn btn-warning btn-sm" href="PersonaControl?action=delete&id=<c:out 
                                value="${p.id_persona}"/>" onclick="return confirm('Estas seguro de eliminar?')" 
                               >                                    
                                   <span class="glyphicon glyphicon-trash"></span>
                            </a>                            
                        </td>
                    </tr>    
                </c:forEach>
            </tbody>
        </table>
        <a href="PersonaControl?action=insert" class="btn btn-primary">
            <span class="glyphicon glyphicon-plus-sign"></span> Agregar
        </a>        
    </body>
</html>
