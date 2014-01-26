package view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class AlgorithmView extends JFrame {
	private static final long serialVersionUID = 1L;

	private JLabel loansLabel;
	private JList<String> loansList;
	private JButton okButton;
	private DefaultListModel<String> listModel;
	private JLabel reason;

	/**
	 * The view for displaying the invalid loans
	 */
	public AlgorithmView() {
		loansLabel = new JLabel("Invalid loans (click to see the reason) : ");
		listModel = new DefaultListModel<String>();
		okButton = new JButton("OK");
		loansList = new JList<String>(listModel);
		loansList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		reason = new JLabel();

		setTitle("Invalid loans");
		setLayout(new BorderLayout());
		setSize(new Dimension(400, 600));
		setLocationRelativeTo(null);
		setResizable(false);

		JPanel p1 = new JPanel(new BorderLayout());
		JPanel centerPanel = new JPanel(new BorderLayout());
		centerPanel.add(loansLabel, BorderLayout.NORTH);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(loansList);
		centerPanel.add(scrollPane, BorderLayout.CENTER);
		p1.add(centerPanel, BorderLayout.CENTER);

		JPanel reasonPanel = new JPanel(new BorderLayout());
		reasonPanel.add(new JLabel("Reason : "), BorderLayout.WEST);
		reasonPanel.add(reason, BorderLayout.CENTER);
		p1.add(reasonPanel, BorderLayout.SOUTH);
		add(p1, BorderLayout.CENTER);

		JPanel southPanel = new JPanel();
		southPanel.add(okButton);
		add(southPanel, BorderLayout.SOUTH);

		setVisible(true);
	}

	// Getters and setters

	public JLabel getLoansLabel() {
		return loansLabel;
	}

	public JList<String> getLoansList() {
		return loansList;
	}

	public JButton getOkButton() {
		return okButton;
	}

	public DefaultListModel<String> getListModel() {
		return listModel;
	}

	public JLabel getReason() {
		return reason;
	}
}
