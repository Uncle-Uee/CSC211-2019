package Term1.Practical_3;

public class TestSLL {
    public static void main(String[] args) {

        CSC211Registration CSC211 = new CSC211Registration();

        LinkedList<Integer> LL = new LinkedList<>();
        LL.AddHeadNode(3);
        LL.AddHeadNode(0);
        LL.AddHeadNode(2);
        LL.AddHeadNode(1);
        LL.AddHeadNode(0);
        LL.AddHeadNode(-1);
        LL.AddHeadNode(0);
        LL.AddHeadNode(-2);
        LL.AddHeadNode(0);

        LL.Display();
        LL.DeleteAllOccurrences(0);
        LL.Display();

        LL.ReplaceNodeAt(1, 0);
        LL.Display();

    }
}
