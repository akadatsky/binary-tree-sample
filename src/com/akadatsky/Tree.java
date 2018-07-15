package com.akadatsky;

import java.util.ArrayList;
import java.util.List;

public class Tree {

    private Entry root;

    public void add(int value) {
        Entry entry = new Entry();
        entry.value = value;
        if (root == null) {
            root = entry;
        } else {
            addToTree(root, entry);
        }
    }

    private void addToTree(Entry root, Entry entry) {
        if (entry.value < root.value) {
            if (root.left == null) {
                root.left = entry;
            } else {
                addToTree(root.left, entry);
            }
        } else if (entry.value > root.value) {
            if (root.right == null) {
                root.right = entry;
            } else {
                addToTree(root.right, entry);
            }
        }
    }

    private List<Integer> createList() {
        List<Integer> list = new ArrayList<>();
        addToList(root, list);
        return list;
    }

    private void addToList(Entry root, List<Integer> list) {
        if (root == null) {
            return;
        }
        addToList(root.left, list);
        list.add(root.value);
        addToList(root.right, list);
    }

    @Override
    public String toString() {
        List<Integer> list = createList();
        StringBuilder result = new StringBuilder("Tree{");
        boolean firstAdded = false;
        for (Integer value : list) {
            if (firstAdded) {
                result.append(", ");
            } else {
                firstAdded = true;
            }
            result.append(String.valueOf(value));
        }
        return result.append("}").toString();
    }

    public void print() {
        BTreePrinter.printNode(root);
    }
}
