public class Column {

    private int columnIndex;
    private double value;
    private String columnName;

    public Column(int columnIndex,double value,String columnName){
        this.columnIndex = columnIndex;
        this.value=value;
        this.columnName=columnName;
    }


    @Override
    public String toString() {
        return "columnNumber: "+ columnIndex +"  "  +value+"";
    }

    public int getColumnIndex() {
        return columnIndex;
    }

    public void setColumnIndex(int columnIndex) {
        this.columnIndex = columnIndex;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }
}
