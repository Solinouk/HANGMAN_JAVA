import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.Random;


public class Hangman {

    String word;
    char[] list_word;
    String letter;
    char good_letter;
    Boolean correct;
    ArrayList<Integer> index = new ArrayList<Integer>();
    ArrayList<String> words_list = new ArrayList<String>();
    String pickWord;
    int count = 0;
    Random nb;
    int tries ;
    char rejoue;
    char rejouer ;
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


    public void chose_word() {

        while (scan.hasNext()) {
            word = scan.next();
            count += 1;
            words_list.add(word);
        }
        nb = new Random();
        int n = nb.nextInt(count);
        pickWord = words_list.get(n);
        System.out.println(pickWord);
    }




    public void check_letter(char letter, String word) {
        index.clear();
//        check if the letter chosen by the player is in the word and store the index of the good letter and the letter itself
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
        System.out.println(index);
        for (int i : index) {
            displayed[i]= good_letter;
        }
        System.out.println(displayed);
        return displayed;
    }


//    check if the game is finished
    public void game_over(String word, char[] displayed, int tries){
//        rejouer = 'n';
        correct = getCorrect();
//        if letter is correct, nomber of trials don't change
            if (correct) {
                System.out.println("bravo, vous avez trouvé une lettre du mot. ");
//                then check if the word is correct
//                in case it is, ask the player if he wants to play again
                if (Arrays.equals(displayed, word.toCharArray())){
                    System.out.println(" Vous avez trouvé le bon mot !");
                    System.out.println("Voulez-vous rejouer ? 'o' ");
                    rejoue = sc.next().charAt(0);
                    System.out.println(rejoue);
                    rejouer = Character.toLowerCase(rejoue);
                }
                else {
                    return ;
                }
            }
// if letter is not correct
            else{
//              number of trials decreases
                tries -= 1;
                System.out.println(tries);
                System.out.println("La lettre n'est pas dans le mot");
//                then if there's no trials anymore, ask player if he wants to play again
                if (tries == 0) {
                    System.out.println("Vous avez perdu. Le mot était " + word + ".");
                    System.out.println("Voulez-vous rejouer ? 'o' ");
                    rejoue = sc.next().charAt(0);
                    rejouer = Character.toLowerCase(rejoue);

                }
//                then if there are still some trials, indicates how many trials remain
                if (tries > 0) {
                    System.out.println("Il vous reste " + tries + " essais.");
                }
            }
        
        }



    public char getGood_letter() {return good_letter;}
    public String getPickWord() {
        return pickWord;
    }

    public Boolean getCorrect() {return correct;}

    public ArrayList<Integer> getIndex() {return index;}

    public char getRejouer() {return rejouer;}

    public int getTries() {
        return tries;
    }
}





