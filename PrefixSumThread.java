import java.io.*;
class PrefixSumThread implements Runnable
{	static	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static int n;
	static int sumAr[];
	static int sumAr2[];
	int index;
	static int j;
	
	PrefixSumThread(int index)
	{
		this.index=index;
	}
	public static void main(String ar[])throws Exception
	{	
		System.out.println("Enter the number of elements");
		n=Integer.parseInt(br.readLine());
		System.out.println("Enter the value for the elements");
		sumAr=new int[n];
		sumAr2=new int[n];
		
		
		for(int i=0;i<n;i++)
		{
			sumAr[i]=Integer.parseInt(br.readLine());
			sumAr2[i]=sumAr[i];
		}
		
		Thread threadAr[]=new Thread[n-1];
		
		for(j=0;j<=(int)Math.ceil(Math.log(n)/Math.log(2))-1;j++)
		{    
			for(int i=1;i<=n-1;i++)
			{	
			
			threadAr[i-1]=new Thread(new PrefixSumThread(i));
			
			threadAr[i-1].start();
			threadAr[i-1].sleep(10);
			}
			synchronized(sumAr)
			{	for(int k=0;k<n;k++)
				{System.out.print(sumAr2[k]+" ");
				sumAr[k]=sumAr2[k];}
				System.out.println();
			}
		}
			
	}
	public void run()
	{	
			synchronized(sumAr)
			{
			if((index-(int)Math.pow(2,j))>=0)
			{
				sumAr2[index]=sumAr[index]+sumAr[index-(int)Math.pow(2,j)];
				
			}
			
			}
		
		
	}
}
	