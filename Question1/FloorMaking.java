package com.greatlearning.Assignment3.BstToSkewed;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class FloorMaking{
	static int count=1;
	public static void main(String arg[])

	{

		Queue<Integer> q1=new LinkedList<Integer>();

		Stack<Integer> s1=new Stack<Integer>();
		System.out.println("Enter the number of floors in the building");
		Scanner sc=new Scanner(System.in);
		int floor =sc.nextInt();

		for(int j=1;j<=floor;j++)
		{
			System.out.println("Enter the floor size given on day :"+j);
			q1.add(sc.nextInt());

		}
		int max=floor,i=0;

		System.out.println(q1);


		while(i<=max && max>0)
		{
			if(q1.peek()!=max) 
			{
				s1.push(q1.poll());
				System.out.println("Day "+count+" :");
				if(q1.isEmpty())
				{
					System.out.println("  "+s1.peek());
					s1.pop();
					
				}
				count=count+1;



			}
			else if(q1.peek()==max)
			{


				if(q1.peek()==max && s1.isEmpty())
				{
					q1.poll();

					System.out.println("Day" +count+" : "+ max );
					count=count+1;
					max=max-1;

				}
				else if (q1.peek()==max && s1.peek()==(max-1))
				{
					q1.poll();

					System.out.println("Day " +count+ "  : "+ max +" "+ s1.peek());
					s1.pop();
					
					
					if(q1.peek()==max && s1.peek()==max)
					{
						System.out.print(" " + s1.peek());
						s1.pop();
					}
					if(q1.isEmpty())
					{
						System.out.println("  "+s1.peek());
						s1.pop();
						
					}
					count=count+1;
					max=max-1;

				}
				else if (q1.peek()==max && s1.peek()!= max)
				{


					int value=s1.indexOf(max-1, 0);
					if(value==-1)
					{
						q1.poll();


						System.out.println("Day " +count+ "  : "+ max +" ");
						count=count+1;
						max=max-1;


					}
					else
					{
						System.out.print("Day " +count+ "  : "+ max +" "+ (max-1));

						s1.remove(value);
						count=count+1;
						max=max-1;
						System.out.println(s1);
						System.out.println(q1);
					}
					}
				else 
				{
					q1.poll();
					if(q1.isEmpty())

					{
						System.out.print("Day " +count+ "  : "+ max + " ");
						for(int j=1;j<max;j++)
						{
							System.out.print(" " + (max-j)+" ");
						}
					}

				}
			}


			i++;
		}

		sc.close();
	}

}