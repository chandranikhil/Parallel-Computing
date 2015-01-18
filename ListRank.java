import java.util.*;
import java.io.*;

class ListRank implements Runnable{
	static int next[];
	static int position[];
	static int numPro;
	int index;
	
	ListRank(int i){
		index =i;
	}
	
	public void run(){
		
		
	try{
		for(int j=1;j<=(int)Math.ceil(Math.log(numPro)/Math.log(2));j++){
			System.out.println("Thread "+index+" running");
			position[index] = position[index]+position[next[index]];
			next[index]=next[next[index]];
			Thread.sleep(5);	
		}
	}catch(Exception e){}
	
	}
		
		
	
	public static void main(String args[]) throws Exception{
	
		System.out.println("Enter the number of nodes in the list-");
		Scanner obj = new Scanner(System.in);
		numPro=obj.nextInt();
		
		next = new int[numPro];
		position = new int[numPro];
		
		//initialise next array
		for(int i=0;i<numPro-1;i++)
		next[i]=i+1;
		next[numPro-1]=numPro-1;
			
		//initialise position array
		for(int i=0;i<numPro;i++){
			if(next[i]==i)
			position[i]=0;
			else
			position[i]=1;
		}
					
		//Thread initialisation
		Thread pro[] = new Thread[numPro];
		for(int i=0;i<numPro;i++){
			pro[i] = new Thread(new ListRank(i));
			pro[i].start();
		}
		for(int i=0;i<numPro;i++){
			pro[i].join();
		}
		System.out.println("The List Ranking is ");
		//output
		for(int i=0;i<numPro;i++)
		System.out.print(position[i]+" ");
	}
	

}	
			
			
			
		
		