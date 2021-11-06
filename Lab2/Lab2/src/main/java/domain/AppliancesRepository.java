package domain;

import domain.entities.Appliance;
import infrastructure.DbAccessor;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Repository class to get appliances
 */
public class AppliancesRepository {
    /**
     * Db accessor instance
     */
    private DbAccessor dbAccessor;

    /**
     * Default constructor
     * @throws JAXBException
     * @throws IOException
     */
    public AppliancesRepository() throws JAXBException, IOException {
        this.dbAccessor = new DbAccessor();
    }

    /**
     * Gets appliance from db
     * @return all appliances
     */
    public List<Appliance> getAppliances() {
        return dbAccessor.getAppliances();
    }

    /**
     * Get appliances of specified class
     * @param type type of appliance
     * @return appliances of specified class
     */
    public List<Appliance> getAppliancesOfType(Class type) {
        List<Appliance> result = new ArrayList<Appliance>();
        List<Appliance> sourceSequence = dbAccessor.getAppliances();
        for (Appliance appliance : sourceSequence) {
            if (appliance.getClass() == type) {
                result.add(appliance);
            }
        }
        return result;
    }
}
