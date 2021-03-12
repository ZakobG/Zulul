package zoo.managers;

import zoo.entities.ZooEntities;

import java.util.ArrayList;

public class ZooManagers {
    private ArrayList<ZooEntities> zooEntities = new ArrayList<>();

    public ArrayList<ZooEntities> getAll(){
        return zooEntities;
    }
}
