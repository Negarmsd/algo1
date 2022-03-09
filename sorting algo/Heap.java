import java.util.Arrays;
public class Heap {
	int size;
	public int[] buildMaxHeap(int[] arr) {
		size = arr.length;
		for (int i = arr.length / 2; i >= 0; i--) {
			System.out.println(Arrays.toString(arr));
			maxHeapify(arr, i);
			
		}
		return arr;
	}
	public void maxHeapify(int[] arr, int i) {
		int l = 2 * i + 1;
		int r = 2 * i + 2;
		int max = 0;
		if (l <= size - 1 && arr[l] > arr[i]) {
			max = l;
		} else {
			max = i;
		}
		if (r <= size - 1 && arr[r] > arr[max]) {
			max = r;
		}
		if (max != i) {
			int temp = arr[i];
			arr[i] = arr[max];
			arr[max] = temp;
			maxHeapify(arr,max);
		}
	}

	public int[] heapSort(int[] arr) {
		
		buildMaxHeap(arr);
		System.out.println("\nSort\n");
		int count = 1;
		size = arr.length;
		for (int i = arr.length - 1; i > 0; i--) {
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			size--;
			//System.out.println(Arrays.toString(arr));
			maxHeapify(arr, 0);
			System.out.println(Arrays.toString(arr));
		}
		return arr;
	}

	public int[] buildMinHeap(int[] arr) {
		size = arr.length - 1;
		for(int i = arr.length / 2; i>= 0; i--) {
		minHeapify(arr, i);
		}
		return arr;
	}
	public void minHeapify(int[] arr, int i) {
		int l = 2 * i + 1;
		int r = 2 * i + 2;
		int min = 0;
		if (l <= size  && arr[l] < arr[i]) {
			min = l;
		} else {
			min = i;
		}
		if (r <= size  && arr[r] < arr[min]) {
			min = r;
		}
		if (min != i) {
			int temp = arr[i];
			arr[i] = arr[min];
			arr[min] = temp;
			minHeapify(arr, min);
		}
	}
	public int[] minHeapSort(int[] arr) {
		buildMinHeap(arr);
		size = arr.length - 1;
		for (int i = arr.length - 1; i > 0; i--) {
			int temp = arr[i];
			arr[i] = arr[0];
			arr[0] = temp;
			size--;
			minHeapify(arr, 0);
			
		}
		return arr;
	}
					
}
