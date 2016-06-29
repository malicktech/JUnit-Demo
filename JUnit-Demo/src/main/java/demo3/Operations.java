package demo3;

import java.util.Arrays;

public class Operations {

	 public static long additionner(final long...pNombres) {
	        long lRetour = 0;
	        for(final long lNombre : pNombres) {
	            lRetour += lNombre;
	        }
	        return lRetour;
	    }
	 
	    public static double soustraire(final double...pNombres) {
	        if(pNombres.length < 2) {
	            throw new IllegalArgumentException(
	                    "Il faut au moins deux nombres en entrée");
	        }
	        double lRetour = pNombres[0];
	        for(int i=1;i<pNombres.length;i++) {
	            lRetour -= pNombres[i];
	        }
	        return lRetour;
	    }
	    
	    /**
	     *  Cette méthode ne fonctionne pas correctement Les tests vont le vérifier 
	     * @param pNombres
	     * @return
	     */
	    public static long multiplier(final long...pNombres) {
	        long lRetour = 0;
	        for(final long lNombre : pNombres) {
	            lRetour *= lNombre;
	        }
	        return lRetour;
	    }
	    
	    public static long diviser(final long...pNombres) {
	        if(pNombres.length < 2) {
	            throw new IllegalArgumentException(
	                    "Il faut au moins deux nombres en entrée");
	        }
	        long lRetour = pNombres[0];
	        for(int i=1;i<pNombres.length;i++) {
	            lRetour /= pNombres[i];
	        }
	        return lRetour;
	    }
	    
	    /**
	     * Cette méthode vérifie que les longueurs passées en paramètre sont celles d'un triangle rectangle
	     * @param pLongueurs
	     * @return
	     */
	    public static Boolean[] pythagore(final long[]...pLongueurs) {
	        final Boolean[] lRetours = new Boolean[pLongueurs.length];

	        for(int i=0;i<pLongueurs.length;i++) {
	            final long[] lLongeurs = pLongueurs[i];
	            if(lLongeurs.length != 3) {
	                throw new IllegalArgumentException(
	                    "Les blocs de longueurs doivent être de 3 éléments");
	            }
	            
	            final long[] lCopieLongueurs = lLongeurs.clone();
	            Arrays.sort(lCopieLongueurs);
	            
	            final long lLongueur1 = lCopieLongueurs[0] * lCopieLongueurs[0];
	            final long lLongueur2 = lCopieLongueurs[1] * lCopieLongueurs[1];
	            final long lLongueur3 = lCopieLongueurs[2] * lCopieLongueurs[2];
	            
	            if(lLongueur1 + lLongueur2 == lLongueur3) {
	                lRetours[i] = true;
	            }
	            else {
	                lRetours[i] = false;
	            }
	        }

	        return lRetours;
	    }
	    

	    
	}
