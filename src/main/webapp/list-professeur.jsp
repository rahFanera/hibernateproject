<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Gestion des Professeurs</title>
    <script src="assets/tailwind.js" type="text/javascript"></script>
</head>
<body>

    <jsp:include page="header.jsp" />
    <jsp:include page="modal.jsp" />

    <nav class="flex flex-row justify-center items-center py-5 px-8 gap-8">
        <a href="index.jsp" class="text-blue-900 font-semibold">Accueil</a>
        <a href="ProfesseurList" class="text-blue-900 font-semibold border-b-2">Professeurs</a>
        <a href="SalleList" class="text-blue-900 font-semibold">Salles</a>
        <a href="OccuperList" class="text-blue-900 font-semibold">Occupations</a>
    </nav>

    <main>

    <section class="flex flex-row justify-center items-center py-5 px-8 gap-8">
        <form action="ProfesseurSearch" method="get">
            <input type="text" name="keyword"
                   class="px-3 py-1 rounded border border-gray-500 outline-none text-sm focus:border-blue-900 "
                   value="${param.keyword}"
                   placeholder="Rechercher un professeur..." required>
            <button type="submit" class="bg-blue-900 text-white outline-none rounded px-3 py-1.5 text-sm">Rechercher</button>
        </form>
        <a href="ProfesseurList">Reinitialiser</a>
    </section>

    <section class="flex flex-col items-center justify-center mt-5">
        <table>
            <thead>
            <tr>
                <th class="px-5 py-2">Codeprof</th>
                <th class="px-5 py-2">Nom</th>
                <th class="px-5 py-2">Prenom(s)</th>
                <th class="px-5 py-2">Grade</th>
                <th class="px-5 py-2">Actions</th>
            </tr>
            </thead>
            <tbody>
            <c:choose>
                <c:when test="${not empty professeurs}">
                    <c:forEach var="professeur" items="${professeurs}">
                        <tr>
                            <td class="px-5 py-2 text-gray-500">${professeur.codeprof}</td>
                            <td class="px-5 py-2">${professeur.nom}</td>
                            <td class="px-5 py-2">${professeur.prenom}</td>
                            <td class="px-5 py-2">${professeur.grade}</td>
                            <td colspan="2" class="flex px-5 py-2 gap-5">
                                <a href="ProfesseurUpdate?codeprof=${professeur.codeprof}"
                                   class="text-blue-500"
                                >Modifier</a>
                                <a class="text-red-500"
                                href="ProfesseurDelete?codeprof=${professeur.codeprof}" onclick="return confirm('Êtes-vous sûr de vouloir supprimer ce professeur ?');">Supprimer</a>
                            </td>
                        </tr>
                    </c:forEach>
                </c:when>
                <c:otherwise>
                    <tr><td class="text-gray-500 text-center" colspan="5">Aucun professeur trouve</td></tr>
                </c:otherwise>
            </c:choose>
            </tbody>
        </table>

        <a href="ProfesseurAdd"
           class="font-bold text-md text-blue-900 px-4 py-2 rounded-full bg-gray-200 shadow-md mt-5"
        >+</a>
    </section>
    </main>
<script src="assets/script-modal.js"></script>
</body>
</html>
