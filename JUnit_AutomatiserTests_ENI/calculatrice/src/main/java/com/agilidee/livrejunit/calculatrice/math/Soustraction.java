package com.agilidee.livrejunit.calculatrice.math;

public class Soustraction implements Operation{
    public Long calculer(Long a, Long b) {
        return a-b;
    }
    public Character lireSymbole() {
        return '-';
    }
}
