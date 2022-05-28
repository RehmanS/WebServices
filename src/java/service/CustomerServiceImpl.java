package service;

import dao.CustomerDAO;
import exception.ExceptionConstants;
import exception.WebServicesException;
import java.util.ArrayList;
import java.util.List;
import model.Customer;
import request.ReqCustomer;
import response.RespCustomer;
import response.RespCustomerList;
import response.RespStatus;
import response.RespStatusList;

public class CustomerServiceImpl implements CustomerService {
    
    private CustomerDAO customerDAO;
    
    public CustomerServiceImpl(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
        
    }
    
    @Override
    public RespCustomerList getCustomerList() {
        RespCustomerList response = new RespCustomerList();
        List<RespCustomer> respCustomerList = new ArrayList<>();
        try {
            List<Customer> customerList = customerDAO.getCustomerList();
            if (customerList.isEmpty()) {
                throw new WebServicesException(ExceptionConstants.CUSTOMER_NOT_FOUND, "Customer not found");
            }
            for (Customer customer : customerList) {
                RespCustomer respCustomer = new RespCustomer();
                respCustomer.setId(customer.getId());
                respCustomer.setFirstName(customer.getFirstName());
                respCustomer.setLastName(customer.getLastName());
                respCustomer.setStreetNumber(customer.getStreetNumber());
                respCustomer.setStreetName(customer.getStreetName());
                respCustomer.setPostalCode(customer.getPostalCode());
                respCustomer.setCountry(customer.getCountry());
                respCustomer.setPhoneNumber(customer.getPhoneNumber());
                respCustomerList.add(respCustomer);
            }
            response.setRespCustomerList(respCustomerList);
            response.setStatus(RespStatus.getSuccessMessage());
        } catch (WebServicesException ex) {
            ex.printStackTrace();
            response.setStatus(new RespStatus(ex.getCode(), ex.getMessage()));
        } catch (Exception ex) {
            ex.printStackTrace();
            response.setStatus(new RespStatus(ExceptionConstants.INTERNAL_EXCEPTION, "Internal Exception"));
        }
        return response;
    }
    
    @Override
    public RespCustomer getCustomerById(Integer customerId) {
        RespCustomer response = new RespCustomer();
        try {
            if (customerId == null) {
                throw new WebServicesException(ExceptionConstants.INVALID_REQUEST_DATA, "Invalid request data");
            }
            Customer customer = customerDAO.getCustomerById(customerId);
            if (customer == null) {
                throw new WebServicesException(ExceptionConstants.CUSTOMER_NOT_FOUND, "Customer not found");
            }
            response.setId(customerId);
            response.setFirstName(customer.getFirstName());
            response.setLastName(customer.getLastName());
            response.setStreetNumber(customer.getStreetNumber());
            response.setStreetName(customer.getStreetName());
            response.setPostalCode(customer.getPostalCode());
            response.setCountry(customer.getCountry());
            response.setPhoneNumber(customer.getPhoneNumber());
            response.setStatus(RespStatus.getSuccessMessage());
        } catch (WebServicesException ex) {
            ex.printStackTrace();
            response.setStatus(new RespStatus(ex.getCode(), ex.getMessage()));
        } catch (Exception ex) {
            ex.printStackTrace();
            response.setStatus(new RespStatus(ExceptionConstants.INTERNAL_EXCEPTION, "Internal Exception"));
        }
        return response;
    }
    
    @Override
    public RespStatusList addCustomer(ReqCustomer reqCustomer) {
        RespStatusList response = new RespStatusList();
        try {
            Integer id = reqCustomer.getId();
            String firstName = reqCustomer.getFirstName();
            String lastName = reqCustomer.getLastName();
            String streetNumber = reqCustomer.getPhoneNumber();
            String streetName = reqCustomer.getStreetName();
            Integer postalCode = reqCustomer.getPostalCode();
            String country = reqCustomer.getCountry();
            String phoneNumber = reqCustomer.getPhoneNumber();
            if (firstName == null || lastName == null) {
                throw new WebServicesException(ExceptionConstants.INVALID_REQUEST_DATA, "Invalid request data");
            }
            Customer customer = new Customer();
            customer.setId(id);
            customer.setFirstName(firstName);
            customer.setLastName(lastName);
            customer.setStreetNumber(streetNumber);
            customer.setStreetName(streetName);
            customer.setPostalCode(postalCode);
            customer.setCountry(country);
            customer.setPhoneNumber(phoneNumber);
            customerDAO.addCustomer(customer);
            response.setStatus(RespStatus.getSuccessMessage());
        } catch (WebServicesException ex) {
            ex.printStackTrace();
            response.setStatus(new RespStatus(ex.getCode(), ex.getMessage()));
        } catch (Exception ex) {
            ex.printStackTrace();
            response.setStatus(new RespStatus(ExceptionConstants.INTERNAL_EXCEPTION, "Internal Exception"));
        }
        return response;
    }

    @Override
    public RespStatusList updateCustomer(ReqCustomer reqCustomer) {
        RespStatusList response = new RespStatusList();
        try {
            Integer id = reqCustomer.getId();
            String firstName = reqCustomer.getFirstName();
            String lastName = reqCustomer.getLastName();
            String streetNumber = reqCustomer.getPhoneNumber();
            String streetName = reqCustomer.getStreetName();
            Integer postalCode = reqCustomer.getPostalCode();
            String country = reqCustomer.getCountry();
            String phoneNumber = reqCustomer.getPhoneNumber();
            if (id==null || firstName == null || lastName == null) {
                throw new WebServicesException(ExceptionConstants.INVALID_REQUEST_DATA, "Invalid request data");
            }
            Customer customer = customerDAO.getCustomerById(id);
            if(customer==null){
                throw new WebServicesException(ExceptionConstants.CUSTOMER_NOT_FOUND, "Customer not found");
            }
            //customer.setId(id);
            customer.setFirstName(firstName);
            customer.setLastName(lastName);
            customer.setStreetNumber(streetNumber);
            customer.setStreetName(streetName);
            customer.setPostalCode(postalCode);
            customer.setCountry(country);
            customer.setPhoneNumber(phoneNumber);
            customerDAO.updateCustomer(customer);
            response.setStatus(RespStatus.getSuccessMessage());
        } catch (WebServicesException ex) {
            ex.printStackTrace();
            response.setStatus(new RespStatus(ex.getCode(), ex.getMessage()));
        } catch (Exception ex) {
            ex.printStackTrace();
            response.setStatus(new RespStatus(ExceptionConstants.INTERNAL_EXCEPTION, "Internal Exception"));
        }
        return response;
    }
    
}
