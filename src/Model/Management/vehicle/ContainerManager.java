package Model.Management.vehicle;
import Model.Management.Management;
import Model.Vehicle.Container;
import java.util.ArrayList;
import java.util.List;

public class ContainerManager implements Management<Container> {
    private List<Container> containers;
    public ContainerManager(){
        containers = new ArrayList<>();
    }


    @Override
    public void add(Container container) {
        containers.add(container);
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public void edit(String id, Container container) {
        int index = findIndexById(id);
        containers.set(index, container);
    }

    @Override
    public int findIndexById(String id) {
        for (int i = 0; i < containers.size(); i++) {
            if (id.equals(containers.get(i).getId()))
                return i;
        }
        return -1;
    }

    public List<Container> getAllContainer() {
        return containers;
    }
}
