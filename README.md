# WikiRaceAssistant

## Problem Statement
Wiki Racing is a popular game that consists of moving from one specific Wikipedia page to another specific page by only using links on the Wikipedia pages. The problem is that it is difficult to find all the links on the page, as they are surrounded by other useless text.

## Project Objectives
To make a service that takes a Wikipedia URL and returns only the links from the page to make Wiki Racing easier.

## User Guide
All API access is through "http://138.68.1.193:8080/WikiRaceAssistant-1.0/links/{endOfWikiURL}". To search for links on a Wikipedia page, add the last of the part of the Wikipedia URL to the end of the API URL. The API returns a list of links in JSON format. See the example below.

Example URL: http://138.68.1.193:8080/WikiRaceAssistant-1.0/links/panda

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
