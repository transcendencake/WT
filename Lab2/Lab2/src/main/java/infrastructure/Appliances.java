package infrastructure;

import domain.entities.Appliance;
import domain.entities.Oven;
import domain.entities.Refrigerator;
import domain.entities.Teapot;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * Wrapper class to serialize
 */
@XmlRootElement(name = "Appliances")
@XmlAccessorType(XmlAccessType.FIELD)
public class Appliances {
    @XmlElements({ @XmlElement(name = "Appliance", type = Appliance.class),
            @XmlElement(name = "Oven", type = Oven.class),
            @XmlElement(name = "Refrigerator", type = Refrigerator.class),
            @XmlElement(name = "Teapot", type = Teapot.class) })
    /**
     * List of appliances
     */
    private List<Appliance> appliances;

    /**
     * Getter for appliances
     * @return appliances field value
     */
    public List<Appliance> getAppliances() {
        return appliances;
    }
}
