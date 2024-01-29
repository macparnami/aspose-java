package com.jpmchase.cib.plugins;

import java.util.ArrayList;

class Formatting{

}
class CellFormatting extends Formatting{
    public int HorizontalMerge ;
    public int VerticalMerge ;
}
class RowFormatting extends Formatting{

}
class TableFormatting extends Formatting{

}

class TableCell{
    public String data;
    public CellFormatting formatting;
}

class TableRow{
    public ArrayList<TableCell> cells;
    public RowFormatting formatting;
}

public class CustomTableData {
    public ArrayList<TableRow> rows;
    public TableFormatting formatting;
}
