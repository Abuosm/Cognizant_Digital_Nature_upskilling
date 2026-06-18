package Design_Patterns_and_Principles.DecoratorPatternExample;

public class SlackNotifierDecorator extends NotifierDecorator {

    public SlackNotifierDecorator(Notifier notifier) {

        super(notifier);

    }

    public void send() {
         
        super.send();

        System.out.println("Slack Notification Sent");

    }

}