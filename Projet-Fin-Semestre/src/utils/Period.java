package utils;

import java.util.Calendar;

/**
 * Class which implements time periods and methods to handle it.
 * 
 * @author Marc Karassev, Anaïs Marongiu
 * 
 */
public class Period {
	// TODO manage time zone and locale
	// TODO tests

	// Fields

	private Calendar startDate;
	private Calendar endDate;

	// Constructors

	/**
	 * Default constructor, constructs a new period from now to a week later.
	 */
	public Period() {
		this(Calendar.getInstance(), Calendar.getInstance());
		long endTime = this.endDate.getTimeInMillis()
				+ (1000 * 60 * 60 * 24 * 7);
		this.endDate.setTimeInMillis(endTime);
	}

	/**
	 * Constructs a new period with the specified dates. If the end date is
	 * before the start date, switches them.
	 * 
	 * @param sd
	 *            the start date
	 * @param ed
	 *            the end date
	 */
	public Period(Calendar sd, Calendar ed) {
		this.startDate = sd;
		this.endDate = ed;

		if (this.getDuration() < 0) {
			this.endDate = this.startDate;
		}
	}

	// Getters and Setters

	/**
	 * Returns the period start date field.
	 * 
	 * @return the calendar object corresponding to the period start date.
	 */
	public Calendar getStartDate() {
		return startDate;
	}

	/**
	 * Returns the period end date field.
	 * 
	 * @return the calendar object corresponding to the period end date.
	 */
	public Calendar getEndDate() {
		return endDate;
	}

	// Methods

	/**
	 * Calculates the period duration in days.
	 * 
	 * @return the period duration
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
	 * Checks if the given periods are overlapping.
	 * 
	 * @param p1
	 *            the first period
	 * @param p2
	 *            the second period
	 * @return true if they are, false otherwise
	 */
	public static boolean overlap(Period p1, Period p2) {
		long start1 = p1.getStartDate().getTimeInMillis();
		long end1 = p1.getEndDate().getTimeInMillis();
		long start2 = p2.getStartDate().getTimeInMillis();
		long end2 = p1.getEndDate().getTimeInMillis();

		return start1 > start2 && start1 < end2 || end1 > start1 && end1 < end2;
	}

	/**
	 * Returns a string representation of the period and its fields.
	 */
	public String toString() {
		return "from " + startDate.get(Calendar.DATE) + "/"
				+ startDate.get(Calendar.MONTH) + 1 + "/"
				+ startDate.get(Calendar.YEAR) + " to "
				+ endDate.get(Calendar.DATE) + "/"
				+ endDate.get(Calendar.MONTH) + 1 + "/"
				+ endDate.get(Calendar.YEAR);
	}
}
