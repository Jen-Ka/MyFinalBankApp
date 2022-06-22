package app.model.users;

import java.util.ArrayList;
import java.util.List;

public class UserListForAuth { // БД клиентов для авторизации
    private static List<User> dao = new ArrayList<>();

    public static User getById(String userId) {

        User result = new User();
        result.setUserId("-1");

        for (User user : dao) {
            if (user.getUserId().equals(userId)) {
                result = user;
            }
        }
        return result;
    }

    /*public User getIdUser(String login, String password) {

        User result = new User();
        result.setUserId("-1");

        for (User user : dao) {
            if (user.getUserLogin().equals(login) && user.getUserPassword().equals(password)) {
                result = user.getUserId();
            }
        }
        return result;
    }*/

    public boolean add(User user) {

        for (User u : dao) {
            if (u.getUserLogin().equals(user.getUserLogin()) && u.getUserPassword().equals(user.getUserPassword())) {
                return false;
            }
        }
        return dao.add(user);
    }

    public User.ROLE getRoleByLoginPassword(String login, String password) {

        User.ROLE result = User.ROLE.UNKNOWN;

        for (User user : dao) {
            if (user.getUserLogin().equals(login) && user.getUserPassword().equals(password)) {
                result = user.getRole();
            }
        }
        return result;
    }

    public boolean userIsExist( String login, String password) {

        boolean result = false;

        for (User user : dao) {
            if (user.getUserLogin().equals(login) && user.getUserPassword().equals(password)) {
                result = true;
                break;
            }
        }
        return result;
    }
}
