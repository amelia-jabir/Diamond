package com.diamond;

public class Diamond {

    public static void main(String[] args) {
        drawDiamond('L');
    }

    public static void drawDiamond(char letter) {

        if(letter < 65 || letter > 90) {
            try {
                throw new InvalidLetterException("Letter must be uppercase between A - Z");
            } catch (InvalidLetterException e) {
                e.printStackTrace();
            }
            return;
        }

        int dist = letter - 65;

        /* Row Loop */
        final int lastrow = dist*2+1;
        for (int row = 0; row < lastrow; row++) {

            /* Mirroring */
            int negationAfterMiddle = (int) Math.pow(-1, row/(dist+1)); // this variable turns -1, when row >= dist+1 (reaching the middle)
            int minuendAfterMiddle = (row/(dist+1)) * (lastrow - 1); // this variable acts as a minuend, when row >= dist+1 (reaching the middle)

            int col = minuendAfterMiddle + row * negationAfterMiddle;

            char l = (char) ('A' + col);

            // char loop
            for (int ch = 0; ch < lastrow; ch++) {
                if (ch == dist - col || ch == dist + col) {
                    System.out.print(l);
                } else {
                    if (ch < dist - col || ch > dist + col) {
                        System.out.print('.');
                    } else {
                        System.out.print(' ');
                    }
                }
            }

            System.out.print('\n');
        }

    }

}
