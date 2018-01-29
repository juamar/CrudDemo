<%-- 
    Document   : cursos
    Created on : Jan 25, 2018, 10:58:09 AM
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
        <a href="/CrudDemo/newCurso">New</a>
        <table>
            <tr>
                <th>Id</th>
                <th>Nombre</th>
            </tr>
            
            <c:forEach var="curso" items="${cursos}">
                <tr>
                    <td>
                        <c:out value="${curso.getId()}"></c:out>
                    </td>
                    <td>
                        <c:out value="${curso.getNombre()}"></c:out>
                    </td>
                </tr>
            </c:forEach>
            
        </table>
    </body>
</html>
