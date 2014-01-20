package model.equipment;

import java.util.ArrayList;

import utils.Period;
import config.Model;

/**
 * Super class equipment, defines the common properties to all equipments.
 * @author Marc, Anaïs
 * 
 */
public abstract class Equipment {

    private static int counter = 1;

    // Fields
    private String id;
    private String maker;
    private ArrayList<Period> unavailabalityPeriods = new ArrayList<Period>();
    private Model type;

    // Constructors

    public Equipment() {
        this("E", "unkwown", new ArrayList<Period>(), Model.UNKWOWN);
    }

    public Equipment(String id, String maker,
            ArrayList<Period> unavailabalityPeriods, Model type) {
        this.id = id + "-" + counter;
        this.maker = maker;
        this.unavailabalityPeriods = unavailabalityPeriods;
        this.type = type;
        counter++;
    }

    // Methods

    /**
     * Checks if the equipment is available now.
     * 
     * @return true if it is, false otherwise
     */
    public boolean availableNow() {
        if (this.getUnavailabalityPeriods().size() > 0) {
            return (!this.getUnavailabalityPeriods().get(0).today());
        }
        return true;
    }

    /**
     * Checks if the equipment is available during the period p.
     * 
     * @param p
     * @return true if it is, false otherwise
     */
    public boolean availableAt(Period p) {
        Period p2;

        for (int i = 0; i < this.getUnavailabalityPeriods().size(); i++) {
            p2 = this.getUnavailabalityPeriods().get(i);
            if (Period.overlap(p, p2))
                return false;
        }
        return true;
    }

    public String toString() {
        return "ID: " + id + ", made by: " + maker + ", unavailable: "
                + unavailabalityPeriods;
    }

    // Getters and setters

    public String getId() {
        return id;
    }

    public String getMaker() {
        return maker;
    }

    public ArrayList<Period> getUnavailabalityPeriods() {
        return unavailabalityPeriods;
    }

    public void setUnavailabalityPeriods(ArrayList<Period> unavailabalityPeriods) {
        this.unavailabalityPeriods = unavailabalityPeriods;
    }

    public static int getCounter() {
        return counter;
    }

    public Model getType() {
        return type;
    }
}
