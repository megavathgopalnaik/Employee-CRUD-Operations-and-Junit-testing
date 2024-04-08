package employee.emailCustomAnnotaionvalidator;




import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import employee.entity.Employee;
import employee.repository.EmployeeRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


public class EmailVal implements ConstraintValidator<EmailValidator, String>{
@Autowired
private EmployeeRepository repo;
	@Override
	public boolean isValid(String email, ConstraintValidatorContext context) {
	  Optional <Employee>employee=repo.findByEmail(email);
		if(employee.isEmpty()) {
		return true;
		}else {
			return false;
		}
	}

}
