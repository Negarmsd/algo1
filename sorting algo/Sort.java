import java.util.Arrays;
import java.lang.Math; 
public class Sort{
	public int[] mergsort(int[] arr) {
		int mid = arr.length / 2;
		int[] r,l, rr, ll;
		
		if (arr.length >= 2) {
			l = new int[mid];
			r = new int[arr.length - mid];
			for (int i = 0 ; i < mid; i++) {
				l[i] = arr[i];
			}
			for (int i = 0; i < arr.length - mid; i++) {
				r[i] = arr[i + mid];
			}
			ll = mergsort(l);
			rr = mergsort(r);
			//System.out.println("*" + Arrays.toString(l) + " " + Arrays.toString(r));
			return combine(mergsort(ll), mergsort(rr));
		}
		return arr;
		
	}
	public int[] combine(int[] l, int[] r){
		int[] c = new int[l.length + r.length];
		int i = 0, j = 0, k = 0;
		while(i < l.length && j < r.length) {
			if (l[i] <= r[j]) {
				c[k] = l[i];
				i++;
			}
			else {
				c[k] = r[j];
				j++;
			}
			k++;
			
		}
		while (i < l.length) {
			c[k] = l[i];
			i++;
			k++;
		}
		while(j < r.length) {
			c[k] = r[j];
			j++;
			k++;
		}

       
		System.out.println(Arrays.toString(c));
		return c;
	}
	//p -> pivot, r -> end of the partition
	public int[] quicksort(int[] arr, int p, int r) {
		
		if(p < r) {
			
			int q = partition(arr, p, r);
			quicksort(arr, p, q);
			quicksort(arr, q + 1, r);
			//System.out.println(Arrays.toString(arr));
			
		}
		
		return arr;
	}
	public int partition(int[] arr, int p, int r) {
		int pivot= 0, i = p - 1;
		pivot = arr[r - 1];
		System.out.println( pivot);
		for (int j = p; j < r ; j++) {
			if (arr[j] <= pivot) {
				i++;
				//System.out.println(Arrays.toString(arr));
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				
			}
		}	
		System.out.println(Arrays.toString(arr) + " " + arr[i]);
		return i++;
	}
	public int[] radixsort(int[] a, int d) {
		int[] b = new int[a.length];
		for (int i = 0; i < b.length; i++) { 
			b[i] = 0;
		}
		for (int i = 0; i < d; i++) {
			radixCountingsort(a, b, i);
		}
		return a;
	}
	public void radixCountingsort(int[] a, int[] b, int k) {
		
		int[] c = new int[10];
		for (int i = 0; i < c.length; i++) { 
			c[i] = 0;
		}
		for (int i = 0; i < a.length; i++) {
			++c[(a[i] / (int)Math.pow(10,k)) % 10];
		}
		for (int i = 1; i < c.length; i++) {
			c[i] += c[i - 1];
		}
		for (int i = a.length - 1; i >=0; i--) {
			b[c[(a[i] / (int)Math.pow(10,k)) % 10] - 1] = a[i];
			c[(a[i] / (int)Math.pow(10,k)) % 10]--;
		}
		System.out.println(Arrays.toString(b));
		for (int i = 0; i < a.length; i++) {
			a[i] = b[i];
		}
		
	}
	public void countingsort(int[] a, int[] b, int k) {
		int[] c = new int[k];
		for (int i = 0; i < c.length; i++) { 
			c[i] = 0;
		}
		for (int i = 0; i < a.length; i++) {
			c[a[i]]++;
		}
		for (int i = 1; i < c.length; i++) {
			c[i] += c[i - 1];
		}
		for (int i = a.length - 1; i >= 0; i--) {
			b[c[a[i]] - 1] = a[i];
			c[a[i]]++;
		}
	}
	public int min(int[] a) {
		int min = a[0];
		for (int i = 1; i < a.length ; i++) {
			if (a[i] < min) {
				min = a[i];
			}
		}
		return min;
	}
	public int max(int[] a) {
		int max = a[0];
		for (int i = 1; i < a.length; i++) {
			if (a[i] > max) {
				max = a[i];
			}
		}
		return max;
	} 
	public int median(int[] x) {
		if (x.length == 0) return 0;
		
		if (x.length % 2 == 0) {
			return x[x.length / 2 - 1];
		} else {
			return x[x.length / 2];
		}
	}
	
	public int select(int[] x, int k) {
		int m = 0;
		if (x.length <= 5) {
			x = mergsort(x);
			return x[k - 1];
		} else {
			int n = 0;
			if (x.length % 5 == 0) {
				n = x.length / 5;
			} else {
				n = x.length / 5 + 1;
			}
			
			int[] b = new int[5];
			int[] mid = new int[n];
			int count = 0;
			for (int i = 0; i < (x.length / 5) * 5; i++) {	
				//System.out.println(count);
				b[i % 5] = x[i];
				if (i % 5 == 4) {
					b = mergsort(b);
					mid[count] = median(b);
					count++;
					System.out.println(Arrays.toString(b));
				}
			}
			int[] bb = new int[x.length % 5];
			for (int i = (x.length / 5) * 5; i < x.length; i++) {	
				//System.out.println(count);
				bb[i % 5] = x[i];
				if (i ==  x.length - 1 ) {
					bb = mergsort(bb);
					mid[count] = median(bb);
					count++;
					System.out.println(Arrays.toString(bb));
				}
			}
			System.out.println("mid\t" + Arrays.toString(mid));
			
			m = select(mid, (int)Math.ceil((double)mid.length / 2.0));
			System.out.println("m =\t" + m);
			int big = 0, eq = 0, sm = 0;
			for (int i = 0; i < x.length; i++) {
				if (x[i] > m) big++;
				if (x[i] == m) eq++;
				if (x[i] < m) sm++;
			}
			int[] bigger = new int[big];
			int[] smaller = new int[sm];
			int[] equ = new int[eq];
			for (int i = 0; i < x.length; i++) {
				if (x[i] > m) {
					big--;
					bigger[big] = x[i];
					
					
				}
				if (x[i] < m) {
					sm--;
					smaller[sm] = x[i];
					
				}
				if (x[i] == m) {
					eq--;
					equ[eq] = x[i];
					
				}
			}
			System.out.println("sm\t" + Arrays.toString(smaller));
			System.out.println("eq\t" + Arrays.toString(equ));
			System.out.println("big\t" + Arrays.toString(bigger));
			if (smaller.length >= k) {
				return select(smaller, k);
			}
			else if (smaller.length + equ.length >= k) {
				return m;
			} else {
				return select(bigger, k - (smaller.length + equ.length));	
			}
		}

	}
	public int[] bubblesort(int[] a) {
		for (int i = a.length; i > 0; i--) { 
			for (int j = 0; j < i - 1; j++) {
				if (a[j] > a[j + 1]) {
					int  temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
					System.out.println(Arrays.toString(a));
				}
			}
		}
		return a;
	}	

}
			


