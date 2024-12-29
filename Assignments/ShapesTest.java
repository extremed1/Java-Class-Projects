/*
 * Author: Danielle Moore
 * Date: 11/09/2024
 * Description: This driver program creates 2 cylinder objects.
 */
package Assignments;

public class ShapesTest {
    public static void main(String[] args) {
        // variable initialization

        Cylinder cylinder1 = new Cylinder();
        System.out.println(cylinder1.toString());
        System.out.println("Area of cylinder1: " + cylinder1.getArea()); // Printing area of cylinder1
        System.out.println("Volume of cylinder1: " + cylinder1.getVolume());// Printing volume of cylinder1

        Cylinder cylinder2 = new Cylinder(2.0, 5.0);
        System.out.println(cylinder2.toString());
        System.out.println("Area of cylinder2: " + cylinder2.getArea());// Printing area of cylinder2
        System.out.println("Volume of cylinder2: " + cylinder2.getVolume());// Printing volume of cylinder2
    }// end of main
}// end of ShapesTest
