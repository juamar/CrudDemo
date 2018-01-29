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
        <h1>New Alumno</h1>
        <form:form method="POST" action="/CrudDemo/alumnos/addAlumno" modelAttribute="alumno">
            <table>
                <tr>
                    <td><form:label path="nombres">Nombres</form:label></td>
                    <td><form:input path="nombres"/></td>
                </tr>
                <tr>
                    <td><form:label path="apellidos">Apellidos</form:label></td>
                    <td><form:input path="apellidos"/></td>
                </tr>
                <tr>
                    <td><form:label path="curso.Id">Curso</form:label></td>
                    <td><form:select path="curso.Id" items="${cursos}" itemValue="Id" itemLabel="Nombre"></form:select></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Submit"/></td>
                </tr>
            </table>
        </form:form>
    </body>
</html>
