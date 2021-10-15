package com.greatlearning.Assignment3.BstToSkewed;

class Node
{
    int data;
    Node left, right;
    
   

    Node(int value)
    {
        data = value;
        left = null;
        right=null;
    }
}
class BinaryTreeRightSkewedTree
{
    public static Node node;
    static Node prevNode = null;
    static Node headNode = null;
   
  
    static void BTToSkewed(Node root)
    {
       
        
        if(root == null)
        {
            return;
        }
      
       BTToSkewed(root.left);
       
        Node rightNode = root.right;
       
        if(headNode == null)
        {
            headNode = root;
            root.left = null;
            prevNode = root;
        }
        else
        {
            prevNode.right = root;
            root.left = null;
            prevNode = root;
        }
       
       
           BTToSkewed(rightNode);
        
       
    }
   
 
    static void traverseRightSkewed(Node root)
    {
        if(root == null)
        {
            return;
        }
        System.out.print(root.data + " ");
        traverseRightSkewed(root.right);       
    }
   
    
    public static void main (String[] args)
    {
     
    	
        BinaryTreeRightSkewedTree.node = new Node(50);
        BinaryTreeRightSkewedTree.node.left = new Node(30);
        BinaryTreeRightSkewedTree.node.right = new Node(60);
        BinaryTreeRightSkewedTree.node.left.left = new Node(10);
        BinaryTreeRightSkewedTree.node.left.right = new Node(40);
   
        BTToSkewed(node);
        traverseRightSkewed(headNode);
    }
}
 