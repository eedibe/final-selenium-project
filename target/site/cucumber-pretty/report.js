$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("darksky_testing.feature");
formatter.feature({
  "line": 2,
  "name": "Signup Message feature",
  "description": "",
  "id": "signup-message-feature",
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
  "duration": 3439504575,
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
  "line": 25,
  "name": "Verify invalid signup error message",
  "description": "",
  "id": "signup-message-feature;verify-invalid-signup-error-message",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 24,
      "name": "@darksky-4"
    }
  ]
});
formatter.step({
  "line": 26,
  "name": "I am on Darksky home page",
  "keyword": "Given "
});
formatter.step({
  "line": 27,
  "name": "I click on Register button",
  "keyword": "When "
});
formatter.step({
  "line": 28,
  "name": "I verify I am on Register page by asserting Register header",
  "keyword": "Then "
});
formatter.match({
  "location": "DarkSky_RegisterSD.onHomepage()"
});
formatter.result({
  "duration": 5445148098,
  "status": "passed"
});
formatter.match({
  "location": "DarkSky_RegisterSD.clickonResgiterbutton()"
});
formatter.result({
  "duration": 64643178,
  "status": "passed"
});
formatter.match({
  "location": "DarkSky_RegisterSD.getRegisterError()"
});
formatter.result({
  "duration": 34921214,
  "status": "passed"
});
formatter.after({
  "duration": 135273305,
  "status": "passed"
});
});