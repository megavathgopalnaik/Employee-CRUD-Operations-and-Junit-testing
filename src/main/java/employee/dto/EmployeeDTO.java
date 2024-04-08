package employee.dto;

import java.util.Objects;

import employee.emailCustomAnnotaionvalidator.EmailValidator;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;



public class EmployeeDTO {

	
	

	private Integer id;
	
	@NotBlank(message = "Name Cannot be empty")
	private String name;
	
	private String unit;
	
	@Email(message="please check the email format")
	@EmailValidator
	private String email;
	
	private Integer age;

	@Pattern(regexp="Active|Deactive",message="Status Should be either Active or Deactive")
	private String Status;
	
	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Status, age, email, id, name, unit);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeDTO other = (EmployeeDTO) obj;
		return Objects.equals(Status, other.Status) && Objects.equals(age, other.age)
				&& Objects.equals(email, other.email) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name) && Objects.equals(unit, other.unit);
	}

	@Override
	public String toString() {
		return "EmployeeDTO [id=" + id + ", name=" + name + ", unit=" + unit + ", email=" + email + ", age=" + age
				+ ", Status=" + Status + "]";
	}
	
	
}
