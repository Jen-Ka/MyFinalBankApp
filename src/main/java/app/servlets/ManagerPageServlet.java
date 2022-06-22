package app.servlets;

import app.model.users.User;
import app.model.users.UserService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

@WebServlet(urlPatterns = "/managePage")
public class ManagerPageServlet extends HttpServlet {

    public static final String TABLE_BEGIN = "<table style=\" border: 2px solid black;   border-collapse: collapse;\">\n" +
            "  <tr>\n" +
            "    <th>Role</th>\n" +
            "    <th>ID client</th>\n" +
            "    <th>FirstName</th> \n" +
            "    <th>LastName</th>\n" +
            "    <th>Login</th>\n" +
            "    <th>Password</th>\n" +
            "    <th>Accounts</th>\n" +
            "    <th>Cards</th>\n" +
            "    <th>Credits</th>\n" +
            "  </tr>";

    public static final String TABLE_END = "</table>";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        HttpSession session = req.getSession();
        
        UserService us = new UserService();
        Map<String, User> sortedUserMap =  new TreeMap<>(us.getAll());

        ServletHelper.populateHtmlBegin(resp);

        resp.getWriter().append("<p>Clients</p>");

        resp.getWriter().append(TABLE_BEGIN);
        for (Map.Entry<String, User> str: sortedUserMap.entrySet()) {
            User users = str.getValue();

            resp.getWriter().append("<tr>\n" +
                    "    <td>  " + users.getRole() + "       </td>\n" +
                    "    <td>  " + users.getUserId() + "       </td>\n" +
                    "    <td>  " + users.getUserFirstName() + "  </td> \n" +
                    "    <td>  " + users.getUserLastName() + "     </td>\n" +
                    "    <td>  " + users.getUserLogin() + "      </td>\n" +
                    "    <td>  " + users.getUserPassword() + "     </td>\n" +
                    "    <td>  " + users.getclientBankAccs() + "      </td>\n" +
                    "    <td>  " + users.getclientCards() + "      </td>\n" +
                    "    <td>  " + users.getclientCredit() + "      </td>\n" +
                    "    <td> </td>\n" +
                    "  </tr>");

        }
        resp.getWriter().append(TABLE_END);

        resp.getWriter().append("<p><a href=\"./clientAdd.jsp\">To page of add Client</a></p>");

        resp.getWriter().append("<p><a href=\"./managerForm.jsp\">To manager page</a></p>");

        ServletHelper.populateHtmlEnd(resp);
    }
}
