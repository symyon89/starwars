# Star Wars API Implementation

- *This is a basic implementation of https://swapi.dev/api*

## Getting started

- This sample application provides a REST API using Spring Boot, so it is very easy to make it work as standalone server.
- Customazie your data in config/ConfigProperties class, you should change BASEURL

### Local deployment 
    -  Run mvn package, to build jar executable

## Authentication
- This API is a completely open API. No authentication is required to query and get data. This also means that we've limited what you can do to just GET-ing the data. If you find a mistake in the data, then tweet the author or email him.

## Searching
- All resources support a search parameter that filters the set of resources returned. This allows you to make queries like:

- {YourBasePath(BASEURL)}people/?search=r2

## Page
- All resources support a page parameter. This allows you to make queries like:

    {YourBasePath(BASEURL)}people/?page=1

## Resources

### Root
    The Root resource provides information on all available resources within the API.
    
### Example request:
    {YourBasePath} ex: http:localhost:8080/

### Resonse :
    {
    "films": "{YourBasePath}/films/",
    "people": "{YourBasePath}/people/",
    "planets": "{YourBasePath}/planets/",
    "species": "{YourBasePath}/species/",
    "starships": "{YourBasePath}/starships/",
    "vehicles": "{YourBasePath}/vehicles/"
    }
    
### Atributes :
    films string -- The URL root for Film resources
    people string -- The URL root for People resources
    planets string -- The URL root for Planet resources
    species string -- The URL root for Species resources
    starships string -- The URL root for Starships resources
    vehicles string -- The URL root for Vehicles resources
    
    
## Endpoints :
- The following example is available for each atribute :
    
 - /films/ - get all movies resources
 - /films/:id/ - get a specific movie resource
    
    
    
    
    
    
    
    
    
    
    
    
    