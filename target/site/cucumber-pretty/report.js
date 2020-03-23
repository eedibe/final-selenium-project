$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("hotels.feature");
formatter.feature({
  "line": 3,
  "name": "Hotels features",
  "description": "",
  "id": "hotels-features",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@web"
    },
    {
      "line": 1,
      "name": "@hotel"
    },
    {
      "line": 1,
      "name": "@regression"
    }
  ]
});
formatter.scenarioOutline({
  "line": 30,
  "name": "Verify room count dropdown",
  "description": "",
  "id": "hotels-features;verify-room-count-dropdown",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 29,
      "name": "@hotel-4"
    }
  ]
});
formatter.step({
  "line": 31,
  "name": "I am on hotels.com home page",
  "keyword": "Given "
});
formatter.step({
  "line": 32,
  "name": "I select \u003cselect_rooms\u003e from room dropdown",
  "keyword": "Then "
});
formatter.step({
  "line": 33,
  "name": "I verify \u003cnumber_of_room_dropdown\u003e is displayed",
  "keyword": "And "
});
formatter.examples({
  "line": 34,
  "name": "",
  "description": "",
  "id": "hotels-features;verify-room-count-dropdown;",
  "rows": [
    {
      "cells": [
        "select_rooms",
        "number_of_room_dropdown"
      ],
      "line": 35,
      "id": "hotels-features;verify-room-count-dropdown;;1"
    },
    {
      "comments": [
        {
          "line": 36,
          "value": "#| 2            | 2                    |"
        },
        {
          "line": 37,
          "value": "#| 3            | 3                    |"
        }
      ],
      "cells": [
        "4",
        "4"
      ],
      "line": 38,
      "id": "hotels-features;verify-room-count-dropdown;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 4320033897,
  "status": "passed"
});
formatter.background({
  "line": 5,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.scenario({
  "comments": [
    {
      "line": 36,
      "value": "#| 2            | 2                    |"
    },
    {
      "line": 37,
      "value": "#| 3            | 3                    |"
    }
  ],
  "line": 38,
  "name": "Verify room count dropdown",
  "description": "",
  "id": "hotels-features;verify-room-count-dropdown;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 29,
      "name": "@hotel-4"
    },
    {
      "line": 1,
      "name": "@regression"
    },
    {
      "line": 1,
      "name": "@hotel"
    },
    {
      "line": 1,
      "name": "@web"
    }
  ]
});
formatter.step({
  "line": 31,
  "name": "I am on hotels.com home page",
  "keyword": "Given "
});
formatter.step({
  "line": 32,
  "name": "I select 4 from room dropdown",
  "matchedColumns": [
    0
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 33,
  "name": "I verify 4 is displayed",
  "matchedColumns": [
    1
  ],
  "keyword": "And "
});
formatter.match({
  "location": "Hotels_RoomCountSD.onHomepage()"
});
formatter.result({
  "duration": 231703428,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "4",
      "offset": 9
    }
  ],
  "location": "Hotels_RoomCountSD.selectRooms(String)"
});
formatter.result({
  "duration": 3328692686,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "4",
      "offset": 9
    }
  ],
  "location": "Hotels_RoomCountSD.verifyRoomCountDropdown(String)"
});
formatter.result({
  "duration": 222449386,
  "status": "passed"
});
formatter.after({
  "duration": 181530844,
  "status": "passed"
});
});