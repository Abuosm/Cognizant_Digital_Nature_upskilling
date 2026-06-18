package Design_Patterns_and_Principles.DecoratorPatternExample;

public class SMSNotifierDecorator extends NotifierDecorator {

    public SMSNotifierDecorator(Notifier notifier) {

        super(notifier);

    }

    public void send() {

        super.send();

        System.out.println("SMS Notification Sent");

    }

}