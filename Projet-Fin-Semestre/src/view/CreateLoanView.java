package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerNumberModel;

/**
 * View for creating a borrowing
 * 
 * @author Hugo
 * 
 */
public class CreateLoanView extends JDialog {
	private static final long serialVersionUID = 1L;
	private List<SpinnerNumberModel> numberModelList;
	private List<JSpinner> quantitiesList;
	private List<JLabel> labelsList;
	private SpinnerDateModel dateModelStart;
	private SpinnerDateModel dateModelEnd;
	private JSpinner startDate;
	private JSpinner endDate;
	private JButton borrowButton;
	private JButton cancelButton;
	private JPanel panelNorth;
	private JLabel startDateLabel;
	private JLabel endDateLabel;

	public CreateLoanView() {
		setTitle("Create loan");
		setSize(new Dimension(400, 400));
		setLocationRelativeTo(null);
		setResizable(false);

		setLayout(new BorderLayout());

		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.YEAR, 999);
		startDateLabel = new JLabel("From : ");
		endDateLabel = new JLabel("To : ");
		dateModelStart = new SpinnerDateModel();
		dateModelEnd = new SpinnerDateModel();
		numberModelList = new LinkedList<SpinnerNumberModel>();
		quantitiesList = new LinkedList<JSpinner>();
		labelsList = new LinkedList<JLabel>();
		startDate = new JSpinner(dateModelStart);
		String dateFormat = "dd/MM/yyyy";
		startDate.setEditor(new JSpinner.DateEditor(startDate, dateFormat));
		endDate = new JSpinner(dateModelEnd);
		endDate.setEditor(new JSpinner.DateEditor(endDate, dateFormat));
		borrowButton = new JButton("Borrow");
		cancelButton = new JButton("Cancel");

		JPanel southPanel = new JPanel(new GridLayout(2, 2));

		JPanel startDatePanel = new JPanel(new GridLayout(2, 1));
		startDatePanel.add(startDateLabel);
		startDatePanel.add(startDate);
		southPanel.add(startDatePanel);

		JPanel endDatePanel = new JPanel(new GridLayout(2, 1));
		endDatePanel.add(endDateLabel);
		endDatePanel.add(endDate);
		southPanel.add(endDatePanel);

		southPanel.add(borrowButton);
		southPanel.add(cancelButton);

		add(southPanel, BorderLayout.SOUTH);

		setVisible(true);
	}

	/**
	 * Add the devices dynamically
	 * 
	 * @param devices
	 */
	public void fillDevicesList(HashMap<String, Integer> devices) {
		numberModelList.clear();
		labelsList.clear();
		quantitiesList.clear();
		panelNorth = new JPanel(new GridLayout(devices.size(), 2));
		for (String s : devices.keySet()) {
			SpinnerNumberModel model = new SpinnerNumberModel();
			JLabel label = new JLabel(s);
			model.setValue(1);
			model.setMinimum(1);
			model.setMaximum(devices.get(s));
			JSpinner spinner = new JSpinner(model);
			JPanel panel = new JPanel();
			panel.add(spinner);
			numberModelList.add(model);
			labelsList.add(label);
			quantitiesList.add(spinner);
			panelNorth.add(label);
			panelNorth.add(panel);
		}

		add(panelNorth, BorderLayout.NORTH);
		setVisible(true);
	}

	/**
	 * Displays a message error
	 * 
	 * @param message
	 *            , error to display
	 */
	public void errorMessage(String message) {
		JOptionPane.showMessageDialog(this, message);
	}

	// Getters and Setters

	public List<JSpinner> getQuantitiesList() {
		return quantitiesList;
	}

	public List<JLabel> getLabelsList() {
		return labelsList;
	}

	public JButton getBorrowButton() {
		return borrowButton;
	}

	public JSpinner getStartDate() {
		return startDate;
	}

	public JSpinner getEndDate() {
		return endDate;
	}

	public JButton getCancelButton() {
		return cancelButton;
	}

	public List<SpinnerNumberModel> getNumberModelList() {
		return numberModelList;
	}

	public SpinnerDateModel getDateModelStart() {
		return dateModelStart;
	}

	public SpinnerDateModel getDateModelEnd() {
		return dateModelEnd;
	}
}
