<h1>Spring Angular Spring Security JWT : E-Banking</h1>
<h2>Introduction</h2>
<p>
L'objectif est de développer une application de gestion de comptes bancaires en trois étapes clés. La première consiste à créer la couche DAO avec Spring Boot, la deuxième à concevoir l'interface utilisateur avec Angular, et la troisième à assurer la sécurité via Spring Security et les JSON Web Tokens.

L'application permettra la gestion complète des comptes bancaires, avec deux types distincts : courants et épargnes.


<h2>Conception:</h2>
<img src="captures/useCase.png">

<h2>Partie 1 : Couche DAO et Service</h2>

<h3>Création du Projet Spring Boot:</h3>
<p>La phase inaugurale de notre projet requiert l'établissement de l'environnement de 
développement par le biais de la création d'un projet Spring Boot. Reconnu pour son infrastructure rationalisée, 
Spring Boot facilite le développement d'applications Java en autorisant une configuration expéditive et une gestion 
fluide des dépendances.</p>

<h3>Création des entités JPA : Customer, BankAccount, Saving Account, CurrentAccount, AccountOperation:</h3>
<p>Une fois le projet Spring Boot établi, l'étape cruciale suivante réside dans la création des entités JPA (Java Persistence API). Ces entités, comprenant Customer, BankAccount, Saving Account, CurrentAccount et AccountOperation, dictent 
la structure des données maniées par l'application. Chaque entité constitue une table dans la base de données, et 
les relations qui les lient reflètent la logique métier inhérente au système bancaire.</p>
<img src="captures/entities.png">

<h3>Création des interfaces JPA Repository basées sur Spring Data:</h3>
<p>Les interfaces JPA Repository, s'appuyant sur Spring Data, revêtent 
une importance cruciale en facilitant l'accès aux données. En définissant ces interfaces, 
nous exploitons la puissance de Spring Data pour générer automatiquement les requêtes SQL requises 
pour les opérations CRUD (Create, Read, Update, Delete). Cette approche simplifie significativement 
la couche DAO en éliminant la nécessité de rédiger manuellement des requêtes SQL.</p>
<img src="captures/repos.png">

<h3>Mapping Héritage:</h3>
<p>Dans ce projet nous allons essayer les 3 strategies à noter le Single Table , Table Per class et Joined</p>
<img src="captures/mappingHeritage.png">

<h4>Stratégie "Single Table":</h4>
<p>CurentAccount entitie</p>
<img src="captures/single4.png">
<p>SavingAccount entitie</p>
<img src="captures/single5.png">
<p>BankAccount entitie</p>
<img src="captures/single6.png">
<p>Simulation H2database : all customers</p>
<img src="captures/single1.png">
<p>Simulation H2database : Bank_Account Customer </p>
<img src="captures/single2.png">
<p>Simulation H2database : Account_Operation Customer </p>
<img src="captures/single3.png">

<h4>Stratégie "Table Per Class":</h4>
<p>CurentAccount entitie</p>
<img src="captures/perClass1.png">
<p>SavingAccount entitie</p>
<img src="captures/perClass2.png">
<p>BankAccount entitie</p>
<img src="captures/perClass3.png">

<img src="captures/perClass4.png">
<img src="captures/perClass5.png">
<img src="captures/perClass6.png">
<img src="captures/perClass7.png">

<h4>Stratégie "Joined":</h4>
<p>CurentAccount entitie</p>
<img src="captures/joined.png">
<p>SavingAccount entitie</p>
<img src="captures/joined1.png">
<p>BankAccount entitie</p>
<img src="captures/joined2.png">

<img src="captures/joined3.png">
<img src="captures/joined4.png">
<img src="captures/joined5.png">


<h3>Consultation d'un customer:</h3>
<img src="captures/consulter.png">


<h3>Basculement vers MySQL en utilisant la stratégie "Single Table":</h3>
<img src="captures/mysql.png">
<img src="captures/BaseDeDonnée.png">

<h3>Affichage des customers sous format json:</h3>
<img src="captures/cust.png">

