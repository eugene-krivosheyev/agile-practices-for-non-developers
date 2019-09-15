package com.acme.dbo.it;

import com.acme.dbo.client.domain.Client;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static lombok.AccessLevel.PRIVATE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
@ActiveProfiles("it")
@FieldDefaults(level = PRIVATE)
@NoArgsConstructor
public class ExampleIT {
    @Autowired MockMvc mockMvc;
    @Autowired ObjectMapper jsonMapper;

    @Test
    public void shouldGetClientWithId1() throws Exception {
        String clientFoundJsonString = mockMvc.perform(
                get("/api/client/1").header("X-API-VERSION", "1")
        ).andDo(print()).andExpect(status().is(200))
                .andReturn().getResponse().getContentAsString();

        Client clientFound = jsonMapper.readValue(clientFoundJsonString, Client.class);

        assertThat(clientFound.getLogin())
                .isEqualTo("admin@acme.com");
    }
}
