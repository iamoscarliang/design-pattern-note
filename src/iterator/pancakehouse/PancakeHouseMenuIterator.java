package iterator.pancakehouse;

import iterator.MenuItem;
import iterator.MenuIterator;

import java.util.List;

public class PancakeHouseMenuIterator implements MenuIterator {

    private final List<MenuItem> mMenuItems;

    private int position = 0;

    public PancakeHouseMenuIterator(List<MenuItem> menuItems) {
        mMenuItems = menuItems;
    }

    @Override
    public boolean hasNext() {
        return position < mMenuItems.size() && mMenuItems.get(position) != null;
    }

    @Override
    public MenuItem next() {
        return mMenuItems.get(position++);
    }

}
