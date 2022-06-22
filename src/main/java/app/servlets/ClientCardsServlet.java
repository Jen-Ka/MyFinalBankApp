package app.servlets;

import app.model.bankproduct.BankAccount;
import app.model.bankproduct.BankAccountService;
import app.model.bankproduct.Card;
import app.model.bankproduct.CardService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;

@WebServlet(urlPatterns = "/cardsClient")
public class ClientCardsServlet extends HttpServlet {
    public static final String TABLE_BEGIN = "<table style=\" border: 2px solid black;   border-collapse: collapse;\">\n" +
            "  <tr>\n" +
            "    <th>ID client</th>\n" +
            "    <th>Number</th> \n" +
            "    <th>cardNumber</th>\n" +
            "    <th>Balance</th>\n" +
            "  </tr>";

    public static final String TABLE_END = "</table>";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        String userId = "2";// пришлось исспользовать костыль, никак не получается получить id юзера из сессии или откуда-нибудь ещё(((

        ServletHelper.populateHtmlBegin(resp);

        @SuppressWarnings("unchecked") final AtomicReference<CardService> cards = (AtomicReference<CardService>) req.getServletContext().getAttribute("cards");

        req.setAttribute("userId", userId);

        if (cards != null) {
            if (cards.get().cardIsExist(userId)) {
                Card card = CardService.getById(userId);

                req.setAttribute("clientCards", cards);

                resp.getWriter().append("<p>My cards:</p>");

                resp.getWriter().append(TABLE_BEGIN);

                resp.getWriter().append("<tr>\n" +
                        "    <td>  " + card.getClientId() + "       </td>\n" +
                        "    <td>  " + card.getProductNumber() + "  </td> \n" +
                        "    <td>  " + card.getCardNumber() + "  </td> \n" +
                        "    <td>  " + card.getBalance() + "  </td> \n" +
                        "  </tr>");
                resp.getWriter().append(TABLE_END);
            }

        } else {
            session.invalidate();
            resp.getWriter().append("<p> You have not cards in our bank </p>");

        }
        resp.getWriter().append("<p><a href=\"./clientForm.jsp\">To page of Client</a></p>");

        ServletHelper.populateHtmlEnd(resp);

    }
}
