<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Gestion des Salles</title>
    <script src="assets/tailwind.js" type="text/javascript"></script>
</head>
<body>

<jsp:include page="header.jsp" />
<jsp:include page="modal.jsp" />

<nav class="flex flex-row justify-center items-center py-5 px-8 gap-8">
    <a href="index.jsp" class="text-blue-900 font-semibold">Accueil</a>
    <a href="ProfesseurList" class="text-blue-900 font-semibold">Professeurs</a>
    <a href="SalleList" class="text-blue-900 font-semibold border-b-2">Salles</a>
    <a href="OccuperList" class="text-blue-900 font-semibold">Occupations</a>
</nav>
<main class="flex flex-col items-center justify-center mt-5">
    <table>
        <thead>
        <tr>
            <th>CodeSalle</th>
            <th>Designation</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:choose>
            <c:when test="${not empty salles}">
                <c:forEach var="salle" items="${salles}">
                    <tr>
                        <td>${salle.codesalle}</td>
                        <td>${salle.designation}</td>
                        <td colspan="2">
                            <a href="SalleUpdate?codesalle=${salle.codesalle}">Modifier</a> |
                            <a href="SalleDelete?codesalle=${salle.codesalle}" onclick="return confirm('Êtes-vous sûr de vouloir supprimer cette salle ?');">Supprimer</a>
                        </td>
                    </tr>
                </c:forEach>
            </c:when>
            <c:otherwise>
                <tr><td>Aucune salle trouvee</td></tr>
            </c:otherwise>
        </c:choose>
        </tbody>
    </table>

    <a href="SalleAdd">Ajouter une salle</a>
</main>

<script src="assets/script-modal.js"></script>
</body>
</html>
