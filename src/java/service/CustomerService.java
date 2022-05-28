package service;

import java.util.List;
import model.Customer;
import request.ReqCustomer;
import response.RespCustomer;
import response.RespCustomerList;
import response.RespStatusList;

public interface CustomerService {

    RespCustomerList getCustomerList();

    RespCustomer getCustomerById(Integer customerId);

    RespStatusList addCustomer(ReqCustomer reqCustomer);

    RespStatusList updateCustomer(ReqCustomer reqCustomer);

}
