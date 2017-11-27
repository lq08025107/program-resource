package com.sdt.sort;


public class HeapSort1 {

	public static void main(String[] args) {
		int[] a = {73,98,27,36,77,22,6,32,83,69};
		show(a);
		a = heapSort(a);
		show(a);

	}
	public static int[] heapSort(int[] a){
		int N = a.length - 1;
		for(int k = N/2; k >= 0; k--){
			sink(a, k, N);
			//show(a);
		}
		while(N > 0){
			exch(a, 0, N--);
			sink(a, 0, N);
		}
		return a;
	}
	
	private static void exch(int[] a, int i, int j){
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
	
	private static void sink(int[] a, int k, int N) {
        while (2 * k < N) {
            int j = 2 * k+1;    //a[j]为 a[k]的左子结点
            if (j < N && a[j] < a[j + 1]) {
                j++;        //保证a[j]指向 a[k]的较大的那个孩子结点
            }
            if (a[k] > a[j]) { //如果a[k] 比他的最大的子结点还大，则无需调整
                break;
            } else {    //否则 交换a[k] 和a[j]
                exch(a, j, k);      //为了保证a[k]（堆顶）（父亲永远比儿子大）
                k = j;  // 然后 继续 a[k]的子结点和a[k]的孙结点进行比较
            }
        }
}
	
	public static void show(int[] array){
		for(int number : array){
			System.out.print(number + " ");
		}
		System.out.println(" ");
	}

}
