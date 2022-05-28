package webservice;

import dao.CustomerDAO;
import dao.CustomerDaoImpl;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import request.ReqCustomer;
import response.RespCustomer;
import response.RespCustomerList;
import response.RespStatusList;
import service.CustomerService;
import service.CustomerServiceImpl;

@Path("/customerWebservicev2")
public class CustomerWebService {

    CustomerDAO customerDAO = new CustomerDaoImpl();
    CustomerService customerService = new CustomerServiceImpl(customerDAO);

    @GET
    @Path("/getCustomerListv2")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public RespCustomerList getCustomerList() {
        return customerService.getCustomerList();
    }

    @GET
    @Path("/getCustomerById")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public RespCustomer getCustomerById(@QueryParam("customerId") Integer customerId) {
        return customerService.getCustomerById(customerId);
    }

    @POST
    @Path("/addCustomer")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public RespStatusList addCustomer(ReqCustomer reqCustomer) {
        return customerService.addCustomer(reqCustomer);
    }
    
    @PUT
    @Path("/updateCustomer")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public RespStatusList updateCustomer(ReqCustomer reqCustomer) {
        return customerService.updateCustomer(reqCustomer);
    }

}
