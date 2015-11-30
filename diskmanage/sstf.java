package diskmanage;
import java.util.ArrayList;
import java.util.List;

public class sstf {
	
	private static int start;
	private	static int num;
	private static int pos[];
	private static int del[];
	private static int mdata[];
	private static int input1[];
	private static int input2[];
	
	
	sstf(int n,int s,int a[],int b[])
	{
		num=n;
		start=s;
		input1=a;
		input2=b;
		pos=new int[200];
		del=new int[200];
		
	}
	private int nextindex(int n,int t)
	{
		int min=300;
		int k=0;
		int flag=1;
		for(int i=0;i<num;i++)
		{
			if(del[i]<=t&&del[i]!=-1)
			{  
				flag=0;
				if(abs(n-pos[i])<min)
				{
					min=abs(n-pos[i]);
					k=i;
				}
			}
		}
		if(flag==1)
			return -1;
		return pos[k];
	}
	private int abs(int i) {
		// TODO Auto-generated method stub
		if(i>=0)
			return i;
		return -1*i;
	}
	private int findindex(int n)
	{
		for(int i=0;i<num;i++)
		{
			if(pos[i]==n)
			{
				return i;
			}
		}
		return -1;
	}
	public void simulate() {
		List<Integer> x = new ArrayList<Integer>();
		List<Integer> y = new ArrayList<Integer>();
		System.out.println("Enter "+num+" processes in the format: <Sector co-ordinate> <Request delay>:");
		for(int i=0;i<num;i++) 
		{
			int a=input1[i];
			int b=input2[i];
			pos[i]=a;
			del[i]=b;
		}
		int curr=start;
		int direction=0;
		int time=0;
		int next=nextindex(curr,time);
		System.out.println(curr+"->"+next);
		if(next<curr)
		{
			direction=-1;
		}
		if(next>curr)
		{
			direction=1;
		}
		System.out.println(curr);
		int t=0;
		
		while(t!=num)
		{
			if(next==-1){
				time++;
				x.add(curr);
				y.add(-1);
				next=nextindex(curr,time);
				if(next<curr)
				{
					direction=-1;
				}
				if(next>curr)
				{
					direction=1;
				}
			}
			else{
				if(next==curr)
				{
					t++;
					System.out.println("At "+ curr);
					int m=findindex(curr);
					del[m]=-1;
					x.add(curr);
					y.add(curr);
					next=nextindex(curr,time);
					System.out.println(curr+"->"+next);
					if(next<curr)
					{
						direction=-1;
					}
					if(next>curr)
					{
						direction=1;
					}
				}
				else{
					x.add(curr);
					y.add(-1);
				}
				time++;
				curr=curr+direction;
			}
		}
		
		int[] data=new int[x.size()];
		mdata = new int [y.size()];
		for(int i=0;i<x.size();i++)
		{
			data[i]=x.get(i);
			mdata[i]=y.get(i);
			System.out.println(data[i]+" : "+mdata[i]);
		}
		marker(data,mdata);
		return;
	}
	public void marker(int m[],int u[])
	{
		GraphingData g=new GraphingData();
		g.getvalues(m,u);
		g.plot();
	}
}