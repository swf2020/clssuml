package com.alibaba;// 本题为考试多行输入输出规范示例，无需提交，不计分。

import com.sun.org.apache.xerces.internal.xs.datatypes.ObjectList;

import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        int a = rectCover(4);
        System.out.println(a);
        int b = rectCover1(4);
        System.out.println(b);
    }

    


    public static int rectCover(int target) {
        int[] dp = new int[target + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= target; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[target];
    }

    public static int rectCover1(int target) {
        int pre1 = 1;
        int pre2 = 2;

        for (int i = 3; i <= target; i++) {
            int temp = pre1 + pre2;
            pre1 = pre2;
            pre2 = temp;
        }

        return pre2;
    }



    class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(int val) {
            this.val = val;
        }
    }

    StringBuffer sb = new StringBuffer();
    private String Serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        Serialize(root, sb);
        return sb.toString();
    }

    private void Serialize(TreeNode node, StringBuffer sb) {
        if (node == null) {
            sb.append("#,");
            return;
        }
        sb.append(node.val);
        sb.append(",");
        Serialize(node.left, sb);
        Serialize(node.right, sb);
    }

    private TreeNode DeSerialize(String res) {
        String[] rest = res.split(",");
        return DeSerialize(rest);

    }

    private int index = -1;
    private TreeNode DeSerialize(String[] rest) {
        index++;
        if (rest[index] != "#") {
            TreeNode node = new TreeNode(Integer.parseInt(rest[index]));
            node.left = DeSerialize(rest);
            node.right = DeSerialize(rest);
            return node;
        }
        return null;
    }


}