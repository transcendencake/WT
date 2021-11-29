package business.commands.record;

import org.jdom2.JDOMException;
import persistance.models.Record;
import business.configuration.DatabaseProvider;
import business.commandsService.ILibraryCommand;
import presentation.dialogs.RecordDialog;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class EditRecord implements ILibraryCommand {
    @Override
    public void Invoke(String[] tokens) throws NoSuchMethodException, IOException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchFieldException, JDOMException {
        Record oldRecord = RecordDialog.getRecordWithId();
        if(oldRecord != null) {
            Record newRecord = RecordDialog.readNewRecord();
            DatabaseProvider.recordDatabase.update(oldRecord, newRecord);
            RecordDialog.printAfterBRecordUpdated();
        } else {
            RecordDialog.printBookWithIdNotFound();
        }
    }
}
