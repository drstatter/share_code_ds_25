package ClassEx;

// 1. File class representing individual files
class MyFile implements FileSystemComponent {
    private String name;
    private int size;

    public MyFile(String name, int size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        // Base case scenario: A file has a fixed size and no nested elements
        return size;
    }
}
