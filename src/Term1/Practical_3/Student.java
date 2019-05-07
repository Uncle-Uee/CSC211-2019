package Term1.Practical_3;

public class Student {

    /* ---------- ---------- ---------- VARIABLES ---------- ---------- ----------  */
    private String name;
    private String surname;
    private int age;
    private long studentNo;
    private double score;

    /* ---------- ---------- ---------- CONSTRUCTORS ---------- ---------- ----------  */
    public Student() {
    }

    /**
     * Create a new Student with a Name, Surname, Age, Student# and Score.
     * @param name
     * @param surname
     * @param age
     * @param studentNo
     * @param score
     */
    public Student(String name, String surname, int age, long studentNo, double score) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.studentNo = studentNo;
        this.score = score;
    }

    /* ---------- ---------- ---------- GETTERS AND SETTERS ---------- ---------- ----------  */

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(long studentNo) {
        this.studentNo = studentNo;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    /* ---------- ---------- ---------- TO STRING ---------- ---------- ----------  */
    public String toString() {
        return this.name + " " + this.surname + " " + this.age + " " + this.studentNo + " " + this.score;
    }
}
