package business.commands.record;

import business.configuration.constants.IViewRecordConstants;
import org.jdom2.JDOMException;
import persistance.models.Record;
import business.configuration.DatabaseProvider;
import business.commandsService.ILibraryCommand;
import presentation.dialogs.RecordDialog;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class ViewRecords implements ILibraryCommand {
    @Override
    public void Invoke(String[] tokens) throws NoSuchMethodException, IOException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchFieldException, JDOMException {
        Record[] books = DatabaseProvider.recordDatabase.getAllRecords();
        int bookOnPage = RecordDialog.readRecordsPerPageAmount();
        if(bookOnPage == IViewRecordConstants.notNeedPaging) {
            RecordDialog.printRecords(books);
        }else {
            RecordDialog.printRecordsWithPaging(books, bookOnPage);
        }
    }
}
