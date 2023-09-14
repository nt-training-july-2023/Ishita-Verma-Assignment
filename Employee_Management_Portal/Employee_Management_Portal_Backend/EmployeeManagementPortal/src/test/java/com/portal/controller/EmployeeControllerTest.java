//import com.portal.controller;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//
//import static org.mockito.Mockito.when;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//public class EmployeeControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private AdminRepository adminRepository;
//
//    @Test
//    public void testGetEmployeesByRole() throws Exception {
//        // Mock the repository to return a list of employees
//        when(adminRepository.findByRole(Role.EMPLOYEE)).thenReturn(createSampleEmployees());
//
//        // Perform a GET request to the endpoint
//        mockMvc.perform(MockMvcRequestBuilders.get("/api/admin/all/EMPLOYEE"))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$").isArray())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(2))
//                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("John Doe"))
//                .andExpect(MockMvcResultMatchers.jsonPath("$[1].name").value("Jane Smith"));
//    }
//
//    private List<Admin> createSampleEmployees() {
//        Admin employee1 = new Admin();
//        employee1.setId(1L);
//        employee1.setName("Ishita");
//        employee1.setEmail("ishita@example.com");
//        employee1.setRole(Role.EMPLOYEE);
//
//        Admin employee2 = new Admin();
//        employee2.setId(2L);
//        employee2.setName("Pranjal");
//        employee2.setEmail("pranjal@example.com");
//        employee2.setRole(Role.EMPLOYEE);
//
//        return Arrays.asList(employee1, employee2);
//    }
//}
