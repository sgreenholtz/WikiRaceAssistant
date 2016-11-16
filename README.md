# WikiRaceAssistant

## Problem Statement
Wiki racing is a popular game that consists of moving from one page to another only using links on the page. It is difficult to find all the links on the page, as they are surrounded by other text.

## Project Objectives
To make a service that takes a wikipedia url and returns all the links on the page to make wiki racing easier.

## User Guide
All API access is through "http://localhost:8080/links/". To search for links on a Wikipedia page, add the last of the part of the Wikipedia URL to the end of the API URL. The API returns a list of links in JSON format. See the example below.

Example URL: http://localhost:8080/links/panda

JSON Response:
```JSON
{
  "sourceUrl": "https://en.wikipedia.org/wiki/panda",
  "links": [
    {
      "title": "Pablo Sandoval",
      "url": "https://en.wikipedia.org/wiki/Pablo_Sandoval"
    },
    {
      "title": "Conservation status",
      "url": "https://en.wikipedia.org/wiki/Conservation_status"
    },
    {
      "title": "Vulnerable species",
      "url": "https://en.wikipedia.org/wiki/Vulnerable_species"
    },
    {
      "title": "IUCN Red List",
      "url": "https://en.wikipedia.org/wiki/IUCN_Red_List"
    },
    {
      "title": "Taxonomy (biology)",
      "url": "https://en.wikipedia.org/wiki/Taxonomy_(biology)"
    },
    {
      "title": "Animal",
      "url": "https://en.wikipedia.org/wiki/Animal"
    },
    {
      "title": "Chordate",
      "url": "https://en.wikipedia.org/wiki/Chordate"
    },
    {
      "title": "Mammal",
      "url": "https://en.wikipedia.org/wiki/Mammal"
    },
    {
      "title": "Carnivora",
      "url": "https://en.wikipedia.org/wiki/Carnivora"
    },
    {
      "title": "Caniformia",
      "url": "https://en.wikipedia.org/wiki/Caniformia"
    }
  ]
}
```

If the passed URL is invalid, the API will respond with a 404 error.

## Progress log
- Backend java logic and REST service done by Sebastian
- Frontend work done by Austin
- Unit tests by Austin and Sebastian
