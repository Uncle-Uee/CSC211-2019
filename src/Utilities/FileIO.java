package Utilities;/*
 * Created By : Uee
 * Modified By :
 *
 * <p>
 * This Source Code is released under the terms of the
 * GNU license. See https://www.gnu.org/licenses/#GPL
 * for more information.
 * <p>
 * Usage:   Do what you want, modify like you want.
 * <p>
 */

import java.io.*;
import java.util.*;

public abstract class FileIO {

    /**
     * Default Constructor
     */
    public FileIO() {
    }

    /**
     * Read a File Line-by-Line and Store each Line into an ArrayList and Return the ArrayList of Data.
     *
     * @param filePath the String Path Location of the File to Read from.
     * @return the ArrayList of String Data.
     */
    public static ArrayList<String> ReadLines(String filePath) {

        try {

            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            ArrayList<String> lines = new ArrayList<>();
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                lines.add(line);
            }

            bufferedReader.close();

            return lines;

        } catch (IOError | IOException e) {
            System.out.println(e.toString());
        }

        return null;
    }

    /**
     * Write Data from an ArrayList to a Specific File.
     *
     * @param filePath the String Path Location of the File to Write to.
     * @param data     the ArrayList of Data that will be Written to the File.
     */
    public static <T> void WriteFile(String filePath, ArrayList<T> data) {
        try {
            FileWriter fileWriter = new FileWriter(filePath);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            for (T element : data)
                bufferedWriter.write(element.toString() + "\n");

            bufferedWriter.close();

        } catch (IOError | IOException e) {
            System.out.println(e.toString());
        }
    }

    /**
     * Overwrite or Append new Data to a file.
     *
     * @param filePath the String Path Location of the File to Write to.
     * @param data     the specific Data that will be Written to the File.
     * @param append   flag to append data to a File instead of Overwriting it.
     */
    public static void WriteFile(String filePath, Object data, boolean append) {
        try {
            FileWriter fileWriter = new FileWriter(filePath, append);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(data.toString() + "\n");
            bufferedWriter.close();

        } catch (IOError | IOException e) {
            System.out.println(e.toString());
        }
    }
}
