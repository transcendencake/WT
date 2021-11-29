package business.commands.record;

import org.jdom2.JDOMException;
import persistance.models.Record;
import business.configuration.DatabaseProvider;
import business.commandsService.ILibraryCommand;
import presentation.dialogs.BaseDialog;
import presentation.dialogs.RecordDialog;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class DeleteRecord implements ILibraryCommand {
    @Override
    public void Invoke(String[] tokens) throws NoSuchMethodException, IOException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchFieldException, JDOMException {
        Record book = RecordDialog.getRecordWithId();
        if(book != null) {
            DatabaseProvider.recordDatabase.delete(book);
            RecordDialog.printAfterBookDeleted();
        } else {
            RecordDialog.printBookWithIdNotFound();
        }
    }
}
