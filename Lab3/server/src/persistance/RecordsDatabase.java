package persistance;

import database.XMLDatabase;
import org.jdom2.JDOMException;
import persistance.models.Record;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class RecordsDatabase implements IRecordsDatabase {
    private XMLDatabase database = new XMLDatabase(IDatabaseFiles.Records, Record.class);

    public RecordsDatabase() throws IOException {
    }

    @Override
    public void add(Record record) throws IllegalAccessException, NoSuchFieldException, IOException, NoSuchMethodException, InstantiationException, InvocationTargetException, JDOMException {
        Object[] tmp = database.getRecords();
        record.id = tmp.length == 0 ? 0 : ((Record)tmp[tmp.length - 1]).id + 1;
        database.add(record);
    }

    @Override
    public void update(Record oldRecord, Record newRecord) throws IllegalAccessException, NoSuchFieldException, IOException, JDOMException {
        newRecord.id = oldRecord.id;
        database.update(oldRecord, newRecord);
    }

    @Override
    public void delete(Record record) throws IllegalAccessException, NoSuchFieldException, IOException {
        database.deleteRecord(record);
    }

    @Override
    public Record[] getAllRecords() throws NoSuchMethodException, IOException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchFieldException, JDOMException {
        Object[] tmp = database.getRecords();
        return Arrays.copyOf(tmp, tmp.length, Record[].class);
    }
}
