package diskmanage;
import java.util.ArrayList;
import java.util.List;

public class fcfs {
	
	private static int start;
	private	static int num;
	private static int pos[];
	private static int mdata[];
	private static int input1[];
	
	
	fcfs(int n,int s,int a[])
	{
		num=n;
		start=s;
		input1=a;
		pos=new int[200];
		for(int i=0;i<200;i++)
		{
			pos[i]=-1;
		}
	}
	
	public void simulate() {
		List<Integer> x = new ArrayList<Integer>();
		List<Integer> y = new ArrayList<Integer>();
				System.out.println("Enter "+num+" processes in the format: <Sector co-ordinate> :");
		
		for(int i=0;i<num;i++) 
		{
			int a=input1[i];
			pos[i]=a;
		}
		int curr=start;
		int direction=1;
		int next=0;
		while(next!=num)
		{
			if(pos[next]<curr)
			{
				direction=-1;
			}
			if(pos[next]>curr)
			{
				direction=1;
			}
			if(pos[next]==curr)
			{
				next++;
				x.add(curr);
				y.add(curr);
			}
			else{

				x.add(curr);
				y.add(-1);
			}
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