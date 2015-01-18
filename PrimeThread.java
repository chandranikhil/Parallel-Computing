import java.io.*;
import java.util.*;

class PrimeThread implements Runnable
{	static int value=4;
	int threadValue;
	static int ar[]=new int[101];
	static int count=0;
	
	PrimeThread(int num)
	{
		threadValue=num;
	}
	PrimeThread()
	{}
	
	public static void main(String args[])
	{	new PrimeThread().go();
		System.out.println("Prime numbers are:");
		for(int i=2;i<=100;i++)
		{	if(ar[i]!=-1)
			System.out.println(++count+": "+i);
		}
	}
	public void run()
	{ 
		boolean repeat=false;	
	  do{   System.out.println("ThreadValue:"+threadValue+" "+this);
	   	repeat=false;
		for(int i=(int)Math.pow(threadValue,2);i<=100;i+=threadValue)
		{	
			ar[i]=-1;
			
			try{Thread.sleep(10);}catch(Exception e){}
		}
		synchronized(this)
		{
		do
		{
			value++;
		   //System.out.println("here "+threadValue+" "+value+" ar[]"+ar[value]);
		}while((value)<=7 && ar[value]==-1);
		if(value<=7)
		{
			repeat=true;
			threadValue=value;
			
		}
		System.out.println("ThreadFinal:"+threadValue);
		}
	    }while(repeat);
	}
	public void go()
	{
		Thread t1=new Thread(new PrimeThread(2));
		Thread t2=new Thread(new PrimeThread(3));
		t1.start();
		t2.start();
		while(t1.isAlive() ||t2.isAlive()){}

	}
}