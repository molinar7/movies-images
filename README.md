Project movies-images

**Technologies Used:**

- Java 11: Core programming language.

- Spring Boot: Used for project setup and configuration.

- Spring MVC: Design pattern for the architecture.

- H2 Database: In-memory relational database for quick development.

- OpenSwagger: For API documentation and testing.




**Movie Images API:**


**List All Movie Images Grouped by Release Year**

- GET /api/movie-images/all/grouped-by-year

- Description: Fetches all movie images, grouped by their release year.


**List All Movie Images by Year**

- GET /api/movie-images/year/{year}

- Description: Retrieves all movie images released in a specific year.

- Path Variable: year - The year to filter the movie images by.



**Vote Movie Image**

- POST /api/movie-images/vote/{id}

- Description: Votes for a movie image.

- Path Variable: id - The ID of the movie image to vote on.

- Request Param: upVote - Boolean indicating whether it's an upvote (true) or downvote (false).



**Get Details of a Movie Image**

- GET /api/movie-images/{id}

- Description: Fetches details of a specific movie image.

- Path Variable: id - The ID of the movie image to retrieve details for.

