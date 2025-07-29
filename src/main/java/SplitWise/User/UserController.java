package SplitWise.User;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class UserController {

    List<User> users;

    public UserController()
    {
        users=new ArrayList<>();
    }

    public void addUser(User user)
    {
        users.add(user);
    }

    public User getUser(int userId)
    {
        Predicate<User> predicate=user->user.getUserId()==userId;
        return users.stream().filter(predicate).findFirst().orElse(null);
    }

    public List<User> getAllUsers()
    {
        return users;
    }
    
    public boolean deleteUser(int userId)
    {
        Predicate<User> predicate=user->user.getUserId()==userId;
        return users.removeIf(predicate);
    }
}
