package com.prueba.mutants.UseCase;

public class ValidateMutant {

    String [] dna;
    int size;
    int SIZE_IS_MUTANT = 4;
    
    public ValidateMutant(String [] dna) {
        this.dna = dna;
    }

    public boolean validateMutant() {
        if(dna != null && validateSize()) {
            for (int i = 0; i < dna.length; i++) {
                for (int j = 0; j < size; j++) {
                    if(validateLine(i, j) || validateDiagonal(i, j))
                        return true;
                }
            }
        }
        return false;
    }

    public boolean validateDiagonal(int x, int y){
        if(validateDiagonalRight(x, y) || validateDiagonalLeft(x, y))
            return true;
        return false;
    }

    public boolean validateDiagonalLeft(int x, int y){
        if(validateDiagonalLeftUp(x, y) || validateDiagonalLeftDown(x, y))
            return true;
        return false;
    }

    public boolean validateDiagonalLeftUp(int x, int y){
        String firstDna = getIndividualDna(x, y);
        int yAux = y - 1;
        if((x - (SIZE_IS_MUTANT - 1)) >= 0 && (y - (SIZE_IS_MUTANT-1)) >= 0) {
            for (int i = (x - 1); i >= (x - (SIZE_IS_MUTANT - 1)); i--) {
                String word = getIndividualDna(i, yAux);
                if (!firstDna.equals(word))
                    return false;
                yAux--;
            }
            return true;
        }
        return false;
    }

    public boolean validateDiagonalLeftDown(int x, int y){
        String firstDna = getIndividualDna(x, y);
        int yAux = y - 1;
        if((x + (SIZE_IS_MUTANT - 1)) <= dna.length && (y - (SIZE_IS_MUTANT-1)) >= 0) {
            for (int i = (x + 1); i <= (x + (SIZE_IS_MUTANT - 1)); i++) {
                String word = getIndividualDna(i, yAux);
                if (!firstDna.equals(word))
                    return false;
                yAux--;
            }
            return true;
        }
        return false;
    }

    public boolean validateDiagonalRight(int x, int y){
        if(validateDiagonalRightDown(x, y) || validateDiagonalRightUp(x, y))
            return true;
        return false;
    }

    public boolean validateDiagonalRightUp(int x, int y){
        String firstDna = getIndividualDna(x, y);
        int yAux = y - 1;
        if((x - (SIZE_IS_MUTANT - 1)) >= 0 && (y + (SIZE_IS_MUTANT-1)) >= (size-1)) {
            for (int i = (x - 1); i >= (x - (SIZE_IS_MUTANT - 1)); i--) {
                String word = getIndividualDna(i, yAux);
                if (!firstDna.equals(word))
                    return false;
                yAux++;
            }
            return true;
        }
        return false;
    }

    public boolean validateDiagonalRightDown(int x, int y){
        String firstDna = getIndividualDna(x, y);
        int yAux = y + 1;
        // valida diagonal hacia la izquierda y arriba es posible
        if((x + (SIZE_IS_MUTANT - 1)) <= dna.length && (y + (SIZE_IS_MUTANT-1)) <= (size-1)) {
            for (int i = (x + 1); i <= (x + (SIZE_IS_MUTANT - 1)); i++) {
                String word = getIndividualDna(i, yAux);
                if (!firstDna.equals(word))
                    return false;
                yAux++;
            }
            return true;
        }
        return false;
    }

    public boolean validateLine(int x, int y){
        if (validateLineRight(x, y) || validateLineDown(x, y))
            return true;
        return false;
    }

    public boolean validateLineDown(int x, int y){
        String firstDna = getIndividualDna(x, y);
        // valida diagonal hacia la izquierda y arriba es posible
        if((x + (SIZE_IS_MUTANT-1)) <= (size-1)) {
            for (int i = (x + 1); i <= (x + (SIZE_IS_MUTANT - 1)); i++) {
                String word = getIndividualDna(i, y);
                if (!firstDna.equals(word))
                    return false;
            }
            return true;
        }
        return false;
    }

    public boolean validateLineRight(int x, int y){
        String firstDna = getIndividualDna(x, y);
        // valida diagonal hacia la izquierda y arriba es posible
        if((y + (SIZE_IS_MUTANT-1)) <= (size-1)) {
            for (int i = (y + 1); i <= (y + (SIZE_IS_MUTANT - 1)); i++) {
                String word = getIndividualDna(x, i);
                if (!firstDna.equals(word))
                    return false;
            }
            return true;
        }
        return false;
    }

    public String getIndividualDna(int x, int y) {
        return String.valueOf(dna[x].charAt(y));
    }

    public boolean validateSize() {
        size = dna[0].length();
        for (int i = 1; i < dna.length; i++) {
            if(size != dna[i].length()) return false;
        }
        return true;
    }

}
