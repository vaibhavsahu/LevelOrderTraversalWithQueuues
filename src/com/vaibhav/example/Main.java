package com.vaibhav.example;


import java.util.*;

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }

     public static List<List<Integer>> levelOrderTraversal(TreeNode root){
         Queue<TreeNode> currentQueue = new LinkedList<>();
         Queue<TreeNode> nextQueue = new LinkedList<>();

         List<List<Integer>> levelOrder = new ArrayList<>();

         currentQueue.add(root);
         List<Integer> list1 = new ArrayList<>();
         levelOrder.add(Arrays.asList(root.val));


         while(!currentQueue.isEmpty()){
             TreeNode temp = currentQueue.remove();
             if(temp != null){
                 if(temp.left != null){
                     nextQueue.add(temp.left);
                     list1.add(temp.left.val);
                 }
                 if(temp.right != null){
                     nextQueue.add(temp.right);
                     list1.add(temp.right.val);
                 }
                 if(currentQueue.isEmpty()){
                     if(!list1.isEmpty()){
                         levelOrder.add(list1);
                     }
                     list1 = new ArrayList<>();
                     //copy elements of nextQueue to currentQueue
                     currentQueue.addAll(nextQueue);
                     nextQueue = new LinkedList<>();
                 }
             }

         }
         return levelOrder;
     }

     public static List<Integer> getLeftView(TreeNode root){
         List<List<Integer>> levelOrder = TreeNode.levelOrderTraversal(root);
         List<Integer> leftView =new ArrayList<>();

         levelOrder.stream().forEach( list -> leftView.add(list.get(0)));
         return leftView;
     }

    public static List<Integer> getRightView(TreeNode root){
        List<List<Integer>> levelOrder = TreeNode.levelOrderTraversal(root);
        List<Integer> rightView =new ArrayList<>();

        levelOrder.stream().forEach( list -> rightView.add(list.get(list.size()-1)));
        return rightView;
    }
 }


public class Main {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        System.out.println(TreeNode.getLeftView(root));
        System.out.println(TreeNode.getRightView(root));

    }
}
