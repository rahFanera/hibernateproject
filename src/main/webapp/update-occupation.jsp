<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Modifier l'occupation</title>
</head>
<body>
<h2>Modifier l'occupation</h2>

<form action="OccuperUpdate" method="post">
  <input type="hidden" name="codeoccuper" value="${occuper.codeoccuper}">

  <label for="codeprof">Nom du Prof:</label>
  <select id="codeprof" name="codeprof" required>
    <c:forEach var="professeur" items="${professeurs}">
      <option value="${professeur.codeprof}" <c:if test="${professeur.codeprof == occuper.professeur.codeprof}">selected</c:if>>
          ${professeur.nom} ${professeur.prenom}
      </option>
    </c:forEach>
  </select>

  <br>

  <label for="codesalle">Designation de la Salle:</label>
  <select id="codesalle" name="codesalle" required>
    <c:forEach var="salle" items="${salles}">
      <option value="${salle.codesalle}" <c:if test="${salle.codesalle == occuper.salle.codesalle}">selected</c:if>>
          ${salle.designation}
      </option>
    </c:forEach>
  </select>

  <br>

  <label for="date">Date d'occupation:</label>
  <input type="date" id="date" name="date" value="${occuper.date}" required><br>

  <button type="submit">Mettre à jour</button>
</form>

<br>
<a href="list-occupation.jsp">Retour à la liste des occupations</a>
</body>
</html>
