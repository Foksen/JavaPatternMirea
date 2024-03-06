package Adapter;

public class Table {
    private int rows;
    private int cols;
    private String[][] fields;

    public Table(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.fields = new String[rows][cols];
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public String getField(int row, int col) {
        return fields[row][col];
    }

    public void setField(int row, int col, String field) {
        fields[row][col] = field;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("-".repeat(1 + cols * 19)).append('\n');
        for (String[] row : fields) {
            builder.append('|');
            for (String field : row) {
                builder.append(String.format(" %-16s ", field));
                builder.append('|');
            }
            builder.append('\n');
        }
        builder.append("-".repeat(1 + cols * 19));
        return builder.toString();
    }
}
