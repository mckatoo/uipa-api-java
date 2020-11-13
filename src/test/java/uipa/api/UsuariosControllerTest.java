package uipa.api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
public class UsuariosControllerTest {
    
    @Autowired
    MockMvc mockMvc;

    @Test
    public void usuariosTestTodos() throws Exception {
        mockMvc.perform(get("/api/usuarios")).andExpect(status().isOk());
    }
    
}
