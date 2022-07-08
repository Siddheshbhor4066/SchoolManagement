package com.school;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	
	static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
	static ArrayList<Teacher> teachers=new ArrayList<Teacher>();
	static ArrayList<Student> students=new ArrayList<Student>();
	
	static Teacher teacher,tempTeacher;
	static Student student,tempStudent;
	Main()
	{

		teachers.add(new Teacher(101,"JK", 60000));
		teachers.add(new Teacher(102,"MK", 50000));
		students.add(new Student(1001,"SB",7));
		students.add(new Student(1002,"SJ", 6));
	}

	
	synchronized public static boolean Adminlogin() throws NumberFormatException, IOException
	{
		
		System.out.println("Enter UserID:");
		long AdminId=Integer.parseInt(br.readLine());
		System.out.println("Enter Password:");
		String password=br.readLine();
		if(AdminId==123 &&   password.equals("Admin"))
			return true;
		else
			return false;
	}
	
	static int adminDashboard()
	{
		System.out.println("====================================================================");
		System.out.println("                     Administrator Portal");
		int choice = 0;
		do
		{
			try {
			System.out.println("====================================================================");
			System.out.println("Dashbord:");
			System.out.println("\t\t 1)Manage Teacher.\r\n"
					+ "\t\t 2)Manage Student.\r\n"
					+ "\t\t 3)Display Data\r\n"
					+ "\t\t 4)Logout.");
			System.out.println("====================================================================");
			System.out.println("Enter your choice:");
			choice=Integer.parseInt(br.readLine());
			
			switch(choice)
			{
				case 1: 
						ManageTeacher();
					    break;
				case 2:
						ManageStudent();
						break;
				case 3:
						Display();
						break;
				case 4:
						break;
			    default:
			    	throw new Exception("Wrong choice!!"); 		   
			}
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}while(choice!=4);
			
		System.out.println("====================================================================");
		System.out.println("Bye...");
		System.out.println("====================================================================");
		return 0;
	}
	//
	public static int ManageTeacher()
	{
		int choice = 0;
		do {
		try {
			System.out.println("====================================================================");
			System.out.println("Menu:");
			System.out.println("\t\t 1)Add Teacher.\r\n"
					+ "\t\t 2)Search Teacher.\r\n"
					+ "\t\t 3)Pay Salary.\r\n"
					+ "\t\t 4)Return back.");
			System.out.println("====================================================================");
			System.out.println("Enter your choice:");
			choice=Integer.parseInt(br.readLine());
			
			switch(choice)
			{
				case 1: 
						AddTeacher();
					    break;
				case 2:
						searchTeacher();
						break;
				case 3:
						System.out.println("Enter The Data You Want To search(Name Or ID)");
						System.out.println("\tPlease Enter Your Required Data:");
						String value=br.readLine();
						int flag=0;
						for(Teacher temp:teachers)
						{
							if(temp.getName().equals(value) || temp.getId()==Integer.parseInt(value))
							{   
								tempTeacher=temp;
								flag=1;
							}
						}
						if(flag == 1)
						{
							tempTeacher.receiveSalary(tempTeacher.getSalary());
						}
						else
							System.out.println("SORRY...! Data Not Found\n");
				    
						break;
				case 4:
						break;
			    default:
			    	throw new Exception("Wrong choice!!"); 		   
			
			}
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}while(choice!=4);
		return 0;
	}

	//
	public static int ManageStudent()
	{
		int choice=0;
		do {
		try {
			System.out.println("====================================================================");
			System.out.println("Menu:");
			System.out.println("\t\t 1)Add Student.\r\n"
					+ "\t\t 2)Search Student.\r\n"
					+ "\t\t 3)Receive fee.\r\n"
					+ "\t\t 4)Return back.");
			System.out.println("====================================================================");
			System.out.println("Enter your choice:");
			choice=Integer.parseInt(br.readLine());
			
			switch(choice)
			{
				case 1: 
						AddStudent();
					    break;
				case 2:
						searchStudent();
						break;
				case 3:
						System.out.println("Enter Students search value name, ID:");
						String value=br.readLine();
						int flag=0;
						for(Student temp:students)
						{
							if(temp.getName().equals(value) || temp.getId()==Integer.parseInt(value))
							{   
								tempStudent=temp;
								flag=1;
							}
						}
						if(flag==1)
						{
							tempStudent.payFees(tempStudent.getFeesTotal());
						}
						else
							System.out.println("SORRY...! Data Not Found\n");

						break;
				case 4:
						break;
			    default:
			    	throw new Exception("Wrong choice!!"); 		   
			
			}
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}while(choice!=4);
		return 0;
	}
	
	
	public static void Display()
	{
		int choice=0;
		do {
		try {
			System.out.println("====================================================================");
			System.out.println("Menu:");
			System.out.println("\t\t 1)Display Teachers.\r\n"
					+ "\t\t 2)Display Students.\r\n"
					+ "\t\t 3)OutStanding.\r\n"
					+ "\t\t 4)Return back.");
			System.out.println("====================================================================");
			System.out.println("Enter your choice:");
			choice=Integer.parseInt(br.readLine());
			
			switch(choice)
			{
				case 1: 
						displayTeacher();
					    break;
				case 2:
						displayStudent();
						break;
				case 3:
						OutStanding();
						break;
				case 4:
						break;
			    default:
			    	throw new Exception("Wrong choice!!"); 		   
			
			}
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}while(choice!=3);
		return;
	}
	//
	public static void AddTeacher() throws NumberFormatException, IOException
	{
	    int n;
	    System.out.println("How many Teachers data you want to enter:");
	    n=Integer.parseInt(br.readLine());
	    for(int i = 0; i < n; i++)
	    {
	        System.out.println("Enter data for "+i+" no Teacher");
	        System.out.println("\tEnter Teacher Name:");
	        String Tname=br.readLine();
	        System.out.println("\tEnter Teachers ID:");
	        int Tid=Integer.parseInt(br.readLine());
	        System.out.println("\tEnter salary:");
	        int Tsalary=Integer.parseInt(br.readLine());
	        teachers.add(new Teacher(Tid,Tname,Tsalary));
	    }
	}
	
	static void AddStudent() throws NumberFormatException, IOException
	{
	    int n;
	    System.out.println("How many Students data you want to enter:");
	    n=Integer.parseInt(br.readLine());

	    for(int i = 0; i < n; i++)
	    {
	        System.out.println("\nEnter data for "+i+" no Student\n");
	        System.out.println("\tEnter Student Name:");
	        String Sname=br.readLine();
	        System.out.println("\tEnter student ID:");
	        int Sid=Integer.parseInt(br.readLine());
	        System.out.println("\tEnter Section:");
	        int Ssection=Integer.parseInt(br.readLine());
	        students.add(new Student(Sid,Sname, Ssection));
	    }
	}
	
	
	//
	public static void searchTeacher() throws IOException
	{
	    System.out.println("Enter The Data You Want To search(Name OR ID)");
	    System.out.println("\tPlease Enter Your Required Data:");
	    String value=br.readLine();
	    int flag=0;
	    for(Teacher temp:teachers)
		{
			if(temp.getName().equals(value) || temp.getId()==Integer.parseInt(value))
			{   
				tempTeacher=temp;
				flag=1;
			}
		}
	    if(flag == 0)
	        System.out.println("SORRY...! Data Not Found\n");
	    else
	    {
	        System.out.println("\nData Found Your Data Should Be below here");
	        System.out.println("\tTeachers ID:"+tempTeacher.getId());
	        System.out.println("\tTeachers Name:"+tempTeacher.getName());
	        System.out.println("\tMonthly Salary:"+tempTeacher.getSalary());
	        System.out.println("\tSalary Earned:"+tempTeacher.getSalaryEarned());
	        
	    }
	}
	public static void searchStudent() throws IOException
	{
	    System.out.println("Enter Students search value Name OR ID:");
	    String value=br.readLine();
	    int flag=0;
	    for(Student temp:students)
		{
			if(temp.getName().equals(value) || temp.getId()==Integer.parseInt(value))
			{   
				tempStudent=temp;
				flag=1;
			}
		}
	    if(flag == 0)
	        System.out.println("SORRY...! Data Not Found\n");
	    else
	    	    {
	        System.out.println("\nSearch Student's information:\n");
	        System.out.println("\tStudent's Name:"+tempStudent.getName());
	        System.out.println("\tStudent's ID:"+tempStudent.getId());
	        System.out.println("\tStudent's Section:"+tempStudent.getGrade());
	        System.out.println("\tStudent's Fees Paid:"+tempStudent.getFeesPaid());

	        
	    }

	}
	public static void displayTeacher()
	{
		System.out.println("Teacher Details:");
		int i=1;
		for(Teacher temp:teachers)
		{
			System.out.println("Teacher "+i);
			System.out.println("\tTeachers ID:"+temp.getId());
		    System.out.println("\tTeachers Name:"+temp.getName());
		    System.out.println("\tMonthly Salary:"+temp.getSalary());
		    System.out.println("\tSalary Earned:"+temp.getSalaryEarned());
		    i++;
		}
	}
	public static void displayStudent()
	{
		System.out.println("Student Details:");
		int i=1;
		for(Student temp:students)
		{
			System.out.println("Student "+i);
	        System.out.println("\tStudent Name:"+temp.getName());
	        System.out.println("\tStudent ID:"+temp.getId());
	        System.out.println("\tStudent Section:"+temp.getGrade());
	        System.out.println("\tStudent Fees Paid:"+temp.getFeesPaid());
	        i++;
		}
	}
	public static void OutStanding()
	{
		System.out.println("Total Money Earned :"+School.getTotalMoneyEarned());
		System.out.println("Total Money Spent  :"+School.getTotalMoneySpent());
		
		if(School.getTotalMoneyEarned()>=0)
			System.out.println("Profit of "+School.getTotalMoneyEarned());
		else
			System.out.println("Loss of "+School.getTotalMoneyEarned());
	}
    public static void main(String[] args) throws NumberFormatException, IOException {
    	
    	System.out.println("\n====================================================================");
		System.out.println("------------------  School Management Application ------------------");
		System.out.println("====================================================================");
		Main m=new Main();    	
		if(m.Adminlogin())
		{
			m.adminDashboard();
		}			  
		else
		{
			System.out.println("User not authenticated!!");
		}
    	
    }
}









