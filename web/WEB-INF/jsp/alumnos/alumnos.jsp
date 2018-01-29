<%-- 
    Document   : alumnos
    Created on : Jan 28, 2018, 1:35:21 PM
    Author     : JuanIgnacio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${message}</title>
    </head>
    <body>
        <h1>${message}</h1>
        <a href="/CrudDemo/alumnos/newAlumno">New</a>
        <table>
            <tr>
                <th>Id</th>
                <th>Nombres</th>
                <th>Apellidos</th>
                <th>Curso</th>
            </tr>
            
            <c:forEach var="alumno" items="${alumnos}">
                <tr>
                    <td>
                        <c:out value="${alumno.getId()}"></c:out>
                    </td>
                    <td>
                        <c:out value="${alumno.getNombres()}"></c:out>
                    </td>
                    <td>
                        <c:out value="${alumno.getApellidos()}"></c:out>
                    </td>
                    <td>
                        <c:out value="${alumno.getCurso().getNombre()}"></c:out>
                    </td>
                </tr>
            </c:forEach>
            
        </table>
    </body>
</html>
