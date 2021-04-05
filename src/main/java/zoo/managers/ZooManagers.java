package zoo.managers;

import zoo.entities.ZooEntities;
import zoo.entities.User;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;

@ApplicationScoped
public class ZooManagers {

    private ArrayList<User> userList = new ArrayList<>();
    private ArrayList<ZooEntities> zooEntities = new ArrayList<>();
    private ArrayList<ZooEntities> zooHealthy = new ArrayList<>();
    private ArrayList<ZooEntities> zooSick = new ArrayList<>();

    private int num = 0;
    private int numUser = 0;
    private User user;


    public ArrayList<ZooEntities> getAll() {

        return zooEntities;
    }

    public ArrayList<ZooEntities> getHealthy() {

        return zooHealthy;
    }

    public ArrayList<ZooEntities> getSick() {

        return zooSick;
    }

    public ZooEntities get(int id) {

        return zooEntities.get(id);
    }

    public String createUser(User post) {
        if (!post.name.equals(null) && !post.password.equals(null)) {
            post.id = numUser;
            userList.add(post);
            numUser++;

            return "Okkk user";
        } else {
            return "neni Okkk user";
        }
    }

    public String create(ZooEntities post) {
        if (!post.name.equals(null) && !post.type.equals(null) && post.age != 0) {
            post.id = num;
            zooEntities.add(post);
            num++;
            if (post.status) {
                zooHealthy.add(post);
            } else {
                zooSick.add(post);
            }
            return "Okkk";
        } else {
            return "neni Okkk";
        }
    }


    public void delete(int id) {
        int delete = 0;
        zooEntities.remove(id);
        for (ZooEntities i : zooHealthy) {
            delete++;
            if (id == i.id) {
                zooHealthy.remove(delete);
                break;
            }
        }
        delete = 0;
        for (ZooEntities i : zooSick) {
            delete++;
            if (id == i.id) {
                zooSick.remove(delete);
                break;
            }
        }
    }

    public String login(String name, String password) {
        for (User a : userList) {
            if (name.equals(a.name) && password.equals(a.password)) {
                user = a;
                return "lol funguje to";
            }
        }
        return "nejsi retard a nefunguje to lol";
    }
    public String logout(){
     user = null;
     return "odhlasen";
    }
}
