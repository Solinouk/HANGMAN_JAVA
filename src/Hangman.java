import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.Random;


public class Hangman {

    String word;
    char[] list_word;
    char good_letter;
    Boolean correct;
    ArrayList<Integer> index = new ArrayList<Integer>();
    ArrayList<String> words_list = new ArrayList<String>();
    String pickWord;
    int count = 0;
    Random nb;
    int trials;
    char repl;
    char replay;
    Boolean over = false;
    private Scanner sc = new Scanner(System.in);


    public  Hangman() {
    }

    //    The file where french words 8 letters long are listed in.
    private File file = new File("./src/words_8_letters.txt");
    private Scanner scan;

    {
        try {
            scan = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

// chose a word randomly in a file
    public void chose_word() {

        while (scan.hasNext()) {
            word = scan.next();
            count += 1;
            words_list.add(word);
        }
        nb = new Random();
        int n = nb.nextInt(count);
        pickWord = words_list.get(n);

    }


    //        check if the letter chosen by the player is in the word and store the index of
    //        the good letter and the letter itself
    public void check_letter(char letter, String word) {
        index.clear();

        for (int i = 0; i < word.length(); i++) {
            list_word = word.toCharArray();

            if (list_word[i] == letter) {
                good_letter = letter;
                index.add(i);
            }
        }
//        if the index is emtpy, that means that there's no match between the letter chose and the word.
//        correct =true if a letter matches
        if (index.isEmpty()) {
            correct = false;
            System.out.println("Dommage...");

        } else {
            correct = true;
            System.out.println("Bravo !");
        }
    }

//    replace each hidden letter by the good letter. If no letter matches, nothing change
    public char[] display_word(String word, char[] displayed) {
        for (int i : index) {
            displayed[i]= good_letter;
        }
        System.out.println(displayed);
        return displayed;
    }


//    check if the game is finished
    public int game_over(String word, char[] displayed, int trials){

        correct = getCorrect();
//        if letter is correct, nomber of trials don't change
            if (correct) {
                System.out.println("bravo, vous avez trouvé une lettre du mot. ");
//                then check if the word is correct. In this case, the game is finished

                if (Arrays.equals(displayed, word.toCharArray())){
                    System.out.println(" Vous avez trouvé le bon mot !");
                    over = true;
                }
            }
// if letter is not correct
            else{
//              number of trials decreases
                trials -= 1;
                System.out.println(trials);
                System.out.println("La lettre n'est pas dans le mot");
//                then if there's no trials anymore, ask player if he wants to play again
                if (trials == 0) {
                    System.out.println("Vous avez perdu. Le mot était " + word + ".");
                    over = true;
                }
//                then if there are still some trials, indicates how many trials remain
                if (trials > 0) {
                    System.out.println("Il vous reste " + trials + " essais.");
                }
            }
        return trials;
        }

//        if game is finished, ask player if he wants to play again
    public char replay() {
        System.out.println("Voulez-vous replay ? 'o' ");
        repl = sc.next().charAt(0);
        replay = Character.toLowerCase(repl);
        return replay;
    }



    public char getGood_letter() {return good_letter;}
    public String getPickWord() {
        return pickWord;
    }

    public Boolean getCorrect() {return correct;}

    public ArrayList<Integer> getIndex() {return index;}

    public char getReplay() {
        return replay;
    }

    public int getTrials() {
        return trials;
    }

    public Boolean getOver() {
        return over;
    }
}


//
//
//;
