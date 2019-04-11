# GMDB Intermediary API Exercise
## Intro
In its initial state, the GMDB monolith is a tightly coupled MVC application.
All of the endpoints in the single controller (GmdbController) are currently responding with server-rendered templates in HTML.
Before we can begin refactoring the UI of this application into a Single Page App, we must first create a ReSTful API that can serve only the JSON data needed by the UI. 
As tempting as it may be, the goal of this exercise is **NOT** to refactor existing functionality or add anything new, but rather provide JSON endpoints for **what currently exists** in the GMDB app.

## Exercise
Your goal in this exercise will be to create a new controller with the following endpoints:
- `POST /api/login` should receive login credentials through the request body. Validate the credentials using the `GmdbService.validateUser()` method. Assuming that the credentials are valid, return the user given by the service as JSON. Upon successful login, this endpoint should also set the following session Attributes:
  ```java
  httpSession.setAttribute("screenname", user.getScreenName());
  httpSession.setAttribute("userid", user.getId());
  ```
  For more insight, observe the `/login` endpoint in the `GmdbController` class that exists currently and how it accesses/sets the current httpSession.
  
  If the service does not find a user with the given credentials, respond with a 403 status code(`FORBIDDEN`) the following JSON object:

```JSON
{
    "errorMessage": "Invalid credentials"
}
```

- `POST /api/create-account` should receive a request body with the following fields: 
```
{
  String email,
  String password,
  String screenName,
  String repeatPassword
}
```
This endpoint should utilize the appropriate method that exists in the `GmdbService` to create a new user, given the request body.
If the service succeeds in creating the user,
then endpoint should respond with a 201 status code (`CREATED`) and a JSON response that contains an informative message that the account was successfully created.
If the service fails to create the user, then respond with a 422 status code (`UNPROCCESSABLE_IDENTITY`) and a JSON response with an appropriate error message, such as:
```JSON
{
  "errorMessage": "Account could not be created"
}
``` 

- `POST /api/index` should receive a request body with a field representing a search query string, and should utilize the `GmdbService` to respond with a List of Movie objects

- `GET /api/movie` should expect a query parameter with the key `i` and a value which corresponds to a movie id , and should utilize the `GmdbService` to respond with the Movie object found by the service.
For example,  `GET /movie?i=tt0076759` should respond with the movie object corresponding to  Star Wars Episode IV - A New Hope.

- `POST /api/add-review` should receive a request body userID, movieID, reviewTitle, and reviewBody (all Strings). If the userID or movieID are invalid (should validate using the `GmdbService`), then this endpoint should respond with an appropriate errorMessage and status code. 
- `POST /api/forgot` should receive a request body with an email property. This endpoint use the `GmdbService` to get the password for the given email, and respond with a JSON object containing the password for that email.
