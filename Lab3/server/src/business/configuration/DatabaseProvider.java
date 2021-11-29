package business.configuration;

import persistance.RecordsDatabase;
import persistance.IRecordsDatabase;
import persistance.IUserDatabase;
import persistance.UserDatabase;

import java.io.IOException;

public class DatabaseProvider {
    public static IRecordsDatabase recordDatabase;
    public static IUserDatabase userDatabase;

    static {
        try {
            recordDatabase = new RecordsDatabase();
            userDatabase = new UserDatabase();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
