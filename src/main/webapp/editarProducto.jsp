<%--
  Created by IntelliJ IDEA.
  User: newma
  Date: 08-06-2023
  Time: 18:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="styles.css">
    <title>Editar Producto</title>
</head>
<body>
    <main>
        <nav class="n-bar">
            <ul>
                <li><strong><a href="index.jsp">Tienda Web</a></strong></li>
            </ul>
            <ul>
                <li><a href="crearProducto.jsp">Crear Producto</a></li>
                <li><a href="crearCliente.jsp">Agregar Cliente</a></li>
                <li><a href="buscarProducto.jsp" role="button">Busqueda de articulo</a></li>
            </ul>
        </nav>
        <article>
            <section class="e-product-form">
                <h1>Editar producto seleccionado</h1>
                <form action="editarProducto" method="post">
                    <input name="tipo de construccion" type="text" hidden="hidden" value="${tipoConstruccion}">
                    <input name="ubicacion" placeholder="Nombre" type="text" value="${ubicacion}">
                    <input type="number" name="precio" placeholder="$$$ Precio" value="${precio}">
                    <button type="submit">Editar</button>
                </form>
            </section>
        </article>
    </main>
</body>
</html>
