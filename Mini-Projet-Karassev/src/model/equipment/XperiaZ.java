package model.equipment;

import java.util.ArrayList;

import utils.Period;
import config.Model;
import config.OS;
import config.Processor;

/**
 * Class XperiaZ, is an hardware with specific values to its fields.
 * @author Marc
 * 
 */
public class XperiaZ extends Hardware {

    // Constructors

    public XperiaZ() {
        super("XperiaZ", "Sony", new ArrayList<Period>(), 6.4,
                Processor.APQ8064, OS.ANDROID41, Model.XPERIAZ);
    }
}
