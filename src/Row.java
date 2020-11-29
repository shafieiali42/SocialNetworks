public class Row {

    private int rowIndex;
    private MyLinkedList<Column> columns;
    private String rowName;

    public Row(int rowIndex,MyLinkedList<Column> columns,String rowName){
        this.rowIndex=rowIndex;
        this.columns=columns;
        this.rowName=rowName;
    }


    @Override
    public String toString() {
        return "[  rowNumber: "+rowIndex+"   " + columns +" ]";
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
