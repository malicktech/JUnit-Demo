package calculator.math;

public interface Operation {
    /**
     * R�alise l'op�ration.
     * @param a premier param?tre.
     * @param b second param?tre.
     * @return R�sultat de l'op�ration.
     */
    public Long calculer(Long a, Long b) throws Exception;

    /**
     * Utile � la gestion de l'affichage.
     * @return Le symbole de l'op�ration.
     */
    public Character lireSymbole();
}
