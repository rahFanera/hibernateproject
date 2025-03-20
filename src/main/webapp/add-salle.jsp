<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Ajouter une salle</title>
</head>
<body>
<div class="container">
    <h2>Ajouter une Salle</h2>
    <form action="SalleAdd" method="post">
        <label for="codesalle">CodeSalle :</label>
        <input type="text" id="codesalle" name="codesalle" required>

        <label for="designation">Designation :</label>
        <input type="text" id="designation" name="designation" required>

        <button type="submit">Ajouter</button>
    </form>
    <a href="SalleList">Voir la liste des Salles</a>
</div>
</body>
</html>
