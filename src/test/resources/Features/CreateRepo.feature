Feature: Github API automation scripts using REST Assured

Scenario: Verify user is able to create new repo 
Given User add headers with authentication for repo
When User add request body to create new repo
And User send post request to Repos
Then User verify status code is 201
And User verify the response body for create repo matching with expected


Scenario: Verify user is able to update the exsiting repo
Given User add headers with authentication for repo
When User add request body to update existing repo
And User send patch request to update repo
Then User verify status code is 200
And User verify the response body for update repo is matching expected