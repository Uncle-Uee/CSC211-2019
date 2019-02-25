/*
  Created By : Uee
  Modified By :
  Thomas
  <p>
  This Source Code is released under the terms of the
  GNU license. See https://www.gnu.org/licenses/#GPL
  for more information.
  <p>
  Usage:   Do what you want, modify like you want.
  <p>
 */

package Term1.Assignment_1;

import java.util.*;

public class DistinctPairs {

    /* ---------- ---------- ---------- VARIABLES ---------- ---------- ----------  */

    /**
     * List of Patient Arrivals and Departures.
     */
    private ArrayList<ElapsedTime> _visitTimes;

    /* ---------- ---------- ---------- CONSTRUCTORS ---------- ---------- ----------  */

    /**
     * Default Constructor
     */
    public DistinctPairs() {
        this._visitTimes = new ArrayList<>();
    }

    /**
     * Constructor with ArrayList of Elapsed Time.
     *
     * @param visitTimes an ArrayList of Elapsed Time.
     */
    public DistinctPairs(ArrayList<ElapsedTime> visitTimes) {
        this._visitTimes = visitTimes;
    }


    /* ---------- ---------- ---------- METHODS ---------- ---------- ----------  */

    /**
     * Calculate how many Distinct Pairs of Patients were at the Vet at the Same Time.
     *
     * @return may return a set of pairs that were found.
     */
    public String CalculateDistinctPairs() {

        if (Size() == 0)
            return "No Pairs Found";

        StringBuilder pairs = new StringBuilder("{");
        for (int i = 0; i < Size() - 1; i++) {
            for (int j = i + 1; j < Size(); j++) {
                if (TimeOut(i) >= TimeIn(j) && TimeOut(j) > TimeIn(i)) {
                    pairs.append("(").append(i + 1).append(", ").append(j + 1).append("), ");
                }
            }
        }

        return pairs.length() > 1 ? pairs.substring(0, pairs.length() - 2) + "}" : "No Pairs Found";
    }

    /* ---------- ---------- ---------- GETTERS AND SETTERS ---------- ---------- ----------  */

    public ArrayList<ElapsedTime> getVisitTimes() {
        return this._visitTimes;
    }

    public void setVisitTimes(ArrayList<ElapsedTime> _visitTimes) {
        this._visitTimes = _visitTimes;
    }

    /* ---------- ---------- ---------- HELPERS ---------- ---------- ----------  */

    /**
     * How many Elements are in the Visit Times ArrayList.
     *
     * @return the Total Number of elements.
     */
    private int Size() {
        return this._visitTimes != null ? this._visitTimes.size() : 0;
    }


    /**
     * The Arrival Time of a Patient.
     *
     * @param index is the Position of Element to Get in the VisitTimes ArrayList
     * @return the Arrival Time of a Patient.
     */
    private int TimeIn(int index) {
        return this._visitTimes.get(index).getTimeIn();
    }

    /**
     * The Departure Time of a Patient.
     *
     * @param index is the Position of Element to Get in the VisitTimes ArrayList
     * @return the Departure Time of a Patient.
     */
    private int TimeOut(int index) {
        return this._visitTimes.get(index).getTimeOut();
    }

    /* ---------- ---------- ---------- MAIN METHOD ---------- ---------- ----------  */

    public static void main(String[] args) {

        ArrayList<ElapsedTime> visitTimes = new ArrayList<>();

        visitTimes.add(new ElapsedTime(2, 5));
        visitTimes.add(new ElapsedTime(3, 6));
        visitTimes.add(new ElapsedTime(8, 9));
        visitTimes.add(new ElapsedTime(10, 11));
        visitTimes.add(new ElapsedTime(7, 11));
        visitTimes.add(new ElapsedTime(1, 4));
        visitTimes.add(new ElapsedTime(1, 2));

        DistinctPairs DP = new DistinctPairs(visitTimes);

        System.out.println(DP.CalculateDistinctPairs());


    }

}
