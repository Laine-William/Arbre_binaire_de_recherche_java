// Classe  pour créer les noeuds d'un arbre bibaire de recherche
    public class Cellule extends ArbreBinaireRecherche {
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
