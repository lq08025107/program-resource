package com.sdt.sort;



public class HeapSort<T extends Comparable<? super T>> {
	private int size;
	private Object[] data = new Object[256];
	
	public HeapSort(T[] data){
		super();
		this.initHeap(data);
	}
	
	public void initHeap(T[] data){
		assert data.length >= 1;
		ensureCapacity();
		this.size = data.length;
		System.arraycopy(data, 0, this.data, 0, this.size);
		int startPos = this.getParentIndex(this.size - 1);
		for(int i = startPos; i >= 0; i--){
			this.shiftdown(i);
		}
	}
	
	public void addToHeap(T value){
		this.ensureCapacity();
		this.data[this.size++] = value;
		this.shiftup(this.size - 1);
	}
	
	private void shiftup(int pos){
		int parentIdx = this.getParentIndex(pos);
		while(pos != 0 
				&& this.getValue(pos).compareTo(this.getValue(parentIdx)) < 0){
			pos = parentIdx;
			parentIdx = this.getParentIndex(pos);
		}
	}
	
	public boolean hasNext(){
		return this.size > 0;
	}
	
	public T getHeapTop(){
		return (T)this.data[0];
	}
	
	private void ensureCapacity(){
		if(this.data.length <= this.size){
			Object[] oldData = this.data;
			this.data = new Object[(int)(data.length * 1.5)];
			System.arraycopy(oldData, 0, this.data, 0, oldData.length);
		}
	}
	
	private int getParentIndex(int pos){
		return (pos - 1) / 2;
	}
	
	private void swap(int idx1, int idx2){
		T tmp = this.getValue(idx1);
		this.data[idx1] = this.getValue(idx2);
		this.data[idx2] = tmp;
	}
	
	public T getValue(int index){
		return (T) this.data[index];
	}
	
	private int getLeftChildIdx(int pos){
		return pos * 2 + 1;
	}
	
	private int getRightChildIdx(int pos){
		return pos * 2 + 2;
	}
	private void shiftdown(int pos){
		int leftChildIdx = this.getLeftChildIdx(pos);
		if(leftChildIdx >= this.size){
			return;
		}
		int rightChildIdx = getRightChildIdx(pos);
		int toBeSwapIdx = leftChildIdx;
		if(rightChildIdx < this.size && this.getValue(leftChildIdx).compareTo(this.getValue(rightChildIdx)) > 0){
			toBeSwapIdx = rightChildIdx;
		}
		if(this.getValue(pos).compareTo(this.getValue(toBeSwapIdx)) > 0){
			this.swap(pos, toBeSwapIdx);
			this.shiftdown(toBeSwapIdx);
		}
	}
	
	public T removeTop(){
		T rsT = this.getHeapTop();
		this.data[0] = this.data[--this.size];
		this.shiftdown(0);
		return rsT;
	}
	
	public void addToHeapKeepFixedSize(T value){
		if(this.getHeapTop() == null || value.compareTo(this.getHeapTop()) > 0){
			this.data[0] = value;
			this.shiftdown(0);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] data = {4,3,12,6,78,22};
		HeapSort<Integer> heap = new HeapSort<Integer>(data);
		while(heap.hasNext()){
			System.out.print(heap.removeTop());
			System.out.print(" ");
		}
		
		System.out.println(" ");
		heap.initHeap(data);
		for(int i = 0; i < 10; i++){
			heap.addToHeap(i);
		}
		while(heap.hasNext()){
			System.out.print(heap.removeTop());
			System.out.print(" ");
		}
		System.out.println(" ");
		heap.initHeap(data);
		for(int i = 0; i < 10; i++){
			heap.addToHeapKeepFixedSize(i);
		}
		while(heap.hasNext()){
			System.out.print(heap.removeTop());
			System.out.print(" ");
		}
	}

}
