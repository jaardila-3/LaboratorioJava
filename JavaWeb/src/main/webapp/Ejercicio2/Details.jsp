<%-- 
    Document   : Details
    Created on : 2/10/2021, 11:41:15 a. m.
    Author     : alex
--%>
<%@page import="ejercicio2.Bus" %>

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
                        String placa = request.getParameter("placa");
                        String capacidadPasajeros = request.getParameter("capacidadPasajeros");
                        String precioPasaje = request.getParameter("precioPasaje");
                        if (placa != null && capacidadPasajeros != null && precioPasaje != null) {
                            int capacidad = Integer.parseInt(capacidadPasajeros);
                            double pasaje = Double.parseDouble(precioPasaje);
                            Bus bus = new Bus(placa, capacidad, pasaje);
                        }
                        //variables utilizadas mas abajo y que se vuelven a enviar a este formulario
                        if (request.getParameter("subirPasajeros") != null) {
                            int subirPasajeros = Integer.parseInt(request.getParameter("subirPasajeros"));
                            Bus.bus.subirPasajeros(subirPasajeros);
                        }
                        if (request.getParameter("bajarPasajeros") != null) {
                            int bajarPasajeros = Integer.parseInt(request.getParameter("bajarPasajeros"));
                            Bus.bus.bajarPasajeros(bajarPasajeros);
                        }
                        if (Bus.bus.getPlaca() != null) {
                            int control = Bus.bus.getCapacidadPasajeros() - Bus.bus.getPasajerosActuales();
                    %>
                    <!-- Button trigger modal Placa -->
                    <button type="button" class="btn btn-success" data-bs-toggle="modal" data-bs-target="#staticPlaca">
                        Obtener placa
                    </button>

                    <!-- Modal -->
                    <div class="modal fade" id="staticPlaca" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="staticBackdropLabel">Placa del bus</h5>
                                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                </div>
                                <div class="modal-body">
                                    <%=Bus.bus.getPlaca()%>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
                                </div>
                            </div>
                        </div>
                    </div>

                    <!-- Button trigger modal capacidad -->
                    <button type="button" class="btn btn-secondary" data-bs-toggle="modal" data-bs-target="#staticCapacidad">
                        Obtener capacidad
                    </button>

                    <!-- Modal -->
                    <div class="modal fade" id="staticCapacidad" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="staticBackdropLabel">Capacidad del bus</h5>
                                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                </div>
                                <div class="modal-body">
                                    <%=Bus.bus.getCapacidadPasajeros()%>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
                                </div>
                            </div>
                        </div>
                    </div>

                    <!-- Button trigger modal precio -->
                    <button type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#staticPrecio">
                        Obtener precio
                    </button>

                    <!-- Modal -->
                    <div class="modal fade" id="staticPrecio" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="staticBackdropLabel">Precio del Pasaje</h5>
                                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                </div>
                                <div class="modal-body">
                                    <%=Bus.bus.getPrecioPasaje()%>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
                                </div>
                            </div>
                        </div>
                    </div>

                    <!-- Button trigger modal pasajeros actuales -->
                    <button type="button" class="btn btn-warning" data-bs-toggle="modal" data-bs-target="#staticPasajeros">
                        Pasajeros actuales
                    </button>

                    <!-- Modal -->
                    <div class="modal fade" id="staticPasajeros" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="staticBackdropLabel">Pasajeros actuales</h5>
                                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                </div>
                                <div class="modal-body">
                                    <%=Bus.bus.getPasajerosActuales()%>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
                                </div>
                            </div>
                        </div>
                    </div>


                    <!-- Button trigger modal pasajeros totales -->
                    <button type="button" class="btn btn-info" data-bs-toggle="modal" data-bs-target="#staticPasajerosTotales">
                        Total pasajeros
                    </button>

                    <!-- Modal -->
                    <div class="modal fade" id="staticPasajerosTotales" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="staticBackdropLabel">Total pasajeros</h5>
                                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                </div>
                                <div class="modal-body">
                                    <%=Bus.bus.getTotalPasajeros()%>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
                                </div>
                            </div>
                        </div>
                    </div>


                    <!-- Button trigger modal dinero acumulado -->
                    <button type="button" class="btn btn-dark" data-bs-toggle="modal" data-bs-target="#staticAcumulado">
                        Dinero acumulado
                    </button>

                    <!-- Modal -->
                    <div class="modal fade" id="staticAcumulado" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="staticBackdropLabel">Dinero acumulado</h5>
                                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                </div>
                                <div class="modal-body">
                                    <%=Bus.bus.getDineroAcumulado()%>
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
                                <label for="subirPasajeros">Subir pasajeros al bus (max:<%=control%>)</label>                            
                                <input type="number" class="form-control" name="subirPasajeros" value="0" max="<%=control%>" required="required cantidad">
                            </div>

                            <div class="col-6 mt-3 mb-3">
                                <label for="bajarPasajeros">Bajar pasajeros del bus (max:<%=Bus.bus.getPasajerosActuales()%>)</label>
                                <input type="number" class="form-control" name="bajarPasajeros" value="0" max="<%=Bus.bus.getPasajerosActuales()%>" required="required cantidad">
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
