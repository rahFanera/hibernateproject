# Utilisation Hibernate avec une base de donnees de type PostgrSQL


1. <strong>Les classes d'objet :</strong>
<pre>
PROF ( codeprof, nom, prenom, grade )
SALLE ( codesal, designation )
OCCUPER ( codeoccuper, codeprof, codesal, date )
</pre>

2. <strong>Les traitements :</strong>
<ul>
<li>Cote client : Application web avec JSP</li>
<li>Mapper les trois classe d'objet</li>
<li>CRUD sur les trois tables</li>
<li>Rechercher des profs par son code, son nom, son prenom ou son grade</li>
</ul>