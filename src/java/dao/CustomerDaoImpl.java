package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Customer;

public class CustomerDaoImpl implements CustomerDAO {

    @Override
    public List<Customer> getCustomerList() throws Exception {
        List<Customer> customerList = new ArrayList<Customer>();
        String query = "select * from customer";
        try (Connection c = DBHelper.getConnection();
                PreparedStatement ps = c.prepareStatement(query);
                ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Customer cc = new Customer();
                cc.setId(rs.getInt("id"));
                cc.setFirstName(rs.getString("firstname"));
                cc.setLastName(rs.getString("lastname"));
                cc.setStreetNumber(rs.getString("streetnumber"));
                cc.setStreetName(rs.getString("streetname"));
                cc.setPostalCode(rs.getInt("postalcode"));
                cc.setCountry(rs.getString("country"));
                cc.setPhoneNumber(rs.getString("phonenumber"));
                customerList.add(cc);
            }
        }
        return customerList;
    }

    @Override
    public void addCustomer(Customer customer) throws Exception {
        String query = "INSERT INTO CUSTOMER(id,firstname,lastname,streetnumber,streetname,postalcode,country,phonenumber)"
                + "VALUES(?,?,?,?,?,?,?,?)";
        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(query)) {
            ps.setInt(1, customer.getId());
            ps.setString(2, customer.getFirstName());
            ps.setString(3, customer.getLastName());
            ps.setString(4, customer.getStreetNumber());
            ps.setString(5, customer.getStreetName());
            ps.setInt(6, customer.getPostalCode());
            ps.setString(7, customer.getCountry());
            ps.setString(8, customer.getPhoneNumber());
            ps.execute();
        }
    }

    @Override
    public Customer getCustomerById(Integer customerId) throws Exception {

        Customer customer = new Customer();
        String query = "SELECT * FROM CUSTOMER WHERE id = ?";
        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(query)) {
            ps.setInt(1, customerId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                customer.setId(rs.getInt("id"));
                customer.setFirstName(rs.getString("firstname"));
                customer.setLastName(rs.getString("lastname"));
                customer.setPhoneNumber(rs.getString("phonenumber"));
                customer.setStreetNumber(rs.getString("streetnumber"));
                customer.setStreetName(rs.getString("streetname"));
                customer.setPostalCode(rs.getInt("postalcode"));
                customer.setCountry(rs.getString("country"));

            } else {
                customer = null;
            }
        }
        return customer;
    }

    @Override
    public void updateCustomer(Customer customer) throws Exception {
        String query = "UPDATE CUSTOMER SET firstname=?,lastname=?,streetnumber=?,streetname=?,postalcode=?,country=?,phonenumber=? where id=?";
                
        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(query);) {
            ps.setString(1, customer.getFirstName());
            ps.setString(2, customer.getLastName());
            ps.setString(3, customer.getStreetNumber());
            ps.setString(4, customer.getStreetName());
            ps.setInt(5, customer.getPostalCode());
            ps.setString(6, customer.getCountry());
            ps.setString(7, customer.getPhoneNumber());
            ps.setInt(8, customer.getId());
            ps.executeUpdate();
        }
    }

    @Override
    public List<Customer> searchCustomerData(String keyword) throws Exception {
        List<Customer> customerList = new ArrayList<Customer>();
        String query = "SELECT * FROM CUSTOMER WHERE FIRST_NAME LIKE ? OR LAST_NAME LIKE ?";
        try (Connection c = DBHelper.getConnection();
                PreparedStatement ps = c.prepareStatement(query);) {
            ps.setString(1, "%" + keyword + "%");
            ps.setString(2, "%" + keyword + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Customer cc = new Customer();
                cc.setId(rs.getInt("CUSTOMER_ID"));
                cc.setFirstName(rs.getString("FIRST_NAME"));
                cc.setLastName(rs.getString("LAST_NAME"));
                customerList.add(cc);
            }
        }
        return customerList;
    }

}
