import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int M = in.nextInt();
		int N = in.nextInt();
		int R = in.nextInt();
		int matrix[][] = new int[M][N];
		for(int i=0; i<M; i++){
			for(int j=0; j<N; j++){
				matrix[i][j] = in.nextInt();
			}
		}


		rotateMatrix(M, N, matrix, R);



		for(int i=0; i<M; i++){
			for(int j=0; j<N; j++){
				System.out.print(matrix[i][j]+" ");
			}

			System.out.println();
		}
	}


	public static void rotateMatrix(int m, int n, int a[][], int R){
		int i, k = 0, l = 0;


		int M1 =m;
		int N1=n;


		while (k < m && l < n)
		{
			int pk = k, pm =m, pl = l,pn= n;
			int rotCount = M1*2+(N1-2)*2;
			if(rotCount!=0)
				rotCount= R%rotCount;
			for(int t=0; t<rotCount;t++){

				int temp = 0;
				for (i = n-1; i >= l; --i)
				{
					temp = temp+a[k][i];
					a[k][i] = temp -a[k][i];
					temp = temp -a[k][i];
				}
				k++;

				if (l < n)
				{
					for (i = l+1; i < m; ++i)
					{
						temp = temp+a[i][l];
						a[i][l] = temp-a[i][l];
						temp = temp-a[i][l];
					}
					l++;    
				}   

				if ( k < m)
				{
					for (i = l; i <= n-1; ++i)
					{
						temp = temp + a[m-1][i];
						a[m-1][i] = temp - a[m-1][i];
						temp = temp - a[m-1][i];

					}
					m--;
				}

				for (i = m-1; i >= l; --i)
				{
					temp = temp + a[i][n-1];
					a[i][n-1] = temp - a[i][n-1];
					temp = temp - a[i][n-1];
				}
				a[k-1][n-1] = temp;
				n--;

				if(t<rotCount-1){
					k=pk;
					l=pl;
					m=pm;
					n=pn;
				}

			}
			M1-=2;
			N1-=2;
		}
	}

}


