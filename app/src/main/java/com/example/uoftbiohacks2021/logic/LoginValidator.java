package com.example.uoftbiohacks2021.logic;

import android.content.Context;
import java.io.*;

public class LoginValidator {
    public User validate(String username, String password, Context context) {
        username = username.toLowerCase();
        File userFile = new File(context.getFilesDir(), username + ".txt");
        boolean exists = userFile.exists();
        if (!exists) {
            return null;
        }
        User user = instantiateUser(userFile);
        if (user == null) {
            return user;
        }
        if (user.getPassword().equals(password)) {
            return user;
        }
        return null;

    }

    public User instantiateUser(File userFile) {
        User user = null;
        try {
            //Read obj from file
            FileInputStream file = new FileInputStream(userFile);
            ObjectInputStream in = new ObjectInputStream(file);

            //Deserialze obj
            user = (User) in.readObject();

            in.close();
            file.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Cannot find file");
        }
        catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Deserialization unsuccessful");
        }
        return user;
    }
}
