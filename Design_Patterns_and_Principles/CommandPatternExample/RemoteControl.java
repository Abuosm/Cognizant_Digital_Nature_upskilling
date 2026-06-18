package Design_Patterns_and_Principles.CommandPatternExample;

public class RemoteControl {
  private Command command;



    public void setCommand(Command command){

        this.command = command;

    }



    public void pressButton(){

        command.execute();

    }

}