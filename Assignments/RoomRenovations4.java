/*
 * Author: Danielle Moore
 * Date: 10/4//2024
 * Description: This program uses builds off of assignment 4 and creates methods to calculate the cost of a room renovation. 
 */
package Assignments;

import java.util.Scanner;

public class RoomRenovations4 {

    // Global variables
    public static double fullWallArea;
    public static double fullFloorArea;

    // Method to calculate the area of the door and subtract it from the total area
    // of the wall.
    public static double calculateWallAreaWithoutDoors(double width, double height, double wallArea) {
        double doorArea = width * height;
        wallArea -= doorArea;
        return wallArea;
    }// end of calculateWallAreaWithoutDoors method

    // Method to calculate the area of the window and subtract it from the total
    // area
    // of the wall.
    public static double calculateWallAreaWithoutWindows(double width, double height, double wallArea) {
        double windowArea = width * height;
        wallArea -= windowArea;
        return wallArea;
    }// end of calculateWallAreaWithoutWindows method

    // Method to calculate area of the bookcase face and subtract from the wall
    // area.
    public static double calculateWallAreaWithoutBookcase(double length, double height, double wallArea) {
        double faceBookshelfArea = length * height;
        wallArea -= faceBookshelfArea;
        return wallArea;
    }// end of calculateWallAreaWithoutBookcase method

    // Method to calculate area of the bookcase face and subtract from the wall
    // area.
    public static double calculateFloorAreaWithoutBookcase(double length, double depth, double floorArea) {
        double bottomBookshelfArea = length * depth;
        floorArea -= bottomBookshelfArea;
        return floorArea;
    }// end of calculateWallAreaWithoutBookcase method

    // Method to pick the flooring based on the user's choice and budget
    public static void chooseFlooring(int flooringChoice, double flooringBudget, double floorArea, double titleCost,
            double woodCost, double carpetCost, double linoleumCost) {
        // check flooring choice
        for (int loop = 1; flooringChoice <= 4; loop++, flooringChoice++) {
            if (flooringChoice == 1 && (flooringBudget >= floorArea * titleCost)) {
                if (loop == 1 && flooringChoice != 0) {
                    System.out.printf(
                            "Congrats! You got your flooring preference of ceramic tile. You have $%.2f left in your flooring budget.",
                            flooringBudget - floorArea * titleCost);
                } else {
                    System.out.printf(
                            "Your flooring choice is ceramic tile. You have $%.2f left in your flooring budget.",
                            flooringBudget - floorArea * titleCost);
                }
                ;
                break;
            } else if (flooringChoice == 2 && (flooringBudget >= floorArea * woodCost)) {
                if (loop == 1 && flooringChoice != 0) {
                    System.out.printf(
                            "Congrats! You got your flooring preference of hardwood. You have $%.2f left in your flooring budget.",
                            flooringBudget - floorArea * woodCost);
                } else {
                    System.out.printf("Your flooring choice is hardwood. You have $%.2f left in your flooring budget.",
                            flooringBudget - floorArea * woodCost);
                }
                ;
                break;
            } else if (flooringChoice == 3 && (flooringBudget >= floorArea * carpetCost)) {
                if (loop == 1 && flooringChoice != 0) {
                    System.out.printf(
                            "Congrats! You got your flooring preference of carpet. You have $%.2f left in your flooring budget.\n",
                            flooringBudget - floorArea * carpetCost);
                } else {
                    System.out.printf("Your flooring choice is carpet. You have $%.2f left in your flooring budget.\n",
                            flooringBudget - floorArea * carpetCost);
                }
                ;
                break;
            } else if (flooringChoice == 4 && (flooringBudget >= floorArea * linoleumCost)) {
                if (loop == 1 && flooringChoice != 0) {
                    System.out.printf(
                            "Congrats! You got your flooring preference of linoleum tile. You have $%.2f left in your flooring budget.\n",
                            flooringBudget - floorArea * linoleumCost);
                } else {
                    System.out.printf(
                            "Your flooring choice is linoleum tile. You have $%.2f left in your flooring budget.\n",
                            flooringBudget - floorArea * linoleumCost);
                }
                ;
                break;
            }
        } // end of for loop

        // If the user does not have enough in their budget for any of the floorings,
        // tell them.
        if (flooringChoice == 5) {
            System.out.printf("You cannot afford any flooring with your budget. You have $%.2f left in your budget\n",
                    flooringBudget);
        }
    }// end of chooseFlooring method

    public static void chooseWallCovering(int wallCoveringChoice, double wallCoveringBudget, double wallArea,
            double tileCost, double panelingCost, double wallpaperCost, double paintCost) {
        // Wall covering check
        for (int loop = 1; wallCoveringChoice <= 4; loop++, wallCoveringChoice++) {
            if (wallCoveringChoice == 1 && (wallCoveringBudget >= wallArea * tileCost)) {
                if (loop == 1 && wallCoveringChoice != 0) {
                    System.out.printf(
                            "Congrats! You got your wall covering preference of ceramic tile. You have $%.2f left in your wall covering budget.",
                            wallCoveringBudget - wallArea * tileCost);
                } else {
                    System.out.printf(
                            "Your flooring choice is ceramic tile. You have $%.2f left in your wall covering budget.",
                            wallCoveringBudget - wallArea * tileCost);
                }
                ;
                break;
            } else if (wallCoveringChoice == 2 && (wallCoveringBudget >= wallArea * panelingCost)) {
                if (loop == 1 && wallCoveringChoice != 0) {
                    System.out.printf(
                            "Congrats! You got your wall covering preference of paneling. You have $%.2f left in your wall covering budget.",
                            wallCoveringBudget - wallArea * panelingCost);
                } else {
                    System.out.printf(
                            "Your flooring choice is paneling. You have $%.2f left in your wall covering budget.",
                            wallCoveringBudget - wallArea * panelingCost);
                }
                ;
                break;
            } else if (wallCoveringChoice == 3 && (wallCoveringBudget >= wallArea * wallpaperCost)) {
                if (loop == 1 && wallCoveringChoice != 0) {
                    System.out.printf(
                            "Congrats! You got your wall covering preference of wallpaper. You have $%.2f left in your wall covering budget.\n",
                            wallCoveringBudget - wallArea * wallpaperCost);
                } else {
                    System.out.printf(
                            "Your flooring choice is wallpaper. You have $%.2f left in your wall covering budget.\n",
                            wallCoveringBudget - wallArea * wallpaperCost);
                }
                ;
                break;
            } else if (wallCoveringChoice == 4 && (wallCoveringBudget >= wallArea * paintCost)) {
                if (loop == 1 && wallCoveringChoice != 0) {
                    System.out.printf(
                            "Congrats! You got your wall covering preference of paint. You have $%.2f left in your wall covering budget.\n",
                            wallCoveringBudget - wallArea * paintCost);
                } else {
                    System.out.printf(
                            "Your flooring choice is paint. You have $%.2f left in your wall covering budget.\n",
                            wallCoveringBudget - wallArea * paintCost);
                }
                ;
                break;
            }
        }

        // If the user does not have enough in their budget for any of the floorings,
        // tell them.
        if (wallCoveringChoice == 5) {
            System.out.printf(
                    "You cannot afford any wall covering with your budget. You have $%.2f left in your budget",
                    wallCoveringBudget);
        }
    }// end of chooseWallCovering method

    // Start of main method
    public static void main(String[] args) {
        // Variables and initialization
        double roomLength, roomWidth, roomHeight, userFlooringBudget, userWallCoveringBudget, floorTileCost = 4.00,
                floorWoodCost = 3.00,
                floorCarpetCost = 2.00, floorLinoleumCost = 1.00, wallTileCost = 4.00, wallPanelingCost = 3.00,
                wallWallpaperCost = 2.00, wallPaintCost = 1.00;
        int userFlooringChoice, userWallCoverChoice;

        Scanner userInput = new Scanner(System.in); // creating a scanner object.

        // User budger
        System.out.println("Enter your floor and wall coverings budget for the room renovation: ");
        userFlooringBudget = userInput.nextDouble();
        userWallCoveringBudget = userInput.nextDouble();

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
                fullWallArea = calculateWallAreaWithoutDoors(doorWidth, doorHeight, fullWallArea);
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
                fullWallArea = calculateWallAreaWithoutWindows(windowWidth, windowHeight, fullWallArea);
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
                fullWallArea = calculateWallAreaWithoutBookcase(bookcaseLength, bookcaseHeight, fullWallArea);
                fullFloorArea = calculateFloorAreaWithoutBookcase(bookcaseLength, bookcaseDepth, fullFloorArea);
            } // end of for statement
        }

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
                userFlooringBudget, userWallCoveringBudget);

        // Getting the flooring choice
        chooseFlooring(userFlooringChoice, userFlooringBudget, fullFloorArea, floorTileCost, floorWoodCost,
                floorCarpetCost, floorLinoleumCost);

        // Getting the wall covering choice
        chooseWallCovering(userWallCoverChoice, userWallCoveringBudget, fullWallArea, wallTileCost, wallPanelingCost,
                wallWallpaperCost, wallPaintCost);

        // Closing scanner
        userInput.close();

    }// end of main

}// end of class
