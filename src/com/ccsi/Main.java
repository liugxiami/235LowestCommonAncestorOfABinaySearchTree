package com.ccsi;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

public class Main {

    public static void main(String[] args) {
	    TreeNode root=buildTree();
        TreeNode res=lowestCommonAncestor2(root,new TreeNode(0),new TreeNode(3));
        System.out.println(res.val);
    }
    //Given a binary search tree(BST),find the lowest common ancestor(LCA)of two given
    //Nodes in the BST.
    //According to the definition of LCA on wikipedia,"The lowest common ancestor is defined
    //between two nodes v and w as the lowest node in T that has both v and w as descendants
    //(where we allow a node to be descendant of itself)."
    //1.recursion
    public static TreeNode lowestCommonAncestor1(TreeNode root,TreeNode p,TreeNode q){
        if(root==null||p==null||q==null) return null;
        TreeNode curr=root;   //此步多余，可以直接用root；
        if(curr.val>p.val&&curr.val>q.val) return lowestCommonAncestor1(curr.left,p,q);
        else if(curr.val<q.val&&curr.val<q.val)return lowestCommonAncestor1(curr.right,p,q);
        else return curr;
    }
    //2.loop
    public static TreeNode lowestCommonAncestor2(TreeNode root,TreeNode p,TreeNode q){
        if(root==null||p==null||q==null) return null;
        TreeNode curr=root;
        while(curr!=null){
            if(curr.val>p.val&&curr.val>q.val)curr=curr.left;  //p,q大小未知，所以都需判断
            else if(curr.val<q.val&&curr.val<q.val)curr=curr.right;
            else return curr;
        }
        return null;
    }
    public static TreeNode buildTree(){
        TreeNode root=new TreeNode(6);
        root.left=new TreeNode(2);
        root.right=new TreeNode(8);
        root.left.left=new TreeNode(0);
        root.left.right=new TreeNode(4);
        root.right.left=new TreeNode(7);
        root.right.right=new TreeNode(9);
        root.left.right.left=new TreeNode(3);
        root.left.right.right=new TreeNode(5);
        return root;
    }
}
class TreeNode{
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
