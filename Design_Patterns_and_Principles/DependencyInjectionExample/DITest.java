package Design_Patterns_and_Principles.DependencyInjectionExample;

public class DITest {
  public static void main(String args[]){



    CustomerRepository repo =
        new CustomerRepositoryImpl();



    CustomerService service =
        new CustomerService(repo);



    service.getCustomer(1001);



}
}
