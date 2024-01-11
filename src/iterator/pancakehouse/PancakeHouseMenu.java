package iterator.pancakehouse;

import iterator.Menu;
import iterator.MenuItem;
import iterator.MenuIterator;

import java.util.ArrayList;
import java.util.List;

public class PancakeHouseMenu implements Menu {

    private final List<MenuItem> mMenuItems = new ArrayList<>();

    public PancakeHouseMenu() {
        mMenuItems.add(new MenuItem("Blueberry Pancake", 3.49));
        mMenuItems.add(new MenuItem("Waffle", 3.59));
    }

    @Override
    public MenuIterator createIterator() {
        return new PancakeHouseMenuIterator(mMenuItems);
    }

}
