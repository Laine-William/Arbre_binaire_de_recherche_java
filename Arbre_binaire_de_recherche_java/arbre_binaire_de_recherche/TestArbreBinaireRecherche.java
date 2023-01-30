import java.util.ArrayList;
import java.util.Random;

public class TestArbreBinaireRecherche {
    public static void main(String[] args) {

        ArbreBinaireRecherche arbre=new ArbreBinaireRecherche();

        ArrayList<Element> tableau= new ArrayList<>();

        for(int k=0;k<40;k++)

            tableau.add(Element.genererElement());

        for(int i=0;i<tableau.size()-1;i++) {

            arbre.insererElement(tableau.get(i));
        }

        System.out.println("------------------------------------------------------------");
        System.out.println("----------- ARBRE DE 40 ELEMENTS APRES CREATION ------------");
        System.out.println("------------------------------------------------------------");

        arbre.afficher();

        System.out.println("\n------------------------------------------------------------");
        System.out.println("------------------- TEST DES FONCTIONS ---------------------");
        System.out.println("------------------------------------------------------------");

        System.out.println("Arbre de hauteur : " +arbre.tailleArbre(arbre.getRacine()));
        System.out.println("Arbre de racine : " +arbre.getRacine());
        System.out.println("Arbre de noeuds : " +arbre.nbCellules(arbre.getRacine()));
        arbre.insererElement(new Element(17, Element.genereValeur()));

        System.out.println("Nombre de noeuds apres l'ajout de l'élément 17: " +arbre.nbCellules(arbre.getRacine()));
        System.out.println("Chercher l'élement ajouté qui doit être 17 dans l'arbre, voici l'élément trouvé : "+arbre.chercherElement(17));
        System.out.println("Chercher le parent de 17 dans l'arbre : "+arbre.chercherParentCellule(17));
        System.out.println("Element supprimé est : "+ arbre.supprimer(17) );
        System.out.println("Chercher la clé 17 qui n'existe pas dans l'arbre : "+arbre.chercherElement(17).getValeur());
        System.out.println("Arbre de noeuds apres suppression de 17 : " +arbre.nbCellules(arbre.getRacine()));

        //------------------TEST TP FICHE COMPLEMENTAIRE----------------------
        System.out.println("\n------------------------------------------------------------");
        System.out.println("------------------ TEST COMPRELENTAIRE TP ------------------");
        System.out.println("------------------------------------------------------------");

        ArbreBinaireRecherche arbre2=new ArbreBinaireRecherche();

        ArrayList<Element> elements= new ArrayList<>();

        ArrayList<Element> aInserer= new ArrayList<>();

        ArrayList<Element> aSupprimer= new ArrayList<>();

        Random rand = new Random();

        int val=0;

        //remplissage avec 10.000 valeurs aleatoires de 0 à 1.000.000
        for(int k=0;k<10000;k++) {

            elements.add(Element.genererElement());
        }

        double debutRemplissage = System.nanoTime();

        for(int k=0;k<10000;k++) {

            arbre2.insererElement(elements.get(k));
        }

        double finRemplissage = System.nanoTime();

        System.out.println("\n------------------ TAILLE ET HAUTEUR APRES CREATION D'UN ARBRE DE 10 000 ELEMENTS ------------------");
        System.out.println("Hauteur Arbre apres 10 000 insertions : " +arbre2.tailleArbre(arbre2.getRacine()));
        System.out.println("Nombre de noeuds apres 10 000 insertions: " +arbre2.nbCellules(arbre2.getRacine()));
        System.out.println("Temps de création de 10 000 éléments : " + ((finRemplissage-debutRemplissage)/1000000) + " secondes");

       //création du tableau d'insertion et de suppression de 1000 elements
        for(int i =0;i<1000;i++){

            aInserer.add(Element.genererElement());
        }

        for(int i=0;i<1000;i++) {

            val =rand.nextInt(10000);

            aSupprimer.add(elements.get(val));
        }

        //--------- inserer 1000 elements ---------
        double debutInsertion = System.nanoTime();

        for(int i =0;i<1000;i++){

            arbre2.inserer(aInserer.get(i));
        }
        double finInsertion = System.nanoTime();

        System.out.println("\n--------------------- TAILLE ET HAUTEUR APRES INSERTION DE 1 000 ELEMENTS -------------------------");

        System.out.println("Hauteur Arbre apres 1 000 insertion: " +arbre2.tailleArbre(arbre2.getRacine()));

        System.out.println("Nombre de noeuds apres 1 000 insertion: " +arbre2.nbCellules(arbre2.getRacine()));

        System.out.println("Temps d'insertion : " + ((finInsertion-debutInsertion)/1000000) + " secondes");

        //--------- supprimer 1000 elements ---------

        double debutSuppression = System.nanoTime();

        for(int i =0;i<1000;i++){

            arbre2.supprimer(aSupprimer.get(i).getCle());
        }

        double finSuppression = System.nanoTime();

        System.out.println("\n------------------ TAILLE ET HAUTEUR APRES SUPPRESSION ALEATOIRE DE 1 000 ELEMENTS ------------------");

        System.out.println("Hauteur Arbre apres 1 000 suppression: " +arbre2.tailleArbre(arbre2.getRacine()));

        System.out.println("Nombre de noeuds apres 1 000 suppression: " +arbre2.nbCellules(arbre2.getRacine()));

        System.out.println("Temps de suppression : " + ((finSuppression-debutSuppression)/1000000) + " secondes");
    }
}
