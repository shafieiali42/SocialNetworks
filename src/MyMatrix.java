public class MyMatrix {

    private int rowNumbs;
    private int columnNumbs;

    private MyLinkedList<Row> rows;



    public MyMatrix(){

    }

    public MyMatrix(int rowNumbs,int columnNumbs,MyLinkedList<Row> rows){
        this.rowNumbs=rowNumbs;
        this.columnNumbs=columnNumbs;
        this.rows=rows;
    }


    @Override
    public String toString() {
        return "{ "+rows+" }";
    }

    public int getRowNumbs() {
        return rowNumbs;
    }

    public void setRowNumbs(int rowNumbs) {
        this.rowNumbs = rowNumbs;
    }

    public int getColumnNumbs() {
        return columnNumbs;
    }

    public void setColumnNumbs(int columnNumbs) {
        this.columnNumbs = columnNumbs;
    }

    public MyLinkedList<Row> getRows() {
        return rows;
    }

    public void setRows(MyLinkedList<Row> rows) {
        this.rows = rows;
    }
}
