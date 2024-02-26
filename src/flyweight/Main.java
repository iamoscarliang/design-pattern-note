package flyweight;

public class Main {

    public static void main(String[] args) {
        LeafFactory factory = new LeafFactory();

        // Create a tree with some green leaves
        Tree greenTree = new Tree(100, 100);
        for (int i = 0; i < 3; i++) {
            greenTree.addLeaf(factory.createLeaf("green"));
            greenTree.addLeaf(factory.createLeaf("dark green"));
        }

        // Create a tree with some yellow leaves
        Tree yellowTree = new Tree(200, 300);
        for (int i = 0; i < 4; i++) {
            yellowTree.addLeaf(factory.createLeaf("yellow"));
            yellowTree.addLeaf(factory.createLeaf("orange"));
        }

        greenTree.display();
        yellowTree.display();
    }

}
