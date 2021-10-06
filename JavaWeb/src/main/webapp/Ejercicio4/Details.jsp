<%-- 
    Document   : Details
    Created on : 5/10/2021, 11:19:47 a. m.
    Author     : alex
--%>
<%@page import="ejercicio4.Banco" %>
<%@page import="ejercicio4.Empresa" %>
<%@page import="ejercicio4.Persona" %>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.List" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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

                    <%
                        String nombre = request.getParameter("nombre");
                        int control = 0;
                        if (nombre != null) {
                            Banco banco = new Banco(nombre);
                        }
                        if (request.getParameter("cedula") != null) {
                            String cedula = request.getParameter("cedula");
                            int edad = Integer.parseInt(request.getParameter("edad"));
                            String nombreCliente = request.getParameter("cliente");
                            Persona persona = new Persona(cedula, edad, nombreCliente);
                            Banco.banco.addCliente(persona);
                            Banco.banco.addPersona(persona);
                            control = 1;
                        }
                        if (request.getParameter("nit") != null) {
                            String nit = request.getParameter("nit");
                            String representante = request.getParameter("representante");
                            String nombreCliente = request.getParameter("cliente");
                            Empresa empresa = new Empresa(nit, representante, nombreCliente);
                            Banco.banco.addCliente(empresa);
                            Banco.banco.addEmpresa(empresa);
                            control = 2;
                        }
                        if (Banco.banco.getNombre() != null) {

                    %>

                    <nav class="navbar navbar-expand-lg navbar-dark bg-dark mt-5">
                        <div class="container-fluid">
                            <a class="navbar-brand" href="#">Consultas</a>
                            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDarkDropdown" aria-controls="navbarNavDarkDropdown" aria-expanded="false" aria-label="Toggle navigation">
                                <span class="navbar-toggler-icon"></span>
                            </button>
                            <div class="collapse navbar-collapse" id="navbarNavDarkDropdown">
                                <ul class="navbar-nav">
                                    <li class="nav-item dropdown">
                                        <a class="nav-link dropdown-toggle" href="#" id="navbarDarkDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                            Clientes
                                        </a>
                                        <ul class="dropdown-menu dropdown-menu-dark" aria-labelledby="navbarDarkDropdownMenuLink">
                                            <li><a class="dropdown-item" href="ListClientes.jsp">Nombres de los clientes</a></li>
                                            <li><a class="dropdown-item" href="ListPersonas.jsp">Nombres y cédulas de las personas clientes</a></li>
                                            <li><a class="dropdown-item" href="ListEmpresas.jsp">Nombre y representante de cada empresa</a></li>
                                            <li><a class="dropdown-item" href="ListClientesMenores.jsp">Nombres de los clientes menores de edad</a></li>
                                            <li><a class="dropdown-item" href="ClienteMasJoven.jsp">Nombre y la edad del cliente más joven</a></li>
                                            <li><a class="dropdown-item" href="ClienteMasViejo.jsp">Nombre y la edad del cliente más viejo</a></li>
                                            <li><a class="dropdown-item" href="CreateBank.jsp">Regresar</a></li>
                                        </ul>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </nav>

                    <h1 class="mt-4">Clientes del banco <%= Banco.banco.getNombre()%></h1>

                    <form action="Details.jsp" method="post">

                        <div class="form-group col-4 mt-3">
                            <label for="cliente">Nombre del cliente</label>
                            <input type="text" class="form-control" name="cliente" required="required">
                        </div>

                        <div class="form-group col-4 mt-3">
                            <label for="tipo">Tipo de cliente</label>
                            <select class="form-select" aria-label="Default select example" name="tipo" onchange="Cliente(this.value)">
                                <option selected>Seleccione el tipo de cliente</option>
                                <option value="1">Persona</option>
                                <option value="2">Empresa</option>
                            </select>
                        </div>   
                        <div class="resultado"></div>                        
                    </form>

                    <div class="visually-hidden" id="control"><%=control%></div>
                    <%
                        }
                    %>
                </div>
            </div>
        </div>
                
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>

        <script>
            document.addEventListener("DOMContentLoaded", function () {
                let control = document.getElementById("control").innerHTML;
                if (control === "1") {
                    alert("Se agrego la persona como cliente del banco.");
                }
                if (control === "2") {
                    alert("Se agrego la empresa como cliente del banco.");
                }
            });

            function Cliente(value) {
                const resultado = document.querySelector('.resultado');
                if (value === "1") {
                    let contenido = `<div class="form-group col-4 mt-3">
                                        <label for="cedula">Cédula del cliente</label>
                                        <input type="text" class="form-control" name="cedula" required="required">
                                    </div>
                                    <div class="form-group col-4 mt-3">
                                        <label for="edad">Edad del cliente</label>
                                        <input type="number" class="form-control" name="edad" required="required">
                                    </div> 
                                    <div class="mt-3">
                                        <input type="submit" class="btn btn-primary" name="enviar" value="Guardar"/>
                                    </div>`;
                    resultado.innerHTML = contenido;
                }
                if (value === "2") {
                    let contenido = `<div class="form-group col-4 mt-3">
                                        <label for="nit">Nit de la empresa</label>
                                        <input type="text" class="form-control" name="nit" required="required">
                                    </div>
                                    <div class="form-group col-4 mt-3">
                                        <label for="representante">Representante de la empresa</label>
                                        <input type="text" class="form-control" name="representante" required="required">
                                    </div> 
                                    <div class="mt-3">
                                        <input type="submit" class="btn btn-primary" name="enviar" value="Guardar"/>
                                    </div>`;
                    resultado.innerHTML = contenido;
                }
            }
        </script>
    </body>
</html>
