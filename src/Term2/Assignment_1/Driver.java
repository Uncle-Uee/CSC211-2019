package Term2.Assignment_1;

import java.util.ArrayList;

public class Driver {

    /* ---------- ---------- ---------- MAIN ---------- ---------- ---------- */

    public static void main(String[] args) {
        Schedule schedule = new Schedule();
        ArrayList<Job> jobs = FileIO.GetJobs("Jobs.txt");

        assert (jobs != null);

        for (int i = 0; i < jobs.size(); i++)
            schedule.InsertJob(jobs.get(i));

        System.out.println("\nComplete Job Schedule.\n");
        schedule.DisplaySchedule();


        int scheduleSize = schedule.Size();
        System.out.println("\nJobs Will now Be Completed.\n\n");

        for (int i = 0; i < scheduleSize; i++) {
            schedule.ClearJobsFromQueue(schedule.DeleteJob());

            System.out.println(schedule.Size() != 0 ? "\n\nThese Jobs are Remaining.\n" : "\n\nThere are No" +
                    " Jobs Left to Complete.\n");
            schedule.DisplaySchedule();
        }

    }

}
