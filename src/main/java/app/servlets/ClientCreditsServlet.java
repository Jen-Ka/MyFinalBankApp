package app.servlets;

import app.model.bankproduct.Card;
import app.model.bankproduct.CardService;
import app.model.bankproduct.Credit;
import app.model.bankproduct.CreditService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;

@WebServlet(urlPatterns = "/creditsClient")
public class ClientCreditsServlet extends HttpServlet {
    public static final String TABLE_BEGIN = "<table style=\" border: 2px solid black;   border-collapse: collapse;\">\n" +
            "  <tr>\n" +
            "    <th>ID client</th>\n" +
            "    <th>Number</th> \n" +
            "    <th>Type of credit</th>\n" +
            "    <th>Sum of credit</th>\n" +
            "    <th>Term of credit</th>\n" +
            "    <th>Percents</th>\n" +
            "    <th>Payment</th>\n" +
            "  </tr>";

    public static final String TABLE_END = "</table>";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        String userId = "2";// пришлось использовать костыль, никак не получается получить id юзера из сессии или откуда-нибудь ещё(((

        ServletHelper.populateHtmlBegin(resp);

        @SuppressWarnings("unchecked")
        final AtomicReference<CreditService> credits = (AtomicReference<CreditService>) req.getServletContext().getAttribute("credits");

        req.setAttribute("userId", userId);

        if (credits != null) {
            if (credits.get().creditIsExist(userId)) {
                Credit credit = CreditService.getById(userId);

                req.setAttribute("clientCredit", credits);

                resp.getWriter().append("<p>My credits:</p>");

                resp.getWriter().append(TABLE_BEGIN);

                resp.getWriter().append("<tr>\n" +
                        "    <td>  " + credit.getClientId() + "       </td>\n" +
                        "    <td>  " + credit.getProductNumber() + "  </td> \n" +
                        "    <td>  " + credit.getCreditType() + "  </td> \n" +
                        "    <td>  " + credit.getSum() + "  </td> \n" +
                        "    <td>  " + credit.getTime() + "  </td> \n" +
                        "    <td>  " + credit.getPercent() + "  </td> \n" +
                        "    <td>  " + credit.getPayment() + "  </td> \n" +
                        "  </tr>");
                resp.getWriter().append(TABLE_END);
            }

        } else {
            session.invalidate();
            resp.getWriter().append("<p> You have not credits in our bank </p>");

        }
        resp.getWriter().append("<p><a href=\"./clientForm.jsp\">To page of Client</a></p>");

        ServletHelper.populateHtmlEnd(resp);

    }
}
