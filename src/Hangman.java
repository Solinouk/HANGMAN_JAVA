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

    public Hangman() {
    }

    //    The file where french words 8 letters long are listed in.
    private File file = new File("/home/solenne/Documents/GITHUB/HANGMAN_JAVA/src/words_8_letters.txt");
    Scanner sc;

    {
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    public void chose_word() {

        while (sc.hasNext()) {
            word = sc.next();
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

//        correct = word.contains(letter);

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


//    public void display_word(String word, ArrayList displayed) {
//
//
//
//
//
//    }

    public char getGood_letter() {
        return good_letter;
    }

    public Boolean getCorrect() {
        return correct;
    }

    public ArrayList<Integer> getIndex() {
        return index;
    }
}




