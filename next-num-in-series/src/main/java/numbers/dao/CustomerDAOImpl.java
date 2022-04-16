package numbers.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import numbers.entity.Customer;


@Repository
public class CustomerDAOImpl implements CustomerDAO {

	
	//need some dependency injection
	@Autowired
	//private SessionFactory sessionFactory;
	private SessionFactory sessionFactory;
	
	
	@Override
	public  List<Customer> getCustomers() {
		
		//get the current hibernate session
		Session currentSession=sessionFactory.getCurrentSession();
		
		//create a query
		Query<Customer> theQuery=currentSession.createQuery("from Customer order by lastName", Customer.class);
		
		//execute query and get result list
		List<Customer> customers=theQuery.getResultList();
		
		//return results
		return customers;
	}


	@Override
	public void saveCustomer(Customer theCustomer) {
	
		//get the current hibernate session
		Session currentSession=sessionFactory.getCurrentSession();
	
		//Save or update theCustomer record
		currentSession.saveOrUpdate(theCustomer);
	}


	@Override
	public Customer getCustomer(int theId) {

		//get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession(); 
		
		//now retrieve from the database using primary key
		Customer theCustomer=currentSession.get(Customer.class, theId);
		
		return theCustomer;
	}


	@Override
	public void deleteCustomer(int theId) {
		
		//get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession(); 
	
		Customer theCustomer=currentSession.get(Customer.class, theId);
		
		//now retrieve from the database using primary key
		currentSession.delete(theCustomer);
	}
}
