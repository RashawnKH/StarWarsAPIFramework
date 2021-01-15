# StarWarsAPIFramework
A framework created in order to allow ease of testing the Star Wars API 

How to use the framework -


First you will need to set up a DTO using the Injector class, for example:





PeopleDTO person = (PeopleDTO) Injector.generateDTO("https://swapi.dev/api/people/1/");


You will need to cast it to the type of DTO you want.




You can then make use of the methods which will allow you to test the json file, for example:


Assertions.assertTrue(person.isFirstLetterUppercase(person.getName()));





If you want to test the headers and status code returned you can do so by using the ConnectionManager class, for example:







ConnectionManager connectionManager = new ConnectionManager();


HashMap<String, String> headers = connectionManager.getHeaders(person.getResponse());
Assertions.assertEquals(headers.get("connection"), "keep-alive");




