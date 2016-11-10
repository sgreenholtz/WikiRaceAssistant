# WikiRaceAssistant
Web service scrapes Wikipedia to find all the links on the page to help you with Wiki Race-ing

## TODO List
- unit test to test the service
- make sure it only searches once
- ~~format response as a JSON~~
- ~~front end~~
- ~~accept the keyword and make into link to search~~
- error message
- ~~only search for links in the body of the wikipedia page~~

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
