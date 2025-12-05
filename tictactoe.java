import java.util.Scanner;
public class tictactoe {
static Scanner input = new Scanner(System.in);
	static boolean gameValue = true, gameover = false;
	static int first4moves = 0;
    public static void main(String [] args) { 
       	String ttt[][] = 
        {
        {"-" , "-" , "-"},
        {"-" , "-" , "-"},
        {"-" , "-" , "-"}, 
        };
      	do {
        structure(ttt);
	gameValue = playerMove(ttt,gameValue);
	first4moves++;
        if (first4moves >= 3 )
       	{
	gameover = checkwinner(ttt);
        if (!gameover)  gameover = checkdraw(ttt);
       	}
        }while(gameover==false);
    }
    
    
   
    public static void structure(String ttt[][]) {
    
    for (int rows = 0; rows < ttt.length; rows++) 
        {
        for (int cols = 0; cols < ttt[rows].length; cols++)
        {
        System.out.print(" " + ttt[rows][cols] + " ");
        if (cols < 2 ) System.out.print("|");

        }
        System.out.println();
        if (rows < 2)  System.out.println("---------------");
        }

    }

    public static boolean playerMove(String ttt[][], boolean gameValue) {
	int row , col;
        String value;
	if (gameValue) value = "x";
	else value = "o";
	System.out.println("It's " + value + "'s turn");
        while (true) {   
        System.out.println("Which row? (1-3) ");
        row = input.nextInt() - 1;

        System.out.println("Which colume?(1-3) ");
        col = input.nextInt() - 1;
        if (row < 0 || row > 2 || col < 0 || col > 2)
        {
           System.out.println("only Three row/col, Please try again");
        continue;
        }
    
     //perventing overwriting.  
	
        if (ttt[row][col].equals("x") || ttt[row][col].equals("o")) 
             {
             System.out.println("YOU can't add value here");
             continue;
           }
           else {
            ttt[row][col] = value;
           return gameValue ? false : true ;
        }   
        } 
    }



    public static boolean checkdraw( String[][] ttt) {
        for (int rows = 0; rows < ttt.length; rows++) 
        {
            for (int cols = 0; cols < ttt[rows].length; cols++)
            {
               if (ttt[rows][cols].equals("-" )) {
               return false;
               }
            }
        }
        // if all spaces are taken and ttt[row][cols] != "-" it should return true
        System.out.println("it is a Draw");
        return true;
    }




    public static boolean checkwinner(String ttt[][]) {
     for (int p = 0; p < ttt.length; p++) 
        //checking the rows, that is why we looped only the first index
        {  
         if (ttt[p][0].equals("x") && ttt[p][1].equals("x") && ttt[p][2].equals("x")) 
         { 
           System.out.println("X wins");  
           return true;
         }
           else if  (ttt[p][0].equals("o") && ttt[p][1].equals("o") && ttt[p][2].equals("o")) 
              {
                System.out.println("O wins");
               return true;
               
                 }
        }
          // now we are checking for cols
        for (int z = 0; z < ttt.length; z++) 
       
        {
            if (ttt[0][z].equals("x") && ttt[1][z].equals("x") && ttt[2][z].equals("x")) 
            {
            System.out.println("X wins"); 
            return true;
            }
            else if (ttt[0][z].equals("o") && ttt[1][z].equals("o") && ttt[2][z].equals("o"))
            {
            System.out.println("O wins");
            return true;
            }
        }   
          // here we are checking for the dignoals, right to left and left to right
        if (ttt[0][0].equals("x") && ttt[1][1].equals("x") && ttt[2][2].equals("x"))
        {
            System.out.println("X wins");
            return true;
        
        }
        else if (ttt[0][0].equals("o") && ttt[1][1].equals("o") && ttt[2][2].equals("o"))
        {
            System.out.println("O wins");
            return true;
            
        }
        
        if (ttt[0][2].equals("x") && ttt[1][1].equals("x") && ttt[2][0].equals("x"))
        {
            System.out.println("X wins");
            return true;
            
        }
        else if (ttt[0][2].equals("o") && ttt[1][1].equals("o") && ttt[2][0].equals("o"))
        {
            System.out.println("O wins");
            return true;
            
        }
        
        return false;
    }
}
