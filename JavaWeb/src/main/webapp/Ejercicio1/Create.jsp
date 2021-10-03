<%-- 
    Document   : Create
    Created on : 1/10/2021, 10:01:32 p. m.
    Author     : alex
--%>

<%@page import="ejercicio1.Cita" %>

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

                    <h1 class="mt-4">Datos de la cita</h1>

                    <form action="Create.jsp" method="post">
                        <div class="form-group col-4 mt-3">
                            <label for="numero">Número de cita</label>
                            <input type="number" class="form-control" name="numero" value="1" required="required">
                        </div>
                        <div class="form-group col-4 mt-3">
                            <label for="tipo">Seleccione el tipo de cita</label>
                            <select class="form-control" name="tipo">
                                <option>1</option>
                                <option>2</option>
                                <option>3</option>
                                <option>4</option>
                                <option>5</option>
                            </select>
                        </div>
                        <div class="form-group col-4 mt-3">
                            <label for="tarifa">Tarifa de la cita</label>
                            <input type="number" class="form-control" name="tarifa" value="10" required="required">
                        </div>

                        <div class="mt-3">
                            <input type="submit" class="btn btn-primary" name="enviar" value="Guardar"/>
                        </div>

                    </form>
                    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>
                </div>
            </div>
            <div class="row">
                <div class="col-sm">
                    <%
                        String numeroStr = request.getParameter("numero");
                        String tipoStr = request.getParameter("tipo");
                        String tarifaStr = request.getParameter("tarifa");
                        if (numeroStr != null && tarifaStr != null) {

                    %>
                    <div class="alert alert-primary mt-3" role="alert">
                        <%                        int numero = Integer.parseInt(numeroStr);
                            int tipo = Integer.parseInt(tipoStr);
                            double tarifa = Double.parseDouble(tarifaStr);
                            Cita cita = new Cita(numero, tipo, tarifa);
                            String resultado = "El número de la cita es: " + cita.getNumero() + ", esta cita es de tipo: " + cita.getTipo()
                                    + ", su tarifa normal es de: " + cita.getTarifa() + " pesos; pero por ser de tipo " + cita.getTipo() + " queda con un valor final de " + cita.calcularValorFinal();
                            out.println(resultado);
                        %>
                    </div>
                    <% }%>
                </div>
            </div>
        </div>
    </body>
</html>