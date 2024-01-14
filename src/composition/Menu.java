package composition;

import java.util.ArrayList;
import java.util.List;

public class Menu extends MenuComponent {

    private String mName;

    private final List<MenuComponent> mComponents = new ArrayList<>();

    public Menu(String name) {
        mName = name;
    }

    @Override
    public void add(MenuComponent component) {
        mComponents.add(component);
    }

    @Override
    public void remove(MenuComponent component) {
        mComponents.remove(component);
    }

    @Override
    public MenuComponent getChild(int i) {
        return mComponents.get(i);
    }

    @Override
    public String getName() {
        return mName;
    }

    @Override
    public void print() {
        System.out.println(mName);
        System.out.println("-----------------");
        for (MenuComponent component : mComponents) {
            component.print();
        }
    }

}
