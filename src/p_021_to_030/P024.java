package p_021_to_030;

public class P024 {

	public static void next(int[] arr) {
		int k = 0, l = 0;
		for (int i = arr.length - 2; i >= 0; i--) {
			if (arr[i] < arr[i + 1]) {
				k = i;
				break;
			}
		}

		for (int i = arr.length - 1; i > k; i--) {
			if (arr[i] > arr[k]) {
				l = i;
				break;
			}
		}

		int temp = arr[k];
		arr[k] = arr[l];
		arr[l] = temp;

		for (int i = k + 1; i < (arr.length + k + 1) / 2; i++){
			int tmp = arr[i];
			arr[i] = arr[arr.length - (1 + i - (k + 1))];
			arr[arr.length - (1 + i - (k + 1))] = tmp;
		}


	}

	public static void main(String[] args) {
		int[] arr = {0,1,2,3,4,5,6,7,8,9};
		for (int i = 0; i < 999999; i++) {
			next(arr);
		}
		
		for (int j : arr) {
			System.out.print(j);
		}


	}

}
