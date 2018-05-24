package cityStuff;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JToolTip;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import games.diceRollGame;
import games.numberGuess;
import games.paperScissorsRock;
import teamStuff.Cartographer;
import teamStuff.EdgyScaryFiendLord;
import teamStuff.HealingItem;
import teamStuff.Hero;
import teamStuff.LuckyBoii;
import teamStuff.MerchantMan;
import teamStuff.PowerUp;
import teamStuff.Support;
import teamStuff.Tank;

public class gameEnvGui {
	private int selectedItemPrice;
	private static int luckynumDice = 0;
	private static int luckynumGuess = 1;
	private static int luckynumPSR = 3;
	private static int buyingItem;
	private static String buyingType;
	private static String selectedHealingItem;
	private static String selectedPowerUp = "noItem";
	private static int citiesFinished = 0;
	private static int numOfGuesses = 0;
	private static int numOfHeroes;
	private static int vill;
	private Hero heroToAdd;
	private gameEnvironmentGuiRunTime game = new gameEnvironmentGuiRunTime();
	private JFrame frame;
	private JTextField textField;
	private JTextField heroNameEntryBox;
	private JTextField teamNameEntryBox;
	private Timer timer = new Timer();
	private int gameTime = 0;
	private boolean finished = false;
	public HealingItem current;
    private JProgressBar pb;
    private JDialog dialog;


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
		gameStartPanel();
//		lossGamePanel();
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
//		finishGamePanel();
//		gameEndPane/l();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Heroes vs. Villains");
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 940, 642);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		
		
	}
	
	private void gameStartPanel() {
		frame.getContentPane().setLayout(null);
		JLabel frontPageTitle = new JLabel("HEROES  VS  VILLAINS");
		frontPageTitle.setForeground(new Color(0, 0, 0));
		frontPageTitle.setFont(new Font("Arvo", Font.BOLD | Font.ITALIC, 60));
		frontPageTitle.setHorizontalAlignment(SwingConstants.CENTER);
		frontPageTitle.setBounds(12, 44, 914, 82);
		frame.getContentPane().add(frontPageTitle);
		
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
		frame.getContentPane().add(btnQuitGame);
		
		JButton btnPlayGame = new JButton("PLAY");
		btnPlayGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				frame.repaint();
				cityAmmountPanel();
			}
		});
		btnPlayGame.setBackground(new Color(75, 0, 130));
		btnPlayGame.setForeground(new Color(255, 255, 255));
		btnPlayGame.setFont(new Font("Dialog", Font.BOLD, 70));
		btnPlayGame.setBounds(313, 280, 319, 129);
		frame.getContentPane().add(btnPlayGame);
		
		JLabel frontPageBackGround = new JLabel("");
		frontPageBackGround.setIcon(new ImageIcon(new ImageIcon(gameEnvGui.class.getResource("/Images/StartScreenArt.png")).getImage().getScaledInstance(940, 642, Image.SCALE_DEFAULT)));
		frontPageBackGround.setBounds(0, 0, 938, 616);
		frame.getContentPane().add(frontPageBackGround);
		
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
//				setFinished(true); //MOVE TO finishGamePanel()
//				gameEndPanel();    //MOVE TO finishGamePanel()
				
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
				}
				else {
					game.getTeam().nameTeam(teamNameEntryBox.getText());
					lblTeamNameError.setVisible(false);
					btnProceedToCamp.setVisible(true);
					lblBeginQuest.setText("Go forth, " + game.getTeam().getName() + ", and vanquish darstardly villains, who've many cities under their rule!");
				}
			}
		});
		btnSubmitTeamName.setBounds(371, 318, 177, 25);
		frame.getContentPane().add(btnSubmitTeamName);
	}
	
	
	
	
	
	
	//______________________________________________________
	//                     TIMER STUFF
	//______________________________________________________
	
	private boolean getFinished() {
		return finished;
	}
	
	private void setFinished(boolean state) {
		finished = state;
	}
	
	private int getGameTime() {
		return gameTime;
	}
	
	private void startTiming() {
		
		TimerTask timeGame = new TimerTask() {
			public void run() {
				gameTime++;
				getFinished();
				if(getFinished() == true) {
					cancel();
				}
			}
		};
		timer.scheduleAtFixedRate(timeGame, 1000, 1000);
	}
	
	//_______________________________________________________
	
	
	
	
	
	private void baseCampPanel() {
		
		frame.getContentPane().setLayout(null);
		
//		CHECKING IF THE TEAM HAS A MAP
		if (game.hasMap()) {
			game.makeAllFound();
		}
		
		JButton viewInventory = new JButton("View Inventory");
		viewInventory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, game.getTeam().viewInventory());
			}
		});
		viewInventory.setBounds(55, 478, 165, 91);
		frame.getContentPane().add(viewInventory);
		
		JButton viewStats = new JButton("View Stats");
		viewStats.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, game.getTeam().toString());
			}
		});
		viewStats.setBounds(384, 478, 165, 91);
		frame.getContentPane().add(viewStats);
		
		JButton exitGame = new JButton("Exit Game");
		exitGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		exitGame.setBounds(708, 478, 165, 91);
		frame.getContentPane().add(exitGame);
		
		JButton btnNorth = new JButton("North");
		btnNorth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
						hospitalPanel();
						break;
				}
			}
		});
		btnNorth.setBounds(384, 43, 152, 25);
		frame.getContentPane().add(btnNorth);
		btnNorth.setText(game.getMapPlace(0,citiesFinished));
		
		
		
		
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
						hospitalPanel();
						break;
				}
			}
		});
		btnEast.setBounds(708, 212, 146, 25);
		frame.getContentPane().add(btnEast);
		btnEast.setText(game.getMapPlace(1,citiesFinished));
		
		
		
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
						hospitalPanel();
						break;
				}
			}
		});
		btnSouth.setBounds(384, 385, 152, 25);
		frame.getContentPane().add(btnSouth);
		btnSouth.setText(game.getMapPlace(2,citiesFinished));
		
		
		
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
						hospitalPanel();
						break;
				}
			}
		});
		btnWest.setBounds(74, 212, 146, 25);
		frame.getContentPane().add(btnWest);
		btnWest.setText(game.getMapPlace(3,citiesFinished));
		
		JLabel compass = new JLabel("");
		compass.setIcon(new ImageIcon(new ImageIcon(gameEnvGui.class.getResource("/Images/compass.png")).getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT)));
		compass.setBounds(0, 0, 200, 183);
		frame.getContentPane().add(compass);
		
		JLabel baseCampBackGround = new JLabel("New label");
		baseCampBackGround.setIcon(new ImageIcon(new ImageIcon(gameEnvGui.class.getResource("/Images/finalBackground.jpg")).getImage().getScaledInstance(940, 642, Image.SCALE_DEFAULT)));
		baseCampBackGround.setBounds(0, -64, 949, 740);
		frame.getContentPane().add(baseCampBackGround);
	}
	
	private void cityAmmountPanel() {
		frame.getContentPane().setLayout(null);
		JLabel lblHowManyCities = new JLabel("How Many Cities Would You Like To Save?");
		lblHowManyCities.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblHowManyCities.setHorizontalAlignment(SwingConstants.CENTER);
		lblHowManyCities.setBounds(10, 43, 914, 61);
		frame.getContentPane().add(lblHowManyCities);
		
		JComboBox numOfCitiesCombo = new JComboBox();
		numOfCitiesCombo.setFont(new Font("Tahoma", Font.BOLD, 30));
		numOfCitiesCombo.setModel(new DefaultComboBoxModel(new String[] {"3", "4", "5", "6"}));
		numOfCitiesCombo.setBounds(419, 115, 50, 41);

		frame.getContentPane().add(numOfCitiesCombo);
		
		JComboBox numOfHeroesCombo = new JComboBox();
		numOfHeroesCombo.setFont(new Font("Tahoma", Font.BOLD, 30));
		numOfHeroesCombo.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3"}));
		numOfHeroesCombo.setBounds(419, 290, 50, 41);
		frame.getContentPane().add(numOfHeroesCombo);
		
		JButton confirmButton = new JButton("Confirm");
		confirmButton.setFont(new Font("Tahoma", Font.BOLD, 30));
		confirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String i = (String)numOfCitiesCombo.getSelectedItem();
				int num;
				try {
					num = Integer.parseInt(i);
				} catch (Exception lala) {
					num = 3;
				}
				String k = (String)numOfHeroesCombo.getSelectedItem();
				try {
					numOfHeroes = Integer.parseInt(k);
				} catch (Exception lala) {
					numOfHeroes = 1;
				}
				game.setNumOfCities(num);
				game.generateVillians(num);
				game.setCurrentVillian(0);
				game.setThingsUp(num);
				for (int l = 0; l != num; l++) {
					ArrayList<String> map = game.generateLayout();
					game.addBaseCamp(map);
				}
				game.setCurrentShop(0);
				startTiming();
				frame.getContentPane().removeAll();
				frame.repaint();
				teamInitializerPanel();
			}
		});
		confirmButton.setBounds(358, 485, 171, 86);
		
		frame.getContentPane().add(confirmButton);
		
		JLabel lblHowManyHeroes = new JLabel("How Many Heroes Would You Like? ");
		lblHowManyHeroes.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblHowManyHeroes.setHorizontalAlignment(SwingConstants.CENTER);
		lblHowManyHeroes.setBounds(10, 238, 914, 41);
		frame.getContentPane().add(lblHowManyHeroes);
		JLabel playthroughTime = new JLabel("YOUR TIMED PLAY-THROUGH WILL BEGIN UPON CONFIRMATION");
		playthroughTime.setFont(new Font("Dialog", Font.BOLD, 18));
		playthroughTime.setHorizontalAlignment(SwingConstants.CENTER);
		playthroughTime.setBounds(12, 404, 912, 69);
		frame.getContentPane().add(playthroughTime);
		
		
	}
	
	
	private void villiansLairPanel() {
		frame.getContentPane().setLayout(null);
		JButton fleeFromLair = new JButton("Flee From The Lair");
		fleeFromLair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, game.randomEvent());
				frame.getContentPane().removeAll();
				frame.repaint();
				baseCampPanel();
			}
		});
		fleeFromLair.setBounds(162, 420, 652, 73);
		frame.getContentPane().add(fleeFromLair);
		
		JButton btnBattleTheVillian = new JButton("Battle The Villian");
		btnBattleTheVillian.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (game.getCurrentVillian().hasFavGame() == true) {
					JOptionPane.showMessageDialog(null, "VILLIAN: TIME TO PLAY MY FAVOURITE GAME\nYOU: OH STINKERS!");
					frame.getContentPane().removeAll();
					frame.repaint();
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
					frame.getContentPane().removeAll();
					frame.repaint();
					battleSelectionPanel();
				}
				
			}
		});
		btnBattleTheVillian.setBounds(162, 518, 647, 73);
		frame.getContentPane().add(btnBattleTheVillian);
		
		JLabel VillianName = new JLabel("New label");
		VillianName.setHorizontalAlignment(SwingConstants.CENTER);
		VillianName.setFont(new Font("Arvo", Font.BOLD, 27));
		VillianName.setForeground(Color.RED);
		VillianName.setBounds(284, 12, 358, 27);
		frame.getContentPane().add(VillianName);
		VillianName.setText(game.getCurrentVillian().getName());
		
		JLabel catchPhrase = new JLabel("New label");
		catchPhrase.setBounds(490, 168, 140, 15);
		frame.getContentPane().add(catchPhrase);
		catchPhrase.setText(game.getCurrentVillian().getTaunt());
		
		
		JLabel villianIcon = new JLabel("");
		villianIcon.setBounds(162, -60, 698, 481);
		frame.getContentPane().add(villianIcon);
		villianIcon.setIcon(game.getCurrentVillian().getIcon());
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(0, 0, 938, 616);
		frame.getContentPane().add(lblNewLabel_2);
		lblNewLabel_2.setIcon(new ImageIcon(new ImageIcon(gameEnvGui.class.getResource("/Images/lairWall.png")).getImage().getScaledInstance(940, 642, Image.SCALE_DEFAULT)));
		
	}
	
	private void battleSelectionPanel() {
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().setLayout(null);
		JButton paperScissorsRock = new JButton("Paper Scissors Rock");
		paperScissorsRock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				frame.repaint();
				paperScissorsRockPanel();
			}
		});
		paperScissorsRock.setBounds(85, 388, 179, 46);
		frame.getContentPane().add(paperScissorsRock);
		
		
		JLabel PSR = new JLabel("");
		PSR.setBounds(53, 176, 272, 200);
		frame.getContentPane().add(PSR);
		PSR.setIcon(new ImageIcon(new ImageIcon(gameEnvGui.class.getResource("/Images/paperScissorsRock.png")).getImage().getScaledInstance(250, 150, Image.SCALE_DEFAULT)));

		
		
		JLabel guessRanNum = new JLabel("");
		guessRanNum.setBounds(337, 176, 230, 200);
		frame.getContentPane().add(guessRanNum);
		guessRanNum.setIcon(new ImageIcon(new ImageIcon(gameEnvGui.class.getResource("/Images/GRN.png")).getImage().getScaledInstance(250, 150, Image.SCALE_DEFAULT)));
		
		JLabel diceRoll = new JLabel("");
		diceRoll.setBounds(661, 205, 158, 171);
		frame.getContentPane().add(diceRoll);
		diceRoll.setIcon(new ImageIcon(new ImageIcon(gameEnvGui.class.getResource("/Images/DICE.png")).getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT)));

		
		JButton GuessTheRandom = new JButton("Guess The Random Number");
		GuessTheRandom.setBounds(334, 388, 233, 46);
		GuessTheRandom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				frame.repaint();
				numberGuessPanel();
			}
		});
		frame.getContentPane().add(GuessTheRandom);
		
		JButton btnRollTheDice = new JButton("Roll The Dice");
		btnRollTheDice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				frame.repaint();
				diceRollPanel();
			}
		});
		btnRollTheDice.setBounds(640, 388, 179, 46);
		frame.getContentPane().add(btnRollTheDice);
		
		JLabel lblChooseYourDoom = new JLabel("CHOOSE    YOUR    DOOM");
		lblChooseYourDoom.setHorizontalAlignment(SwingConstants.CENTER);
		lblChooseYourDoom.setFont(new Font("Arvo", Font.BOLD, 30));
		lblChooseYourDoom.setBounds(0, 32, 914, 53);
		frame.getContentPane().add(lblChooseYourDoom);
		

	}
	
	private void diceRollPanel() {
		diceRollGame diceGame = new diceRollGame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		if (game.hasLuck()) {
			luckynumDice = 3;
		}
		frame.getContentPane().setLayout(null);
		JLabel lblBattlingWith = new JLabel("Battling With ");
		lblBattlingWith.setHorizontalAlignment(SwingConstants.CENTER);
		lblBattlingWith.setBounds(324, 263, 269, 14);
		lblBattlingWith.setText("Battle With: " + game.getTeam().getHeroArray().get(0).getName());
		frame.getContentPane().add(lblBattlingWith);
		
		JLabel hero1Name = new JLabel("hero1");
		hero1Name.setHorizontalAlignment(SwingConstants.CENTER);
		hero1Name.setBounds(195, 12, 167, 51);
		frame.getContentPane().add(hero1Name);
		
		
		JLabel hero2Name = new JLabel("hero2");
		hero2Name.setHorizontalAlignment(SwingConstants.CENTER);
		hero2Name.setBounds(374, 12, 164, 51);
		frame.getContentPane().add(hero2Name);
		
		JLabel hero13Name = new JLabel("hero3");
		hero13Name.setHorizontalAlignment(SwingConstants.CENTER);
		hero13Name.setBounds(568, 12, 155, 51);
		frame.getContentPane().add(hero13Name);
		
		
		JRadioButton char_1_box = new JRadioButton("");
		char_1_box.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblBattlingWith.setText("Battle With: " + game.getTeam().getHeroArray().get(0).getName());
				game.setCurrentHero(0);
				
			}
		});
		char_1_box.setBounds(265, 232, 97, 23);
		char_1_box.setBackground(null);
		frame.getContentPane().add(char_1_box);
		
		JRadioButton char_2_box = new JRadioButton("");
		char_2_box.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblBattlingWith.setText("Battle With: " + game.getTeam().getHeroArray().get(1).getName());
				game.setCurrentHero(1);
			}
		});
		char_2_box.setBounds(445, 232, 97, 23);
		frame.getContentPane().add(char_2_box);
		char_2_box.setBackground(null);
		
		JRadioButton char_3_box = new JRadioButton("");
		char_3_box.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblBattlingWith.setText("Battle With: " + game.getTeam().getHeroArray().get(2).getName());
				game.setCurrentHero(2);
			}
		});
		char_3_box.setBounds(626, 232, 97, 23);
		frame.getContentPane().add(char_3_box);
		char_3_box.setBackground(null);
		
		JLabel HERO1 = new JLabel("");
		HERO1.setBounds(216, 75, 112, 149);
		frame.getContentPane().add(HERO1);
		
		JLabel HERO2 = new JLabel("");
		HERO2.setBounds(398, 75, 107, 149);
		frame.getContentPane().add(HERO2);
		
		JLabel HERO3 = new JLabel("");
		HERO3.setBounds(582, 75, 112, 149);
		frame.getContentPane().add(HERO3);
		

		try {
			System.out.println("h3" + game.getTeam().getHeroArray().get(2).getCurrentHealth());
			if (game.getTeam().getHeroArray().get(2).getCurrentHealth() > 0) {
				hero13Name.setText(game.getTeam().getHeroArray().get(2).getName());
				HERO3.setIcon(game.getTeam().getHeroArray().get(2).getIcon());
				char_3_box.setSelected(true);
				game.setCurrentHero(2);
				lblBattlingWith.setText("Battle With: " + game.getTeam().getHeroArray().get(2).getName());
			} else {
				hero13Name.setVisible(false);
				char_3_box.setVisible(false);
				HERO3.setVisible(false);
			}
		} catch (Exception noName0) {
			hero13Name.setVisible(false);
			char_3_box.setVisible(false);
			HERO3.setVisible(false);
		}
		try {
			System.out.println("h2" + game.getTeam().getHeroArray().get(1).getCurrentHealth());
			if (game.getTeam().getHeroArray().get(1).getCurrentHealth() > 0) {
				hero2Name.setText(game.getTeam().getHeroArray().get(1).getName());
				HERO2.setIcon(game.getTeam().getHeroArray().get(1).getIcon());
				char_2_box.setSelected(true);
				game.setCurrentHero(1);
				lblBattlingWith.setText("Battle With: " + game.getTeam().getHeroArray().get(1).getName());
			} else {
				hero2Name.setVisible(false);
				char_2_box.setVisible(false);
				HERO2.setVisible(false);
			}
		} catch (Exception noName0) {
			hero2Name.setVisible(false);
			char_2_box.setVisible(false);
			HERO2.setVisible(false);
		}
		try {
			System.out.println("h1" + game.getTeam().getHeroArray().get(0).getCurrentHealth());
			if (game.getTeam().getHeroArray().get(0).getCurrentHealth() > 0) {
				hero1Name.setText(game.getTeam().getHeroArray().get(0).getName());
				HERO1.setIcon(game.getTeam().getHeroArray().get(0).getIcon());
				char_1_box.setSelected(true);
				game.setCurrentHero(0);
				lblBattlingWith.setText("Battle With: " + game.getTeam().getHeroArray().get(0).getName());
			} else {
				hero1Name.setVisible(false);
				char_1_box.setVisible(false);
				HERO1.setVisible(false);
			}
		} catch (Exception noName0) {
			hero1Name.setVisible(false);
			char_1_box.setVisible(false);
			HERO1.setVisible(false);
		}
		
		
		ButtonGroup charsForBattle = new ButtonGroup();
		charsForBattle.add(char_1_box);
		charsForBattle.add(char_2_box);
		charsForBattle.add(char_3_box);
		
		JLabel resultCalc = new JLabel("ROLL THE DICE");
		resultCalc.setHorizontalAlignment(SwingConstants.CENTER);
		resultCalc.setFont(new Font("Arvo", Font.BOLD, 30));
		resultCalc.setBounds(12, 293, 914, 75);
		frame.getContentPane().add(resultCalc);
		
		
		JLabel RESULT = new JLabel("");
		RESULT.setHorizontalAlignment(SwingConstants.CENTER);
		RESULT.setFont(new Font("Arvo", Font.BOLD, 30));
		RESULT.setBounds(12, 380, 914, 75);
		frame.getContentPane().add(RESULT);
		
		JLabel numOfWins = new JLabel("");
		numOfWins.setHorizontalAlignment(SwingConstants.CENTER);
		numOfWins.setFont(new Font("Arvo", Font.BOLD, 30));
		numOfWins.setBounds(22, 55, 130, 75);
		frame.getContentPane().add(numOfWins);
		numOfWins.setText(String.valueOf(game.getCurrentVillian().getLossCount()));
		
		JButton btnRollDice = new JButton("Roll Dice");
		btnRollDice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int hero = diceGame.getHeroRoll(luckynumDice);
				int vill = diceGame.getVillianRoll();
				String outcomes = "HERO ROLL: " + hero + "     |     VILLIAN ROLL: " + vill;
				resultCalc.setText(outcomes);
				String result = diceGame.calculateWinnerGui(hero, vill);
				RESULT.setText(result);
				if (hero > vill) {
					game.getCurrentVillian().oneDefeat();
					numOfWins.setText(String.valueOf(game.getCurrentVillian().getLossCount()));
					if (game.getCurrentVillian().getLossCount() == game.getCurrentVillian().getTimesToBeat()) {
						frame.getContentPane().removeAll();
						frame.repaint();
						villianBeatPanel();
					} else if (game.getCurrentVillian().changesTheGame() == true){
						Random rand = new Random();
						int newGame = rand.nextInt(3);
						frame.getContentPane().removeAll();
						frame.repaint();
						if (newGame == 0) {
							paperScissorsRockPanel();
						} else if (newGame == 1){
							numberGuessPanel();
						} else {
							diceRollPanel();
						}
					}
				} else if (hero < vill) {
					if (game.getTeam().getHeroArray().get(game.getCurrentHero()).getCurrentHealth() - game.getCurrentVillian().getDamageAmmount() <= 0) {
						game.getTeam().getHeroArray().get(game.getCurrentHero()).damageHealth(game.getCurrentVillian().getDamageAmmount());
						JOptionPane.showMessageDialog(null, "Your Hero Is Dead!");
						if (game.getCurrentHero() == 0) {
							hero1Name.setVisible(false);
							char_1_box.setVisible(false);
							HERO1.setVisible(false);
						} else if (game.getCurrentHero() == 1) {
							hero2Name.setVisible(false);
							char_2_box.setVisible(false);
							HERO2.setVisible(false);
						} else {
							hero13Name.setVisible(false);
							char_3_box.setVisible(false);
							HERO3.setVisible(false);
						}
						int stillAliveChar = 999;
						for (int i = 0; i < game.getTeam().getHeroArray().size(); i++) {
							if (game.getTeam().getHeroArray().get(i).getCurrentHealth() > 0) {
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
						JOptionPane.showMessageDialog(null, "Your Hero Takes " + game.getCurrentVillian().getDamageAmmount() + " Damage");
						game.getTeam().getHeroArray().get(game.getCurrentHero()).damageHealth(game.getCurrentVillian().getDamageAmmount());//method works if there is only 1 person in the team, however when there are 2 or more then a person  gets removed and the array shrinks but doesnt go into the catch
					}
				}
			}
		});
		btnRollDice.setBounds(119, 463, 311, 75);
		frame.getContentPane().add(btnRollDice);
		
		JButton btnViewStats = new JButton("View Stats");
		btnViewStats.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, game.getTeam().toString());
			}
		});
		btnViewStats.setBounds(499, 463, 311, 75);
		frame.getContentPane().add(btnViewStats);
		
		JLabel lblWins = new JLabel("WINS");
		lblWins.setHorizontalAlignment(SwingConstants.CENTER);
		lblWins.setFont(new Font("Arvo", Font.BOLD, 30));
		lblWins.setBounds(22, 12, 130, 75);
		frame.getContentPane().add(lblWins);

		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(0, 0, 926, 604);
		frame.getContentPane().add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon(new ImageIcon(gameEnvGui.class.getResource("/Images/diceBG.png")).getImage().getScaledInstance(950, 620, Image.SCALE_DEFAULT)));

		

		
	}
	
	private void numberGuessPanel() {
		numberGuess numberGame = new numberGuess();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		if (game.hasLuck()) {
			luckynumGuess = 4;
		}
		vill = numberGame.getVillianChoice(luckynumGuess);
		frame.getContentPane().setLayout(null);
		JLabel lblWhatsYourGuess = new JLabel("Select Your Guess");
		lblWhatsYourGuess.setBounds(399, 371, 160, 14);
		frame.getContentPane().add(lblWhatsYourGuess);
		
		JLabel lblBattlingWith = new JLabel("Battling With ");
		lblBattlingWith.setFont(new Font("Dialog", Font.BOLD, 17));
		lblBattlingWith.setHorizontalAlignment(SwingConstants.CENTER);
		lblBattlingWith.setBounds(325, 262, 269, 14);
		frame.getContentPane().add(lblBattlingWith);
		
		JComboBox numberOptionsCombo = new JComboBox();
		if (game.hasLuck()) {
			numberOptionsCombo.setModel(new DefaultComboBoxModel(new String[] {"5", "6", "7", "8", "9", "10"}));
		} else {
			numberOptionsCombo.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		}
		
		numberOptionsCombo.setBounds(429, 397, 65, 22);
		frame.getContentPane().add(numberOptionsCombo);
		
		JLabel lblResult = new JLabel("GUESS A NUMBER");
		lblResult.setHorizontalAlignment(SwingConstants.CENTER);
		lblResult.setFont(new Font("Arvo", Font.BOLD, 30));
		lblResult.setBounds(12, 261, 914, 98);
		frame.getContentPane().add(lblResult);
		
		
		JLabel hero1name = new JLabel("hero1");
		hero1name.setHorizontalAlignment(SwingConstants.CENTER);
		hero1name.setBounds(205, 12, 125, 14);
		frame.getContentPane().add(hero1name);
		
		
		JLabel hero2name = new JLabel("hero2");
		hero2name.setHorizontalAlignment(SwingConstants.CENTER);
		hero2name.setBounds(387, 12, 125, 14);
		frame.getContentPane().add(hero2name);
		
		JLabel hero3name = new JLabel("hero3");
		hero3name.setHorizontalAlignment(SwingConstants.CENTER);
		hero3name.setBounds(571, 12, 119, 14);
		frame.getContentPane().add(hero3name);
		
		
		JRadioButton char_1_box = new JRadioButton("");
		char_1_box.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblBattlingWith.setText("Battle With: " + game.getTeam().getHeroArray().get(0).getName());
				game.setCurrentHero(0);
			}
		});
		char_1_box.setBounds(261, 202, 97, 23);
		char_1_box.setBackground(null);
		frame.getContentPane().add(char_1_box);
		
		JRadioButton char_2_box = new JRadioButton("");
		char_2_box.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblBattlingWith.setText("Battle With: " + game.getTeam().getHeroArray().get(1).getName());
				game.setCurrentHero(1);
			}
		});
		char_2_box.setBounds(441, 202, 97, 23);
		frame.getContentPane().add(char_2_box);
		char_2_box.setBackground(null);
		
		JRadioButton char_3_box = new JRadioButton("");
		char_3_box.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblBattlingWith.setText("Battle With: " + game.getTeam().getHeroArray().get(2).getName());
				game.setCurrentHero(2);
			}
		});
		char_3_box.setBounds(622, 202, 97, 23);
		frame.getContentPane().add(char_3_box);
		char_3_box.setBackground(null);
		
		JLabel HERO1 = new JLabel("");
		HERO1.setBounds(212, 45, 112, 149);
		frame.getContentPane().add(HERO1);
		
		JLabel HERO2 = new JLabel("");
		HERO2.setBounds(394, 45, 107, 149);
		frame.getContentPane().add(HERO2);
		
		JLabel HERO3 = new JLabel("");
		HERO3.setBounds(578, 45, 112, 149);
		frame.getContentPane().add(HERO3);
		
		try {
			System.out.println("h3" + game.getTeam().getHeroArray().get(2).getCurrentHealth());
			if (game.getTeam().getHeroArray().get(2).getCurrentHealth() > 0) {
				hero3name.setText(game.getTeam().getHeroArray().get(2).getName());
				HERO3.setIcon(game.getTeam().getHeroArray().get(2).getIcon());
				char_3_box.setSelected(true);
				game.setCurrentHero(2);
				lblBattlingWith.setText("Battle With: " + game.getTeam().getHeroArray().get(2).getName());
			} else {
				hero3name.setVisible(false);
				char_3_box.setVisible(false);
				HERO3.setVisible(false);
			}
		} catch (Exception noName0) {
			hero3name.setVisible(false);
			char_3_box.setVisible(false);
			HERO3.setVisible(false);
		}
		try {
			System.out.println("h2" + game.getTeam().getHeroArray().get(1).getCurrentHealth());
			if (game.getTeam().getHeroArray().get(1).getCurrentHealth() > 0) {
				hero2name.setText(game.getTeam().getHeroArray().get(1).getName());
				HERO2.setIcon(game.getTeam().getHeroArray().get(1).getIcon());
				char_2_box.setSelected(true);
				game.setCurrentHero(1);
				lblBattlingWith.setText("Battle With: " + game.getTeam().getHeroArray().get(1).getName());
			} else {
				hero2name.setVisible(false);
				char_2_box.setVisible(false);
				HERO2.setVisible(false);
			}
		} catch (Exception noName0) {
			hero2name.setVisible(false);
			char_2_box.setVisible(false);
			HERO2.setVisible(false);
		}
		try {
			System.out.println("h1" + game.getTeam().getHeroArray().get(0).getCurrentHealth());
			if (game.getTeam().getHeroArray().get(0).getCurrentHealth() > 0) {
				hero1name.setText(game.getTeam().getHeroArray().get(0).getName());
				HERO1.setIcon(game.getTeam().getHeroArray().get(0).getIcon());
				char_1_box.setSelected(true);
				game.setCurrentHero(0);
				lblBattlingWith.setText("Battle With: " + game.getTeam().getHeroArray().get(0).getName());
			} else {
				hero1name.setVisible(false);
				char_1_box.setVisible(false);
				HERO1.setVisible(false);
			}
		} catch (Exception noName0) {
			hero1name.setVisible(false);
			char_1_box.setVisible(false);
			HERO1.setVisible(false);
		}
		
		ButtonGroup charsForBattle = new ButtonGroup();
		charsForBattle.add(char_1_box);
		charsForBattle.add(char_2_box);
		charsForBattle.add(char_3_box);
		
		
		JLabel cheat = new JLabel("CurrentAnswer");
		cheat.setBounds(820, 590, 73, 14);
		frame.getContentPane().add(cheat);
		cheat.setText(Integer.toString(vill));
		cheat.setVisible(false);
		if (game.hasLuck()) {
			cheat.setVisible(true);
		}
		
		JLabel wins = new JLabel("WINS");
		wins.setHorizontalAlignment(SwingConstants.CENTER);
		wins.setFont(new Font("Arvo", Font.BOLD, 30));
		wins.setBounds(12, 12, 130, 75);
		frame.getContentPane().add(wins);
		
		JLabel numberOfWins = new JLabel("0");
		numberOfWins.setHorizontalAlignment(SwingConstants.CENTER);
		numberOfWins.setFont(new Font("Arvo", Font.BOLD, 30));
		numberOfWins.setBounds(12, 55, 130, 75);
		frame.getContentPane().add(numberOfWins);
		numberOfWins.setText(String.valueOf(game.getCurrentVillian().getLossCount()));
		
		JButton btnConfirmYourGuess = new JButton("Confirm Your Guess");
		btnConfirmYourGuess.setBounds(105, 436, 311, 66);
		frame.getContentPane().add(btnConfirmYourGuess);
		frame.getContentPane().setLayout(null);
		btnConfirmYourGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int hero = Integer.parseInt((String) numberOptionsCombo.getSelectedItem());
				numOfGuesses += 1;
				if (hero != vill && numOfGuesses < 2) {
					lblResult.setText(numberGame.higherOrLowerGui(hero, vill));
				}  else if (hero == vill) {
					lblResult.setText("YOU HAVE GUESSED CORRECTLY");
					game.getCurrentVillian().oneDefeat();
					numOfGuesses = 0;
					numberOfWins.setText(String.valueOf(game.getCurrentVillian().getLossCount()));
					vill = numberGame.getVillianChoice(luckynumGuess);
					cheat.setText(Integer.toString(vill));
					if (game.getCurrentVillian().getLossCount() == game.getCurrentVillian().getTimesToBeat()) {
						frame.getContentPane().removeAll();
						frame.repaint();
						villianBeatPanel();
					} else if (game.getCurrentVillian().changesTheGame()){
						Random rand = new Random();
						int newGame = rand.nextInt(2);
						frame.getContentPane().removeAll();
						frame.repaint();
						if (newGame == 0) {
							paperScissorsRockPanel();
						} else if (newGame == 1){
							numberGuessPanel();
						} else {
							diceRollPanel();
						}
					}
				} else {
					vill = numberGame.getVillianChoice(luckynumGuess);
					cheat.setText(Integer.toString(vill));
					if (game.getTeam().getHeroArray().get(game.getCurrentHero()).getCurrentHealth() - game.getCurrentVillian().getDamageAmmount() <= 0) {
						game.getTeam().getHeroArray().get(game.getCurrentHero()).damageHealth(game.getCurrentVillian().getDamageAmmount());
						JOptionPane.showMessageDialog(null, "Your Hero Is Dead!");
						frame.getContentPane().removeAll();
						frame.repaint();
						numberGuessPanel();
						numOfGuesses = 0;
						if (game.getCurrentHero() == 0) {
							hero1name.setVisible(false);
							char_1_box.setVisible(false);
						} else if (game.getCurrentHero() == 1) {
							hero2name.setVisible(false);
							char_2_box.setVisible(false);
						} else {
							hero3name.setVisible(false);
							char_3_box.setVisible(false);
						}
						int stillAliveChar = 999;
						for (int i = 0; i < game.getTeam().getHeroArray().size(); i++) {
							if (game.getTeam().getHeroArray().get(i).getCurrentHealth() > 0) {
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
						JOptionPane.showMessageDialog(null, "Your Hero Takes " + game.getCurrentVillian().getDamageAmmount() + " Damage");
						numOfGuesses = 0;
						game.getTeam().getHeroArray().get(game.getCurrentHero()).damageHealth(game.getCurrentVillian().getDamageAmmount());//method works if there is only 1 person in the team, however when there are 2 or more then a person  gets removed and the array shrinks but doesnt go into the catch
					}
				}
			}
		});
		JButton viewStats = new JButton("View Stats");
		viewStats.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, game.getTeam().toString());
			}
		});
		viewStats.setBounds(506, 436, 311, 66);
		frame.getContentPane().add(viewStats);
		
		JLabel background = new JLabel("");
		background.setBounds(0, -39, 938, 643);
		frame.getContentPane().add(background);
		background.setIcon(new ImageIcon(new ImageIcon(gameEnvGui.class.getResource("/Images/numberguessBG.png")).getImage().getScaledInstance(950, 620, Image.SCALE_DEFAULT)));
		

		
		
	}
	
	private void hospitalPanel() {
		JLabel lblApplyTo = new JLabel("Apply To:");
		lblApplyTo.setBounds(431, 175, 70, 15);
		frame.getContentPane().add(lblApplyTo);
		
		
		JLabel hero1name = new JLabel("hero1");
		hero1name.setHorizontalAlignment(SwingConstants.CENTER);
		hero1name.setBounds(227, 202, 97, 14);
		frame.getContentPane().add(hero1name);
		
		
		
		JLabel hero2name = new JLabel("hero2");
		hero2name.setHorizontalAlignment(SwingConstants.CENTER);
		hero2name.setBounds(401, 202, 133, 14);
		frame.getContentPane().add(hero2name);
		
		JLabel hero3name = new JLabel("hero3");
		hero3name.setHorizontalAlignment(SwingConstants.CENTER);
		hero3name.setBounds(596, 202, 108, 14);
		frame.getContentPane().add(hero3name);
		
		
		JRadioButton char_1_box = new JRadioButton("");
		char_1_box.setBackground(new Color(51, 0, 102));
		char_1_box.setHorizontalAlignment(SwingConstants.CENTER);
		char_1_box.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblApplyTo.setText("Apply To: " + game.getTeam().getHeroArray().get(0).getName());
				game.setCurrentHero(0);
			}
		});
		char_1_box.setBounds(227, 383, 97, 23);
		char_1_box.setSelected(true);
		frame.getContentPane().add(char_1_box);
		char_1_box.setBackground(new Color(0,0,0,0));
		
		JRadioButton char_2_box = new JRadioButton("");
		char_2_box.setHorizontalAlignment(SwingConstants.CENTER);
		char_2_box.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblApplyTo.setText("Apply To: " + game.getTeam().getHeroArray().get(1).getName());
				game.setCurrentHero(1);
			}
		});
		char_2_box.setBounds(421, 383, 97, 23);
		frame.getContentPane().add(char_2_box);
		char_2_box.setBackground(new Color(0,0,0,0));
		
		JRadioButton char_3_box = new JRadioButton("");
		char_3_box.setHorizontalAlignment(SwingConstants.CENTER);
		char_3_box.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblApplyTo.setText("Apply To: " + game.getTeam().getHeroArray().get(2).getName());
				game.setCurrentHero(2);
			}
		});
		char_3_box.setBounds(607, 383, 97, 23);
		frame.getContentPane().add(char_3_box);
		char_3_box.setBackground(new Color(0,0,0,0));
		
		
		
		JLabel hero1icon = new JLabel("");
		hero1icon.setBounds(226, 231, 162, 144);
		frame.getContentPane().add(hero1icon);
		
		
		JLabel hero2icon = new JLabel("");
		hero2icon.setBounds(425, 237, 159, 138);
		frame.getContentPane().add(hero2icon);
		
		
		JLabel hero3icon = new JLabel("");
		hero3icon.setBounds(596, 231, 162, 144);
		frame.getContentPane().add(hero3icon);
		
		try {
			if (game.getTeam().getHeroArray().get(0).getCurrentHealth() > 0) {
			hero1name.setText(game.getTeam().getHeroArray().get(0).getName());
			hero1icon.setIcon(game.getTeam().getHeroArray().get(0).getIcon());
			} else {
				hero1name.setVisible(false);
				char_1_box.setVisible(false);
				hero1icon.setVisible(false);
			}
		} catch (Exception noName0) {
			hero1name.setVisible(false);
			char_1_box.setVisible(false);
			hero1icon.setVisible(false);
		}
		try {
			if (game.getTeam().getHeroArray().get(1).getCurrentHealth() > 0) {
			hero2name.setText(game.getTeam().getHeroArray().get(1).getName());
			hero2icon.setIcon(game.getTeam().getHeroArray().get(1).getIcon());
			} else {
				hero2name.setVisible(false);
				char_2_box.setVisible(false);
				hero2icon.setVisible(false);
			}
		} catch (Exception noName0) {
			hero2name.setVisible(false);
			char_2_box.setVisible(false);
			hero2icon.setVisible(false);
		}
		try {
			if (game.getTeam().getHeroArray().get(2).getCurrentHealth() > 0) {
			hero3name.setText(game.getTeam().getHeroArray().get(2).getName());
			hero3icon.setIcon(game.getTeam().getHeroArray().get(2).getIcon());
			} else {
				hero3name.setVisible(false);
				char_3_box.setVisible(false);
				hero3icon.setVisible(false);
			}
		} catch (Exception noName0) {
			hero3name.setVisible(false);
			char_3_box.setVisible(false);
			hero3icon.setVisible(false);
		}
		
		ButtonGroup charsForBattle = new ButtonGroup();
		charsForBattle.add(char_1_box);
		charsForBattle.add(char_2_box);
		charsForBattle.add(char_3_box);
		
		
		
		JLabel lblAvaiableHealingItems = new JLabel("Avaiable Healing Items");
		lblAvaiableHealingItems.setBounds(369, 22, 177, 15);
		frame.getContentPane().add(lblAvaiableHealingItems);
		
		JButton btnRs1 = new JButton("Restore Health I");
		btnRs1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedHealingItem = btnRs1.getText();
			}
		});
		btnRs1.setBounds(135, 105, 189, 31);
		frame.getContentPane().add(btnRs1);
		
		selectedHealingItem = btnRs1.getText();
		
		JButton btnRs2 = new JButton("Restore Health II");
		btnRs2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedHealingItem = btnRs2.getText();
			}
		});
		btnRs2.setBounds(357, 105, 189, 31);
		frame.getContentPane().add(btnRs2);
		
		JButton btnRs3 = new JButton("Restore Health III");
		btnRs3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedHealingItem = btnRs3.getText();
			}
		});
		btnRs3.setBounds(571, 105, 189, 31);
		frame.getContentPane().add(btnRs3);
		
		JLabel HealthIStock = new JLabel("New label");
		HealthIStock.setBounds(225, 148, 23, 15);
		frame.getContentPane().add(HealthIStock);
		HealthIStock.setText(String.valueOf(Collections.frequency(game.getTeam().getHealingItems(), game.getCurrentShop().getHealingItems().get(0))));
		
		
		JLabel HealthIIStock = new JLabel("New label");
		HealthIIStock.setBounds(448, 148, 70, 15);
		frame.getContentPane().add(HealthIIStock);
		HealthIIStock.setText(String.valueOf(Collections.frequency(game.getTeam().getHealingItems(), game.getCurrentShop().getHealingItems().get(1))));
		
		JLabel HealthIIIStock = new JLabel("New label");
		HealthIIIStock.setBounds(663, 148, 70, 15);
		frame.getContentPane().add(HealthIIIStock);
		HealthIIIStock.setText(String.valueOf(Collections.frequency(game.getTeam().getHealingItems(), game.getCurrentShop().getHealingItems().get(2))));
		
		
		
		JButton timeRemainingButton = new JButton("View Time Remaining");
		timeRemainingButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					JOptionPane msg = new JOptionPane("Your Time Remaining", JOptionPane.PLAIN_MESSAGE);
				    JDialog dlg = msg.createDialog(String.valueOf(current.getTimeRemaining()));
				    dlg.setTitle("Your Time Remaining");
				    dlg.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
				    new Thread(new Runnable() {
				      @Override
				      public void run() {
				    	  while(current.getTimeRemaining() > 0) {
				        try {
				          Thread.sleep(1000);
				          msg.setMessage(current.getTimeRemaining());
				        } catch (InterruptedException e) {
				          e.printStackTrace();
				        }
				        }
				    	game.stopUsingHealingItem();
				        dlg.setVisible(false);
				        current = null;
				      }
				   
				    }).start();
				    dlg.setVisible(true);
				} catch (Exception no) {
					JOptionPane.showMessageDialog(null, "You Need To Apply An Item First");
				}
			}
		});
		timeRemainingButton.setBounds(369, 487, 215, 44);
		frame.getContentPane().add(timeRemainingButton);
		
		JButton applyToHero = new JButton("Apply To Hero");
		applyToHero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (game.usingHealingItem()) {
					JOptionPane.showMessageDialog(null, "You Cannot Heal Two Characters At Once");
				} else {
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
					game.useHealingItem();
					System.out.println(game.usingHealingItem());
					current = game.getTeam().getHealingItems().get(count);
					game.getTeam().getHeroArray().get(game.getCurrentHero()).useHealingItem(current);
					frame.getContentPane().removeAll();
					frame.repaint();
					hospitalPanel();
					timeRemainingButton.doClick();
					
				} else {
					JOptionPane.showMessageDialog(null, "YOU DONT HAVE THIS ITEM!");
				}
				}
			}
		});
		applyToHero.setBounds(207, 437, 215, 44);
		frame.getContentPane().add(applyToHero);
		
		JButton exit = new JButton("Exit");
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, game.randomEvent());
				frame.getContentPane().removeAll();
				frame.repaint();
				baseCampPanel();
			}
		});
		exit.setBounds(518, 437, 215, 44);
		frame.getContentPane().add(exit);
		
		
		
	
		

		
		JLabel rs1 = new JLabel("New label");
		rs1.setBounds(202, 41, 46, 52);
		frame.getContentPane().add(rs1);
		rs1.setIcon(new ImageIcon(new ImageIcon(gameEnvGui.class.getResource("/Images/RestoreHealth1.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
		
		JLabel rs2 = new JLabel("New label");
		rs2.setBounds(430, 41, 46, 52);
		frame.getContentPane().add(rs2);
		rs2.setIcon(new ImageIcon(new ImageIcon(gameEnvGui.class.getResource("/Images/RestoreHealth1.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));

		
		JLabel rs3 = new JLabel("New label");
		rs3.setBounds(650, 41, 46, 52);
		frame.getContentPane().add(rs3);
		rs3.setIcon(new ImageIcon(new ImageIcon(gameEnvGui.class.getResource("/Images/RestoreHealth1.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setBounds(0, -77, 938, 681);
		frame.getContentPane().add(lblNewLabel_8);
		lblNewLabel_8.setIcon(new ImageIcon(new ImageIcon(gameEnvGui.class.getResource("/Images/hospitalBack.png")).getImage().getScaledInstance(940, 642, Image.SCALE_DEFAULT)));
		JLabel lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setBounds(0, 12, 938, 681);
		frame.getContentPane().add(lblNewLabel_9);
		lblNewLabel_9.setIcon(new ImageIcon(new ImageIcon(gameEnvGui.class.getResource("/Images/hospitalBack.png")).getImage().getScaledInstance(940, 642, Image.SCALE_DEFAULT)));


		
	}
	
	private void shopPanel() {

		
		frame.getContentPane().setBackground(UIManager.getColor("OptionPane.warningDialog.border.background"));
		JLabel itemName = new JLabel("Selected Item Name");
		itemName.setBounds(751, 572, 135, 15);
		frame.getContentPane().add(itemName);
		itemName.setVisible(false);
		
		JButton viewInventory = new JButton("View Inventory");
		viewInventory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, game.getTeam().viewInventory());
			}
		});
		viewInventory.setBounds(372, 14, 165, 38);
		frame.getContentPane().add(viewInventory);
		
		
		JLabel stck1 = new JLabel("Stock");
		stck1.setBounds(281, 111, 70, 15);
		frame.getContentPane().add(stck1);
		
		JLabel stck2 = new JLabel("Stock");
		stck2.setBounds(495, 111, 70, 15);
		frame.getContentPane().add(stck2);
		
		JLabel stck3 = new JLabel("Stock");
		stck3.setBounds(677, 111, 70, 15);
		frame.getContentPane().add(stck3);
		
		
		JLabel stck4 = new JLabel("Stock");
		stck4.setBounds(281, 239, 70, 15);
		frame.getContentPane().add(stck4);
		
		JLabel stck5 = new JLabel("Stock");
		stck5.setBounds(482, 239, 70, 15);
		frame.getContentPane().add(stck5);
		
		JLabel stck6 = new JLabel("Stock");
		stck6.setBounds(669, 239, 70, 15);
		frame.getContentPane().add(stck6);
		
		JLabel stck7 = new JLabel("Stock");
		stck7.setBounds(281, 349, 70, 15);
		frame.getContentPane().add(stck7);
		
		JLabel stck8 = new JLabel("Stock");
		stck8.setBounds(482, 349, 70, 15);
		frame.getContentPane().add(stck8);
		
		JLabel stck9 = new JLabel("Stock");
		stck9.setBounds(669, 349, 70, 15);
		frame.getContentPane().add(stck9);
		
		JLabel stck10 = new JLabel("Stock");
		stck10.setBounds(281, 449, 70, 15);
		frame.getContentPane().add(stck10);
		
		JLabel stck11 = new JLabel("Stock");
		stck11.setBounds(482, 449, 70, 15);
		frame.getContentPane().add(stck11);
		
		JLabel stck12 = new JLabel("Stock");
		stck12.setBounds(688, 449, 70, 15);
		frame.getContentPane().add(stck12);
		
		
		
		
		
		JLabel pr1 = new JLabel("Price");
		pr1.setBounds(281, 96, 70, 15);
		frame.getContentPane().add(pr1);
		
		JLabel pr2 = new JLabel("Price");
		pr2.setBounds(495, 96, 70, 15);
		frame.getContentPane().add(pr2);
		
		JLabel pr3 = new JLabel("Price");
		pr3.setBounds(677, 96, 70, 15);
		frame.getContentPane().add(pr3);
		
		JLabel pr4 = new JLabel("Price");
		pr4.setBounds(281, 223, 70, 15);
		frame.getContentPane().add(pr4);
		
		JLabel pr5 = new JLabel("Price");
		pr5.setBounds(482, 223, 70, 15);
		frame.getContentPane().add(pr5);
		
		JLabel pr6 = new JLabel("Price");
		pr6.setBounds(669, 223, 70, 15);
		frame.getContentPane().add(pr6);
		
		JLabel pr7 = new JLabel("Price");
		pr7.setBounds(281, 333, 70, 15);
		frame.getContentPane().add(pr7);
		
		JLabel pr8 = new JLabel("Price");
		pr8.setBounds(482, 333, 70, 15);
		frame.getContentPane().add(pr8);
		
		JLabel pr9 = new JLabel("Price");
		pr9.setBounds(669, 333, 70, 15);
		frame.getContentPane().add(pr9);
		
		JLabel pr10 = new JLabel("Price");
		pr10.setBounds(281, 433, 70, 15);
		frame.getContentPane().add(pr10);
		
		JLabel pr11 = new JLabel("Price");
		pr11.setBounds(482, 433, 70, 15);
		frame.getContentPane().add(pr11);
		
		JLabel pr12 = new JLabel("Price");
		pr12.setBounds(688, 433, 70, 15);
		frame.getContentPane().add(pr12);
		
		
		JLabel ip1 = new JLabel("0");
		ip1.setBounds(334, 96, 70, 15);
		frame.getContentPane().add(ip1);
		ip1.setText(String.valueOf(game.getCurrentShop().getHealingItems().get(0).getHealingItemPrice()-game.getTeam().getBarterSkillSum()));
		if (game.getCurrentShop().getHealingItems().get(0).getHealingItemPrice()-game.getTeam().getBarterSkillSum() <= 0){
			ip1.setText(String.valueOf(10));
		}
		
		JLabel ip2 = new JLabel("0");
		ip2.setBounds(552, 96, 70, 15);
		frame.getContentPane().add(ip2);
		ip2.setText(String.valueOf(game.getCurrentShop().getHealingItems().get(1).getHealingItemPrice()-game.getTeam().getBarterSkillSum()));
		if (game.getCurrentShop().getHealingItems().get(1).getHealingItemPrice()-game.getTeam().getBarterSkillSum() <= 0){
			ip2.setText(String.valueOf(10));
		}
		
		JLabel ip3 = new JLabel("0");
		ip3.setBounds(721, 96, 70, 15);
		frame.getContentPane().add(ip3);
		ip3.setText(String.valueOf(game.getCurrentShop().getHealingItems().get(2).getHealingItemPrice()-game.getTeam().getBarterSkillSum()));
		if (game.getCurrentShop().getHealingItems().get(2).getHealingItemPrice()-game.getTeam().getBarterSkillSum() <= 0){
			ip3.setText(String.valueOf(10));
		}
		
		JLabel ip4 = new JLabel("0");
		ip4.setBounds(324, 223, 70, 15);
		frame.getContentPane().add(ip4);
		ip4.setText(String.valueOf(game.getCurrentShop().getPowerUpItems().get(0).getPowerUpPrice()-game.getTeam().getBarterSkillSum()));
		if (game.getCurrentShop().getPowerUpItems().get(0).getPowerUpPrice()-game.getTeam().getBarterSkillSum() <= 0){
			ip4.setText(String.valueOf(10));
		}
		
		// start here
		JLabel ip5 = new JLabel("0");
		ip5.setBounds(525, 223, 70, 15);
		frame.getContentPane().add(ip5);
		ip5.setText(String.valueOf(game.getCurrentShop().getPowerUpItems().get(1).getPowerUpPrice()-game.getTeam().getBarterSkillSum()));
		if (game.getCurrentShop().getPowerUpItems().get(1).getPowerUpPrice()-game.getTeam().getBarterSkillSum() <= 0){
			ip5.setText(String.valueOf(10));
		}
		
		JLabel ip6 = new JLabel("0");
		ip6.setBounds(731, 223, 70, 15);
		frame.getContentPane().add(ip6);
		ip6.setText(String.valueOf(game.getCurrentShop().getPowerUpItems().get(2).getPowerUpPrice()-game.getTeam().getBarterSkillSum()));
		if (game.getCurrentShop().getPowerUpItems().get(2).getPowerUpPrice()-game.getTeam().getBarterSkillSum() <= 0){
			ip6.setText(String.valueOf(10));
		}
		
		JLabel ip7 = new JLabel("0");
		ip7.setBounds(324, 333, 70, 15);
		frame.getContentPane().add(ip7);
		ip7.setText(String.valueOf(game.getCurrentShop().getPowerUpItems().get(3).getPowerUpPrice()-game.getTeam().getBarterSkillSum()));
		if (game.getCurrentShop().getPowerUpItems().get(3).getPowerUpPrice()-game.getTeam().getBarterSkillSum() <= 0){
			ip7.setText(String.valueOf(10));
		}
		
		JLabel ip8 = new JLabel("0");
		ip8.setBounds(525, 333, 70, 15);
		frame.getContentPane().add(ip8);
		ip8.setText(String.valueOf(game.getCurrentShop().getPowerUpItems().get(4).getPowerUpPrice()-game.getTeam().getBarterSkillSum()));
		if (game.getCurrentShop().getPowerUpItems().get(4).getPowerUpPrice()-game.getTeam().getBarterSkillSum() <= 0){
			ip8.setText(String.valueOf(10));
		}
		
		JLabel ip9 = new JLabel("0");
		ip9.setBounds(721, 333, 70, 15);
		frame.getContentPane().add(ip9);
		ip9.setText(String.valueOf(game.getCurrentShop().getPowerUpItems().get(5).getPowerUpPrice()-game.getTeam().getBarterSkillSum()));
		if (game.getCurrentShop().getPowerUpItems().get(5).getPowerUpPrice()-game.getTeam().getBarterSkillSum() <= 0){
			ip9.setText(String.valueOf(10));
		}
		
		JLabel ip10 = new JLabel("0");
		ip10.setBounds(324, 433, 70, 15);
		frame.getContentPane().add(ip10);
		ip10.setText(String.valueOf(game.getCurrentShop().getPowerUpItems().get(6).getPowerUpPrice()-game.getTeam().getBarterSkillSum()));
		if (game.getCurrentShop().getPowerUpItems().get(6).getPowerUpPrice()-game.getTeam().getBarterSkillSum() <= 0){
			ip10.setText(String.valueOf(10));
		}
		
		JLabel ip11 = new JLabel("0");
		ip11.setBounds(525, 433, 70, 15);
		frame.getContentPane().add(ip11);
		ip11.setText(String.valueOf(game.getCurrentShop().getPowerUpItems().get(7).getPowerUpPrice()-game.getTeam().getBarterSkillSum()));
		if (game.getCurrentShop().getPowerUpItems().get(7).getPowerUpPrice()-game.getTeam().getBarterSkillSum() <= 0){
			ip11.setText(String.valueOf(10));
		}
		
		JLabel ip12 = new JLabel("0");
		ip12.setBounds(731, 433, 70, 15);
		frame.getContentPane().add(ip12);
		ip12.setText(String.valueOf(game.getCurrentShop().getPowerUpItems().get(8).getPowerUpPrice()-game.getTeam().getBarterSkillSum()));
		if (game.getCurrentShop().getPowerUpItems().get(8).getPowerUpPrice()-game.getTeam().getBarterSkillSum() <= 0){
			ip12.setText(String.valueOf(10));
		}
		
		
		//itemName.setIcon(new ImageIcon(new ImageIcon(gameEnvGui.class.getResource("/Images/RestoreHealth1.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
		JLabel itemImg = new JLabel("Selected Item Name");
		itemImg.setBounds(45, 310, 53, 51);
		frame.getContentPane().add(itemImg);
		itemImg.setIcon(new ImageIcon(new ImageIcon(gameEnvGui.class.getResource("/Images/RestoreHealth1.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, game.randomEvent());
				frame.getContentPane().removeAll();
				frame.repaint();
				baseCampPanel();
			}
		});
		btnExit.setBounds(495, 534, 238, 70);
		frame.getContentPane().add(btnExit);
		
		JLabel currentItemInfo = new JLabel("");
		currentItemInfo.setBounds(28, 400, 70, 15);
		frame.getContentPane().add(currentItemInfo);
		
		JLabel lblAvailableHealingItems = new JLabel("Available Healing Items");
		lblAvailableHealingItems.setBounds(372, 64, 238, 15);
		frame.getContentPane().add(lblAvailableHealingItems);
		
		JLabel lblAvailablePowerUps = new JLabel("Available Power Ups");
		lblAvailablePowerUps.setBounds(384, 196, 238, 15);
		frame.getContentPane().add(lblAvailablePowerUps);
		
		JButton health1 = new JButton("r1");
		health1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedItemPrice = Integer.parseInt(ip1.getText());
				itemName.setText(game.getCurrentShop().getHealingItems().get(0).getHealingItemName());
				itemImg.setIcon(new ImageIcon(new ImageIcon(gameEnvGui.class.getResource("/Images/RestoreHealth1.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
			}
		});
		health1.setBounds(173, 150, 159, 23);
		frame.getContentPane().add(health1);
		health1.setText(game.getCurrentShop().getHealingItems().get(0).getHealingItemName());
		
		JButton health2 = new JButton("r2");
		health2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedItemPrice = Integer.parseInt(ip2.getText());
				itemName.setText(game.getCurrentShop().getHealingItems().get(1).getHealingItemName());
				itemImg.setIcon(new ImageIcon(new ImageIcon(gameEnvGui.class.getResource("/Images/RestoreHealth1.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
			}
		});
		health2.setBounds(372, 151, 165, 21);
		frame.getContentPane().add(health2);
		health2.setText(game.getCurrentShop().getHealingItems().get(1).getHealingItemName());
		
		JButton health3 = new JButton("r3");
		health3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedItemPrice = Integer.parseInt(ip3.getText());
				itemName.setText(game.getCurrentShop().getHealingItems().get(2).getHealingItemName());
				itemImg.setIcon(new ImageIcon(new ImageIcon(gameEnvGui.class.getResource("/Images/RestoreHealth1.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
			}
		});
		health3.setBounds(561, 150, 186, 23);
		frame.getContentPane().add(health3);
		health3.setText(game.getCurrentShop().getHealingItems().get(2).getHealingItemName());
		
		
		
		
//		THE BEGGINING OF THE POWER UP SECTION
		JButton powerUp1 = new JButton("p1");
		powerUp1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedItemPrice = Integer.parseInt(ip4.getText());
				itemName.setText(game.getCurrentShop().getPowerUpItems.get(0).getPowerUpName());
				itemImg.setIcon(new ImageIcon(new ImageIcon(gameEnvGui.class.getResource("/Images/AugmentVitality1.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
			}
		});
		powerUp1.setBounds(173, 279, 159, 23);
		frame.getContentPane().add(powerUp1);
		powerUp1.setText(game.getCurrentShop().getPowerUpItems.get(0).getPowerUpName());
		
		JButton powerUp2 = new JButton("p2");
		powerUp2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedItemPrice = Integer.parseInt(ip5.getText());
				itemName.setText(game.getCurrentShop().getPowerUpItems.get(1).getPowerUpName());
				itemImg.setIcon(new ImageIcon(new ImageIcon(gameEnvGui.class.getResource("/Images/AugmentVitality1.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
			}
		});
		powerUp2.setBounds(372, 279, 165, 23);
		frame.getContentPane().add(powerUp2);
		powerUp2.setText(game.getCurrentShop().getPowerUpItems.get(1).getPowerUpName());
		
		JButton powerUp3 = new JButton("p3");
		powerUp3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedItemPrice = Integer.parseInt(ip6.getText());
				itemName.setText(game.getCurrentShop().getPowerUpItems.get(2).getPowerUpName());
				itemImg.setIcon(new ImageIcon(new ImageIcon(gameEnvGui.class.getResource("/Images/AugmentVitality1.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
			}
		});
		powerUp3.setBounds(561, 280, 186, 22);
		frame.getContentPane().add(powerUp3);
		powerUp3.setText(game.getCurrentShop().getPowerUpItems.get(2).getPowerUpName());
		
		JButton powerUp4 = new JButton("p4");
		powerUp4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedItemPrice = Integer.parseInt(ip7.getText());
				itemName.setText(game.getCurrentShop().getPowerUpItems.get(3).getPowerUpName());
				itemImg.setIcon(new ImageIcon(new ImageIcon(gameEnvGui.class.getResource("/Images/IronFlesh1.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
			}
		});
		powerUp4.setBounds(173, 372, 159, 23);
		frame.getContentPane().add(powerUp4);
		powerUp4.setText(game.getCurrentShop().getPowerUpItems.get(3).getPowerUpName());
		
		JButton powerUp5 = new JButton("p5");
		powerUp5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedItemPrice = Integer.parseInt(ip8.getText());
				itemName.setText(game.getCurrentShop().getPowerUpItems.get(4).getPowerUpName());
				itemImg.setIcon(new ImageIcon(new ImageIcon(gameEnvGui.class.getResource("/Images/IronFlesh1.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
			}
		});
		powerUp5.setBounds(372, 372, 165, 23);
		frame.getContentPane().add(powerUp5);
		powerUp5.setText(game.getCurrentShop().getPowerUpItems.get(4).getPowerUpName());
		
		JButton powerUp6 = new JButton("p6");
		powerUp6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedItemPrice = Integer.parseInt(ip9.getText());
				itemName.setText(game.getCurrentShop().getPowerUpItems.get(5).getPowerUpName());
				itemImg.setIcon(new ImageIcon(new ImageIcon(gameEnvGui.class.getResource("/Images/IronFlesh1.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
			}
		});
		powerUp6.setBounds(561, 372, 186, 23);
		frame.getContentPane().add(powerUp6);
		powerUp6.setText(game.getCurrentShop().getPowerUpItems.get(5).getPowerUpName());
		
		JButton powerUp7 = new JButton("p7");
		powerUp7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedItemPrice = Integer.parseInt(ip10.getText());
				itemName.setText(game.getCurrentShop().getPowerUpItems.get(6).getPowerUpName());
				itemImg.setIcon(new ImageIcon(new ImageIcon(gameEnvGui.class.getResource("/Images/SilverTongue1.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
			}
		});
		powerUp7.setBounds(173, 489, 159, 23);
		frame.getContentPane().add(powerUp7);
		powerUp7.setText(game.getCurrentShop().getPowerUpItems.get(6).getPowerUpName());
		
		JButton powerUp8 = new JButton("p8");
		powerUp8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedItemPrice = Integer.parseInt(ip11.getText());
				itemName.setText(game.getCurrentShop().getPowerUpItems.get(7).getPowerUpName());
				itemImg.setIcon(new ImageIcon(new ImageIcon(gameEnvGui.class.getResource("/Images/SilverTongue1.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
			}
		});
		powerUp8.setBounds(372, 489, 165, 23);
		frame.getContentPane().add(powerUp8);
		powerUp8.setText(game.getCurrentShop().getPowerUpItems.get(7).getPowerUpName());
		
		JButton powerUp9 = new JButton("p9");
		powerUp9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedItemPrice = Integer.parseInt(ip12.getText());
				itemName.setText(game.getCurrentShop().getPowerUpItems.get(8).getPowerUpName());
				itemImg.setIcon(new ImageIcon(new ImageIcon(gameEnvGui.class.getResource("/Images/SilverTongue1.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
			}
		});
		powerUp9.setBounds(561, 490, 186, 22);
		frame.getContentPane().add(powerUp9);
		powerUp9.setText(game.getCurrentShop().getPowerUpItems.get(8).getPowerUpName());
		
		JLabel lblSelectedItem = new JLabel("Selected Item");
		lblSelectedItem.setBounds(21, 283, 104, 15);
		frame.getContentPane().add(lblSelectedItem);
		
		
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
		HIT1.setBounds(334, 111, 70, 15);
		frame.getContentPane().add(HIT1);
		HIT1.setText(String.valueOf(game.getCurrentShop().getHealingStockLevel()[0]));
		
		JLabel HIT2 = new JLabel("r1Stock");
		HIT2.setBounds(552, 111, 70, 15);
		frame.getContentPane().add(HIT2);
		HIT2.setText(String.valueOf(game.getCurrentShop().getHealingStockLevel()[1]));
		
		JLabel HIT3 = new JLabel("r1Stock");
		HIT3.setBounds(721, 111, 70, 15);
		frame.getContentPane().add(HIT3);
		HIT3.setText(String.valueOf(game.getCurrentShop().getHealingStockLevel()[2]));
		
		JLabel PUP1 = new JLabel("null");
		PUP1.setBounds(333, 239, 70, 15);
		frame.getContentPane().add(PUP1);
		PUP1.setText(String.valueOf(game.getCurrentShop().getPowerUpStockLevel()[0]));
		
		JLabel PUP2 = new JLabel("null");
		PUP2.setBounds(530, 239, 70, 15);
		frame.getContentPane().add(PUP2);
		PUP2.setText(String.valueOf(game.getCurrentShop().getPowerUpStockLevel()[1]));
		
		JLabel PUP3 = new JLabel("null");
		PUP3.setBounds(721, 240, 70, 15);
		frame.getContentPane().add(PUP3);
		PUP3.setText(String.valueOf(game.getCurrentShop().getPowerUpStockLevel()[2]));
		
		JLabel PUP4 = new JLabel("null");
		PUP4.setBounds(334, 349, 70, 15);
		frame.getContentPane().add(PUP4);
		PUP4.setText(String.valueOf(game.getCurrentShop().getPowerUpStockLevel()[3]));
		
		JLabel PUP5 = new JLabel("null");
		PUP5.setBounds(525, 349, 70, 15);
		frame.getContentPane().add(PUP5);
		PUP5.setText(String.valueOf(game.getCurrentShop().getPowerUpStockLevel()[4]));
		
		JLabel PUP6 = new JLabel("null");
		PUP6.setBounds(721, 349, 70, 15);
		frame.getContentPane().add(PUP6);
		PUP6.setText(String.valueOf(game.getCurrentShop().getPowerUpStockLevel()[5]));
		
		JLabel PUP7 = new JLabel("null");
		PUP7.setBounds(324, 453, 70, 15);
		frame.getContentPane().add(PUP7);
		PUP7.setText(String.valueOf(game.getCurrentShop().getPowerUpStockLevel()[6]));
		
		JLabel PUP8 = new JLabel("null");
		PUP8.setBounds(535, 449, 70, 15);
		frame.getContentPane().add(PUP8);
		PUP8.setText(String.valueOf(game.getCurrentShop().getPowerUpStockLevel()[7]));
		
		JLabel PUP9 = new JLabel("null");
		PUP9.setBounds(731, 449, 70, 15);
		frame.getContentPane().add(PUP9);
		PUP9.setText(String.valueOf(game.getCurrentShop().getPowerUpStockLevel()[8]));
		
		JLabel moneyLevel = new JLabel("0");
		moneyLevel.setBounds(816, 26, 70, 15);
		frame.getContentPane().add(moneyLevel);
		moneyLevel.setText(String.valueOf(game.getTeam().getMoney()));
		
		
		
		JButton purchaseButton = new JButton("Purchase Selected Item");
		purchaseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch(itemName.getText()) {
				case "Restore Health I":
					buyingItem = 0;
					buyingType = "Healing Potion";
					break;
				case "Restore Health II":
					buyingItem = 1;
					buyingType = "Healing Potion";
					break;
				case "Restore Health III":
					buyingItem = 2;
					buyingType = "Healing Potion";
					break;
				case "Iron Flesh I":
					buyingItem = 0;
					buyingType = "Power Up";
					break;
				case "Iron Flesh II":
					buyingItem = 1;
					buyingType = "Power Up";
					break;
				case "Iron Flesh III":
					buyingItem = 2;
					buyingType = "Power Up";
					break;
				case "Augment Vitality I":
					buyingItem = 3;
					buyingType = "Power Up";
					break;
				case "Augment Vitality II":
					buyingItem = 4;
					buyingType = "Power Up";
					break;
				case "Augment Vitality III":
					buyingItem = 5;
					buyingType = "Power Up";
					break;
				case "Silver Tongue I":
					buyingItem = 6;
					buyingType = "Power Up";
					break;
				case "Silver Tongue II":
					buyingItem = 7;
					buyingType = "Power Up";
					break;
				case "Silver Tongue III":
					buyingItem = 8;
					buyingType = "Power Up";
					break;
				default:
					if (game.hasMap()) {
						JOptionPane.showMessageDialog(null, "ONLY SOMEONE TRULY LOST\nNEEDS MORE THAN ONE MAP");
					} else {
						JOptionPane.showMessageDialog(null, "WISE PURCHASE TRAVELLER");//CAUSE ITS A MAP
					}
					
					buyingType = "Map";
				}
				if (buyingType == "Healing Potion") {
				if (game.getCurrentShop().getHealingStockLevel()[buyingItem] > 0) {
					if (game.getTeam().getMoney() >= selectedItemPrice) {
						game.getTeam().addHealingItem(game.getCurrentShop().getHealingItems().get(buyingItem));
						game.getCurrentShop().getHealingStockLevel()[buyingItem] -= 1;
						game.getTeam().addMoney(-(selectedItemPrice));
						JOptionPane.showMessageDialog(null, "SUCESSFUL PURCHASE OF " + game.getCurrentShop().getHealingItems().get(buyingItem).getHealingItemName());
					} else {
						JOptionPane.showMessageDialog(null, "YOU DONT HAVE ENOUGH MONEY!");
					}
				} else {
					JOptionPane.showMessageDialog(null, "THIS ITEM IS OUT OF STOCK");
				}} else if (buyingType == "Power Up") {
					if (game.getCurrentShop().getPowerUpStockLevel()[buyingItem] > 0) {
						if (game.getTeam().getMoney() >= selectedItemPrice) {
							game.getTeam().addPowerUp(game.getCurrentShop().getPowerUpItems().get(buyingItem));
							game.getCurrentShop().getPowerUpStockLevel()[buyingItem] -= 1;
							game.getTeam().addMoney(-(selectedItemPrice));
							JOptionPane.showMessageDialog(null, "SUCESSFUL PURCHASE OF " + game.getCurrentShop().getPowerUpItems().get(buyingItem).getPowerUpName());
						} else {
							JOptionPane.showMessageDialog(null, "YOU DONT HAVE ENOUGH MONEY!");
						}
					} else {
						JOptionPane.showMessageDialog(null, "THIS ITEM IS OUT OF STOCK");
					}
				} else {
					game.makeAllFound();
					game.giveMap();
				}
				frame.getContentPane().removeAll();
				frame.repaint();
				shopPanel();
				
			}
		});
		purchaseButton.setBounds(216, 534, 227, 70);
		frame.getContentPane().add(purchaseButton);
		
		
		JOptionPane msg = new JOptionPane("Item Description", JOptionPane.PLAIN_MESSAGE);
	    JDialog dlg = msg.createDialog(game.getRHI().toString());
	    dlg.setVisible(false);
		
		JLabel r1 = new JLabel("New label");
		r1.setBounds(216, 96, 53, 51);
		r1.setIcon(new ImageIcon(new ImageIcon(gameEnvGui.class.getResource("/Images/RestoreHealth1.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
		frame.getContentPane().add(r1);
		r1.setToolTipText(game.getRHI().toString());
		
		
		JLabel r2 = new JLabel("New label");
		r2.setBounds(416, 96, 46, 52);
		r2.setIcon(new ImageIcon(new ImageIcon(gameEnvGui.class.getResource("/Images/RestoreHealth1.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
		frame.getContentPane().add(r2);
		r2.setToolTipText(game.getRHII().toString());
		
		JLabel r3 = new JLabel("New label");
		r3.setBounds(608, 91, 46, 52);
		r3.setIcon(new ImageIcon(new ImageIcon(gameEnvGui.class.getResource("/Images/RestoreHealth1.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
		frame.getContentPane().add(r3);
		r3.setToolTipText(game.getRHIII().toString());
		
		
		
		JLabel p1 = new JLabel("New label");
		p1.setBounds(216, 224, 53, 51);
		frame.getContentPane().add(p1);
		p1.setIcon(new ImageIcon(new ImageIcon(gameEnvGui.class.getResource("/Images/AugmentVitality1.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
		p1.setToolTipText(game.getIFI().toString());
		
		JLabel p2 = new JLabel("New label");
		p2.setBounds(416, 223, 46, 52);
		frame.getContentPane().add(p2);
		p2.setIcon(new ImageIcon(new ImageIcon(gameEnvGui.class.getResource("/Images/AugmentVitality1.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
		p2.setToolTipText(game.getIFII().toString());
		
		JLabel p3 = new JLabel("New label");
		p3.setBounds(608, 224, 46, 52);
		frame.getContentPane().add(p3);
		p3.setIcon(new ImageIcon(new ImageIcon(gameEnvGui.class.getResource("/Images/AugmentVitality1.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
		p3.setToolTipText(game.getIFIII().toString());
		
		JLabel p5 = new JLabel("New label");
		p5.setBounds(416, 316, 46, 52);
		frame.getContentPane().add(p5);
		p5.setIcon(new ImageIcon(new ImageIcon(gameEnvGui.class.getResource("/Images/IronFlesh1.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
		p5.setToolTipText(game.getAVII().toString());
		
		JLabel p4 = new JLabel("New label");
		p4.setBounds(216, 317, 53, 51);
		frame.getContentPane().add(p4);
		p4.setIcon(new ImageIcon(new ImageIcon(gameEnvGui.class.getResource("/Images/IronFlesh1.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
		p4.setToolTipText(game.getAVI().toString());
		
		JLabel p6 = new JLabel("New label");
		p6.setBounds(608, 317, 46, 52);
		frame.getContentPane().add(p6);
		p6.setIcon(new ImageIcon(new ImageIcon(gameEnvGui.class.getResource("/Images/IronFlesh1.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
		p6.setToolTipText(game.getAVIII().toString());
		
		JLabel p8 = new JLabel("New label");
		p8.setBounds(416, 433, 46, 52);
		frame.getContentPane().add(p8);
		p8.setIcon(new ImageIcon(new ImageIcon(gameEnvGui.class.getResource("/Images/SilverTongue1.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
		p8.setToolTipText(game.getSTII().toString());
		
		
		JLabel p7 = new JLabel("New label");
		p7.setBounds(216, 433, 53, 58);
		frame.getContentPane().add(p7);
		p7.setIcon(new ImageIcon(new ImageIcon(gameEnvGui.class.getResource("/Images/SilverTongue1.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
		p7.setToolTipText(game.getSTI().toString());

		
		JLabel p9 = new JLabel("New label");
		p9.setBounds(608, 434, 46, 52);
		frame.getContentPane().add(p9);
		p9.setIcon(new ImageIcon(new ImageIcon(gameEnvGui.class.getResource("/Images/SilverTongue1.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
		p9.setToolTipText(game.getSTIII().toString());

		
		JButton buyMap = new JButton("Map");
		buyMap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				itemImg.setIcon(new ImageIcon(new ImageIcon(gameEnvGui.class.getResource("/Images/map.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
			}
		});
		buyMap.setBounds(21, 177, 104, 23);
		frame.getContentPane().add(buyMap);
		
		JLabel lblSpecialItems = new JLabel("Special Items");
		lblSpecialItems.setBounds(32, 96, 117, 15);
		frame.getContentPane().add(lblSpecialItems);
		
		JLabel mapLabel = new JLabel("New label");
		mapLabel.setBounds(45, 122, 53, 51);
		frame.getContentPane().add(mapLabel);
		mapLabel.setIcon(new ImageIcon(new ImageIcon(gameEnvGui.class.getResource("/Images/map.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
		
		JLabel shelf = new JLabel("");
		shelf.setBounds(161, 419, 653, 113);
		shelf.setIcon(new ImageIcon(new ImageIcon(gameEnvGui.class.getResource("/Images/shelf.png")).getImage().getScaledInstance(620, 100, Image.SCALE_DEFAULT)));
		frame.getContentPane().add(shelf);
		
		JLabel shelf2 = new JLabel("");
		shelf2.setBounds(163, 314, 651, 107);
		frame.getContentPane().add(shelf2);
		shelf2.setIcon(new ImageIcon(new ImageIcon(gameEnvGui.class.getResource("/Images/shelf.png")).getImage().getScaledInstance(620, 100, Image.SCALE_DEFAULT)));
		
		JLabel shelf3 = new JLabel("");
		shelf3.setBounds(161, 205, 635, 109);
		frame.getContentPane().add(shelf3);
		shelf3.setIcon(new ImageIcon(new ImageIcon(gameEnvGui.class.getResource("/Images/shelf.png")).getImage().getScaledInstance(620, 100, Image.SCALE_DEFAULT)));
		
		JLabel shelf4 = new JLabel("");
		shelf4.setBounds(161, 85, 635, 109);
		frame.getContentPane().add(shelf4);
		shelf4.setIcon(new ImageIcon(new ImageIcon(gameEnvGui.class.getResource("/Images/shelf.png")).getImage().getScaledInstance(620, 100, Image.SCALE_DEFAULT)));
		
		JLabel moneyTitle = new JLabel("Teams Money Level:");
		moneyTitle.setBounds(661, 26, 150, 15);
		frame.getContentPane().add(moneyTitle);
		
		
		

		

		
	}
	
	private void paperScissorsRockPanel() {
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		if (game.hasLuck()) {
			luckynumPSR = 2;
		}
		paperScissorsRock paperGame = new paperScissorsRock();
		frame.getContentPane().setLayout(null);
		
		JLabel resulctCalc = new JLabel("SELECT YOUR GESTURE");
		resulctCalc.setHorizontalAlignment(SwingConstants.CENTER);
		resulctCalc.setFont(new Font("Arvo", Font.BOLD, 30));
		resulctCalc.setBounds(12, 281, 914, 75);
		frame.getContentPane().add(resulctCalc);
		
		JLabel lblResult = new JLabel("");
		lblResult.setHorizontalAlignment(SwingConstants.CENTER);
		lblResult.setFont(new Font("Arvo", Font.BOLD, 30));
		lblResult.setBounds(57, 368, 852, 55);
		frame.getContentPane().add(lblResult);
		
		JLabel numberOfWins = new JLabel("0");
		numberOfWins.setHorizontalAlignment(SwingConstants.CENTER);
		numberOfWins.setFont(new Font("Arvo", Font.BOLD, 30));
		numberOfWins.setBounds(22, 43, 130, 75);
		frame.getContentPane().add(numberOfWins);
		numberOfWins.setText(String.valueOf(game.getCurrentVillian().getLossCount()));
		
		JLabel wins = new JLabel("WINS");
		wins.setHorizontalAlignment(SwingConstants.CENTER);
		wins.setFont(new Font("Arvo", Font.BOLD, 30));
		wins.setBounds(22, 0, 130, 75);
		frame.getContentPane().add(wins);
		
		
		JLabel lblBattlingWith = new JLabel("Battling With ");
		lblBattlingWith.setFont(new Font("Dialog", Font.BOLD, 16));
		lblBattlingWith.setBounds(338, 260, 269, 14);
		lblBattlingWith.setText("Battle With: " + game.getTeam().getHeroArray().get(0).getName());
		frame.getContentPane().add(lblBattlingWith);
		

		
		
		JLabel hero1name = new JLabel("hero1");
		hero1name.setHorizontalAlignment(SwingConstants.CENTER);
		hero1name.setBounds(205, 12, 125, 14);
		frame.getContentPane().add(hero1name);
		
		
		JLabel hero2name = new JLabel("hero2");
		hero2name.setHorizontalAlignment(SwingConstants.CENTER);
		hero2name.setBounds(387, 12, 125, 14);
		frame.getContentPane().add(hero2name);
		
		JLabel hero3name = new JLabel("hero3");
		hero3name.setHorizontalAlignment(SwingConstants.CENTER);
		hero3name.setBounds(571, 12, 119, 14);
		frame.getContentPane().add(hero3name);
		
		
		JRadioButton char_1_box = new JRadioButton("");
		char_1_box.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblBattlingWith.setText("Battle With: " + game.getTeam().getHeroArray().get(0).getName());
				game.setCurrentHero(0);
			}
		});
		char_1_box.setBounds(261, 202, 97, 23);
		char_1_box.setBackground(null);
		frame.getContentPane().add(char_1_box);
		char_1_box.setBackground(new Color(0,0,0,0));
		
		JRadioButton char_2_box = new JRadioButton("");
		char_2_box.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblBattlingWith.setText("Battle With: " + game.getTeam().getHeroArray().get(1).getName());
				game.setCurrentHero(1);
			}
		});
		char_2_box.setBounds(441, 202, 97, 23);
		frame.getContentPane().add(char_2_box);
		char_2_box.setBackground(null);
		char_2_box.setBackground(new Color(0,0,0,0));
		
		JRadioButton char_3_box = new JRadioButton("");
		char_3_box.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblBattlingWith.setText("Battle With: " + game.getTeam().getHeroArray().get(2).getName());
				game.setCurrentHero(2);
			}
		});
		char_3_box.setBounds(622, 202, 97, 23);
		frame.getContentPane().add(char_3_box);
		char_3_box.setBackground(null);
		char_3_box.setBackground(new Color(0,0,0,0));
		
		JLabel HERO1 = new JLabel("");
		HERO1.setBounds(212, 45, 112, 149);
		frame.getContentPane().add(HERO1);
		
		JLabel HERO2 = new JLabel("");
		HERO2.setBounds(394, 45, 107, 149);
		frame.getContentPane().add(HERO2);
		
		JLabel HERO3 = new JLabel("");
		HERO3.setBounds(578, 45, 112, 149);
		frame.getContentPane().add(HERO3);
		
		try {
			System.out.println("h3" + game.getTeam().getHeroArray().get(2).getCurrentHealth());
			if (game.getTeam().getHeroArray().get(2).getCurrentHealth() > 0) {
				hero3name.setText(game.getTeam().getHeroArray().get(2).getName());
				HERO3.setIcon(game.getTeam().getHeroArray().get(2).getIcon());
				char_3_box.setSelected(true);
				game.setCurrentHero(2);
				lblBattlingWith.setText("Battle With: " + game.getTeam().getHeroArray().get(2).getName());
			} else {
				hero3name.setVisible(false);
				char_3_box.setVisible(false);
				HERO3.setVisible(false);
			}
		} catch (Exception noName0) {
			hero3name.setVisible(false);
			char_3_box.setVisible(false);
			HERO3.setVisible(false);
		}
		try {
			System.out.println("h2" + game.getTeam().getHeroArray().get(1).getCurrentHealth());
			if (game.getTeam().getHeroArray().get(1).getCurrentHealth() > 0) {
				hero2name.setText(game.getTeam().getHeroArray().get(1).getName());
				HERO2.setIcon(game.getTeam().getHeroArray().get(1).getIcon());
				char_2_box.setSelected(true);
				game.setCurrentHero(1);
				lblBattlingWith.setText("Battle With: " + game.getTeam().getHeroArray().get(1).getName());
			} else {
				hero2name.setVisible(false);
				char_2_box.setVisible(false);
				HERO2.setVisible(false);
			}
		} catch (Exception noName0) {
			hero2name.setVisible(false);
			char_2_box.setVisible(false);
			HERO2.setVisible(false);
		}
		try {
			System.out.println("h1" + game.getTeam().getHeroArray().get(0).getCurrentHealth());
			if (game.getTeam().getHeroArray().get(0).getCurrentHealth() > 0) {
				hero1name.setText(game.getTeam().getHeroArray().get(0).getName());
				HERO1.setIcon(game.getTeam().getHeroArray().get(0).getIcon());
				char_1_box.setSelected(true);
				game.setCurrentHero(0);
				lblBattlingWith.setText("Battle With: " + game.getTeam().getHeroArray().get(0).getName());
			} else {
				hero1name.setVisible(false);
				char_1_box.setVisible(false);
				HERO1.setVisible(false);
			}
		} catch (Exception noName0) {
			hero1name.setVisible(false);
			char_1_box.setVisible(false);
			HERO1.setVisible(false);
		}
		
		ButtonGroup charsForBattle = new ButtonGroup();
		charsForBattle.add(char_1_box);
		charsForBattle.add(char_2_box);
		charsForBattle.add(char_3_box);
		
		
		frame.getContentPane().setLayout(null);
		JButton viewStats = new JButton("View Stats");
		viewStats.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, game.getTeam().toString());
			}
		});
		viewStats.setBounds(507, 507, 311, 64);
		frame.getContentPane().add(viewStats);
		
		
		JComboBox paperScissorsRockCombo = new JComboBox();
		if (game.hasLuck()) {
			paperScissorsRockCombo.setModel(new DefaultComboBoxModel(new String[] {"Paper", "Scissors"}));
		} else {
			paperScissorsRockCombo.setModel(new DefaultComboBoxModel(new String[] {"Paper", "Scissors", "Rock"}));
		}
		
		paperScissorsRockCombo.setBounds(410, 448, 105, 22);
		frame.getContentPane().add(paperScissorsRockCombo);
		
		JButton btnConfirmYourGuess = new JButton("Confirm Your Guess");
		btnConfirmYourGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String villianGesture = paperGame.getVillianChoice(luckynumPSR);
				String outcome = paperScissorsRockCombo.getSelectedItem() + villianGesture;
				resulctCalc.setText("HERO:     " + paperScissorsRockCombo.getSelectedItem() + "    |    VILLIAN:     " + villianGesture);
				outcome = paperGame.getOutCome(outcome);
				lblResult.setText(outcome);
				switch(outcome) {
				case "You Have Won":
					game.getCurrentVillian().oneDefeat();
					numberOfWins.setText(String.valueOf(game.getCurrentVillian().getLossCount()));
					if (game.getCurrentVillian().getLossCount() == game.getCurrentVillian().getTimesToBeat()) {
						frame.getContentPane().removeAll();
						frame.repaint();
						villianBeatPanel();
					} else if (game.getCurrentVillian().changesTheGame()){
						Random rand = new Random();
						int newGame = rand.nextInt(2);
						frame.getContentPane().removeAll();
						frame.repaint();
						if (newGame == 0) {
							paperScissorsRockPanel();
						} else if (newGame == 1){
							numberGuessPanel();
						} else {
							diceRollPanel();
						}
					}
					break;
				case "The Villian Has Won":
					if (game.getTeam().getHeroArray().get(game.getCurrentHero()).getCurrentHealth() - game.getCurrentVillian().getDamageAmmount() <= 0) {
						game.getTeam().getHeroArray().get(game.getCurrentHero()).damageHealth(game.getCurrentVillian().getDamageAmmount());
						JOptionPane.showMessageDialog(null, "Your Hero Is Dead!");
						frame.getContentPane().removeAll();
						frame.repaint();
						paperScissorsRockPanel();
						if (game.getCurrentHero() == 0) {
							hero1name.setVisible(false);
							char_1_box.setVisible(false);
						} else if (game.getCurrentHero() == 1) {
							hero2name.setVisible(false);
							char_2_box.setVisible(false);
						} else {
							hero3name.setVisible(false);
							char_3_box.setVisible(false);
						}
						int stillAliveChar = 999;
						for (int i = 0; i < game.getTeam().getHeroArray().size(); i++) {
							if (game.getTeam().getHeroArray().get(i).getCurrentHealth() > 0) {
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
						JOptionPane.showMessageDialog(null, "Your Hero Takes " + game.getCurrentVillian().getDamageAmmount() + " Damage");
						game.getTeam().getHeroArray().get(game.getCurrentHero()).damageHealth(game.getCurrentVillian().getDamageAmmount());//method works if there is only 1 person in the team, however when there are 2 or more then a person  gets removed and the array shrinks but doesnt go into the catch
					}
					break;
				case "It Is A Draw, Next Round!":
					break;
				}
			}
		});
		btnConfirmYourGuess.setBounds(99, 507, 311, 64);
		frame.getContentPane().add(btnConfirmYourGuess);
		frame.getContentPane().setLayout(null);
		
		JLabel backGround = new JLabel("");
		backGround.setBounds(0, 0, 938, 616);
		frame.getContentPane().add(backGround);
		backGround.setIcon(new ImageIcon(new ImageIcon(gameEnvGui.class.getResource("/Images/psrBG.png")).getImage().getScaledInstance(940, 642, Image.SCALE_DEFAULT)));

		
	}
	

	
	
	private void powerUpDenPanel() {
		JLabel lblApplyTo = new JLabel("Apply To:");
		lblApplyTo.setHorizontalAlignment(SwingConstants.CENTER);
		lblApplyTo.setBounds(378, 319, 168, 15);
		frame.getContentPane().add(lblApplyTo);
		
		
		JLabel hero1name = new JLabel("hero1");
		hero1name.setBounds(246, 353, 46, 14);
		frame.getContentPane().add(hero1name);
		
		JLabel hero2name = new JLabel("hero2");
		hero2name.setBounds(449, 353, 46, 14);
		frame.getContentPane().add(hero2name);
		
		JLabel hero3name = new JLabel("hero3");
		hero3name.setBounds(619, 353, 46, 14);
		frame.getContentPane().add(hero3name);
		
		
		JRadioButton char_1_box = new JRadioButton("");
		char_1_box.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblApplyTo.setText("Apply To: " + game.getTeam().getHeroArray().get(0).getName());
				game.setCurrentHero(0);
			}
		});
		char_1_box.setBounds(246, 514, 97, 23);
		char_1_box.setSelected(true);
		frame.getContentPane().add(char_1_box);
		char_1_box.setBackground(new Color(0,0,0,0));
		
		JRadioButton char_2_box = new JRadioButton("");
		char_2_box.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblApplyTo.setText("Apply To: " + game.getTeam().getHeroArray().get(1).getName());
				game.setCurrentHero(1);
			}
		});
		char_2_box.setBounds(449, 514, 97, 23);
		frame.getContentPane().add(char_2_box);
		char_2_box.setBackground(new Color(0,0,0,0));
		
		JRadioButton char_3_box = new JRadioButton("");
		char_3_box.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblApplyTo.setText("Apply To: " + game.getTeam().getHeroArray().get(2).getName());
				game.setCurrentHero(2);
			}
		});
		char_3_box.setBounds(638, 514, 97, 23);
		frame.getContentPane().add(char_3_box);
		char_3_box.setBackground(new Color(0,0,0,0));
		
		JLabel hero1icon = new JLabel("");
		hero1icon.setBounds(216, 374, 162, 144);
		frame.getContentPane().add(hero1icon);
		
		
		JLabel hero2icon = new JLabel("");
		hero2icon.setBounds(416, 377, 159, 138);
		frame.getContentPane().add(hero2icon);
		
		
		JLabel hero3icon = new JLabel("");
		hero3icon.setBounds(587, 374, 162, 144);
		frame.getContentPane().add(hero3icon);
		

		try {
			if (game.getTeam().getHeroArray().get(2).getCurrentHealth() > 0) {
			hero3name.setText(game.getTeam().getHeroArray().get(2).getName());
			hero3icon.setIcon(game.getTeam().getHeroArray().get(2).getIcon());
			game.setCurrentHero(2);
			} else {
				hero3name.setVisible(false);
				char_3_box.setVisible(false);
				hero3icon.setVisible(false);
			}
		} catch (Exception noName0) {
			hero3name.setVisible(false);
			char_3_box.setVisible(false);
			hero3icon.setVisible(false);
		}
		try {
			if (game.getTeam().getHeroArray().get(1).getCurrentHealth() > 0) {
			hero2name.setText(game.getTeam().getHeroArray().get(1).getName());
			hero2icon.setIcon(game.getTeam().getHeroArray().get(1).getIcon());
			game.setCurrentHero(1);
			} else {
				hero2name.setVisible(false);
				char_2_box.setVisible(false);
				hero2icon.setVisible(false);
			}
		} catch (Exception noName0) {
			hero2name.setVisible(false);
			char_2_box.setVisible(false);
			hero2icon.setVisible(false);
		}
		try {
			if (game.getTeam().getHeroArray().get(0).getCurrentHealth() > 0) {
			hero1name.setText(game.getTeam().getHeroArray().get(0).getName());
			hero1icon.setIcon(game.getTeam().getHeroArray().get(0).getIcon());
			game.setCurrentHero(0);
			} else {
				hero1name.setVisible(false);
				char_1_box.setVisible(false);
				hero1icon.setVisible(false);
			}
		} catch (Exception noName0) {
			hero1name.setVisible(false);
			char_1_box.setVisible(false);
			hero1icon.setVisible(false);
		}
		lblApplyTo.setText("Apply To:" + game.getTeam().getHeroArray().get(game.getCurrentHero()).getName());
		
		ButtonGroup charsForBattle = new ButtonGroup();
		charsForBattle.add(char_1_box);
		charsForBattle.add(char_2_box);
		charsForBattle.add(char_3_box);
		
		
		
		JLabel lblAvaiableHealingItems = new JLabel("Avaiable Power Up Items");
		lblAvaiableHealingItems.setBounds(369, 22, 177, 15);
		frame.getContentPane().add(lblAvaiableHealingItems);
		
		JLabel p1 = new JLabel("");
		p1.setBounds(118, 51, 134, 144);
		p1.setIcon(new ImageIcon(new ImageIcon(gameEnvGui.class.getResource("/Images/IronFlesh1.png")).getImage().getScaledInstance(140, 140, Image.SCALE_DEFAULT)));
		frame.getContentPane().add(p1);
		
		JLabel p2 = new JLabel("");
		p2.setBounds(390, 53, 167, 142);
		p2.setIcon(new ImageIcon(new ImageIcon(gameEnvGui.class.getResource("/Images/AugmentVitality1.png")).getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT)));
		frame.getContentPane().add(p2);
		
		JLabel p3 = new JLabel("");
		p3.setBounds(679, 52, 159, 154);
		p3.setIcon(new ImageIcon(new ImageIcon(gameEnvGui.class.getResource("/Images/SilverTongue1.png")).getImage().getScaledInstance(130, 130, Image.SCALE_DEFAULT)));
		frame.getContentPane().add(p3);
		
		JLabel shelf = new JLabel("");
		shelf.setBounds(81, 38, 766, 180);
		shelf.setIcon(new ImageIcon(new ImageIcon(gameEnvGui.class.getResource("/Images/shelf.png")).getImage().getScaledInstance(766, 170, Image.SCALE_DEFAULT)));
		frame.getContentPane().add(shelf);
		
		
		
		JButton btnPUP1 = new JButton("Iron Flesh I");
		btnPUP1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedPowerUp = btnPUP1.getText();
			}
		});
		btnPUP1.setBounds(103, 218, 189, 19);
		frame.getContentPane().add(btnPUP1);
		
		JButton btnPUP2 = new JButton("Iron Flesh II");
		btnPUP2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedPowerUp = btnPUP2.getText();
			}
		});
		btnPUP2.setBounds(103, 249, 189, 23);
		frame.getContentPane().add(btnPUP2);
		
		JButton btnPUP3 = new JButton("Iron Flesh III");
		btnPUP3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedPowerUp = btnPUP3.getText();
			}
		});
		btnPUP3.setBounds(103, 284, 189, 23);
		frame.getContentPane().add(btnPUP3);
		
		JButton btnPUP4 = new JButton("Augment Vitality I");
		btnPUP4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedPowerUp = btnPUP4.getText();
			}
		});
		btnPUP4.setBounds(369, 218, 189, 19);
		frame.getContentPane().add(btnPUP4);
		
		
		JButton btnPUP5 = new JButton("Augment Vitality II");
		btnPUP5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedPowerUp = btnPUP5.getText();
			}
		});
		btnPUP5.setBounds(369, 249, 189, 23);
		frame.getContentPane().add(btnPUP5);
		
		JButton btnPUP6 = new JButton("Augment Vitality III");
		btnPUP6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedPowerUp = btnPUP6.getText();
			}
		});
		btnPUP6.setBounds(369, 284, 189, 23);
		frame.getContentPane().add(btnPUP6);
		
		JButton btnPUP7 = new JButton("Silver Tongue I");
		btnPUP7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedPowerUp = btnPUP7.getText();
			}
		});
		btnPUP7.setBounds(655, 218, 189, 23);
		frame.getContentPane().add(btnPUP7);
		
		JButton btnPUP8 = new JButton("Silver Tongue II");
		btnPUP8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedPowerUp = btnPUP8.getText();
			}
		});
		btnPUP8.setBounds(655, 249, 189, 23);
		frame.getContentPane().add(btnPUP8);
		
		JButton btnPUP9 = new JButton("Silver Tongue III");
		btnPUP9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedPowerUp = btnPUP9.getText();
			}
		});
		btnPUP9.setBounds(655, 284, 189, 23);
		frame.getContentPane().add(btnPUP9);
		
		
		
		JLabel stockPUP1 = new JLabel("New label");
		stockPUP1.setBounds(310, 220, 70, 15);
		frame.getContentPane().add(stockPUP1);
		stockPUP1.setText(String.valueOf(Collections.frequency(game.getTeam().getPowerUps(), game.getCurrentShop().getPowerUpItems().get(0))));
		
		
		JLabel stockPUP2 = new JLabel("New label");
		stockPUP2.setBounds(310, 253, 70, 15);
		frame.getContentPane().add(stockPUP2);
		stockPUP2.setText(String.valueOf(Collections.frequency(game.getTeam().getPowerUps(), game.getCurrentShop().getPowerUpItems().get(1))));
		
		JLabel stockPUP3 = new JLabel("New label");
		stockPUP3.setBounds(310, 288, 70, 15);
		frame.getContentPane().add(stockPUP3);
		stockPUP3.setText(String.valueOf(Collections.frequency(game.getTeam().getPowerUps(), game.getCurrentShop().getPowerUpItems().get(2))));
		
		JLabel stockPUP4 = new JLabel("0");
		stockPUP4.setBounds(576, 220, 70, 15);
		frame.getContentPane().add(stockPUP4);
		stockPUP4.setText(String.valueOf(Collections.frequency(game.getTeam().getPowerUps(), game.getCurrentShop().getPowerUpItems().get(3))));
		
		JLabel stockPUP5 = new JLabel("0");
		stockPUP5.setBounds(576, 253, 70, 15);
		frame.getContentPane().add(stockPUP5);
		stockPUP5.setText(String.valueOf(Collections.frequency(game.getTeam().getPowerUps(), game.getCurrentShop().getPowerUpItems().get(4))));
		
		JLabel stockPUP6 = new JLabel("0");
		stockPUP6.setBounds(576, 292, 70, 15);
		frame.getContentPane().add(stockPUP6);
		stockPUP6.setText(String.valueOf(Collections.frequency(game.getTeam().getPowerUps(), game.getCurrentShop().getPowerUpItems().get(5))));
		
		JLabel stockPUP7 = new JLabel("0");
		stockPUP7.setBounds(862, 222, 70, 15);
		frame.getContentPane().add(stockPUP7);
		stockPUP7.setText(String.valueOf(Collections.frequency(game.getTeam().getPowerUps(), game.getCurrentShop().getPowerUpItems().get(6))));
		
		JLabel stockPUP8 = new JLabel("0");
		stockPUP8.setBounds(862, 253, 70, 15);
		frame.getContentPane().add(stockPUP8);
		stockPUP8.setText(String.valueOf(Collections.frequency(game.getTeam().getPowerUps(), game.getCurrentShop().getPowerUpItems().get(7))));
		
		JLabel stockPUP9 = new JLabel("0");
		stockPUP9.setBounds(862, 288, 70, 15);
		frame.getContentPane().add(stockPUP9);
		stockPUP9.setText(String.valueOf(Collections.frequency(game.getTeam().getPowerUps(), game.getCurrentShop().getPowerUpItems().get(8))));
		
		JButton ApplyButton = new JButton("Apply To Hero");
		ApplyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (selectedPowerUp != "noItem") {
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
					JOptionPane.showMessageDialog(null, "THE POWER UP HAS APPLIED SUCCESSFULLY!");
					game.getTeam().getHeroArray().get(game.getCurrentHero()).usePowerUp(game.getTeam().getPowerUps().get(count));//.useHealingItem(game.getTeam().getHealingItems().get(count));
					frame.getContentPane().removeAll();
					frame.repaint();
					game.getTeam().setBarterSkillSum();
					powerUpDenPanel();
				} else {
					JOptionPane.showMessageDialog(null, "YOU DONT HAVE THIS ITEM!");
				}} else {
					JOptionPane.showMessageDialog(null, "YOU HAVE TO SELECT AN ITEM!");
				}
			}
		});
		ApplyButton.setBounds(196, 545, 215, 37);
		frame.getContentPane().add(ApplyButton);
		
		JButton ExitButton = new JButton("Exit");
		ExitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedPowerUp = "noItem";
				JOptionPane.showMessageDialog(null, game.randomEvent());
				frame.getContentPane().removeAll();
				frame.repaint();
				baseCampPanel();
			}
		});
		ExitButton.setBounds(520, 545, 215, 37);
		frame.getContentPane().add(ExitButton);
		
		JLabel wall = new JLabel("");
		wall.setBounds(0, 0, 932, 616);
		frame.getContentPane().add(wall);
		wall.setIcon(new ImageIcon(new ImageIcon(gameEnvGui.class.getResource("/Images/powerUpDenWall.png")).getImage().getScaledInstance(940, 642, Image.SCALE_DEFAULT)));
	}
	
	private void teamInitializerPanel() {
		frame.getContentPane().setLayout(null);
		
		JLabel lblNameHero = new JLabel("");
		lblNameHero.setFont(new Font("Arial Black", Font.ITALIC, 18));
		lblNameHero.setHorizontalAlignment(SwingConstants.CENTER);
		lblNameHero.setBounds(10, 401, 914, 49);
		frame.getContentPane().add(lblNameHero);
		
		heroNameEntryBox = new JTextField(); 
		heroNameEntryBox.setHorizontalAlignment(SwingConstants.CENTER);
		heroNameEntryBox.setBounds(360, 462, 208, 31);
		frame.getContentPane().add(heroNameEntryBox);
		heroNameEntryBox.setColumns(10);
		heroNameEntryBox.setEnabled(false);
		
		JLabel lblNameClashMessage = new JLabel("INVALID ENTRY: Another hero has taken this name; please enter a different name.");
		lblNameClashMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblNameClashMessage.setForeground(new Color(255, 0, 0));
		lblNameClashMessage.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNameClashMessage.setBounds(10, 365, 914, 25);
		frame.getContentPane().add(lblNameClashMessage);
		lblNameClashMessage.setVisible(false);
		
		JButton btnAddToTeam = new JButton("");
		btnAddToTeam.setForeground(new Color(255, 255, 255));
		btnAddToTeam.setBackground(new Color(75, 0, 130));
		
		btnAddToTeam.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		btnAddToTeam.setBounds(360, 493, 208, 53);
		frame.getContentPane().add(btnAddToTeam);
		
		btnAddToTeam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(game.getTeam().getHeroArray().size() >= 1) {
					
						boolean nameChecked = false;
						String name = heroNameEntryBox.getText();
					
						for (int i = 0; i < game.getTeam().getHeroArray().size(); i++) {
								if (name.equals(game.getTeam().getHeroArray().get(i).getName())) {
										lblNameClashMessage.setVisible(true);
										nameChecked = true;}}
					
						if (nameChecked == false) {
								heroToAdd.setHeroName(heroNameEntryBox.getText());
								game.getTeam().getHeroArray().add(heroToAdd);	
								if (numOfHeroes == game.getTeam().getHeroArray().size()) {
										frame.getContentPane().removeAll();
										frame.repaint();
										teamNamePanel();} 
								else {
										frame.getContentPane().removeAll();
										frame.repaint();
										teamInitializerPanel();}}} 
				
				else {
						
						heroToAdd.setHeroName(heroNameEntryBox.getText());
						game.getTeam().getHeroArray().add(heroToAdd);
						if (numOfHeroes == game.getTeam().getHeroArray().size()) {
								frame.getContentPane().removeAll();
								frame.repaint();
								teamNamePanel();} 
						else {
								frame.getContentPane().removeAll();
								frame.repaint();
								teamInitializerPanel();}
				}
				if (heroToAdd.getHeroClass() == "Cartographer") {
					game.giveMap();
				} else if (heroToAdd.getHeroClass() == "LuckyBoii") {
					game.giveLuck();
				}
			}
		});
		btnAddToTeam.setEnabled(false);
		
		
		
		
		JButton btnHeroType1 = new JButton("");
		btnHeroType1.setForeground(new Color(255, 255, 255));
		btnHeroType1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnHeroType1.setText("");
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
		frame.getContentPane().add(btnHeroType1);
		btnHeroType1.setIcon(new ImageIcon(new ImageIcon(gameEnvGui.class.getResource("/Images/merchant.png")).getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT)));
		
		
		
		
		JButton btnHeroType2 = new JButton("");
		btnHeroType2.setForeground(new Color(255, 255, 255));
		btnHeroType2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnHeroType2.setText("");
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
		frame.getContentPane().add(btnHeroType2);
		btnHeroType2.setIcon(new ImageIcon(new ImageIcon(gameEnvGui.class.getResource("/Images/tank.png")).getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT)));
		
		
		
		JButton btnHeroType3 = new JButton("");
		btnHeroType3.setForeground(new Color(255, 255, 255));
		btnHeroType3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnHeroType3.setText("");
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
		frame.getContentPane().add(btnHeroType3);
		btnHeroType3.setIcon(new ImageIcon(new ImageIcon(gameEnvGui.class.getResource("/Images/cartographer.png")).getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT)));

		
		
		
		JButton btnHeroType4 = new JButton("");
		btnHeroType4.setForeground(new Color(255, 255, 255));
		btnHeroType4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnHeroType4.setText("");
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
		frame.getContentPane().add(btnHeroType4);
		btnHeroType4.setIcon(new ImageIcon(new ImageIcon(gameEnvGui.class.getResource("/Images/support.png")).getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT)));

		
		
		
		JButton btnHeroType5 = new JButton("");
		btnHeroType5.setForeground(new Color(255, 255, 255));
		btnHeroType5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnHeroType5.setText("");
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
		frame.getContentPane().add(btnHeroType5);
		btnHeroType5.setIcon(new ImageIcon(new ImageIcon(gameEnvGui.class.getResource("/Images/lucky-boii.png")).getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT)));

		
		
		
		JButton btnHeroType6 = new JButton("");
		btnHeroType6.setForeground(new Color(255, 255, 255));
		btnHeroType6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnHeroType6.setText("");
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
		frame.getContentPane().add(btnHeroType6);
		btnHeroType6.setIcon(new ImageIcon(new ImageIcon(gameEnvGui.class.getResource("/Images/anti-hero.png")).getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT)));

		
		
		
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
		frame.getContentPane().add(lblMerchant);
		
		JLabel lblTank = new JLabel("TANK");
		lblTank.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTank.setHorizontalAlignment(SwingConstants.CENTER);
		lblTank.setBounds(191, 148, 117, 15);
		frame.getContentPane().add(lblTank);
		
		JLabel lblCartographer = new JLabel("CARTOGRAPHER");
		lblCartographer.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCartographer.setHorizontalAlignment(SwingConstants.CENTER);
		lblCartographer.setBounds(338, 148, 117, 15);
		frame.getContentPane().add(lblCartographer);
		
		JLabel lblSupport = new JLabel("SUPPORT");
		lblSupport.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSupport.setHorizontalAlignment(SwingConstants.CENTER);
		lblSupport.setBounds(484, 148, 117, 15);
		frame.getContentPane().add(lblSupport);
		
		JLabel lblLuckyboii = new JLabel("LUCKYBOII");
		lblLuckyboii.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblLuckyboii.setHorizontalAlignment(SwingConstants.CENTER);
		lblLuckyboii.setBounds(636, 148, 117, 15);
		frame.getContentPane().add(lblLuckyboii);
		
		JLabel lblAntihero = new JLabel("ANTI HERO");
		lblAntihero.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAntihero.setHorizontalAlignment(SwingConstants.CENTER);
		lblAntihero.setBounds(792, 148, 117, 15);
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
		
		
		
		JButton btnMerchantInfo = new JButton("CLASS INFO");
		btnMerchantInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, game.getMerchant().getFullInfo());	
			}
		});
		btnMerchantInfo.setForeground(new Color(255, 255, 255));
		btnMerchantInfo.setBackground(new Color(75, 0, 130));
		btnMerchantInfo.setBounds(34, 294, 117, 23);
		frame.getContentPane().add(btnMerchantInfo);
		
		
		
		JButton btnTankInfo = new JButton("CLASS INFO");
		btnTankInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, game.getTank().getFullInfo());
			}
		});
		btnTankInfo.setBackground(new Color(75, 0, 130));
		btnTankInfo.setForeground(new Color(255, 255, 255));
		btnTankInfo.setBounds(191, 294, 117, 23);
		frame.getContentPane().add(btnTankInfo);
		
		
		
		JButton btnCartographerInfo = new JButton("CLASS INFO");
		btnCartographerInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, game.getCartographer().getFullInfo());
			}
		});
		btnCartographerInfo.setForeground(new Color(255, 255, 255));
		btnCartographerInfo.setBackground(new Color(75, 0, 130));
		btnCartographerInfo.setBounds(338, 294, 117, 23);
		frame.getContentPane().add(btnCartographerInfo);
		
		
		
		JButton btnSupportInfo = new JButton("CLASS INFO");
		btnSupportInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, game.getSupport().getFullInfo());
			}
		});
		btnSupportInfo.setForeground(new Color(255, 255, 255));
		btnSupportInfo.setBackground(new Color(75, 0, 130));
		btnSupportInfo.setBounds(484, 294, 117, 23);
		frame.getContentPane().add(btnSupportInfo);
		
		
		
		JButton btnLuckyInfo = new JButton("CLASS INFO");
		btnLuckyInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, game.getLuckyBoii().getFullInfo());
			}
		});
		btnLuckyInfo.setForeground(new Color(255, 255, 255));
		btnLuckyInfo.setBackground(new Color(75, 0, 130));
		btnLuckyInfo.setBounds(636, 294, 117, 23);
		frame.getContentPane().add(btnLuckyInfo);
		
		
		
		JButton btnAntiHeroInfo = new JButton("CLASS INFO");
		btnAntiHeroInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, game.getAntiHero().getFullInfo());
			}
		});
		btnAntiHeroInfo.setBackground(new Color(75, 0, 130));
		btnAntiHeroInfo.setForeground(new Color(255, 255, 255));
		btnAntiHeroInfo.setBounds(792, 294, 117, 23);
		frame.getContentPane().add(btnAntiHeroInfo);
		
	}
	
	private void villianBeatPanel() {
		if (citiesFinished + 1 == game.getNumOfCities()) {
			finishGamePanel();
		} else {
		frame.getContentPane().setLayout(null);
		
		JLabel lblWellDone = new JLabel("WELL DONE ");
		lblWellDone.setHorizontalAlignment(SwingConstants.CENTER);
		lblWellDone.setFont(new Font("Arvo", Font.BOLD, 30));
		lblWellDone.setBounds(12, 52, 914, 53);
		frame.getContentPane().add(lblWellDone);
		lblWellDone.setText("WELL DONE TEAM " + game.getTeam().getName());
		
		JButton btnProceedToCamp = new JButton("PROCEED  TO  CAMP");
		btnProceedToCamp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				game.getTeam().addMoney(100);
				game.makeAllUnfound();
				if (game.hasMap()) {
					game.makeAllFound();
				}
				
				citiesFinished += 1;
				frame.getContentPane().removeAll();
				frame.repaint();
				
				if (citiesFinished < game.getNumOfCities()) {
					game.setCurrentVillian(citiesFinished);
					if (citiesFinished + 1 == game.getNumOfCities()) {
					game.getCurrentVillian().superVillian();
					}
					baseCampPanel();
				} else {
					
				}
			}
		});
		btnProceedToCamp.setFont(new Font("Dialog", Font.BOLD, 22));
		btnProceedToCamp.setBounds(287, 503, 339, 88);
		frame.getContentPane().add(btnProceedToCamp);
		}
	}
	
	
	private void finishGamePanel() {
		JButton btnFinishPlaythrough = new JButton("Complete Playthrough");
		btnFinishPlaythrough.setBackground(new Color(75, 0, 130));
		btnFinishPlaythrough.setForeground(new Color(255, 255, 255));
		btnFinishPlaythrough.setFont(new Font("Arvo", Font.BOLD, 30));
		btnFinishPlaythrough.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setFinished(true); 
				frame.getContentPane().removeAll();
				frame.repaint();
				gameEndPanel();    
			}
		});
		btnFinishPlaythrough.setBounds(274, 409, 405, 116);
		frame.getContentPane().add(btnFinishPlaythrough);
		
		JLabel lblCongratulatoryMessage = new JLabel("Congratuations, you have defeated the super villain and his crooked adherents!");
		lblCongratulatoryMessage.setFont(new Font("Arvo", Font.ITALIC, 22));
		lblCongratulatoryMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblCongratulatoryMessage.setBounds(12, 209, 914, 50);
		frame.getContentPane().add(lblCongratulatoryMessage);
		
		JLabel lblNewLabel_4 = new JLabel("VICTORY!");
		lblNewLabel_4.setFont(new Font("Arvo", Font.BOLD, 80));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(12, 12, 914, 122);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_6 = new JLabel("The cities are saved and the realm is secure!");
		lblNewLabel_6.setFont(new Font("Arvo", Font.ITALIC, 22));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(12, 260, 914, 50);
		frame.getContentPane().add(lblNewLabel_6);
	}
	
	
	private void gameEndPanel() {
		
		JButton btnExitGame_1 = new JButton("EXIT GAME");
		btnExitGame_1.setBackground(new Color(75, 0, 130));
		btnExitGame_1.setForeground(new Color(255, 255, 255));
		btnExitGame_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExitGame_1.setFont(new Font("Dialog", Font.BOLD, 50));
		btnExitGame_1.setBounds(279, 432, 398, 69);
		frame.getContentPane().add(btnExitGame_1);
		
		JLabel lblEndMessage = new JLabel("TEAM NAME: " + game.getTeam().getName());
		lblEndMessage.setForeground(new Color(0, 0, 0));
		lblEndMessage.setFont(new Font("Arvo", Font.BOLD, 40));
		lblEndMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblEndMessage.setBounds(12, 138, 914, 84);
		frame.getContentPane().add(lblEndMessage);
		
		JLabel lblDisplayGameTime = new JLabel("COMPLETION TIME: " + getGameTime() + " seconds.");
		lblDisplayGameTime.setForeground(new Color(0, 0, 0));
		lblDisplayGameTime.setFont(new Font("Arvo", Font.BOLD, 40));
		lblDisplayGameTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblDisplayGameTime.setBounds(12, 234, 914, 52);
		frame.getContentPane().add(lblDisplayGameTime);
		
		JLabel lblPlaythroughInfo = new JLabel("PLAYTHROUGH   INFORMATION");
		lblPlaythroughInfo.setForeground(new Color(0, 0, 0));
		lblPlaythroughInfo.setFont(new Font("Arvo", Font.BOLD, 50));
		lblPlaythroughInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlaythroughInfo.setBounds(12, 12, 914, 94);
		frame.getContentPane().add(lblPlaythroughInfo);
		
		JLabel lblOurThanks = new JLabel("Thank you for playing!");
		lblOurThanks.setForeground(new Color(0, 0, 0));
		lblOurThanks.setFont(new Font("EB Garamond 08", Font.ITALIC, 45));
		lblOurThanks.setHorizontalAlignment(SwingConstants.CENTER);
		lblOurThanks.setBounds(12, 368, 914, 52);
		frame.getContentPane().add(lblOurThanks);
	}
	
	private void lossGamePanel() {
		frame.getContentPane().setLayout(null);
		JButton btnExitGame_1 = new JButton("EXIT GAME");
		btnExitGame_1.setBackground(new Color(75, 0, 130));
		btnExitGame_1.setForeground(new Color(255, 255, 255));
		btnExitGame_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExitGame_1.setFont(new Font("Dialog", Font.BOLD, 50));
		btnExitGame_1.setBounds(279, 492, 398, 69);
		frame.getContentPane().add(btnExitGame_1);
		
		JLabel lblCongratulatoryMessage = new JLabel("Oh blast, your team was killed and you couldnt save the princess");
		lblCongratulatoryMessage.setFont(new Font("Arvo", Font.ITALIC, 22));
		lblCongratulatoryMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblCongratulatoryMessage.setBounds(12, 209, 914, 50);
		frame.getContentPane().add(lblCongratulatoryMessage);
		
		JLabel lblNewLabel_4 = new JLabel("YOU DEAD AF");
		lblNewLabel_4.setFont(new Font("Arvo", Font.BOLD, 80));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(12, 12, 914, 122);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_6 = new JLabel("Now your legacy will only throw shadow over you family");
		lblNewLabel_6.setFont(new Font("Arvo", Font.ITALIC, 22));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(12, 260, 914, 50);
		frame.getContentPane().add(lblNewLabel_6);
	}
}

