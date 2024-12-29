/*
 * Author: Danielle Moore
 * Date: 9/26/2024
 * Description: This program calculates the cost of renovating a room given door, window, and bookcase inputs from the user. We
 * do not know how many doors, windows, or bookcases the user will have, so we will need to ask.
 */
package Assignments;

//importing the Scanner class from the java.util package.
import java.util.Scanner;

public class RoomRenovations3 {
    public static void main(String[] args) {
        // Variables and initialization
        double roomLength, roomWidth, roomHeight, userFlooringBudget, userWallCovingBudget, floorTileCost = 4.00,
                floorWoodCost = 3.00,
                floorCarpetCost = 2.00, floorLinoleumCost = 1.00, wallTileCost = 4.00, wallPanelingCost = 3.00,
                wallWallpaperCost = 2.00, wallPaintCost = 1.00;
        int userFlooringChoice, userWallCoverChoice;

        Scanner userInput = new Scanner(System.in); // creating a scanner object.

        // User budger
        System.out.println("Enter your floor and wall coverings budget for the room renovation: ");
        userFlooringBudget = userInput.nextDouble();
        userWallCovingBudget = userInput.nextDouble();

        // User preferences for floor and wall coverings
        System.out.println(
                "Please enter your preferences for the floor and wall coverings:\nFloor Coverings: 0 = Don't Care; 1 = Ceramic Tile; 2 = Hardwood; 3 = Carpet; 4 = Linoleum Tile\nWall Coverings: 0 = Don't Care; 1 = Ceramic Tile; 2 = Paneling; 3 = Wallpaper; 4 = Paint");
        userFlooringChoice = userInput.nextInt();
        userWallCoverChoice = userInput.nextInt();

        // Room dimensions
        System.out.println("Enter the length, width, and height of the room in feet: ");
        roomLength = userInput.nextDouble();
        roomWidth = userInput.nextDouble();
        roomHeight = userInput.nextDouble();

        // Floor and wall areas
        double fullFloorArea = roomLength * roomWidth;
        double fullWallArea = (roomLength * (2 * roomHeight)) + (roomWidth * (2 * roomHeight));

        // Ask user for number of doors
        System.out.println("Enter the number of doors in the room: ");
        int numDoors = userInput.nextInt();
        if (numDoors > 0) {
            for (int i = 1; i <= numDoors; i++) {
                int doorNumber = i;
                System.out.printf("Enter the width and height of door number %d in feet:%n", doorNumber);
                double doorWidth = userInput.nextDouble();
                double doorHeight = userInput.nextDouble();
                double doorArea = doorWidth * doorHeight;
                fullWallArea -= doorArea;
            } // end of for loop
        }

        // Ask user for number of windows
        System.out.println("Enter the number of windows in the room: ");
        int numWindows = userInput.nextInt();
        if (numWindows > 0) {
            for (int i = 1; i <= numWindows; i++) {
                int windowNumber = i;
                System.out.printf("Enter the width and height of window number %d in feet:%n", windowNumber);
                double windowWidth = userInput.nextDouble();
                double windowHeight = userInput.nextDouble();
                double windowArea = windowWidth * windowHeight;
                fullWallArea -= windowArea;
            } // end of for loop
        }

        // Ask for number of bookcases
        System.out.println("Enter the number of bookcases in the room: ");
        int numBookcases = userInput.nextInt();
        if (numBookcases > 0) {
            for (int i = 1; i <= numBookcases; i++) {
                int bookcaseNumber = i;
                System.out.printf("Enter the length, width, and depth of bookcase number %d in feet:%n",
                        bookcaseNumber);
                double bookcaseLength = userInput.nextDouble();
                double bookcaseHeight = userInput.nextDouble();
                double bookcaseDepth = userInput.nextDouble();

                // Calculate the area of the bookcase face and bottom
                double faceBookshelfArea = bookcaseLength * bookcaseHeight;
                double bottomBookshelfArea = bookcaseLength * bookcaseDepth;
                fullWallArea -= faceBookshelfArea;
                fullFloorArea -= bottomBookshelfArea;
            } // end of for statement
        }

        // Debugging
        /*
         * System.out.println("The total floor area is " + fullFloorArea +
         * " square feet.");
         * System.out.println("The total wall area is " + fullWallArea +
         * " square feet.");
         */

        // Checking to see if the user has enough in their budget for their preferred
        // floor and wall coverings.
        // If not the program will find the next best option.
        // If they do not have enough in their budget, the program will print out a
        // message saying so.

        // Printing out users floor preferences
        if (userFlooringChoice == 1) {
            System.out.println("You've chosen ceramic tile for the floor covering.");
        } else if (userFlooringChoice == 2) {
            System.out.println("You've chosen hardwood for the floor covering.");
        } else if (userFlooringChoice == 3) {
            System.out.println("You've chosen carpet for the floor covering.");
        } else if (userFlooringChoice == 4) {
            System.out.println("You've chosen linoleum tile for the floor covering.");
        } else {
            System.out.println("You do not have a preference for the floor covering.");
        }

        // Users wall covering preference
        if (userWallCoverChoice == 1) {
            System.out.println("You've chosen ceramic tile for the wall covering.");
        } else if (userWallCoverChoice == 2) {
            System.out.println("You've chosen paneling for the wall covering.");
        } else if (userWallCoverChoice == 3) {
            System.out.println("You've chosen wallpaper for the wall covering.");
        } else if (userWallCoverChoice == 4) {
            System.out.println("You've chosen paint for the wall covering.");
        } else {
            System.out.println("You do not have a preference for the wall covering.");
        }

        // Printing out user budget for wall and floor coverings
        System.out.printf(
                "Your budget for floor coverings is $%.2f, and your budget for the wall coverings is $%.2f.\n",
                userFlooringBudget, userWallCovingBudget);

        // check flooring choice
        for (int loop = 1; userFlooringChoice <= 4; loop++, userFlooringChoice++) {
            if (userFlooringChoice == 1 && (userFlooringBudget >= fullFloorArea * floorTileCost)) {
                if (loop == 1 && userFlooringChoice != 0) {
                    System.out.printf(
                            "Congrats! You got your flooring preference of ceramic tile. You have $%.2f left in your flooring budget.",
                            userFlooringBudget - fullFloorArea * floorTileCost);
                } else {
                    System.out.printf(
                            "Your flooring choice is ceramic tile. You have $%.2f left in your flooring budget.",
                            userFlooringBudget - fullFloorArea * floorTileCost);
                }
                ;
                break;
            } else if (userFlooringChoice == 2 && (userFlooringBudget >= fullFloorArea * floorWoodCost)) {
                if (loop == 1 && userFlooringChoice != 0) {
                    System.out.printf(
                            "Congrats! You got your flooring preference of hardwood. You have $%.2f left in your flooring budget.",
                            userFlooringBudget - fullFloorArea * floorWoodCost);
                } else {
                    System.out.printf("Your flooring choice is hardwood. You have $%.2f left in your flooring budget.",
                            userFlooringBudget - fullFloorArea * floorWoodCost);
                }
                ;
                break;
            } else if (userFlooringChoice == 3 && (userFlooringBudget >= fullFloorArea * floorCarpetCost)) {
                if (loop == 1 && userFlooringChoice != 0) {
                    System.out.printf(
                            "Congrats! You got your flooring preference of carpet. You have $%.2f left in your flooring budget.\n",
                            userFlooringBudget - fullFloorArea * floorCarpetCost);
                } else {
                    System.out.printf("Your flooring choice is carpet. You have $%.2f left in your flooring budget.\n",
                            userFlooringBudget - fullFloorArea * floorCarpetCost);
                }
                ;
                break;
            } else if (userFlooringChoice == 4 && (userFlooringBudget >= fullFloorArea * floorLinoleumCost)) {
                if (loop == 1 && userFlooringChoice != 0) {
                    System.out.printf(
                            "Congrats! You got your flooring preference of linoleum tile. You have $%.2f left in your flooring budget.\n",
                            userFlooringBudget - fullFloorArea * floorLinoleumCost);
                } else {
                    System.out.printf(
                            "Your flooring choice is linoleum tile. You have $%.2f left in your flooring budget.\n",
                            userFlooringBudget - fullFloorArea * floorLinoleumCost);
                }
                ;
                break;
            }
        }

        // If the user does not have enough in their budget for any of the floorings,
        // tell them.
        if (userFlooringChoice == 5) {
            System.out.printf("You cannot afford any flooring with your budget. You have $%.2f left in your budget\n",
                    userFlooringBudget);
        }

        // Wall covering check
        for (int loop = 1; userWallCoverChoice <= 4; loop++, userWallCoverChoice++) {
            if (userWallCoverChoice == 1 && (userWallCovingBudget >= fullWallArea * wallTileCost)) {
                if (loop == 1 && userWallCoverChoice != 0) {
                    System.out.printf(
                            "Congrats! You got your wall covering preference of ceramic tile. You have $%.2f left in your wall covering budget.",
                            userWallCovingBudget - fullWallArea * wallTileCost);
                } else {
                    System.out.printf(
                            "Your flooring choice is ceramic tile. You have $%.2f left in your wall covering budget.",
                            userWallCovingBudget - fullWallArea * wallTileCost);
                }
                ;
                break;
            } else if (userWallCoverChoice == 2 && (userWallCovingBudget >= fullWallArea * wallPanelingCost)) {
                if (loop == 1 && userWallCoverChoice != 0) {
                    System.out.printf(
                            "Congrats! You got your wall covering preference of paneling. You have $%.2f left in your wall covering budget.",
                            userWallCovingBudget - fullWallArea * wallPanelingCost);
                } else {
                    System.out.printf(
                            "Your flooring choice is paneling. You have $%.2f left in your wall covering budget.",
                            userWallCovingBudget - fullWallArea * wallPanelingCost);
                }
                ;
                break;
            } else if (userWallCoverChoice == 3 && (userWallCovingBudget >= fullWallArea * wallWallpaperCost)) {
                if (loop == 1 && userWallCoverChoice != 0) {
                    System.out.printf(
                            "Congrats! You got your wall covering preference of wallpaper. You have $%.2f left in your wall covering budget.\n",
                            userWallCovingBudget - fullWallArea * wallWallpaperCost);
                } else {
                    System.out.printf(
                            "Your flooring choice is wallpaper. You have $%.2f left in your wall covering budget.\n",
                            userWallCovingBudget - fullWallArea * wallWallpaperCost);
                }
                ;
                break;
            } else if (userWallCoverChoice == 4 && (userWallCovingBudget >= fullWallArea * wallPaintCost)) {
                if (loop == 1 && userWallCoverChoice != 0) {
                    System.out.printf(
                            "Congrats! You got your wall covering preference of paint. You have $%.2f left in your wall covering budget.\n",
                            userWallCovingBudget - fullWallArea * wallPaintCost);
                } else {
                    System.out.printf(
                            "Your flooring choice is paint. You have $%.2f left in your wall covering budget.\n",
                            userWallCovingBudget - fullWallArea * wallPaintCost);
                }
                ;
                break;
            }
        }

        // If the user does not have enough in their budget for any of the floorings,
        // tell them.
        if (userWallCoverChoice == 5) {
            System.out.printf(
                    "You cannot afford any wall covering with your budget. You have $%.2f left in your budget",
                    userWallCovingBudget);
        }

        userInput.close();

    }// end of main
}// end of class
