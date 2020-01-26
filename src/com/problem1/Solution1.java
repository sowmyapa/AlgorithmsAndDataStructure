package com.problem1;

import java.util.*;

class TreeNode {
    String pathElem = "";
    Map<String, TreeNode> children;

    String nSpaces(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append(" ");
            n--;
        }
        return sb.toString();
    }

    void prettyPrint(int indent) {
        prettyPrint(indent, true);
    }

    void prettyPrint(int indent, boolean newLine) {
        if (pathElem.trim() != "") {
            System.out.print(nSpaces(indent) + "/" + pathElem);
        } else {
            indent -= 2;
        }
        if (children == null) return;
        int numChildren = children.entrySet().size();
        if (numChildren == 1) {
            TreeNode onlyChild = children.values().iterator().next();
            onlyChild.prettyPrint(0, false);
            return;
        } else if (numChildren > 1) {
            for (TreeNode child : children.values()) {
                System.out.println();
                child.prettyPrint(indent + 2, false);
            }
        }
        if (newLine) {
            System.out.println();
        }
    }
}


public class Solution {
    public static void main(String[] args) {
        String[] input = new String[] {
                "/a/b/c/d",
                "/a/b/f",
                "/a/c/m",
                "/b/b/f"
        };
        makeTree(input).prettyPrint(0);

        input = new String[] {
                "/x"
        };
        makeTree(input).prettyPrint(0);

        input = new String[] {
                "/x",
                "/y"
        };
        makeTree(input).prettyPrint(0);

        input = new String[] {
                "/a/b/c/d",
                "/a/b/f",
                "/a/c/m"
        };
        makeTree(input).prettyPrint(0);
    }

    public static TreeNode makeTree(String[] paths) {
        TreeNode root = new TreeNode();
        for (String str : paths) {
            StringTokenizer st = new StringTokenizer(str, "/");
            TreeNode traverse = root;
            while (st.hasMoreTokens()) {
                String next = st.nextToken();
                if (traverse.children == null) {
                    traverse.children = new HashMap<String, TreeNode>();
                }
                TreeNode child = traverse.children.get(next);
                if (child == null) {
                    child = new TreeNode();
                    child.pathElem = next;
                    traverse.children.put(next, child);
                }
                traverse = child;
            }
        }
        return root;
    }
}