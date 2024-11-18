package springbootasync.springbootasync;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
public class AsyncApiTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void asyncTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/async"));
        Assertions.assertTrue(true);
    }

    @Test
    public void asyncTest2() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/async-and-wait"));
        Assertions.assertTrue(true);
    }

    @Test
    public void asyncTestFailed() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/async-failed"));
        Assertions.assertTrue(true);
    }
}
