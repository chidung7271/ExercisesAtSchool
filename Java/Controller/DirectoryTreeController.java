import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

public class DirectoryTreeController {
    private DirectoryTreeView view;
    private DirectoryTreeModel model;
    private String link;
    private FirstGui data;
    private String dict;
    public DirectoryTreeController(DirectoryTreeModel model, DirectoryTreeView view, FirstGui data) {
        this.view = view;
        this.model = model;
        this.data = data;
        // this.textArea = new JTextArea();
        // JScrollPane textScrollPane = new JScrollPane(textArea);
        // JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, view.getTree(), textScrollPane);
        // view.add(splitPane, BorderLayout.CENTER);
        
        this.view.addSaveButtonListener(e -> SaveContent(link));
        this.view.addNewButtonListener(e -> NewFile() );
        view.getTree().addTreeSelectionListener(e->
            // new TreeSelectionListener() {
            // public void valueChanged(TreeSelectionEvent e)
            {
        
                
                DefaultMutableTreeNode node = (DefaultMutableTreeNode) view.getTree().getLastSelectedPathComponent();
                link = GetLink(node);
                if (node == null || link == null ) return;
                File file = new File(link);
                if (file.isFile()) {
                    model.readFile(view,file);
                }
                if(file.isDirectory()){
                    dict = file.getAbsolutePath();
                }
    
        });
    }
    
    
    // private void readFile(File file) {
    //     StringBuilder contentBuilder = new StringBuilder();

    //     try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
    //         String line;
    //         while ((line = reader.readLine()) != null) {
    //             contentBuilder.append(line).append("\n");
    //         }
    //         view.getTextArea().setText(contentBuilder.toString());
    //     } catch (Exception e) {
    //         JOptionPane.showMessageDialog(view, "Cannot read file: " + e.getMessage());
    //     }
    // }

    public void showView() {
        view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        view.setSize(800, 600);
        view.setVisible(true);
    }

    public String GetLink(DefaultMutableTreeNode selectedNode){
        if (selectedNode.isLeaf()) {
            TreePath treePath = new TreePath(selectedNode.getPath());
            String duongDan = "";
            for (Object node : treePath.getPath()) {
                duongDan +=  node.toString() + "/" ;
                duongDan = duongDan.replace("/", "\\");
            }
            return duongDan;
        } else {
            return null;
        }
    
    }

    private void SaveContent(String link) {
        
        model.writeFile(link, view.getTextArea().getText());
        view.getTree().updateUI();

    }

    private void NewFile() {
        if (dict == null){
            dict = data.getPath();
        }
        String FileNew = dict + "/" + data.NewFilePath();
        System.out.println(FileNew);
        try {
            File file = new File(FileNew); // Specify the file name with the desired path
            if (file.createNewFile()) {
                view.getTree().updateUI();

            }
        } catch (IOException e) {
            System.out.println("An error occurred. 💥");
            e.printStackTrace();
        }
    }

    }
    
