package practice;
import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw;
	static BufferedReader br;
	
	static int[][] arr;
	static int cal(int n) {
		int sum=0;
		for(int i=n+1;i<arr[n][0]+n;i++)
			sum+=arr[i][1];
		return sum;
	}
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		arr = new int[n][2];
		int[] res = new int[n+1];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		for(int i=n-1;i>=0;i--) {
			if(i+arr[i][0]>n) {
				arr[i][1] = 0;
				res[i] = res[i+1];
				continue;
			}
			if(cal(i)>arr[i][1]) {
				if(arr[i][1]+res[i+arr[i][0]]>res[i+1])
					res[i] = arr[i][1] + res[i+arr[i][0]];
				else
					res[i] = res[i+1];
				arr[i][1] = 0;
			}
			else {
				for(int j=i+1;j<arr[i][0]+i;j++)
					arr[j][1] = 0;
				res[i] = arr[i][1] + res[i+arr[i][0]];
			}
		}
		bw.write(res[0]+"\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
