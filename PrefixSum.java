import java.util.*;
import java.io.*;

class PrefixSum implements Runnable{
	static int arr[];
	static int total;
	static int numPro;
	int index;
	
	
	PrefixSum(int i){
		index =i;
	}
	
	public void run(){
		
		
	try{
		for(int j=0;j<=(int)(Math.ceil(Math.log(total)/Math.log(2)))-1;j++){
			System.out.println("Thread "+index+" running");
			if(index-(int)(Math.pow(2,j))>=0){
			arr[index] = arr[index]+arr[index-(int)(Math.pow(2,j))];
			}
			Thread.sleep(10);
					
		}
				
		
	}catch(Exception e){}
	
	}	
		
	
	public static void main(String args[]) throws Exception{
		System.out.println("Enter the number of elements-");
		Scanner obj =  new Scanner(System.in);
		total = obj.nextInt();
		arr = new int[total];
		
		System.out.println("Enter The elements");
		for(int i=0;i<total;i++){
			arr[i] = obj.nextInt();
		}
		
		//Thread initialisation
		numPro = total-1;
		Thread pro[] = new Thread[numPro+1];
		for(int i=1;i<=numPro;i++){
			pro[i] = new Thread(new PrefixSum(i));
			pro[i].start();
		}
		for(int i=1;i<=numPro;i++){
			pro[i].join();
		}
		for(int i=0;i<total;i++)
		System.out.print(" "+arr[i]);
	}
	

}	
			
			
			
		
		