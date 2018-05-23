package cityStuff;

import java.awt.EventQueue;
import cityStuff.*;
import games.*;
import teamStuff.Cartographer;
import teamStuff.EdgyScaryFiendLord;
import teamStuff.HealingItem;
import teamStuff.Hero;
import teamStuff.LuckyBoii;
import teamStuff.MerchantMan;
import teamStuff.PowerUp;
import teamStuff.Support;
import teamStuff.Tank;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class gameEnvGui {
	public static int buyingItem;
	public static String buyingType;
	public static String selectedHealingItem;
	public static String selectedPowerUp;
	public static int citiesFinished = 0;
	public static int numOfGuesses = 0;
	public static int numOfHeroes;
	public static int vill;
	public Hero heroToAdd;
	public gameEnvironmentGuiRunTime game = new gameEnvironmentGuiRunTime();
	private JFrame frmHeroesVsVillains;
	private JTextField textField;
	private JTextField heroNameEntryBox;
	private JTextField teamNameEntryBox;
	private Timer timer = new Timer();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gameEnvGui window = new gameEnvGui();
					window.frmHeroesVsVillains.setVisible(true);
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
		gameStartPanel();
//		cityAmmountPanel();//change to team set up later
//		teamInitializerPanel();
//		teamNamePanel();
//		baseCampPanel();
//		villiansLairPanel();
//		battleSelectionPanel();
//		diceRollPanel();
//		numberGuessPanel();
//		paperScissorsRockPanel();
//		shopPanel();
//		hospitalPanel();
//		powerUpDenPanel();
//		villianBeatPanel();


	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmHeroesVsVillains = new JFrame();
		frmHeroesVsVillains.setTitle("Heroes vs. Villains");
		frmHeroesVsVillains.getContentPane().setBackground(Color.LIGHT_GRAY);
		frmHeroesVsVillains.setBounds(100, 100, 940, 642);
		frmHeroesVsVillains.setResizable(false);
		frmHeroesVsVillains.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHeroesVsVillains.getContentPane().setLayout(null);
		
		
	}
	
	private void gameStartPanel() {
		frmHeroesVsVillains.getContentPane().setLayout(null);
		JLabel lblNewLabel_3 = new JLabel("HEROES  VS  VILLAINS");
		lblNewLabel_3.setForeground(new Color(0, 0, 0));
		lblNewLabel_3.setFont(new Font("Arvo", Font.BOLD | Font.ITALIC, 60));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(12, 44, 914, 82);
		frmHeroesVsVillains.getContentPane().add(lblNewLabel_3);
		
		JButton btnQuitGame = new JButton("QUIT");
		btnQuitGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnQuitGame.setForeground(new Color(255, 255, 255));
		btnQuitGame.setBackground(new Color(75, 0, 130));
		btnQuitGame.setFont(new Font("Dialog", Font.BOLD, 70));
		btnQuitGame.setBounds(313, 404, 319, 129);
		frmHeroesVsVillains.getContentPane().add(btnQuitGame);
		
		JButton btnPlayGame = new JButton("PLAY");
		btnPlayGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmHeroesVsVillains.getContentPane().removeAll();
				frmHeroesVsVillains.repaint();
				cityAmmountPanel();
			}
		});
		btnPlayGame.setBackground(new Color(75, 0, 130));
		btnPlayGame.setForeground(new Color(255, 255, 255));
		btnPlayGame.setFont(new Font("Dialog", Font.BOLD, 70));
		btnPlayGame.setBounds(313, 280, 319, 129);
		frmHeroesVsVillains.getContentPane().add(btnPlayGame);
		
		JLabel lblBackGround = new JLabel("");
		lblBackGround.setIcon(new ImageIcon(new ImageIcon(gameEnvGui.class.getResource("/Images/StartScreenArt.png")).getImage().getScaledInstance(940, 642, Image.SCALE_DEFAULT)));
		lblBackGround.setBounds(0, 0, 938, 616);
		frmHeroesVsVillains.getContentPane().add(lblBackGround);
		
	}
	
	
	
	private void teamNamePanel() {
		JLabel lblNameYourTeam = new JLabel("NAME   YOUR   TEAM   OF   HEROES");
		lblNameYourTeam.setFont(new Font("Arvo", Font.BOLD, 40));
		lblNameYourTeam.setHorizontalAlignment(SwingConstants.CENTER);
		lblNameYourTeam.setBounds(12, 47, 914, 52);
		frmHeroesVsVillains.getContentPane().add(lblNameYourTeam);
		
		teamNameEntryBox = new JTextField();
		teamNameEntryBox.setFont(new Font("Arvo", Font.BOLD, 70));
		teamNameEntryBox.setHorizontalAlignment(SwingConstants.CENTER);
		teamNameEntryBox.setBounds(118, 135, 713, 107);
		frmHeroesVsVillains.getContentPane().add(teamNameEntryBox);
		teamNameEntryBox.setColumns(10);
		
		JLabel lblTeamNameError = new JLabel("INVALID ENTRY: The team name must be between 2 and 10 characters in length.");
		lblTeamNameError.setFont(new Font("Dialog", Font.BOLD, 16));
		lblTeamNameError.setForeground(new Color(255, 0, 0));
		lblTeamNameError.setHorizontalAlignment(SwingConstants.CENTER);
		lblTeamNameError.setBounds(12, 254, 914, 52);
		frmHeroesVsVillains.getContentPane().add(lblTeamNameError);
		lblTeamNameError.setVisible(false);
		
		JButton btnProceedToCamp = new JButton("PROCEED  TO  CAMP");
		btnProceedToCamp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				game.getTeam().setBarterSkillSum();
				game.getTeam().setDeterrenceSum();
				game.getTeam().setFameSum();
				frmHeroesVsVillains.getContentPane().removeAll();
				frmHeroesVsVillains.repaint();
				baseCampPanel();
			}
		});
		btnProceedToCamp.setFont(new Font("Dialog", Font.BOLD, 22));
		btnProceedToCamp.setBounds(287, 503, 339, 88);
		frmHeroesVsVillains.getContentPane().add(btnProceedToCamp);
		btnProceedToCamp.setVisible(false);
		
		JLabel lblBeginQuest = new JLabel("");
		lblBeginQuest.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblBeginQuest.setHorizontalAlignment(SwingConstants.CENTER);
		lblBeginQuest.setBounds(12, 446, 914, 45);
		frmHeroesVsVillains.getContentPane().add(lblBeginQuest);
		
		JButton btnSubmitTeamName = new JButton("Confirm Name");
		btnSubmitTeamName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(teamNameEntryBox.getText().length() < 2 || teamNameEntryBox.getText().length() > 10) {
					lblTeamNameError.setVisible(true);
				}
				else {
					game.getTeam().nameTeam(teamNameEntryBox.getText());
					lblTeamNameError.setVisible(false);
					btnProceedToCamp.setVisible(true);
					lblBeginQuest.setText("Go forth, " + game.getTeam().getName() + ", and vanquish darstardly villains who've many cities under their rule!");
				}
			}
		});
		btnSubmitTeamName.setBounds(371, 318, 177, 25);
		frmHeroesVsVillains.getContentPane().add(btnSubmitTeamName);
	}
	
	
	
	
	
	private void baseCampPanel() {
		frmHeroesVsVillains.getContentPane().setLayout(null);
		
		JButton btnNewButton_1 = new JButton("View Inventory");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, game.getTeam().viewInventory());
			}
		});
		btnNewButton_1.setBounds(55, 478, 165, 91);
		frmHeroesVsVillains.getContentPane().add(btnNewButton_1);
		
		JButton btnViewStats = new JButton("View Stats");
		btnViewStats.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, game.getTeam().toString());
			}
		});
		btnViewStats.setBounds(384, 478, 165, 91);
		frmHeroesVsVillains.getContentPane().add(btnViewStats);
		
		JButton btnExitGame = new JButton("Exit Game");
		btnExitGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!game.hasMap) {
					game.makeAllUnfound();
				}
				citiesFinished += 1;
				game.setCurrentShop(citiesFinished);
				frmHeroesVsVillains.getContentPane().removeAll();
				frmHeroesVsVillains.repaint();
				baseCampPanel();
			}
		});
		btnExitGame.setBounds(708, 478, 165, 91);
		frmHeroesVsVillains.getContentPane().add(btnExitGame);
		
		JButton btnNorth = new JButton("North");
		btnNorth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				btnNorth.setText(game.getMapPlace(0));
				btnNorth.setText(game.getCurrentMap(citiesFinished).get(0));
				game.setFoundPlaceTrue(0);
				frmHeroesVsVillains.getContentPane().removeAll();
				frmHeroesVsVillains.repaint();
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
						hospitalPanel();
						break;
				}
			}
		});
		btnNorth.setBounds(405, 43, 117, 25);
		frmHeroesVsVillains.getContentPane().add(btnNorth);
		btnNorth.setText(game.getMapPlace(0,citiesFinished));//this is the correct one
//		btnNorth.setText(game.getCurrentMap(citiesFinished).get(0));//this is used for testing
//		btnNorth.setText("???");
		JButton btnEast = new JButton("East");
		btnEast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnEast.setText(game.getCurrentMap(citiesFinished).get(1));
				game.setFoundPlaceTrue(1);
				frmHeroesVsVillains.getContentPane().removeAll();
				frmHeroesVsVillains.repaint();
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
						hospitalPanel();
						break;
				}
			}
		});
		btnEast.setBounds(737, 212, 117, 25);
		frmHeroesVsVillains.getContentPane().add(btnEast);
		btnEast.setText(game.getMapPlace(1,citiesFinished));//this is the correct one
//		btnEast.setText(game.getCurrentMap(citiesFinished).get(1));//test one
//		btnEast.setText(game.getCurrentMap(citiesFinished).get(1));
		JButton btnSouth = new JButton("South");
		btnSouth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSouth.setText(game.getCurrentMap(citiesFinished).get(2));
				game.setFoundPlaceTrue(2);
				frmHeroesVsVillains.getContentPane().removeAll();
				frmHeroesVsVillains.repaint();
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
						hospitalPanel();
						break;
				}
//				if (btnSouth.getText() == "Lair") {
//					villiansLairPanel();
//				} 
			}
		});
		btnSouth.setBounds(405, 385, 117, 25);
		frmHeroesVsVillains.getContentPane().add(btnSouth);
		btnSouth.setText(game.getMapPlace(2,citiesFinished));//correct one
//		btnSouth.setText(game.getCurrentMap(citiesFinished).get(2));//testone
//		btnSouth.setText(game.getCurrentMap(citiesFinished).get(2));
		JButton btnWest = new JButton("West");
		btnWest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnWest.setText(game.getCurrentMap(citiesFinished).get(3));
				game.setFoundPlaceTrue(3);
				frmHeroesVsVillains.getContentPane().removeAll();
				frmHeroesVsVillains.repaint();
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
						hospitalPanel();
						break;
				}
			}
		});
		btnWest.setBounds(74, 212, 117, 25);
		frmHeroesVsVillains.getContentPane().add(btnWest);
		btnWest.setText(game.getMapPlace(3,citiesFinished));//correct one
//		btnWest.setText(game.getCurrentMap(citiesFinished).get(3));//test one
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(new ImageIcon(gameEnvGui.class.getResource("/Images/team.gif")).getImage().getScaledInstance(553, 376, Image.SCALE_SMOOTH)));
		lblNewLabel_1.setBounds(260, 124, 431, 173);
		frmHeroesVsVillains.getContentPane().add(lblNewLabel_1);
		
		JLabel compass = new JLabel("");
		compass.setIcon(new ImageIcon(new ImageIcon(gameEnvGui.class.getResource("/Images/compass.png")).getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT)));
		compass.setBounds(0, -272, 949, 740);
		frmHeroesVsVillains.getContentPane().add(compass);
		
		JLabel backGround = new JLabel("New label");
		backGround.setIcon(new ImageIcon(new ImageIcon(gameEnvGui.class.getResource("/Images/finalBackground.jpg")).getImage().getScaledInstance(940, 642, Image.SCALE_DEFAULT)));
		backGround.setBounds(0, -64, 949, 740);
		frmHeroesVsVillains.getContentPane().add(backGround);
	}
	
	private void cityAmmountPanel() {
		frmHeroesVsVillains.getContentPane().setLayout(null);
		JLabel lblHowManyCities = new JLabel("How Many Cities Would You Like To Save?");
		lblHowManyCities.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblHowManyCities.setHorizontalAlignment(SwingConstants.CENTER);
		lblHowManyCities.setBounds(10, 43, 914, 61);
		frmHeroesVsVillains.getContentPane().add(lblHowManyCities);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 30));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"3", "4", "5", "6"}));
		comboBox.setBounds(419, 115, 50, 41);
		frmHeroesVsVillains.getContentPane().add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3"}));
		comboBox_1.setBounds(419, 290, 50, 41);
		frmHeroesVsVillains.getContentPane().add(comboBox_1);
		
		JButton btnNewButton = new JButton("Confirm");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 30));
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
				frmHeroesVsVillains.getContentPane().removeAll();
				frmHeroesVsVillains.repaint();
				teamInitializerPanel();//for vinnie test
			}
		});
		btnNewButton.setBounds(359, 405, 171, 86);
		frmHeroesVsVillains.getContentPane().add(btnNewButton);
		
		JLabel lblHowManyHeroes = new JLabel("How Many Heroes Would You Like? ");
		lblHowManyHeroes.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblHowManyHeroes.setHorizontalAlignment(SwingConstants.CENTER);
		lblHowManyHeroes.setBounds(10, 238, 914, 41);
		frmHeroesVsVillains.getContentPane().add(lblHowManyHeroes);
		
		
	}
	
	
	private void villiansLairPanel() {
		frmHeroesVsVillains.getContentPane().setLayout(null);
		JButton btnNewButton_2 = new JButton("Flee From The Lair");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmHeroesVsVillains.getContentPane().removeAll();
				frmHeroesVsVillains.repaint();
				baseCampPanel();
			}
		});
		btnNewButton_2.setBounds(129, 244, 241, 90);
		frmHeroesVsVillains.getContentPane().add(btnNewButton_2);
		
		JButton btnBattleTheVillian = new JButton("Battle The Villian");
		btnBattleTheVillian.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmHeroesVsVillains.getContentPane().removeAll();
				frmHeroesVsVillains.repaint();
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
		btnBattleTheVillian.setBounds(525, 244, 241, 90);
		frmHeroesVsVillains.getContentPane().add(btnBattleTheVillian);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(0, 0, 938, 616);
		frmHeroesVsVillains.getContentPane().add(lblNewLabel_2);
		lblNewLabel_2.setIcon(new ImageIcon(new ImageIcon(gameEnvGui.class.getResource("/Images/lairWall.png")).getImage().getScaledInstance(940, 642, Image.SCALE_DEFAULT)));
		
		
		
	}
	
	private void battleSelectionPanel() {
		frmHeroesVsVillains.getContentPane().setLayout(null);
		JButton btnNewButton_3 = new JButton("Paper Scissors Rock");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmHeroesVsVillains.getContentPane().removeAll();
				frmHeroesVsVillains.repaint();
				paperScissorsRockPanel();
			}
		});
		btnNewButton_3.setBounds(87, 139, 179, 118);
		frmHeroesVsVillains.getContentPane().add(btnNewButton_3);
		
		JButton btnGuessTheRandom = new JButton("Guess The Random Number");
		btnGuessTheRandom.setBounds(359, 139, 179, 118);
		btnGuessTheRandom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmHeroesVsVillains.getContentPane().removeAll();
				frmHeroesVsVillains.repaint();
				numberGuessPanel();
			}
		});
		frmHeroesVsVillains.getContentPane().add(btnGuessTheRandom);
		
		JButton btnRollTheDice = new JButton("Roll The Dice");
		btnRollTheDice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmHeroesVsVillains.getContentPane().removeAll();
				frmHeroesVsVillains.repaint();
				diceRollPanel();
			}
		});
		btnRollTheDice.setBounds(630, 139, 179, 118);
		frmHeroesVsVillains.getContentPane().add(btnRollTheDice);
	}
	
	private void diceRollPanel() {
		frmHeroesVsVillains.getContentPane().setLayout(null);
		JLabel lblBattlingWith = new JLabel("Battling With ");
		lblBattlingWith.setBounds(361, 24, 269, 14);
		lblBattlingWith.setText("Battle With: " + game.getTeam().getHeroArray().get(0).getName());
		frmHeroesVsVillains.getContentPane().add(lblBattlingWith);
		
		JLabel lblHero = new JLabel("hero1");
		lblHero.setBounds(56, 24, 46, 14);
		frmHeroesVsVillains.getContentPane().add(lblHero);
		
		
		JLabel lblHero_1 = new JLabel("hero2");
		lblHero_1.setBounds(56, 98, 46, 14);
		frmHeroesVsVillains.getContentPane().add(lblHero_1);
		
		JLabel lblHero_2 = new JLabel("hero3");
		lblHero_2.setBounds(56, 175, 46, 14);
		frmHeroesVsVillains.getContentPane().add(lblHero_2);
		
		
		JRadioButton char_1_box = new JRadioButton("");
		char_1_box.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblBattlingWith.setText("Battle With: " + game.getTeam().getHeroArray().get(0).getName());
				game.setCurrentHero(0);
			}
		});
		char_1_box.setBounds(66, 45, 97, 23);
		char_1_box.setSelected(true);
		frmHeroesVsVillains.getContentPane().add(char_1_box);
		
		JRadioButton char_2_box = new JRadioButton("");
		char_2_box.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblBattlingWith.setText("Battle With: " + game.getTeam().getHeroArray().get(1).getName());
				game.setCurrentHero(1);
			}
		});
		char_2_box.setBounds(66, 119, 97, 23);
		frmHeroesVsVillains.getContentPane().add(char_2_box);
		
		JRadioButton char_3_box = new JRadioButton("");
		char_3_box.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblBattlingWith.setText("Battle With: " + game.getTeam().getHeroArray().get(2).getName());
				game.setCurrentHero(2);
			}
		});
		char_3_box.setBounds(66, 196, 97, 23);
		frmHeroesVsVillains.getContentPane().add(char_3_box);
		
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
		frmHeroesVsVillains.getContentPane().add(lblResult);
		
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
						frmHeroesVsVillains.getContentPane().removeAll();
						frmHeroesVsVillains.repaint();
						villianBeatPanel();
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
							frmHeroesVsVillains.getContentPane().removeAll();
							frmHeroesVsVillains.repaint();
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
		frmHeroesVsVillains.getContentPane().add(btnRollDice);
		
		JButton btnViewStats_1 = new JButton("View Stats");
		btnViewStats_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, game.getTeam().toString());
			}
		});
		btnViewStats_1.setBounds(499, 400, 311, 138);
		frmHeroesVsVillains.getContentPane().add(btnViewStats_1);
		
	}
	
	private void numberGuessPanel() {
		//int numOfGuesses = 0;
		vill = numberGuess.getVillianChoice();
		frmHeroesVsVillains.getContentPane().setLayout(null);
		JLabel lblWhatsYourGuess = new JLabel("Whats Your Guess?");
		lblWhatsYourGuess.setBounds(373, 253, 129, 14);
		frmHeroesVsVillains.getContentPane().add(lblWhatsYourGuess);
		
		JLabel lblBattlingWith = new JLabel("Battling With ");
		lblBattlingWith.setBounds(361, 24, 269, 14);
		lblBattlingWith.setText("Battle With: " + game.getTeam().getHeroArray().get(0).getName());
		frmHeroesVsVillains.getContentPane().add(lblBattlingWith);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		comboBox.setBounds(383, 278, 65, 22);
		frmHeroesVsVillains.getContentPane().add(comboBox);
		
		JLabel lblResult = new JLabel("You Need To Roll The Dice First!");
		lblResult.setBounds(281, 137, 304, 55);
		frmHeroesVsVillains.getContentPane().add(lblResult);
		
		
		JLabel lblHero = new JLabel("hero1");
		lblHero.setBounds(56, 24, 46, 14);
		frmHeroesVsVillains.getContentPane().add(lblHero);
		
		
		JLabel lblHero_1 = new JLabel("hero2");
		lblHero_1.setBounds(56, 98, 46, 14);
		frmHeroesVsVillains.getContentPane().add(lblHero_1);
		
		JLabel lblHero_2 = new JLabel("hero3");
		lblHero_2.setBounds(56, 175, 46, 14);
		frmHeroesVsVillains.getContentPane().add(lblHero_2);
		
		
		JRadioButton char_1_box = new JRadioButton("");
		char_1_box.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblBattlingWith.setText("Battle With: " + game.getTeam().getHeroArray().get(0).getName());
				game.setCurrentHero(0);
			}
		});
		char_1_box.setBounds(66, 45, 97, 23);
		char_1_box.setSelected(true);
		frmHeroesVsVillains.getContentPane().add(char_1_box);
		
		JRadioButton char_2_box = new JRadioButton("");
		char_2_box.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblBattlingWith.setText("Battle With: " + game.getTeam().getHeroArray().get(1).getName());
				game.setCurrentHero(1);
			}
		});
		char_2_box.setBounds(66, 119, 97, 23);
		frmHeroesVsVillains.getContentPane().add(char_2_box);
		
		JRadioButton char_3_box = new JRadioButton("");
		char_3_box.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblBattlingWith.setText("Battle With: " + game.getTeam().getHeroArray().get(2).getName());
				game.setCurrentHero(2);
			}
		});
		char_3_box.setBounds(66, 196, 97, 23);
		frmHeroesVsVillains.getContentPane().add(char_3_box);
		
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
		frmHeroesVsVillains.getContentPane().add(lblNewLabel);
		lblNewLabel.setText(Integer.toString(vill));
		
		JButton btnConfirmYourGuess = new JButton("Confirm Your Guess");
		btnConfirmYourGuess.setBounds(274, 311, 311, 126);
		frmHeroesVsVillains.getContentPane().add(btnConfirmYourGuess);
		frmHeroesVsVillains.getContentPane().setLayout(null);
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
						frmHeroesVsVillains.getContentPane().removeAll();
						frmHeroesVsVillains.repaint();
						villianBeatPanel();
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
							frmHeroesVsVillains.getContentPane().removeAll();
							frmHeroesVsVillains.repaint();
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
		frmHeroesVsVillains.getContentPane().add(btnViewStats_1);
		
		
	}
	
	private void hospitalPanel() {
		
		JLabel lblApplyTo = new JLabel("Apply To:");
		lblApplyTo.setBounds(421, 231, 70, 15);
		frmHeroesVsVillains.getContentPane().add(lblApplyTo);
		
		
		JLabel lblHero = new JLabel("hero1");
		lblHero.setBounds(245, 264, 46, 14);
		frmHeroesVsVillains.getContentPane().add(lblHero);
		
		
		
		JLabel lblHero_1 = new JLabel("hero2");
		lblHero_1.setBounds(441, 264, 46, 14);
		frmHeroesVsVillains.getContentPane().add(lblHero_1);
		
		JLabel lblHero_2 = new JLabel("hero3");
		lblHero_2.setBounds(627, 264, 46, 14);
		frmHeroesVsVillains.getContentPane().add(lblHero_2);
		
		
		JRadioButton char_1_box = new JRadioButton("");
		char_1_box.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblApplyTo.setText("Apply To: " + game.getTeam().getHeroArray().get(0).getName());
				game.setCurrentHero(0);
			}
		});
		char_1_box.setBounds(255, 286, 97, 23);
		char_1_box.setSelected(true);
		frmHeroesVsVillains.getContentPane().add(char_1_box);
		
		JRadioButton char_2_box = new JRadioButton("");
		char_2_box.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblApplyTo.setText("Apply To: " + game.getTeam().getHeroArray().get(1).getName());
				game.setCurrentHero(1);
			}
		});
		char_2_box.setBounds(451, 286, 97, 23);
		frmHeroesVsVillains.getContentPane().add(char_2_box);
		
		JRadioButton char_3_box = new JRadioButton("");
		char_3_box.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblApplyTo.setText("Apply To: " + game.getTeam().getHeroArray().get(2).getName());
				game.setCurrentHero(2);
			}
		});
		char_3_box.setBounds(637, 286, 97, 23);
		frmHeroesVsVillains.getContentPane().add(char_3_box);
		
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
		frmHeroesVsVillains.getContentPane().add(lblAvaiableHealingItems);
		
		JButton btnNewButton_4 = new JButton("Restore Health I");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedHealingItem = btnNewButton_4.getText();
			}
		});
		btnNewButton_4.setBounds(135, 55, 189, 81);
		frmHeroesVsVillains.getContentPane().add(btnNewButton_4);
		
		selectedHealingItem = btnNewButton_4.getText();
		
		JButton btnRestoreHealthIi_1 = new JButton("Restore Health II");
		btnRestoreHealthIi_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedHealingItem = btnRestoreHealthIi_1.getText();
			}
		});
		btnRestoreHealthIi_1.setBounds(357, 55, 189, 81);
		frmHeroesVsVillains.getContentPane().add(btnRestoreHealthIi_1);
		
		JButton btnRestoreHealthIi = new JButton("Restore Health III");
		btnRestoreHealthIi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedHealingItem = btnRestoreHealthIi.getText();
			}
		});
		btnRestoreHealthIi.setBounds(571, 55, 189, 81);
		frmHeroesVsVillains.getContentPane().add(btnRestoreHealthIi);
		
		JLabel HealthIStock = new JLabel("New label");
		HealthIStock.setBounds(196, 148, 70, 15);
		frmHeroesVsVillains.getContentPane().add(HealthIStock);
		HealthIStock.setText(String.valueOf(Collections.frequency(game.getTeam().getHealingItems(), game.getCurrentShop().getHealingItems().get(0))));
		
		
		JLabel HealthIIStock = new JLabel("New label");
		HealthIIStock.setBounds(421, 148, 70, 15);
		frmHeroesVsVillains.getContentPane().add(HealthIIStock);
		HealthIIStock.setText(String.valueOf(Collections.frequency(game.getTeam().getHealingItems(), game.getCurrentShop().getHealingItems().get(1))));
		
		JLabel HealthIIIStock = new JLabel("New label");
		HealthIIIStock.setBounds(645, 148, 70, 15);
		frmHeroesVsVillains.getContentPane().add(HealthIIIStock);
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
					frmHeroesVsVillains.getContentPane().removeAll();
					frmHeroesVsVillains.repaint();
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
		frmHeroesVsVillains.getContentPane().add(btnNewButton_5);
		
		JButton btnExit_1 = new JButton("Exit");
		btnExit_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmHeroesVsVillains.getContentPane().removeAll();
				frmHeroesVsVillains.repaint();
				baseCampPanel();
			}
		});
		btnExit_1.setBounds(518, 380, 215, 100);
		frmHeroesVsVillains.getContentPane().add(btnExit_1);
		
	}
	
	private void shopPanel() {
		JLabel lblTeamsCurrentInventory = new JLabel("Teams Current Inventory");
		lblTeamsCurrentInventory.setBounds(372, 12, 238, 15);
		frmHeroesVsVillains.getContentPane().add(lblTeamsCurrentInventory);
		frmHeroesVsVillains.getContentPane().setBackground(UIManager.getColor("OptionPane.warningDialog.border.background"));
		JLabel itemName = new JLabel("Selected Item Name");
		itemName.setBounds(751, 572, 135, 15);
		frmHeroesVsVillains.getContentPane().add(itemName);
		itemName.setVisible(false);
		
		
		//itemName.setIcon(new ImageIcon(new ImageIcon(gameEnvGui.class.getResource("/Images/RestoreHealth1.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
		JLabel itemImg = new JLabel("Selected Item Name");
		itemImg.setBounds(45, 310, 53, 51);
		frmHeroesVsVillains.getContentPane().add(itemImg);
		itemImg.setIcon(new ImageIcon(new ImageIcon(gameEnvGui.class.getResource("/Images/RestoreHealth1.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmHeroesVsVillains.getContentPane().removeAll();
				frmHeroesVsVillains.repaint();
				baseCampPanel();
			}
		});
		btnExit.setBounds(495, 534, 238, 70);
		frmHeroesVsVillains.getContentPane().add(btnExit);
		
		JLabel currentItemInfo = new JLabel("");
		currentItemInfo.setBounds(28, 400, 70, 15);
		frmHeroesVsVillains.getContentPane().add(currentItemInfo);
		
		JLabel lblAvailableHealingItems = new JLabel("Available Healing Items");
		lblAvailableHealingItems.setBounds(372, 64, 238, 15);
		frmHeroesVsVillains.getContentPane().add(lblAvailableHealingItems);
		
		JLabel lblAvailablePowerUps = new JLabel("Available Power Ups");
		lblAvailablePowerUps.setBounds(384, 196, 238, 15);
		frmHeroesVsVillains.getContentPane().add(lblAvailablePowerUps);
		
		JButton health1 = new JButton("r1");
		health1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				itemName.setText(game.getCurrentShop().getHealingItems().get(0).getHealingItemName());
				itemImg.setIcon(new ImageIcon(new ImageIcon(gameEnvGui.class.getResource("/Images/RestoreHealth1.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
			}
		});
		health1.setBounds(185, 150, 123, 23);
		frmHeroesVsVillains.getContentPane().add(health1);
		health1.setText(game.getCurrentShop().getHealingItems().get(0).getHealingItemName());
		
		JButton health2 = new JButton("r2");
		health2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				itemName.setText(game.getCurrentShop().getHealingItems().get(1).getHealingItemName());
				itemImg.setIcon(new ImageIcon(new ImageIcon(gameEnvGui.class.getResource("/Images/RestoreHealth1.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
			}
		});
		health2.setBounds(407, 151, 117, 21);
		frmHeroesVsVillains.getContentPane().add(health2);
		health2.setText(game.getCurrentShop().getHealingItems().get(1).getHealingItemName());
		
		JButton health3 = new JButton("r3");
		health3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				itemName.setText(game.getCurrentShop().getHealingItems().get(2).getHealingItemName());
				itemImg.setIcon(new ImageIcon(new ImageIcon(gameEnvGui.class.getResource("/Images/RestoreHealth1.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
			}
		});
		health3.setBounds(640, 151, 123, 23);
		frmHeroesVsVillains.getContentPane().add(health3);
		health3.setText(game.getCurrentShop().getHealingItems().get(2).getHealingItemName());
		
		
		
		
//		THE BEGGINING OF THE POWER UP SECTION
		JButton powerUp1 = new JButton("p1");
		powerUp1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				itemName.setText(game.getCurrentShop().getPowerUpItems.get(0).getPowerUpName());
				itemImg.setIcon(new ImageIcon(new ImageIcon(gameEnvGui.class.getResource("/Images/AugmentVitality1.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
			}
		});
		powerUp1.setBounds(173, 279, 123, 23);
		frmHeroesVsVillains.getContentPane().add(powerUp1);
		powerUp1.setText(game.getCurrentShop().getPowerUpItems.get(0).getPowerUpName());
		
		JButton powerUp2 = new JButton("p2");
		powerUp2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				itemName.setText(game.getCurrentShop().getPowerUpItems.get(1).getPowerUpName());
				itemImg.setIcon(new ImageIcon(new ImageIcon(gameEnvGui.class.getResource("/Images/AugmentVitality1.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
			}
		});
		powerUp2.setBounds(407, 279, 104, 23);
		frmHeroesVsVillains.getContentPane().add(powerUp2);
		powerUp2.setText(game.getCurrentShop().getPowerUpItems.get(1).getPowerUpName());
		
		JButton powerUp3 = new JButton("p3");
		powerUp3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				itemName.setText(game.getCurrentShop().getPowerUpItems.get(2).getPowerUpName());
				itemImg.setIcon(new ImageIcon(new ImageIcon(gameEnvGui.class.getResource("/Images/AugmentVitality1.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
			}
		});
		powerUp3.setBounds(640, 279, 104, 22);
		frmHeroesVsVillains.getContentPane().add(powerUp3);
		powerUp3.setText(game.getCurrentShop().getPowerUpItems.get(2).getPowerUpName());
		
		JButton powerUp4 = new JButton("p4");
		powerUp4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				itemName.setText(game.getCurrentShop().getPowerUpItems.get(3).getPowerUpName());
				itemImg.setIcon(new ImageIcon(new ImageIcon(gameEnvGui.class.getResource("/Images/IronFlesh1.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
			}
		});
		powerUp4.setBounds(173, 372, 123, 23);
		frmHeroesVsVillains.getContentPane().add(powerUp4);
		powerUp4.setText(game.getCurrentShop().getPowerUpItems.get(3).getPowerUpName());
		
		JButton powerUp5 = new JButton("p5");
		powerUp5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				itemName.setText(game.getCurrentShop().getPowerUpItems.get(4).getPowerUpName());
				itemImg.setIcon(new ImageIcon(new ImageIcon(gameEnvGui.class.getResource("/Images/IronFlesh1.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
			}
		});
		powerUp5.setBounds(407, 372, 104, 23);
		frmHeroesVsVillains.getContentPane().add(powerUp5);
		powerUp5.setText(game.getCurrentShop().getPowerUpItems.get(4).getPowerUpName());
		
		JButton powerUp6 = new JButton("p6");
		powerUp6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				itemName.setText(game.getCurrentShop().getPowerUpItems.get(5).getPowerUpName());
				itemImg.setIcon(new ImageIcon(new ImageIcon(gameEnvGui.class.getResource("/Images/IronFlesh1.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
			}
		});
		powerUp6.setBounds(640, 371, 104, 23);
		frmHeroesVsVillains.getContentPane().add(powerUp6);
		powerUp6.setText(game.getCurrentShop().getPowerUpItems.get(5).getPowerUpName());
		
		JButton powerUp7 = new JButton("p7");
		powerUp7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				itemName.setText(game.getCurrentShop().getPowerUpItems.get(6).getPowerUpName());
				itemImg.setIcon(new ImageIcon(new ImageIcon(gameEnvGui.class.getResource("/Images/SilverTongue1.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
			}
		});
		powerUp7.setBounds(173, 489, 123, 23);
		frmHeroesVsVillains.getContentPane().add(powerUp7);
		powerUp7.setText(game.getCurrentShop().getPowerUpItems.get(6).getPowerUpName());
		
		JButton powerUp8 = new JButton("p8");
		powerUp8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				itemName.setText(game.getCurrentShop().getPowerUpItems.get(7).getPowerUpName());
				itemImg.setIcon(new ImageIcon(new ImageIcon(gameEnvGui.class.getResource("/Images/SilverTongue1.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
			}
		});
		powerUp8.setBounds(407, 489, 104, 23);
		frmHeroesVsVillains.getContentPane().add(powerUp8);
		powerUp8.setText(game.getCurrentShop().getPowerUpItems.get(7).getPowerUpName());
		
		JButton powerUp9 = new JButton("p9");
		powerUp9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				itemName.setText(game.getCurrentShop().getPowerUpItems.get(8).getPowerUpName());
				itemImg.setIcon(new ImageIcon(new ImageIcon(gameEnvGui.class.getResource("/Images/SilverTongue1.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
			}
		});
		powerUp9.setBounds(640, 489, 104, 22);
		frmHeroesVsVillains.getContentPane().add(powerUp9);
		powerUp9.setText(game.getCurrentShop().getPowerUpItems.get(8).getPowerUpName());
		
		JLabel lblSelectedItem = new JLabel("Selected Item");
		lblSelectedItem.setBounds(21, 283, 104, 15);
		frmHeroesVsVillains.getContentPane().add(lblSelectedItem);
//		r1.setIcon(new ImageIcon(new ImageIcon(gameEnvGui.class.getResource("/Images/RestoreHealth1.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
		
		
		
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
		itemsToChoose.add(powerUp6);
		itemsToChoose.add(powerUp7);
		itemsToChoose.add(powerUp8);
		itemsToChoose.add(powerUp9);
		
		
//		STOCK LEVEL LABELS
		JLabel HIT1 = new JLabel("r1Stock");
		HIT1.setBounds(314, 132, 70, 15);
		frmHeroesVsVillains.getContentPane().add(HIT1);
		HIT1.setText(String.valueOf(game.getCurrentShop().getHealingStockLevel()[0]));
		
		JLabel HIT2 = new JLabel("r1Stock");
		HIT2.setBounds(529, 132, 70, 15);
		frmHeroesVsVillains.getContentPane().add(HIT2);
		HIT2.setText(String.valueOf(game.getCurrentShop().getHealingStockLevel()[1]));
		
		JLabel HIT3 = new JLabel("r1Stock");
		HIT3.setBounds(762, 132, 70, 15);
		frmHeroesVsVillains.getContentPane().add(HIT3);
		HIT3.setText(String.valueOf(game.getCurrentShop().getHealingStockLevel()[2]));
		
		JLabel PUP1 = new JLabel("null");
		PUP1.setBounds(314, 260, 70, 15);
		frmHeroesVsVillains.getContentPane().add(PUP1);
		PUP1.setText(String.valueOf(game.getCurrentShop().getPowerUpStockLevel()[0]));
		
		JLabel PUP2 = new JLabel("null");
		PUP2.setBounds(529, 260, 70, 15);
		frmHeroesVsVillains.getContentPane().add(PUP2);
		PUP2.setText(String.valueOf(game.getCurrentShop().getPowerUpStockLevel()[1]));
		
		JLabel PUP3 = new JLabel("null");
		PUP3.setBounds(762, 260, 70, 15);
		frmHeroesVsVillains.getContentPane().add(PUP3);
		PUP3.setText(String.valueOf(game.getCurrentShop().getPowerUpStockLevel()[2]));
		
		JLabel PUP4 = new JLabel("null");
		PUP4.setBounds(314, 353, 70, 15);
		frmHeroesVsVillains.getContentPane().add(PUP4);
		PUP4.setText(String.valueOf(game.getCurrentShop().getPowerUpStockLevel()[3]));
		
		JLabel PUP5 = new JLabel("null");
		PUP5.setBounds(529, 353, 70, 15);
		frmHeroesVsVillains.getContentPane().add(PUP5);
		PUP5.setText(String.valueOf(game.getCurrentShop().getPowerUpStockLevel()[4]));
		
		JLabel PUP6 = new JLabel("null");
		PUP6.setBounds(762, 353, 70, 15);
		frmHeroesVsVillains.getContentPane().add(PUP6);
		PUP6.setText(String.valueOf(game.getCurrentShop().getPowerUpStockLevel()[5]));
		
		JLabel PUP7 = new JLabel("null");
		PUP7.setBounds(319, 470, 70, 15);
		frmHeroesVsVillains.getContentPane().add(PUP7);
		PUP7.setText(String.valueOf(game.getCurrentShop().getPowerUpStockLevel()[6]));
		
		JLabel PUP8 = new JLabel("null");
		PUP8.setBounds(529, 470, 70, 15);
		frmHeroesVsVillains.getContentPane().add(PUP8);
		PUP8.setText(String.valueOf(game.getCurrentShop().getPowerUpStockLevel()[7]));
		
		JLabel PUP9 = new JLabel("null");
		PUP9.setBounds(726, 452, 70, 15);
		frmHeroesVsVillains.getContentPane().add(PUP9);
		PUP9.setText(String.valueOf(game.getCurrentShop().getPowerUpStockLevel()[8]));
		
		
		JButton purchaseButton = new JButton("Purchase Selected Item");
		purchaseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch(itemName.getText()) {
				case "Restore Health I":
					buyingItem = 0;
					buyingType = "Healing Potion";
//					if (game.getCurrentShop().getHealingStockLevel()[0] > 0) {
//						if (game.getTeam().getMoney() > game.getCurrentShop().getHealingItems().get(0).getHealingItemPrice()) {
//							game.getTeam().addHealingItem(game.getCurrentShop().getHealingItems().get(0));
//							game.getCurrentShop().getHealingStockLevel()[0] -= 1;
//							HIT1.setText(String.valueOf(game.getCurrentShop().getHealingStockLevel()[0]));
//							game.getTeam().addMoney(-game.getCurrentShop().getHealingItems().get(0).getHealingItemPrice());
//						} else {
//							JOptionPane.showMessageDialog(null, "YOU DONT HAVE ENOUGH MONEY!");
//						}
//					} else {
//						JOptionPane.showMessageDialog(null, "THIS ITEM IS OUT OF STOCK");
//					}
					break;
				case "Restore Health II":
					buyingItem = 1;
					buyingType = "Healing Potion";
//					if (game.getCurrentShop().getHealingStockLevel()[1] > 0) {
//						game.getTeam().addHealingItem(game.getCurrentShop().getHealingItems().get(1));
//						game.getCurrentShop().getHealingStockLevel()[1] -= 1;
//						HIT2.setText(String.valueOf(game.getCurrentShop().getHealingStockLevel()[1]));
//					} else {
//						JOptionPane.showMessageDialog(null, "THIS ITEM IS OUT OF STOCK");
//					}
					break;
				case "Restore Health III":
					buyingItem = 2;
					buyingType = "Healing Potion";
//					if (game.getCurrentShop().getHealingStockLevel()[2] > 0) {
//						game.getTeam().addHealingItem(game.getCurrentShop().getHealingItems().get(2));
//						game.getCurrentShop().getHealingStockLevel()[2] -= 1;
//						HIT3.setText(String.valueOf(game.getCurrentShop().getHealingStockLevel()[2]));
//					} else {
//						JOptionPane.showMessageDialog(null, "THIS ITEM IS OUT OF STOCK");
//					}
					break;
				case "Iron Flesh I":
					buyingItem = 0;
					buyingType = "Power Up";
//					if (game.getCurrentShop().getPowerUpStockLevel()[0] > 0) {
//						game.getTeam().addPowerUp(game.getCurrentShop().getPowerUpItems().get(0));
//						game.getCurrentShop().getPowerUpStockLevel()[0] -= 1;
//						PUP1.setText(String.valueOf(game.getCurrentShop().getPowerUpStockLevel()[0]));
//					} else {
//						JOptionPane.showMessageDialog(null, "THIS ITEM IS OUT OF STOCK");
//					}
					break;
				case "Iron Flesh II":
					buyingItem = 1;
					buyingType = "Power Up";
//					if (game.getCurrentShop().getPowerUpStockLevel()[1] > 0) {
//						game.getTeam().addPowerUp(game.getCurrentShop().getPowerUpItems().get(1));
//						game.getCurrentShop().getPowerUpStockLevel()[1] -= 1;
//						PUP2.setText(String.valueOf(game.getCurrentShop().getPowerUpStockLevel()[1]));
//					} else {
//						JOptionPane.showMessageDialog(null, "THIS ITEM IS OUT OF STOCK");
//					}
					break;
				case "Iron Flesh III":
					buyingItem = 2;
					buyingType = "Power Up";
//					if (game.getCurrentShop().getPowerUpStockLevel()[2] > 0) {
//						game.getTeam().addPowerUp(game.getCurrentShop().getPowerUpItems().get(2));
//						game.getCurrentShop().getPowerUpStockLevel()[2] -= 1;
//						PUP3.setText(String.valueOf(game.getCurrentShop().getPowerUpStockLevel()[2]));
//					} else {
//						JOptionPane.showMessageDialog(null, "THIS ITEM IS OUT OF STOCK");
//					}
					break;
				case "Augment Vitality I":
					buyingItem = 3;
					buyingType = "Power Up";
//					if (game.getCurrentShop().getPowerUpStockLevel()[3] > 0) {
//						game.getTeam().addPowerUp(game.getCurrentShop().getPowerUpItems().get(3));
//						game.getCurrentShop().getPowerUpStockLevel()[3] -= 1;
//						PUP4.setText(String.valueOf(game.getCurrentShop().getPowerUpStockLevel()[3]));
//					} else {
//						JOptionPane.showMessageDialog(null, "THIS ITEM IS OUT OF STOCK");
//					}
					break;
				case "Augment Vitality II":
					buyingItem = 4;
					buyingType = "Power Up";
//					if (game.getCurrentShop().getPowerUpStockLevel()[4] > 0) {
//						game.getTeam().addPowerUp(game.getCurrentShop().getPowerUpItems().get(4));
//						game.getCurrentShop().getPowerUpStockLevel()[4] -= 1;
//						PUP5.setText(String.valueOf(game.getCurrentShop().getPowerUpStockLevel()[4]));
//					} else {
//						JOptionPane.showMessageDialog(null, "THIS ITEM IS OUT OF STOCK");
//					}
					break;
				case "Augment Vitality III":
					buyingItem = 5;
					buyingType = "Power Up";
//					if (game.getCurrentShop().getPowerUpStockLevel()[5] > 0) {
//						game.getTeam().addPowerUp(game.getCurrentShop().getPowerUpItems().get(5));
//						game.getCurrentShop().getPowerUpStockLevel()[5] -= 1;
//						PUP6.setText(String.valueOf(game.getCurrentShop().getPowerUpStockLevel()[5]));
//					} else {
//						JOptionPane.showMessageDialog(null, "THIS ITEM IS OUT OF STOCK");
//					}
					break;
				case "Silver Tongue I":
					buyingItem = 6;
					buyingType = "Power Up";
//					if (game.getCurrentShop().getPowerUpStockLevel()[6] > 0) {
//						game.getTeam().addPowerUp(game.getCurrentShop().getPowerUpItems().get(6));
//						game.getCurrentShop().getPowerUpStockLevel()[6] -= 1;
//						PUP7.setText(String.valueOf(game.getCurrentShop().getPowerUpStockLevel()[6]));
//					} else {
//						JOptionPane.showMessageDialog(null, "THIS ITEM IS OUT OF STOCK");
//					}
					break;
				case "Silver Tongue II":
					buyingItem = 7;
					buyingType = "Power Up";
//					if (game.getCurrentShop().getPowerUpStockLevel()[7] > 0) {
//						game.getTeam().addPowerUp(game.getCurrentShop().getPowerUpItems().get(7));
//						game.getCurrentShop().getPowerUpStockLevel()[7] -= 1;
//						PUP8.setText(String.valueOf(game.getCurrentShop().getPowerUpStockLevel()[7]));
//					} else {
//						JOptionPane.showMessageDialog(null, "THIS ITEM IS OUT OF STOCK");
//					}
					break;
				case "Silver Tongue III":
					buyingItem = 8;
					buyingType = "Power Up";
//					if (game.getCurrentShop().getPowerUpStockLevel()[8] > 0) {
//						game.getTeam().addPowerUp(game.getCurrentShop().getPowerUpItems().get(8));
//						game.getCurrentShop().getPowerUpStockLevel()[8] -= 1;
//						PUP9.setText(String.valueOf(game.getCurrentShop().getPowerUpStockLevel()[8]));
//					} else {
//						JOptionPane.showMessageDialog(null, "THIS ITEM IS OUT OF STOCK");
//					}
					break;
				default:
					if (game.hasMap) {
						JOptionPane.showMessageDialog(null, "ONLY SOMEONE TRULY LOST\nNEEDS MORE THAN ONE MAP");
					} else {
						JOptionPane.showMessageDialog(null, "WISE PURCHASE TRAVELLER");//CAUSE ITS A MAP
					}
					
					buyingType = "Map";
				}
				if (buyingType == "Healing Potion") {
				if (game.getCurrentShop().getHealingStockLevel()[buyingItem] > 0) {
					if (game.getTeam().getMoney() > game.getCurrentShop().getHealingItems().get(buyingItem).getHealingItemPrice()) {
						game.getTeam().addHealingItem(game.getCurrentShop().getHealingItems().get(buyingItem));
						game.getCurrentShop().getHealingStockLevel()[buyingItem] -= 1;
//						HIT1.setText(String.valueOf(game.getCurrentShop().getHealingStockLevel()[buyingItem]));
						game.getTeam().addMoney(-game.getCurrentShop().getHealingItems().get(buyingItem).getHealingItemPrice());
						JOptionPane.showMessageDialog(null, "SUCESSFUL PURCHASE OF " + game.getCurrentShop().getHealingItems().get(buyingItem).getHealingItemName());
					} else {
						JOptionPane.showMessageDialog(null, "YOU DONT HAVE ENOUGH MONEY!");
					}
				} else {
					JOptionPane.showMessageDialog(null, "THIS ITEM IS OUT OF STOCK");
				}} else if (buyingType == "Power Up") {
					if (game.getCurrentShop().getPowerUpStockLevel()[buyingItem] > 0) {
						if (game.getTeam().getMoney() > game.getCurrentShop().getPowerUpItems().get(buyingItem).getPowerUpPrice()) {
							game.getTeam().addPowerUp(game.getCurrentShop().getPowerUpItems().get(buyingItem));
							game.getCurrentShop().getPowerUpStockLevel()[buyingItem] -= 1;
//							HIT1.setText(String.valueOf(game.getCurrentShop().getPowerUpStockLevel()[buyingItem]));
							game.getTeam().addMoney(-game.getCurrentShop().getPowerUpItems().get(buyingItem).getPowerUpPrice());
							JOptionPane.showMessageDialog(null, "SUCESSFUL PURCHASE OF " + game.getCurrentShop().getPowerUpItems().get(buyingItem).getPowerUpName());
						} else {
							JOptionPane.showMessageDialog(null, "YOU DONT HAVE ENOUGH MONEY!");
						}
					} else {
						JOptionPane.showMessageDialog(null, "THIS ITEM IS OUT OF STOCK");
					}
				} else {
					game.makeAllFound();
					game.hasMap = true;
				}
				frmHeroesVsVillains.getContentPane().removeAll();
				frmHeroesVsVillains.repaint();
				shopPanel();
				
			}
		});
		purchaseButton.setBounds(216, 534, 227, 70);
		frmHeroesVsVillains.getContentPane().add(purchaseButton);
		
		JLabel r1 = new JLabel("New label");
		r1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				
			}
		});
		r1.setBounds(216, 96, 53, 51);
		r1.setIcon(new ImageIcon(new ImageIcon(gameEnvGui.class.getResource("/Images/RestoreHealth1.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
		frmHeroesVsVillains.getContentPane().add(r1);
		
		JLabel r2 = new JLabel("New label");
		r2.setBounds(668, 95, 46, 52);
		r2.setIcon(new ImageIcon(new ImageIcon(gameEnvGui.class.getResource("/Images/RestoreHealth1.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
		frmHeroesVsVillains.getContentPane().add(r2);
		
		JLabel r3 = new JLabel("New label");
		r3.setBounds(434, 95, 46, 52);
		r3.setIcon(new ImageIcon(new ImageIcon(gameEnvGui.class.getResource("/Images/RestoreHealth1.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
		frmHeroesVsVillains.getContentPane().add(r3);
		
		JLabel p1 = new JLabel("New label");
		p1.setBounds(216, 224, 53, 51);
		frmHeroesVsVillains.getContentPane().add(p1);
		p1.setIcon(new ImageIcon(new ImageIcon(gameEnvGui.class.getResource("/Images/AugmentVitality1.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
		
		JLabel p2 = new JLabel("New label");
		p2.setBounds(434, 223, 46, 52);
		frmHeroesVsVillains.getContentPane().add(p2);
		p2.setIcon(new ImageIcon(new ImageIcon(gameEnvGui.class.getResource("/Images/AugmentVitality1.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
		
		JLabel p3 = new JLabel("New label");
		p3.setBounds(668, 223, 46, 52);
		frmHeroesVsVillains.getContentPane().add(p3);
		p3.setIcon(new ImageIcon(new ImageIcon(gameEnvGui.class.getResource("/Images/AugmentVitality1.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
		
		JLabel p5 = new JLabel("New label");
		p5.setBounds(434, 316, 46, 52);
		frmHeroesVsVillains.getContentPane().add(p5);
		p5.setIcon(new ImageIcon(new ImageIcon(gameEnvGui.class.getResource("/Images/IronFlesh1.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
		
		JLabel p4 = new JLabel("New label");
		p4.setBounds(216, 317, 53, 51);
		frmHeroesVsVillains.getContentPane().add(p4);
		p4.setIcon(new ImageIcon(new ImageIcon(gameEnvGui.class.getResource("/Images/IronFlesh1.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
		
		JLabel p6 = new JLabel("New label");
		p6.setBounds(668, 316, 46, 52);
		frmHeroesVsVillains.getContentPane().add(p6);
		p6.setIcon(new ImageIcon(new ImageIcon(gameEnvGui.class.getResource("/Images/IronFlesh1.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
		
		JLabel p8 = new JLabel("New label");
		p8.setBounds(434, 433, 46, 52);
		frmHeroesVsVillains.getContentPane().add(p8);
		p8.setIcon(new ImageIcon(new ImageIcon(gameEnvGui.class.getResource("/Images/SilverTongue1.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
		
		JLabel p7 = new JLabel("New label");
		p7.setBounds(216, 433, 53, 58);
		frmHeroesVsVillains.getContentPane().add(p7);
		p7.setIcon(new ImageIcon(new ImageIcon(gameEnvGui.class.getResource("/Images/SilverTongue1.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
		
		JLabel p9 = new JLabel("New label");
		p9.setBounds(668, 433, 46, 52);
		frmHeroesVsVillains.getContentPane().add(p9);
		p9.setIcon(new ImageIcon(new ImageIcon(gameEnvGui.class.getResource("/Images/SilverTongue1.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
		
		JButton buyMap = new JButton("Map");
		buyMap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				itemImg.setIcon(new ImageIcon(new ImageIcon(gameEnvGui.class.getResource("/Images/map.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
			}
		});
		buyMap.setBounds(21, 177, 104, 23);
		frmHeroesVsVillains.getContentPane().add(buyMap);
		
		JLabel lblSpecialItems = new JLabel("Special Items");
		lblSpecialItems.setBounds(32, 96, 117, 15);
		frmHeroesVsVillains.getContentPane().add(lblSpecialItems);
		
		JLabel mapLabel = new JLabel("New label");
		mapLabel.setBounds(45, 122, 53, 51);
		frmHeroesVsVillains.getContentPane().add(mapLabel);
		mapLabel.setIcon(new ImageIcon(new ImageIcon(gameEnvGui.class.getResource("/Images/map.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
		
		JLabel shelf = new JLabel("hello");
		shelf.setBounds(161, 419, 653, 113);
		shelf.setIcon(new ImageIcon(new ImageIcon(gameEnvGui.class.getResource("/Images/shelf.png")).getImage().getScaledInstance(620, 100, Image.SCALE_DEFAULT)));
		frmHeroesVsVillains.getContentPane().add(shelf);
		
		JLabel shelf2 = new JLabel("hello");
		shelf2.setBounds(163, 314, 651, 107);
		frmHeroesVsVillains.getContentPane().add(shelf2);
		shelf2.setIcon(new ImageIcon(new ImageIcon(gameEnvGui.class.getResource("/Images/shelf.png")).getImage().getScaledInstance(620, 100, Image.SCALE_DEFAULT)));
		
		JLabel shelf3 = new JLabel("hello");
		shelf3.setBounds(161, 205, 635, 109);
		frmHeroesVsVillains.getContentPane().add(shelf3);
		shelf3.setIcon(new ImageIcon(new ImageIcon(gameEnvGui.class.getResource("/Images/shelf.png")).getImage().getScaledInstance(620, 100, Image.SCALE_DEFAULT)));
		
		JLabel shelf4 = new JLabel("hello");
		shelf4.setBounds(161, 85, 635, 109);
		frmHeroesVsVillains.getContentPane().add(shelf4);
		shelf4.setIcon(new ImageIcon(new ImageIcon(gameEnvGui.class.getResource("/Images/shelf.png")).getImage().getScaledInstance(620, 100, Image.SCALE_DEFAULT)));
		
		JLabel lblInfo = new JLabel("Item Info");
		lblInfo.setBounds(32, 373, 70, 15);
		frmHeroesVsVillains.getContentPane().add(lblInfo);
		

		

		
	}
	
	private void paperScissorsRockPanel() {
//		ArrayList<String> villianOptions = new ArrayList<String>();
//		villianOptions.add("Paper");
//		villianOptions.add("Scissors");
//		villianOptions.add("Rock");
		paperScissorsRock paperGame = new paperScissorsRock();
		//int numOfGuesses = 0;
//		vill = numberGuess.getVillianChoice();
		frmHeroesVsVillains.getContentPane().setLayout(null);
		
		JLabel lblBattlingWith = new JLabel("Battling With ");
		lblBattlingWith.setBounds(373, 24, 269, 14);
		lblBattlingWith.setText("Battle With: " + game.getTeam().getHeroArray().get(0).getName());
		frmHeroesVsVillains.getContentPane().add(lblBattlingWith);
		
		JLabel lblResult = new JLabel("You Need To Roll The Dice First!");
		lblResult.setBounds(293, 137, 304, 55);
		frmHeroesVsVillains.getContentPane().add(lblResult);
		
		
		JLabel lblHero = new JLabel("hero1");
		lblHero.setBounds(56, 24, 46, 14);
		frmHeroesVsVillains.getContentPane().add(lblHero);
		
		
		JLabel lblHero_1 = new JLabel("hero2");
		lblHero_1.setBounds(56, 98, 46, 14);
		frmHeroesVsVillains.getContentPane().add(lblHero_1);
		
		JLabel lblHero_2 = new JLabel("hero3");
		lblHero_2.setBounds(56, 175, 46, 14);
		frmHeroesVsVillains.getContentPane().add(lblHero_2);
		
		
		JRadioButton char_1_box = new JRadioButton("");
		char_1_box.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblBattlingWith.setText("Battle With: " + game.getTeam().getHeroArray().get(0).getName());
				game.setCurrentHero(0);
			}
		});
		char_1_box.setBounds(66, 45, 97, 23);
		char_1_box.setSelected(true);
		frmHeroesVsVillains.getContentPane().add(char_1_box);
		
		JRadioButton char_2_box = new JRadioButton("");
		char_2_box.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblBattlingWith.setText("Battle With: " + game.getTeam().getHeroArray().get(1).getName());
				game.setCurrentHero(1);
			}
		});
		char_2_box.setBounds(66, 119, 97, 23);
		frmHeroesVsVillains.getContentPane().add(char_2_box);
		
		JRadioButton char_3_box = new JRadioButton("");
		char_3_box.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblBattlingWith.setText("Battle With: " + game.getTeam().getHeroArray().get(2).getName());
				game.setCurrentHero(2);
			}
		});
		char_3_box.setBounds(66, 196, 97, 23);
		frmHeroesVsVillains.getContentPane().add(char_3_box);
		
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
		frmHeroesVsVillains.getContentPane().setLayout(null);
		JButton btnViewStats_1 = new JButton("View Stats");
		btnViewStats_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, game.getTeam().toString());
			}
		});
		btnViewStats_1.setBounds(304, 458, 311, 126);
		frmHeroesVsVillains.getContentPane().add(btnViewStats_1);
		
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Paper", "Scissors", "Rock"}));
		comboBox.setBounds(383, 278, 105, 22);
		frmHeroesVsVillains.getContentPane().add(comboBox);
		
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
						frmHeroesVsVillains.getContentPane().removeAll();
						frmHeroesVsVillains.repaint();
						villianBeatPanel();
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
							frmHeroesVsVillains.getContentPane().removeAll();
							frmHeroesVsVillains.repaint();
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
		frmHeroesVsVillains.getContentPane().add(btnConfirmYourGuess);
		frmHeroesVsVillains.getContentPane().setLayout(null);
		
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
		frmHeroesVsVillains.getContentPane().setLayout(null);
	}
	
	
	private void powerUpDenPanel() {
		JLabel lblApplyTo = new JLabel("Apply To:");
		lblApplyTo.setBounds(422, 343, 70, 15);
		frmHeroesVsVillains.getContentPane().add(lblApplyTo);
		
		
		JLabel lblHero = new JLabel("hero1");
		lblHero.setBounds(246, 376, 46, 14);
		frmHeroesVsVillains.getContentPane().add(lblHero);
		
		JLabel lblHero_1 = new JLabel("hero2");
		lblHero_1.setBounds(442, 376, 46, 14);
		frmHeroesVsVillains.getContentPane().add(lblHero_1);
		
		JLabel lblHero_2 = new JLabel("hero3");
		lblHero_2.setBounds(628, 376, 46, 14);
		frmHeroesVsVillains.getContentPane().add(lblHero_2);
		
		
		JRadioButton char_1_box = new JRadioButton("");
		char_1_box.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblApplyTo.setText("Apply To: " + game.getTeam().getHeroArray().get(0).getName());
				game.setCurrentHero(0);
			}
		});
		char_1_box.setBounds(256, 398, 97, 23);
		char_1_box.setSelected(true);
		frmHeroesVsVillains.getContentPane().add(char_1_box);
		
		JRadioButton char_2_box = new JRadioButton("");
		char_2_box.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblApplyTo.setText("Apply To: " + game.getTeam().getHeroArray().get(1).getName());
				game.setCurrentHero(1);
			}
		});
		char_2_box.setBounds(452, 398, 97, 23);
		frmHeroesVsVillains.getContentPane().add(char_2_box);
		
		JRadioButton char_3_box = new JRadioButton("");
		char_3_box.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblApplyTo.setText("Apply To: " + game.getTeam().getHeroArray().get(2).getName());
				game.setCurrentHero(2);
			}
		});
		char_3_box.setBounds(638, 398, 97, 23);
		frmHeroesVsVillains.getContentPane().add(char_3_box);
		
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
		frmHeroesVsVillains.getContentPane().add(lblAvaiableHealingItems);
		
		JButton btnPUP1 = new JButton("Iron Flesh I");
		btnPUP1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedPowerUp = btnPUP1.getText();
			}
		});
		btnPUP1.setBounds(135, 55, 189, 58);
		frmHeroesVsVillains.getContentPane().add(btnPUP1);
		
		selectedPowerUp = btnPUP1.getText();
		
		JButton btnPUP2 = new JButton("Iron Flesh II");
		btnPUP2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedPowerUp = btnPUP2.getText();
			}
		});
		btnPUP2.setBounds(357, 55, 189, 58);
		frmHeroesVsVillains.getContentPane().add(btnPUP2);
		
		JButton btnPUP3 = new JButton("Iron Flesh III");
		btnPUP3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedPowerUp = btnPUP3.getText();
			}
		});
		btnPUP3.setBounds(571, 55, 189, 58);
		frmHeroesVsVillains.getContentPane().add(btnPUP3);
		
		JButton btnPUP4 = new JButton("Augment Vitality I");
		btnPUP4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedPowerUp = btnPUP4.getText();
			}
		});
		btnPUP4.setBounds(135, 152, 189, 58);
		frmHeroesVsVillains.getContentPane().add(btnPUP4);
		
		
		JButton btnPUP5 = new JButton("Augment Vitality II");
		btnPUP5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedPowerUp = btnPUP5.getText();
			}
		});
		btnPUP5.setBounds(357, 152, 189, 58);
		frmHeroesVsVillains.getContentPane().add(btnPUP5);
		
		JButton btnPUP6 = new JButton("Augment Vitality III");
		btnPUP6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedPowerUp = btnPUP6.getText();
			}
		});
		btnPUP6.setBounds(571, 152, 189, 58);
		frmHeroesVsVillains.getContentPane().add(btnPUP6);
		
		JButton btnPUP7 = new JButton("Silver Tongue I");
		btnPUP7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedPowerUp = btnPUP7.getText();
			}
		});
		btnPUP7.setBounds(135, 249, 189, 58);
		frmHeroesVsVillains.getContentPane().add(btnPUP7);
		
		JButton btnPUP8 = new JButton("Silver Tongue II");
		btnPUP8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedPowerUp = btnPUP8.getText();
			}
		});
		btnPUP8.setBounds(357, 249, 189, 58);
		frmHeroesVsVillains.getContentPane().add(btnPUP8);
		
		JButton btnPUP9 = new JButton("Silver Tongue III");
		btnPUP9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedPowerUp = btnPUP9.getText();
			}
		});
		btnPUP9.setBounds(571, 249, 189, 58);
		frmHeroesVsVillains.getContentPane().add(btnPUP9);
		
		
		
		JLabel stockPUP1 = new JLabel("New label");
		stockPUP1.setBounds(196, 125, 70, 15);
		frmHeroesVsVillains.getContentPane().add(stockPUP1);
		stockPUP1.setText(String.valueOf(Collections.frequency(game.getTeam().getPowerUps(), game.getCurrentShop().getPowerUpItems().get(0))));
		
		
		JLabel stockPUP2 = new JLabel("New label");
		stockPUP2.setBounds(423, 125, 70, 15);
		frmHeroesVsVillains.getContentPane().add(stockPUP2);
		stockPUP2.setText(String.valueOf(Collections.frequency(game.getTeam().getPowerUps(), game.getCurrentShop().getPowerUpItems().get(1))));
		
		JLabel stockPUP3 = new JLabel("New label");
		stockPUP3.setBounds(645, 125, 70, 15);
		frmHeroesVsVillains.getContentPane().add(stockPUP3);
		stockPUP3.setText(String.valueOf(Collections.frequency(game.getTeam().getPowerUps(), game.getCurrentShop().getPowerUpItems().get(2))));
		
		JLabel stockPUP4 = new JLabel("0");
		stockPUP4.setBounds(196, 222, 70, 15);
		frmHeroesVsVillains.getContentPane().add(stockPUP4);
		stockPUP4.setText(String.valueOf(Collections.frequency(game.getTeam().getPowerUps(), game.getCurrentShop().getPowerUpItems().get(3))));
		
		JLabel stockPUP5 = new JLabel("0");
		stockPUP5.setBounds(421, 222, 70, 15);
		frmHeroesVsVillains.getContentPane().add(stockPUP5);
		stockPUP5.setText(String.valueOf(Collections.frequency(game.getTeam().getPowerUps(), game.getCurrentShop().getPowerUpItems().get(4))));
		
		JLabel stockPUP6 = new JLabel("0");
		stockPUP6.setBounds(645, 222, 70, 15);
		frmHeroesVsVillains.getContentPane().add(stockPUP6);
		stockPUP6.setText(String.valueOf(Collections.frequency(game.getTeam().getPowerUps(), game.getCurrentShop().getPowerUpItems().get(5))));
		
		JLabel stockPUP7 = new JLabel("0");
		stockPUP7.setBounds(196, 319, 70, 15);
		frmHeroesVsVillains.getContentPane().add(stockPUP7);
		stockPUP7.setText(String.valueOf(Collections.frequency(game.getTeam().getPowerUps(), game.getCurrentShop().getPowerUpItems().get(6))));
		
		JLabel stockPUP8 = new JLabel("0");
		stockPUP8.setBounds(421, 319, 70, 15);
		frmHeroesVsVillains.getContentPane().add(stockPUP8);
		stockPUP8.setText(String.valueOf(Collections.frequency(game.getTeam().getPowerUps(), game.getCurrentShop().getPowerUpItems().get(7))));
		
		JLabel stockPUP9 = new JLabel("0");
		stockPUP9.setBounds(645, 319, 70, 15);
		frmHeroesVsVillains.getContentPane().add(stockPUP9);
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
					frmHeroesVsVillains.getContentPane().removeAll();
					frmHeroesVsVillains.repaint();
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
		frmHeroesVsVillains.getContentPane().add(btnNewButton_5);
		
		JButton btnExit_1 = new JButton("Exit");
		btnExit_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmHeroesVsVillains.getContentPane().removeAll();
				frmHeroesVsVillains.repaint();
				baseCampPanel();
			}
		});
		btnExit_1.setBounds(520, 452, 215, 100);
		frmHeroesVsVillains.getContentPane().add(btnExit_1);
		
		
		
		
		
		
	}
	
	private void teamInitializerPanel() {
		frmHeroesVsVillains.getContentPane().setLayout(null);
		
		JLabel lblNameHero = new JLabel("");
		lblNameHero.setFont(new Font("Arial Black", Font.ITALIC, 18));
		lblNameHero.setHorizontalAlignment(SwingConstants.CENTER);
		lblNameHero.setBounds(10, 401, 914, 49);
		frmHeroesVsVillains.getContentPane().add(lblNameHero);
		
		heroNameEntryBox = new JTextField(); 
		heroNameEntryBox.setHorizontalAlignment(SwingConstants.CENTER);
		heroNameEntryBox.setBounds(360, 462, 208, 31);
		frmHeroesVsVillains.getContentPane().add(heroNameEntryBox);
		heroNameEntryBox.setColumns(10);
		heroNameEntryBox.setEnabled(false);
		
		JLabel lblNameClashMessage = new JLabel("INVALID ENTRY: Another hero has taken this name; please enter a different name.");
		lblNameClashMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblNameClashMessage.setForeground(new Color(255, 0, 0));
		lblNameClashMessage.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNameClashMessage.setBounds(10, 365, 914, 25);
		frmHeroesVsVillains.getContentPane().add(lblNameClashMessage);
		lblNameClashMessage.setVisible(false);
		
		JButton btnAddToTeam = new JButton("");
		btnAddToTeam.setForeground(new Color(255, 255, 255));
		btnAddToTeam.setBackground(new Color(75, 0, 130));
		
		btnAddToTeam.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 28));
		btnAddToTeam.setBounds(360, 493, 208, 53);
		frmHeroesVsVillains.getContentPane().add(btnAddToTeam);
		
		btnAddToTeam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(game.getHeroList().size() >= 1) {
					
						boolean nameChecked = false;
						String name = heroNameEntryBox.getText();
					
						for (int i = 0; i < game.getHeroList().size(); i++) {
								if (name.equals(game.getHeroList().get(i).getName())) {
										lblNameClashMessage.setVisible(true);
										nameChecked = true;}}
					
						if (nameChecked == false) {
								heroToAdd.setHeroName(heroNameEntryBox.getText());
								game.getHeroList().add(heroToAdd);	
							
								// after it has added the char
								if (numOfHeroes == game.getHeroList().size()) {
										frmHeroesVsVillains.getContentPane().removeAll();
										frmHeroesVsVillains.repaint();
										teamNamePanel();} 
								else {
										frmHeroesVsVillains.getContentPane().removeAll();
										frmHeroesVsVillains.repaint();
										teamInitializerPanel();}}} 
				
				else {
						heroToAdd.setHeroName(heroNameEntryBox.getText());
						game.getHeroList().add(heroToAdd);
				
						// after it has added the char
						if (numOfHeroes == game.getHeroList().size()) {
								frmHeroesVsVillains.getContentPane().removeAll();
								frmHeroesVsVillains.repaint();
								teamNamePanel();} 
						else {
								frmHeroesVsVillains.getContentPane().removeAll();
								frmHeroesVsVillains.repaint();
								teamInitializerPanel();}
				}
			}
		});
		btnAddToTeam.setEnabled(false);
		
		
		
		
		JButton btnHeroType1 = new JButton("");
		btnHeroType1.setForeground(new Color(255, 255, 255));
		btnHeroType1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnHeroType1.setText("Choose");
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				btnHeroType1.setText("");
			}
		});
		btnHeroType1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNameHero.setText("NAME YOUR MERCHANT");
				heroNameEntryBox.setEnabled(true);
				btnAddToTeam.setEnabled(true);
				btnAddToTeam.setText("Add to team");
				heroToAdd = new MerchantMan();
			}
		});
		btnHeroType1.setBackground(Color.DARK_GRAY);
		btnHeroType1.setBounds(34, 169, 117, 126);
		frmHeroesVsVillains.getContentPane().add(btnHeroType1);
		
		
		
		
		JButton btnHeroType2 = new JButton("");
		btnHeroType2.setForeground(new Color(255, 255, 255));
		btnHeroType2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnHeroType2.setText("Choose");
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				btnHeroType2.setText("");
			}
		});
		btnHeroType2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNameHero.setText("NAME YOUR TANK");
				heroNameEntryBox.setEnabled(true);
				btnAddToTeam.setEnabled(true);
				btnAddToTeam.setText("Add to team");
				heroToAdd = new Tank();
			}
		});
		btnHeroType2.setBackground(Color.DARK_GRAY);
		btnHeroType2.setBounds(191, 169, 117, 126);
		frmHeroesVsVillains.getContentPane().add(btnHeroType2);
		
		
		
		
		JButton btnHeroType3 = new JButton("");
		btnHeroType3.setForeground(new Color(255, 255, 255));
		btnHeroType3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnHeroType3.setText("Choose");
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				btnHeroType3.setText("");
			}
		});
		btnHeroType3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNameHero.setText("NAME YOUR CARTOGRAPHER");
				heroNameEntryBox.setEnabled(true);
				btnAddToTeam.setEnabled(true);
				btnAddToTeam.setText("Add to team");
				heroToAdd = new Cartographer();
			}
		});
		btnHeroType3.setBackground(Color.DARK_GRAY);
		btnHeroType3.setBounds(338, 169, 117, 126);
		frmHeroesVsVillains.getContentPane().add(btnHeroType3);
		
		
		
		
		JButton btnHeroType4 = new JButton("");
		btnHeroType4.setForeground(new Color(255, 255, 255));
		btnHeroType4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnHeroType4.setText("Choose");
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				btnHeroType4.setText("");
			}
		});
		btnHeroType4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNameHero.setText("NAME YOUR SUPPORT");
				heroNameEntryBox.setEnabled(true);
				btnAddToTeam.setEnabled(true);
				btnAddToTeam.setText("Add to team");
				heroToAdd = new Support();
			}
		});
		btnHeroType4.setBackground(Color.DARK_GRAY);
		btnHeroType4.setBounds(484, 169, 117, 126);
		frmHeroesVsVillains.getContentPane().add(btnHeroType4);
		
		
		
		
		JButton btnHeroType5 = new JButton("");
		btnHeroType5.setForeground(new Color(255, 255, 255));
		btnHeroType5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnHeroType5.setText("Choose");
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				btnHeroType5.setText("");
			}
		});
		btnHeroType5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNameHero.setText("NAME YOUR LUCKY BOII");
				heroNameEntryBox.setEnabled(true);
				btnAddToTeam.setEnabled(true);
				btnAddToTeam.setText("Add to team");
				heroToAdd = new LuckyBoii();
			}
		});
		btnHeroType5.setBackground(Color.DARK_GRAY);
		btnHeroType5.setBounds(636, 169, 117, 126);
		frmHeroesVsVillains.getContentPane().add(btnHeroType5);
		
		
		
		
		JButton btnHeroType6 = new JButton("");
		btnHeroType6.setForeground(new Color(255, 255, 255));
		btnHeroType6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnHeroType6.setText("Choose");
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				btnHeroType6.setText("");
			}
		});
		btnHeroType6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNameHero.setText("NAME YOUR ANTI-HERO");
				heroNameEntryBox.setEnabled(true);
				btnAddToTeam.setEnabled(true);
				btnAddToTeam.setText("Add to team");
				heroToAdd = new EdgyScaryFiendLord();
			}
		});
		btnHeroType6.setBackground(Color.DARK_GRAY);
		btnHeroType6.setBounds(792, 169, 117, 126);
		frmHeroesVsVillains.getContentPane().add(btnHeroType6);
		
		
		
		
		ButtonGroup heroClassOptions = new ButtonGroup();
		heroClassOptions.add(btnHeroType1);
		heroClassOptions.add(btnHeroType2);
		heroClassOptions.add(btnHeroType3);
		heroClassOptions.add(btnHeroType4);
		heroClassOptions.add(btnHeroType5);
		heroClassOptions.add(btnHeroType6);
		
		
		
		
		JLabel lblMerchant = new JLabel("MERCHANT");
		lblMerchant.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMerchant.setHorizontalAlignment(SwingConstants.CENTER);
		lblMerchant.setBounds(34, 147, 117, 15);
		frmHeroesVsVillains.getContentPane().add(lblMerchant);
		
		JLabel lblTank = new JLabel("TANK");
		lblTank.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTank.setHorizontalAlignment(SwingConstants.CENTER);
		lblTank.setBounds(191, 148, 117, 15);
		frmHeroesVsVillains.getContentPane().add(lblTank);
		
		JLabel lblCartographer = new JLabel("CARTOGRAPHER");
		lblCartographer.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCartographer.setHorizontalAlignment(SwingConstants.CENTER);
		lblCartographer.setBounds(338, 148, 117, 15);
		frmHeroesVsVillains.getContentPane().add(lblCartographer);
		
		JLabel lblSupport = new JLabel("SUPPORT");
		lblSupport.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSupport.setHorizontalAlignment(SwingConstants.CENTER);
		lblSupport.setBounds(484, 148, 117, 15);
		frmHeroesVsVillains.getContentPane().add(lblSupport);
		
		JLabel lblLuckyboii = new JLabel("LUCKYBOII");
		lblLuckyboii.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblLuckyboii.setHorizontalAlignment(SwingConstants.CENTER);
		lblLuckyboii.setBounds(636, 148, 117, 15);
		frmHeroesVsVillains.getContentPane().add(lblLuckyboii);
		
		JLabel lblAntihero = new JLabel("ANTI HERO");
		lblAntihero.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAntihero.setHorizontalAlignment(SwingConstants.CENTER);
		lblAntihero.setBounds(792, 148, 117, 15);
		frmHeroesVsVillains.getContentPane().add(lblAntihero);

		JLabel lblSelectHeroesFor = new JLabel("CHOOSE  THE  CLASS  OF  THIS  HERO");
		lblSelectHeroesFor.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectHeroesFor.setFont(new Font("Arvo", Font.BOLD, 16));
		lblSelectHeroesFor.setBounds(10, 83, 914, 31);
		frmHeroesVsVillains.getContentPane().add(lblSelectHeroesFor);
		
		JLabel lblAssembleYourTeam = new JLabel("ASSEMBLE  YOUR  TEAM  OF  HEROES");
		lblAssembleYourTeam.setHorizontalAlignment(SwingConstants.CENTER);
		lblAssembleYourTeam.setFont(new Font("Arvo", Font.BOLD, 30));
		lblAssembleYourTeam.setBounds(10, 29, 914, 53);
		frmHeroesVsVillains.getContentPane().add(lblAssembleYourTeam);
		
		JButton btnMerchantInfo = new JButton("CLASS INFO");
		btnMerchantInfo.setForeground(new Color(255, 255, 255));
		btnMerchantInfo.setBackground(new Color(75, 0, 130));
		btnMerchantInfo.setBounds(34, 294, 117, 23);
		frmHeroesVsVillains.getContentPane().add(btnMerchantInfo);
		
		JButton btnTankInfo = new JButton("CLASS INFO");
		btnTankInfo.setBackground(new Color(75, 0, 130));
		btnTankInfo.setForeground(new Color(255, 255, 255));
		btnTankInfo.setBounds(191, 294, 117, 23);
		frmHeroesVsVillains.getContentPane().add(btnTankInfo);
		
		JButton btnCartographerInfo = new JButton("CLASS INFO");
		btnCartographerInfo.setForeground(new Color(255, 255, 255));
		btnCartographerInfo.setBackground(new Color(75, 0, 130));
		btnCartographerInfo.setBounds(338, 294, 117, 23);
		frmHeroesVsVillains.getContentPane().add(btnCartographerInfo);
		
		JButton btnSupportInfo = new JButton("CLASS INFO");
		btnSupportInfo.setForeground(new Color(255, 255, 255));
		btnSupportInfo.setBackground(new Color(75, 0, 130));
		btnSupportInfo.setBounds(484, 294, 117, 23);
		frmHeroesVsVillains.getContentPane().add(btnSupportInfo);
		
		JButton btnLuckyInfo = new JButton("CLASS INFO");
		btnLuckyInfo.setForeground(new Color(255, 255, 255));
		btnLuckyInfo.setBackground(new Color(75, 0, 130));
		btnLuckyInfo.setBounds(636, 294, 117, 23);
		frmHeroesVsVillains.getContentPane().add(btnLuckyInfo);
		
		JButton btnAntiHeroInfo = new JButton("CLASS INFO");
		btnAntiHeroInfo.setBackground(new Color(75, 0, 130));
		btnAntiHeroInfo.setForeground(new Color(255, 255, 255));
		btnAntiHeroInfo.setBounds(792, 294, 117, 23);
		frmHeroesVsVillains.getContentPane().add(btnAntiHeroInfo);
		
	}
	
	private void villianBeatPanel() {
		frmHeroesVsVillains.getContentPane().setLayout(null);
		JButton btnProceedToCamp = new JButton("PROCEED  TO  CAMP");
		btnProceedToCamp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "You Destroyed The Villian!");
				game.makeAllUnfound();
				citiesFinished += 1;
				frmHeroesVsVillains.getContentPane().removeAll();
				frmHeroesVsVillains.repaint();
				//game.setCurrentHero(citiesFinished);
				game.setCurrentVillian(citiesFinished);
				if (citiesFinished < game.getNumOfCities()) {
					baseCampPanel();
				} else {
					finalVillianPanel();
				}
			}
		});
		btnProceedToCamp.setFont(new Font("Dialog", Font.BOLD, 22));
		btnProceedToCamp.setBounds(287, 503, 339, 88);
		frmHeroesVsVillains.getContentPane().add(btnProceedToCamp);
	}
	
	private void finalVillianPanel() {
		frmHeroesVsVillains.getContentPane().setLayout(null);
	}
}

