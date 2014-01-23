package config;

/**
 * Implements constants for borrowers. LOAN_DURATION constants defines the loan
 * duration limits and LOAN_RESERVATION constants defines the number of days in
 * advance a reservation can be made. All constants are uttered in days.
 * 
 * initial code by: Marc Karassev; modified by: Marc Karassev
 * 
 * @author Marc Karassev
 * 
 */
public interface BorrowerConstants {
	int STUDENT_LOAN_DURATION_LIMIT = 7;
	int STUDENT_LOAN_RESERVATION_LIMIT = 7;
	int TEACHER_LOAN_DURATION_LIMIT = 14;
	int TEACHER_LOAN_RESERVATION_LIMIT = 14;
}
