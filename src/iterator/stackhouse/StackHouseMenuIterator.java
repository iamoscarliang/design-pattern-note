package iterator.stackhouse;

import iterator.MenuItem;
import iterator.MenuIterator;

public class StackHouseMenuIterator implements MenuIterator {

    private final MenuItem[] mMenuItems;

    private int position = 0;

    public StackHouseMenuIterator(MenuItem[] menuItems) {
        mMenuItems = menuItems;
    }

    @Override
    public boolean hasNext() {
        return position < mMenuItems.length && mMenuItems[position] != null;
    }

    @Override
    public MenuItem next() {
        return mMenuItems[position++];
    }

}
