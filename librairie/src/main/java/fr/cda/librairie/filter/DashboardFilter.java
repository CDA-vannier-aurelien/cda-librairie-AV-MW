package fr.cda.librairie.filter;

import fr.cda.librairie.dto.UtilisateurDto;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/dashboard")
public class DashboardFilter implements Filter {


    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        System.out.println("\n--------->>> filtre authentification");
        HttpServletRequest reqH = (HttpServletRequest) req;
        UtilisateurDto currentUser = (UtilisateurDto) reqH.getSession().getAttribute("user");
        if (currentUser == null) {
            ((HttpServletResponse) resp).sendRedirect("index");
            return;
        }
        if (currentUser.getLabelRole().equals("Client")) {
            ((HttpServletResponse) resp).sendRedirect("index");
            return;
        } else {
            chain.doFilter(req, resp);
        }

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
