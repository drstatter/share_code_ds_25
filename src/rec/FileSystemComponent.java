package rec;

public interface FileSystemComponent {
    // Returns the name of the file or folder
    String getName();

    // Returns the total size of the component in MB
    int getSize();
}
