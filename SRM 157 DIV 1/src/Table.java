import java.util.ArrayList;
import java.util.List;

public class Table {

    private class Cell {
        private int colSpan;
        private int rowSpan;
        private char value;

        public Cell(String s) {

            if ((s == null) || (s.length() == 0)) {
                this.colSpan = 0;
                this.rowSpan = 0;
                this.value = 0;
            } else {
                s = s.replaceAll("[()]", "");  // Remove parentheses
                String[] elements = s.split(",");
                this.colSpan = Integer.parseInt(elements[0]);
                this.rowSpan = Integer.parseInt(elements[1]);
                this.value = elements[2].charAt(0);
            }
        }
    }

    int tableWidth;
    List<char[]> table = new ArrayList<>();

    public String[] layout(String[] tbl) {

        tableWidth = calcTableWidth(tbl);

        for (int row = 0; row < tbl.length; row++) {

            // Add new row if necessary.
            while (table.size() <= row) {
                table.add(row, new char[tableWidth]);
            }

            // Skip over any empty rows.
            if (isRowEmpty(tbl[row])) continue;

            int col = 0;

            Cell[] cells = parseCells(tbl[row]);

            for (int i = 0; i < cells.length; i++) {

                // Skip over any columns that are already occupied.
                col = getNextOpenCol(row, col);

                // Write the cell's value into all locations that it occupies.
                for (int r = 0; r < cells[i].rowSpan; r++) {
                    for (int c = 0; c < cells[i].colSpan; c++) {
                        tableInsert(row + r, col + c, cells[i].value);
                    }
                }
            }
        }

        return tableToArray();
    }

    private int calcTableWidth(String[] s) {

        for (int i = 0; i < s.length; i++) {

            if (isRowEmpty(s[i])) {
                continue;

            } else {

                // Add up all the colSpans and return the sum.
                Cell[] cells = parseCells(s[i]);

                int width = 0;

                for (Cell c : cells) {
                    width += c.colSpan;
                }

                return width;
            }
        }

        return 0;
    }

    private void tableInsert(int row, int col, char value) {

        // Add additional rows if necessary.
        while (table.size() <= row) {
            table.add(row, new char[tableWidth]);
        }

        table.get(row)[col] = value;
    }

    private int getNextOpenCol(int row, int col) {

        while (table.get(row)[col] != 0) {
            col++;
        }

        return col;
    }

    private String[] tableToArray() {

        String[] ret = new String[table.size()];

        for (int i = 0; i < table.size(); i++) {
            ret[i] = new String(table.get(i));
        }

        return ret;
    }

    private Cell[] parseCells(String s) {

        // Split on )(
        String[] elements = s.split("\\)\\(");

        Cell[] cells = new Cell[elements.length];

        for (int i = 0; i < elements.length; i++) {
            cells[i] = new Cell(elements[i]);
        }

        return cells;

    }

    // Consider a row empty if it does not contain any parenthesis.
    private boolean isRowEmpty(String s) {
        return !s.contains("(");
    }
}
