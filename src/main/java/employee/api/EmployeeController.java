package employee.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import employee.dto.EmployeeDTO;
import employee.exception.EmployeeException;
import employee.service.EmployeeService;
import jakarta.validation.constraints.Pattern;

@RestController
public class EmployeeController {

	
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/get/{id}")
	public EmployeeDTO getEmployee(@PathVariable Integer id) throws EmployeeException {
		
		return employeeService.getEmployee(id);
	}
	
	@PostMapping("/add")
	public String addEmployee(@Validated @RequestBody EmployeeDTO employeeDTO) throws EmployeeException {
		
		
		return employeeService.addEmployee(employeeDTO);
	}
	
	@PutMapping("/update")
	public String updateEmployee(@Validated @RequestBody EmployeeDTO employeeDTO) throws EmployeeException {
		
		
		return employeeService.updateEmployee(employeeDTO);
	}
	@DeleteMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable Integer id) throws EmployeeException {
		
		
		return employeeService.deleteEmployee(id);
		
	}
	
	  @PatchMapping("/statusUpdate/{id}")
	  public String statusUpdate(@PathVariable Integer id, @Pattern(regexp = "Active|Deactive")
	  @RequestParam String status) throws EmployeeException {
	     
		  return employeeService.statusUpdate(id, status);
	}
}
