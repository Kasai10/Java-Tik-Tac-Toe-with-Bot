public class Board {
    private char[] bord = {'-', '-', '-', '-', '-', '-', '-', '-', '-'};
    private char[][] array2d = to2dArray(this.bord);

    public char[] getBord() {
        return this.bord;
    }

    public char[][] getArray2d() {
        return this.array2d;
    }

    public Board() {

    }

    public boolean isFree(int index) {
        return bord[index] == '-';
    }

    public boolean isFull() {
        for (char element : bord) {
            if (element == '-') {
                return false;
            }
        }
        return true;
    }

    public String showField() {
        int index = 0;
        int index2 = 3;
        String newBord = "";
        for (int i = 0; i < 3; i++) {
            newBord += String.valueOf(bord).substring(index, index2) + "\n";
            index += 3;
            index2 += 3;
        }
        return newBord;
    }

    public boolean turnNumberIsEven(int turnNumber) {
        return turnNumber % 2 == 0;
    }

    public void placePlayerSymbol(int index, int turnNumber) {
        if (isFree(index) && turnNumberIsEven(turnNumber)) {
            this.bord[index] = 'o';
        } else if (isFree(index)) {
            this.bord[index] = 'x';
        }
    }

    public boolean hasWon() {
        for (int i = 0; i < array2d.length; i++) {
            char[] row = new char[3];
            char[] column = new char[3];
            for (int j = 0; j < array2d[i].length; j++) {
                row[j] = array2d[i][j];
                column[j] = array2d[j][i];
            }
            if (String.valueOf(row).equals("xxx") || String.valueOf(row).equals("ooo")) {
                return true;
            } else if (String.valueOf(column).equals("xxx") || String.valueOf(column).equals("ooo")) {
                return true;
            }
        }

        char[] diagonal1 = new char[3];
        char[] diagonal2 = new char[3];
        for (int i = 0; i < array2d.length; i++) {
            diagonal1[i] = array2d[i][i];
            diagonal2[i] = array2d[i][array2d[i].length - 1 - i];
        }
        if (String.valueOf(diagonal1).equals("xxx") || String.valueOf(diagonal1).equals("ooo")) {
            return true;
        } else if (String.valueOf(diagonal2).equals("xxx") || String.valueOf(diagonal2).equals("ooo")) {
            return true;
        }
        return false;
    }

    private static char[][] to2dArray(char[] bord) {
        char[][] array2d = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                array2d[i][j] = bord[(j * 3) + i];
            }
        }
        return array2d;
    }

    private int charInString(String string, char c) {
        int counter = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == c) {
                counter++;
            }
        }
        return counter;
    }

    public int hasWinningMove(char[] charArray, int i, Board bord, char switchParameter, char c) {
        if (charInString(String.valueOf(charArray), c) == 2) {
            for (int k = 0; k < charArray.length; k++) {
                if (bord.isFree(k)) {
                    if (switchParameter == 'i') {
                        switch (i) {
                            case 0:
                                return k + i;
                            case 1:
                                return k + i + 2;
                            case 2:
                                return k + i + 4;
                        }
                    } else if (switchParameter == 'k') {
                        switch (k) {
                            case 0:
                                return k + i;
                            case 1:
                                return k + i + 2;
                            case 2:
                                return k + i + 4;
                        }
                    }
                }
            }
        }
        return -1;
    }


}
