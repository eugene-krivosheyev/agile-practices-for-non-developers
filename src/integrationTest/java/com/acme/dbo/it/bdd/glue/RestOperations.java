package com.acme.dbo.it.bdd.glue;

import com.acme.dbo.client.domain.Client;
import com.fasterxml.jackson.databind.ObjectMapper;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static lombok.AccessLevel.PRIVATE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
@ActiveProfiles("it")
@FieldDefaults(level = PRIVATE)
@NoArgsConstructor
public class RestOperations {
    @Autowired MockMvc mockMvc;
    @Autowired ObjectMapper jsonMapper;

    MockHttpServletRequestBuilder request;
    ResultActions result;

    @Given("^Application is running on port (\\d+)$")
    public void applicationIsRunningOnPort(int port) throws Throwable {

    }

    @When("^REST-client make GET request to '/api/client/(\\d+)'$")
    public void restClientMakeGETRequestToApiClient(int clientId) throws Throwable {
        request = get("/api/client/" + clientId);
    }

    @When("^REST-client supply HTTP header 'X-API-VERSION' as '(\\d+)'$")
    public void restClientSupplyHTTPHeaderXAPIVERSIONAs(int version) throws Throwable {
        request.header("X-API-VERSION", version);
    }

    @Then("^REST-client get status code '(\\d+)'$")
    public void restClientGetStatusCode(int status) throws Throwable {
        result = mockMvc.perform(request)
                .andExpect(status().is(status));
    }

    @And("^REST-client get user with email '(.+)'$")
    public void restClientGetUserWithEmailAdminRootRu(String email) throws Throwable {
        String clientFoundJsonString = result.andReturn().getResponse().getContentAsString();
        Client clientFound = jsonMapper.readValue(clientFoundJsonString, Client.class);
        Assertions.clientHasEmail(clientFound, email);
    }
}
