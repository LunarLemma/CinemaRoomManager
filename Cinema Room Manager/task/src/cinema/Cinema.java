package cinema;
import java.util.*;
public class Cinema {

    public static void main(String[] args) {
        // Write your code here
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int rows= sc.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seats=sc.nextInt();
        char[][] seating= new char[rows][seats];
        for(char[] val: seating)
            Arrays.fill(val,'S');
        menu(sc,seating);
    }
    static void menu(Scanner sc,char[][] seating){
        int ticketCount=0,currInc=0,conste=1;
        do {
            System.out.println("\n1. Show the seats\n2. Buy a ticket\n3. Statistics\n0. Exit");
            int n = sc.nextInt();
            switch (n) {
                case 1 ->
                    printArray(seating);
                case 2 -> {
                    do {
                        System.out.println("\nEnter a row number:");
                        int row = sc.nextInt();
                        System.out.println("Enter a seat number in that row:");
                        int seat = sc.nextInt();
                        if(row>seating.length || seat>seating[0].length){
                            System.out.println("\nWrong Input!");
                            continue;
                        }
                        else if(seating[row-1][seat-1]=='B') {
                            System.out.println("That ticket has already been purchased!");
                            continue;
                        }
                        seating[row - 1][seat - 1] = 'B';
                        ticketCount++;
                        int value=getPrice(seating.length * seating[0].length, row, seating.length / 2);
                        currInc+=value;
                        System.out.println("\nTicket Price: $" + value);
                        break;
                    }while(true);
                }
                case 3-> {
                    int check=seating.length* seating[0].length;
                    System.out.println("\nNumber of purchased tickets: "+ticketCount);
                    System.out.printf("Percentage: %.2f%%",((ticketCount*100.0)/check));
                    System.out.println("\nCurrent income: $"+currInc);
                    int tot=0;
                    if(check<=60)
                        tot=check*10;
                    else{
                        int front=seating.length/2;
                        tot=(front*10+(seating.length-front)*8)*seating[0].length;
                    }
                    System.out.println("Total income: $"+tot);
                }
                case 0 ->
                    conste=0;
                default ->
                    System.out.println("Invalid input");
            }
        }while(conste==1);
    }
    static int getPrice(int check,int row,int val){
        if(check<=60 || row <= val)
            return 10;
        else
            return 8;
    }
    static void printArray(char[][] arr){
        System.out.println();
        System.out.print("Cinema: \n  ");
        for(int i=0;i<arr[0].length;i++)
            System.out.print((i+1)+" ");
        System.out.println();
        for(int i=0;i< arr.length;i++) {
            System.out.print((i+1)+" ");
            for (int j = 0; j < arr[0].length; j++)
                System.out.print(arr[i][j]+" ");
            System.out.println();
        }
    }
}
