package fr.cda.librairie.filter;

import fr.cda.librairie.dto.UtilisateurDto;
import fr.cda.librairie.utils.Constantes;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = {"/delete.do", "/add.do"})
public class AuthentificationFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        System.out.println("\n--------->>> filtre authentification");
        HttpServletRequest reqH = (HttpServletRequest) request;

        UtilisateurDto currentUser = (UtilisateurDto) reqH.getSession().getAttribute(Constantes.USER_EN_COURS);

        if (currentUser == null) {
            ((HttpServletResponse) response).sendRedirect("list.do");
            return;
        } else {
            chain.doFilter(request, response);
        }

    }
}
