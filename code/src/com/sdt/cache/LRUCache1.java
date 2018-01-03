package com.sdt.cache;

import java.util.HashMap;

class DoubleLinkedListNode{
	public int val;
	public int key;
	public DoubleLinkedListNode pre;
	public DoubleLinkedListNode next;
	
	public DoubleLinkedListNode(int key, int val) {
		this.val = val;
		this.key = key;
	}
}
public class LRUCache1 {
	private HashMap<Integer, DoubleLinkedListNode> map
		= new HashMap<Integer, DoubleLinkedListNode>();
	private DoubleLinkedListNode head;
	private DoubleLinkedListNode end;
	private int capacity;
	private len ;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
