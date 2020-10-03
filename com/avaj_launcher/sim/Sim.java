package com.avaj_launcher.sim;

import java.io.*;
import com.avaj_launcher.sim.aircraft.*;
import com.avaj_launcher.sim.tower.*;

public class Sim {
    public static void main(String[] args) {
        // BufferedReader fileReader = null;
        // try{
        //     if (0 < args.length) {
        //         String filename = args[0];
        //         File file = new File(filename);

        //         if (file.exists()) {
        //             if (file.length() != 0){
        //                 String currentLine;
        //                 int storeNumber;

        //                 fileReader = new BufferedReader(new FileReader(file));
                        
        //                 currentLine = fileReader.readLine();

        //                 try { 
        //                      storeNumber = Integer.parseInt(currentLine);
        //                     if (storeNumber >= 0) {
        //                         while((currentLine = fileReader.readLine()) != null) {
        //                             System.out.println(currentLine);
        //                         }
        //                     } else {
        //                         throw new Exception("The first line was not a positive integer");
        //                     }
        //                 } catch (Exception e) {
        //                     throw new Exception("The first line was not a positive integer");
        //                 }
        //             } else {
        //                 throw new Exception("The file is empty");
        //             }
        //         } else {
        //             throw new Exception("File does not exist");
        //         }
        //     }
        // }catch(Exception e) {
        //     System.out.println(e.getMessage());
        // }
        String line = "Balloon hey 20 5 11";
        validateInput(line);
    }

    public static void validateInput(String line) {
        String[] inputArray = line.split(" ");
        int longitude;
        int latitude;
        int height;

        try {
            if(inputArray.length == 5){
                if(inputArray[0].equals("Helicopter") || inputArray[0].equals("Balloon") || inputArray[0].equals("JetPlane")) {
                    try {
                        longitude = Integer.parseInt(inputArray[2]);
                        latitude = Integer.parseInt(inputArray[3]);
                        height = Integer.parseInt(inputArray[4]);

                        if (longitude >= 0 && latitude >= 0 && height >= 0) {
                            System.out.println("All coordinates are positive values");
                        } else {
                            throw new Exception(" ");
                        }
                    }catch(Exception e) {
                        throw new Exception("One or more of the coordinates is not a positive integer");
                    }

                } else {
                    throw new Exception("First string needs to be aircraft type");
                }
            } else {
                throw new Exception("Incorrect input format");
            }
        }catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
