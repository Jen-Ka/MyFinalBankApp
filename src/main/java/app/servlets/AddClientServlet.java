package app.servlets;

import app.model.users.User;
import app.model.users.UserService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet(urlPatterns = "/addClient")
public class AddClientServlet extends HttpServlet {

    public static final String USER_ID = "userId";
    private static final String USER_LOGIN = "login";
    private static final String USER_PSW = "password";
    public static final String USER_FIRSTNAME = "userFirstName";
    public static final String USER_LASTNAME = "userLastName";
    private static final String USER_BACCS = "clientAccounts";
    private static final String USER_CARDS = "clientCards";
    private static final String USER_CREDITS = "clientCredits";

    protected void doPost(HttpServletRequest request, HttpServletResponse resp)
            throws IOException {

        String pId = request.getParameter(USER_ID);
        String pLogin = request.getParameter(USER_LOGIN);
        String pPassword = request.getParameter(USER_PSW);
        String pFirstName = request.getParameter(USER_FIRSTNAME);
        String pLastName = request.getParameter(USER_LASTNAME);
        int pClientAccounts = Integer.parseInt(request.getParameter(USER_BACCS));
        int pClientCards = Integer.parseInt(request.getParameter(USER_CARDS));
        int pClientCredits = Integer.parseInt(request.getParameter(USER_CREDITS));

        User users = new User(pId, pLogin, pPassword, pFirstName, pLastName, pClientAccounts, pClientCards, pClientCredits, User.ROLE.valueOf("USER"));
        UserService us = new UserService();
        us.add(users);

        ServletHelper.populateHtmlBegin(resp);

        resp.getWriter().append("<p>New user added!</p>");

        resp.getWriter().append("<p><a href=\"./clientAdd.jsp\">To page of add Client</a></p>");

        resp.getWriter().append("<p><a href=\"/managePage\">To list of clients</a></p>");

        ServletHelper.populateHtmlEnd(resp);
    }

}
