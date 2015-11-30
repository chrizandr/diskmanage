package diskmanage;
import java.util.ArrayList;
import java.util.List;

public class cscan {
	
	private static int start;
	private	static int num;
	private static int pos[];
	private static int del[];
	private static int mdata[];
	private static int input1[];
	private static int input2[];
	
	
	
	cscan(int n,int s,int a[],int b[])
	{
		num=n;
		start=s;
		input1=a;
		input2=b;
		pos=new int[200];
		del=new int[200];
		for(int i=0;i<200;i++)
		{
			pos[i]=-1;
			del[i]=1000000;
		}
	
	}
	
	public void simulate() {
		List<Integer> x = new ArrayList<Integer>();
		List<Integer> y = new ArrayList<Integer>();
				System.out.println("Enter "+num+" processes in the format: <Sector co-ordinate> <Request delay>:");
		int st=199,end=0;
		for(int i=0;i<num;i++) 
		{
			int a=input1[i];
			int b=input2[i];
			if(st>a)
				st=a;
			if(end<a)
				end=a;
			pos[a]=a;
			del[a]=b;
		}
		int curr=start;
		int direction=1;
		int t=0;
		int time=0;
		while(t!=num)
		{
			if(curr==200)
			{
				curr=0;
			}
			if(del[curr]<=time)
			{
				x.add(curr);
				y.add(curr);
				del[curr]=100000;
				t++;
			}
			else
			{
				x.add(curr);
				y.add(-1);
			}
			time++;
			curr=curr+direction;
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