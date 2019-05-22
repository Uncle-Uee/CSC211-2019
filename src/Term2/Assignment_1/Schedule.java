package Term2.Assignment_1;

import DataStructures.PriorityQueue.PriorityQueue;
import DataStructures.Queue.Queue;

import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 *
 * Following the Format,
 *                          0   <- Root
 *                        /   \
 *     Left Child  ->    0     0    <- Right Child
 *                     /  \   / \
 *                    0   0  0   0
 * The Heap is made Linear using an Array.
 *
 * By using the Formula's:
 *      (index - 1) / 2 -> Parent of Child
 *      2 * index + 1 -> Left Child
 *      2 * index + 2 -> Right Child
 *
 * You can Navigate the Linear Heap correctly as if it were a Non Linear Structure like a Tree.
 */
public class Schedule {

    /* ---------- ---------- ---------- VARIABLES ---------- ---------- ---------- */
    /**
     * Default Capacity of the Schedule.
     */
    public final int CAPACITY = 11;

    /**
     * Array List Representing the Schedule Heap (Max Heap).
     */
    private ArrayList<PriorityQueue<Job>> schedule;

    /* ---------- ---------- ---------- CONSTRUCTORS ---------- ---------- ---------- */

    public Schedule() {
        this.schedule = new ArrayList<>(CAPACITY);
    }

    public Schedule(int capacity) {
        this.schedule = new ArrayList<>(capacity);
    }

    /* ---------- ---------- ---------- SCHEDULE METHODS ---------- ---------- ---------- */

    /**
     * Return True if the Schedule contains no Priority Queue. Otherwise Return False.
     *
     * @return True or False.
     */
    public boolean isEmpty() {
        return this.schedule.isEmpty();
    }

    /**
     * Return the Total Number of Elements within the Schedule.
     *
     * @return 0 or a Value greater than 0
     */
    public int Size() {
        return this.schedule.size();
    }

    /**
     * Insert a new Job with a Job Priority into the Schedule by either creating a new Priority Queue or
     * appending the stated job to an already existing Priority Queue that has the same Job Priority.
     *
     * @param job - Then Job to Add to the Schedule.
     */
    public void InsertJob(Job job) {
        if (isEmpty()) {
            this.schedule.add(NewPriorityJob(job.getJobPriority(), job));
        } else {
            // Find and Check if the Schedule contains a Priority Queue with a matching Priority and return
            // the Index of where that Priority Queue is.
            int index = PriorityExists(job.getJobPriority());

            // If the Index value is >= 0, Then append/enqueue the new Job to the Queue.
            if (index >= 0) {
                AddJobToQueueAt(index, job);
            }
            // Otherwise, Create a new Priority Queue in the Schedule and Shift Up the Elements within the
            // Schedule.
            else {
                this.schedule.add(NewPriorityJob(job.getJobPriority(), job));
                ShiftUp();
            }
        }
    }

    /**
     * Delete the Root Priority Queue of the Schedule and Return it.
     *
     * @return Return the Root Priority Queue of the Schedule provided the Schedule is not Empty.
     * @throws NoSuchElementException
     */
    public PriorityQueue<Job> DeleteJob() throws NoSuchElementException {
        if (Size() == 0) {
            throw new NoSuchElementException("The Schedule Queue is Empty");
        }
        // If there is only 1 Job Left within the Schedule, Then Remove it.
        if (Size() == 1) {
            return RemovePriorityJobAt(0);
        }
        // Remove and store the Root Element in a temporary Variable.
        PriorityQueue<Job> deleted = GetPriorityJobAt(0);
        // Move the Last Element in the Schedule to the Root.
        this.schedule.set(0, RemovePriorityJobAt(Size() - 1));
        // Shift the Elements Down.
        ShiftDown();

        // Return the Deleted Priority Queue.
        return deleted;
    }

    /**
     * Shift the Elements within the Schedule up after Insertion.
     */
    private void ShiftUp() {
        int index = Size() - 1;
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            if (GetPriorityAt(index) > GetPriorityAt(parentIndex)) {
                Swap(index, parentIndex);
                index = parentIndex;
            } else
                break;
        }
    }

    /**
     * Shift the Elements within the Schedule down after Deleting the Root.
     */
    private void ShiftDown() {
        // Parent Index.
        int index = 0;
        // Left Child Index.
        int left = 2 * index + 1;

        while (left < Size()) {
            // Index of the Child Greater than the Parent.
            int maximum = left;
            // Right Child Index.
            // Right can also be defined as 2 * index + 2
            int right = left + 1;

            // If there is a right child
            if (right < Size()) {
                if (GetPriorityAt(right) > GetPriorityAt(left)) {
                    maximum++;
                }
            }
            if (GetPriorityAt(index) < GetPriorityAt(maximum)) {
                Swap(index, maximum);
                index = maximum;
                left = 2 * index + 1;
            } else {
                break;
            }
        }
    }

    /**
     * Clear a Job from the Queue of Jobs and Return True upon Completion.
     *
     * @param priorityJobs - Priority Queue of Jobs that needs to be Completed.
     * @return True upon Completing All the Jobs.
     */
    public boolean ClearJobsFromQueue(PriorityQueue<Job> priorityJobs) {
        if (priorityJobs.getQueue().isEmpty()) {
            System.out.println("\tJobs have been Completed.");
            return true;
        }
        System.out.println("\tDoing this Job -> " + priorityJobs.getQueue().Dequeue().toString());
        return ClearJobsFromQueue(priorityJobs);
    }

    /**
     * Display the Completed Schedule of Jobs with a Specific Job Priority starting at the Root that is
     * contains the Highest Priority of Jobs that need to be completed first. (Max Heap Representation)
     */
    public void DisplaySchedule() {
        for (int i = 0; i < Size(); i++) {
            JobQueueAt(i).Display();
        }
        System.out.println("\n");
    }

    /* ---------- ---------- ---------- HELPER METHODS ---------- ---------- ---------- */

    /**
     * Return the Job Queue within a Priority Queue.
     *
     * @param index - Index of the Priority Where the Job Queue can be Found.
     * @return A Queue of Jobs.
     */
    private Queue<Job> JobQueueAt(int index) {
        return this.schedule.get(index).getQueue();
    }

    private void AddJobToQueueAt(int index, Job job) {
        JobQueueAt(index).Enqueue(job, true);
    }

    private PriorityQueue<Job> NewPriorityJob(int priority, Job job) {
        return new PriorityQueue<>(priority, job);
    }

    private PriorityQueue<Job> RemovePriorityJobAt(int index) {
        return this.schedule.remove(index);
    }

    private PriorityQueue<Job> GetPriorityJobAt(int index) {
        return this.schedule.get(index);
    }

    private int GetPriorityAt(int index) {
        return this.schedule.get(index).getPriority();
    }

    private int PriorityExists(int priority) {
        for (int i = 0; i < Size(); i++) {
            if (this.schedule.get(i).getPriority() == priority)
                return i;
        }
        return -1;
    }

    private void Swap(int i, int j) {
        PriorityQueue<Job> temp = this.schedule.get(i);
        this.schedule.set(i, this.schedule.get(j));
        this.schedule.set(j, temp);
    }

}
