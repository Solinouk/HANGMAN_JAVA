import java.util.Scanner;

public class Player {

    String name;
    int score;

    char let ;
    char letter ;
    public Scanner sc = new Scanner(System.in);


    public Player(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public Player() {

    }

    public int get_score(){
        return score;
    }

    public String get_name() {
        return name;
    }

    public void chose_name(){

        System.out.println("Veuillez saisir votre nom :");
        name = sc.nextLine();
        System.out.println("Bienvenue "+ name + " !");

    }

    public void chose_letter(){
        System.out.println("Veuillez choisir une lettre ");
        let = sc.next().charAt(0);
        letter = Character.toUpperCase(let);

        System.out.println("Voyons si la lettre " + letter + " est dans le mot. ");

    }

    public char getLetter() {
        return letter;
    }
}
