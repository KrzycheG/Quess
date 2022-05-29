package com.example.demo.Session;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
 class ControllerTest {

    @Autowired
    private Controller controller;

    @Autowired
    private MockMvc mockMvc;

   @Test
    void start() throws Exception {
      mockMvc.perform(get("/start")).andExpect(status().isOk());
    }

    @Test
    void quess() {
    }

    @Test
    void highscores() {
    }
}