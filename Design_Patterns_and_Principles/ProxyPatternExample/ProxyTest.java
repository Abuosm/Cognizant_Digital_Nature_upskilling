package Design_Patterns_and_Principles.ProxyPatternExample;

public class ProxyTest {

    public static void main(String[] args) {

        Image image =
            new ProxyImage("profile.jpg");

        image.display();

        System.out.println();

        image.display();

    }

}