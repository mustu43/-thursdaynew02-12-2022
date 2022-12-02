package javaexamples;
import java.util.Scanner;
import java.io.*;
public class tictactoe {
	int p,p1sc=0,p2sc=0,tie=0,n;
	String p1,p2;
	char[][] t= {{' ',' ', ' '},{' ',' ', ' '},{' ',' ', ' '}};
	char[] sym= {'O','X'}; 
	Scanner s = new Scanner(System.in);
	
	public void initial()
	{
		int k=1;
		System.out.println("Welcome to the Tic-Tac-Toe Game");
		System.out.println("Remeber these numbers as positions. So, whenever you want to include X or O enter the"
				+ " position.");
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print((k++)+"|");
			}
			System.out.println("\n------");
		}
	}
	
	public void select()
	{
		System.out.println("Enter the player number 1 or 2 who wants to play first.");
		p=s.nextInt();
		if(p==1)
		{
			p1="O";
			p2="X";
		}
		else
		{
			p2="O";
			p1="X";
		}
		System.out.println("\nEnter the number of games you want to play ");
		n=s.nextInt();
		System.out.println("Lets start");
	}
	
	public void display()
	{
		System.out.println("-------------");
		for(int i=0;i<3;i++)
		{
			for (int j = 0; j < 3; j++)
			{
				System.out.print("| "+t[i][j]+" ");
			}
			System.out.print("|");
			System.out.println("\n-------------");
		}
	}
	
	public void play()
	{
		int turns=1,ppp,pos=0,st,times=0;
		int visited[]=new int[9];
		String w="";
		
		while(times<n)
		{
			System.out.println("\t---------");
			System.out.println("\t| Game "+ (times+1)+" |");
			System.out.println("\t---------");
			
			while(turns<10)
			{
				st=ppp=p;
				System.out.println("Player "+ppp+" turn");
				System.out.println("Enter the position :");
				pos=s.nextInt();
				while(pos>9)
				{
					System.out.println("You have entered a wrong position" +pos);
					System.out.println("Please enter the position");
					pos=s.nextInt();
				}
				if(pos==visited[pos-1])
				{
				System.out.println("Position already entered");
				}
				else {
					if(ppp==1)
					{
						if(pos==1)
						{
							t[0][0]='O';
							visited[0]=1;
						}
						else if(pos==2)
						{
							t[0][1]='O';
							visited[1]=2;
						}
						else if(pos==3)
						{
							t[0][2]='O';
							visited[2]=3;
						}
						else if(pos==4)
						{
							t[1][0]='O';
							visited[3]=4;
						}
						else if(pos==5)
						{
							t[1][1]='O';
							visited[4]=5;
						}
						else if(pos==6)
						{
							t[1][2]='O';
							visited[5]=6;
						}
						else if(pos==7)
						{
							t[2][0]='O';
							visited[6]=7;
						}
						else if(pos==8)
						{
							t[2][1]='O';
							visited[7]=8;
						}
						else if(pos==9)
						{
							t[2][2]='O';
							visited[8]=9;
						}
					}
					
					else
					{
						if(pos==1)
						{
							t[0][0]='X';
							visited[0]=1;
						}
						else if(pos==2)
						{
							t[0][1]='X';
							visited[1]=2;
						}
						else if(pos==3)
						{
							t[0][2]='X';
							visited[2]=3;
						}
						else if(pos==4)
						{
							t[1][0]='X';
							visited[3]=4;
						}
						else if(pos==5)
						{
							t[1][1]='X';
							visited[4]=5;
						}
						else if(pos==6)
						{
							t[1][2]='X';
							visited[5]=6;
						}
						else if(pos==7)
						{
							t[2][0]='X';
							visited[6]=7;
						}
						else if(pos==8)
						{
							t[2][1]='X';
							visited[7]=8;
						}
						else if(pos==9)
						{
							t[2][2]='X';
							visited[8]=9;
						}
					}
			
					display();
					w=check();
		
					if(p==1)
						p=2;
					else if(p==2)
						p=1;
		
					turns++;
					if(st==1&&w=="O")
					{
						System.out.println("The winner is "+w);
						p1sc++;
						break;
					}
					else if(st==2&&w=="X")
					{
						System.out.println("The winner is "+w);
						p2sc++;
						break;
					}
					else 
						System.out.println();
					if(turns==9)
						tie++;
					}
			}
			System.out.println("Player 1(O) Score : "+p1sc+"   Player 2(X) Score : "+p2sc+"   Tie Score : "+tie);
			System.out.println();
			turns=1;pos=0;
			for(int i=0;i<9;i++)
			{
				visited[i]=0;
			}
			for(int i=0;i<3;i++)
			{
				for (int j = 0; j < 3; j++)
				{
					t[i][j]=' ';
				}
			}
			w="";
			times++;
			System.out.println();
		}
	}
	public String check()
	{
		String win="";
		if(t[0][0]=='O'&&t[0][1]=='O'&&t[0][2]=='O')
			win="O";
		else 
			if(t[1][0]=='O'&&t[1][1]=='O'&&t[1][2]=='O')
			win="O";
		else 
			if(t[2][0]=='O'&&t[2][1]=='O'&&t[2][2]=='O')
			win="O";
		else 
			if(t[0][0]=='O'&&t[1][1]=='O'&&t[2][2]=='O')
			win="O";
		else 
			if(t[0][2]=='O'&&t[1][1]=='O'&&t[2][0]=='O')
			win="O";
		else 
			if(t[0][0]=='O'&&t[1][0]=='O'&&t[2][0]=='O')
				win="O";
		else 
			if(t[0][1]=='O'&&t[1][1]=='O'&&t[2][1]=='O')
				win="O";
		else 
			if(t[0][2]=='O'&&t[1][2]=='O'&&t[2][2]=='O')
				win="O";
		else
			if(t[0][0]=='X'&&t[0][1]=='X'&&t[0][2]=='X')
			win="X";
		else 
			if(t[1][0]=='X'&&t[1][1]=='X'&&t[1][2]=='X')
			win="X";
		else 
			if(t[2][0]=='X'&&t[2][1]=='X'&&t[2][2]=='X')
			win="X";
		else 
			if(t[0][0]=='X'&&t[1][1]=='X'&&t[2][2]=='X')
			win="X";
		else 
			if(t[0][2]=='X'&&t[1][1]=='X'&&t[2][0]=='X')
			win="X";
		else 
			if(t[0][0]=='X'&&t[1][0]=='X'&&t[2][0]=='X')
			win="X";
		else 
			if(t[0][1]=='X'&&t[1][1]=='X'&&t[2][1]=='X')
			win="X";
		else 
			if(t[0][2]=='X'&&t[1][2]=='X'&&t[2][2]=='X')
			win="X";
		
		return win;
	}
	public void createfile() throws IOException
	{
	        String path= "C://Desktop/scores.txt";
	       File file = new File(path); 
        FileWriter fw = new FileWriter(file);
        FileReader fr = new FileReader(file);
       
        try {  
            
            if (file.createNewFile()) {  
                System.out.println("Scores are added to file!");  
            } else {  
                System.out.println("Scores are added to file!");  
            }  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
        double pp1=p1sc,pp2=p2sc;
        double p1per=(pp1/n*100),p2per=pp2/n*100;
        fw.write("Total Games Played = "+n+"\nPlayer 1 Score(O) = "+p1sc+"\nWin % = "+p1per+"%"+"\nPlayer 2 Score(X) = "+p2sc+"\nWin % = "+p2per+"%");
        fw.close();
        char[] data = new char[100];
        fr.read(data);
       System.out.println(data);
       fr.close();      
	}

	public static void main(String[] args) throws IOException{
		 tictactoe  t = new  tictactoe();
		t.select();
		t.initial();
		t.display();
		t.play();
		try{
		t.createfile();
		}
		catch (Exception e) {  
            e.printStackTrace();  
        } 
	}
}