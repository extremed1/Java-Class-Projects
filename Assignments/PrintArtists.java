/*
 * Author: Danielle Moore
 * Date: 9/13/2020
 * Description: This program prints the birth years of famous artists
 */
package Assignments;

public class PrintArtists {
    public static void main(String[] args) {
        // Variables and initialization
        int daVinciBirthYear = 1452, michelangeloBirthYear = 1475, vanGoghBirthYear = 1853, rodinBirthYear = 1840,
                picassoBirthYear = 1881, daliBirthYear = 1904;

        // output statements
        System.out.printf("%-9d Leonardo da Vinci\n", daVinciBirthYear);
        System.out.printf("%-9d Michelangelo\n", michelangeloBirthYear);
        System.out.printf("%-9d Vincent Van Gogh\n", vanGoghBirthYear);
        System.out.printf("%-9d Auguste Rodin\n", rodinBirthYear);
        System.out.printf("%-9d Pablo Picasso\n", picassoBirthYear);
        System.out.printf("%-9d Salvador Dali\n", daliBirthYear);
    }// end of main

}// end of class
