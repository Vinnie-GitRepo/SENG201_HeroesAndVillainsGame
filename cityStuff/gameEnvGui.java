package cityStuff;

import java.awt.EventQueue;
import cityStuff.*;
import games.diceRollGame;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;

public class gameEnvGui {
	public static int citiesFinished = 0;
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
		cityAmmountPanel();//change to team set up later
		//baseCampPanel();
		//villiansLairPanel();
		//battleSelectionPanel();
		//diceRollPanel();
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
		btnViewStats.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, gameEnvironmentGuiRunTime.getTeam().toString());
			}
		});
		btnViewStats.setBounds(384, 478, 165, 91);
		frame.getContentPane().add(btnViewStats);
		
		JButton btnExitGame = new JButton("Exit Game");
		btnExitGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				citiesFinished += 1;
				frame.getContentPane().removeAll();
				frame.repaint();
				baseCampPanel();
			}
		});
		btnExitGame.setBounds(708, 478, 165, 91);
		frame.getContentPane().add(btnExitGame);
		
		JButton btnNorth = new JButton("North");
		btnNorth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				frame.repaint();
				if (btnNorth.getText() == "Lair") {
					villiansLairPanel();
				}
			}
		});
		btnNorth.setBounds(405, 43, 117, 25);
		frame.getContentPane().add(btnNorth);
		btnNorth.setText(gameEnvironmentGuiRunTime.getCurrentMap(citiesFinished).get(0));
		JButton btnEast = new JButton("East");
		btnEast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				frame.repaint();
				if (btnEast.getText() == "Lair") {
					villiansLairPanel();
				}
			}
		});
		btnEast.setBounds(737, 212, 117, 25);
		frame.getContentPane().add(btnEast);
		btnEast.setText(gameEnvironmentGuiRunTime.getCurrentMap(citiesFinished).get(1));
		JButton btnSouth = new JButton("South");
		btnSouth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				frame.repaint();
				if (btnSouth.getText() == "Lair") {
					villiansLairPanel();
				}
			}
		});
		btnSouth.setBounds(405, 385, 117, 25);
		frame.getContentPane().add(btnSouth);
		btnSouth.setText(gameEnvironmentGuiRunTime.getCurrentMap(citiesFinished).get(2));
		JButton btnWest = new JButton("West");
		btnWest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				frame.repaint();
				if (btnWest.getText() == "Lair") {
					villiansLairPanel();
				}
			}
		});
		btnWest.setBounds(74, 212, 117, 25);
		frame.getContentPane().add(btnWest);
		btnWest.setText(gameEnvironmentGuiRunTime.getCurrentMap(citiesFinished).get(3));
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
				gameEnvironmentGuiRunTime.generateVillians(num);
				gameEnvironmentGuiRunTime.setThingsUp(num);
				for (int l = 0; l != num; l++) {
					ArrayList<String >map = gameEnvironmentGuiRunTime.generateLayout();
					gameEnvironmentGuiRunTime.addBaseCamp(map);
				}
				//JOptionPane.showMessageDialog(null, gameEnvironmentGuiRunTime.num_of_cities);
				frame.getContentPane().removeAll();
				frame.repaint();
				baseCampPanel();
			}
		});
		btnNewButton.setBounds(363, 229, 171, 86);
		frame.getContentPane().add(btnNewButton);
	}
	
	
	private void villiansLairPanel() {
		frame.getContentPane().setLayout(null);
		JButton btnNewButton_2 = new JButton("Flee From The Lair");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				frame.repaint();
				baseCampPanel();
			}
		});
		btnNewButton_2.setBounds(111, 468, 241, 90);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnBattleTheVillian = new JButton("Battle The Villian");
		btnBattleTheVillian.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				frame.repaint();
				
				battleSelectionPanel();
			}
		});
		btnBattleTheVillian.setBounds(538, 468, 241, 90);
		frame.getContentPane().add(btnBattleTheVillian);
	}
	
	private void battleSelectionPanel() {
		frame.getContentPane().setLayout(null);
		JButton btnNewButton_3 = new JButton("Paper Scissors Rock");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton_3.setBounds(87, 139, 179, 118);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnGuessTheRandom = new JButton("Guess The Random Number");
		btnGuessTheRandom.setBounds(359, 139, 179, 118);
		frame.getContentPane().add(btnGuessTheRandom);
		
		JButton btnRollTheDice = new JButton("Roll The Dice");
		btnRollTheDice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				frame.repaint();
				diceRollPanel();
			}
		});
		btnRollTheDice.setBounds(630, 139, 179, 118);
		frame.getContentPane().add(btnRollTheDice);
	}
	private void diceRollPanel() {
		frame.getContentPane().setLayout(null);
		JLabel lblBattlingWith = new JLabel("Battling With ");
		lblBattlingWith.setBounds(361, 24, 269, 14);
		lblBattlingWith.setText("Battle With: " + gameEnvironmentGuiRunTime.getTeam().getHeroArray().get(0).getName());
		frame.getContentPane().add(lblBattlingWith);
		
		JLabel lblHero = new JLabel("hero1");
		lblHero.setBounds(56, 24, 46, 14);
		frame.getContentPane().add(lblHero);
		
		
		JLabel lblHero_1 = new JLabel("hero2");
		lblHero_1.setBounds(56, 98, 46, 14);
		frame.getContentPane().add(lblHero_1);
		
		JLabel lblHero_2 = new JLabel("hero3");
		lblHero_2.setBounds(56, 175, 46, 14);
		frame.getContentPane().add(lblHero_2);
		
		
		JRadioButton char_1_box = new JRadioButton("");
		char_1_box.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblBattlingWith.setText("Battle With: " + gameEnvironmentGuiRunTime.getTeam().getHeroArray().get(0).getName());
			}
		});
		char_1_box.setBounds(66, 45, 97, 23);
		char_1_box.setSelected(true);
		frame.getContentPane().add(char_1_box);
		
		JRadioButton char_2_box = new JRadioButton("");
		char_2_box.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblBattlingWith.setText("Battle With: " + gameEnvironmentGuiRunTime.getTeam().getHeroArray().get(1).getName());
			}
		});
		char_2_box.setBounds(66, 119, 97, 23);
		frame.getContentPane().add(char_2_box);
		
		JRadioButton char_3_box = new JRadioButton("");
		char_3_box.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblBattlingWith.setText("Battle With: " + gameEnvironmentGuiRunTime.getTeam().getHeroArray().get(2).getName());
			}
		});
		char_3_box.setBounds(66, 196, 97, 23);
		frame.getContentPane().add(char_3_box);
		
		try {
			lblHero.setText(gameEnvironmentGuiRunTime.getTeam().getHeroArray().get(0).getName());
		} catch (Exception noName0) {
			lblHero.setVisible(false);
			char_1_box.setVisible(false);
		}
		try {
			lblHero_1.setText(gameEnvironmentGuiRunTime.getTeam().getHeroArray().get(1).getName());
		} catch (Exception noName0) {
			lblHero_1.setVisible(false);
			char_2_box.setVisible(false);
		}
		try {
			lblHero_2.setText(gameEnvironmentGuiRunTime.getTeam().getHeroArray().get(2).getName());
		} catch (Exception noName0) {
			lblHero_2.setVisible(false);
			char_3_box.setVisible(false);
		}
		
		ButtonGroup charsForBattle = new ButtonGroup();
		charsForBattle.add(char_1_box);
		charsForBattle.add(char_2_box);
		charsForBattle.add(char_3_box);
		
		JLabel lblResult = new JLabel("You Need To Roll The Dice First!");
		lblResult.setBounds(281, 137, 304, 55);
		frame.getContentPane().add(lblResult);
		
		JButton btnRollDice = new JButton("Roll Dice");
		btnRollDice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int hero = diceRollGame.getHeroRoll();
				int vill = diceRollGame.getVillianRoll();
				String result = diceRollGame.calculateWinnerGui(hero, vill);
				lblResult.setText(result);
			}
		});
		btnRollDice.setBounds(281, 389, 311, 138);
		frame.getContentPane().add(btnRollDice);
		
		

		
	}
	
	
	private void numberGuessPanel() {
		frame.getContentPane().setLayout(null);
		JLabel lblWhatsYourGuess = new JLabel("Whats Your Guess?");
		lblWhatsYourGuess.setBounds(229, 404, 129, 14);
		frame.getContentPane().add(lblWhatsYourGuess);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		comboBox.setBounds(349, 400, 65, 22);
		frame.getContentPane().add(comboBox);
		
		JButton btnConfirmYourGuess = new JButton("Confirm Your Guess");
		btnConfirmYourGuess.setBounds(452, 400, 138, 23);
		frame.getContentPane().add(btnConfirmYourGuess);
	}
	
	
	private void paperScissorsRockPanel() {
		frame.getContentPane().setLayout(null);
	}
}
