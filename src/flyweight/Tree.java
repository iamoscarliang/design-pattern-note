package flyweight;

import java.util.ArrayList;
import java.util.List;

public class Tree {

    private float mX;
    private float mY;

    private final List<Leaf> mLeaves = new ArrayList<>();

    public Tree(float x, float y) {
        mX = x;
        mY = y;
    }

    public float getX() {
        return mX;
    }

    public void setX(float x) {
        mX = x;
    }

    public float getY() {
        return mY;
    }

    public void setY(float y) {
        mY = y;
    }

    public void addLeaf(Leaf leaf) {
        mLeaves.add(leaf);
    }

    public void display() {
        System.out.println("Display a tree at (" + mX + ", " + mY + "), with " + mLeaves);
    }

}
