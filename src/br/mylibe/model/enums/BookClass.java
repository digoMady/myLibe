package br.mylibe.model.enums;

/**
 *
 * @author mady
 */
public enum BookClass {
    ROMANCE,
    FICCAO,
    DRAMA,
    EDUCATIVO,
    ILUSTRATIVO,
    POESIA,
    FANTASIA;
    
    public BookClass[] getValores() {
        return BookClass.values();
    }
}
