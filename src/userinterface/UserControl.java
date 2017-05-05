package userinterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import businesslayer.MethodHolder;
import businesslayer.Person;

import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class UserControl extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserControl frame = new UserControl();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println(e);
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UserControl() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnNewButton = new JButton("Info Entry");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent f) {
				try {
					guiInterface newPerson = new guiInterface();
					newPerson.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println(e);
				}
				
			}
		});
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Exit");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		
		JButton btnNewButton_2 = new JButton("Info List");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MethodHolder infoList = new MethodHolder();
				try {
					ArrayList<Person> personHolder = infoList.findAllPeople();
				} catch (Exception e1) {
					e1.printStackTrace();
					System.out.println(e);
				}
				
				
			}
		});
		
		JButton btnNewButton_3 = new JButton("Person Search");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PersonSearch newSearch;
				try {
					newSearch = new PersonSearch();
					newSearch.setVisible(true);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		contentPane.add(btnNewButton_3);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_4 = new JButton("Delete Person");
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DeletePerson deletePerson = new DeletePerson();
				deletePerson.setVisible(true);
				
				
			}
		});
		contentPane.add(btnNewButton_4);
		contentPane.add(btnNewButton_1);
	}

}
