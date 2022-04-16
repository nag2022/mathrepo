package numbers.utils;

import org.springframework.stereotype.Service;

@Service
public class Customfunctions implements MathCustomfunctions {

	public static String computeNextTerm;
	public static String computeNextTerm1;
	public static String computeNextTerm2;
	
	public String ProgressiveGPseriesCheck(int[] arr) {
		int firstTerm=arr[0];
		int rdiff=2;
		int termInd,flag=0;
		computeNextTerm="";
		for(termInd=2;termInd<=6;termInd++) {
			int termVal=(int) (firstTerm*rdiff);
			if (termVal != arr[termInd-1])
				flag=1;
			rdiff++;
			firstTerm=arr[termInd-1];
		}		
		if (flag==0) 
			computeNextTerm+=((int) (firstTerm*rdiff));
		else
			computeNextTerm+="SKIP";
		return computeNextTerm;
	}

	public String PRIMEseriesCheck(int[] arr) {

		int i;
		computeNextTerm="";
		for(i=0;i<arr.length;i++) {
			if (checkPrime(arr[i]))
				continue;
			else {
				computeNextTerm = "SKIP";
				break;
			}	
		}
		int nextPrime=arr[i-1]+1;  // we have to take the maximum value here
		for (i=nextPrime;!computeNextTerm.contentEquals("SKIP");i++) {
			
			if (checkPrime(i)){
				computeNextTerm+=i;
				break;
			}
		}
		return computeNextTerm;
	}

	public boolean checkPrime(int num) {
		
		int bvalToCheck = (int) Math.sqrt(num);
		for(int i=2;i<bvalToCheck;i++)
            if(num%i==0) 
                return false;
        return true;
	}

	public String FIBseriesCheck(int[] arr) {
		int termInd,flag=0;
		computeNextTerm="";
		for(termInd=3;termInd<=6;termInd++) {
			int termVal=arr[termInd-2]+arr[termInd-3];
			if (termVal != arr[termInd-1])
				flag=1;
		}		
		if (flag==0) 
			computeNextTerm+=arr[termInd-2]+arr[termInd-3];
		else
			computeNextTerm+="SKIP";
		return computeNextTerm;
	}

	
	public String GPseriesCheck(int[] arr) {
		int firstTerm=arr[0];
		int rdiff=arr[1]/arr[0];
		int termInd,flag=0;
		computeNextTerm="";
		for(termInd=2;termInd<=6;termInd++) {
			int termVal=(int) (firstTerm*(Math.pow(rdiff, termInd-1)));
			if (termVal != arr[termInd-1])
				flag=1;
		}		
		if (flag==0) 
			computeNextTerm+=((int) (firstTerm*(Math.pow(rdiff, termInd-1))));
		else
			computeNextTerm+="SKIP";
		return computeNextTerm;
	}

	public String APseriesCheck(int[] arr) {
		
		int firstTerm=arr[0];
		int diff=arr[1]-arr[0];
		int termInd,flag=0;
		computeNextTerm="";
		for(termInd=2;termInd<=6;termInd++) {
			int termVal=firstTerm+(termInd-1)*diff;
			if (termVal != arr[termInd-1])
				flag=1;
		}		
		if (flag==0) 
			computeNextTerm+=(firstTerm+(termInd-1)*diff);
		else
			computeNextTerm+="SKIP";
		return computeNextTerm;
	}

	@Override
	public String PowerseriesCheck(int[] arr) {
	
		int flag = 0;
		int powerValue;
		int i=(int)Math.pow(arr[0],(float)1/2),j=2,k=0;
		int leng = arr.length;
		computeNextTerm="";
		while (k< leng) {
			powerValue = (int) Math.pow(i, j);
			if (powerValue == arr[k]) {
				i++;
				k++;
				continue;
			} else if (powerValue > arr[i - 1]) {
				flag = 1;
				break;
			} else {
				j++;
				i = (int)Math.pow(arr[0],(float)1/j);
				k=0;
			}
		}
		if (flag == 0)
			computeNextTerm += (int) Math.pow(i, j);
		else
			computeNextTerm += "SKIP";
		return computeNextTerm;
	}	

	@Override
	public String computeNextterm() {

		return computeNextTerm;
	}

	@Override
	public String computeNextterm1() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String computeNextterm2() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
