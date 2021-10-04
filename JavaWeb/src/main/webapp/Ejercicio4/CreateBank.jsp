<%-- 
    Document   : CreateBank
    Created on : 4/10/2021, 3:19:40 p. m.
    Author     : alex
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="ejercicio4.Banco" %>
<%Banco.banco.reset(); %>

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

                    <h1 class="mt-4">Datos de la cuenta</h1>

                    <form action="Details.jsp" method="post">

                        <div class="form-group col-4 mt-3">
                            <label for="cuenta">Número de la cuenta</label>
                            <input type="text" class="form-control" name="cuenta" value="0000-0000-0001" required="required">
                        </div>

                        <div class="form-group col-4 mt-3">
                            <label for="tipo">Seleccione el tipo de cuenta</label>
                            <select class="form-control" name="tipo">
                                <option value="ahorro">ahorro</option>
                                <option value="credito">crédito</option>                                
                            </select>
                        </div>                                                

                        <div class="form-group col-4 mt-3">
                            <label for="inicial">Valor inicial</label>
                            <input type="number" class="form-control" name="inicial" value="100" required="required" min="100">
                        </div>

                        <div class="mt-3">
                            <input type="submit" class="btn btn-primary" name="enviar" value="Guardar"/>
                        </div>

                    </form>
                </div>
            </div>            
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>
    </body>
</html>
