
public class Recherche_Dichotomique {
    static int rechercheDichotomique(int[] tab, int elemt){
      
int N=tab.length-1;
int mil, deb, fin;
      deb = 0; fin = N ;
      do{
          mil = (deb+fin)/2;
          if(tab[mil] == elemt)
              return mil;
          else if(tab[mil] < elemt)
              fin = mil-1;
          else
              deb = mil+1;
      } while(deb <= fin);
      return -1;
  }
}
