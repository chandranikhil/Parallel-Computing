import java.util.*;
import java.io.*;

class EnumSort implements Runnable {
	
	static int n = 5;
	static int a[] = {1,2,3,4,5};
	static int position[] = {0,0,0,0,0};
	static int sorted[];
	static int numPro;
	static boolean first[]= {true,true,true,true,true};
	int i,j;
		
	EnumSort(int i,int j){
		this.i = i;
		this.j = j;
	}
	
	
	public void run(){
		synchronized(this){
				
		if((a[i]<a[j])||((a[i]==a[j])&&(i<j)))
			increment(i);
		
		System.out.println("Thread "+ i+","+j+" running");
		/*try{
		Thread.sleep(5);}
		catch(Exception e){}*/
	}
	}
	
	void increment(int i){
		if(first[i]){
			position[i]=1;
			first[i]=false;
		}
		else{
		position[i] = position[i]+1;
		}
	}		
	
	public static void main(String args[]) throws Exception{
		position = new int[n];
		sorted = new int[n];
		numPro = n*n;

		
		Thread pro[]= new Thread[numPro];
		int count=0;
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				pro[count] = new Thread(new EnumSort(i,j));
				pro[count].start();
				count++;
			}
		}
		
		count=0;		
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				pro[count++].join();
			}
		}
		
		for(int i=0;i<n;i++)
		sorted[position[i]]=a[i];
		
		for(int i=0;i<n;i++)
		System.out.print(position[i]);
		
		System.out.println("\n");
		for(int i=0;i<n;i++){
			System.out.print(sorted[i]);
		}
			
		
	}
}
	
	