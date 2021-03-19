package zoo.managers;

import zoo.entities.ZooEntities;

import javax.ws.rs.core.Response;
import java.util.ArrayList;

public class ZooManagers {
    private ArrayList<ZooEntities> zooEntities = new ArrayList<>();

    private int id = 0;
    static String name;
    static String type;
    static int age;

    public ArrayList<ZooEntities> getAll() {
        return zooEntities;
    }

    public void get() {
        if (zooEntities.get(id) != null) {
            Response.ok(zooEntities.get(id)).build();
        } else {
            Response.ok("Zvíře není.").build();
        }
    }

    public void create(ZooEntities post) {
        if (name != null && type != null && zooEntities.get(age) != null) {
            post.setId(id);
            id++;
            zooEntities.add(post);
        }
    }

    public void delete() {
        if (zooEntities.get(id) != null) {
            zooEntities.remove(id);
        }
    }
}