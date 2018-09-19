package com.aircraft.tower;

import java.io.*;

public class WriteToFile {
    private static BufferedWriter writer = null;

    public static void openFile(){
        if (writer == null)
            try {
                writer = new BufferedWriter(new FileWriter("simulation.txt"));
            } catch (IOException e) {
                System.out.println("Could not open the file");
            }
    }

    public static void writeToFile(String message) {
        try {
            writer.write(message);
            writer.newLine();
            writer.flush();
        } catch (IOException e) {
            System.out.println("Cant write to the file");
        }
    }
}
