# AP-CSA-Project
//Video Game for learning and studying the material covered in AP Modern World
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

// Class: Question
class Question {
// Properties:
// Create variables that store information about each question
//questionText: String  // Stores the text of the question itself
private String questionText;
//options: Array of String // Stores the possible answers as a list of text choices
public String[] options;
//correctAnswerIndex: Integer // Stores the index of the correct answer within the options list.
private int correctAnswerIndex;
//subject: String // Stores the subject or category of the question
private String subject
    

    // Constructor:
    // This method creates a new Question object
    // Set the questionText variable to the value provided for the question text
    // Set the options variable to the list of answer options provided
    // Set the correctAnswerIndex variable to the index of the correct answer
    // Set the subject variable to the subject of the question
    public Question(String questionText, String[] options, int correctAnswerIndex, String subject)
    {
        //set questionText to text
        this.questionText = questionText;
        //set options to optionsArray
        this.options = options;
        //set correctAnswerIndex to correctIndex
        this.correctAnswerIndex = correctAnswerIndex;
        //set subject to sub
        this.subject = subject;
    }
    // isCorrect:
      // This method checks if the player's answer is the correct answer
      // Check if the playerAnswer is equal to the correctAnswerIndex
      // If they are equal, return true which means the answer is correct
      // Otherwise, return false which means the answer is incorrect
    public boolean isCorrect(int playerAnswer)
    {
        return playerAnswer == correctAnswerIndex;
    }

    // display:
    // This method shows the question and its answer options to the player
    // Print the questionText to display the question
    // Loop through each option in the options list, keeping track of its index
    // For each option, print its number (index + 1) followed by a period and the      option text
    public void display()
    {
        //print questionText
        System.out.println(questionText);
        //For each option with index i in options: print (i + 1) + ". " + option
        for (int i = 0; i < options.length; i++)
        {
            System.out.println((i + 1) + ". " + options[i]);
        }
        // End the for loop
    }

    // getQuestionText:
    // Returns the question text
    public String getQuestionText()
    {
        //return questionText
        return questionText;
    }

    // getOptions:
    // Returns the options array
    public String[] getOptions()
    {
        //return options
        return options;
    }

    // getCorrectAnswerIndex:
    // Returns the index of the correct answer
    public int getCorrectAnswerIndex()
    {
        // return correctAnswerIndex
        return correctAnswerIndex;
    }

    // getSubject:
    // Returns the subject of the question
    public String getSubject() 
    {
        //return subject
        return subject;
    }
// End Class: Question
}
//Class Player
class Player
{
    //Properties:
    //name: String
    public String name;
    //characterClass: String  // "History Mage", "Math Warrior", or "Code Wizard"
    public String characterClass;
    //health: Integer
    public int health;
    //maxHealth: Integer
    private int maxHealth;
    //attack: Integer
    private int attack;
    //level: Integer
    public int level;
    //xp: Integer
    private int xp;
    //xpToNextLevel: Integer
    private int xpToNextLevel;
    //powerUps: List of String
    private ArrayList<String> powerUps;

    //Constructor:
    public Player(String name, String characterClass)
    {
        //Set name to given name
        this.name = name;
        //Set characterClass to given characterClass
        this.characterClass = characterClass;
        //Set health to 100
        this.health = 100;
        //Set maxHealth to 100
        this.maxHealth = 100;
        //Set attack to 10
        this.attack = 10;
        //Set level to 1
        this.level = 1;
        //Set xp to 0
        this.xp = 0;
        //Set xpToNextLevel to 5
        this.xpToNextLevel = 5;
        //Initialize powerUps as an empty list
        this.powerUps = new ArrayList<String>();
    }

    //Method attackEnemy(enemy):
    public void attackEnemy(Enemy enemy)
    {
        //Calculate damage (equal to attack)
        int damage = attack;
        //Print "[player name] attacks for [damage] damage!"
        System.out.println(name + " attacks for " + damage + " damage!");
        //Call enemy.takeDamage(damage)
        enemy.takeDamage(damage);
    }

    //Method takeDamage(amount):
    public void takeDamage(int amount)
    {
        //Subtract amount from health
        health -= amount;
        //If health is less than 0, set health to 0
        if (health < 0)
        {
            health = 0;
        }
        //Print "[player name] has [health] health remaining."
        System.out.println(name + " has " + health + " health remaining.")
    }

    //Method heal(amount):
    public void heal(int amount)
    {
        //Add amount to health
        health += amount;
        //If health is greater than maxHealth, set health to maxHealth
        if (health > maxHealth)
        {
            health = maxHealth;
        }
        //Print "[player name] healed for [amount] health. Now has [health] health."
        System.out.println(name + " healed for " + amount + " health. Now has " + health + " health.");
    }

   //Method addXP(amount):
    public boolean addXp(int amount)
    {
        //Add amount to xp
        xp += amount;
        //Print "[player name] gained [amount] XP. Total: [xp]/[xpToNextLevel]"
        System.out.println(name + " gained " + amount + " XP. Total: " + xp + "/" + xptoNextLevel);
        //If xp is greater than or equal to xpToNextLevel,
        if (xp >= xpToNextLevel)
        {
            //Call levelUp()
            return levelUp();
            //Return true
        }
        //Return false
        return false;
    }

    //Method levelUp():
    public boolean levelUp()
    {
        //Increment level
        level++;
        //Increase maxHealth by 20
        maxHealth += 20;
        //Set health to maxHealth
        health = maxHealth;
        //Increase attack by 5
        attack += 5;
        //Set xp to 0
        xp = 0;
        //Print "[player name] leveled up to level [level]!"
        System.out.println(name + " leveled up to level " + level + "!");
        //Print "Health increased to [maxHealth]"
        System.out.println("Health increased to " + maxHealth);
        //Print "Attack increased to [attack]"
        System.out.println("Attack increased to " + attack);
        //Return true
        return true;
    }

    //Method addPowerUp(powerUp):
    public void addPowerUp(String powerUp)
    {
        //Add powerUp to powerUps list
        powerUps.add(powerUp);
        //Print "[player name] gained the [powerUp] power-up!"
        System.out.println(name + " gained the " powerUp + " power-up!");
    }

   //Method usePowerUp(enemy, powerUpIndex):
    public void usePowerUp(Enemy enemy, int powerUpIndex)
    {
        //If powerUpIndex is valid
        if (powerUpIndex >= 0 && powerUpIndex < powerUps.size())
        {
            //powerUp = Remove powerUp from powerUps list at powerUpIndex
            String powerUp = powerUps.remove(powerUpIndex);

            //If powerUp is "Double Attack":
            if (powerUp.equals("Double Attack"))
            {
                //Print "[player name] uses Double Attack!"
                System.out.println(name + " uses Double Attack!");
                //Call attackEnemy(enemy)
                attackEnemy(enemy);
                //Call attackEnemy(enemy)
                attackEnemy(enemy);
            }
            //Else If powerUp is "Heal":
            else if (powerUp.equals("Heal"))
            {
                //Print "[player name] uses Heal!"
                System.out.println(name + " uses Heal!");
                //Call heal(30)
                heal(30);
            }
            //Else If powerUp is "Shield":
            else if (powerUp.equals("Shield"))
            {
                //Print "[player name] uses Shield for the next attack!"
                System.out.println(name + " uses Shield for the next attack!");
                // Shield implementation is in the game class
            }
        }
        //Else:
        else
        {
            //Print "Invalid power-up index."
            System.out.println("Invalid power-up index.");
        }
    }

    //Method displayStats():
    public void displayStats()
    {
        //Print "Name: " + name
        System.out.println("Name: " + name);
        //Print "Class: " + characterClass
        System.out.println("Class: " + characterClass);
        //Print "Level: " + level
        System.out.println("Level: " + level);
        //Print "Health: " + health + "/" + maxHealth
        System.out.println("Health: " + health + "/" + maxHealth);
        //Print "Attack: " + attack
        System.out.println("Attack: " + attack);
        //Print "XP: " + xp + "/" + xpToNextLevel
        System.out.println("XP: " + xp + "/" + xpToNextLevel);
        //Print "Power-ups: " + powerUps
        System.out.println("Power-ups: " + powerUps);
    }

    //Method getName():
    public String getName()
    {
        //Return name
        return name;
    }

    //Method getCharacterClass():
    public String getCharacterClass()
    {
        //Return characterClass
        return characterClass;
    }

    //Method getHealth():
    public int getHealth()
    {
        //Return health
        return health;
    }

    //Method getMaxHealth():
    public int getMaxHealth()
    {
        //Return maxHealth
        return maxHealth;
    }
    //Method getAttack():
    public int getAttack()
    {
        //Return attack
        return attack;
    }

    //Method getLevel():
    public int getAttack()
    {
        //Return level
        return level;
    }

    //Method getXp():
    public int getXp()
    {
        //Return xp
        return xp;
    }

    //Method getXpToNextLevel():
    public int getXpToNextLevel()
    {
        //Return xpToNextLevel
        return xpToNextLevel;
    }

    //Method getPowerUps():
    public ArrayList<String> getPowerUps()
    {
        //Return powerUps
    }
}
//Class Enemy
class Enemy
{
    //Properties:
    //name: String
    public String name;
    //health: Integer
    public int health;
    //attack: Integer // private
    private int attack;
    //level: Integer
    public int levell
    //random: Random (Random number generator)
    private Random random;
        
    //Constructor(playerLevel):
    public Enemy(int PlayerLevel)
    {
        //Set level to playerLevel
        this.level = playerLevel;
        //Set health to 50 + (10 * level)
        this.health = 50 + (10 * level);
        //Set attack to 5 + (3 * level)
        this.attack = 5 + (3 * level);
        //Initialize random as a new Random object
        this.random = new Random();

        // Generate enemy name based on historical figures
        //names: Array of Strings = ["Alexander", "Caesar", "Cleopatra", "Napoleon", "Genghis Khan"]
        String[] names = {"Alexander", "Caeser", "Cleopatra", "Napoleon", "Genghis Khan"};
        //Set name to names[random.nextInt(length of names)] + " (Level " + level + ")"
        this.name = names[random.nextInt(names.length)] + " (Level " + level + ")";
    }

    //Method attackPlayer(player):
    public void attackPlayer(Player player)
    {
        //Print "[enemy name] attacks for [attack] damage!"
        System.out.println(name + " attacks for " + attack + " damage!");
        //Call player.takeDamage(attack)
        player.takeDamage(attack);
    }

    //Method takeDamage(amount):
    public void takeDamage(int amount)
    {
        //Subtract amount from health
        health -= amount;
        //If health is less than 0, set health to 0
        if (health < 0)
        {
            health = 0;
        }
        //Print "[enemy name] has " + health + " health remaining."
        System.out.println(name + " has " + health + " health remaining.");
    }
    //Method getName():
    public String getName()
    {
        //Return name
        return name;
    }

    //Method getHealth():
    public int getHealth()
    {
        //Return health
        return health;
    }

    //Method getAttack(): //Added getAttack()
    public int getAttack()
    {
        //Return attack
        return attack;
    }

    //Method getLevel():
    public int getLevel()
    {
        //Return level
        return level;
    }
}
//Class Game
class Game
{
    //Properties:
        //player: Player
    private Player player;
        //questions: ArrayList of Question
    private ArrayList<Question> questions;
        //scanner: Scanner
    private Scanner scanner;
        //gameRunning: Boolean
    private boolean gameRunning;
        //random: Random
    private Random random;

    //Constructor()
    public Game
    {
        //Initialize scanner
        scanner = new Scanner(System.in);
        //Set gameRunning to true
        gameRunning = true;
        //Initialize questions as a new ArrayList of Question
        questions = new ArrayList<Question>();
        //Initialize random as a new Random object
        random = new Random();
    }

    //Method start()
    public void start()
    {
        //Call initializeGame()
        initializeGame();
        //Call mainMenu()
        mainMenu();
    }

    //Method initializeGame()
    public void initializeGame()
    {
        //Print "Welcome to AP World History Battle Game!"
        System.out.println("Welcome to AP World History Battle Game!");
        //Call loadQuestions()
        loadQuestions();
        //Call createPlayer()
        createPlayer();
    }

    //Method loadQuestions()
    public void loadQuestions()
    {
        //Create question objects and add them to the questions list
        String[] q1Options = {"Mesopotamia", "Egypt", "Indus Valley", "China"};
        questions.add(new Question("Which civilization is considered the oldest?",q1Options,0,"Ancient History"));
        String[] q2Options = {"1492", "1776", "1066", "1215"};
        questions.add(new Question("In what year did Columbus reach the Americas?",q2Options,0,"World Exploration"));
        String[] q3Options = {"Karl Marx", "Adam Smith", "John Maynard Keynes", David Ricardo"};
        questions.add(new Question("Who wrote 'The Wealth of Nations'?",q3Options,1,"Economics"));
        String[] q4Options = {"Woodrow Wilson", "Franklin D. Roosevelt", "Harry S. Truman", "Dwight D. Eisenhower"};
        questions.add(new Question("Which U.S. president is associated with the New Deal?",q4Options,1,"US History"));
        String[] q5Options = {"Socrates", "Plato", "Aristotle", "Epicurus"};
        questions.add(new Question("Who was the teacher of Alexander the Great?",q5Options,2,"Ancient Greece"));
        String[] q6Options = {"Buddhism", "Christianity", "Islam", "Hinduism"};
        questions.add(new Question("Which religion originated in India?",q6Options,3,"World Religions"));
        String[] q7Options = {"The printing press", "The compass", "Gunpowder", "The steam engine"};
        questions.add(new Question("Which invention is attributed to Johannes Gutenberg?",q7Options,0,"Renaissance"));
        String[] q8Options = {"The French Revolution", "The American Revolution", "The Russian Revolution", "The Industrial Revolution"};
        questions.add(new Question("Which revolution began in 1789?",q8Options,0,"European History"));
        String[] q9Options = {"Japan", "China", "Korea", "Vietnam"};
        questions.add(new Question("In which country did the Meiji Restoration take place?",q9Options,0,"East Asian History"));
        String[] q10Options = {"Nelson Mandela", "Mahatma Ghandhi", "Martin Luther King Jr.", "Jawaharlal Nehru"};
        questions.add(new Question("Who led the Salt March in India?",q10Options,1,"World Decolonization"));
        System.out.println(questions.size() + " questions loaded.");
    }

    //Method createPlayer()
    public void createPlayer()
    {
        //Print "Enter your name:"
        System.out.println("Enter your name:");
        //Read player's name from scanner
        String name = scanner.nextLine();
        //Print character class options
        System.out.println("Choose your character class:");
        //Read player's character class choice from scanner
        System.out.println("1. History Mage - specializes in ancient history");
        System.out.println("2. Math Warrior - specializes in dates and numbers");
        System.out.println("3. Code Wizard - specializes in modern history");
        int choice = 0;
        if (scanner.hasNextInt())
        {
            choice = scanner.nextInt();
        } 
        else
        {
            System.out.println("Invalid input. Please enter a number between 1 and 3. Defaulting to History Mage.");
            choice = 1;
        }
        scanner.nextLine();
        String characterClass = "";
        if (choice == 1)
        {
            characterClass = "History Mage";
        }
        else if (choice == 2)
        {
            characterClass = "Math Warrior";
        }
        else if (choice == 3)
        {
            characterClass = "Code Wizard";
        }
        else
        {
            characterClass = "History Mage";
            System.out.println("Invalid choice. Defaulting to History Mage.");
        }
        //Create a new Player object with the given name and character class
        player = new Player(name, characterClass);
        //Print a welcome message
        System.out.println("Welcome, " + player.name + " the " + player.characterClass + "!");
    }

    //Method mainMenu()
    public void mainMenu()
    {
        //While gameRunning is true:
        while (gameRunning)
        {
            //Print main menu options
            System.out.println("\n=== MAIN MENU ===");
            System.out.println("1. Start Battle");
            System.out.println("2. View Stats");
            System.out.println("3. Exit Game");
            //Read player's choice from scanner
            int choice = 0;
            if (scanner.hasNextInt())
            {
                choice = scanner.nextInt();
            }
            else
            {
                System.out.println("Invalid input. Please enter a number between 1 and 3.");
                scanner.next();
            }
            scanner.nextLine();
            //If choice is 1:
            if (choice == 1)
            {
                //Call startBattle()
                startBattle();
            }
            //Else if choice is 2:
            else if (choice == 2)
            {
                //Call player.displayStats()
                player.displayStats();
            }
            //Else if choice is 3:
            else if (choice == 3)
            {
                //Call exitGame()
                exitGame();
            }
            //Else:
            else
            {
                //Print "Invalid choice. Try again."
                System.out.println("Invalid choice. Try again.");
            }
        }
    }

    //Method startBattle()
    public void startBattle()
    {
        //Create a new Enemy object
        Enemy enemy = new Enemy(player.level);
        //Print enemy introduction
        System.out.println("A new challenger approaches: " + enemy.name);
        //While enemy's health is greater than 0 and player's health is greater than 0:
        while (enemy.health > 0 && player.health > 0)
        {
            //Get a random question from the questions list
            Question question = questions.get(random.nextInt(questions.size()));
            //Display the question and its options
            question.display();
            //Read player's answer from scanner
            System.out.println("Enter your answer (1-" + question.options.length + "):");
            int answer = 0;
            //If player's answer is valid:
            if (scanner.hasNextInt())
            {
                answer = scanner.nextInt() - 1;
            }
            else
            {
                System.out.println("Invalid input. The enemy attacks!");
                scanner.next();
                enemy.attackPlayer(player);
                if (player.health <= 0)
                {
                    break;
                }
            }
            scanner.nextLine();
            if (answer >= 0 && answer < question.options.length)
            {
                //If the answer is correct:
                if (question.isCorrect(answer))
                {
                    //Print "Correct answer!"
                    System.out.println("Correct answer!");
                    //Call player.attackEnemy(enemy)
                    player.attackEnemy(enemy);
                    //Chance to get power-up
                    if (random.nextInt(10) < 3)
                    {
                        //Add a random power-up to the player
                        String[] powerUps = {"Double Attack", "Heal", "Shield"};
                        player.addPowerUp(powerUps[random.nextInt(powerUps.length)]);
                        //Ask player if they want to use a power-up
                        if (player.getPowerUps().size() > 0)
                        {
                            System.out.println("Do you want to use a power-up? (1-Yes, 0-No)");
                            int usePowerUpChoice = 0;
                            if (scanner.hasNextInt())
                            {
                                usePowerUpChoice = scanner.nextInt();
                            }
                            else
                            {
                                System.out.println("Invalid Input. Not using power-up");
                                scanner.next();
                                usePowerUpChoice = 0;
                            }
                            scanner.nextLine();
                            //If player chooses to use a power-up:
                            if (usePowerUpChoice == 1)
                            {
                                System.out.println("Choose a power-up:");
                                //Display available power-ups
                                for (int i = 0; i < player.getPowerUps().size(); i++)
                                {
                                    System.out.println((i + 1) + ". " + player.getPowerUps().get(i));
                                }
                                int powerUpChoice = 0;
                                if (scanner.hasNextInt())
                                {
                                    //Get power-up choice from player
                                    powerUpChoice = scanner.nextInt() - 1;
                                }
                                else
                                {
                                    System.out.println("Invalid power up choice.");
                                    scanner.next();
                                    powerUpChoice = -1;
                                }
                                scanner.nextLine();
                                //Call player.usePowerUp(enemy, powerUpChoice)
                                player.usePowerUp(enemy, powerUpChoice);
                            }
                        }
                    }
                }
                //Else:
                else
                {
                    //Print "Incorrect answer!"
                    System.out.println("Incorrect answer! The correct answer was: " + (question.getCorrectAnswerIndex() + 1) + ". " + question.getOptions()[question.getCorrectAnswerIndex()]);
                    //Call enemy.attackPlayer(player)
                    enemy.attackPlayer(player);
                }
                    
            
            }
            //Else:
            else
            {
                
                //Print "Invalid answer! The enemy attacks!"
                System.out.println("Invalid answer! The enemy attacks!");
                //Call enemy.attackPlayer(player)
                enemy.attackPlayer(player);
            }
                //Check if battle is over
            //If enemy's health is 0 or less:
            if (enemy.getHealth() <= 0)
            {
                //Print "Victory!"
                System.out.println("Victory! You defeated " + enemy.getName() + "!");
                //Call player.addXP(1)
                boolean leveledUp = player.addXP(1);
                //If player leveled up:
                if(leveledUp)
                {
                    //Print "Enemies will be stronger now!"
                    System.out.println("Enemies will be stronger now!");
                }
                //Break from the loop
                break;
            }
            //If player's health is 0 or less:
            if (player.health <= 0)
            {
                //Print "Defeat!"
                System.out.println("Defeat! " + enemy.getName() + " has defeated you!");
                //Break from the loop
                break;
            }
        }
    }
    //Method exitGame()
    public void exitGame()
    {
        //Print "Thanks for playing AP World History Battle Game!"
        System.out.println("Thanks for playing AP World History Battle Game!");
        //Set gameRunning to false
        gameRunning = false;
    }
}
//Main Program Execution
public class Main
{
    public static void main(String[] args)
    {
        Game game = new Game();
        game.start();
    }
}
        








