package Design_Patterns_and_Principles.FactoryMethodPatternExample;

public class WordFactory extends DocumentFactory{

  public Document createDocument() {
    return new WordDocument();
  }
  
}
