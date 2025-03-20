<section id="modal" class="fixed z-50 inset-0 bg-black/10 backdrop-blur-sm flex justify-center items-center hidden">
  <div class="bg-gray-50 rounded-lg shadow-lg p-6 max-w-xl w-full">

    <p class="text-gray-700 mt-4">
      Utilisation Hibernate avec une base de donnees de type PostgrSQL
    </p>
    <br/>
    <strong class="text-blue-900">Les classes d'objet :</strong>
    <ul>
      <li>PROF ( codeprof, nom, prenom, grade )</li>
      <li>SALLE ( codesal, designation )</li>
      <li>OCCUPER ( codeprof, codesal, date )</li>
    </ul>
    <br/>
    <strong class="text-blue-900">Les traitements :</strong>
    <ul>
      <li>Cote client : Application web avec JSP</li>
      <li>Mapper les trois classe d'objet</li>
      <li>CRUD sur les trois tables</li>
      <li>Recherche des profs par son code ou son nom</li>
    </ul>
    <button id="closeModalBtn"></button>
  </div>
</section>