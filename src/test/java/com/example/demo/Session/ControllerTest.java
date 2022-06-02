package com.example.demo.Session;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import java.util.HashMap;
import java.util.Map;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


@SpringBootTest
@AutoConfigureMockMvc
 class ControllerTest {


    @Autowired
    private MockMvc mockMvc;


    @Test
    void start() throws Exception {

     MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/start"))
              .andExpect(MockMvcResultMatchers.status().isOk())
             .andDo(print())
             .andReturn();

        Assertions.assertEquals(24, result.getResponse().getContentAsString().length());
    }

    @Test
    void quessWrongSess() throws Exception {


       Map<String,String > parameters = new HashMap<>();
       parameters.put("sess" , "asdasdasd");
       parameters.put("number", "5");

       ObjectMapper objectMapper = new ObjectMapper();
       MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/quess")
               .contentType(MediaType.APPLICATION_JSON)
               .content(objectMapper.writeValueAsString(parameters)))
               .andExpect(MockMvcResultMatchers.status().isOk())
               .andDo(print())
               .andReturn();

       Assertions.assertEquals("{\"Session with given Id doesnt exist\":\"Try again\"}", result.getResponse().getContentAsString());

    }

    @Test
    void quessRightSess() throws Exception{

       Map<String,String > parameters = new HashMap<>();
       parameters.put("sess" , "628d331abc4935745a90bfec");
       parameters.put("number", "5");

       ObjectMapper objectMapper = new ObjectMapper();
       MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/quess")
                       .contentType(MediaType.APPLICATION_JSON)
                       .content(objectMapper.writeValueAsString(parameters)))
               .andExpect(MockMvcResultMatchers.status().isOk())
               .andDo(print())
               .andReturn();

       String res = result.getResponse().getContentAsString();
       String subRes = res.substring(res.indexOf("Result"), res.indexOf("Number")-3);

       Assertions.assertTrue("Result: \":\"Too big :O".equals(subRes) || "Result: \":\"Winner".equals(subRes)
       || "Result: \":\"Too small :(".equals(subRes));




    }

    @Test
    void highscores() throws Exception {

               mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/highscores"))
               .andExpect(MockMvcResultMatchers.status().isOk())
               .andDo(print())
               .andReturn();

    }
}