package presentation;

import domain.ApplianceHelpers;
import domain.AppliancesRepository;
import domain.entities.Appliance;
import domain.entities.Teapot;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;

/**
 * main console class
 */
public class Main {

    /**
     * Entry method
     * @param args command line args
     * @throws IOException
     * @throws JAXBException
     */
    public static void main(String[] args) throws IOException, JAXBException {
        AppliancesRepository repository = new AppliancesRepository();
        List<Appliance> teapots = repository.getAppliancesOfType(Teapot.class);
        List<Appliance> orderedAppliances = ApplianceHelpers.sort(repository.getAppliances());
        Appliance cheapestAppliance = orderedAppliances.get(0);
        System.out.println("Teapots:");
        for (Appliance teapot : teapots) {
            System.out.println(teapot.toString());
        }
        System.out.println("Cheapest:");
        System.out.println(cheapestAppliance.toString());
        System.in.read();
    }
}
