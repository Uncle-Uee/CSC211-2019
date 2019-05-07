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

public class FileIO {

    private static FileReader fileReader = null;
    private static BufferedReader bufferedReader = null;

    private static ArrayList lines = null;

    public enum TYPE {
        STRING,
        CHAR,
        INT,
        FLOAT,
        DOUBLE
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

    public static ArrayList<Integer> ReadIntegers(String filePath) {

        try {

            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            ArrayList<Integer> lines = new ArrayList<>();
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                lines.add(Integer.parseInt(line));
            }

            bufferedReader.close();

            return lines;

        } catch (IOError | IOException e) {
            System.out.println(e.toString());
        }

        return null;
    }

    /**
     * @param filePath
     * @param cleanString
     * @param type
     * @return
     */
    public static ArrayList ReadLines(String filePath, boolean cleanString, TYPE type) {
        try {

            fileReader = new FileReader(filePath);
            bufferedReader = new BufferedReader(fileReader);

            switch (type) {
                case STRING:
                    lines = new ArrayList<String>();
                    break;
                case CHAR:
                    lines = new ArrayList<Character>();
                    break;
                case INT:
                    lines = new ArrayList<Integer>();
                    break;
                case FLOAT:
                    lines = new ArrayList<Float>();
                    break;
                case DOUBLE:
                    lines = new ArrayList<Double>();
                    break;
                default:
//                    lines = new ArrayList<T>();
                    break;
            }

            String line;

            while ((line = bufferedReader.readLine()) != null) {

                if (cleanString)
                    line = line.replaceAll("[^\\p{Alpha} ]", "").toLowerCase();

                switch (type) {
                    case STRING:
                        lines.add(line);
                        break;
                    case CHAR:
                        lines.add(line.charAt(0));
                        break;
                    case INT:
                        lines.add(Integer.parseInt(line));
                        break;
                    case FLOAT:
                        lines.add(Float.parseFloat(line));
                        break;
                    case DOUBLE:
                        lines.add(Double.parseDouble(line));
                        break;
                    default:
//                        lines.add((T) line);
                        break;
                }
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
