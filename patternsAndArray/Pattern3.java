package P;

public class Pattern3 {

	public static void main(String[] args) {
		
		int row = 4;
		int blank = row - 1;
		for (int i = 1;i<=row;i++) {
			for(int j =1;j<=blank;j++) {
				System.out.print(" ");
			}
			blank--;
			for(int x=1;x<=2*i-1;x++) {
				System.out.print("*");
			}
			System.out.println("");
		}
		blank = 1;
		for(int i = 1;i<= row -1;i++) {
			for(int j=1;j<=blank;j++) {
				System.out.print(" ");
			}
			blank++;
			for(int x=1; x<=2*(row-i)-1;x++) {
				System.out.print("*");
			}
			System.out.println("");
		}
	}
}
