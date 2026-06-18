package Design_Patterns_and_Principles.DependencyInjectionExample;

public class CustomerRepositoryImpl implements CustomerRepository {
      public String findCustomerById(int id){

        return "Customer ID : " + id;

    }
}
