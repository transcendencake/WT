package domain;

import domain.entities.Appliance;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Helper utils class for appliances
 */
public class ApplianceHelpers {
    /**
     * Sort appliances by id
     * @param src source sequence
     * @return sorted sequence
     */
    public static List<Appliance> sort(List<Appliance> src) {
        List<Appliance> result = new ArrayList<>(src);
        Collections.sort(result);
        return result;
    }
}
