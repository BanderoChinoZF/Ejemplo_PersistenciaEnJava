<%-- 
    Document   : index
    Created on : 3/06/2020, 04:59:22 PM
    Author     : luisa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
        <title>PERSISTENCIA EN JAVA</title>
    </head>
    <body>
        <br>
        <div class="container" align="center">
            <h1>Ejemplo De Persistencia :v</h1>
            <br>
            
            <!--  -->
            <form name="formulario" method="post" action="Guardar">
                
                Nombre: <input name="nombres" type="text" required> <br>
                Apellidos: <input name="apellidos" type="text" required> <br>
                Direccion: <input name="direccion" type="text" required> <br>
                
                <input type="submit" value="Registrar" class="btn btn-primary">
                
                
            </form>
            
            
            
            
        </div>
    </body>
</html>
