# DeckOfCardsGame
This app is composed by a Frontend written in ReactJS and Typescript and a Backend written in Java and using JPA, Hibernate and Spring.

# Frontend
To run this project, import the client folder to an IDE of your choice (e.g. Visual Studio). For more details, check the README file inside the client folder.

It should look like the following.

![Alt text](./client/frontend.png?raw=true "Frontend")

# Backend

The data for the game and the player is persisted into an in-memory database named H2. Hibernate and JPA allow the adoption of different DBs, such as PostgreSQL and MySQL easily just by changing the Properties files. Refer to the route /h2-console/ to access the DB.

The data for the cards, the game shoe and the card statistics is persisted in the JVM only and it does not get persisted to tables like we do for Game and Player. This was done for simplification and performance, since drawing and sorting cards is done often.


The images below show the UI along with all the available routes served by the backend.
The backend responds when accessing the IP and port to which it is configured, and if no route is passed it will serve the Swagger UI instead, where the user will be able to see all the possible routes listed.

For example, if the server runs on localhost and port 8080 and you send a GET request to localhost:8080/players, then the backend will reply with a JSON containing the list of all players. However, if you send a request without routes (e.g. localhost:8080), then the browser will responde with the Swagger UI and list you all the routes.

# Player Controller

Below is a list of all the routes hooked to the Player entity. The last route is expanded to illustrate how it works. Clicking on a route expands its controls.

![Alt text](./backend/player.png?raw=true "Player Routes")

# Game Controller

Similar to the Player Controller, the game controller will serve data that is related to the game and the cards. The list of all the routes is detailed below.

![Alt text](./backend/game.png?raw=true "Player Routes")

# Unit Tests and Integration Tests

During the first day of the assignments, I was writing Unit Tests and Integration Tests (i.e. would go through the database) as I implemented the models and interfaces.

At some point I was having severe issues related to persisting compositions to the database using Hibernate and JPA, so I simply started from scratch.

However, during this second attempt I was in a hurry and did not write the unit tests again. This was a big mistake, since this small investment of time would pay off quickly and help me promptly detect issues that emerged from changing the interfaces while introducing the features.

I am providing the ones used on the original implementation which is equivalent except to how Game and Players relate.

# Possible Improvements

Some improvements can be easily identified and implemented as next steps for the current project.

First and foremost, adapt and reintroduce Unit Tests and Integration Tests. They would give much confidence to implement new features and modify existing ones.

We are currently ordering the players by points using Java. Adopting ordering via the SQL query would take advantage of improvements on the DB level, such as caching.

Using a HashMap to store the players rather than Lists would allow for acces in O(1) rather than O(n). That could be an improvement in case the game needs to have a massive amount of players.

Using game names instead of the ID would probably introduce minimal performance cost and would make it easier to handle the requests. Joining games by their name is easier than using codes.

# Known Issues

Some of them are still presenting issues when done from the frontend, such as swapping between games, swapping player hands and deleting players.

However, all the features from the specifications are currently available from the backend and can be tested easily using the Swagger UI (see lists in section 2).
