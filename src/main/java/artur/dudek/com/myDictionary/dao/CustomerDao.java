package artur.dudek.com.myDictionary.dao;

import artur.dudek.com.myDictionary.entity.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerDao extends CrudRepository <Customer , Integer> {

    /*
    Nie trzeba dzięki extends CrudRepository

    public List<Customer> findAll();
    void save(Customer customer);
    Customer getCustomer(int theId);
    void deleteCustomer(int theId);
    List<Customer> getCustomer(String theName);
    */


    // nowe możliwości:
    @Query(value = "select * from customer where id=:theId", nativeQuery = true)
    public List<Customer> getCustometNativeQuery(@Param("theId") int theId);

    @Query(value = "select * from customer where upper(last_name) like '%DUDEK%'", nativeQuery = true)
    public List<Customer> getCustometNativeQueryDudek();
}
