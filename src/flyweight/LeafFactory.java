package flyweight;

import java.util.HashMap;
import java.util.Map;

public class LeafFactory {

    private final Map<String, Leaf> mLeaves = new HashMap<>();

    public Leaf createLeaf(String color) {
        if (mLeaves.containsKey(color)) {
            return mLeaves.get(color);
        } else {
            Leaf leaf = new Leaf(color);
            mLeaves.put(color, leaf);
            return leaf;
        }
    }

}
