# Système de Gestion des Factures avec Spring Boot
Application web développée avec Spring Boot et Thymeleaf pour la gestion des clients et leurs factures.
## Gestion des Données
### Base de Données
- Base de données MySQL
- Implémentation JPA avec Spring Data
- Validation Jakarta
- Repositories extensibles (CrudRepository)
### Fonctionnalités de Gestion
#### Gestion des Clients
- CRUD complet (Création, Lecture, Mise à jour, Suppression)
- Validation des données
- Historique des factures par client
- Statistiques détaillées
#### Gestion des Factures
- Création avec sélection dynamique du client
- Mise à jour des montants et dates
- Suppression
- Calcul automatique des totaux
## Interface Utilisateur Moderne
### Design
- Effets glassmorphisme
- Animations fluides
- Fond dynamique
- Composants personnalisés:
  - Menu déroulant moderne
  - Boutons animés
  - Tableaux responsifs
### Technologies Frontend
- Thymeleaf
- CSS personnalisé
- Design responsive
## Structure du Projet
```
src/
├── main/
│   ├── java/ma/ensa/projet/
│   │   ├── controllers/
│   │   ├── entities/
│   │   └── repository/
│   └── resources/
│       ├── static/css/
│       └── templates/
```
## Diagramme de Classe
### Entités Principales
#### 1. Client
- Entité principale avec contraintes de validation
- Attributs:
  - `id`: Identifiant unique (Long)
  - `nom`: Nom du client (String, NotBlank)
  - `adresse`: Adresse du client (String, NotBlank)
  - `telephone`: Numéro de téléphone (String, NotBlank)
- Relation One-to-Many avec Facture (Un client peut avoir plusieurs factures)
- Annotations JPA pour la persistance
#### 2. Facture
- Entité secondaire avec validation
- Attributs:
  - `id`: Identifiant unique (Long)
  - `date`: Date de la facture (Date, NotNull, Format: yyyy-MM-dd)
  - `montantTotal`: Montant total (Double, NotNull)
- Relation Many-to-One avec Client (Plusieurs factures pour un client)
- Annotations de formatage pour la date
### Repositories
#### 1. ClientRepository
- Extension de CrudRepository<Client, Long>
- Hérite des opérations CRUD standards
#### 2. FactureRepository
- Extension de CrudRepository<Facture, Long>
- Hérite des opérations CRUD standards
### Relations
- Client ←→ Facture: Relation bidirectionnelle One-to-Many
- Hiérarchie d'héritage des repositories représentée
- Toutes les contraintes de validation incluses
![image](https://github.com/user-attachments/assets/d04a2071-9415-4b94-a128-b13ed678aaab)
## Installation
1. Cloner le projet
2. Configurer application.properties:
```properties
spring.datasource.url = jdbc:mysql://localhost:3306/projet

spring.datasource.username = root

spring.datasource.password =
```
3. Démarrer l'application:
```bash

mvn spring-boot:run

```
4. Accéder à http://localhost:8080
## Video Demo


https://github.com/user-attachments/assets/910b7336-9a46-4fee-9b69-6f48aa556fff


---

Développé dans le cadre du projet de Contrôle - ENSAJ

Alioui Jaâfar
