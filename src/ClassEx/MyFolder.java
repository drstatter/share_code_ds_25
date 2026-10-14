package ClassEx;

import java.util.ArrayList;
import java.util.List;

class MyFolder implements FileSystemComponent {
    private String name;
    private List<FileSystemComponent> components;

    public MyFolder(String name) {
        this.name = name;
        this.components = new ArrayList<FileSystemComponent>();
    }

    public void addComponent(FileSystemComponent component) {
        components.add(component);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        int totalSize = 0;

        // RECURSION: We iterate through the interface type.
        // If a component is a File, it returns its size immediately.
        // If a component is another Folder, it calls this exact getSize() method recursively.
        for (FileSystemComponent component : components) {
            totalSize += component.getSize();
        }

        return totalSize;
    }
}