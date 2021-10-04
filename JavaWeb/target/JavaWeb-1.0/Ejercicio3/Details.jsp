<%-- 
    Document   : Details
    Created on : 4/10/2021, 11:55:27 a. m.
    Author     : alex
--%>
<%@page import="ejercicio3.Cuenta" %>

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
                        <a href="Create.jsp">Volver</a>
                    </div>

                    <h1 class="mt-4">Recorrido del Bus</h1>
                    <%
                        String cuenta = request.getParameter("cuenta");
                        String tipo = request.getParameter("tipo");
                        String inicial = request.getParameter("inicial");
                        if (cuenta != null && tipo != null && inicial != null) {
                            double ValorInicial = Double.parseDouble(inicial);
                            Cuenta cuenta1 = new Cuenta(cuenta, tipo, ValorInicial);
                        }
                        //variables utilizadas mas abajo y que se vuelven a enviar a este formulario
                        if (request.getParameter("consignar") != null) {
                            int consignar = Integer.parseInt(request.getParameter("consignar"));
                            Cuenta.cuenta.consignar(consignar);
                        }
                        if (request.getParameter("retirar") != null) {
                            int retirar = Integer.parseInt(request.getParameter("retirar"));
                            Cuenta.cuenta.retirar(retirar);
                        }
                        if (Cuenta.cuenta.getSaldoActual() > 0) {
                            double control = Cuenta.cuenta.getSaldoActual() - Cuenta.cuenta.getSaldoMinimo();
                    %>
                    <!-- Button trigger modal Saldo -->
                    <button type="button" class="btn btn-success" data-bs-toggle="modal" data-bs-target="#staticSaldo">
                        Obtener saldo
                    </button>

                    <!-- Modal -->
                    <div class="modal fade" id="staticSaldo" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="staticBackdropLabel">Obtener saldo actual</h5>
                                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                </div>
                                <div class="modal-body">
                                    <%=Cuenta.cuenta.getSaldoActual()%>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
                                </div>
                            </div>
                        </div>
                    </div>

                    <!-- Button trigger modal minimo en cuenta-->
                    <button type="button" class="btn btn-secondary" data-bs-toggle="modal" data-bs-target="#staticMinimo">
                        Saldo mínimo
                    </button>

                    <!-- Modal -->
                    <div class="modal fade" id="staticMinimo" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="staticBackdropLabel">Saldo mínimo en cuenta</h5>
                                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                </div>
                                <div class="modal-body">
                                    <%=Cuenta.cuenta.getSaldoMinimo()%>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
                                </div>
                            </div>
                        </div>
                    </div>

                    <!-- Button trigger modal crédito -->
                    <button type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#staticCredito">
                        Capacidad crédito
                    </button>

                    <!-- Modal -->
                    <div class="modal fade" id="staticCredito" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="staticBackdropLabel">Capacidad de crédito</h5>
                                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                </div>
                                <div class="modal-body">
                                    <%=Cuenta.cuenta.getCapacidadCredito()%>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
                                </div>
                            </div>
                        </div>
                    </div>


                    <div class="col-6 mt-3">
                        <form action="Details.jsp" method="post">
                            <div class="col-6">
                                <label for="consignar">Consignar</label>                            
                                <input type="number" class="form-control" name="consignar" value="0" required="required cantidad">
                            </div>

                            <div class="col-6 mt-3 mb-3">
                                <label for="retirar">Retirar (max: <%=control%>)</label>
                                <input type="number" class="form-control" name="bajarPasajeros" value="0" max="<%=control%>" required="required cantidad">
                            </div>

                            <input type="submit" class="btn btn-primary" value="Enviar"/>

                        </form>
                    </div>

                    <%
                    } else {
                    %>
                    <div class="alert alert-primary mt-3" role="alert">Error al enviar los datos</div>
                    <%
                        }
                    %>

                </div>
            </div>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>

    </body>
</html>
