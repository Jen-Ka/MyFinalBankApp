package app.servlets;

import app.model.users.User;
import app.model.users.UserListForAuth;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.atomic.AtomicReference;

@WebServlet(urlPatterns = "/mainClient")
public class ClientPageServlet extends HttpServlet {

    public static final String TABLE_BEGIN = "<table style=\" border: 2px solid black; border-collapse: collapse;\">\n" +
            "  <tr>\n" +
            "    <th>UserId</th>\n" +
            "    <th>Login</th>\n" +
            "    <th>FirstName</th> \n" +
            "    <th>LastName</th>\n" +
            "    <th>Accounts</th>\n" +
            "    <th>Cards</th>\n" +
            "    <th>Credits</th>\n" +
            "  </tr>";

    public static final String TABLE_END = "</table>";

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        String login = "client1";
        String password = "psw1";
        String userId = "2";

        ServletHelper.populateHtmlBegin(resp);

        @SuppressWarnings("unchecked")
        final AtomicReference<UserListForAuth> dao = (AtomicReference<UserListForAuth>) req.getServletContext().getAttribute("dao");

        User user = UserListForAuth.getById(userId);

            req.setAttribute("userId", userId);

        if (dao.get().userIsExist(login, password)) {

            req.setAttribute("user", user);

            resp.getWriter().append("<p>My profile:</p>");

            resp.getWriter().append(TABLE_BEGIN);

            resp.getWriter().append("<tr>\n" +
                    "    <td>  " + user.getUserId() + "       </td>\n" +
                    "    <td>  " + user.getUserLogin() + "  </td> \n" +
                    "    <td>  " + user.getUserFirstName() + "  </td> \n" +
                    "    <td>  " + user.getUserLastName() + "     </td>\n" +
                    "    <td>  " + user.getclientBankAccs() + "     </td>\n" +
                    "    <td>  " + user.getclientCards() + "      </td>\n" +
                    "    <td>  " + user.getclientCredit() + "      </td>\n" +
                    "  </tr>");
            resp.getWriter().append(TABLE_END);

        } else {
            session.invalidate();
            resp.getWriter().append("<p> User is not found </p>");

           }
        resp.getWriter().append("<p><a href=\"./clientForm.jsp\">To page of Client</a></p>");

        ServletHelper.populateHtmlEnd(resp);

    }
}
