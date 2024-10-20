package com.example.project;

public class LinearCalculator {
    // INSTANCE VARIABLES
    private int x1;
    private int x2;
    private int y1;
    private int y2;

    // CONSTRUCTOR
    public LinearCalculator(String point1, String point2) {
        // Parsing the points from strings
        this.x1 = Integer.parseInt(point1.substring(1, point1.indexOf(',')));
        this.y1 = Integer.parseInt(point1.substring(point1.indexOf(',') + 1, point1.indexOf(')')));
        this.x2 = Integer.parseInt(point2.substring(1, point2.indexOf(',')));
        this.y2 = Integer.parseInt(point2.substring(point2.indexOf(',') + 1, point2.indexOf(')')));
    }
    
    // GETTERS
     public int getX1() {
        return x1;
    }


    public int getY1() {
        return y1;
    }
   
    public int getX2() {
        return x2;
    }
   
    public int getY2() {
        return y2;
    }


    // SETTERS
    public void setX1(int x1) {
        this.x1 = x1;
    }
   
    public void setY1(int y1) {
        this.y1 = y1;
    }


    public void setX2(int x2) {
        this.x2 = x2;
    }
   
    public void setY2(int y2) {
        this.y2 = y2;
    }


    // METHOD TO CALCULATE DISTANCE
    public double distance() {
        double distance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        return roundedToHundredth(distance);
    }

    // METHOD TO CALCULATE SLOPE
    public double slope() {
        if (x2 - x1 == 0) {
            return -999.99;  // Undefined slope (vertical line)
        }
        double slope = (double) (y2 - y1) / (x2 - x1);
        return roundedToHundredth(slope);
    }

    // METHOD TO CALCULATE Y-INTERCEPT
    public double yInt() {
        if (x2 - x1 == 0) {
            return -999.99;  // Undefined y-intercept (vertical line)
        }
        double yInt = y1 - slope() * x1;
        return roundedToHundredth(yInt);
    }

    // METHOD TO CREATE EQUATION
    public String equation() {
        if (slope() == -999.99) {
            return "undefined";          //if the equation has no slope, the equation should return -> "undefined"
        }
        if (slope() == 0.0) {
            return "y=" + yInt();        //if the equation has 0 as its slope, the equation should return the y-int
        }
        String output = "y=" + slope() + "x";
        if (yInt() > 0) {
            output += "+" + yInt();
        } else if (yInt() != 0) {
            output += yInt();
        }
        return output;
    }

    // METHOD TO ROUND TO NEAREST HUNDREDTH
    public double roundedToHundredth(double value) {
        return Math.round(value * 100.0) / 100.0;
    }

    // FIND SYMMETRY METHOD
    public String findSymmetry() {
        if (y1 == -y2 && x1 == x2) {
            return "Symmetric about the x-axis";
        } else if (x1 == -x2 && y1 == y2) {
            return "Symmetric about the y-axis";
        } else if (x1 == -x2 && y1 == -y2) {
            return "Symmetric about the origin";
        } else {
            return "No symmetry";
        }
    }

    // MIDPOINT METHOD
    public String Midpoint() {
        double midX = (x1 + x2) / 2.0;
        double midY = (y1 + y2) / 2.0;
        return "The midpoint of this line is: (" + roundedToHundredth(midX) + "," + roundedToHundredth(midY) + ")";
    }

    // UPDATED PRINT INFO METHOD
    public String printInfo() {
        String str = "The two points are: (" + x1 + "," + y1 + ")";
        str += " and " + "(" + x2 + "," + y2 + ")";
        str += "\nThe equation of the line between these points is: " + equation();
        str += "\nThe slope of this line is: " + slope();
        str += "\nThe y-intercept of the line is: " + yInt();
        str += "\nThe distance between the two points is: " + distance();
        str += "\n" + Midpoint();
        str += "\n" + findSymmetry();
        return str;
    }
}