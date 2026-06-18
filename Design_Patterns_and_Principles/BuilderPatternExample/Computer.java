package Design_Patterns_and_Principles.BuilderPatternExample;

public class Computer{

  String CPU;
  String RAM;
  String Storage;


  private Computer(Builder builder){
    this.CPU = builder.CPU;
    this.RAM = builder.RAM;
    this.Storage = builder.Storage;
  }

  public void showConfiguration(){
    System.out.println("CPU: " + CPU);
    System.out.println("RAM: " + RAM);
    System.out.println("Storage: " + Storage);
  
  }

  public static class Builder{
    private String CPU;
    private String RAM;
    private String Storage;

    public Builder setCPU(String CPU){
      this.CPU = CPU;
      return this;
    }

    public Builder setRAM(String RAM){
      this.RAM = RAM;
      return this;
    }

    public Builder setStorage(String Storage){
      this.Storage = Storage;
      return this;
    }

    public Computer build(){
      return new Computer(this);
    }
  }
}

