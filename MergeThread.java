import java.util.*;
import java.io.*;

class MergeThread implements Runnable
{
	static int initAr []={0,1,5,7,9,13,17,19,23,2,4,8,11,12,21,22,24};
	static int finalAr[]={0,1,5,7,9,13,17,19,23,2,4,8,11,12,21,22,24};
	static int n=17;
	int val,low,high;
	static boolean done[];
	MergeThread(int val,int low,int high)
	{
		this.val=val;
		this.low=low;
		this.high=high;
	}
	public static void main(String ar[])
	{	boolean over=false;
		done=new boolean[n];
		Thread threadAr[]=new Thread[n];
		for(int i=1;i<n;i++)
		{	done[i]=false;
			
			if(i<n/2)
			threadAr[i]=new Thread(new MergeThread(i,(n/2)-1,n));
			else
			threadAr[i]=new Thread(new MergeThread(i,1,(n/2)));
			
			threadAr[i].start();
		}
		
		while(!over)
		{	over=true;
			for(int i=1;i<=n-1;i++)
			{
			
				if(done[i]==false)
				{
				over=false;break;
				}
			}
		}
		for(int i=1;i<n;i++)
		{
			System.out.print(finalAr[i]+" ");
		}
	}

	public void run()
	{	int index=999;
		int x=initAr[val];
		do{
			index=(low+high)/2;
			if(x<initAr[index])
				high=index-1;
			else
				low=index+1;
			
		  }while(low<=high);
		int put=high+val-(n/2);
		
		finalAr[put]=x;
		done[val]=true;
	}
}
		