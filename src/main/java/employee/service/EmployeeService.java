package employee.service;

import employee.dto.EmployeeDTO;
import employee.exception.EmployeeException;

public interface EmployeeService {

	EmployeeDTO getEmployee(Integer id) throws EmployeeException;

	String addEmployee(EmployeeDTO employeeDTO) throws EmployeeException;

	String updateEmployee(EmployeeDTO employeeDTO) throws EmployeeException;

	String deleteEmployee(Integer id)throws EmployeeException;

	String statusUpdate(Integer id, String status)throws EmployeeException;

}
