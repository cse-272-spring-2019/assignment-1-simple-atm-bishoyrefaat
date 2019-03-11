


public class atm implements AtmInterface {
	
	private double balance = 0;
	private double history[]={0,0,0,0,0,0};
	private String historyStatment ;
	
	

@Override
public Boolean CardValidator(String cardNumber) {
		String str="12345";
		if(cardNumber.equals(str))
			return true;
			else return false;
	}
	
	
	
	
	
	@Override
	public int deposit(Double value) {
		if(value<=0)
			return 0;
		else {
			balance+=value;
		for(int i=5;i>0;i--) {
			history[i]=history[i-1];
			}
		history[0]=balance;
		return 1;
		}}
	

	@Override
	public int withdraw(Double value) {
		if(balance>=value) {
		balance-=value;
		for(int i=5;i>0;i--) {
			history[i]=history[i-1];
			}
		history[0]=balance;
		return 1;
		}else
			return 0;
}

	@Override
	public double balanceinquiry() {
		return balance;
}

	@Override
	public String history(int x) {
		if(x<=5&&x>0) {
			if(history[x]<history[x-1]) {
				
		historyStatment="previous balance= "+history[x]+"  before a deposit of  "+(history[x-1]-history[x]) +"  was made ";
	   
			return historyStatment;}
	    
	    else if(history[x]>history[x-1]) {
	    	historyStatment="previous balance= "+history[x]+"  before a withdraw of  "+(history[x]-history[x-1]) +"  was made";
	    
	     return historyStatment; 
	     }
	   
	}
		return null;
	}
}
