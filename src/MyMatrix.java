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



    public  MyMatrix getFullRowsMatrix(){

        MyMatrix fullRowsMatrix =this.copy();

        for (int i = 0; i < fullRowsMatrix.getRows().getSize(); i++) {
            if (fullRowsMatrix.getRows().getElement(i).getColumns().getSize()!=columnNumbs){
                for (int j = 0; j < fullRowsMatrix.getRows().getElement(i).getColumns().getSize(); j++) {
                    fullRowsMatrix.getRows().getElement(i).getColumns().getElement(j).setValue(0);
                }
            }
        }

        return fullRowsMatrix;
    }


    public MyMatrix copy(){
        MyLinkedList<Row> rows = new MyLinkedList<>();
        for (int i = 0; i < this.getRows().getSize(); i++) {
            rows.addElement(this.getRows().getElement(i).copy());
        }
        MyMatrix copy =new MyMatrix(rowNumbs,columnNumbs,rows);
        return copy;
    }



    public static MyMatrix multiplyMatrix(MyMatrix matrix1 , MyMatrix matrix2){
        MyMatrix result =new MyMatrix();
        return result;
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
