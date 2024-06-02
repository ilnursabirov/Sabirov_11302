package hw4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

class Node {
    String tag;
    String text;
    Node parent;
    List<Node> children;
    Map<String, String> attr;
    public Node(){
        this(null, null);
    }
    public Node(String tag, String text){
        this.tag = tag;
        this.text = text;
        children = new ArrayList<>();
        attr = new HashMap<>();
    }
    public void addChild(Node child) {
        child.parent = this;
        this.children.add(child);
    }
}



public class ParsTree {
    private Node root;
    String meta;
    public ParsTree(String file) {
        this.root = new Node("html", null);
        StringBuilder allHTML = new StringBuilder();

        try (BufferedReader bw = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = bw.readLine()) != null) {
                allHTML.append(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Stack<Node> stack = new Stack<>();
        stack.add(root);

        while (allHTML.length() > 0) {
            String tag = null;

            if (allHTML.toString().contains(">")) {
                tag = allHTML.substring(allHTML.indexOf("<") + 1, allHTML.indexOf(">"));
                allHTML.delete(allHTML.indexOf("<"), allHTML.indexOf(">"));
            } else {
                allHTML.setLength(0);
                break;
            }
            String text = null;

            if (allHTML.indexOf(">") - allHTML.indexOf("<") < 0) {
                text = allHTML.substring(allHTML.indexOf(">")+1, allHTML.indexOf("<"));
            }

            allHTML.delete(allHTML.indexOf(">"), allHTML.indexOf(">")+1);
            if (tag.contains("meta")){
                this.meta = tag;
                continue;
            }

            if (tag.charAt(0) != '/') {
                Node newNode = new Node(tag, text);
                stack.add(newNode);
            } else {
                if (!tag.contains(" ")) {
                    if (tag.contains(stack.peek().tag) || stack.peek().tag.contains(tag.replaceAll("/", ""))) {
                        Node node = stack.pop();
                        if (!stack.isEmpty()) {
                            stack.peek().addChild(node);
                            node.parent = stack.peek();
                        }
                    }
                } else {
                    if (tag.replaceAll(" ", "").contains(stack.peek().tag)
                            || stack.peek().tag.contains(tag.replaceAll(" ", "").replaceAll("/", ""))) {
                        Node node = stack.pop();
                        if (!stack.isEmpty()) {
                            stack.peek().addChild(node);
                            node.parent = stack.peek();
                        }
                    }
                }
            }
        }
    }

    public Node getRoot(){
        return root;
    }

    public void pass(Node root){
        System.out.println(root.text);
        if (!root.children.isEmpty()) {
            for (int j = 0; j < root.children.size(); j++) {
                pass(root.children.get(j));
            }
        }
    }

    public static void main(String[] args) {
        ParsTree tree = new ParsTree("src/hw4/html.html");

        tree.pass(tree.getRoot());
    }
}
