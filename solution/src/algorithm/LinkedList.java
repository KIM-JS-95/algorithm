package algorithm;

import java.util.Comparator;
	public class LinkedList<E> {
		class Node<E>{
			private E data;
			private Node<E> next;
			
			Node(E data, Node<E> next) {
				this.data = data;
				this.next = next;
			}
		}

		private Node<E> head;
		private Node<E> crnt;

	//생성자
	public LinkedList() {
		head = crnt =null;
	}
	
	//노드 검색 메서드
	public E search(E obj, Comparator<? super E> c) {
		Node<E> ptr = head;  //Scanning Node
		
		while(ptr !=null) {
			if(c.compare(obj,ptr.data)==0) { //search
				crnt = ptr;
				return ptr.data;
			}
			ptr=ptr.next;
		}
		return null;
	}
	
	//머리부분 노드 삽입
	public void addFirst(E obj) {
		Node<E> ptr = head;
		head = crnt = new Node<E>(obj, ptr);
	}
	
	//꼬리부분 노드 삽입
	public void addLast(E obj) {
		if(head == null)
			addFirst(obj);
		else {
			Node<E> ptr = head;
			while(ptr.next != null)
				ptr = ptr.next;
			ptr.next = crnt = new Node<E>(obj, null);
		}	
	}
	//머리 노드 삭제
	public void removeFirst() {
		if(head !=null)
			head = crnt = head.next;
	}
	
	public void removeLast() {
		if(head != null) {
			if(head.next == null)
				removeFirst();
			else {
				Node<E> ptr = head;
				Node<E> pre = head;
				
				while(ptr.next != null) {
					pre = ptr;
					ptr = ptr.next;
				}
				pre.next = null;
				crnt=pre;
			}
		}
	}
	public void clear() {
		while(head != null)
		removeFirst();
		crnt = null;
	}
	
	public boolean next() {
		if(crnt == null || crnt.next == null)
			return false;
		crnt = crnt.next;
		return true;
	}
	
	public void printCurrentNode() {
		if(crnt == null)
			System.out.println("선택한 노드가 없습니다.");
		else
			System.out.println(crnt.data);
	}
	
	public void dump() {
		Node<E> ptr = head;		
		while(ptr != null) {
			System.out.println(ptr.data);
			ptr=ptr.next;
		}
	}
}