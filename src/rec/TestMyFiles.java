package rec;

public class TestMyFiles {

    public static void main(String[] args) {
        // Create individual files
        FileSystemComponent file1 = new MyFile("photo.jpg", 5);
        FileSystemComponent file2 = new MyFile("song.mp3", 7);
        FileSystemComponent file3 = new MyFile("document.pdf", 3);
        FileSystemComponent file4 = new MyFile("movie.mp4", 1200);

        // Create media Folder
        MyFolder mediaFolder = new MyFolder("Media");
        mediaFolder.addComponent(file1);
        mediaFolder.addComponent(file2);

        // Create documents MyFolder
        MyFolder docsFolder = new MyFolder("Documents");
        docsFolder.addComponent(file3);

        // Create root MyFolder and nest other MyFolders inside it
        MyFolder rootFolder = new MyFolder("Root");
        rootFolder.addComponent(mediaFolder); // Nested MyFolder
        rootFolder.addComponent(docsFolder);  // Nested MyFolder
        rootFolder.addComponent(file4);       // Loose file in root

        // Print results
        System.out.println("Media MyFolder size: " + mediaFolder.getSize() + "MB (Expected: 12)");
        System.out.println("Root MyFolder size: " + rootFolder.getSize() + "MB (Expected: 1215)");
    }


}
