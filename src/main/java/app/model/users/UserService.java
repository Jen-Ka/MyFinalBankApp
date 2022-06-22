package app.model.users;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class UserService {  //БД клиентов для менеджера

    private static Map<String, User> users = new HashMap<>();

    static  {

        users.put("admin", new User("1", "admin", "123ppp", "Manager", "of Hope Bank", 0,0,0,User.ROLE.ADMIN));
        users.put("client1", new User("2", "client1", "psw1", "Ivanova", "Alla", 4,4,3, User.ROLE.USER));
        users.put("client2", new User("3", "client2", "psw2", "Petrov", "Pavel", 6, 6, 4, User.ROLE.USER));
        users.put("client3", new User("4", "client3", "psw3", "Lukina", "Anna", 1,0, 3, User.ROLE.USER));
        users.put("client4", new User("5", "client4", "psw4", "Tutorin", "Igor", 1,2,3, User.ROLE.USER));
    }

    public static  Map<String, User> getAll() {
        return users;
    }

    public  synchronized void add(User users) {
        this.users.put(users.getUserLogin(), users);
    }

}
