$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("darksky_temperature.feature");
formatter.feature({
  "line": 2,
  "name": "Darksky temperature",
  "description": "",
  "id": "darksky-temperature",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@web"
    },
    {
      "line": 1,
      "name": "@regression"
    },
    {
      "line": 1,
      "name": "@darksky"
    }
  ]
});
formatter.before({
  "duration": 3402113917,
  "status": "passed"
});
formatter.background({
  "line": 4,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.scenario({
  "line": 12,
  "name": "Verify timline is displayed in correct format",
  "description": "",
  "id": "darksky-temperature;verify-timline-is-displayed-in-correct-format",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 11,
      "name": "@darksky-2"
    }
  ]
});
formatter.step({
  "line": 13,
  "name": "I am on Darksky homepage",
  "keyword": "Given "
});
formatter.step({
  "line": 14,
  "name": "I verify timeline is displayed with two hours incremented",
  "keyword": "Then "
});
formatter.match({
  "location": "DarkSky_TimeIncrement_2SD.amIonHomepage()"
});
formatter.result({
  "duration": 218182251,
  "status": "passed"
});
formatter.match({
  "location": "DarkSky_TimeIncrement_2SD.verifyTimeIncrementedByTwoHours()"
});
formatter.result({
  "duration": 194881960,
  "status": "passed"
});
formatter.after({
  "duration": 106437276,
  "status": "passed"
});
});