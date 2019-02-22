package artur.dudek.com.myDictionary.service;

import artur.dudek.com.myDictionary.entity.Customer;
import java.util.List;
import java.util.Optional;

public interface CustomerService {
    public List<Customer> findAll();
    void save(Customer theCustomer);
    Optional<Customer> findCustomerById(Integer theId);

    public List<Customer> getCustometNativeQueryDudek();
//    void deleteCustomer(int theId);
//    List<Customer> getCustomer(String theName);
}
