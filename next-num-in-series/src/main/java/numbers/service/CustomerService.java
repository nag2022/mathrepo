package numbers.service;

import java.util.List;

import numbers.entity.Customer;

import java.util.List;

public interface CustomerService {
	
	public List<Customer> getCustomers ();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int theId);

	public void deleteCustomer(int theId);
	
	public Double nextNumInSeries(int a, int b, int c, int d, int e, int f,int g) throws InterruptedException;

}
