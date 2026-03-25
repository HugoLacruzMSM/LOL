package hugo.lol.entity.inventory.grid;

import hugo.lol.entity.inventory.InventoryCell;
import hugo.lol.entity.inventory.Position;
import hugo.lol.entity.item.Item;
import java.util.List;

public class InventoryGrid {

    private final InventoryCell[][] cells;
    private final int rows;
    private final int cols;

    public InventoryGrid(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.cells = new InventoryCell[rows][cols];
        initCells();
    }

    private void initCells() {
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < cols; column++) {
                cells[row][column] = new InventoryCell();
            }
        }
    }

    public boolean autoPlace(Item item) {
        for (int ror = 0; ror < rows; ror++) {
            for (int column = 0; column < cols; column++) {
                if (tryPlace(item, ror, column)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean tryPlace(Item item, int startRow, int startCol) {
        List<Position> region = item.getOccupiedCells(startRow, startCol);
        if (!fitsInBounds(region) || !regionIsFree(region)){
            return false;
        }
        fillRegion(region, item);
        return true;
    }

    public Item removeAt(int row, int col) {
        if (!isValid(row, col) || !cellAt(row, col).isOccupied()) return null;
        Item item = cellAt(row, col).peek();
        clearRegion(item.getOccupiedCells(row, col));
        return item;
    }

    public Item peek(int row, int col) {
        if (!isValid(row, col)) return null;
        return cellAt(row, col).peek();
    }

    public int getRows() { return rows; }
    public int getCols() { return cols; }

    private boolean fitsInBounds(List<Position> region) {
        for (Position pos : region) {
            if (!isValid(pos.getRow(), pos.getCol())){
                return false;
            }
        }
        return true;
    }

    private boolean regionIsFree(List<Position> region) {
        for (Position pos : region) {
            if (cellAt(pos.getRow(), pos.getCol()).isOccupied()){
                return false;
            }
        }
        return true;
    }

    private void fillRegion(List<Position> region, Item item) {
        for (Position pos : region) {
            cellAt(pos.getRow(), pos.getCol()).place(item);
        }
    }

    private void clearRegion(List<Position> region) {
        for (Position pos : region) {
            cellAt(pos.getRow(), pos.getCol()).remove();
        }
    }

    private InventoryCell cellAt(int row, int col) {
        return cells[row][col];
    }

    private boolean isValid(int row, int col) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }

    public void print() {
        System.out.println("=== Inventory Grid ===");
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < cols; column++) {
                Item item = cellAt(row, column).peek();
                System.out.printf("%-20s", item == null ? "[ ]" : "[" + item.getName() + "]");
            }
            System.out.println();
        }
    }
}