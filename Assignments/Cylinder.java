/*
 * Author: Danielle Moore
 * Date: 11/09/2024
 * Description: This program creates a Cylinder class that inherits from the Circle class. It has a radius, color, and height.
 */
package Assignments;

public class Cylinder extends Circle {
    // Variables and initialization
    private double height;

    // Default constructor
    public Cylinder() {
        super();
        this.height = 1.0;

        // print statement that states what parameters were used
        System.out.printf("Cylinder object default constructor: radius = %.2f, color = %s, height = %.2f\n",
                getRadius(), getColor(), this.height);
    }// end of 1st constructor

    // Constructor that just reads in the height
    public Cylinder(double height) {
        super();
        this.height = height;

        // print statement that states what parameters were used
        System.out.printf("Cylinder object constructor with given height: radius = %.2f, color = %s, height = %.2f\n",
                getRadius(), getColor(), this.height);
    }// end of 2nd constructor

    // Constructor that reads in the radius and height
    public Cylinder(double radius, double height) {
        super(radius);
        this.height = height;

        // print statement that states what parameters were used
        System.out.printf(
                "Cylinder object constructor with given radius and height: radius = %.2f, color = %s, height = %.2f\n. We are setting the Circle object radius to the given radius.",
                getRadius(), getColor(), this.height);
    }// end of 3rd constructor

    // Constructor that reads in the radius, color, and height
    public Cylinder(double radius, double height, String color) {
        super(radius, color);
        this.height = height;

        // print statement that states what parameters were used
        System.out.printf(
                "Cylinder object constructor with given radius, color, and height: radius = %.2f, color = %s, height = %.2f\n. We are setting the Circle object radius and color to the given radius and color.",
                getRadius(), getColor(), this.height);
    }// end of 4th constructor

    // Overriding toString() method
    public String toString() {
        return "Cylinder[radius=" + getRadius() + ",color=" + getColor() + ",height=" + this.height + "]";
    }// end of toString

    // Method that calculates the volume of the cylinder
    public double getVolume() {
        return super.getArea() * this.height;
    }// end of getVolume

    // Overriding getArea() method
    @Override
    public double getArea() {
        return (2 * super.getArea()) + this.height * Math.PI * (2 * getRadius());
    }// end of getArea

}// end of Cylinder class
