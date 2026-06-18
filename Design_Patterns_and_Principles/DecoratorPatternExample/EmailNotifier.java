package Design_Patterns_and_Principles.DecoratorPatternExample;

public class EmailNotifier implements Notifier {
  
  public void send(){
    System.out.println("Sending email notification...");
  }
  
}
