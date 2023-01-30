import java.util.Random;

public class Element {
    /**
     * clé de l'Element.
     */
    private int cle;
    /**
     * valeur de l'Element.
     */
    private String valeur;

    /**
     * constructeur sans paramètres
     */
    public Element (int i) {
        this.cle = i;
        this.valeur = null;
    }

    /**
     * constructeur avec paramètres
     * @param cle la clé pour identifier un Element
     * @param valeur la valeur d'un Element
     */
    public Element (int cle, String valeur) {
        this.cle = cle;
        this.valeur = valeur;
    }

    public static Element genererElement(){
        return new Element(genereCle(),genereValeur());
    }
    public static int genereCle(){

        Random rand = new Random();

        return rand.nextInt(1000000) + 1;
    }

    public static String genereValeur(){

        Random rand = new Random();

        char c = (char)(rand.nextInt(26) + 65);

        return "" + c;
    }

    /**
     * constructeur par recopie
     * @param element l'Element à recopier
     */
    public Element (Element element) {

        this.cle = element.cle;

        this.valeur = element.valeur;
    }

    /**
     * modificateur de clé
     * @param element l'objet contenant la clé à affecter
     */
    public void setCle (Element element) {
        this.cle = element.cle;
    }
    
    /**
     * modificateur de valeur
     * @param element l'objet contenant la valeur à affecter
     */
    public void setValeur (Element element) {

        this.valeur = element.valeur;
    }

    /**
     * accesseur de clé
     * @return int
     */
    public int getCle () {
        
        return this.cle;
    }

    /**
     * accesseur de valeur
     * @return String
     */
    public String getValeur () {
        return this.valeur;
    }

    /**
     * affichage d'un Element
     * @return String
     */
    public String toString () {
        String string="";
        string = string + this.cle+"("+getValeur()+")";
        return string;
    }
}
