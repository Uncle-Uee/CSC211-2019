package Term1.Practical_3;

public class TestSLL {
    public static void main(String[] args) {

        CSC211Registration CSC211 = new CSC211Registration();

        CSC211.Register_Student(new Student("Ubaid", "Effendi-Emjedi", 1, 3341897, 60.3f));
        System.out.println(CSC211.Count_Class());
        CSC211.Display();
    }
}
