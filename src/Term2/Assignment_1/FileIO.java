package Term2.Assignment_1;

import java.io.*;
import java.util.ArrayList;

public class FileIO {

    /* ---------- ---------- ---------- VARIABLES ---------- ---------- ---------- */

    private static FileReader _fileReader;
    private static BufferedReader _bufferedReader;

    private static String _line = "";
    private static String[] _data;

    /* ---------- ---------- ---------- FileIO METHODS ---------- ---------- ---------- */

    public static ArrayList<Job> GetJobs(String path) {
        try {
            File file = new File(path);

            if (!file.exists()) {
                System.out.println("No Such File Exists.");
                return null;
            }

            _fileReader = new FileReader(file);
            _bufferedReader = new BufferedReader(_fileReader);

            ArrayList<Job> jobs = new ArrayList<>();

            // ToDo : Read Lines and Extract Jobs.
            while ((_line = _bufferedReader.readLine()) != null) {
                // ToDo : Extract Jobs
                _data = _line.split(" ", 2);

                jobs.add(CreateJob(_data));
            }

            _bufferedReader.close();
            return jobs;

        } catch (IOException | IOError e) {
            System.out.println(e.toString());
        }
        return null;
    }

    /* ---------- ---------- ---------- HELPER METHODS ---------- ---------- ---------- */

    private static Job CreateJob(String[] data) {

        if (data.length <= 0)
            return null;


        // We Know that the First element is the JobID
        int jobID = ToInteger(data[0]);

        // If the Second Elements First Character is a White Space, Then Remove it and re-split.
        if (Character.isSpaceChar(data[1].charAt(0))) {
            _line = data[1].replaceFirst(" ", "");
            data = _line.split(" ", 2);
        }

        // Otherwise, re-split the Second Element using a White Space.
        else {
            data = data[1].split(" ", 2);
        }


        int jobPriority = ToInteger(data[0]);
        String clientName = data[1];

        return new Job(jobID, jobPriority, clientName);
    }


    private static int ToInteger(String value) {
        return Integer.parseInt(value);
    }

}
