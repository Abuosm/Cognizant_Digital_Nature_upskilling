package Design_Patterns_and_Principles.DecoratorPatternExample;

public class DecoratorTest {

    public static void main(String[] args) {

        Notifier notifier =
            new SlackNotifierDecorator(
                new SMSNotifierDecorator(
                    new EmailNotifier()
                )
            );

        notifier.send();

    }

}