package utils;

import java.util.Calendar;

/**
 * Class which implements time periods and methods to handle it.
 * 
 * @author Anaïs, Marc
 * 
 */
public class Period {

    // Fields

    private Calendar startDate;
    private Calendar endDate;

    // Constructors

    public Period() {
        this(Calendar.getInstance(), Calendar.getInstance());
        long endTime = this.startDate.getTimeInMillis() + (24 * 60 * 60 * 1000)
                * 7;
        this.endDate.setTimeInMillis(endTime);
    }

    public Period(Calendar sd, Calendar ed) {
        super();
        this.startDate = sd;
        this.endDate = ed;

        // Verify if the endDate is after the startDate,
        // else correct it in considering that the period is between the
        // startDay and itself
        if (this.getDuration() < 0) {
            this.endDate = this.startDate;
        }
    }

    // Getters and Setters

    public Calendar getStartDate() {
        return startDate;
    }

    public Calendar getEndDate() {
        return endDate;
    }

    // Methods

    /**
     * Calculates the duration in days of the period.
     * 
     * @return the duration
     */
    public int getDuration() {
        long time = this.endDate.getTimeInMillis()
                - this.startDate.getTimeInMillis();
        return (int) time / (24 * 60 * 60 * 1000);
    }

    /**
     * Calculates the number of days between this period's startDate and now.
     * 
     * @return the number of days between the beginning of this period and now.
     */
    public int daysFromNow() {
        Calendar now = Calendar.getInstance();

        return (int) (this.startDate.getTimeInMillis() - now.getTimeInMillis())
                / (24 * 60 * 60 * 1000);
    }

    /**
     * Checks if today is in the period.
     * 
     * @return true if yes, false otherwise
     */
    public boolean today() {
        long today = Calendar.getInstance().getTimeInMillis();
        return today > startDate.getTimeInMillis()
                && today < endDate.getTimeInMillis();
    }

    /**
     * Checks if p1 & p2 are overlapping.
     * 
     * @param p1
     * @param p2
     * @return true if they are, false otherwise
     */
    public static boolean overlap(Period p1, Period p2) {
        long start1 = p1.getStartDate().getTimeInMillis();
        long end1 = p1.getEndDate().getTimeInMillis();
        long start2 = p2.getStartDate().getTimeInMillis();
        long end2 = p1.getEndDate().getTimeInMillis();

        return start1 > start2 && start1 < end2 || end1 > start1 && end1 < end2;
    }

    public String toString() {
        return "from " + startDate.get(Calendar.DATE) + "/"
                + startDate.get(Calendar.MONTH) + "/"
                + startDate.get(Calendar.YEAR) + " to "
                + endDate.get(Calendar.DATE) + "/"
                + endDate.get(Calendar.MONTH) + "/"
                + endDate.get(Calendar.YEAR);
    }
}
