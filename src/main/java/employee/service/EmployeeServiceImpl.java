package employee.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import employee.dto.EmployeeDTO;
import employee.entity.Employee;
import employee.exception.EmployeeException;
import employee.repository.EmployeeRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	@Override
	public EmployeeDTO getEmployee(Integer id) throws EmployeeException {
		// TODO Auto-generated method stub
		Optional<Employee> employee= employeeRepository.findById(id);
		if(employee.isEmpty()) {
			throw new EmployeeException("Employee_Not_Found_Exception");
		}
		else {
			EmployeeDTO employeeDTO= new EmployeeDTO();
			employeeDTO.setId(employee.get().getId());
			employeeDTO.setName(employee.get().getName());
			employeeDTO.setUnit(employee.get().getUnit());
			employeeDTO.setAge(employee.get().getAge());
		    employeeDTO.setStatus(employee.get().getStatus());
		return employeeDTO;
	}
	}
	@Override
	public String addEmployee(EmployeeDTO employeeDTO)throws EmployeeException {
		// TODO Auto-generated method stub
		Employee employee=new Employee();
		employee.setAge(employeeDTO.getAge());
		employee.setName(employeeDTO.getName());
		employee.setUnit(employeeDTO.getUnit());
		employee.setEmail(employeeDTO.getEmail());
		employee.setStatus(employeeDTO.getStatus());
		
		Employee e=employeeRepository.save(employee);
		if(e==null) {
			throw new EmployeeException("Employee_Not_Saved_Exception");
		}
		else
		return "Employe details are saved and employee id is "+e.getId().toString();
	}
	@Override
	public String updateEmployee(EmployeeDTO employeeDTO)throws EmployeeException {
		// TODO Auto-generated method 
     Optional<Employee>  existingDEmployee=employeeRepository.findById(employeeDTO.getId());
     Employee employee= new Employee(); 
    		 employee=existingDEmployee.get();
    		 employee.setAge(employeeDTO.getAge());
    		 employee.setEmail(employeeDTO.getEmail());
    		 employee.setName(employeeDTO.getName());
    		 employee.setUnit(employeeDTO.getUnit());
    		 employee.setStatus(employeeDTO.getStatus());
    		 employeeRepository.save(employee);
		
		return "Employee details are updated ";
	}
	@Override
	public String deleteEmployee(Integer id) throws EmployeeException {
	Optional<Employee> employee=employeeRepository.findById(id);
	
	if(employee.isEmpty()) {
		throw new EmployeeException("Employee not found with the given id");
	}
	else {
		employeeRepository.deleteById(id);
	}
		return "Employee details deleted successfully";
	}
	@Override
	public String statusUpdate(Integer id, String status) throws EmployeeException {
		Optional<Employee>employee=employeeRepository.findById(id);
		if (employee.isEmpty()) {
			throw new EmployeeException("Employee not found with the given id");
			
		}else  {
			Employee e= employee.get();
			e.setStatus(status);
	Employee ee=	employeeRepository.save(e);
	
	return "Employee Status Update to "+ ee.getStatus();
		}
		
	}
}
