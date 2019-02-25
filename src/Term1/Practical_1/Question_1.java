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

package Term1.Practical_1;

import java.io.*;

public class Question_1 {

    /* ---------- ---------- ---------- CONSTRUCTORS ---------- ---------- ---------- */

    public Question_1() {
    }

    public Question_1(String inputFile, String outputFile) {
        ReadWriteFile(inputFile, outputFile);
    }

    /* ---------- ---------- ---------- QUESTION 1 METHODS ---------- ---------- ---------- */


    public void ReadWriteFile(String inputFile, String outputFile) {
        try {

            FileReader fileReader = new FileReader(new File(inputFile));
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            FileWriter fileWriter = new FileWriter(new File(outputFile));
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            // String with no Special Characters and Digits.
            String line0;
            // String with no Duplicate Letters.
            String line1;

            while ((line0 = bufferedReader.readLine()) != null) {

                // Remove Special Characters and Digits
                line0 = line0.replaceAll("[^\\p{Alpha} ]", "").toLowerCase();

                // Remove Duplicate Letters
                line1 = "";
                for (int i = 0; i < line0.length(); i++) {
                    if (line1.indexOf(line0.charAt(i)) < 0)
                        line1 += line0.charAt(i);
                }

                bufferedWriter.write(line1 + "\n");
            }

            bufferedReader.close();
            bufferedWriter.close();

        } catch (IOException | IOError e) {
            System.out.println(e.toString());
        }
    }

    /* ---------- ---------- ---------- GETTERS AND SETTERS ---------- ---------- ---------- */

    public static void main(String[] args) {
        // Another Possible Way to Execute the ReadWriteFile Method.

        //        Question_1 Q1 = new Question_1();
        //        Q1.ReadWriteFile("data1.txt", "data2.txt");

        Question_1 Q1 = new Question_1("data1.txt", "data2.txt");

    }

}
