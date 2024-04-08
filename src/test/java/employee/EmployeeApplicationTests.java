package employee;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import employee.dto.EmployeeDTO;
import employee.entity.Employee;
import employee.exception.EmployeeException;
import employee.repository.EmployeeRepository;
import employee.service.EmployeeService;
import employee.service.EmployeeServiceImpl;

@SpringBootTest
class EmployeeApplicationTests {
@Mock
private EmployeeRepository employeeRepo;

@InjectMocks
private EmployeeService ser=new EmployeeServiceImpl();

   @Test
  public void  addTest()throws EmployeeException{
	   EmployeeDTO employeeDTO = new EmployeeDTO();
       employeeDTO.setAge(30);
       employeeDTO.setName("John Doe");
       employeeDTO.setUnit("IT");
       employeeDTO.setEmail("john.doe@example.com");
       employeeDTO.setStatus("Active");

       Employee employee = new Employee();
       employee.setId(1);
       employee.setAge(employeeDTO.getAge());
       employee.setName(employeeDTO.getName());
       employee.setUnit(employeeDTO.getUnit());
       employee.setEmail(employeeDTO.getEmail());
       employee.setStatus(employeeDTO.getStatus());

       when(employeeRepo.save(Mockito.any(Employee.class))).thenReturn(employee);

       String result = ser.addEmployee(employeeDTO);

     assertEquals("Employe details are saved and employee id is 1", result);
   }

	

	private void assertEquals(String string, String result) {
	
}


    @Test
    public void testUpdateEmployee() throws EmployeeException {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(1);
        employeeDTO.setAge(30);
        employeeDTO.setName("John Doe");
        employeeDTO.setUnit("IT");
        employeeDTO.setEmail("john.doe@example.com");
        employeeDTO.setStatus("Active");

        Employee existingEmployee = new Employee();
        existingEmployee.setId(1);
        existingEmployee.setAge(25);
        existingEmployee.setName("Jane Doe");
        existingEmployee.setUnit("HR");
        existingEmployee.setEmail("jane.doe@example.com");
        existingEmployee.setStatus("Inactive");

        when(employeeRepo.findById(1)).thenReturn(Optional.of(existingEmployee));
        when(employeeRepo.save(Mockito.any(Employee.class))).thenReturn(existingEmployee);

        String result = ser.updateEmployee(employeeDTO);

        assertEquals("Employee details are updated", result);
        assertEquals(employeeDTO.getAge(), existingEmployee.getAge());
        assertEquals(employeeDTO.getName(), existingEmployee.getName());
        assertEquals(employeeDTO.getUnit(), existingEmployee.getUnit());
        assertEquals(employeeDTO.getEmail(), existingEmployee.getEmail());
        assertEquals(employeeDTO.getStatus(), existingEmployee.getStatus());
    }
    
    
    @Test
    public void testGetEmployee() throws EmployeeException {
        Integer id = 1;
        Employee employee = new Employee();
        employee.setId(id);
        employee.setName("John Doe");
        employee.setUnit("IT");
        employee.setAge(30);
        employee.setStatus("Active");

        when(employeeRepo.findById(id)).thenReturn(Optional.of(employee));

        EmployeeDTO result = ser.getEmployee(id);

        assertEquals(id, result.getId());
        assertEquals(employee.getName(), result.getName());
        assertEquals(employee.getUnit(), result.getUnit());
        assertEquals(employee.getAge(), result.getAge());
        assertEquals(employee.getStatus(), result.getStatus());
    }
    @Test
    public void testGetEmployeeNotFound() {
      
        Employee employee = new Employee();
        employee.setId(1);
        employee.setName("John Doe");
        employee.setUnit("IT");
        employee.setAge(30);
        employee.setStatus("Active");

     
        when(employeeRepo.findById(employee.getId())).thenReturn(Optional.of(employee));

        
        EmployeeException e = Assertions.assertThrows(EmployeeException.class, () -> ser.getEmployee(2));
        Assertions.assertEquals("Employee_Not_Found_Exception", e.getMessage());
    }
    
    
    @Test
    public void testDeleteEmployee() throws EmployeeException {
        Integer id = 1;
        Employee employee = new Employee();
        employee.setId(id);
        when(employeeRepo.findById(id)).thenReturn(Optional.of(employee));

        String result = ser.deleteEmployee(id);

        assertEquals("Employee details deleted successfully", result);
        verify(employeeRepo).deleteById(id);
    }

  

 


	@Test
    public void testStatusUpdate() throws EmployeeException {
        Integer id = 1;
        String status = "Inactive";
        Employee employee = new Employee();
        employee.setId(id);
        employee.setStatus("Active");
        when(employeeRepo.findById(id)).thenReturn(Optional.of(employee));
        when(employeeRepo.save(employee)).thenReturn(employee);

        String result = ser.statusUpdate(id, status);

        assertEquals("Employee Status Update to " + status, result);
        assertEquals(status, employee.getStatus());
    }

  

private void assertEquals(Integer age, Integer age2) {
		// TODO Auto-generated method stub
		
	}


	@Test
	void contextLoads() {
	}

}
