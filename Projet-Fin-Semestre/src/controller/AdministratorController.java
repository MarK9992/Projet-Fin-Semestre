package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import managementsystem.Ask;
import managementsystem.ManagementSystem;
import users.Manager;
import view.AccountView;
import view.AdministratorView;
import view.AlgorithmView;
import view.SimulationView;
import view.StatisticsView;

public class AdministratorController {

	private String adminId;
	private ManagementSystem ms;
	private AdministratorView view;
	private List<Ask> asks;

	public AdministratorController(String adminId, ManagementSystem m,
			AdministratorView v) {
		this.adminId = adminId;
		ms = m;
		view = v;
		view.setTitle(ms.getUser(adminId).getName());
		asks = new LinkedList<Ask>();

		obtainBorrowingsStrings();

		view.getValidateButton().addActionListener(new AcceptListener());
		view.getBackButton().addActionListener(new BackListener());
		view.getSimulationButton().addActionListener(new SimulationListener());
		view.getAlgoButton().addActionListener(new AlgorithmListener());
		view.getStatisticsButton().addActionListener(new StatisticsListener());
	}

	/**
	 * Validate a borrowing
	 * 
	 * @param idBorrowing
	 *            the id of the borrowing to validate
	 * @throws IOException
	 * @throws Exception
	 *             if the borrowing can't be accepted anymore
	 */
	public void accept(Ask ask) throws IllegalArgumentException, IOException {
		try {
			((Manager) ms.getUser(adminId)).acceptAsk(ask);
		} catch (NullPointerException e) {
			System.out
					.println("Erreur pas suffisamment d'équipements disponible. (cette erreur se produit tout le temps, le problème n'est pas résolu)");
		}
	}

	/**
	 * Retrieves the ids and labels from the model Adds the labels to the view's
	 * list Adds the Ids to the LinkedList
	 */
	public void obtainBorrowingsStrings() {
		asks.clear();
		for (int i = 0; i < ms.getAsks().size(); i++) {
			asks.add(ms.getAsks().get(i));
			view.getListModel().addElement(ms.getAsks().get(i).toString());
		}
	}

	/**
	 * The listener of the use algo button
	 * 
	 * @author Hugo
	 * 
	 */

	public class AlgorithmListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			AlgorithmView newView = new AlgorithmView();
			new AlgorithmController(ms, (Manager) ms.getUser(adminId), newView);
		}
	}

	/**
	 * The listener of the Statistics button
	 * 
	 * @author Hugo
	 * 
	 */

	public class StatisticsListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			StatisticsView newView = new StatisticsView();
			new StatisticsController(ms, newView);
		}
	}

	/**
	 * The listener of the Simulation button
	 * 
	 * @author Hugo
	 * 
	 */

	public class SimulationListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			SimulationView newView = new SimulationView();
			new SimulationController(ms, newView);
		}
	}

	/**
	 * The listener of the back button
	 * 
	 * @author Hugo
	 * 
	 */

	public class BackListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			AccountView newView = new AccountView();
			new AccountController(ms, newView);
			view.dispose();
		}
	}

	/**
	 * The listener of the validate button
	 * 
	 * @author Hugo
	 * 
	 */
	public class AcceptListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			List<Integer> indexSelected = new LinkedList<Integer>();

			for (int i = 0; i < view.getListModel().getSize(); i++) {
				for (int j = 0; j < view.getBorrowingsList()
						.getSelectedIndices().length; j++) {
					if (view.getBorrowingsList().getSelectedIndices()[j] == i) {
						try {
							accept(asks.get(i));
						} catch (IllegalArgumentException e1) {
							e1.printStackTrace();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						indexSelected.add(i);
					}
				}
			}

			view.clearList();
			obtainBorrowingsStrings();

			// TODO Save the changes
		}
	}

}
