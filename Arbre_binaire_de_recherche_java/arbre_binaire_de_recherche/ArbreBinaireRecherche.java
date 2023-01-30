/** Une classe pour créer un arbre binaire de recherche
 * @author Munkhdorj Erdenebaatar, William Laine
 * @version 03/05/2021
 */

public class ArbreBinaireRecherche {
    /**
     * l'élément courant qui va permettre de parcourir l'arbre
     */
    private Cellule courant;
    /**
     * la racine de l'arbre
     */
    private Cellule racine;

    /**
     * Constructeur de l'arbre binaire
     */
    public ArbreBinaireRecherche() {
        this.racine=null;
    }

    /**
     * Calcule le nombre de cellules d'un arbre
     * @param cellule la cellule de début
     * @return int
     */
    public int nbCellules(Cellule cellule) {
        int count=1;
        if(cellule==null)
            return 0;
        if(cellule.filsG!=null)
            count+=nbCellules(cellule.filsG);
        if(cellule.filsD!=null)
            count+=nbCellules(cellule.filsD);
        return count;
    }

    /**
     * Méthode pour insérer un élément
     * @param element l'élément à insérer
     * @return boolean
     */
    public boolean insererElement(Element element){
        courant=racine;
        return inserer(element);
    }

    /**Insère dans l'arbre l'Element e récursivement et renvoit vrai si l'élément a bien été inséré
     * @param element l'élément à insérer
     * @return boolean
     */
    public boolean inserer(Element element){
        //si l'arbre est vide alors on crée la racine
        if (racine == null) {
            racine = new Cellule(element);
            return true;
        }
        //si on est au bout de la branche alors on insère
        if(courant.filsD==null && element.getCle() < courant.contenu.getCle()){
            courant.filsD=new Cellule(element,courant);
            return true;
        }
        if(courant.filsG==null && element.getCle() > courant.contenu.getCle()){
            courant.filsG=new Cellule(element,courant);
            return true;
        }

        //on parcourt l'arbre
        //parcourt dans le fils droit
        if (element.getCle() < courant.contenu.getCle()) {
            if (courant.filsD != null) {
                courant = courant.filsD;
                inserer(element);
            }
        }
        //parcourt dans fils gauche
        if (element.getCle() > courant.contenu.getCle()) {
            if (courant.filsG != null) {
                courant = courant.filsG;
                inserer(element);
            }
        }

        //si ca n'a pas été inséré on retourne faux
        return false;
    }

    /**
     * Calcule la hauteur d'un arbre
     * @param cellule le noeud de début
     * @return int
     */
    public int tailleArbre(Cellule cellule) {
        int h1=0, h2=0;
        if(cellule==null)
            return -1;
        else
        {
            if(cellule.filsG!=null)
                h1=tailleArbre(cellule.filsG);
            if(cellule.filsD!=null)
                h2=tailleArbre(cellule.filsD);
            return Math.max(h1,h2)+1;
        }
    }

    /**
     * Cherche un élément dans l'arbre
     * @param cle l'élément à chercher
     * @return Element
     */
    public Element chercherElement(int cle){
        if(racine==null)
            return new Element(-1);
        courant=racine;
        //si on a trouvé l'élément on le retourne
        courant=racine;
        return chercher(cle).contenu;

    }

    /**
     * Méthode récursive de recherche d'un élément dans un arbre
     * @param cle l'élément à chercher
     * @return Cellule
     */
    public Cellule chercher(int cle) {

        if(courant.contenu!=null)
        //parcourt dans branche droite
        if(cle < courant.contenu.getCle()) {
            if (courant.filsD != null) {
                courant = courant.filsD;
                chercher(cle);
            }
        }
        if(courant.contenu!=null)
        //parcourt dans branche droite
        if(cle > courant.contenu.getCle()) {
            if(courant.filsG!=null) {
                courant=courant.filsG;
                chercher(cle);
            }
        }
        //retourne l'élément si on l'a trouvé
        if(courant.contenu!=null)
        if(courant.contenu.getCle()==cle)
            return courant;
        return new Cellule(new Element(-1));
    }

    /**
     * Cherche le parent d'un élément dans l'arbre
     * @param cle l'élément à chercher
     * @return Cellule
     */
    public Cellule chercherParentCellule(int cle){
        if(racine==null)
            return new Cellule(new Element(-1));
        courant=racine;
        //si on a trouvé l'élément on le retourne

        courant=racine;
        return chercherParent(cle);


    }

    /**
     * Méthode récursive de recherche d'un élément dans un arbre
     * @param cle l'élément à chercher
     * @return Cellule
     */
    public Cellule chercherParent(int cle) {
        if(courant==null){
            return new Cellule(new Element(-1));
        }
        //fils droit
        if(courant.contenu!=null)
        if(cle < courant.contenu.getCle()) {
            if (courant.filsD != null) {
                courant = courant.filsD;
                chercher(cle);
            }
        }
        //fils gauche
        if(courant.contenu!=null)
        if(cle > courant.contenu.getCle()) {
            if(courant.filsG!=null) {
                courant=courant.filsG;
                chercher(cle);
            }
        }
        if(courant.contenu!=null)
        if(courant.contenu.getCle()==cle)
            return courant.parent;
        return new Cellule(new Element(-1));
    }

    /**
     * Chercher la clé minimum dans un sous-arbre
     * @param courant l'élément courant qui repésente le début du sous-arbre
     * @return Cellule
     */
    public Cellule valeurMin(Cellule courant) {
        Cellule minval=null;

        while (courant.filsD != null) {
            minval = courant.filsD;
            courant = courant.filsD;
        }
        if(minval==null||minval.contenu==null)
            return new Cellule(new Element(-1,"O"));
        return minval;
    }

    /**Supprimer de l'arbre l'élément qui a pour pour clé celle passée en paramètre et renvoit l'Element supprimé
     * @param cle la clé pour identifier un Element
     * @return Element
     */
    public Element supprimer(int cle){
        //on place l'élément à supprimer dans courant
        courant=racine;
        //on cherche son parent
        Cellule parent=chercherParentCellule(cle);
        courant=chercher(cle);
       if(parent!=null && courant.contenu.getCle()==cle){
            String val = courant.contenu.getValeur();
            //si courant est une feuille on le supprime directement
            if(courant.filsG ==null && courant.filsD==null){
                if(parent.filsD!=null)
                if(parent.filsD.contenu.getCle()==cle) {
                    parent.filsD = null;
                    return courant.contenu;
                }
                if(parent.filsG!=null)
                if(parent.filsG.contenu.getCle()==cle) {
                    parent.filsG = null;
                    return courant.contenu;
                }
            }
            //si sa brache droite est vide
            if(courant.filsD ==null && courant.filsG!=null){
                parent.filsD = courant.filsG;
                courant.contenu=null;
                courant.parent=null;
                return new Element(cle,val);
            }else if(courant.filsG ==null && courant.filsD!=null){
                parent.filsG = courant.filsD;
                courant.contenu=null;
                courant.parent=null;
                return new Element(cle,val);
            }else{
                //chercher le plus petit du sous-arbre de courant
                Element e =new Element((valeurMin(courant).contenu));
                if(e.getCle()>-1){
                    courant.contenu = new Element(e);
                    courant.filsD.parent=courant;
                    Cellule pereM = valeurMin(courant).parent;
                    if(pereM.filsD!=null)
                        if(courant.contenu.getCle()==pereM.filsD.contenu.getCle()){
                            val = pereM.filsD.contenu.getValeur();
                            pereM.filsD.setContenu(new Element(-1,null));
                            pereM.filsD=null;
                            return new Element(courant.contenu.getCle(),val);
                        }
                    if(pereM.filsG!=null)
                    if(courant.contenu.getCle()==pereM.filsG.contenu.getCle()){
                        val = pereM.filsG.contenu.getValeur();
                        pereM.filsG.setContenu(new Element(-1,null));
                        pereM.filsG=null;
                        return new Element(courant.contenu.getCle(),val);
                    }
                }
            }
       }
        return null;
    }

    /**Affiche l'arbre à partir de la racine
     */
    public void afficher() {
        courant = racine;
        afficherRes("RACINE ",courant);
    }
    /**Supprimer de l'arbre l'élément qui a pour pour clé celle passée en paramètre et renvoit l'Element supprimé
     * @param courant l'élément qui représente le début de la branche à afficher
     * @param s text à ajouter dans l'affichage
     */
    public void afficherRes(String s, Cellule courant){
        if (courant != null) {
            afficherRes(courant+" filsG : ",courant.filsG);
            System.out.println(s+courant.contenu);
            afficherRes(courant+" filsD : ",courant.filsD);
        }
    }
    /**Méthode pour récupèrer la racine
     */
    public Cellule getRacine(){
        return this.racine;
    }

    /**Classe privée pour créer les noeuds d'un arbre bibaire de recherche
     */
    private class Cellule {
        /** le contenu d'un noeud
         */
        Element contenu ; // contenu d'une cellule
        /** le noeud gauche du noeud courant
         */
        Cellule filsG ; // La cellule qui est le fils gauche
        /** le noeud droit du noeud courant
         */
        Cellule filsD ; // la cellule qui est le fils droit
        /**Supprimer le noeud parent du noeud courant
         */
        Cellule parent ; // la cellule qui est le parent

        /** Constructeur d'un noeud
         * @param contenu le contenu du noeud à créer
         */
        Cellule(Element contenu) {
            this.contenu=new Element(contenu);
            this.filsG =null;
            this.filsD=null;
            this.parent=null;
        }

        /** Constructeur d'un noeud avec 2 paramètres
         * @param contenu le contenu du noeud à créer
         * @param parent le noeud qui va être le parent
         */
        Cellule(Element contenu, Cellule parent) {
            this.contenu=new Element(contenu);
            this.filsG =null;
            this.filsD=null;
            this.parent=parent;
        }

        void setContenu(Element e){
            this.contenu = new Element(e);
        }

        /** Affichage  du contenu d'un noeud
         * @return String
         */
        public String toString(){
            return this.contenu.toString();
        }
    }
}
