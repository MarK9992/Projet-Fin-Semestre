package model.equipment;

import java.util.ArrayList;

import utils.Period;
import config.Model;
import config.OS;
import config.Processor;

/**
 * Class Ipad3, is an hardware with specific values to its fields.
 * @author Marc
 * 
 */
public class Ipad3 extends Hardware {

    // Constructors

    public Ipad3() {
        super("Ipad3", "Apple", new ArrayList<Period>(), 9.7,
                Processor.APPLEA5X, OS.IOS5, Model.IPAD3);
    }
}
