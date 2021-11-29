package presentation.dialogs;

import org.jdom2.JDOMException;
import persistance.models.Record;
import business.configuration.DatabaseProvider;
import persistance.models.RecordSearchParams;
import business.configuration.constants.IRecordFields;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RecordDialog extends BaseDialog{
    public static Record readNewRecord() throws IOException {
        Record record = new Record();
        printer.get().print("Enter info of the record: ");
        record.info = scanner.get().nextLine();
        printer.get().print("Enter name of the record: ");
        record.name = scanner.get().nextLine();
        return record;
    }

    public static void printIfCantFindAdminWithLogin() {
        printer.get().println("Can't find admin with such login");
    }

    public static void printAfterNewRecordAdded() {
        printer.get().println("New record has been succesfully added");
    }

    public static void printAfterBookDeleted() {
        printer.get().println("record has been succesfully deleted");
    }

    public static void printBookWithIdNotFound() {
        printer.get().println("record with specified id wasn't found");
    }

    public static void printAfterBRecordUpdated() {
        printer.get().println("record has been successfully updated");
    }

    public static String readAdminName() throws IOException {
        printer.get().print("Enter admin name: ");
        return scanner.get().nextLine();
    }

    public static List<RecordSearchParams> readSearchBooksParams() throws IllegalAccessException, IOException {
        printer.get().println("Enter the fields for search, you can use space as separator. There are 3 fields: id, name, info");
        String[] fieldsForSearch = scanner.get().nextLine().split(" ");
        Field[] validBookFields = IRecordFields.class.getDeclaredFields();
        List<RecordSearchParams> res = new ArrayList<>();
        for (String fieldForSearch : fieldsForSearch) {
            boolean ifFind = false;
            for (Field field : validBookFields) {
                ifFind = ifFind || field.get(field.getClass()).toString().equals(fieldForSearch);
            }
            if(!ifFind) {
                printer.get().println(fieldForSearch + " is unknown field");
            } else {
                RecordSearchParams params = new RecordSearchParams();
                params.field = fieldForSearch;
                printer.get().print("Enter string for search for field " + fieldForSearch + ": ");
                String input = scanner.get().nextLine();
                params.value = input;
                res.add(params);
            }
        }
        return res;
    }

    public static Record getRecordWithId() throws NoSuchMethodException, IOException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchFieldException, JDOMException {
        printer.get().print("Enter record id: ");
        int id = scanner.get().nextInt();
        Record[] records = DatabaseProvider.recordDatabase.getAllRecords();
        Record record = null;
        if(Arrays.stream(records).anyMatch(b -> b.id == id)) {
            record = Arrays.stream(records).filter(b -> b.id == id).findFirst().get();
        }
        return record;
    }

    public static int readRecordsPerPageAmount() throws IOException {
        printer.get().print("Enter amount of books per page(0): ");
        return scanner.get().nextInt();
    }

    public static void printRecordsWithPaging(Record[] records, int amountOnPage) throws IOException {
        if(records.length == 0) {
            printer.get().println("There are no records in database");
        } else {
            for(int page = 0; page * amountOnPage < records.length; ++page) {
                printer.get().println("Page " + (page + 1));
                int endOfPage = (page + 1) * amountOnPage;
                if(endOfPage > records.length) {
                    endOfPage = records.length;
                }
                printRecords(Arrays.copyOfRange(records, page * amountOnPage, endOfPage));
                if(endOfPage != records.length) {
                    printer.get().println("Enter for next page");
                    scanner.get().nextLine();
                }
            }
            printer.get().println("\ndone. All pages have been printed.");
        }
    }

    public static void printRecords(Record[] records, boolean needHeader) {
        if(records.length > 0) {
            if (needHeader) {
                printRecordsHeader();
            }
            for (Record book :
                    records) {
                printer.get().println(String.format("%d\t%s\t%s", book.id, book.name, book.info));
            }
        }else {
            printer.get().println("There no records");
        }
    }

    public static void printRecords(Record[] records) {
        printRecords(records, true);
    }

    public static void printRecordsHeader() {
        printer.get().println("Id\tName\tInfo");
    }
}
