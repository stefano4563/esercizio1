enum tipologia {casa, personale, lavoro}

public class Contatto {
    public String nome;
    public String cognome;
    public String numero;
    public tipologia tipo;
    public int nascosto;

public String stampa(){
    return String.format("nome: %s, cognome: %s, numero: %s, tipologia: %s", nome,cognome, numero, tipo.toString());
}




}
