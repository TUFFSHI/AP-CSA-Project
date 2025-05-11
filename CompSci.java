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
    public Question(String questionText, String[] options, int correctAnswerIndex,      String subject)
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
    //characterClass: String  // "History Mage", "Math Warrior", or "Code                 Wizard"
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
        Set name to given name
        Set characterClass to given characterClass
        Set health to 100
        Set maxHealth to 100
        Set attack to 10
        Set level to 1
        Set xp to 0
        Set xpToNextLevel to 5
        Initialize powerUps as an empty list

    Method attackEnemy(enemy):
        Calculate damage (equal to attack)
        Print "[player name] attacks for [damage] damage!"
        Call enemy.takeDamage(damage)

    Method takeDamage(amount):
        Subtract amount from health
        If health is less than 0, set health to 0
        Print "[player name] has [health] health remaining."

    Method heal(amount):
        Add amount to health
        If health is greater than maxHealth, set health to maxHealth
        Print "[player name] healed for [amount] health. Now has [health] health."

   Method addXP(amount):
        Add amount to xp
        Print "[player name] gained [amount] XP. Total: [xp]/[xpToNextLevel]"
        If xp is greater than or equal to xpToNextLevel,
            Call levelUp()
            Return true
        Return false

    Method levelUp():
        Increment level
        Increase maxHealth by 20
        Set health to maxHealth
        Increase attack by 5
        Set xp to 0
        Print "[player name] leveled up to level [level]!"
        Print "Health increased to [maxHealth]"
        Print "Attack increased to [attack]"
        Return true

    Method addPowerUp(powerUp):
        Add powerUp to powerUps list
        Print "[player name] gained the [powerUp] power-up!"

   Method usePowerUp(enemy, powerUpIndex):
        If powerUpIndex is valid (within bounds of powerUps list):
            powerUp = Remove powerUp from powerUps list at powerUpIndex

            If powerUp is "Double Attack":
                Print "[player name] uses Double Attack!"
                Call attackEnemy(enemy)
                Call attackEnemy(enemy)
            Else If powerUp is "Heal":
                Print "[player name] uses Heal!"
                Call heal(30)
            Else If powerUp is "Shield":
                Print "[player name] uses Shield for the next attack!"
                // Shield implementation would be handled in the battle logic, likely in the Game class
        Else:
            Print "Invalid power-up index."

    Method displayStats():
        Print "Name: " + name
        Print "Class: " + characterClass
        Print "Level: " + level
        Print "Health: " + health + "/" + maxHealth
        Print "Attack: " + attack
        Print "XP: " + xp + "/" + xpToNextLevel
        Print "Power-ups: " + powerUps

    Method getName():
        Return name

    Method getCharacterClass():
        Return characterClass

    Method getHealth():
        Return health

    Method getMaxHealth():
        Return maxHealth

    Method getAttack():
        Return attack

    Method getLevel():
        Return level

    Method getXp():
        Return xp

    Method getXpToNextLevel():
        Return xpToNextLevel

    Method getPowerUps():
        Return powerUps



