import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        String word;
        char[] displayed;
        Player p = new Player();
        Hangman h = new Hangman();
        int trial;
        p.chose_name();
        trial = 10;
        Boolean over;
        char replay = 'o';

        while (replay == 'o') {
            h.chose_word();
            word = h.getPickWord();
            displayed = new char[8];
            for (int i = 0; i < 8; i++) {
                displayed[i] = '-';
            }
            over=false;

            while (over == false) {
                p.chose_letter();
                char letter = p.getLetter();
                h.check_letter(letter, word);
                h.display_word(word, displayed);

                trial =h.game_over(word, displayed, trial);
                over = h.getOver();
            }

            h.replay();
            replay = h.getReplay();

            if (replay != 'o') {
                System.out.println("A bientôt " + p.get_name() + "!");

            }
        }
    }
}
