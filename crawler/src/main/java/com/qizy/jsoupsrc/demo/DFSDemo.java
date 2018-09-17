package com.qizy.jsoupsrc.demo;
/**
 * jsoup中node提供对dfs想到经典
 * @author qizy
 *
 */
public class DFSDemo {

	public static void main(String[] args) {
		Node root = new Node("A");
		Node nodeB = new Node("B");
		nodeB.appendChild(new Node("E"))
			 .appendChild(new Node("F"));
		root.appendChild(nodeB)
			.appendChild(new Node("C"))
			.appendChild(new Node("D"));
		root.traverse();
	}

}
