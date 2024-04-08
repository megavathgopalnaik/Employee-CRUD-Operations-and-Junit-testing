package employee.exceptionadvice;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import employee.exception.EmployeeException;

public class LoggingAspect {
	
	
	    private static final Log LOGGER = LogFactory.getLog(LoggingAspect.class);

	    public void logServiceException(EmployeeException exception) {
	        LOGGER.error(exception.getMessage(), exception);
	  
	}


}
