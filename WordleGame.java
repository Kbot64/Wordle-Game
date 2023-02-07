import java.util.*;
import java.io.*;


public class WordleGame{

    public static ArrayList<String> wordleAnswerList = new ArrayList<String>();
    public static ArrayList<String> allowedGuesses = new ArrayList<String>();
    private String wordleWord;
    private ArrayList<String> alphabet = new ArrayList<String>();
    private String[] letters = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "w", "X", "Y", "Z"};
    private int maxGuesses = 6;
    private int numGuesses;
    private ArrayList<String> solution;
    Scanner input = new Scanner(System.in);


    public WordleGame() {
        wordleWord = wordleAnswerList.get((int)(Math.random() * wordleAnswerList.size()));
        System.out.println(wordleWord);
        for(int i = 0; i < letters.length; i++) {
        alphabet.add(letters[i]);
        }
        numGuesses = 0;


    }

    /**
     * @param guess
     * @return
     */
    public String getGuess() {
        String guess = "";
        if(numGuesses <= maxGuesses && !validate(guess)) {
            numGuesses++;
            System.out.println("What is your guess? ");
            guess = input.nextLine();
            System.out.println("Guess " + numGuesses + ": " + guess);
            checkWordle(guess);
        }
        return guess;
    }

    /**
     * @param word
     * @return
     */
    public boolean validate(String word) {
        if(word.length() <= 5 && wordleAnswerList.contains(word)) {
            return true;
        } else {
            return false;
        }
    }
    
    public void checkWordle(String word) {
        for(int i = 0; i < word.length(); i++) {
          if(wordleWord.substring(i, i + 1).equals(word.substring(i, i + 1))) {
            solution.add(word.substring(i, i + 1));
          }
        }
    }  


  

//static blocks get run when the class is loaded
static{
   //creates an arraylist of of all the possible wordle answers from the txt file
   try {
      Scanner input = new Scanner(new File("Wordle_Answers.txt"));
      while(input.hasNextLine()){
        String temp = input.nextLine().trim();
        wordleAnswerList.add(temp);
      }
      input.close();
    }
    catch(Exception e){
      //System.out.println("Error reading or parsing wordle_answers.txt\n" + e);
    } 

       //creates an arraylist of of all the possible guesses from the txt file
   try {
      Scanner input = new Scanner(new File("Wordle_Allowed_Guesses.txt"));
      while(input.hasNextLine()){
        String temp = input.nextLine().trim();
        allowedGuesses.add(temp);
      }
      input.close();
    }
    catch(Exception e){
      //System.out.println("Error reading or parsing wordle_answers.txt\n" + e);
    }   
        //System.out.println(allowedGuesses);

  

}
}
