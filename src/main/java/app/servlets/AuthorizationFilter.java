package app.servlets;

import app.model.users.User;
import app.model.users.UserListForAuth;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;


@WebFilter("/authorization")
public class AuthorizationFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String login = req.getParameter("login");
        String password = req.getParameter("password");

        @SuppressWarnings("unchecked")
        final AtomicReference<UserListForAuth> dao = (AtomicReference<UserListForAuth>) req.getServletContext().getAttribute("dao");

        HttpSession session = req.getSession();

        String userId = String.valueOf(req.getAttribute("userId"));

        //проверка входа пользователя
        if (dao.get().userIsExist(login, password)) {

            User.ROLE role = dao.get().getRoleByLoginPassword(login, password);

            session.setAttribute("password", password);
            session.setAttribute("login", login);
            session.setAttribute("role", role);
            session.setAttribute("userId", userId);

            moveToMenu(req, res, role);

        } else {

            moveToMenu(req, res, User.ROLE.UNKNOWN);
        }
    }

    //выбор действия - если роль админ, то открывем админскую страницу, если роль пользователя, то пользовательскую страницу
    private void moveToMenu(HttpServletRequest req, HttpServletResponse resp, User.ROLE role)
            throws ServletException, IOException {

        if (role.equals(User.ROLE.ADMIN)) {

            req.getServletContext().getRequestDispatcher("/managerForm.jsp").forward(req,resp);

        } else if (role.equals(User.ROLE.USER)) {

            req.getServletContext().getRequestDispatcher("/clientForm.jsp").forward(req, resp);;

        } else {

            req.getRequestDispatcher("/error.jsp").forward(req, resp);
        }
    }

    @Override
    public void destroy() {
    }
}
