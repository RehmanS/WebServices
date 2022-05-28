package dao;

import java.util.List;
import model.Customer;

public interface CustomerDAO {
    List<Customer> getCustomerList() throws Exception;
    
    void addCustomer(Customer customer) throws Exception;

    Customer getCustomerById(Integer customerId) throws Exception;

    void updateCustomer(Customer customer) throws Exception;

    List<Customer> searchCustomerData(String keyword) throws Exception;
}
