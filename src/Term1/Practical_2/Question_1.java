/*
  Created By : Uee
  Modified By :

  <p>
  This Source Code is released under the terms of the
  GNU license. See https://www.gnu.org/licenses/#GPL
  for more information.
  <p>
  Usage:   Do what you want, modify like you want.
  <p>
 */

package Term1.Practical_2;

import java.io.*;
import java.util.*;

public class Question_1 {

    /* ---------- ---------- ---------- VARIABLES ---------- ---------- ---------- */
    private final HashMap NUMBERS = new HashMap<String, Integer>() {{
        put("zero", 0);
        put("one", 1);
        put("two", 2);
        put("three", 3);
        put("four", 4);
        put("five", 5);
        put("six", 6);
        put("seven", 7);
        put("eight", 8);
        put("nine", 9);
        put("ten", 10);
        put("eleven", 11);
        put("twelve", 12);
        put("thirteen", 13);
        put("fourteen", 14);
        put("fifteen", 15);
        put("sixteen", 16);
        put("seventeen", 17);
        put("eighteen", 18);
        put("nineteen", 19);
        put("twenty", 20);
    }};
    private int _value = 0;

    /* ---------- ---------- ---------- CONSTRUCTORS ---------- ---------- ---------- */

    public Question_1() {
    }

    public Question_1(String inputFile, String outputFile) {

        ReadWriteFile(inputFile, outputFile);

    }
    /* ---------- ---------- ---------- METHODS ---------- ---------- ---------- */

    public void ReadWriteFile(String inputFile, String outputFile) {
        try {
            FileWriter fileWriter = new FileWriter(outputFile);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            FileReader fileReader = new FileReader(inputFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            String[] expression;

            while ((line = bufferedReader.readLine()) != null) {
                if (line.length() > 0) {

                    /*
                     * Use Regex to Replace Special Characters with a Whitespace.
                     * Then split the String by a whitespace to get a String Array.
                     */
                    expression = line.split("[^\\p{Alpha} ]");

                    /*
                     * Write the Evaluated Expression to the Output File.
                     */
                    bufferedWriter.write(EvaluateExpression(expression) + "\n");
                }
            }

            bufferedReader.close();
            bufferedWriter.close();
        } catch (IOException | IOError e) {
            System.out.println(e.toString());
        }
    }

    /* ---------- ---------- ---------- GETTERS AND SETTERS ---------- ---------- ---------- */

    /* ---------- ---------- ---------- HELPERS ---------- ---------- ---------- */

    /**
     * Get the Integer Value of the NUMBERS Hashmap using the String Key.
     *
     * @param key of the Integer Value.
     * @return the Key's Value Pair as an int.
     */
    private int GetValue(String key) {
        return (int) this.NUMBERS.get(key);
    }

    /**
     * Evaluate a String Array Mathematical Expression and Return the Integer Value.
     *
     * @param expression a String Array Mathematical Expression.
     * @return
     */
    private int EvaluateExpression(String[] expression) {
        /*
         * Store the First Value.
         */
        this._value = GetValue(expression[0]);

        /*
         * Loop through the Expression Array and Apply the Correct Mathematical Operation
         * using the Values that are found at index 2 onwards.
         */
        for (int i = 2, j = 1; i < expression.length; i += 2, j += 2) {
            switch (expression[j]) {
                case "plus":
                    this._value += GetValue(expression[i]);
                    break;
                case "minus":
                    this._value -= GetValue(expression[i]);
                    break;
                case "multipliedby":
                    this._value *= GetValue(expression[i]);
                    break;
                case "dividedby":
                    try {
                        this._value /= GetValue(expression[i]);
                        break;
                    } catch (Exception e) {
                        System.out.println(e.toString());
                    }
                case "raisedtopowerof":
                    this._value = (int) Math.pow(this._value, GetValue(expression[i]));
                    break;
            }
        }
        return this._value;
    }

    /* ---------- ---------- ---------- MAIN METHOD ---------- ---------- ---------- */
    public static void main(String[] args) {
        Question_1 Q1 = new Question_1("prac2.txt", "prac2_3341897.txt");
    }
}
