package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import view.SimulationView;
import managementsystem.ManagementSystem;

/**
 * The controller of the Simulation view
 * 
 * @author Hugo SIMOND
 * 
 */
public class SimulationController {
	private ManagementSystem ms;
	private SimulationView view;
	private List<String> states;
	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

	public SimulationController(ManagementSystem m, SimulationView v) {
		ms = m;
		view = v;
		states = new ArrayList<String>();
		v.getOkButton().addActionListener(new OkListener());
		v.getCurrentDay().setText(dateFormat.format(new Date()));
		v.getPrevButton().addActionListener(new PrevListener());
		v.getNextButton().addActionListener(new NextListener());
		v.getLoansList().addMouseListener(new LoansListener());

		updateList();
	}

	public void updateList() {
		JList<String> loansList = view.getLoansList();
		loansList.removeAll();
		DefaultListModel<String> listModel = view.getListModel();
		Calendar calendar = Calendar.getInstance();
		try {
			calendar.setTime(dateFormat.parse(view.getCurrentDay().getText()));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}

		// TODO fill list
	}

	/**
	 * The listener of the cancel button
	 * 
	 * @author Hugo
	 * 
	 */

	public class OkListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			view.dispose();
		}
	}

	/**
	 * The listener of the next button
	 * 
	 * @author Hugo
	 * 
	 */
	public class NextListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Calendar calendar = Calendar.getInstance();
			try {
				calendar.setTime(dateFormat.parse(view.getCurrentDay()
						.getText()));
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			calendar.add(Calendar.DAY_OF_MONTH, 1);
			view.getCurrentDay().setText(dateFormat.format(calendar.getTime()));

			updateList();
		}
	}

	/**
	 * The listener of the prev button
	 * 
	 * @author Hugo
	 * 
	 */
	public class PrevListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Calendar calendar = Calendar.getInstance();
			try {
				calendar.setTime(dateFormat.parse(view.getCurrentDay()
						.getText()));
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			calendar.add(Calendar.DAY_OF_MONTH, -1);
			view.getCurrentDay().setText(dateFormat.format(calendar.getTime()));

			updateList();
		}
	}

	/**
	 * The listener of the list
	 * 
	 * @author Hugo
	 * 
	 */
	public class LoansListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent arg0) {
			if (view.getListModel().getSize() == 0) {
				return;
			}
			JList<String> list = view.getLoansList();
			int selected = list.getSelectedIndex();
			view.getStateLabel().setText(states.get(selected));
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
		}
	}
}
