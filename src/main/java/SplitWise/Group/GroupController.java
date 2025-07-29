package SplitWise.Group;

import SplitWise.User.User;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class GroupController {

    List<Group> groups;

    public GroupController()
    {
        groups=new ArrayList<>();
    }

    public void addUser(User user,Group group)
    {
        group.getUser().add(user);
    }

    public void addGroup(Group group)
    {
        groups.add(group);
    }

    public Group getGroup(int groupId)
    {
        Predicate<Group> predicate= group->group.getId()==groupId;
        return groups.stream().filter(predicate).findFirst().orElse(null);
    }

    public List<Group> getGroups()
    {
        return groups;
    }

    public boolean deleteGroup(int groupId)
    {
        Predicate<Group> predicate=group->group.getId()==groupId;
        return groups.removeIf(predicate);
    }
}
