package cityStuff;

import java.awt.EventQueue;
import cityStuff.*;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class gameEnvGui {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gameEnvGui window = new gameEnvGui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public gameEnvGui() {
		initialize();
		//cityAmmountPanel();//change to team set up later
		baseCampPanel();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 940, 642);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

	}
	private void baseCampPanel() {
		frame.getContentPane().setLayout(null);
		JButton btnNewButton_1 = new JButton("View Inventory");
		btnNewButton_1.setBounds(55, 478, 165, 91);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnViewStats = new JButton("View Stats");
		btnViewStats.setBounds(384, 478, 165, 91);
		frame.getContentPane().add(btnViewStats);
		
		JButton btnExitGame = new JButton("Exit Game");
		btnExitGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnExitGame.setBounds(708, 478, 165, 91);
		frame.getContentPane().add(btnExitGame);
		
		JButton btnNorth = new JButton("North");
		btnNorth.setBounds(405, 43, 117, 25);
		frame.getContentPane().add(btnNorth);
		
		JButton btnEast = new JButton("East");
		btnEast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEast.setBounds(737, 212, 117, 25);
		frame.getContentPane().add(btnEast);
		
		JButton btnSouth = new JButton("South");
		btnSouth.setBounds(405, 385, 117, 25);
		frame.getContentPane().add(btnSouth);
		
		JButton btnWest = new JButton("West");
		btnWest.setBounds(74, 212, 117, 25);
		frame.getContentPane().add(btnWest);
	}
	
	private void cityAmmountPanel() {
		frame.getContentPane().setLayout(null);
		JLabel lblHowManyCities = new JLabel("How Many Cities Would You Like To Save?");
		lblHowManyCities.setBounds(310, 84, 412, 15);
		frame.getContentPane().add(lblHowManyCities);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"3", "4", "5", "6"}));
		comboBox.setBounds(419, 151, 61, 24);
		frame.getContentPane().add(comboBox);
		
		JButton btnNewButton = new JButton("Confirm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String i = (String)comboBox.getSelectedItem();
				int num;
				try {
					num = Integer.parseInt(i);
				} catch (Exception lala) {
					num = 3;
				}
				//JOptionPane.showMessageDialog(null, i);
				gameEnvironmentGuiRunTime.setNumOfCities(num);
				//JOptionPane.showMessageDialog(null, gameEnvironmentGuiRunTime.num_of_cities);
				frame.getContentPane().removeAll();
				frame.repaint();
				baseCampPanel();
			}
		});
		btnNewButton.setBounds(363, 229, 171, 86);
		frame.getContentPane().add(btnNewButton);
	}
}
