package iterator.stackhouse;

import iterator.Menu;
import iterator.MenuItem;
import iterator.MenuIterator;

public class StackHouseMenu implements Menu {

    private static final int MAX_ITEMS = 2;

    private int mItemCount = 0;
    private final MenuItem[] mMenuItems = new MenuItem[MAX_ITEMS];

    public StackHouseMenu() {
        mMenuItems[0] = new MenuItem("Fillet Steak", 20.99);
        mMenuItems[1] = new MenuItem("New York Steak", 15.99);
    }

    @Override
    public MenuIterator createIterator() {
        return new StackHouseMenuIterator(mMenuItems);
    }

}
