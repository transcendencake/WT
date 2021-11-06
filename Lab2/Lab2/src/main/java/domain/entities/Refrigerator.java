package domain.entities;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Refrigerator class
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Refrigerator extends Appliance {
    /**
     * Weight of refrigerator in Kgs
     */
    @XmlElement
    private int weight;

    /**
     * @return String representation of refrigerator
     */
    @Override
    public String toString() {
        return String.format("Refrigerator. %s Weight: %dkg", super.toString(), this.weight);
    }
}
