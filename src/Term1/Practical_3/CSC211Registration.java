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

package Term1.Practical_3;

import DataStructures.LinkedList.LinkedList;
import DataStructures.Node.Node;

public class CSC211Registration extends LinkedList<Student> {

    /* ---------- ---------- ---------- CONSTRUCTORS ---------- ---------- ----------  */

    public CSC211Registration() {
    }

    public CSC211Registration(Node<Student> HEAD) {
        super(HEAD);
    }

    /* ---------- ---------- ---------- METHODS ---------- ---------- ----------  */
    public int Count_Class() {
        return Size();
    }

    public void Register_Student(Student student) {
        AddHeadNode(student);
    }

    public void Deregister_Student() {
        DeleteTailNode();
    }

    public void Deregister_Particular_Student(long studentNo) {
        if (isEmpty())
            return;

        if (this.HEAD.getData().getStudentNo() == studentNo)
            DeleteHeadNode();

        RESET();
        while (this.CURRENT != null) {
            if (this.CURRENT.getData().getStudentNo() == studentNo)
                DELETED();
            INCREMENT();
        }
    }
}
