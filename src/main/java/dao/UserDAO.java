package dao;

import model.User;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDAO {
    private static final Map<Integer, User> userMap = new HashMap<>();
    private static int idCounter = 1;
    
    static {
        // Add some initial users
        userMap.put(idCounter, new User(idCounter++, "john_doe", "john@example.com"));
        userMap.put(idCounter, new User(idCounter++, "jane_smith", "jane@example.com"));
    }
    
    public User getUser(int id) {
        return userMap.get(id);
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(userMap.values());
    }

    public void addUser(User user) {
        if (user.getId() == 0) {
            user.setId(idCounter++);
        }
        userMap.put(user.getId(), user);
    }
} 