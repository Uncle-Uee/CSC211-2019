package Term2.Assignment_1;

public class Job {

    /* ---------- ---------- ---------- VARIABLES ---------- ---------- ----------  */

    private int _jobID = 0;
    private int _jobPriority = 0;
    private String _clientName = "";

    /* ---------- ---------- ---------- CONSTRUCTORS ---------- ---------- ----------  */

    public Job() {
    }

    public Job(int jobID, int jobPriority, String clientName) {
        this._jobID = jobID;
        this._jobPriority = jobPriority;
        this._clientName = clientName;
    }

    /* ---------- ---------- ---------- JOB METHODS ---------- ---------- ----------  */

    public String toString() {
        return this._jobID + " " + this._jobPriority + " " + this._clientName;
    }

    /* ---------- ---------- ---------- GETTERS AND SETTERS ---------- ---------- ----------  */

    public int getJobID() {
        return _jobID;
    }

    public void setJobID(int _jobID) {
        this._jobID = _jobID;
    }

    public int getJobPriority() {
        return _jobPriority;
    }

    public void setJobPriority(int _jobPriority) {
        this._jobPriority = _jobPriority;
    }

    public String getClientName() {
        return _clientName;
    }

    public void setClientName(String _clientName) {
        this._clientName = _clientName;
    }
}
