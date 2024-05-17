package mamabologtub.springframework.springtricks.springtricks;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class SpringtricksApplicationTests {

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void testGetAllPeople() throws Exception {
        this.mockMvc.perform(get("/person")
                .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());
    }

    @Test
    public void testGetOnePerson() throws Exception {
        this.mockMvc.perform(get("/person/{id}", 1)
                .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());
    }

    @Test
    public void testCreatePerson() throws Exception {
        JSONObject payload = new JSONObject();
        payload.put("name", "Unit Test");
        payload.put("age", "0");
        payload.put("city", "Unit City");

        this.mockMvc.perform(post("/person")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(payload.toString()))
        .andExpect(status().isOk());
    }

    @Test
    public void testCreateBadPerson() throws Exception {
        JSONObject payload = new JSONObject();
        payload.put("name", "Unit Test");

        this.mockMvc.perform(post("/person")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(payload.toString()));
        // .andExpect(status().isBadRequest());
    }
}
