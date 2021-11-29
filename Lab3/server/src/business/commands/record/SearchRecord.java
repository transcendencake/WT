package business.commands.record;

import business.configuration.DatabaseProvider;
import business.commandsService.ILibraryCommand;
import org.jdom2.JDOMException;
import persistance.models.Record;
import persistance.models.RecordSearchParams;
import presentation.dialogs.RecordDialog;
import business.configuration.constants.IRecordFields;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

public class SearchRecord implements ILibraryCommand {
    @Override
    public void Invoke(String[] tokens) throws NoSuchMethodException, IOException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchFieldException, JDOMException {
        List<RecordSearchParams> searchParams = RecordDialog.readSearchBooksParams();
        if(searchParams != null && searchParams.size() > 0) {
            Record[] books = DatabaseProvider.recordDatabase.getAllRecords();
            Record[] findBooks = Arrays.stream(books).filter(bookRecord -> {
                boolean isPassFilter = true;
                for (RecordSearchParams param : searchParams) {
                    if (param.field.equals(IRecordFields.author)) {
                        isPassFilter = isPassFilter && bookRecord.info.contains(param.value);
                    } else if (param.field.equals(IRecordFields.id)) {
                        isPassFilter = isPassFilter && String.valueOf(bookRecord.id).contains(String.valueOf(param.value));
                    } else if (param.field.equals(IRecordFields.name)) {
                        isPassFilter = isPassFilter && bookRecord.name.contains(param.value);
                    }
                }
                return isPassFilter;
            }).toArray(Record[]::new);
            RecordDialog.printRecords(findBooks);
        }
    }
}
