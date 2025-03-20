<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.fanera.hibernateproject.model.Professeur, com.fanera.hibernateproject.model.Salle" %>
<%@ page import="com.fanera.hibernateproject.dao.ProfesseurDao, com.fanera.hibernateproject.dao.SalleDao" %>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ajouter une occupation</title>
</head>
<body>
<h2>Ajouter une occupation</h2>

<form action="OccuperAdd" method="post">
    <label for="codeprof">Prof :</label>
    <select id="codeprof" name="codeprof" required>
        <option value="">Sélectionner un Prof</option>
        <%
            ProfesseurDao professeurDao = new ProfesseurDao();
            List<Professeur> professeurs = professeurDao.findAllProfesseurs();
            for (Professeur professeur : professeurs) {
        %>
        <option value="<%= professeur.getCodeprof() %>">
            <%= professeur.getNom() %>
            <%= professeur.getPrenom() %>
        </option>
        <%
            }
        %>
    </select>
    <br>

    <label for="codesalle">Salle :</label>
    <select id="codesalle" name="codesalle" required>
        <option value="">Sélectionner une salle</option>
        <%
            SalleDao salleDao = new SalleDao();
            List<Salle> salles = salleDao.getAllSalles();
            for (Salle salle : salles) {
        %>
        <option value="<%= salle.getCodesalle() %>"><%= salle.getDesignation() %></option>
        <%
            }
        %>
    </select>
    <br>

    <label for="date">Date :</label>
    <input type="date" id="date" name="date" required><br>

    <button type="submit">Ajouter</button>
</form>
</body>
</html>
