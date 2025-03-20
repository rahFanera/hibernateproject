<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Ajouter un Professeur</title>
    <script src="assets/tailwind.js" type="text/javascript"></script>
</head>
<body class="bg-gray-50">

<main class="flex flex-col h-screen items-center justify-center">
<section class="flex flex-col bg-white shadow rounded p-5 border border-gray-200 gap-8">
    <h2 class="text-xl font-semibold text-blue-900">Ajouter un nouveau Professeur</h2>
    <form action="ProfesseurAdd" method="post" class="flex flex-col gap-2">
        <label for="codeprof" class="text-sm">Codeprof</label>
        <input class="px-3 py-1 rounded border border-gray-200 outline-none text-sm focus:border-blue-900 "
                type="text" id="codeprof" name="codeprof" required>

        <label for="nom" class="text-sm">Nom </label>
        <input class="px-3 py-1 rounded border border-gray-200 outline-none text-sm focus:border-blue-900 "
                type="text" id="nom" name="nom" required>

        <label for="prenom" class="text-sm">Prénom(s)</label>
        <input class="px-3 py-1 rounded border border-gray-200 outline-none text-sm focus:border-blue-900 "
                type="text" id="prenom" name="prenom" required>

        <label for="grade" class="text-sm">Grade</label>
        <input class="px-3 py-1 rounded border border-gray-200 outline-none text-sm focus:border-blue-900 "
                type="text" id="grade" name="grade" required>

        <button class="px-3 py-2 rounded text-sm bg-blue-900 text-white mt-3 cursor-pointer"
                type="submit">Ajouter</button>
    </form>
    <a href="ProfesseurList" class="text-center text-sm text-blue-900 underline">Retourner a la liste des Professeurs</a>
</section>
</main>
</body>
</html>
