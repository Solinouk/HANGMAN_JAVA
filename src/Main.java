import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        String word;
        char[] displayed;
        Player p = new Player();
        Hangman h = new Hangman();
        int trial;
        p.chose_name();
        h.chose_word();
        trial = 10;
        char rejouer = 'o';

        while (rejouer == 'o') {
            word = h.getPickWord();
            displayed = new char[8];
            for (int i = 0; i < 8; i++) {
                displayed[i] = '-';
            }

            while (true) {
                p.chose_letter();
                char letter = p.getLetter();
                h.check_letter(letter, word);
                h.display_word(word, displayed);
                h.game_over(word, displayed, trial);
                trial = h.getTries();
                rejouer = h.getRejouer();
            }
        }
    }
}
