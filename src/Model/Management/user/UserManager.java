package Model.Management.user;
import Model.File.user.ReadFileUser;
import Model.File.user.WriteFileUser;
import Model.User.User;
import java.util.List;

public class UserManager {

WriteFileUser writeFileUser = new WriteFileUser();
ReadFileUser readFileUser = new ReadFileUser();
    private List<User> userList;

    public UserManager() {
        userList = readFileUser.readData();
    }
    public void add(User user) {
        this.userList = readFileUser.readData();
        userList.add(user);
        writeFileUser.writeData(userList);
    }
    public void delete(String user) {
        this.userList = readFileUser.readData();
        int index = findIndexByUser(user);
        userList.remove(index);
        writeFileUser.writeData(userList);
    }

    public int findIndexByUser(String user) {
        this.userList = readFileUser.readData();
        for (int i = 0; i < userList.size(); i++) {
            if (user.equals(userList.get(i).getUserName())) {
                return i;
            }
        }
        return -1;
    } public int findIndexById(String id) {
        this.userList = readFileUser.readData();
        for (int i = 0; i < userList.size(); i++) {
            if (id.equals(userList.get(i).getId())) {
                return i;
            }
        }
        return -1;
    }
   public List<User> getAllUser(){
        return this.readFileUser.readData();
    }
}
