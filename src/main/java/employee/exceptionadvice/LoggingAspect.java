package employee.exceptionadvice;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import employee.exception.EmployeeException;

@Component
@Aspect
public class LoggingAspect {
	
	
	    private static final Log LOGGER = LogFactory.getLog(LoggingAspect.class);

	    @AfterThrowing(pointcut = "execution(* employee.service.EmployeeServiceImpl.*(..))", throwing = "exception")
	    public void logServiceException(EmployeeException exception) {
	        LOGGER.error(exception.getMessage(), exception);
	  
	}


}
