import com.demo.Customer;
import com.demo.Main;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Main.class)
public class CustomerControllerTest {

    @Autowired
    private WebApplicationContext applicationContext;

    private MockMvc mvc;

    @Before
    public void setup(){
        mvc = MockMvcBuilders.webAppContextSetup(applicationContext).build();
    }

    @Test
    public void testCustomerController() throws Exception {

        Customer customer = new Customer();
        customer.setName("Tom");
        customer.setAge(25);

        MvcResult mvcResult = mvc.perform(post("/customer").contentType(MediaType.APPLICATION_JSON).content(toJson(customer))).andExpect(status().isOk())
                .andExpect(status().isOk()).andReturn();
        String contentAsString = mvcResult.getResponse().getContentAsString();
        Integer id = JsonPath.parse(contentAsString).read("$.id");

        //mvc.perform(post("/customer").contentType(MediaType.APPLICATION_JSON).content(toJson(customer))).andExpect(status().isOk());
        //mvc.perform(get("/customer/1")).andExpect(status().isOk()).andExpect(jsonPath("$.id").exists());
        mvc.perform(get("/customer/" + id)).andExpect(status().isOk()).andExpect(jsonPath("$.id").exists());
        //mvc.perform(delete("/customer/1")).andExpect(status().isOk());
        mvc.perform(delete("/customer/" + id)).andExpect(status().isOk());
    }

    private String toJson(Object object){
        try {
            return new ObjectMapper().writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }
}

