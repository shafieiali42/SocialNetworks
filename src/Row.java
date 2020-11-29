public class Row {

    private int rowIndex;
    private MyLinkedList<Column> columns;
    private String rowName;

    public Row(int rowIndex, MyLinkedList<Column> columns, String rowName) {
        this.rowIndex = rowIndex;
        this.columns = columns;
        this.rowName = rowName;
    }

    public Row() {

    }


    public static Row add(Row row1, Row row2, MyLinkedList<String> columnsName) {
        Row row = new Row();
        row.setRowName(row1.getRowName());
        MyLinkedList<Column> columns = new MyLinkedList<>();

        for (int i = 0; i < columnsName.getSize(); i++) {
            Column column = new Column(i, 0, columnsName.getElement(i));

            for (int k = 0; k < row2.getColumns().getSize(); k++) {
                if (row2.getColumns().getElement(k).getColumnName().equals(columnsName.getElement(i))) {
                    column.setValue(column.getValue()+row2.getColumns().getElement(k).getValue());
                }
            }

            for (int k = 0; k < row1.getColumns().getSize(); k++) {
                if (row1.getColumns().getElement(k).getColumnName().equals(columnsName.getElement(i))) {
                    column.setValue(column.getValue()+row1.getColumns().getElement(k).getValue());
                }
            }

            if (column.getValue() != 0) {
                columns.addElement(column);
            }
        }

        row.setColumns(columns);
        return row;
    }


    @Override
    public String toString() {
        return "[  rowNumber: " + rowIndex + "   " + columns + " ]";
    }

    public int getRowIndex() {
        return rowIndex;
    }

    public void setRowIndex(int rowIndex) {
        this.rowIndex = rowIndex;
    }

    public MyLinkedList<Column> getColumns() {
        return columns;
    }

    public void setColumns(MyLinkedList<Column> columns) {
        this.columns = columns;
    }

    public String getRowName() {
        return rowName;
    }

    public void setRowName(String rowName) {
        this.rowName = rowName;
    }
}
