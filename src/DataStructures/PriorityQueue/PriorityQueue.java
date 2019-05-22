package DataStructures.PriorityQueue;

import DataStructures.Queue.Queue;

public class PriorityQueue<T> {

    /* ---------- ---------- ---------- VARIABLES ---------- ---------- ----------  */

    /**
     * Priority of the Element.
     */
    private int _priority = -1;

    /**
     * Queue of Items with the Same Priority.
     */
    private Queue<T> _queue = new Queue<>();

    /* ---------- ---------- ---------- CONSTRUCTORS ---------- ---------- ----------  */

    public PriorityQueue() {
    }

    public PriorityQueue(int priority, T item) {
        this._priority = priority;
        this._queue.Enqueue(item);
    }

    /* ---------- ---------- ---------- GETTERS AND SETTERS ---------- ---------- ----------  */

    public int getPriority() {
        return _priority;
    }

    public void setPriority(int priority) {
        this._priority = priority;
    }

    public Queue<T> getQueue() {
        return _queue;
    }

    public void setQueue(Queue<T> stack) {
        this._queue = stack;
    }
}
