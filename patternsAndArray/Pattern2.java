package P;

public class Pattern2 {

	public static void main(String[] args) {
		
		int rows = 5;
		for(int i=0;i<rows;i++) 
		{
			for (int j=0;j<=i;j++)
			{
				if (i==2 && j == 1) {
					System.out.print(" ");
				}
				else if (i==3 && j==1 || i==3 && j==2) {
					System.out.print(" ");
				}
				else {
					System.out.print("*");
				}
			}
			System.out.println();
		}
	}
}
