package main;

import main.jjtree.*;

import java.io.FileWriter;
import java.io.IOException;

public class DotGenerator {
    private final StringBuilder dotGraph = new StringBuilder("digraph ASTGraph {\n");

    public void generateDot(SimpleNode root) {
        visit(root, null);
        dotGraph.append("}");
    }

    private void visit(SimpleNode node, SimpleNode parent) {
        if (node == null) {
            System.out.println("DotGenerator node null");
            return;
        }

        int nodeId = System.identityHashCode(node);
        dotGraph.append("  Node").append(nodeId)
                .append(" [label=\"").append(node.toString()).append("\"];\n");

        if (parent != null) {
            int parentId = System.identityHashCode(parent);
            dotGraph.append("  Node").append(parentId)
                    .append(" -> Node").append(nodeId).append(";\n");
        }

        for (int i = 0; i < node.jjtGetNumChildren(); i++) {
            visit((SimpleNode) node.jjtGetChild(i), node);
        }
    }

    public void getDotGraph() {
        String content = dotGraph.toString();

        try (FileWriter fileWriter = new FileWriter("graph.dot")) {
            fileWriter.write(content);

        } catch (IOException e) {
            System.out.println("wtf " + content);

            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}
