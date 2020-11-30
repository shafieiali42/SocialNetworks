import java.util.LinkedList;

public class MyMatrix {

    private int rowNumbs;
    private int columnNumbs;

    private MyLinkedList<Row> rows;


    public MyMatrix() {

    }

    public MyMatrix(int rowNumbs, int columnNumbs, MyLinkedList<Row> rows) {
        this.rowNumbs = rowNumbs;
        this.columnNumbs = columnNumbs;
        this.rows = rows;
    }


    public MyMatrix getFullRowsMatrix() {

        MyMatrix fullRowsMatrix = this.copy();

        for (int i = 0; i < fullRowsMatrix.getRows().getSize(); i++) {
            if (fullRowsMatrix.getRows().getElement(i).getColumns().getSize() != columnNumbs) {
                for (int j = 0; j < fullRowsMatrix.getRows().getElement(i).getColumns().getSize(); j++) {
                    fullRowsMatrix.getRows().getElement(i).getColumns().getElement(j).setValue(0);

                }
            }
        }

        return fullRowsMatrix;
    }


    public MyMatrix copy() {
        MyLinkedList<Row> rows = new MyLinkedList<>();
        for (int i = 0; i < this.getRows().getSize(); i++) {
            rows.addElement(this.getRows().getElement(i).copy());
        }
        MyMatrix copy = new MyMatrix(rowNumbs, columnNumbs, rows);
        return copy;
    }


//    public double multiplyList(MyLinkedList<Double> list1, MyLinkedList<Double> list2) {
//        double result=0d;
//
//
//
//
//
//    }


    public static MyMatrix multiplyMatrix(MyMatrix matrix1, MyMatrix matrix2,MyLinkedList<String> subjects) {
        MyMatrix result = new MyMatrix();
        MyLinkedList<Row> rowsOfResult =new MyLinkedList<>();
        for (int i = 0; i < matrix1.getRows().getSize(); i++) {
            Row row =new Row();
            row.setRowIndex(i);
            row.setRowName(matrix1.getRows().getElement(i).getRowName());
            MyLinkedList<Column> column = new MyLinkedList<>();
            row.setColumns(column);
            for (int j = 0; j < matrix2.getRows().getSize(); j++) {

                row =Row.add(row,matrix2.getRows().getElement(j).
                        multipleToNumber(matrix1.getRows().getElement(i).getColumnsValueWithIndex(j)),subjects);
            }
            row.setRowIndex(i);
            rowsOfResult.addElement(row);
        }
        result.setRows(rowsOfResult);
        return result;
    }


    @Override
    public String toString() {
        return "{ " + rows + " }";
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
