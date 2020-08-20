package fr.cda.librairie.controller.config;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;


/**
 * Servlet permettant permettant de récupérer les informations de confirgurations et de contexte.
 * 
 * @author PC
 *
 */
public abstract class AbstractController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void init(final ServletConfig config) throws ServletException {
		super.init(config);
		WebApplicationContext springContext = WebApplicationContextUtils
				.getRequiredWebApplicationContext(config.getServletContext());
		final AutowireCapableBeanFactory beanFactory = springContext.getAutowireCapableBeanFactory();
		beanFactory.autowireBean(this);
		
		
	}

}
