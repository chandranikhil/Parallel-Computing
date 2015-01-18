import java.util.*;
import java.io.*;

class GraphColor implements Runnable{
	static int n=3;
	static int c=2;
	static int adj[][] = {{0,1,1},{1,0,0},{1,0,0}};
	
	static int valid=0;
	static int candidate[][] = {{0,0,0},{0,0,1},{0,1,0},{0,1,1},{1,0,0},{1,0,1},{1,1,0},{1,1,1}};
	static int can[] =  new int[8];
	int index;
	
	GraphColor(int val){
	this.index = val;
	}
		
	public void run(){
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				if((adj[i][j]==1) && candidate[index][i]==candidate[index][j])
				can[index]=0;
			}
		}
	}
					
		
	
	public static void main(String args[]) throws Exception{
		
		
		Thread pro[] =  new Thread[8];
		for(int i=0;i<8;i++)
		can[i]=1;
		
		for(int i=0;i<8;i++)
		{
			pro[i] = new Thread(new GraphColor(i));
			pro[i].start();
		}
		
		for(int i=0;i<8;i++)
		pro[i].join();
		
		for(int i=0;i<8;i++)
		{
			if(can[i]==1)
			valid++;
		}
		System.out.println("The num of valid color are "+valid);
		
		
	}
	}
		