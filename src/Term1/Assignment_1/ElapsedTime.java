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

package Term1.Assignment_1;

/**
 * The Difference in Time Between Arrival and Departure Times.
 */
public class ElapsedTime {

    /* ---------- ---------- ---------- VARIABLES ---------- ---------- ----------  */

    /**
     * Time of Arrival.
     */
    private int _timeIn;

    /**
     * Time of Departure.
     */
    private int _timeOut;


    /* ---------- ---------- ---------- CONSTRUCTORS ---------- ---------- ----------  */

    /**
     * Default Constructor
     */
    public ElapsedTime() {
    }


    /**
     * Constructor with TimeIn and TimeOut Variables.
     *
     * @param timeIn  the Time of Arrival.
     * @param timeOut the Time of Departure.
     */
    public ElapsedTime(int timeIn, int timeOut) {
        this._timeIn = Math.abs(timeIn);
        this._timeOut = Math.abs(timeOut);
    }

    /* ---------- ---------- ---------- GETTERS AND SETTERS ---------- ---------- ----------  */

    public int getTimeIn() {
        return _timeIn;
    }

    public void setTimeIn(int _timeIn) {
        this._timeIn = Math.abs(_timeIn);
    }

    public int getTimeOut() {
        return _timeOut;
    }

    public void setTimeOut(int _timeOut) {
        this._timeOut = Math.abs(_timeOut);
    }
}
