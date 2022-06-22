package app.servlets;

import app.model.bankproduct.BankAccount;
import app.model.bankproduct.BankAccountService;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import static app.model.bankproduct.BankAccountService.*;

@WebServlet(urlPatterns = "/accountsClient")
public class ClientBankAccountsServlet extends HttpServlet {
    public static final String TABLE_BEGIN = "<table style=\" border: 2px solid black;   border-collapse: collapse;\">\n" +
            "  <tr>\n" +
            "    <th>ID client</th>\n" +
            //"    <th>FirstName Client</th> \n" +
            "    <th>Number</th>\n" +
            "    <th>Balance</th>\n" +
            "  </tr>";

    public static final String TABLE_END = "</table>";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        String userId = "2";// пришлось использовать костыль, никак не получается получить id юзера из сессии или откуда-нибудь ещё(((

        ServletHelper.populateHtmlBegin(resp);

        @SuppressWarnings("unchecked") final AtomicReference<BankAccountService> accounts = (AtomicReference<BankAccountService>) req.getServletContext().getAttribute("accounts");

        req.setAttribute("userId", userId);
        if (accounts != null){
            if (accounts.get().accIsExist(userId)) {

                BankAccount ba = BankAccountService.getById(userId);

                req.setAttribute("accountsClient", accounts);

                resp.getWriter().append("<p>My accounts:</p>");

                resp.getWriter().append(TABLE_BEGIN);

                resp.getWriter().append("<tr>\n" +
                        "    <td>  " + ba.getClientId() + "       </td>\n" +
                        "    <td>  " + ba.getProductNumber() + "  </td> \n" +
                        "    <td>  " + ba.getBalance() + "  </td> \n" +
                        "  </tr>");

                resp.getWriter().append(TABLE_END);
        }

        } else {
            session.invalidate();
            resp.getWriter().append("<p> You have not accounts in our bank </p>");

        }
        resp.getWriter().

                append("<p><a href=\"./clientForm.jsp\">To page of Client</a></p>");

        ServletHelper.populateHtmlEnd(resp);

    }

}



