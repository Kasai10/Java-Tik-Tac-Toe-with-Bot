

public class Bot {
    public int nextMove(Board bord) {
        char[][] array2d = bord.getArray2d();

        for (int i = 0; i < array2d.length; i++) {
            char[] row = new char[3];
            char[] column = new char[3];
            for (int j = 0; j < array2d[i].length; j++) {
                row[j] = array2d[i][j];
                column[j] = array2d[j][i];

                bord.hasWinningMove(column, j, bord, 'k', 'o');
            }
            bord.hasWinningMove(row, i, bord, 'i', 'o');
        }

        char[] diagonal1 = new char[3];
        char[] diagonal2 = new char[3];
        for (int i = 0; i < array2d.length; i++) {
            diagonal1[i] = array2d[i][i];
            diagonal2[i] = array2d[i][array2d[i].length - 1 - i];
            bord.hasWinningMove(diagonal1, i, bord, 'k', 'o');
            bord.hasWinningMove(diagonal2, i, bord, 'i', 'o');
        }

        for (int i = 0; i < array2d.length; i++) {
            char[] row = new char[3];
            char[] column = new char[3];
            for (int j = 0; j < array2d[i].length; j++) {
                row[j] = array2d[i][j];
                column[j] = array2d[j][i];

                bord.hasWinningMove(column, j, bord, 'k', 'x');
            }
            bord.hasWinningMove(row, i, bord, 'i', 'x');
        }

        char[] diagonal3 = new char[3];
        char[] diagonal4 = new char[3];
        for (int i = 0; i < array2d.length; i++) {
            diagonal1[i] = array2d[i][i];
            diagonal2[i] = array2d[i][array2d[i].length - 1 - i];
            bord.hasWinningMove(diagonal3, i, bord, 'k', 'x');
            bord.hasWinningMove(diagonal4, i, bord, 'i', 'x');
        }

        if (bord.isFree(4)) {
            return 4;
        }

        if (bord.isFree(0)) {
            return 0;
        } else if (bord.isFree(2)) {
            return 2;
        } else if (bord.isFree(6)) {
            return 6;
        } else if (bord.isFree(8)) {
            return 8;
        }

        for (int i = 0; i < bord.getBord().length; i++) {
            if (bord.isFree(i)) {
                return i;
            }
        }
        return -1;
    }
}


