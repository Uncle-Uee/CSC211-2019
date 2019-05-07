package Term2;

import Utilities.FileIO;

import java.util.ArrayList;

public class init {
    public static ArrayList<Integer> lines = null;

    public static void main(String[] args) {
        lines = FileIO.ReadLines("file.txt", false, FileIO.TYPE.INT);
        System.out.println(lines.get(0).getClass());
    }
}
