$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/StudentAPIpractice.feature");
formatter.feature({
  "name": "Single student API automation",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Student Atribute validation",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@singlestudent"
    }
  ]
});
formatter.before({
  "status": "skipped"
});
formatter.step({
  "name": "user hits single student API with \"http://cybertekchicago.com/student/88\"",
  "keyword": "When "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "user test for required attribitues",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.after({
  "status": "skipped"
});
});