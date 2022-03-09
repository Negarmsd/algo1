import java.util.Arrays;
public class Main{
	public static void main(String[] args) {
		Sort sort = new Sort();
		int[] arr = {1, 22, 10, 13, 24, 6, 18, 21, 4};
		//System.out.println(Arrays.toString(sort.mergsort(arr)));

		Heap heap = new Heap();
		//System.out.println(Arrays.toString(heap.buildMaxHeap(arr)));
		//System.out.println(Arrays.toString(heap.heapSort(arr)));

		int[] ar = {8, 5, 9, 3, 6, 1};
		//System.out.println(Arrays.toString(heap.buildMinHeap(ar)));
		//System.out.println(Arrays.toString(heap.minHeapSort(ar)));
		

		//System.out.println("qiss");
		//int[] a = {9, 7, 4, 2, 3, 6, 1, 5};
		//System.out.println(Arrays.toString(sort.quicksort(a, 0, a.length)));
		


		int[] b = new int[a.length];
		for(int i:b) i = 0;
		//b = sort.radixsort(a, 10);
		//System.out.println(Arrays.toString(b));

		int[] c= {2, 3, 5, 7, 11, 13, 17, 19};
		System.out.println(sort.select(a,3));
		
		//sort.countingsort(arr,b,100);
		//System.out.println(Arrays.toString(b));
		//System.out.println(Arrays.toString(sort.bubblesort(c)));

		
	}
}
