package artur.dudek.com.myDictionary.service;

import artur.dudek.com.myDictionary.dao.CustomerDao;
import artur.dudek.com.myDictionary.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * Created by admin on 12.11.2018.
 */
@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    private CustomerDao customerDao;

    @Override
    public List<Customer> findAll() {
        return (List<Customer>) customerDao.findAll();
    }

    @Override
    public void save(Customer theCustomer) {customerDao.save(theCustomer);
    }

    @Override
    public Optional<Customer> findCustomerById(Integer theId) {
        Optional<Customer> customer = customerDao.findById(theId);
        return customer;
    }

    public List<Customer> getCustometNativeQueryDudek(){
        return (List<Customer>) customerDao.getCustometNativeQueryDudek();
    }

    //
//    @Override
//    @Transactional
//    public void deleteCustomer(int theId) {
//        customerDao.deleteCustomer(theId);
//    }
//
//    @Override
//    @Transactional
//    public List<Customer> getCustomer(String theName) {
//        List<Customer> list = customerDao.getCustomer(theName);
//        return list;
//    }
}
