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

    public Hangman() {
    }

    //    The file where french words 8 letters long are listed in.
    private File file = new File("/home/solenne/Documents/GITHUB/HANGMAN_JAVA/src/words_8_letters.txt");
    Scanner scan;

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

    public String getPickWord() {
        return pickWord;
    }


    public void check_letter(char letter, String word) {
        index.clear();
        for (int i = 0; i < word.length(); i++) {
            list_word = word.toCharArray();

            if (list_word[i] == letter) {
                good_letter = letter;
                index.add(i);
            }
        }
        if (index.isEmpty()) {
            correct = false;
            System.out.println("Dommage...");

        } else {
            correct = true;
            System.out.println("Bravo !");
        }
    }

    public char[] display_word(String word, char[] displayed) {
        System.out.println(index);
        for (int i : index) {
            displayed[i]= good_letter;
        }
        System.out.println(displayed);
        return displayed;
    }


    public int game_over(String word, char[] displayed, int tries){

        correct = getCorrect();//

            if (correct) {
                System.out.println("bravo, vous avez trouvé une lettre du mot. ");
                if (Arrays.equals(displayed, word.toCharArray())){
                    System.out.println(" Vous avez trouvé le bon mot !");
                    System.out.println("Voulez-vous rejouer ? 'o' ");
                    rejoue = scan.next().charAt(0);
                    System.out.println(rejoue);
                    rejouer = Character.toLowerCase(rejoue);
                }
            }

            else{
                tries -= 1;
                System.out.println(tries);
                System.out.println("La lettre n'est pas dans le mot");
                if (tries == 0) {
                    System.out.println("Vous avez perdu. Le mot était " + word + ".");
                    System.out.println("Voulez-vous rejouer ? 'o' ");
                    rejoue = scan.next().charAt(0);
                    rejouer = Character.toLowerCase(rejoue);

                }
                if (tries > 0) {
                    System.out.println("Il vous reste " + tries + " essais.");
                }
            }
        return tries;
        }



    public char getGood_letter() {return good_letter;}

    public Boolean getCorrect() {return correct;}

    public ArrayList<Integer> getIndex() {return index;}

    public char getRejouer() {return rejouer;}

    public int getTries() {
        return tries;
    }
}





