/*
 * Author: Danielle Moore
 * Date: 11/09/2024
 * Description: This program creates a Circle class that has a radius and color.
 */
package Assignments;

public class Circle {
    // Variables and initialization
    private double radius;
    private String color;

    // Default constructor
    public Circle() {
        this.radius = 1.0;
        this.color = "red";

        // print statement that states what parameters were used
        System.out.printf("Circle object default constructor: radius = %.2f, color = %s\n", this.radius, this.color);

    }// end of 1st constructor

    // Constructor that just reads in the radius
    public Circle(double radius) {
        this.radius = radius;
        this.color = "red";

        // print statement that states what parameters were used
        System.out.printf("Circle object constructor with given radius: radius = %.2f, color = %s\n", this.radius,
                this.color);
    }// end of 2nd constructor

    // Constructor that reads in both the radius and color
    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;

        // print statement that states what parameters were used
        System.out.printf("Circle object default constructor with given radius and color: radius = %.2f, color = %s\n",
                this.radius, this.color);
    } // end of 3rd constructor

    // get Method for radius and color
    public double getRadius() {
        return radius;
    }// end of getRadius

    public String getColor() {
        return color;
    }// end of getColor

    // set Method for radius and color
    public void setRadius(double radius) {
        this.radius = radius;
    }// end of setRadius

    public void setColor(String color) {
        this.color = color;
    }// end of setColor

    // Overriding toString() method
    public String toString() {
        return "Circle[radius=" + radius + ",color=" + color + "]";
    }// end of toString

    // Method that calculates the area of the circle
    public double getArea() {
        return Math.PI * (radius * radius);
    }// end of getArea

}// end of Circle class