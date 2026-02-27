package cat.udl.eps.softarch.fll.config;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Map;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.webmvc.error.DefaultErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

@Component
public class InternalErrorTraceErrorAttributes extends DefaultErrorAttributes {

	@Override
	public Map<String, Object> getErrorAttributes(WebRequest request, ErrorAttributeOptions options) {
		// start without trace
		options = options.excluding(ErrorAttributeOptions.Include.STACK_TRACE);

		Map<String, Object> attrs = super.getErrorAttributes(request, options);

		Object statusObj = attrs.get("status");
		int status = (statusObj instanceof Integer i) ? i : 999;
		HttpStatus resolvedStatus = HttpStatus.resolve(status);
		if (resolvedStatus != null && resolvedStatus.is5xxServerError()) {
			Throwable error = getError(request);
			if (error != null) {
				attrs.put("trace", stackTrace(error));
			}
		}
		return attrs;
	}

	private static String stackTrace(Throwable t) {
		StringWriter sw = new StringWriter();
		t.printStackTrace(new PrintWriter(sw));
		return sw.toString();
	}
}
