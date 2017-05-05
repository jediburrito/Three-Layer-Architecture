package userinterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import businesslayer.Main;
import businesslayer.MethodHolder;
import businesslayer.Person;

import java.awt.FlowLayout;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;

public class guiInterface extends JFrame {

	private JPanel contentPane;
	private JTextField txtInsertTextHere;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JTextField textField_3;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					guiInterface frame = new guiInterface();
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
	public guiInterface() throws Exception, NumberFormatException{
		
		
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 220, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		lblNewLabel = new JLabel("First Name");
		contentPane.add(lblNewLabel);
		
		txtInsertTextHere = new JTextField();
		contentPane.add(txtInsertTextHere);
		txtInsertTextHere.setColumns(10);
		
		lblNewLabel_1 = new JLabel("Last Name");
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		contentPane.add(textField);
		textField.setColumns(10);
		
		lblNewLabel_2 = new JLabel("             age");
		contentPane.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		lblNewLabel_3 = new JLabel("            SSN");
		contentPane.add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		lblNewLabel_4 = new JLabel("Credit Card");
		contentPane.add(lblNewLabel_4);
		
		textField_3 = new JTextField();
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		btnNewButton = new JButton("Confirm");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String firstName = txtInsertTextHere.getText();
				String lastName = textField.getText();
				String age = textField_1.getText();
				String ssn = textField_2.getText();
				String creditCard = textField_3.getText();
				MethodHolder personInsert = new MethodHolder();
			
				
				try {
					if(firstName.isEmpty() || lastName.isEmpty()){
						
						throw new Exception();
			}
				
				int ageInt = Integer.parseInt(age);
				long ssnLong = Long.parseLong(ssn);
				long creditCardLong = Long.parseLong(creditCard);
				Person newGuy = new Person(firstName,lastName, ageInt, ssnLong,creditCardLong);
				MethodHolder.insertPerson(newGuy);
			}catch(NumberFormatException nfe){
				System.out.println("Number format Exception: please enter valid numbers!");
			} catch (Exception e) {
				
				System.out.println("Invalid entry!");
				setVisible(false);
			}
				setVisible(false);
				
				
			
			}
		});
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				setVisible(false);
				
			}
		});
		contentPane.add(btnNewButton_1);
	}

}
