import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.util.*;
import java.text.*;

import javax.swing.JList;
import javax.swing.JRadioButton;

import java.awt.GridLayout;

import javax.swing.JButton;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.RowSpec;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JTextArea;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.math.*;

public class ReserveGUI extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	Restaurant todays;
	
	
	private JPanel contentPane;
	private JTextField txtPartySize;
	private JTextField txtName;
	private JTextArea txtMsg;
	private JTextField txtRID;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField txtShowWait;
	private JTextField txtDinetime;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					ReserveGUI frame = new ReserveGUI();
					frame.setVisible(true);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});
	}
	

	/**
	 * Create the frame.
	 */
	public ReserveGUI() {

		//initialize restaurant
		todays = new Restaurant("todays");
		todays.openRestaurant("todays");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 445, 464);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWelcomeToReservation = new JLabel("*** Welcome to Reservation ***");
		lblWelcomeToReservation.setBounds(5, 5, 419, 24);
		lblWelcomeToReservation.setFont(new Font("Script MT Bold", Font.BOLD, 20));
		lblWelcomeToReservation.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblWelcomeToReservation);
		
		JLabel label = new JLabel("");
		label.setBounds(0, 0, 0, 0);
		contentPane.add(label);
		
		JLabel lblNewLabel_1 = new JLabel("Party Size : ");
		lblNewLabel_1.setBounds(5, 52, 96, 14);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		contentPane.add(lblNewLabel_1);
		
		txtPartySize = new JTextField();
		txtPartySize.setBounds(77, 49, 86, 20);
		txtPartySize.setColumns(10);
		contentPane.add(txtPartySize);
		
		JList list_1 = new JList();
		list_1.setBounds(0, 0, 0, 0);
		contentPane.add(list_1);
		
		JList list = new JList();
		list.setBounds(0, 0, 0, 0);
		contentPane.add(list);
		
		JLabel lblNewLabel_2 = new JLabel("Seat Type Preference : ");
		lblNewLabel_2.setBounds(5, 110, 131, 14);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		contentPane.add(lblNewLabel_2);
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 125, 274, 39);
		panel.setLayout(null);
		
		final JRadioButton radBar = new JRadioButton("Bar");
		
		buttonGroup.add(radBar);
		radBar.setBounds(0, 7, 77, 23);
		radBar.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(radBar);
		
		
		final JRadioButton radBooth = new JRadioButton("Booth");
		buttonGroup.add(radBooth);
		radBooth.setBounds(79, 7, 94, 23);
		panel.add(radBooth);
		radBooth.setHorizontalAlignment(SwingConstants.LEFT);
		
		final JRadioButton radWindow = new JRadioButton("Window ");
		buttonGroup.add(radWindow);
		radWindow.setBounds(175, 7, 93, 23);
		radWindow.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(radWindow);
		contentPane.add(panel);
		
		JLabel lblNewLabel_3 = new JLabel("Your Name : ");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3.setBounds(5, 185, 96, 14);
		contentPane.add(lblNewLabel_3);
		
		txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setBounds(109, 182, 170, 20);
		contentPane.add(txtName);
		
		JLabel lblNewLabel_4 = new JLabel("*** Message : ");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4.setBounds(5, 220, 96, 14);
		contentPane.add(lblNewLabel_4);
		
		txtMsg = new JTextArea();
		txtMsg.setBackground(new Color(255, 228, 181));
		txtMsg.setEditable(false);
		txtMsg.setLineWrap(true);
		txtMsg.setBounds(111, 215, 313, 52);
		contentPane.add(txtMsg);
		
		JLabel lblNewLabel_5 = new JLabel("(max. of 6 per table)");
		lblNewLabel_5.setBounds(173, 52, 113, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblToCancel = new JLabel("To Cancel -------------------------------------------------------------------");
		lblToCancel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblToCancel.setBounds(10, 278, 409, 14);
		contentPane.add(lblToCancel);
		
		JLabel lblYourReservationId = new JLabel("Your Reservation ID : ");
		lblYourReservationId.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblYourReservationId.setBounds(10, 303, 126, 14);
		contentPane.add(lblYourReservationId);
		
		txtRID = new JTextField();
		txtRID.setBounds(10, 318, 158, 20);
		contentPane.add(txtRID);
		txtRID.setColumns(10);
		
		JButton btnCancel = new JButton("CANCEL");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //cancel reservation
				boolean result = false;
				int id = Integer.parseInt(txtRID.getText());
				result = todays.cancelReservation(id);
				if(result)
				{
					txtMsg.setText("Your reservation : " + id + " was successfully cancelled.");
				}
				else
				{
					txtMsg.setText("Error while trying to cancel Reservation : " + id);
				}
				
			}
		});
		btnCancel.setBounds(282, 317, 142, 23);
		contentPane.add(btnCancel);
		
		JButton btnShowAll = new JButton("SHOW ALL RESERVATIONS");
		btnShowAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				todays.showAllReservs();
			}
		});
		btnShowAll.setBounds(10, 402, 269, 23);
		contentPane.add(btnShowAll);
		
		JButton btnCreate = new JButton("CREATE");
		btnCreate.setBounds(285, 180, 139, 24);
		contentPane.add(btnCreate);
		
		JButton btnClear = new JButton("CLEAR");
		btnClear.setBounds(282, 351, 142, 24);
		contentPane.add(btnClear);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.setBounds(282, 401, 142, 24);
		contentPane.add(btnExit);
		
		txtShowWait = new JTextField();
		txtShowWait.setEditable(false);
		txtShowWait.setBounds(289, 140, 130, 24);
		contentPane.add(txtShowWait);
		txtShowWait.setColumns(10);
		
		JButton btnShowWait = new JButton("SHOW WAIT TIME");
		btnShowWait.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnShowWait.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //shows wait time for each seat type
				
				if(radBar.isSelected())
				{
					txtShowWait.setText(todays.getWaitTime("Bar") + " min");
				}
				else if(radBooth.isSelected())
				{
					txtShowWait.setText(todays.getWaitTime("Booth") + " min");
				}
				else if(radWindow.isSelected())
				{
					txtShowWait.setText(todays.getWaitTime("Window") + " min");
				}
			}
		});
		btnShowWait.setBounds(289, 106, 130, 23);
		contentPane.add(btnShowWait);
		
		JLabel lblNewLabel_6 = new JLabel("Desired Dining Time : ");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_6.setBounds(5, 72, 131, 14);
		contentPane.add(lblNewLabel_6);
		
		txtDinetime = new JTextField();
		txtDinetime.setBounds(132, 69, 86, 20);
		contentPane.add(txtDinetime);
		txtDinetime.setColumns(10);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) { //exits program
				
				System.exit(0);
			}
		});
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //clears all text & radio
				
				
				txtPartySize.setText("");
				txtName.setText("");
				txtMsg.setText("");
				txtRID.setText("");
				txtShowWait.setText("");
				txtDinetime.setText("");
				radBar.setSelected(false);
				radBooth.setSelected(false);
				radWindow.setSelected(false);
				
			}
		});
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //create reservation
				
				int partysize1 = Integer.parseInt(txtPartySize.getText());
				int dinetime1;
				if(txtDinetime.equals(""))
				{
					dinetime1 = 60 + (int)(60 * Math.random()); //if dinetime is not entered, default is 60
				}
				dinetime1 = Integer.parseInt(txtDinetime.getText());
				String name1 = txtName.getText(); 
				String seatType1 = "default";
				if(radBar.isSelected())
				{
					seatType1 = "Bar";
				}
				else if(radBooth.isSelected())
				{
					seatType1 = "Booth";
				}
				else if(radWindow.isSelected())
				{
					seatType1 = "Window";
				}
				
				
				
				int rID1 = todays.makeReservation(name1, seatType1, partysize1, dinetime1);
				if(rID1 == 0)
				{
					txtMsg.setText(todays.mLasterror);
				}
				else
				{
					txtMsg.setText("Thank you! \nYour Reservation ID is " + rID1);	
				}
			
				
				
				
					
				
			}
		});
		
		
	
		
	}
	
	
}
