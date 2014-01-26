package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class BorrowerView extends JFrame {
	private static final long serialVersionUID = 1L;

	private JLabel devicesLabel;
	private JList<String> devicesList;
	private JButton loansButton;
	private JButton borrowButton;
	private JButton backButton;

	private DefaultListModel<String> listModel;

	/**
	 * The view for the borrowers (Students and Teachers)
	 */
	public BorrowerView() {
		devicesLabel = new JLabel("Devices : ");
		listModel = new DefaultListModel<String>();
		borrowButton = new JButton("Borrow...");
		backButton = new JButton("Back");
		loansButton = new JButton("See loans history");
		devicesList = new JList<String>(listModel);
		devicesList
				.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

		setLayout(new BorderLayout());
		setSize(new Dimension(400, 600));
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		add(loansButton, BorderLayout.NORTH);
		JPanel centerPanel = new JPanel(new BorderLayout());
		centerPanel.add(devicesLabel, BorderLayout.NORTH);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(devicesList);
		centerPanel.add(scrollPane, BorderLayout.CENTER);
		add(centerPanel, BorderLayout.CENTER);

		JPanel southPanel = new JPanel(new GridLayout(1, 2));
		southPanel.add(borrowButton);
		southPanel.add(backButton);
		add(southPanel, BorderLayout.SOUTH);

		setVisible(true);
	}

	// Getters and setters

	public JButton getLoansButton() {
		return loansButton;
	}

	public JLabel getDevicesLabel() {
		return devicesLabel;
	}

	public JList<String> getDevicesList() {
		return devicesList;
	}

	public JButton getBorrowButton() {
		return borrowButton;
	}

	public DefaultListModel<String> getListModel() {
		return listModel;
	}

	public JButton getBackButton() {
		return backButton;
	}
}
