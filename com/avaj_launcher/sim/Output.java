package com.avaj_launcher.sim;

import java.io.*;

public class Output {
    static File file;
    static PrintWriter writer;
    public static void createFile() {
        try {
            file = new File("simulation.txt");
            if (file.createNewFile()){

            } else {
                writer = new PrintWriter(file);
                writer.flush();
                writer.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void writeOuput(String outString) {
        try {
            writer = new PrintWriter(new FileWriter(file, true));
            writer.write(outString);
            writer.append("\n");
            writer.close();
        } catch (Exception e) {
            System.out.println("Error occured while writing to file");
        }
    }
}
