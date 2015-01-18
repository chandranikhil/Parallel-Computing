import java.util.*;
import java.io.*;

class PrefixSeq implements Runnable{
	static int arr[];
	static int total;
	static int numPro;
	int index;
	
	PrefixSeq(int i){
		index =i;
	}
	
	public void run(){
		
		int z=(int)Math.ceil((Math.log(total)/Math.log(2)));
	try{
		for(int j=0 ; j<=z-1;j++){
			System.out.println("Thread "+index);
			if(( (index%(int)Math.pow(2,j))==0) && (2*index +(int)(Math.pow(2,j))<total)){
				arr[2*index] = arr[2*index] + arr[2*index +(int)Math.pow(2,j)];
				}
			Thread.sleep(5);
	
		}
	}catch(Exception e){}
	
	}		
	
	public static void main(String args[]) throws Exception{
		System.out.println("Enter the number of elements");
		Scanner obj =  new Scanner(System.in);
		total = obj.nextInt();
		arr = new int[total];
		System.out.println("Enter The elements");
		for(int i=0;i<total;i++){
			arr[i] = obj.nextInt();
		}
		
		//Thread initialisation
		numPro = (int)(Math.floor(total/2));
		Thread pro[] = new Thread[numPro];
		for(int i=0;i<=numPro-1;i++){
			pro[i] = new Thread(new PrefixSeq(i));
			pro[i].start();
		}
		for(int i=0;i<numPro;i++){
			pro[i].join();
		}
		
		System.out.println("The Sum is "+arr[0]);
	}
	

}	
			
			
			
		
		