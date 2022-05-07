/**
 * @question
 * Write a program, that given the winners of points gives the final score
 * the rules of tennis are as follows -
 * Tennis is played as a sequence of points and only one side can win a point the score for a slide
 * is denoted as follows
 * 0 points
 * 1 point - 15
 * 2 points - 30
 * 3 points - 40
 *
 * If the score reaches 40-40 a deuce is called the WInner if the next point is awarded "Advantage"
 * and can then win the game by taking the next point or be brought back to deuce if their opponent score
 * there is no limit in the rules to the number of times players can tie at deuce
 * without a deuce if the player scores a point after reaching 40(i.e. if the opponent has
 * 30 or less) the player scoring the point wins the game
 *
 * Assuming that the slides are A & B you are given a sequence of the winners of th points without spaces
 */

import java.util.*;

public class Tennis {

    private void exec(String name) {
        String CurrWinner = "";
        int srcA = 0, srcB = 0;
        int i;
        boolean ff = false;
        for (i = 0; i < name.length() - 1; i++) {
            if (name.charAt(i) == 'A' && name.charAt(i) == name.charAt(i + 1))
                srcA++;
            else if (name.charAt(i) == 'B' && name.charAt(i) == name.charAt(i + 1))
                srcB++;
            else {
                if (name.charAt(i) != name.charAt(i + 1)) {
                    srcA++;
                    srcB++;
                    i++;
                }
            }
            if (srcA == srcB && srcA == 3) {
                ff = true;
            }
            if (ff) {
                if (srcA > srcB) {
                    CurrWinner += "A";
                    srcA = srcB = 0;
                    ff = false;
                } else if (srcA < srcB) {
                    CurrWinner += "B";
                    srcA = srcB = 0;
                    ff = false;
                }
            } else {
                if (srcA == 3 && srcA > srcB) {
                    CurrWinner += "A";
                    srcA = srcB = 0;
                    ff = false;
                }
                if (srcB == 3 && srcB > srcA) {
                    CurrWinner += "B";
                    srcA = srcB = 0;
                    ff = false;
                }
            }
        }
        if (srcA == 3 && name.charAt(i) == 'A') {
            CurrWinner += "A";
            srcA = srcB = 0;
        }
        if (srcB == 3 && name.charAt(i) == 'B') {
            CurrWinner += "B";
            srcA = srcB = 0;
        }
        System.out.println(CurrWinner);
    }
    public static void main(String args[]) throws Exception {
        new Tennis().exec("AAAABBBBABABAA");
        new Tennis().exec("ABAABABBBB");
        new Tennis().exec("ABABABAABB");
        /**
         * O/P
         * ABA
         * A
         * AB
         */
    }
}
