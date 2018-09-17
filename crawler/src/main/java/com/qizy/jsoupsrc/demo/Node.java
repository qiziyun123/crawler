package com.qizy.jsoupsrc.demo;

import java.util.ArrayList;
import java.util.List;

public class Node {
	private String val;
	

	private Node parent;
	private List<Node> children;
	// pointer to the index of all neigber
	private int siblingIndex;
	public Node(String v) {
		val=v;
	}
	public Node appendChild(Node node) {
		if(children==null) {
			children = new ArrayList<Node>();
		}
		children.add(node);
		node.setSiblingIndex(children.size()-1);
		node.setParent(this);
		return this;
	}

	public Node getNextSibiling() {
		if(parent==null) {
			return null;
		}else {
			final int index = siblingIndex+1;
			if(index<parent.getChildren().size()) {			
				return parent.getChildren().get(index);
			}else {
				return null;
			}
		}
		
	}
	
	// traverse this node as a root node
	//   	a
	//  b 	c 	d
	//e   f
	public void traverse() {
		Node root = this;
		int depth =0;
		Node pointer = root;
		while(pointer!=null) {
			pointer.head();
			if(pointer.getChildren()!=null) {
				// traverse child
				pointer = pointer.getChildren().get(0);
				depth++;
			}else {
				// traverse sibling
				while(pointer.getNextSibiling()==null&&depth>0) {
					pointer.tail();
					// last visit
					pointer= pointer.getParent();
					depth--;
				}
				pointer.tail();
				// last visit
				if(pointer==root) {
					break;
				}else {
					pointer = pointer.getNextSibiling();
				}
			}
		}
	}
	
	public void head() {
		System.out.println("first " + this.val);
	}
	
	public void tail() {
		System.out.println("last " + this.val);
	}
	
	public List<Node> getChildren() {
		return children;
	}

	public String getVal() {
		return val;
	}

	public void setVal(String val) {
		this.val = val;
	}

	public int getSiblingIndex() {
		return siblingIndex;
	}

	public void setSiblingIndex(int sibilingIndex) {
		this.siblingIndex = sibilingIndex;
	}

	public Node getParent() {
		return parent;
	}
	public void setParent(Node parent) {
		this.parent = parent;
	}
	
	
}
