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

import java.util.*;

import static Utilities.FileIO.*;

public class Question_2 {

    /* ---------- ---------- ---------- VARIABLES ---------- ---------- ---------- */

    private ArrayList<String> lines;


    /* ---------- ---------- ---------- CONSTRUCTORS ---------- ---------- ---------- */

    public Question_2(String inputFile) {
        this.lines = ReadLines(inputFile);
    }

    public Question_2(String inputFile, String word) {
        this.lines = ReadLines(inputFile);
        System.out.println(FindMatch(word) ? "Matched" : "No Match");
    }

    /* ---------- ---------- ---------- QUESTION 2 METHODS ---------- ---------- ---------- */

    public boolean FindMatch(String word) {
        return FindWord(word) || ContainsCharacters(word);
    }

    private boolean ContainsCharacters(String word) {
        for (String element : lines) {
            for (int i = 0; i < word.length(); i++) {
                if (element.indexOf(word.charAt(i)) < 0) {
                    break;
                }
                if (i == word.length() - 1) {
                    System.out.println(element + " " + word);
                    return true;
                }
            }
        }
        return false;
    }

    private boolean FindWord(String word) {
        return lines != null && lines.contains(word);
    }

    /* ---------- ---------- ---------- GETTERS AND SETTERS ---------- ---------- ---------- */

    public ArrayList<String> getLines() {
        return lines;
    }

    public void setLines(ArrayList<String> lines) {
        this.lines = lines;
    }

    public static void main(String[] args) {
        Question_2 Q2 = new Question_2("data2.txt", "uee");

    }
}
