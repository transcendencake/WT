package business;

import business.configuration.DatabaseProvider;
import persistance.models.Record;
import persistance.models.User;
import persistance.models.UserRole;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class EmailSender {
    public void notifyAboutNewBook(Record newBook) throws NoSuchMethodException, IOException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchFieldException {
        User[] users = DatabaseProvider.userDatabase.getAllUsers();
        String message = getNewBookMessage(newBook);
        for(User user : users) {
            sendEmail(user.email, message);
        }
    }

    public void suggestNewBook(Record book, User admin, User sender) throws NoSuchMethodException, IOException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchFieldException {
        if(admin.role == UserRole.Admin) {
            String message = getSuggestNewBookMessage(book, sender.name);
            sendEmail(admin.email, message);
        }
    }

    private void sendEmail(String userMail, String message) {
        EmailDialog.printAfterEmailSende(userMail, message);
    }

    private String getNewBookMessage(Record record) {
        return "New book has been added." + castBookToString(record);
    }

    private String getSuggestNewBookMessage(Record record, String senderName) {
        return "Hello, user with login: " + senderName + " suggest to add new book - " + castBookToString(record);
    }

    private String castBookToString(Record record) {
        return "Id: " + record.id + ", Author: " + record.info + ", Name: "
                + record.name;
    }
}
