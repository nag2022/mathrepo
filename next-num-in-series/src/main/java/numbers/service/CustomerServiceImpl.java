package numbers.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import numbers.dao.CustomerDAO;
import numbers.entity.Customer;
import numbers.utils.MathCustomfunctions;


@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDAO customerDAO;
	
	@Autowired
	private MathCustomfunctions mathCustfunc;

	public static Double computeNextTerm=999.298;
	//public static boolean inSeries = true;
	
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		return customerDAO.getCustomers();
	}

	@Override
	@Transactional
	public void saveCustomer(Customer theCustomer) {
	
		customerDAO.saveCustomer(theCustomer);	
	}

	@Override
	@Transactional
	public Customer getCustomer(int theId) {

		return customerDAO.getCustomer(theId);
	}

	@Override
	@Transactional
	public void deleteCustomer(int theId) {
		
		customerDAO.deleteCustomer(theId);
	}

	public Double nextNumInSeries(int a, int b, int c, int d, int e, int f,int g) throws InterruptedException {

		int []  arr = {a,b,c,d,e,f,g};
		boolean inSeries = true;
		
		
//		class SharedVar {
//		    private Double nextTerm;
//		    private final Object lock = new Object();
//
//		    public void newMessage(Double x) {
//		        synchronized (lock) {
//		        	nextTerm = x;
//		        }
//		    }
//
//		    public Double getMessage() {
//		        synchronized (lock) {
//		            Double temp = nextTerm;
//		            nextTerm = null;
//		            return temp;
//		        }
//		    }
//		}
		
		/*
		Thread PowerseriesCheckThread = new Thread (new Runnable() {
		
			@Override
			public void run() {
		    int flag = 0;
		    boolean inSeries = true;
			int powerValue;
			int i=(int)Math.pow(arr[0],(float)2),j=2,k=0;
			int leng = arr.length;
			
			System.out.println("PowerSeries started");
			System.out.println("Power Series->Compute next term value="+computeNextTerm);
			System.out.println("Inside Power Series-> Stopthread INITIAL value="+arr[6]);			
			
			while (k< leng) {
				powerValue = (int) Math.pow(i, j);
				if (powerValue == arr[k]) {
					i++;
					k++;
					continue;
				} else if (powerValue > arr[i - 1]) {
					flag = 1;
					inSeries = false;
					break;
				} else {
					j++;
					i = (int)Math.pow(arr[0],(float)j);
					k=0;
					inSeries = true;
				}
			}
			if (flag==0) {
				computeNextTerm = (double) Math.pow(i, j);
				arr[6]=1;
			}	
			System.out.println("At the end inside PowerSeries-> Stopthread value="+arr[6]);			
			System.out.println("At the end inside PowerSeries-> Compute next term value="+computeNextTerm);
		}	
	});   
		*/
		Thread APseriesCheckThread = new Thread(new Runnable() {
			@Override
			public void run() {
		        //SharedVar sv1 = null;
				int firstTerm=arr[0];
				int diff=arr[1]-arr[0];
				int termInd;
				boolean inSeries = true;
				
				System.out.println("Ap started");
				System.out.println("AP->Compute next term value="+computeNextTerm);
				System.out.println("Inside AP -> Stopthread INITIAL value="+arr[6]);			
				for(termInd=2;termInd<=6;termInd++) {
					int termVal=firstTerm+(termInd-1)*diff;
					if (termVal != arr[termInd-1]) {
						//arr[6]=1;
						System.out.println("Inside AP Before break-> Stopthread value="+arr[6]);
						inSeries = false;
						break;
					}		
				}

				if (inSeries) {
					System.out.println("Calcualting ComputeNextTerm");

					computeNextTerm=(double) (firstTerm+(termInd-1)*diff);
					//sv1.newMessage(computeNextTerm);
					arr[6]=1;
				}
				System.out.println("At the end inside AP-> Stopthread value="+arr[6]);			
				System.out.println("At the end inside AP-> Compute next term value="+computeNextTerm);
				}  
		});
		
		Thread GPseriesCheckThread = new Thread(new Runnable() {
			@Override
			public void run() {
				int firstTerm=arr[0];
				int rdiff=arr[1]/arr[0];
				int termInd;
				boolean inSeries = true;
				
				System.out.println("Gp started");
				System.out.println("GP->Compute next term value="+computeNextTerm);
				System.out.println("Inside GP -> Stopthread INITIAL value="+arr[6]);
				for(termInd=2;termInd<=6;termInd++) {
					int termVal=(int) (firstTerm*(Math.pow(rdiff, termInd-1)));
					if (termVal != arr[termInd-1]) {
						//arr[6]=1;
						System.out.println("Inside GP Before break-> Stopthread value="+arr[6]);
						inSeries = false;
						break;
					}		
				}
				if (inSeries){
					System.out.println("Calcualting ComputeNextTerm");
					computeNextTerm=(Double)(firstTerm*(Math.pow(rdiff, termInd-1)));
					arr[6]=1;
				}
				System.out.println("At the end inside GP-> Stopthread value="+arr[6]);
				System.out.println("At the end inside GP-> Compute next term value="+computeNextTerm);
		     	}	
		});
		
		Thread FIBseriesCheckThread  = new Thread(new Runnable() {

			@Override
			public void run() {
				int termInd;
				boolean inSeries = true;
				System.out.println("FIB started");
				System.out.println("FIB->Compute next term value="+computeNextTerm);
				System.out.println("Inside FIB -> Stopthread INITIAL value="+arr[6]);
				for(termInd=3;termInd<=6;termInd++) {
					int termVal=arr[termInd-2]+arr[termInd-3];
					if (termVal != arr[termInd-1]) {
						//arr[6]=1;
						System.out.println("Inside FIB Before break-> Stopthread value="+arr[6]);
						inSeries=false;
						break;
					}		
				}
				if (inSeries){
					System.out.println("Calcualting ComputeNextTerm"); 
					computeNextTerm=(double) (arr[termInd-2]+arr[termInd-3]);
					arr[6]=1;
				}
				System.out.println("At the end inside FIB-> Stopthread value="+arr[6]);
				System.out.println("At the end inside FIB-> Compute next term value="+computeNextTerm);
			}
		});

		//PowerseriesCheckThread.start();
		APseriesCheckThread.start();
		GPseriesCheckThread.start();
		FIBseriesCheckThread.start();
		

		APseriesCheckThread.join();
		GPseriesCheckThread.join();
		FIBseriesCheckThread.join();
		//PowerseriesCheckThread.join();
		
//		if (arr[6]!=0)
//			return(computeNextTerm);
//		else
//			return 99999.0;

		if (computeNextTerm!=999.298) {
			Double temp=computeNextTerm;
			computeNextTerm=999.298;
			return(temp);
		}		
		else
			return 99999.0;

		/*if (!mathCustfunc.APseriesCheck(arrayNums).equalsIgnoreCase("SKIP")) //cond1
			return(Integer.valueOf(mathCustfunc.computeNextterm()));
		else
			if (!mathCustfunc.GPseriesCheck(arrayNums).equalsIgnoreCase("SKIP"))//cond2
				return(Integer.valueOf(mathCustfunc.computeNextterm()));
			else
				if (!mathCustfunc.ProgressiveGPseriesCheck(arrayNums).equalsIgnoreCase("SKIP"))
					return(Integer.valueOf(mathCustfunc.computeNextterm()));
				else
					if (!mathCustfunc.FIBseriesCheck(arrayNums).equalsIgnoreCase("SKIP"))
						return(Integer.valueOf(mathCustfunc.computeNextterm()));
					else
						if (!mathCustfunc.PRIMEseriesCheck(arrayNums).equalsIgnoreCase("SKIP"))//cond5
							return(Integer.valueOf(mathCustfunc.computeNextterm()));
						else
							if (!mathCustfunc.PowerseriesCheck(arrayNums).equalsIgnoreCase("SKIP"))
								return(Integer.valueOf(mathCustfunc.computeNextterm()));
							else
								return 0;*/
	}

}
