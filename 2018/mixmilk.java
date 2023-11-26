package mixmilk;

import java.util.*;
import java.io.*;

public class mixmilk {
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(new File("mixmilk.in"));
		int[] m = new int[3];
		int[] c = new int[3];
		
		for (int i = 0; i < 3; i++) {
			c[i] = Integer.parseInt(in.next());
			m[i] = Integer.parseInt(in.next());
		}
		
		in.close();
		
		
		int a = 0;
		int b = 1;
		for (int i = 0; i < 100; i++) {
			if (a != 2) { // bucket 1 or bucket 2
				// bucket a empty -> extra space in b (c - m) > milk in a (m)
				// bucket b full  -> c - m < m (see above)
				if (c[b] - m[b] >= m[a]) { // pour till bucket a is empty
					m[b] += m[a];
					m[a] = 0;
				}
				else if (c[b] - m[b] < m[a]) { // pour till bucket b full (a isn't empty)
					m[a] -= c[b] - m[b];
					m[b] = c[b];
				}
				
				a++;
				b++;
				
			} else { // bucket 3
				b = 0;
				
				if (c[b] - m[b] >= m[a]) {
					m[b] += m[a];
					m[a] = 0;
				}
				else if (c[b] - m[b] < m[a]) {
					m[a] -= c[b] - m[b];
					m[b] = c[b];
				}
				
				a = 0;
				b++;
			}
		}
		
		PrintWriter out = new PrintWriter(new File("mixmilk.out"));
		System.out.println(m[0]);
		System.out.println(m[1]);
		System.out.println(m[2]);
		out.println(m[0]);
		out.println(m[1]);
		out.println(m[2]);
		out.close();
	}
}
