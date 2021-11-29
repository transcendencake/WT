package persistance;

import org.jdom2.JDOMException;
import persistance.models.Record;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public interface IRecordsDatabase {
    void add(Record record) throws IllegalAccessException, NoSuchFieldException, IOException, NoSuchMethodException, InstantiationException, InvocationTargetException, JDOMException;
    void update(Record oldRecord, Record newRecord) throws IllegalAccessException, NoSuchFieldException, IOException, JDOMException;
    void delete(Record record) throws IllegalAccessException, NoSuchFieldException, IOException;
    Record[] getAllRecords() throws NoSuchMethodException, IOException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchFieldException, JDOMException;
}
