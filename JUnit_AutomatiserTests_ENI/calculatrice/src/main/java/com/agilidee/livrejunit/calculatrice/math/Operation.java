package com.agilidee.livrejunit.calculatrice.math;

public interface Operation {
    /**
     * Réalise l'opération.
     * @param a premier paramètre.
     * @param b second paramètre.
     * @return Résultat de l'opération.
     */
    public Long calculer(Long a, Long b) throws Exception;

    /**
     * Utile à la gestion de l'affichage.
     * @return Le symbole de l'opération.
     */
    public Character lireSymbole();
}
