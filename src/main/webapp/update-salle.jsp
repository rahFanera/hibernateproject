<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Modification</title>
</head>
<body>
<h2>Modifier une salle</h2>

<form action="SalleUpdate" method="post">
  <input type="hidden" name="codesalle" value="${salle.codesalle}">

  <label for="designation">Designation :</label>
  <input type="text" id="designation" name="designation" value="${salle.designation}" required>

  <button type="submit">Mettre à jour</button>
</form>
<a href="SalleList">Annuler</a>
</body>
</html>
