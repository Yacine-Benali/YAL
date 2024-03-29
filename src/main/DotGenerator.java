package main;

import main.jjtree.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class DotGenerator {
    private final StringBuilder dotGraph = new StringBuilder("digraph ASTGraph {\n");
    private File outputFile;

    public DotGenerator(String inputFilePath)
    {
        File inputFile = new File(inputFilePath);
        File parentDir = inputFile.getParentFile();

        // New file name (example: newfile.txt)
        String newFileName = "graph.dot";
        File newFile = new File(parentDir, newFileName);
        this.outputFile = newFile;
    }

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

        try (FileWriter fileWriter = new FileWriter(outputFile.getPath())) {
            fileWriter.write(content);

        } catch (IOException e) {

            System.err.println("getDotGraph Error writing to file: " + e.getMessage());
        }
    }
}
