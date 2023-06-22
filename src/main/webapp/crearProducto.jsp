<%--
  Created by IntelliJ IDEA.
  User: newma
  Date: 08-06-2023
  Time: 8:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="styles.css">

    <title>Crear producto</title>
</head>
<body>
    <main>
        <nav class="n-bar">
            <ul>
                <li><strong><a href="index.jsp">Tienda Web</a></strong></li>
            </ul>
            <ul>
                <li><a href="crearProducto.jsp">Agregar inmueble</a></li>
                <li><a href="crearCliente.jsp">Agregar Vendedor</a></li>
                <li><a href="buscarProducto.jsp" role="button">Busqueda de inmuebles</a></li>
            </ul>
        </nav>
        <article>
            <section class="product-form">
                <form action="registroProducto" method="post">
                    <h1>Registrar producto</h1>
                    <input placeholder="tipo de construccion" name="ubicacion" type="text" required>
                    <input type="number" name="precio" placeholder="$$$ Precio">
                    <button type="submit">Registrar Producto</button>
                </form>
                <%
                    String mensaje = (String) request.getAttribute("status");
                    if (mensaje != null && !mensaje.isEmpty()) {
                %>
                <h2><%= mensaje %></h2>
                <%
                    }
                %>
            </section>
        </article>
    </main>
</body>
</html>
