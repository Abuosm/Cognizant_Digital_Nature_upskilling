package Design_Patterns_and_Principles.MVCPatternExample;

public class MVCTest {
  public static void main(String args[]){


    Student student =
        new Student(
            101,
            "John",
            "A"
        );


    StudentView view =
        new StudentView();



    StudentController controller =
        new StudentController(
            student,
            view
        );



    controller.updateView();



    controller.setStudentName("Ali");

    controller.setStudentGrade("A+");



    controller.updateView();


}
}
