package Model.Management;

public interface Management<E> {
void add(E e);
    void delete(String id);
    void edit(String id, E e);
    int findIndexById(String id);
}
