package cityStuff;

import java.awt.EventQueue;
import cityStuff.*;
import games.*;
import teamStuff.Cartographer;
import teamStuff.EdgyScaryFiendLord;
import teamStuff.Hero;
import teamStuff.LuckyBoii;
import teamStuff.MerchantMan;
import teamStuff.PowerUp;
import teamStuff.Support;
import teamStuff.Tank;

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
<<<<<<< HEAD
=======
import java.util.Collections;
import java.util.Random;
>>>>>>> a79a103f2e034468aff2cee4abd2cd8421c4b75b
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import java.awt.Font;
import java.awt.Color;

public class gameEnvGui {
<<<<<<< HEAD
=======
	public static String selectedHealingItem;
	public static String selectedPowerUp;
>>>>>>> a79a103f2e034468aff2cee4abd2cd8421c4b75b
	public static int citiesFinished = 0;
	public static int numOfGuesses = 0;
	public static int numOfHeroes;
	public static int vill;
	public Hero heroToAdd;
	public gameEnvironmentGuiRunTime game = new gameEnvironmentGuiRunTime();
	private JFrame frame;
	private JTextField textField;
	private JTextField heroNameEntryBox;
	private JTextField teamNameEntryBox;
<<<<<<< HEAD
=======
	private Timer timer = new Timer();
//	private Timer timer = new Timer();
>>>>>>> a79a103f2e034468aff2cee4abd2cd8421c4b75b

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
<<<<<<< HEAD
=======
		cityAmmountPanel();//change to team set up later
//		teamInitializerPanel();
//		teamNamePanel();
>>>>>>> a79a103f2e034468aff2cee4abd2cd8421c4b75b
//		cityAmmountPanel();//change to team set up later
//		baseCampPanel();
//		villiansLairPanel();
//		battleSelectionPanel();
//		diceRollPanel();
//		numberGuessPanel();
//		paperScissorsRockPanel();
//		shopPanel();
//		hospitalPanel();
//		teamInitializerPanel();
//		shopPanel();
<<<<<<< HEAD
		teamNamePanel();
=======
//		teamNamePanel();
//		hospitalPanel();
//		powerUpDenPanel();

>>>>>>> a79a103f2e034468aff2cee4abd2cd8421c4b75b

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
	
	
	
	
	private void teamNamePanel() {
		JLabel lblNameYourTeam = new JLabel("NAME   YOUR   TEAM   OF   HEROES");
		lblNameYourTeam.setFont(new Font("Arvo", Font.BOLD, 40));
		lblNameYourTeam.setHorizontalAlignment(SwingConstants.CENTER);
		lblNameYourTeam.setBounds(12, 47, 914, 52);
		frame.getContentPane().add(lblNameYourTeam);
		
		teamNameEntryBox = new JTextField();
		teamNameEntryBox.setFont(new Font("Arvo", Font.BOLD, 70));
		teamNameEntryBox.setHorizontalAlignment(SwingConstants.CENTER);
		teamNameEntryBox.setBounds(118, 135, 713, 107);
		frame.getContentPane().add(teamNameEntryBox);
		teamNameEntryBox.setColumns(10);
		
		JLabel lblTeamNameError = new JLabel("INVALID ENTRY: The team name must be between 2 and 10 characters in length.");
		lblTeamNameError.setFont(new Font("Dialog", Font.BOLD, 16));
		lblTeamNameError.setForeground(new Color(255, 0, 0));
		lblTeamNameError.setHorizontalAlignment(SwingConstants.CENTER);
		lblTeamNameError.setBounds(12, 254, 914, 52);
		frame.getContentPane().add(lblTeamNameError);
		lblTeamNameError.setVisible(false);
		
		JButton btnProceedToCamp = new JButton("PROCEED  TO  CAMP");
		btnProceedToCamp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				game.getTeam().setBarterSkillSum();
				game.getTeam().setDeterrenceSum();
				game.getTeam().setFameSum();
				frame.getContentPane().removeAll();
				frame.repaint();
				baseCampPanel();
			}
		});
		btnProceedToCamp.setFont(new Font("Dialog", Font.BOLD, 22));
		btnProceedToCamp.setBounds(287, 503, 339, 88);
		frame.getContentPane().add(btnProceedToCamp);
		btnProceedToCamp.setVisible(false);
		
		JLabel lblBeginQuest = new JLabel("");
		lblBeginQuest.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblBeginQuest.setHorizontalAlignment(SwingConstants.CENTER);
		lblBeginQuest.setBounds(12, 446, 914, 45);
		frame.getContentPane().add(lblBeginQuest);
		
		JButton btnSubmitTeamName = new JButton("Confirm Name");
		btnSubmitTeamName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(teamNameEntryBox.getText().length() < 2 || teamNameEntryBox.getText().length() > 10) {
					lblTeamNameError.setVisible(true);
<<<<<<< HEAD
=======
				}
				else {
					game.getTeam().nameTeam(teamNameEntryBox.getText());
					lblTeamNameError.setVisible(false);
					btnProceedToCamp.setVisible(true);
					lblBeginQuest.setText("Go forth, " + game.getTeam().getName() + ", and vanquish darstardly villains who've many cities under their rule!");
>>>>>>> a79a103f2e034468aff2cee4abd2cd8421c4b75b
				}
			}
		});
		btnSubmitTeamName.setBounds(371, 318, 177, 25);
		frame.getContentPane().add(btnSubmitTeamName);
<<<<<<< HEAD
		
		
		
=======
>>>>>>> a79a103f2e034468aff2cee4abd2cd8421c4b75b
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
				game.makeAllUnfound();
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
//				btnNorth.setText(game.getMapPlace(0));
				btnNorth.setText(game.getCurrentMap(citiesFinished).get(0));
				game.setFoundPlaceTrue(0);
				frame.getContentPane().removeAll();
				frame.repaint();
				switch(btnNorth.getText()) {
					case "Lair":
						villiansLairPanel();
						break;
					case "Shop":
						shopPanel();
						break;
					case "Power Up Den":
						powerUpDenPanel();
						break;
					case "Hospital":
						break;
				}
			}
		});
		btnNorth.setBounds(405, 43, 117, 25);
		frame.getContentPane().add(btnNorth);
		btnNorth.setText(game.getMapPlace(0,citiesFinished));
//		btnNorth.setText("???");
		JButton btnEast = new JButton("East");
		btnEast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnEast.setText(game.getCurrentMap(citiesFinished).get(1));
				game.setFoundPlaceTrue(1);
				frame.getContentPane().removeAll();
				frame.repaint();
				switch(btnEast.getText()) {
					case "Lair":
						villiansLairPanel();
						break;
					case "Shop":
						shopPanel();
						break;
					case "Power Up Den":
						powerUpDenPanel();
						break;
					case "Hospital":
						break;
				}
			}
		});
		btnEast.setBounds(737, 212, 117, 25);
		frame.getContentPane().add(btnEast);
		btnEast.setText(game.getMapPlace(1,citiesFinished));
//		btnEast.setText(game.getCurrentMap(citiesFinished).get(1));
		JButton btnSouth = new JButton("South");
		btnSouth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSouth.setText(game.getCurrentMap(citiesFinished).get(2));
				game.setFoundPlaceTrue(2);
				frame.getContentPane().removeAll();
				frame.repaint();
				switch(btnSouth.getText()) {
					case "Lair":
						villiansLairPanel();
						break;
					case "Shop":
						shopPanel();
						break;
					case "Power Up Den":
						powerUpDenPanel();
						break;
					case "Hospital":
						break;
				}
//				if (btnSouth.getText() == "Lair") {
//					villiansLairPanel();
//				} 
			}
		});
		btnSouth.setBounds(405, 385, 117, 25);
		frame.getContentPane().add(btnSouth);
		btnSouth.setText(game.getMapPlace(2,citiesFinished));
//		btnSouth.setText(game.getCurrentMap(citiesFinished).get(2));
		JButton btnWest = new JButton("West");
		btnWest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnWest.setText(game.getCurrentMap(citiesFinished).get(3));
				game.setFoundPlaceTrue(3);
				frame.getContentPane().removeAll();
				frame.repaint();
				switch(btnWest.getText()) {
					case "Lair":
						villiansLairPanel();
						break;
					case "Shop":
						shopPanel();
						break;
					case "Power Up Den":
						powerUpDenPanel();
						break;
					case "Hospital":
						break;
				}
			}
		});
		btnWest.setBounds(74, 212, 117, 25);
		frame.getContentPane().add(btnWest);
		btnWest.setText(game.getMapPlace(3,citiesFinished));
//		btnWest.setText(game.getCurrentMap(citiesFinished).get(3));
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
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3"}));
		comboBox_1.setBounds(419, 249, 61, 24);
		frame.getContentPane().add(comboBox_1);
		
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
				String k = (String)comboBox_1.getSelectedItem();
				try {
					numOfHeroes = Integer.parseInt(k);
				} catch (Exception lala) {
					numOfHeroes = 1;
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
				game.setCurrentShop(0);
				//JOptionPane.showMessageDialog(null, game.num_of_cities);
				frame.getContentPane().removeAll();
				frame.repaint();
//				baseCampPanel();
				teamInitializerPanel();//for vinnie test
			}
		});
		btnNewButton.setBounds(363, 321, 171, 86);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblHowManyHeroes = new JLabel("How Many Heroes Would You LIke ");
		lblHowManyHeroes.setBounds(310, 197, 412, 15);
		frame.getContentPane().add(lblHowManyHeroes);
		
		
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
				if (game.getCurrentVillian().hasFavGame() == true) {
					JOptionPane.showMessageDialog(null, "THE VILLIAN HAS A FAVOURITE GAME\nYOU HAVE NO CHOICE\nMWAHAHAHA");
					Random gameNum = new Random();
					int game;
					game = gameNum.nextInt(2);
					switch(game) {
					case 0:
						paperScissorsRockPanel();
						break;
					case 1:
						numberGuessPanel();
						break;
					case 2:
						diceRollPanel();
						break;
					} 
				} else {
					battleSelectionPanel();
				}
				
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
	
<<<<<<< HEAD
=======
	private void hospitalPanel() {
		
		JLabel lblApplyTo = new JLabel("Apply To:");
		lblApplyTo.setBounds(421, 231, 70, 15);
		frame.getContentPane().add(lblApplyTo);
		
		
		JLabel lblHero = new JLabel("hero1");
		lblHero.setBounds(245, 264, 46, 14);
		frame.getContentPane().add(lblHero);
		
		
		
		JLabel lblHero_1 = new JLabel("hero2");
		lblHero_1.setBounds(441, 264, 46, 14);
		frame.getContentPane().add(lblHero_1);
		
		JLabel lblHero_2 = new JLabel("hero3");
		lblHero_2.setBounds(627, 264, 46, 14);
		frame.getContentPane().add(lblHero_2);
		
		
		JRadioButton char_1_box = new JRadioButton("");
		char_1_box.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblApplyTo.setText("Apply To: " + game.getTeam().getHeroArray().get(0).getName());
				game.setCurrentHero(0);
			}
		});
		char_1_box.setBounds(255, 286, 97, 23);
		char_1_box.setSelected(true);
		frame.getContentPane().add(char_1_box);
		
		JRadioButton char_2_box = new JRadioButton("");
		char_2_box.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblApplyTo.setText("Apply To: " + game.getTeam().getHeroArray().get(1).getName());
				game.setCurrentHero(1);
			}
		});
		char_2_box.setBounds(451, 286, 97, 23);
		frame.getContentPane().add(char_2_box);
		
		JRadioButton char_3_box = new JRadioButton("");
		char_3_box.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblApplyTo.setText("Apply To: " + game.getTeam().getHeroArray().get(2).getName());
				game.setCurrentHero(2);
			}
		});
		char_3_box.setBounds(637, 286, 97, 23);
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
		
		
		
		JLabel lblAvaiableHealingItems = new JLabel("Avaiable Healing Items");
		lblAvaiableHealingItems.setBounds(369, 22, 177, 15);
		frame.getContentPane().add(lblAvaiableHealingItems);
		
		JButton btnNewButton_4 = new JButton("Restore Health I");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedHealingItem = btnNewButton_4.getText();
			}
		});
		btnNewButton_4.setBounds(135, 55, 189, 81);
		frame.getContentPane().add(btnNewButton_4);
		
		selectedHealingItem = btnNewButton_4.getText();
		
		JButton btnRestoreHealthIi_1 = new JButton("Restore Health II");
		btnRestoreHealthIi_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedHealingItem = btnRestoreHealthIi_1.getText();
			}
		});
		btnRestoreHealthIi_1.setBounds(357, 55, 189, 81);
		frame.getContentPane().add(btnRestoreHealthIi_1);
		
		JButton btnRestoreHealthIi = new JButton("Restore Health III");
		btnRestoreHealthIi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedHealingItem = btnRestoreHealthIi.getText();
			}
		});
		btnRestoreHealthIi.setBounds(571, 55, 189, 81);
		frame.getContentPane().add(btnRestoreHealthIi);
		
		JLabel HealthIStock = new JLabel("New label");
		HealthIStock.setBounds(196, 148, 70, 15);
		frame.getContentPane().add(HealthIStock);
		HealthIStock.setText(String.valueOf(Collections.frequency(game.getTeam().getHealingItems(), game.getCurrentShop().getHealingItems().get(0))));
		
		
		JLabel HealthIIStock = new JLabel("New label");
		HealthIIStock.setBounds(421, 148, 70, 15);
		frame.getContentPane().add(HealthIIStock);
		HealthIIStock.setText(String.valueOf(Collections.frequency(game.getTeam().getHealingItems(), game.getCurrentShop().getHealingItems().get(1))));
		
		JLabel HealthIIIStock = new JLabel("New label");
		HealthIIIStock.setBounds(645, 148, 70, 15);
		frame.getContentPane().add(HealthIIIStock);
		HealthIIIStock.setText(String.valueOf(Collections.frequency(game.getTeam().getHealingItems(), game.getCurrentShop().getHealingItems().get(2))));
		
	
		
		
		
		JButton btnNewButton_5 = new JButton("Apply To Hero");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean applyIt = false;
				int count = 0;
				for (HealingItem item : game.getTeam().getHealingItems()) {
					if (item.getHealingItemName().equals(selectedHealingItem)) {//should add to check if the num underneath is actually in the array or use a try catch
						applyIt = true;
						break;
					}
					count++;
				}
				if (applyIt == true) {
					game.getTeam().getHeroArray().get(game.getCurrentHero()).useHealingItem(game.getTeam().getHealingItems().get(count));
					frame.getContentPane().removeAll();
					frame.repaint();
					hospitalPanel();
					//timer.setVisible(true);
//					while(game.getTeam().getHealingItems().get(count).getTimeRemaining() > 0) {
////						JOptionPane.showMessageDialog(null, game.getTeam().getHealingItems().get(count).getTimeRemaining());
//					}
//					timer.setVisible(true);				
					while(game.getTeam().getHealingItems().get(count).getTimeRemaining() > 110) {
//						JOptionPane.showMessageDialog(null, game.getTeam().getHealingItems().get(count).getTimeRemaining());
					}
					JOptionPane.showMessageDialog(null, "got out of loop");
//					timer.setVisible(false);
					
				} else {
					JOptionPane.showMessageDialog(null, "YOU DONT HAVE THIS ITEM!");
				}
			}
		});
		btnNewButton_5.setBounds(194, 380, 215, 100);
		frame.getContentPane().add(btnNewButton_5);
		
		JButton btnExit_1 = new JButton("Exit");
		btnExit_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				frame.repaint();
				baseCampPanel();
			}
		});
		btnExit_1.setBounds(518, 380, 215, 100);
		frame.getContentPane().add(btnExit_1);
		
	}
>>>>>>> a79a103f2e034468aff2cee4abd2cd8421c4b75b
	
	private void shopPanel() {
		JLabel lblTeamsCurrentInventory = new JLabel("Teams Current Inventory");
		lblTeamsCurrentInventory.setBounds(372, 12, 238, 15);
		frame.getContentPane().add(lblTeamsCurrentInventory);
		
		JLabel itemName = new JLabel("Selected Item Name");
		itemName.setBounds(46, 449, 135, 15);
		frame.getContentPane().add(itemName);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(527, 415, 178, 154);
		frame.getContentPane().add(btnExit);
		
		JLabel lblAvailableHealingItems = new JLabel("Available Healing Items");
		lblAvailableHealingItems.setBounds(372, 83, 238, 15);
		frame.getContentPane().add(lblAvailableHealingItems);
		
		JLabel lblAvailablePowerUps = new JLabel("Available Power Ups");
		lblAvailablePowerUps.setBounds(372, 223, 238, 15);
		frame.getContentPane().add(lblAvailablePowerUps);
		
		JButton health1 = new JButton("r1");
		health1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				itemName.setText(game.getCurrentShop().getHealingItems().get(0).getHealingItemName());
			}
		});
		health1.setBounds(192, 104, 104, 70);
		frame.getContentPane().add(health1);
		health1.setText(game.getCurrentShop().getHealingItems().get(0).getHealingItemName());
		
		JButton health2 = new JButton("r2");
		health2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				itemName.setText(game.getCurrentShop().getHealingItems().get(1).getHealingItemName());
			}
		});
		health2.setBounds(406, 104, 104, 70);
		frame.getContentPane().add(health2);
		health2.setText(game.getCurrentShop().getHealingItems().get(1).getHealingItemName());
		
		JButton health3 = new JButton("r3");
		health3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				itemName.setText(game.getCurrentShop().getHealingItems().get(2).getHealingItemName());
			}
		});
		health3.setBounds(640, 104, 104, 70);
		frame.getContentPane().add(health3);
		health3.setText(game.getCurrentShop().getHealingItems().get(2).getHealingItemName());
		
		JButton powerUp1 = new JButton("p1");
		powerUp1.setBounds(66, 263, 104, 70);
		frame.getContentPane().add(powerUp1);
		
		JButton powerUp2 = new JButton("p2");
		powerUp2.setBounds(202, 263, 104, 70);
		frame.getContentPane().add(powerUp2);
		
		JButton powerUp3 = new JButton("p3");
		powerUp3.setBounds(337, 263, 104, 70);
		frame.getContentPane().add(powerUp3);
		
		JButton powerUp4 = new JButton("p4");
		powerUp4.setBounds(469, 263, 104, 70);
		frame.getContentPane().add(powerUp4);
		
		JButton powerUp5 = new JButton("p5");
		powerUp5.setBounds(601, 263, 104, 70);
		frame.getContentPane().add(powerUp5);
		
		JButton powerUp6 = new JButton("p6");
		powerUp6.setBounds(731, 263, 104, 70);
		frame.getContentPane().add(powerUp6);
		
		ButtonGroup itemsToChoose = new ButtonGroup();
		itemsToChoose.add(health1);
		itemsToChoose.add(health2);
		itemsToChoose.add(health3);
		itemsToChoose.add(powerUp1);
		itemsToChoose.add(powerUp2);
		itemsToChoose.add(powerUp3);
		itemsToChoose.add(powerUp4);
		itemsToChoose.add(powerUp5);
		itemsToChoose.add(powerUp6);
		
		
		
		JLabel lblRstock = new JLabel("r1Stock");
		lblRstock.setBounds(215, 186, 70, 15);
		frame.getContentPane().add(lblRstock);
		lblRstock.setText(String.valueOf(game.getCurrentShop().getHealingStockLevel()[0]));
		
		JLabel label = new JLabel("r1Stock");
		label.setBounds(427, 186, 70, 15);
		frame.getContentPane().add(label);
		label.setText(String.valueOf(game.getCurrentShop().getHealingStockLevel()[1]));
		
		JLabel label_1 = new JLabel("r1Stock");
		label_1.setBounds(674, 186, 70, 15);
		frame.getContentPane().add(label_1);
		label_1.setText(String.valueOf(game.getCurrentShop().getHealingStockLevel()[2]));
		
		
		JButton purchaseButton = new JButton("Purchase Selected Item");
		purchaseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch(itemName.getText()) {
				case "Restore Health I":
					if (game.getCurrentShop().getHealingStockLevel()[0] > 0) {
						game.getTeam().addHealingItem(game.getCurrentShop().getHealingItems().get(0));
						game.getCurrentShop().getHealingStockLevel()[0] -= 1;
					} else {
						JOptionPane.showMessageDialog(null, "THIS ITEM IS OUT OF STOCK");
					}
					break;
				case "Restore Health II":
					break;
				case "Restore Health III":
					break;
				case "Iron Flesh I":
					break;
				case "Iron Flesh II":
<<<<<<< HEAD
					break;
				case "Iron Flesh III":
					break;
				case "Silver Tongue I":
					break;
				case "Silver Tongue II":
					break;
				case "Silver Tongue III":
=======
					if (game.getCurrentShop().getPowerUpStockLevel()[1] > 0) {
						game.getTeam().addPowerUp(game.getCurrentShop().getPowerUpItems().get(1));
						game.getCurrentShop().getPowerUpStockLevel()[1] -= 1;
						PUP2.setText(String.valueOf(game.getCurrentShop().getPowerUpStockLevel()[1]));
					} else {
						JOptionPane.showMessageDialog(null, "THIS ITEM IS OUT OF STOCK");
					}
					break;
				case "Iron Flesh III":
					if (game.getCurrentShop().getPowerUpStockLevel()[2] > 0) {
						game.getTeam().addPowerUp(game.getCurrentShop().getPowerUpItems().get(2));
						game.getCurrentShop().getPowerUpStockLevel()[2] -= 1;
						PUP3.setText(String.valueOf(game.getCurrentShop().getPowerUpStockLevel()[2]));
					} else {
						JOptionPane.showMessageDialog(null, "THIS ITEM IS OUT OF STOCK");
					}
					break;
				case "Augment Vitality I":
					if (game.getCurrentShop().getPowerUpStockLevel()[3] > 0) {
						game.getTeam().addPowerUp(game.getCurrentShop().getPowerUpItems().get(3));
						game.getCurrentShop().getPowerUpStockLevel()[3] -= 1;
						PUP4.setText(String.valueOf(game.getCurrentShop().getPowerUpStockLevel()[3]));
					} else {
						JOptionPane.showMessageDialog(null, "THIS ITEM IS OUT OF STOCK");
					}
					break;
				case "Augment Vitality II":
					if (game.getCurrentShop().getPowerUpStockLevel()[4] > 0) {
						game.getTeam().addPowerUp(game.getCurrentShop().getPowerUpItems().get(4));
						game.getCurrentShop().getPowerUpStockLevel()[4] -= 1;
						PUP5.setText(String.valueOf(game.getCurrentShop().getPowerUpStockLevel()[4]));
					} else {
						JOptionPane.showMessageDialog(null, "THIS ITEM IS OUT OF STOCK");
					}
					break;
				case "Augment Vitality III":
					if (game.getCurrentShop().getPowerUpStockLevel()[5] > 0) {
						game.getTeam().addPowerUp(game.getCurrentShop().getPowerUpItems().get(5));
						game.getCurrentShop().getPowerUpStockLevel()[5] -= 1;
						PUP6.setText(String.valueOf(game.getCurrentShop().getPowerUpStockLevel()[5]));
					} else {
						JOptionPane.showMessageDialog(null, "THIS ITEM IS OUT OF STOCK");
					}
					break;
				case "Silver Tongue I":
					if (game.getCurrentShop().getPowerUpStockLevel()[6] > 0) {
						game.getTeam().addPowerUp(game.getCurrentShop().getPowerUpItems().get(6));
						game.getCurrentShop().getPowerUpStockLevel()[6] -= 1;
						PUP7.setText(String.valueOf(game.getCurrentShop().getPowerUpStockLevel()[6]));
					} else {
						JOptionPane.showMessageDialog(null, "THIS ITEM IS OUT OF STOCK");
					}
					break;
				case "Silver Tongue II":
					if (game.getCurrentShop().getPowerUpStockLevel()[7] > 0) {
						game.getTeam().addPowerUp(game.getCurrentShop().getPowerUpItems().get(7));
						game.getCurrentShop().getPowerUpStockLevel()[7] -= 1;
						PUP8.setText(String.valueOf(game.getCurrentShop().getPowerUpStockLevel()[7]));
					} else {
						JOptionPane.showMessageDialog(null, "THIS ITEM IS OUT OF STOCK");
					}
					break;
				case "Silver Tongue III":
					if (game.getCurrentShop().getPowerUpStockLevel()[8] > 0) {
						game.getTeam().addPowerUp(game.getCurrentShop().getPowerUpItems().get(8));
						game.getCurrentShop().getPowerUpStockLevel()[8] -= 1;
						PUP9.setText(String.valueOf(game.getCurrentShop().getPowerUpStockLevel()[8]));
					} else {
						JOptionPane.showMessageDialog(null, "THIS ITEM IS OUT OF STOCK");
					}
>>>>>>> a79a103f2e034468aff2cee4abd2cd8421c4b75b
					break;
				}
			}
		});
		purchaseButton.setBounds(229, 415, 178, 154);
		frame.getContentPane().add(purchaseButton);
		
		JLabel lblSelectedItem = new JLabel("Selected Item");
		lblSelectedItem.setBounds(54, 403, 104, 15);
		frame.getContentPane().add(lblSelectedItem);
		

		
	}
	
	private void paperScissorsRockPanel() {
//		ArrayList<String> villianOptions = new ArrayList<String>();
//		villianOptions.add("Paper");
//		villianOptions.add("Scissors");
//		villianOptions.add("Rock");
		paperScissorsRock paperGame = new paperScissorsRock();
		//int numOfGuesses = 0;
//		vill = numberGuess.getVillianChoice();
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
		
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Paper", "Scissors", "Rock"}));
		comboBox.setBounds(383, 278, 105, 22);
		frame.getContentPane().add(comboBox);
		
		JButton btnConfirmYourGuess = new JButton("Confirm Your Guess");
		btnConfirmYourGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String outcome = comboBox.getSelectedItem() + paperGame.getVillianChoice();
				outcome = paperGame.getOutCome(outcome);
				JOptionPane.showMessageDialog(null, outcome);
				switch(outcome) {
				case "You Have Won":
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
					break;
				case "The Villian Has Won":
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
					break;
				case "It Is A Draw, Next Round!":
					break;
				}
			}
		});
		btnConfirmYourGuess.setBounds(304, 312, 311, 126);
		frame.getContentPane().add(btnConfirmYourGuess);
		frame.getContentPane().setLayout(null);
		
		/*JButton btnPaper = new JButton("Paper");
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
		*/
		
	
		
	}
	
	private void lossGamePanel() {
		frame.getContentPane().setLayout(null);
	}
	
	
	private void powerUpDenPanel() {
		JLabel lblApplyTo = new JLabel("Apply To:");
		lblApplyTo.setBounds(422, 343, 70, 15);
		frame.getContentPane().add(lblApplyTo);
		
		
		JLabel lblHero = new JLabel("hero1");
		lblHero.setBounds(246, 376, 46, 14);
		frame.getContentPane().add(lblHero);
		
		JLabel lblHero_1 = new JLabel("hero2");
		lblHero_1.setBounds(442, 376, 46, 14);
		frame.getContentPane().add(lblHero_1);
		
		JLabel lblHero_2 = new JLabel("hero3");
		lblHero_2.setBounds(628, 376, 46, 14);
		frame.getContentPane().add(lblHero_2);
		
		
		JRadioButton char_1_box = new JRadioButton("");
		char_1_box.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblApplyTo.setText("Apply To: " + game.getTeam().getHeroArray().get(0).getName());
				game.setCurrentHero(0);
			}
		});
		char_1_box.setBounds(256, 398, 97, 23);
		char_1_box.setSelected(true);
		frame.getContentPane().add(char_1_box);
		
		JRadioButton char_2_box = new JRadioButton("");
		char_2_box.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblApplyTo.setText("Apply To: " + game.getTeam().getHeroArray().get(1).getName());
				game.setCurrentHero(1);
			}
		});
		char_2_box.setBounds(452, 398, 97, 23);
		frame.getContentPane().add(char_2_box);
		
		JRadioButton char_3_box = new JRadioButton("");
		char_3_box.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblApplyTo.setText("Apply To: " + game.getTeam().getHeroArray().get(2).getName());
				game.setCurrentHero(2);
			}
		});
		char_3_box.setBounds(638, 398, 97, 23);
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
		
		
		
		JLabel lblAvaiableHealingItems = new JLabel("Avaiable Power Up Items");
		lblAvaiableHealingItems.setBounds(369, 22, 177, 15);
		frame.getContentPane().add(lblAvaiableHealingItems);
		
		JButton btnPUP1 = new JButton("Iron Flesh I");
		btnPUP1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedPowerUp = btnPUP1.getText();
			}
		});
		btnPUP1.setBounds(135, 55, 189, 58);
		frame.getContentPane().add(btnPUP1);
		
		selectedPowerUp = btnPUP1.getText();
		
		JButton btnPUP2 = new JButton("Iron Flesh II");
		btnPUP2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedPowerUp = btnPUP2.getText();
			}
		});
		btnPUP2.setBounds(357, 55, 189, 58);
		frame.getContentPane().add(btnPUP2);
		
		JButton btnPUP3 = new JButton("Iron Flesh III");
		btnPUP3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedPowerUp = btnPUP3.getText();
			}
		});
		btnPUP3.setBounds(571, 55, 189, 58);
		frame.getContentPane().add(btnPUP3);
		
		JButton btnPUP4 = new JButton("Augment Vitality I");
		btnPUP4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedPowerUp = btnPUP4.getText();
			}
		});
		btnPUP4.setBounds(135, 152, 189, 58);
		frame.getContentPane().add(btnPUP4);
		
		
		JButton btnPUP5 = new JButton("Augment Vitality II");
		btnPUP5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedPowerUp = btnPUP5.getText();
			}
		});
		btnPUP5.setBounds(357, 152, 189, 58);
		frame.getContentPane().add(btnPUP5);
		
		JButton btnPUP6 = new JButton("Augment Vitality III");
		btnPUP6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedPowerUp = btnPUP6.getText();
			}
		});
		btnPUP6.setBounds(571, 152, 189, 58);
		frame.getContentPane().add(btnPUP6);
		
		JButton btnPUP7 = new JButton("Silver Tongue I");
		btnPUP7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedPowerUp = btnPUP7.getText();
			}
		});
		btnPUP7.setBounds(135, 249, 189, 58);
		frame.getContentPane().add(btnPUP7);
		
		JButton btnPUP8 = new JButton("Silver Tongue II");
		btnPUP8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedPowerUp = btnPUP8.getText();
			}
		});
		btnPUP8.setBounds(357, 249, 189, 58);
		frame.getContentPane().add(btnPUP8);
		
		JButton btnPUP9 = new JButton("Silver Tongue III");
		btnPUP9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedPowerUp = btnPUP9.getText();
			}
		});
		btnPUP9.setBounds(571, 249, 189, 58);
		frame.getContentPane().add(btnPUP9);
		
		
		
		JLabel stockPUP1 = new JLabel("New label");
		stockPUP1.setBounds(196, 125, 70, 15);
		frame.getContentPane().add(stockPUP1);
		stockPUP1.setText(String.valueOf(Collections.frequency(game.getTeam().getPowerUps(), game.getCurrentShop().getPowerUpItems().get(0))));
		
		
		JLabel stockPUP2 = new JLabel("New label");
		stockPUP2.setBounds(423, 125, 70, 15);
		frame.getContentPane().add(stockPUP2);
		stockPUP2.setText(String.valueOf(Collections.frequency(game.getTeam().getPowerUps(), game.getCurrentShop().getPowerUpItems().get(1))));
		
		JLabel stockPUP3 = new JLabel("New label");
		stockPUP3.setBounds(645, 125, 70, 15);
		frame.getContentPane().add(stockPUP3);
		stockPUP3.setText(String.valueOf(Collections.frequency(game.getTeam().getPowerUps(), game.getCurrentShop().getPowerUpItems().get(2))));
		
		JLabel stockPUP4 = new JLabel("0");
		stockPUP4.setBounds(196, 222, 70, 15);
		frame.getContentPane().add(stockPUP4);
		stockPUP4.setText(String.valueOf(Collections.frequency(game.getTeam().getPowerUps(), game.getCurrentShop().getPowerUpItems().get(3))));
		
		JLabel stockPUP5 = new JLabel("0");
		stockPUP5.setBounds(421, 222, 70, 15);
		frame.getContentPane().add(stockPUP5);
		stockPUP5.setText(String.valueOf(Collections.frequency(game.getTeam().getPowerUps(), game.getCurrentShop().getPowerUpItems().get(4))));
		
		JLabel stockPUP6 = new JLabel("0");
		stockPUP6.setBounds(645, 222, 70, 15);
		frame.getContentPane().add(stockPUP6);
		stockPUP6.setText(String.valueOf(Collections.frequency(game.getTeam().getPowerUps(), game.getCurrentShop().getPowerUpItems().get(5))));
		
		JLabel stockPUP7 = new JLabel("0");
		stockPUP7.setBounds(196, 319, 70, 15);
		frame.getContentPane().add(stockPUP7);
		stockPUP7.setText(String.valueOf(Collections.frequency(game.getTeam().getPowerUps(), game.getCurrentShop().getPowerUpItems().get(6))));
		
		JLabel stockPUP8 = new JLabel("0");
		stockPUP8.setBounds(421, 319, 70, 15);
		frame.getContentPane().add(stockPUP8);
		stockPUP8.setText(String.valueOf(Collections.frequency(game.getTeam().getPowerUps(), game.getCurrentShop().getPowerUpItems().get(7))));
		
		JLabel stockPUP9 = new JLabel("0");
		stockPUP9.setBounds(645, 319, 70, 15);
		frame.getContentPane().add(stockPUP9);
		stockPUP9.setText(String.valueOf(Collections.frequency(game.getTeam().getPowerUps(), game.getCurrentShop().getPowerUpItems().get(8))));
		
		JButton btnNewButton_5 = new JButton("Apply To Hero");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean applyIt = false;
				int count = 0;
				for (PowerUp item : game.getTeam().getPowerUps()) {
					if (item.getPowerUpName().equals(selectedPowerUp)) {//should add to check if the num underneath is actually in the array or use a try catch
						applyIt = true;
						break;
					}
					count++;
				}
				if (applyIt == true) {
					game.getTeam().getHeroArray().get(game.getCurrentHero()).usePowerUp(game.getTeam().getPowerUps().get(count));//.useHealingItem(game.getTeam().getHealingItems().get(count));
					frame.getContentPane().removeAll();
					frame.repaint();
					powerUpDenPanel();
//					timer.setVisible(true);				
//					while(game.getTeam().getHealingItems().get(count).getTimeRemaining() > 110) {
//						JOptionPane.showMessageDialog(null, game.getTeam().getHealingItems().get(count).getTimeRemaining());
//					}
//					JOptionPane.showMessageDialog(null, "got out of loop");
//					timer.setVisible(false);
					
				} else {
					JOptionPane.showMessageDialog(null, "YOU DONT HAVE THIS ITEM!");
				}
			}
		});
		btnNewButton_5.setBounds(196, 452, 215, 100);
		frame.getContentPane().add(btnNewButton_5);
		
		JButton btnExit_1 = new JButton("Exit");
		btnExit_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				frame.repaint();
				baseCampPanel();
			}
		});
		btnExit_1.setBounds(520, 452, 215, 100);
		frame.getContentPane().add(btnExit_1);
		
		
		
		
		
		
	}
	
	private void teamInitializerPanel() {
		frame.getContentPane().setLayout(null);
		
		
		JLabel lblNameHero = new JLabel("");
		lblNameHero.setHorizontalAlignment(SwingConstants.CENTER);
		lblNameHero.setBounds(10, 425, 914, 25);
		frame.getContentPane().add(lblNameHero);
		
		
		heroNameEntryBox = new JTextField(); 
		heroNameEntryBox.setBounds(359, 462, 209, 31);
		frame.getContentPane().add(heroNameEntryBox);
		heroNameEntryBox.setColumns(10);
		heroNameEntryBox.setEnabled(false);
		
		
		JLabel lblNameClashMessage = new JLabel("INVALID ENTRY: Another hero has taken this name; please enter a different name.");
		lblNameClashMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblNameClashMessage.setForeground(new Color(255, 0, 0));
		lblNameClashMessage.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNameClashMessage.setBounds(10, 357, 914, 25);
		frame.getContentPane().add(lblNameClashMessage);
		lblNameClashMessage.setVisible(false);
		
		
		
		JButton btnAddToTeam = new JButton("Add to team");
		btnAddToTeam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(game.getHeroList().size() >= 1) {
					boolean nameChecked = false;
					String name = heroNameEntryBox.getText();
					
					for (int i = 0; i < game.getHeroList().size(); i++) {
						if (name.equals(game.getHeroList().get(i).getName())) {
							lblNameClashMessage.setVisible(true);
							nameChecked = true;
						}
					}
					
					if (nameChecked == false) {
						heroToAdd.setHeroName(heroNameEntryBox.getText());
						game.getHeroList().add(heroToAdd);
					
						// after it has added the char
						if (numOfHeroes == game.getHeroList().size()) {
							frame.getContentPane().removeAll();
							frame.repaint();
							teamNamePanel();
						} 
						else {
							frame.getContentPane().removeAll();
							frame.repaint();
							teamInitializerPanel();
						}
					}
//					
				} 
				else {
					heroToAdd.setHeroName(heroNameEntryBox.getText());
					game.getHeroList().add(heroToAdd);
				
					// after it has added the char
					if (numOfHeroes == game.getHeroList().size()) {
						frame.getContentPane().removeAll();
						frame.repaint();
						teamNamePanel();
					} 
					else {
						frame.getContentPane().removeAll();
						frame.repaint();
						teamInitializerPanel();
					}
				}
			}
		});
		btnAddToTeam.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		btnAddToTeam.setBounds(360, 493, 208, 53);
		frame.getContentPane().add(btnAddToTeam);
		btnAddToTeam.setEnabled(false);
		
		
		
		
		JButton btnHeroType1 = new JButton("");
		btnHeroType1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNameHero.setText("NAME YOUR MERCHANT");
				heroNameEntryBox.setEnabled(true);
				btnAddToTeam.setEnabled(true);
				heroToAdd = new MerchantMan();
			}
		});
		btnHeroType1.setBackground(Color.DARK_GRAY);
		btnHeroType1.setBounds(34, 142, 117, 126);
		frame.getContentPane().add(btnHeroType1);
		
		
		
		
		JButton btnHeroType2 = new JButton("");
		btnHeroType2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNameHero.setText("NAME YOUR TANK");
				heroNameEntryBox.setEnabled(true);
				btnAddToTeam.setEnabled(true);
				heroToAdd = new Tank();
			}
		});
		btnHeroType2.setBackground(Color.DARK_GRAY);
		btnHeroType2.setBounds(191, 142, 117, 126);
		frame.getContentPane().add(btnHeroType2);
		
		
		
		
		JButton btnHeroType3 = new JButton("");
		btnHeroType3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNameHero.setText("NAME YOUR CARTOGRAPHER");
				heroNameEntryBox.setEnabled(true);
				btnAddToTeam.setEnabled(true);
				heroToAdd = new Cartographer();
			}
		});
		btnHeroType3.setBackground(Color.DARK_GRAY);
		btnHeroType3.setBounds(338, 142, 117, 126);
		frame.getContentPane().add(btnHeroType3);
		
		
		
		
		JButton btnHeroType4 = new JButton("");
		btnHeroType4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNameHero.setText("NAME YOUR SUPPORT");
				heroNameEntryBox.setEnabled(true);
				btnAddToTeam.setEnabled(true);
				heroToAdd = new Support();
			}
		});
		btnHeroType4.setBackground(Color.DARK_GRAY);
		btnHeroType4.setBounds(484, 142, 117, 126);
		frame.getContentPane().add(btnHeroType4);
		
		
		
		
		JButton btnHeroType5 = new JButton("");
		btnHeroType5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNameHero.setText("NAME YOUR LUCKY BOII");
				heroNameEntryBox.setEnabled(true);
				btnAddToTeam.setEnabled(true);
				heroToAdd = new LuckyBoii();
			}
		});
		btnHeroType5.setBackground(Color.DARK_GRAY);
		btnHeroType5.setBounds(636, 142, 117, 126);
		frame.getContentPane().add(btnHeroType5);
		
		
		
		
		JButton btnHeroType6 = new JButton("");
		btnHeroType6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNameHero.setText("NAME YOUR ANTI-HERO");
				heroNameEntryBox.setEnabled(true);
				btnAddToTeam.setEnabled(true);
				heroToAdd = new EdgyScaryFiendLord();
			}
		});
		btnHeroType6.setBackground(Color.DARK_GRAY);
		btnHeroType6.setBounds(792, 142, 117, 126);
		frame.getContentPane().add(btnHeroType6);
		
		
		
		
		ButtonGroup heroClassOptions = new ButtonGroup();
		heroClassOptions.add(btnHeroType1);
		heroClassOptions.add(btnHeroType2);
		heroClassOptions.add(btnHeroType3);
		heroClassOptions.add(btnHeroType4);
		heroClassOptions.add(btnHeroType5);
		heroClassOptions.add(btnHeroType6);
		
		
		
		
		JLabel lblMerchant = new JLabel("MERCHANT");
		lblMerchant.setHorizontalAlignment(SwingConstants.CENTER);
		lblMerchant.setBounds(56, 280, 82, 15);
		frame.getContentPane().add(lblMerchant);
		
		JLabel lblTank = new JLabel("TANK");
		lblTank.setHorizontalAlignment(SwingConstants.CENTER);
		lblTank.setBounds(226, 280, 41, 15);
		frame.getContentPane().add(lblTank);
		
		JLabel lblCartographer = new JLabel("CARTOGRAPHER");
		lblCartographer.setHorizontalAlignment(SwingConstants.CENTER);
		lblCartographer.setBounds(338, 280, 117, 15);
		frame.getContentPane().add(lblCartographer);
		
		JLabel lblSupport = new JLabel("SUPPORT");
		lblSupport.setHorizontalAlignment(SwingConstants.CENTER);
		lblSupport.setBounds(484, 280, 117, 15);
		frame.getContentPane().add(lblSupport);
		
		JLabel lblLuckyboii = new JLabel("LUCKYBOII");
		lblLuckyboii.setHorizontalAlignment(SwingConstants.CENTER);
		lblLuckyboii.setBounds(646, 280, 107, 15);
		frame.getContentPane().add(lblLuckyboii);
		
		JLabel lblAntihero = new JLabel("ANTI HERO");
		lblAntihero.setHorizontalAlignment(SwingConstants.CENTER);
		lblAntihero.setBounds(802, 280, 88, 15);
		frame.getContentPane().add(lblAntihero);

		JLabel lblSelectHeroesFor = new JLabel("CHOOSE  THE  CLASS  OF  THIS  HERO");
		lblSelectHeroesFor.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectHeroesFor.setFont(new Font("Arvo", Font.BOLD, 16));
		lblSelectHeroesFor.setBounds(10, 83, 914, 31);
		frame.getContentPane().add(lblSelectHeroesFor);
		
		JLabel lblAssembleYourTeam = new JLabel("ASSEMBLE  YOUR  TEAM  OF  HEROES");
		lblAssembleYourTeam.setHorizontalAlignment(SwingConstants.CENTER);
		lblAssembleYourTeam.setFont(new Font("Arvo", Font.BOLD, 30));
		lblAssembleYourTeam.setBounds(10, 29, 914, 53);
		frame.getContentPane().add(lblAssembleYourTeam);
		
		
		
		
		
		
	}
}
