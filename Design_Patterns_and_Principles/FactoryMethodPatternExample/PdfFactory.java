package Design_Patterns_and_Principles.FactoryMethodPatternExample;

public class PdfFactory extends DocumentFactory {

    public Document createDocument() {

        return new PdfDocument();

    }

}