package librarysystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import business.LoginException;
import business.SystemController;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import dataaccess.Auth;

public class AddNewMember extends JFrame implements LibWindow {
	
	public static final AddNewMember INSTANCE = new AddNewMember();
	private boolean isInitialized = false;
	
	private JTextField firstName;
	private JTextField lastName;
	private JTextField phone;
	private JTextField street;
	private JTextField city;
	private JTextField state;
	private JTextField zip;
	private JPanel contentPane;
	private JTextField memberId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddNewMember frame = new AddNewMember();
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

	private AddNewMember() {
	
	}

	public void init() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 681, 433);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("First Name");
		lblNewLabel.setBounds(236, 37, 62, 13);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Street");
		lblNewLabel_1.setBounds(236, 137, 45, 13);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("City");
		lblNewLabel_2.setBounds(452, 137, 45, 13);
		contentPane.add(lblNewLabel_2);

		firstName = new JTextField();
		firstName.setBounds(236, 60, 174, 34);
		contentPane.add(firstName);
		firstName.setColumns(10);

		street = new JTextField();
		street.setBounds(236, 160, 174, 34);
		contentPane.add(street);
		street.setColumns(10);

		city = new JTextField();
		city.setBounds(452, 160, 174, 34);
		contentPane.add(city);
		city.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("State");
		lblNewLabel_3.setBounds(33, 208, 45, 13);
		contentPane.add(lblNewLabel_3);

		state = new JTextField();
		state.setBounds(33, 231, 174, 34);
		contentPane.add(state);
		state.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Zip");
		lblNewLabel_4.setBounds(236, 208, 45, 13);
		contentPane.add(lblNewLabel_4);

		zip = new JTextField();
		zip.setBounds(236, 231, 174, 34);
		contentPane.add(zip);
		zip.setColumns(10);

		lastName = new JTextField();
		lastName.setBounds(452, 60, 174, 34);
		contentPane.add(lastName);
		lastName.setColumns(10);

		phone = new JTextField();
		phone.setBounds(33, 160, 174, 34);
		contentPane.add(phone);
		phone.setColumns(10);

		JButton submitButton = new JButton("Add Member");
		submitButton.setBounds(405, 326, 144, 34);
		addNewMemberButtonListener(submitButton);

		contentPane.add(submitButton);

		JLabel lblNewLabel_5 = new JLabel("Last Name");
		lblNewLabel_5.setBounds(452, 37, 62, 13);
		contentPane.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("Telephone");
		lblNewLabel_6.setBounds(33, 137, 62, 13);
		contentPane.add(lblNewLabel_6);

		memberId = new JTextField();
		memberId.setBounds(33, 60, 174, 34);
		contentPane.add(memberId);
		memberId.setColumns(10);

		JLabel lblNewLabel_8 = new JLabel("Member ID");
		lblNewLabel_8.setBounds(33, 37, 62, 13);
		contentPane.add(lblNewLabel_8);
		
		JButton back = new JButton("Back to Main");
		back.setBounds(101, 326, 149, 34);
		addBackButtonListener(back);
		contentPane.add(back);
		
		//getContentPane().add(mainPanel);
		isInitialized = true;
	}
	private void addNewMemberButtonListener(JButton butn) {

		butn.addActionListener(evt -> {

			SystemController control = new SystemController();
			try {
				control.addNewMember(memberId.getText(), firstName.getText(), lastName.getText(), phone.getText(),
						street.getText(), city.getText(), state.getText(), zip.getText());
				JOptionPane.showMessageDialog(this, "Add new member successfully");
			} catch (LoginException e) {
				JOptionPane.showMessageDialog(this, e.getMessage());
			}
		});

	}
	
	private void addBackButtonListener(JButton butn) {

		butn.addActionListener(evt -> {
			LibrarySystem.hideAllWindows();
			LibrarySystem.INSTANCE.setVisible(true);
		});

	}
	
	@Override
	public boolean isInitialized() {
		// TODO Auto-generated method stub
		return isInitialized;
	}

	@Override
	public void isInitialized(boolean val) {
		isInitialized = val;
		
	}
}
