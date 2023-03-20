package zbdy.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//@Component
public class SimpleFilter implements Filter {
	
	private static Logger logger = LoggerFactory.getLogger(SimpleFilter.class);

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		logger.info("Remote Host: " + request.getRemoteHost());
		logger.info("Remote Address: " + request.getRemoteAddr());
		chain.doFilter(request, response);
	}

}
