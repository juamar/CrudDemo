<%-- 
    Document   : newCurso
    Created on : Jan 25, 2018, 12:57:36 PM
    Author     : JuanIgnacio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>New Curso</h1>
        <form:form method="POST" action="/CrudDemo/cursos/addCurso" modelAttribute="curso">
            <table>
                <tr>
                    <td><form:label path="nombre">Name</form:label></td>
                    <td><form:input path="nombre"/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Submit"/></td>
                </tr>
            </table>
        </form:form>
    </body>
</html>
