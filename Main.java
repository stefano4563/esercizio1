import java.util.Objects;
import java.util.Scanner;

import static tools.utility.*;


public class Main {
    public static void main(String[] args) {
        String [] opzioni = {"opzioni", "[1] inserimento", "[2] visualizza", "[3] black box", "[4] chiamata", "[5] visualizza chiamate"};
        Contatto [] gestore = new Contatto[3];
        boolean fine = true;
        Scanner in = new Scanner (System.in);
        int posizione = 0;
        int vero = 1;
        int falso = 2;
        String [] chiamate = new String[10];
        String numero2;
        int posizione2 = 0;
        do{
            switch(menu(opzioni, in)){
                case 1:{
                    inserimento(gestore, in, posizione, vero, falso);
                    posizione++;
                    break;
                }
                case 2:{
                    visualizza(gestore, falso, posizione);
                    break;
                }
                case 3:{
                    black_box(gestore, in, posizione);
                    break;
                }
                case 4:{
                    System.out.println("inserisci il numero della contatto");
                    numero2 = in.nextLine();
                    for(int i=0; i<posizione; i++){
                        if(Objects.equals(numero2, gestore[i].numero)){
                            System.out.println("chiamata in corso...");

                            chiamate[posizione2] = numero2;

                        }

                        posizione2++;
                    }
                    break;
                }
                case 5:{
                    visualizza_chiamate(chiamate, gestore, posizione, vero);
                    break;
                }
                default:{
                    fine = false;
                    break;
                }
            }
        }while(fine);



    }

public static void inserimento (Contatto [] gestore, Scanner in, int posizione, int vero, int falso){
    Contatto contatto = new Contatto();
    String [] scelta = {"tipologia", "[1] personale", "[2] lavoro", "[3] famiglia"};
    String [] scelta2 = {"nascosto", "[1] si", "[2] no"};
System.out.println("inserisci il nome");
contatto.nome = in.nextLine();
System.out.println("inserisci il cognome");
contatto.cognome = in.nextLine();
System.out.println("inserisci il numero");
contatto.numero = in.nextLine();
switch(menu(scelta, in)){
    case 1 -> contatto.tipo = tipologia.personale;
    case 2 -> contatto.tipo = tipologia.lavoro;
    case 3 -> contatto.tipo = tipologia.casa;
}
System.out.println("inserire come contatto nascosto?");
switch(menu(scelta2, in)){
    case 1 -> contatto.nascosto = vero;
    case 2 -> contatto.nascosto = falso;
}
gestore[posizione] = contatto;

}

public static void visualizza(Contatto [] gestore, int falso, int posizione){

    for (int i = 0; i < posizione; i++) {
        //scelgo l'elemento del vettore
        Contatto elemento = gestore[i];
        if(elemento.nascosto==falso){
            System.out.println(gestore[i].stampa());
        }
        else{
            System.out.println("contatto nascosto");
        }
    }
}

public static void black_box(Contatto [] gestore, Scanner in, int posizione){
System.out.println("inserisci la password");
String password = in.nextLine();
String password2 = "bassotto82";
while(!Objects.equals(password, password2)){
        System.out.println("password errata, riprova");
        password = in.nextLine();
}
    }

public static void visualizza_chiamate(String [] chiamate, Contatto [] gestore, int posizione, int vero){
    for (int j = 0; j <  posizione; j++) {
        if(Objects.equals(chiamate[j], gestore[j].numero)){
            if(gestore[j].nascosto == vero){
                System.out.println("contatto nascosto");
            }
            else{
                System.out.println(gestore[j].stampa());
            }
        }
    }
}

}