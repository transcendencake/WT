package domain.entities;

import javax.xml.bind.annotation.XmlElement;
import java.io.Serializable;

/**
 * Base appliance implementation
 */
public class Appliance implements Comparable<Appliance> {
    /**
     * Appliance price
     */
    @XmlElement
    private double price;

    /**
     * Appliance power consumption
     */
    @XmlElement
    private int powerConsumption;

    /**
     * Compare by price
     * @param o appliance to compare with
     * @return 1 if this instance is greater, -1 - if lower, 0 - if equals
     */
    @Override
    public int compareTo(Appliance o) {
        if (this.price > o.price) {
            return 1;
        }
        else if (this.price < o.price) {
            return -1;
        }
        return 0;
    }

    /**
     * @return String representation of appliance
     */
    @Override
    public String toString() {
        return String.format("Price: %5.1f$, Power Consumption: %dW,", this.price, this.powerConsumption);
    }
}
