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
        //Print "Name: " + name
        //Print "Class: " + characterClass
        //Print "Level: " + level
        //Print "Health: " + health + "/" + maxHealth
        //Print "Attack: " + attack
        //Print "XP: " + xp + "/" + xpToNextLevel
        //Print "Power-ups: " + powerUps

    //Method getName():
        //Return name

    //Method getCharacterClass():
        //Return characterClass

    //Method getHealth():
        //Return health

    //Method getMaxHealth():
        //Return maxHealth

    //Method getAttack():
        //Return attack

    //Method getLevel():
        //Return level

    //Method getXp():
        //Return xp

    //Method getXpToNextLevel():
        //Return xpToNextLevel

    //Method getPowerUps():
        //Return powerUps



