package br.com.projetospring;

import br.com.projetospring.entity.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Date;
import java.util.regex.Pattern;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProjetoSpringApplicationTests.class)
@ActiveProfiles("test")
public class UserControllerIntegrationTest {

    private static final String RESOURCE_LOCATION_PATTERN = "http://localhost:8081/users/[0-9]+";
    
    @Autowired
    WebApplicationContext context;
    
    private MockMvc mvc;
    
    @Before
    public void initTests() {
        MockitoAnnotations.initMocks(this);
        mvc = MockMvcBuilders.webAppContextSetup(context).build();
    }
    
    @Test
    public void shouldCreateRetrieveDelete() throws Exception {
        User p1 = mockUser("shouldCreateRetrieveDelete");
        byte[] r1Json = toJson(p1);
        
        // CREATE
        MvcResult result = mvc.perform(post("/users")
                .content(r1Json)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(redirectedUrlPattern())
                .andReturn();
        long id = getResourceIdFromUrl(result.getResponse().getRedirectedUrl());
        
        // RETRIEVE
        mvc.perform(get("/users/" + id)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is((int) id)))
                .andExpect(jsonPath("$.name", is(p1.getName())))
                .andExpect(jsonPath("$.code", is(p1.getCode())));

        // DELETE
        mvc.perform(delete("/users/" + id))
                .andExpect(status().isNoContent());
    }
    
    @Test
    public void shouldCreateAndUpdateAndDelete() throws Exception {
        User p1 = mockUser("shouldCreateAndUpdate");
        byte[] r1Json = toJson(p1);
        //CREATE
        MvcResult result = mvc.perform(post("/api/posts")
                .content(r1Json)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(redirectedUrlPattern())
                .andReturn();
        long id = getResourceIdFromUrl(result.getResponse().getRedirectedUrl());

        User p2 = mockUser("shouldCreateAndUpdate2");
        p2.setId(1);
        byte[] r2Json = toJson(p2);

        // UPDATE
        result = mvc.perform(put("/users/" + id)
                .content(r2Json)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent())
                .andReturn();

        // RETRIEVE updated
        mvc.perform(get("/users/" + id)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is((int) id)))
                .andExpect(jsonPath("$.name", is(p2.getName())))
                .andExpect(jsonPath("$.code", is(p2.getCode())));

        // DELETE
        mvc.perform(delete("/users/" + id))
                .andExpect(status().isNoContent());
    }
    
    // ========================================================== //
    
    private long getResourceIdFromUrl(String locationUrl) {
        String[] parts = locationUrl.split("/");
        return Long.valueOf(parts[parts.length - 1]);
    }
    
    private User mockUser(String prefix) {
        User user = new User();
        user.setName("teste_name");
        user.setCode("123456_code");
        user.setRa(123456);
        user.setDataCriacao(new Date());
        return user;
    }

    private byte[] toJson(Object r) throws Exception {
        ObjectMapper map = new ObjectMapper();
        return map.writeValueAsString(r).getBytes();
    }

    // match redirect header URL (aka Location header)
    private static ResultMatcher redirectedUrlPattern() {
        return result -> {
            Pattern pattern = Pattern.compile("\\A" + UserControllerIntegrationTest.RESOURCE_LOCATION_PATTERN + "\\z");
            assertTrue(pattern.matcher(result.getResponse().getRedirectedUrl()).find());
        };
    }

}
