package Model.File.user;
import Model.User.User;

import java.io.*;
import java.util.List;

//Ghi ra file
public class WriteFileUser {

    File file = new File("Case_1/data/user.csv");
    public void writeData (List<User> users) {
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (User st : users) {
                bufferedWriter.write(st.writeString());
            }
            bufferedWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
