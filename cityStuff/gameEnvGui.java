package cityStuff;

import java.awt.EventQueue;
import cityStuff.*;
import games.*;

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
import java.awt.Font;
import java.awt.Color;

public class gameEnvGui {
	public static int citiesFinished = 0;
	public static int numOfGuesses = 0;
	public static int vill;
	public gameEnvironmentGuiRunTime game = new gameEnvironmentGuiRunTime();
	private JFrame frame;
	private JTextField textField;

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
//		cityAmmountPanel();//change to team set up later
//		baseCampPanel();
//		villiansLairPanel();
//		battleSelectionPanel();
//		diceRollPanel();
//		numberGuessPanel();
//		paperScissorsRockPanel();
		teamInitializerPanel();
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
				JOptionPane.showMessageDialog(null, game.getTeam().toString());
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
		btnNorth.setText(game.getCurrentMap(citiesFinished).get(0));
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
		btnEast.setText(game.getCurrentMap(citiesFinished).get(1));
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
		btnSouth.setText(game.getCurrentMap(citiesFinished).get(2));
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
		btnWest.setText(game.getCurrentMap(citiesFinished).get(3));
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
//				JOptionPane.showMessageDialog(null, i);
				game.setNumOfCities(num);
				game.generateVillians(num);
				game.setCurrentVillian(0);
				game.setThingsUp(num);
				for (int l = 0; l != num; l++) {
					ArrayList<String> map = game.generateLayout();
					game.addBaseCamp(map);
				}
				//JOptionPane.showMessageDialog(null, game.num_of_cities);
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
				frame.getContentPane().removeAll();
				frame.repaint();
				paperScissorsRockPanel();
			}
		});
		btnNewButton_3.setBounds(87, 139, 179, 118);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnGuessTheRandom = new JButton("Guess The Random Number");
		btnGuessTheRandom.setBounds(359, 139, 179, 118);
		btnGuessTheRandom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				frame.repaint();
				numberGuessPanel();
			}
		});
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
		lblBattlingWith.setText("Battle With: " + game.getTeam().getHeroArray().get(0).getName());
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
				lblBattlingWith.setText("Battle With: " + game.getTeam().getHeroArray().get(0).getName());
				game.setCurrentHero(0);
			}
		});
		char_1_box.setBounds(66, 45, 97, 23);
		char_1_box.setSelected(true);
		frame.getContentPane().add(char_1_box);
		
		JRadioButton char_2_box = new JRadioButton("");
		char_2_box.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblBattlingWith.setText("Battle With: " + game.getTeam().getHeroArray().get(1).getName());
				game.setCurrentHero(1);
			}
		});
		char_2_box.setBounds(66, 119, 97, 23);
		frame.getContentPane().add(char_2_box);
		
		JRadioButton char_3_box = new JRadioButton("");
		char_3_box.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblBattlingWith.setText("Battle With: " + game.getTeam().getHeroArray().get(2).getName());
				game.setCurrentHero(2);
			}
		});
		char_3_box.setBounds(66, 196, 97, 23);
		frame.getContentPane().add(char_3_box);
		
		try {
			lblHero.setText(game.getTeam().getHeroArray().get(0).getName());
		} catch (Exception noName0) {
			lblHero.setVisible(false);
			char_1_box.setVisible(false);
		}
		try {
			lblHero_1.setText(game.getTeam().getHeroArray().get(1).getName());
		} catch (Exception noName0) {
			lblHero_1.setVisible(false);
			char_2_box.setVisible(false);
		}
		try {
			lblHero_2.setText(game.getTeam().getHeroArray().get(2).getName());
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
				JOptionPane.showMessageDialog(null, "You Have Rolled A " + hero);
				JOptionPane.showMessageDialog(null, "The Villian Has Rolled A " + vill);
				String result = diceRollGame.calculateWinnerGui(hero, vill);
				lblResult.setText(result);
				if (hero > vill) {
					game.getCurrentVillian().oneDefeat();
					JOptionPane.showMessageDialog(null, "You Have Bet The Villian " + game.getCurrentVillian().getLossCount() + " Times");
					if (game.getCurrentVillian().getLossCount() == 3) {
						JOptionPane.showMessageDialog(null, "You Destroyed The Villian!");
						citiesFinished += 1;
						frame.getContentPane().removeAll();
						frame.repaint();
						//game.setCurrentHero(citiesFinished);
						game.setCurrentVillian(citiesFinished);
						baseCampPanel();
					}
				} else if (hero < vill) {
					if (game.getTeam().getHeroArray().get(game.getCurrentHero()).getCurrentHealth() - 25 == 0) {
						game.getTeam().getHeroArray().get(game.getCurrentHero()).damageHealth(25);
						JOptionPane.showMessageDialog(null, "Your Hero Is Dead!");
						if (game.getCurrentHero() == 0) {
							lblHero.setVisible(false);
							char_1_box.setVisible(false);
						} else if (game.getCurrentHero() == 1) {
							lblHero_1.setVisible(false);
							char_2_box.setVisible(false);
						} else {
							lblHero_2.setVisible(false);
							char_3_box.setVisible(false);
						}
						int stillAliveChar = 999;
						for (int i = 0; i < game.getTeam().getHeroArray().size(); i++) {
							if (game.getTeam().getHeroArray().get(i).getCurrentHealth() != 0) {
								stillAliveChar = i;
								game.setCurrentHero(i);
								break;
							}
						}
						if (stillAliveChar == 999) {
							frame.getContentPane().removeAll();
							frame.repaint();
							lossGamePanel();
						} else if (game.getCurrentHero() == 0) {
							lblBattlingWith.setText("Battle With: " + game.getTeam().getHeroArray().get(0).getName());
							char_1_box.setSelected(true);
						} else if (game.getCurrentHero() == 1) {
							lblBattlingWith.setText("Battle With: " + game.getTeam().getHeroArray().get(1).getName());
							char_2_box.setSelected(true);
						} else {
							lblBattlingWith.setText("Battle With: " + game.getTeam().getHeroArray().get(2).getName());
							char_3_box.setSelected(true);
						}
						System.out.println(game.getTeam().getHeroArray().size());
					} else {
						JOptionPane.showMessageDialog(null, "Your Hero Takes 25 Damage");
						game.getTeam().getHeroArray().get(game.getCurrentHero()).damageHealth(25);//method works if there is only 1 person in the team, however when there are 2 or more then a person  gets removed and the array shrinks but doesnt go into the catch
					}
					//game.;
					//if (game.getTeam().getHeroArray().size() == 0) {
						
					//}
				}
			}
		});
		btnRollDice.setBounds(119, 400, 311, 138);
		frame.getContentPane().add(btnRollDice);
		
		JButton btnViewStats_1 = new JButton("View Stats");
		btnViewStats_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, game.getTeam().toString());
			}
		});
		btnViewStats_1.setBounds(499, 400, 311, 138);
		frame.getContentPane().add(btnViewStats_1);
		
	}
	
	
	private void numberGuessPanel() {
		//int numOfGuesses = 0;
		vill = numberGuess.getVillianChoice();
		frame.getContentPane().setLayout(null);
		JLabel lblWhatsYourGuess = new JLabel("Whats Your Guess?");
		lblWhatsYourGuess.setBounds(373, 253, 129, 14);
		frame.getContentPane().add(lblWhatsYourGuess);
		
		JLabel lblBattlingWith = new JLabel("Battling With ");
		lblBattlingWith.setBounds(361, 24, 269, 14);
		lblBattlingWith.setText("Battle With: " + game.getTeam().getHeroArray().get(0).getName());
		frame.getContentPane().add(lblBattlingWith);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		comboBox.setBounds(383, 278, 65, 22);
		frame.getContentPane().add(comboBox);
		
		JLabel lblResult = new JLabel("You Need To Roll The Dice First!");
		lblResult.setBounds(281, 137, 304, 55);
		frame.getContentPane().add(lblResult);
		
		
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
				lblBattlingWith.setText("Battle With: " + game.getTeam().getHeroArray().get(0).getName());
				game.setCurrentHero(0);
			}
		});
		char_1_box.setBounds(66, 45, 97, 23);
		char_1_box.setSelected(true);
		frame.getContentPane().add(char_1_box);
		
		JRadioButton char_2_box = new JRadioButton("");
		char_2_box.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblBattlingWith.setText("Battle With: " + game.getTeam().getHeroArray().get(1).getName());
				game.setCurrentHero(1);
			}
		});
		char_2_box.setBounds(66, 119, 97, 23);
		frame.getContentPane().add(char_2_box);
		
		JRadioButton char_3_box = new JRadioButton("");
		char_3_box.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblBattlingWith.setText("Battle With: " + game.getTeam().getHeroArray().get(2).getName());
				game.setCurrentHero(2);
			}
		});
		char_3_box.setBounds(66, 196, 97, 23);
		frame.getContentPane().add(char_3_box);
		
		try {
			if (game.getTeam().getHeroArray().get(0).getCurrentHealth() > 0) {
			lblHero.setText(game.getTeam().getHeroArray().get(0).getName());
			} else {
				lblHero.setVisible(false);
				char_1_box.setVisible(false);
			}
		} catch (Exception noName0) {
			lblHero.setVisible(false);
			char_1_box.setVisible(false);
		}
		try {
			if (game.getTeam().getHeroArray().get(1).getCurrentHealth() > 0) {
			lblHero_1.setText(game.getTeam().getHeroArray().get(1).getName());
			} else {
				lblHero_1.setVisible(false);
				char_2_box.setVisible(false);
			}
		} catch (Exception noName0) {
			lblHero_1.setVisible(false);
			char_2_box.setVisible(false);
		}
		try {
			if (game.getTeam().getHeroArray().get(2).getCurrentHealth() > 0) {
			lblHero_2.setText(game.getTeam().getHeroArray().get(2).getName());
			} else {
				lblHero_2.setVisible(false);
				char_3_box.setVisible(false);
			}
		} catch (Exception noName0) {
			lblHero_2.setVisible(false);
			char_3_box.setVisible(false);
		}
		
		ButtonGroup charsForBattle = new ButtonGroup();
		charsForBattle.add(char_1_box);
		charsForBattle.add(char_2_box);
		charsForBattle.add(char_3_box);
		
		
		JLabel lblNewLabel = new JLabel("CurrentAnswer");
		lblNewLabel.setBounds(795, 505, 73, 14);
		frame.getContentPane().add(lblNewLabel);
		lblNewLabel.setText(Integer.toString(vill));
		
		JButton btnConfirmYourGuess = new JButton("Confirm Your Guess");
		btnConfirmYourGuess.setBounds(274, 311, 311, 126);
		frame.getContentPane().add(btnConfirmYourGuess);
		frame.getContentPane().setLayout(null);
		btnConfirmYourGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(null, comboBox.getSelectedItem());
				int hero = Integer.parseInt((String) comboBox.getSelectedItem());
				numOfGuesses += 1;
				if (hero != vill && numOfGuesses < 2) {
					lblResult.setText(numberGuess.higherOrLowerGui(hero, vill));
				}  else if (hero == vill) {
					game.getCurrentVillian().oneDefeat();
//					numOfGuesses += 1;
					//something about getting it right in a num of guesses
					numOfGuesses = 0;
					JOptionPane.showMessageDialog(null, "You Have Bet The Villian " + game.getCurrentVillian().getLossCount() + " Times");
					vill = numberGuess.getVillianChoice();
					lblNewLabel.setText(Integer.toString(vill));
					if (game.getCurrentVillian().getLossCount() == 3) {
						JOptionPane.showMessageDialog(null, "You Destroyed The Villian!");
						citiesFinished += 1;
						frame.getContentPane().removeAll();
						frame.repaint();
//						game.setCurrentHero(citiesFinished);
						game.setCurrentVillian(citiesFinished);
						baseCampPanel();
					}
				} else {
					vill = numberGuess.getVillianChoice();
					lblNewLabel.setText(Integer.toString(vill));
					if (game.getTeam().getHeroArray().get(game.getCurrentHero()).getCurrentHealth() - 25 == 0) {
						game.getTeam().getHeroArray().get(game.getCurrentHero()).damageHealth(25);
						JOptionPane.showMessageDialog(null, "Your Hero Is Dead!");
						numOfGuesses = 0;
						if (game.getCurrentHero() == 0) {
							lblHero.setVisible(false);
							char_1_box.setVisible(false);
						} else if (game.getCurrentHero() == 1) {
							lblHero_1.setVisible(false);
							char_2_box.setVisible(false);
						} else {
							lblHero_2.setVisible(false);
							char_3_box.setVisible(false);
						}
						int stillAliveChar = 999;
						for (int i = 0; i < game.getTeam().getHeroArray().size(); i++) {
							if (game.getTeam().getHeroArray().get(i).getCurrentHealth() != 0) {
								stillAliveChar = i;
								game.setCurrentHero(i);
								break;
							}
						}
						if (stillAliveChar == 999) {
							frame.getContentPane().removeAll();
							frame.repaint();
							lossGamePanel();
						} else if (game.getCurrentHero() == 0) {
							lblBattlingWith.setText("Battle With: " + game.getTeam().getHeroArray().get(0).getName());
							char_1_box.setSelected(true);
						} else if (game.getCurrentHero() == 1) {
							lblBattlingWith.setText("Battle With: " + game.getTeam().getHeroArray().get(1).getName());
							char_2_box.setSelected(true);
						} else {
							lblBattlingWith.setText("Battle With: " + game.getTeam().getHeroArray().get(2).getName());
							char_3_box.setSelected(true);
						}
						System.out.println(game.getTeam().getHeroArray().size());
					} else {
						JOptionPane.showMessageDialog(null, "Your Hero Takes 25 Damage");
						numOfGuesses = 0;
						game.getTeam().getHeroArray().get(game.getCurrentHero()).damageHealth(25);//method works if there is only 1 person in the team, however when there are 2 or more then a person  gets removed and the array shrinks but doesnt go into the catch
					}
				}
			}
		});
		JButton btnViewStats_1 = new JButton("View Stats");
		btnViewStats_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, game.getTeam().toString());
			}
		});
		btnViewStats_1.setBounds(274, 460, 311, 126);
		frame.getContentPane().add(btnViewStats_1);
		
		
	}
	
	
	private void paperScissorsRockPanel() {

		//int numOfGuesses = 0;
		vill = numberGuess.getVillianChoice();
		frame.getContentPane().setLayout(null);
		
		JLabel lblBattlingWith = new JLabel("Battling With ");
		lblBattlingWith.setBounds(373, 24, 269, 14);
		lblBattlingWith.setText("Battle With: " + game.getTeam().getHeroArray().get(0).getName());
		frame.getContentPane().add(lblBattlingWith);
		
		JLabel lblResult = new JLabel("You Need To Roll The Dice First!");
		lblResult.setBounds(293, 137, 304, 55);
		frame.getContentPane().add(lblResult);
		
		
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
				lblBattlingWith.setText("Battle With: " + game.getTeam().getHeroArray().get(0).getName());
				game.setCurrentHero(0);
			}
		});
		char_1_box.setBounds(66, 45, 97, 23);
		char_1_box.setSelected(true);
		frame.getContentPane().add(char_1_box);
		
		JRadioButton char_2_box = new JRadioButton("");
		char_2_box.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblBattlingWith.setText("Battle With: " + game.getTeam().getHeroArray().get(1).getName());
				game.setCurrentHero(1);
			}
		});
		char_2_box.setBounds(66, 119, 97, 23);
		frame.getContentPane().add(char_2_box);
		
		JRadioButton char_3_box = new JRadioButton("");
		char_3_box.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblBattlingWith.setText("Battle With: " + game.getTeam().getHeroArray().get(2).getName());
				game.setCurrentHero(2);
			}
		});
		char_3_box.setBounds(66, 196, 97, 23);
		frame.getContentPane().add(char_3_box);
		
		try {
			if (game.getTeam().getHeroArray().get(0).getCurrentHealth() > 0) {
			lblHero.setText(game.getTeam().getHeroArray().get(0).getName());
			} else {
				lblHero.setVisible(false);
				char_1_box.setVisible(false);
			}
		} catch (Exception noName0) {
			lblHero.setVisible(false);
			char_1_box.setVisible(false);
		}
		try {
			if (game.getTeam().getHeroArray().get(1).getCurrentHealth() > 0) {
			lblHero_1.setText(game.getTeam().getHeroArray().get(1).getName());
			} else {
				lblHero_1.setVisible(false);
				char_2_box.setVisible(false);
			}
		} catch (Exception noName0) {
			lblHero_1.setVisible(false);
			char_2_box.setVisible(false);
		}
		try {
			if (game.getTeam().getHeroArray().get(2).getCurrentHealth() > 0) {
			lblHero_2.setText(game.getTeam().getHeroArray().get(2).getName());
			} else {
				lblHero_2.setVisible(false);
				char_3_box.setVisible(false);
			}
		} catch (Exception noName0) {
			lblHero_2.setVisible(false);
			char_3_box.setVisible(false);
		}
		
		ButtonGroup charsForBattle = new ButtonGroup();
		charsForBattle.add(char_1_box);
		charsForBattle.add(char_2_box);
		charsForBattle.add(char_3_box);
		frame.getContentPane().setLayout(null);
		JButton btnViewStats_1 = new JButton("View Stats");
		btnViewStats_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, game.getTeam().toString());
			}
		});
		btnViewStats_1.setBounds(304, 458, 311, 126);
		frame.getContentPane().add(btnViewStats_1);
		
		JButton btnPaper = new JButton("Paper");
		btnPaper.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPaper.setBounds(163, 305, 144, 119);
		frame.getContentPane().add(btnPaper);
		
		JButton btnScissors = new JButton("Scissors");
		btnScissors.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnScissors.setBounds(382, 305, 144, 119);
		frame.getContentPane().add(btnScissors);
		
		JButton btnScissors_1 = new JButton("Rock");
		btnScissors_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnScissors_1.setBounds(608, 305, 144, 119);
		frame.getContentPane().add(btnScissors_1);
		
		
	
		
	}
	
	private void lossGamePanel() {
		frame.getContentPane().setLayout(null);
	}
	
	private void teamInitializerPanel() {
		frame.getContentPane().setLayout(null);
		
		JLabel lblAssembleYourTeam = new JLabel("ASSEMBLE  YOUR  TEAM");
		lblAssembleYourTeam.setFont(new Font("Arvo", Font.BOLD, 24));
		lblAssembleYourTeam.setBounds(327, 12, 313, 31);
		frame.getContentPane().add(lblAssembleYourTeam);
		
		JButton btnHeroType1 = new JButton("");
		btnHeroType1.setBackground(Color.DARK_GRAY);
		btnHeroType1.setBounds(46, 142, 117, 126);
		frame.getContentPane().add(btnHeroType1);
		
		JButton btnHeroType2 = new JButton("");
		btnHeroType2.setBackground(Color.DARK_GRAY);
		btnHeroType2.setBounds(200, 142, 117, 126);
		frame.getContentPane().add(btnHeroType2);
		
		JButton btnHeroType3 = new JButton("");
		btnHeroType3.setBackground(Color.DARK_GRAY);
		btnHeroType3.setBounds(350, 142, 117, 126);
		frame.getContentPane().add(btnHeroType3);
		
		JButton btnHeroType4 = new JButton("");
		btnHeroType4.setBackground(Color.DARK_GRAY);
		btnHeroType4.setBounds(503, 142, 117, 126);
		frame.getContentPane().add(btnHeroType4);
		
		JButton btnHeroType5 = new JButton("");
		btnHeroType5.setBackground(Color.DARK_GRAY);
		btnHeroType5.setBounds(649, 142, 117, 126);
		frame.getContentPane().add(btnHeroType5);
		
		JButton btnHeroType6 = new JButton("");
		btnHeroType6.setBackground(Color.DARK_GRAY);
		btnHeroType6.setBounds(798, 142, 117, 126);
		frame.getContentPane().add(btnHeroType6);
		
		JLabel lblMerchant = new JLabel("MERCHANT");
		lblMerchant.setBounds(69, 280, 82, 15);
		frame.getContentPane().add(lblMerchant);
		
		JLabel lblTank = new JLabel("TANK");
		lblTank.setBounds(235, 280, 48, 15);
		frame.getContentPane().add(lblTank);
		
		JLabel lblCartographer = new JLabel("CARTOGRAPHER");
		lblCartographer.setBounds(360, 280, 127, 15);
		frame.getContentPane().add(lblCartographer);
		
		JLabel lblSupport = new JLabel("SUPPORT");
		lblSupport.setBounds(527, 280, 70, 15);
		frame.getContentPane().add(lblSupport);
		
		JLabel lblLuckyboii = new JLabel("LUCKYBOII");
		lblLuckyboii.setBounds(666, 280, 82, 15);
		frame.getContentPane().add(lblLuckyboii);
		
		JLabel lblAntihero = new JLabel("ANTI HERO");
		lblAntihero.setBounds(821, 280, 88, 15);
		frame.getContentPane().add(lblAntihero);
		
		JButton btnProceed = new JButton("PROCEED");
		btnProceed.setBounds(413, 579, 117, 25);
		frame.getContentPane().add(btnProceed);
		
		textField = new JTextField();
		textField.setBounds(57, 384, 176, 31);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNameHero = new JLabel("NAME YOUR");
		lblNameHero.setBounds(110, 351, 88, 25);
		frame.getContentPane().add(lblNameHero);
		
		JLabel lblNameClashMessage = new JLabel("INVALID: Another hero has taken this name.");
		lblNameClashMessage.setForeground(new Color(255, 0, 0));
		lblNameClashMessage.setFont(new Font("Dialog", Font.BOLD, 12));
		lblNameClashMessage.setBounds(251, 392, 313, 15);
		frame.getContentPane().add(lblNameClashMessage);
		lblNameClashMessage.setVisible(false);
		
		JLabel lblSelectHeroesFor = new JLabel("SELECT  AND  NAME  HERO  CLASSES  TO  ADD  TO  YOUR  TEAM");
		lblSelectHeroesFor.setFont(new Font("Arvo", Font.BOLD, 16));
		lblSelectHeroesFor.setBounds(211, 55, 526, 31);
		frame.getContentPane().add(lblSelectHeroesFor);
		
		JButton btnNewButton_4 = new JButton("Add to team");
		btnNewButton_4.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		btnNewButton_4.setBounds(57, 415, 176, 25);
		frame.getContentPane().add(btnNewButton_4);
		
		
	}
}
