package zoo.managers;

import zoo.entities.ZooEntities;
import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;

@ApplicationScoped
public class ZooManagers {
    private ArrayList<ZooEntities> zooEntities = new ArrayList<>();

    private int num = 0;

    public ArrayList<ZooEntities> getAll() {
        return zooEntities;
    }

    public ZooEntities get(int id) {
        return zooEntities.get(id);
    }

    public String create(ZooEntities post) {
        if (!post.name.equals(null) && !post.type.equals(null) && post.age != 0) {
            post.id = num;
            zooEntities.add(post);
            num++;
            return "oki";
        } else {
            return "neni oki";
        }
    }
    public void delete(int id) {
        zooEntities.remove(id);
    }
}
