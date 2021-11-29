package business.commands.record;

import business.configuration.AuthProvider;
import org.jdom2.JDOMException;
import persistance.models.Record;
import business.configuration.DatabaseProvider;
import business.commandsService.ILibraryCommand;
import presentation.dialogs.RecordDialog;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class AddRecord implements ILibraryCommand {
    @Override
    public void Invoke(String[] tokens) throws IllegalAccessException, NoSuchFieldException, IOException, NoSuchMethodException, InvocationTargetException, InstantiationException, JDOMException {
        Record record = RecordDialog.readNewRecord();
        DatabaseProvider.recordDatabase.add(record);
        RecordDialog.printAfterNewRecordAdded();
    }
}
