import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;

public class DirectoryTreeView extends JFrame {
    private JTree tree;
    private JButton saveButton;
    private JButton newButton;
    private JTextArea textArea;

    public DirectoryTreeView(DefaultMutableTreeNode root) {
        tree = new JTree(root);
        tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(tree);
        setLayout(new BorderLayout());
        newButton = new JButton("New File");
        saveButton = new JButton("Save");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(newButton);
        buttonPanel.add(saveButton);
        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        textArea = new JTextArea();
        JScrollPane textScrollPane = new JScrollPane(textArea);
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, tree, textScrollPane);
        add(splitPane, BorderLayout.CENTER);
    }

    public JTree getTree() {
        return tree;
    }

    public JTextArea getTextArea() {
        return textArea;
    }

    public void addNewButtonListener(ActionListener actionListener) {
        newButton.addActionListener(actionListener);
    }

    public void addSaveButtonListener(ActionListener actionListener) {
        saveButton.addActionListener(actionListener);
    }

}
