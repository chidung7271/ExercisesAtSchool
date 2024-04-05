import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;

public class DirectoryTreeModel {

    public DefaultMutableTreeNode createNodes(Path directoryPath) throws IOException {
        DefaultMutableTreeNode root = new DefaultMutableTreeNode(directoryPath.toString());
        return createTreeNode(root,directoryPath);
    }

    private DefaultMutableTreeNode createTreeNode(DefaultMutableTreeNode currentNode ,Path file) throws IOException {
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(file)) {
            for (Path entry : stream) {
                if (Files.isDirectory(entry)) {
                    DefaultMutableTreeNode subNode = new DefaultMutableTreeNode(entry.getFileName().toString());
                    currentNode.add(subNode);
                    createTreeNode(subNode, entry);
                } else {
                    DefaultMutableTreeNode node = new DefaultMutableTreeNode(entry.getFileName().toString());
                    currentNode.add(node);
                }
            }
        }
        return currentNode;
    }


    public void readFile(DirectoryTreeView view , File file) {
        StringBuilder contentBuilder = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                contentBuilder.append(line).append("\n");
            }
            view.getTextArea().setText(contentBuilder.toString());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, "Cannot read file: " + e.getMessage());
        }
    }
    public void writeFile(String link, String content){
            Path path = Paths.get(link);
            try {
                Files.write(path, content.getBytes());
                
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
