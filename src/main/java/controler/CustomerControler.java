package main.java.controler;

import main.java.dao.CustomerDAO;
import main.java.domain.Customer;

import java.util.ArrayList;

public class CustomerControler {

    public void getCustomers(ArrayList<Customer> lista) {
        CustomerDAO.getClientes(lista);
    }
    public Customer getCustomer(int id) {return(CustomerDAO.getCliente(id));}
}
