import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class FirstGui extends JFrame {
    private String path;
    private Path link;
    public Path Data() {
        while (true) {
            
        
        path = JOptionPane.showInputDialog(this, "Nhập đường link folder muốn mở");
        try {
            if(path == null){
                System.exit(0);
            }
            else if (path.trim().isEmpty()){
                JOptionPane.showMessageDialog(this, "Phải nhập path mới chạy");
            }
            else{
                path = path.replace("\\","/");
                link = Paths.get(path);
                boolean pathExists = Files.exists(link);
                if (pathExists) {
                    return link;
                } else {
                    JOptionPane.showMessageDialog(this, "Không tồn tại");
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Phải nhập path mới chạy");
        }
    }}

    public String NewFilePath(){
        String path = JOptionPane.showInputDialog(this, "Nhập tên file");
        return path;
    }

    public String getPath() {
        return path;
    }
    public Path getLink(){
        return link;
    }
}
    