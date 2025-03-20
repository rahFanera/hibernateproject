<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <title>Projet 09 - Hibernate</title>
    <script src="assets/tailwind.js" type="text/javascript"></script>
</head>
<body class="bg-gray-50">
    <jsp:include page="header.jsp" />

    <main>
        <jsp:include page="modal.jsp" />

        <section class="flex items-center justify-center gap-5 fixed h-100 w-full">
            <a href="ProfesseurList" class="p-5 bg-white rounded-md shadow">Professeurs</a>
            <a href="SalleList" class="p-5 bg-white rounded-md shadow">Salles</a>
            <a href="OccuperList" class="p-5 bg-white rounded-md shadow">Occupations</a>
        </section>
    </main>

    <script src="assets/script-modal.js"></script>
</body>
</html>