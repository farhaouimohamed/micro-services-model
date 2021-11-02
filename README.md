# micro-services-model

Exemple d'une application développé en micro service qui est constitué par 4 projets spring boot :
#### *Billing service :
microservice qui constitue la facture d'un client (les opérations crud associés à une facture).

#### *Constumer service : 
microservice qui constitue le client (les opérations crud associés à une facture).

#### *Gateway :
C'est comme un canal de communication entre le IHM et les microservices, ce canal communique avec le discovery service pour récupérer les informations nécessaires pour chaque microservice déployé.

#### *Discovery service :
C'est un espace qui porte toutes les informations associés à un web service comme le host, le port .....
