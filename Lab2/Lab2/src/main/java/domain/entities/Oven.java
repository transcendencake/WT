package domain.entities;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Oven class
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Oven extends Appliance {
    /**
     * Oven max temperature in Celsius
     */
    @XmlElement
    private int maxTemperature;

    /**
     * @return String representation of oven
     */
    @Override
    public String toString() {
        return String.format("Oven. %s Max Temperature: %d°.", super.toString(), this.maxTemperature);
    }
}
