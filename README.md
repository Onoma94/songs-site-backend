Java/Spring Boot/Hibernate back-end to the Songs Site. See the repositories **songs-site** for the JS/React front-end and **songs_mysql** for the MySQL database.

The **Songs Site** is designed to hold complete archive of a music chart.

This back-end is a Java application responsible for communication between the web application and the database. It provides web API that the JS uses.

Variety of data displayed on the webpage is handled by variety of **JPA repositories**, that communicate directly with the database. One JPA repository can only take care of one specific type of data object, such as *ChartRun* (contains chart ID, chart date, and place number). In the application, such object types are defined to ease the database-backend-frontend communication and to ease possible future developments.