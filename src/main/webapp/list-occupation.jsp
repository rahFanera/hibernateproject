<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Gestion des Occupations</title>
    <script src="assets/tailwind.js" type="text/javascript"></script>
</head>
<body>

    <jsp:include page="header.jsp" />
    <jsp:include page="modal.jsp" />

    <nav class="flex flex-row justify-center items-center py-5 px-8 gap-8">
        <a href="index.jsp" class="text-blue-900 font-semibold">Accueil</a>
        <a href="ProfesseurList" class="text-blue-900 font-semibold">Professeurs</a>
        <a href="SalleList" class="text-blue-900 font-semibold">Salles</a>
        <a href="OccuperList" class="text-blue-900 font-semibold border-b-2">Occupations</a>
    </nav>

    <main>
        <section class="flex flex-row justify-center items-center py-5 px-8 gap-8">
            <form action="OccuperSearch" method="get">
                <input type="text" name="keyword" placeholder="Rechercher..."
                       class="px-3 py-1 rounded border border-gray-500 outline-none text-sm focus:border-blue-900 "
                       value="${param.keyword}">
                <button type="submit" class="bg-blue-900 text-white outline-none rounded px-3 py-1.5 text-sm">Rechercher</button>
            </form>

            <a href="OccuperList">Reinitialiser</a>
        </section>
        <section class="flex flex-col items-center justify-center mt-5">
            <table>
                <tr>
                    <th class="px-5 py-2">#</th>
                    <th class="px-3 py-2">Prof</th>
                    <th class="px-3 py-2">Salle</th>
                    <th class="px-3 py-2">Date</th>
                    <th class="px-3 py-2">Actions</th>
                </tr>

                <c:choose>
                    <c:when test="${not empty occupations}">
                        <c:forEach var="occupation" items="${occupations}">
                            <tr>
                                <td class="px-5 py-2 text-gray-500">${occupation.codeoccuper}</td>
                                <td class="px-5 py-2">${occupation.professeur.nom} ${occupation.professeur.prenom}</td>
                                <td class="px-5 py-2">${occupation.salle.designation}</td>
                                <td class="px-5 py-2">${occupation.date}</td>
                                <td colspan="2" class="flex px-5 py-2 gap-5">
                                    <a href="OccuperEdit?codeoccuper=${occupation.codeoccuper}"
                                    class="text-blue-500"
                                    >Modifier</a>
                                    <a class="text-red-500"
                                    href="OccuperDelete?codeoccuper=${occupation.codeoccuper}" onclick="return confirm('Êtes-vous sûr de vouloir supprimer cette occupation ?');">Supprimer</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        <tr>
                            <td colspan="5" class="text-gray-500 text-center">Aucune occupation trouvée.</td>
                        </tr>
                    </c:otherwise>
                </c:choose>
            </table>

            <a href="add-occupation.jsp"
               class="font-bold text-md text-blue-900 px-4 py-2 rounded-full bg-gray-200 shadow-md mt-5">
                +
            </a>

        </section>
    </main>

    <script src="assets/script-modal.js"></script>
</body>
</html>
