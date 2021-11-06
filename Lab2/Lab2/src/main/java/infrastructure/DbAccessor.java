package infrastructure;

import domain.entities.Appliance;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.util.List;

/**
 * DAO
 */
public class DbAccessor {
    private static String xmlPath = "D:\\Study\\WT\\Lab2\\Lab2\\src\\main\\resources\\appliances.xml";

    /**
     * Appliances from db
     */
    private List<Appliance> appliances;

    /**
     * Getter for appliances
     * @return appliances from db
     */
    public List<Appliance> getAppliances() {
        return appliances;
    }

    public DbAccessor() throws IOException, JAXBException {
        File file = new File(xmlPath);
        JAXBContext jaxbContext = JAXBContext.newInstance(Appliances.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        Appliances appliancesFromFile = (Appliances)jaxbUnmarshaller.unmarshal(file);
        appliances = appliancesFromFile.getAppliances();
    }
}
