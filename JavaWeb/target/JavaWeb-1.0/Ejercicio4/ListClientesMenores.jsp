<%-- 
    Document   : ListClientesMenores
    Created on : 6/10/2021, 11:59:20 a. m.
    Author     : alex
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="ejercicio4.Banco" %>
<%@page import="ejercicio4.Persona" %>
<% int contador = 0;%>

<!DOCTYPE html>
<html>
    <head>
        <title>LABORATORIO</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">

    </head>
    <body>    
        <div class="container">
            <div class="row">
                <div class="col-sm">
                    <div class="mt-3">
                        <a href="Details.jsp">Volver</a>
                    </div>

                    <h1 class="mt-4 mb-5">Nombres de los clientes menores de edad.</h1>

                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th scope="col">#</th>
                                <th scope="col">Nombre de la persona</th>
                                <th scope="col">Identificación</th>
                                <th scope="col">edad</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                for (Persona clie : Banco.banco.getPersonas()) {
                                    contador++;
                                    if (clie.getEdad() < 18) {
                            %>
                            <tr>
                                <th scope="row"><%=contador%></th>
                                <td><%=clie.getNombre()%></td>
                                <td><%=clie.obtIdentificacion()%></td>
                                <td><%=clie.getEdad()%></td>
                            </tr>
                            <%
                                    }
                                }
                            %>


                        </tbody>
                    </table>
                </div>
            </div>            
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>
    </body>
</html>
