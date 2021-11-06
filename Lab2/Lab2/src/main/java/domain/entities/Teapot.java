package domain.entities;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Teapot class
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Teapot extends Appliance {
    /**
     * Teapot capacity in liters
     */
    @XmlElement
    private double capacity;

    /**
     * @return String representation of teapot
     */
    @Override
    public String toString() {
        return String.format("Teapot. %s Capacity: %3.1fL", super.toString(), this.capacity);
    }
}
