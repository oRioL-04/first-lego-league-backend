package cat.udl.eps.softarch.fll.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import cat.udl.eps.softarch.fll.domain.Team;

@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
public class DomainValidationExceptionHandler {

	@ExceptionHandler(DomainValidationException.class)
	public ResponseEntity<DomainValidationErrorResponse> handleDomainValidationException(DomainValidationException ex) {
		DomainValidationErrorResponse response = new DomainValidationErrorResponse(ex.getCode(), ex.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}

	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<DomainValidationErrorResponse> handleHttpMessageNotReadable(HttpMessageNotReadableException ex) {
		Throwable cause = ex.getCause();
		if (cause instanceof com.fasterxml.jackson.databind.exc.InvalidFormatException ife 
			&& ife.getTargetType() != null && Team.class.isAssignableFrom(ife.getTargetType())) {
			DomainValidationErrorResponse response = new DomainValidationErrorResponse(
					"TEAM_NOT_FOUND", "The referenced team does not exist");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
		throw ex;
	}
}
