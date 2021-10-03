<%-- 
    Document   : Create
    Created on : 2/10/2021, 11:22:39 a. m.
    Author     : alex
--%>
<%@page import="ejercicio2.Bus" %>
<%Bus.bus.reset(); %>
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
                    <div class="mt-3">
                        <a href="../Index.jsp">Volver</a>
                    </div>

                    <h1 class="mt-4">Datos del Bus</h1>

                    <form action="Details.jsp" method="post">
                        <div class="form-group col-4 mt-3">
                            <label for="placa">Placa del bus</label>
                            <input type="text" class="form-control" name="placa" style="text-transform:uppercase;" value="ABC001" required="required placa">
                        </div>

                        <div class="form-group col-4 mt-3">
                            <label for="capacidadPasajeros">Capacidad pasajeros del bus</label>
                            <input type="number" class="form-control" name="capacidadPasajeros" value="5" required="required capacidad">
                        </div>

                        <div class="form-group col-4 mt-3">
                            <label for="precioPasaje">Precio del pasaje</label>
                            <input type="number" class="form-control" name="precioPasaje" value="100" required="required precio">
                        </div>

                        <div class="mt-3">
                            <input type="submit" class="btn btn-primary" name="enviar" value="Guardar"/>
                        </div>

                    </form>
                    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>
                </div>
            </div>            
        </div>
    </body>
</html>
