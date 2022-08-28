package org.stepdef;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.baseclass.BaseClass;

import cucumber.api.java.en.*;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import junit.framework.Assert;

public class StepDefinition extends BaseClass {

	@When("User add request body to create new repo")
	public void user_add_request_body_to_create_new_repo() {
	String randomNumeric = RandomStringUtils.randomAlphanumeric(7);

	String reqBody = "{\"name\":\"testrepo" + randomNumeric + "\"}";
		addBody(reqBody);
	}

	@When("User send post request to Repos")
	public void user_send_post_request_to_Repos() throws Exception {
		methodType("POST", "https://api.github.com/user/repos");
	}

	@Then("User verify status code is {int}")
	public void user_verify_status_code_is(int exp) {
		int actCode = getResponseCode();
		org.junit.Assert.assertEquals(exp, actCode);
	}

	@Given("User add headers with authentication for repo")
	public void user_add_headers_with_authentication_for_repo() {
		Header h1 = new Header("Accept", "application/vnd.github.v3+json");
		Header h2 = new Header("Authorization", "token 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");
		List<Header> listHeader = new ArrayList<Header>();
		listHeader.add(h1);
		listHeader.add(h2);
		Headers headers = new Headers(listHeader);
		addHeaders(headers);
	}

	static String fullName;

	@Then("User verify the response body for create repo matching with expected")
	public void user_verify_the_response_body_for_create_repo_matching_with_expected() {
		getReponseBody().prettyPrint();
		fullName = getReponseBody().jsonPath().get("full_name");
	}

	@When("User add request body to update existing repo")
	public void user_add_request_body_to_update_existing_repo() {
		String body = "{\"name\":\"Hello-World\",\"description\":\"This is your first repository\",\"homepage\":\"https://github.com\",\"private\":true,\"has_issues\":true,\"has_projects\":true,\"has_wiki\":true}";
		addBody(body);
	}

	@When("User send patch request to update repo")
	public void user_send_patch_request_to_update_repo() throws Exception {
		methodType("PATCH", "https://api.github.com/repos/" + fullName);
	}

	@Then("User verify the response body for update repo is matching expected")
	public void user_verify_the_response_body_for_update_repo_is_matching_expected() {
		getReponseBody().prettyPrint();
	}

}
