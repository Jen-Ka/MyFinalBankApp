package app.servlets;

import app.model.bankproduct.*;
import app.model.users.User;
import app.model.users.UserListForAuth;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.concurrent.atomic.AtomicReference;

@WebListener
public class ContextListener implements ServletContextListener {

    private AtomicReference<UserListForAuth> dao;
    private AtomicReference<BankAccountService> accounts;

    private AtomicReference<CardService> cards;

    private AtomicReference<CreditService> credits;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

        dao = new AtomicReference<>(new UserListForAuth()); // псевдобаза клиентов
        dao.get().add(new User("1", "admin", "123ppp", "Manager", "of Hope Bank", 0,0,0,User.ROLE.ADMIN));
        dao.get().add(new User("2", "client1", "psw1", "Ivanova", "Alla", 4,4,3, User.ROLE.USER));
        dao.get().add(new User("3", "client2", "psw2", "Petrov", "Pavel", 6, 6, 4, User.ROLE.USER));
        dao.get().add(new User("4", "client3", "psw3", "Lukina", "Anna", 1,0, 3, User.ROLE.USER));
        dao.get().add(new User("5", "client4", "psw4", "Tutorin", "Igor", 1,2,3, User.ROLE.USER));

        accounts = new AtomicReference<>(new BankAccountService()); // псевдобаза счетов клиентов
        accounts.get().add(new BankAccount(10101010, 10000, "2"));
        accounts.get().add(new BankAccount(20202020, 0, "2"));
        accounts.get().add(new BankAccount(30303030, 100000, "2"));
        accounts.get().add(new BankAccount(40404040, 340, "2"));
        accounts.get().add(new BankAccount(90404040, 78, "3"));
        accounts.get().add(new BankAccount(80404040, 550, "3"));

        cards = new AtomicReference<>(new CardService()); // псевдобаза карт клиентов
        cards.get().add(new Card(1, 919191919, 23000,"2"));
        cards.get().add(new Card(2, 818181818, 5000,"2"));
        cards.get().add(new Card(3, 717171717, 100,"2"));
        cards.get().add(new Card(4, 616161616, 0,"2"));
        cards.get().add(new Card(5, 678161616, 0,"3"));
        cards.get().add(new Card(6, 614441616, 0,"3"));

        credits = new AtomicReference<>(new CreditService()); // псевдобаза кредитов клиентов
        credits.get().add(new Credit(1, "potrebitel", 3000000, 84, 21.5F, 23000,"2"));
        credits.get().add(new Credit(2, "carcredit", 1000000, 36, 11F, 3000,"2"));
        credits.get().add(new Credit(3, "ipoteque", 5000000, 2400, 2.7F, 43500,"2"));
        credits.get().add(new Credit(4, "carcredit", 580000, 48, 13F, 12500,"3"));

        ServletContext servletContext = servletContextEvent.getServletContext();

        servletContext.setAttribute("dao", dao);
        servletContext.setAttribute("accounts", accounts);
        servletContext.setAttribute("cards", cards);
        servletContext.setAttribute("credits", credits);

    }
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        dao = null;
    }
}
