package com.avaj_launcher.sim;

import java.io.*;

public class Output {
    static File file;
    public static void createFile() {
        try {
            file = new File("simulation.txt");
            if(file.createNewFile()) {

            } else {
                throw new Exception("File already exists");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void writeOuput(String outString) {
        try {
            PrintWriter writer = new PrintWriter(file);
            writer.write(outString);
            writer.flush();
            writer.close();
        } catch (Exception e) {
            System.out.println("Error occured while writing to file");
        }
    }
}
