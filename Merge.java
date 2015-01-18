import java.util.*;
import java.io.*;

class Merge implements Runnable {
static int initArr[] = {0,1,5,7,9,13,17,19,23,2,4,8,11,12,21,22,24};
static int finArr[] = {0,1,5,7,9,13,17,19,23,2,4,8,11,12,21,22,24};
static int total=17;
int val,low,high;
static int n=16;

Merge(int val,int low,int high){
	this.val=val;
	this.low=low;
	this.high=high;
}

public static void main(String args[]) throws Exception{

Thread pro[] = new Thread[total];
for(int i=1;i<total;i++)
{
	if(i<=n/2)
	pro[i] = new Thread(new Merge(i,(n/2)+1,n));
	else
	pro[i] = new Thread( new Merge(i,1,n/2));
	
	pro[i].start();
}

for(int i=1;i<total;i++)
pro[i].join();

for(int i=1;i<total;i++)
System.out.print(" "+finArr[i]);

}

public void run(){
	int index;
	int x = initArr[val];
	do{
		index = (low+high)/2;
		
		if(x<initArr[index])
		high = index-1;
		else
		low = index+1;
	}while(low<=high);
	
	finArr[high+val-n/2] = x;
}

}