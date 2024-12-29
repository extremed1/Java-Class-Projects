/*
 * Author: Danielle Moore
 * Date: 9/21/2024
 * Description: This program calculates the cost of renovating a room given input from the user.
 */
package Assignments;

//importing the Scanner class from the java.util package.
import java.util.Scanner;

public class RoomRenovations {
    public static void main(String[] args) {
        // Variables and initialization
        double roomLength, roomWidth, roomHeight, doorWidth, doorHeight, firstWindowWidth, firstWindowHeight,
                secondWindowWidth, secondWindowHeight, bookshelfLength, bookshelfWidth, bookshelfDepth,
                paintingRate, tileFlooringRate = 4.00, hardwoodFlooringRate = 3.00, carpetFlooringRate = 2.00,
                linoleumFlooringRate = 1.00,
                userBudget;

        int userFlooringChoice;

        Scanner userInput = new Scanner(System.in); // creating a scanner object.

        // User Budget
        System.out.println("Enter your budget for the room renovation: ");
        userBudget = userInput.nextDouble();

        // User Preference for Flooring
        System.out.println(
                "Enter the type of flooring you would like to use (0 = Don't Care; 1 = Ceramic Tile; 2 = Hardwood; 3 = Carpet; 4 = Linoleum Tile): ");
        userFlooringChoice = userInput.nextInt();

        // Room dimensions
        System.out.println("Enter the length, width, and height of the room in feet: ");
        roomLength = userInput.nextDouble();
        roomWidth = userInput.nextDouble();
        roomHeight = userInput.nextDouble();

        // Door dimensions
        System.out.println("Enter the width and height of the door in feet: ");
        doorWidth = userInput.nextDouble();
        doorHeight = userInput.nextDouble();

        // Window dimensions
        System.out.println("Enter the width and height of the first window in feet: "); // asking user for window 1
        // dimensions.
        firstWindowWidth = userInput.nextDouble();
        firstWindowHeight = userInput.nextDouble();

        System.out.println("Enter the width and height of the second window in feet: "); // asking user for window 2
        // dimensions.
        secondWindowWidth = userInput.nextDouble();
        secondWindowHeight = userInput.nextDouble();

        // Bookshelf dimensions
        System.out.println("Enter the length, height, and depth of the bookshelf in feet: ");
        bookshelfLength = userInput.nextDouble();
        bookshelfWidth = userInput.nextDouble();
        bookshelfDepth = userInput.nextDouble();

        // Painting and carpeting rates
        System.out.println("Enter the cost per square foot for painting: ");
        paintingRate = userInput.nextDouble();
        // carpetingRate = userInput.nextDouble();

        // Calculations

        // Floor and wall areas
        double fullFloorArea = roomLength * roomWidth;
        double fullWallArea = (roomLength * (2 * roomHeight)) + (roomWidth * (2 * roomHeight));

        // Window areas
        double window1Area = firstWindowWidth * firstWindowHeight; // calculating the area of window 1.
        double window2Area = secondWindowWidth * secondWindowHeight; // calculating the area of window 2.

        // Door and bookshelf areas
        double doorArea = doorWidth * doorHeight;
        double faceBookshelfArea = bookshelfLength * bookshelfWidth;
        double bottomBookshelfArea = bookshelfLength * bookshelfDepth;

        // Total areas
        double totalPaintingArea = fullWallArea - window1Area - window2Area - doorArea - faceBookshelfArea;
        double totalCarpetingArea = fullFloorArea - bottomBookshelfArea;

        double totalCostOfPainting = totalPaintingArea * paintingRate;

        // Printing out the results
        System.out.printf("Wall area to be painted = %.2f\n", totalPaintingArea);
        System.out.printf("Floor area to be covered = %.2f\n", totalCarpetingArea);
        System.out.printf("Cost of wall painting= $%.2f\n", totalCostOfPainting);

        // Determining if user can afford flooring choice. If not,find next most
        // expensive flooring that can be afforded. If no preference is given,
        // find the most expensive flooring that can be afforded. If they can not afford
        // any of the flooring due to their budget, print a message saying so.

        if (userFlooringChoice == 0) {
            // If the user doesn't care what type of flooring they want.
            if (userBudget >= totalCarpetingArea * tileFlooringRate) {
                System.out.printf("Floor Covering: Ceramic Title;\nFloor Budget Left: $%.2f",
                        userBudget - totalCarpetingArea * tileFlooringRate);
            } else if (userBudget >= totalCarpetingArea * hardwoodFlooringRate) {
                System.out.printf("Floor Covering: Hardwood;\nFloor Budget Left: $%.2f",
                        userBudget - totalCarpetingArea * hardwoodFlooringRate);
            } else if (userBudget >= totalCarpetingArea * carpetFlooringRate) {
                System.out.printf("Floor Covering: Carpet;\nFloor Budget Left: $%.2f",
                        userBudget - totalCarpetingArea * carpetFlooringRate);
            } else if (userBudget >= totalCarpetingArea * linoleumFlooringRate) {
                System.out.printf("Floor Covering: Linoleum Tile;\nFloor Budget Left: $%.2f",
                        userBudget - totalCarpetingArea * linoleumFlooringRate);
            } else {
                System.out.printf("You cannot afford any flooring with your budget. You have $%.2f left in your budget",
                        userBudget);
            }
        } else if (userFlooringChoice == 1) {
            // If the user prefers the most expensive option (Ceramic Title)
            if (userBudget >= totalCarpetingArea * tileFlooringRate) {
                System.out.printf("Floor Covering: Ceramic Title;\nFloor Budget Left: $%.2f",
                        userBudget - totalCarpetingArea * tileFlooringRate);
            } else if (userBudget >= totalCarpetingArea * hardwoodFlooringRate) {
                System.out.printf("Floor Covering: Hardwood;\nFloor Budget Left: $%.2f",
                        userBudget - totalCarpetingArea * hardwoodFlooringRate);
            } else if (userBudget >= totalCarpetingArea * carpetFlooringRate) {
                System.out.printf("Floor Covering: Carpet;\nFloor Budget Left: $%.2f",
                        userBudget - totalCarpetingArea * carpetFlooringRate);
            } else if (userBudget >= totalCarpetingArea * linoleumFlooringRate) {
                System.out.printf("Floor Covering: Linoleum Tile;\nFloor Budget Left: $%.2f",
                        userBudget - totalCarpetingArea * linoleumFlooringRate);
            } else {
                System.out.printf("You cannot afford any flooring with your budget. You have $%.2f left in your budget",
                        userBudget);
            }
        } else if (userFlooringChoice == 2) {
            // If the user prefers the second most expensive option (Hardwood)
            if (userBudget >= totalCarpetingArea * hardwoodFlooringRate) {
                System.out.printf("Floor Covering: Hardwood;\nFloor Budget Left: $%.2f",
                        userBudget - totalCarpetingArea * hardwoodFlooringRate);
            } else if (userBudget >= totalCarpetingArea * carpetFlooringRate) {
                System.out.printf("Floor Covering: Carpet;\nFloor Budget Left: $%.2f",
                        userBudget - totalCarpetingArea * carpetFlooringRate);
            } else if (userBudget >= totalCarpetingArea * linoleumFlooringRate) {
                System.out.printf("Floor Covering: Linoleum Tile;\nFloor Budget Left: $%.2f",
                        userBudget - totalCarpetingArea * linoleumFlooringRate);
            } else {
                System.out.printf("You cannot afford any flooring with your budget. You have $%.2f left in your budget",
                        userBudget);
            }
        } else if (userFlooringChoice == 3) {
            // If the user prefers the third most expensive option (Carpet)
            if (userBudget >= totalCarpetingArea * carpetFlooringRate) {
                System.out.printf("Floor Covering: Carpet;\nFloor Budget Left: $%.2f",
                        userBudget - totalCarpetingArea * carpetFlooringRate);
            } else if (userBudget >= totalCarpetingArea * linoleumFlooringRate) {
                System.out.printf("Floor Covering: Linoleum Tile;\nFloor Budget Left: $%.2f",
                        userBudget - totalCarpetingArea * linoleumFlooringRate);
            } else {
                System.out.printf("You cannot afford any flooring with your budget. You have $%.2f left in your budget",
                        userBudget);
            }
        } else if (userFlooringChoice == 4) {
            // If the user prefers the least expensive option (Linoleum Tile)
            if (userBudget >= totalCarpetingArea * linoleumFlooringRate) {
                System.out.printf("Floor Covering: Linoleum Tile;\nFloor Budget Left: $%.2f",
                        userBudget - totalCarpetingArea * linoleumFlooringRate);
            } else {
                // If the user cannot afford any flooring.
                System.out.printf("You cannot afford any flooring with your budget. You have $%.2f left in your budget",
                        userBudget);
            }
        }

        // closing the scanner object.
        userInput.close();
    }// end of main
} // end of class