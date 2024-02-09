package com.jpmchase.cib.plugins;

import java.awt.*;
import java.lang.reflect.Field;
import java.util.ArrayList;

import com.aspose.words.Row;
import org.json.simple.*;
import java.util.Iterator;
import java.lang.Long.*;
import org.json.simple.parser.*;
class Formatting{

}
class CellFormatting extends Formatting{
    public int HorizontalMerge ;
    public int VerticalMerge ;
}
class RowFormatting extends Formatting{
    public Color Color;
}
class TableFormatting extends Formatting{

}

class TableCell{
    public String data;
    public CellFormatting formatting;
    TableCell(){
        data = new String("");
        formatting = new CellFormatting();
    }
}

class TableRow{
    public ArrayList<TableCell> cells;
    public RowFormatting formatting;
    TableRow(int column_length){
        cells = new ArrayList<TableCell>(column_length);
        for(int i=0; i<column_length; i++){
            cells.add(i, new TableCell());
        }
    }
}

public class CustomTableData {
    public ArrayList<TableRow> rows;
    public TableFormatting formatting;
    CustomTableData(int column_length, int row_length, JSONObject JsonObj){
        rows = new ArrayList<TableRow>(row_length);
        for(int i=0; i<row_length; i++){
            rows.add(i, new TableRow(column_length));
        }
        if (JsonObj != null){
            JsonInitialize(JsonObj,rows, column_length, row_length);
        }

    }
    public  static void JsonInitialize(JSONObject JsonObj, ArrayList<TableRow> rows, int column_length, int row_length){
        try {
//            System.out.println(JsonObj);
            JSONObject TableFormatting = (JSONObject)JsonObj.get("table_formatting");
            SetTableFormatting(TableFormatting);

            JSONArray HeaderRowArrayObject = (JSONArray)JsonObj.get("table_header");
            Iterator RowIterator = HeaderRowArrayObject.iterator();
            int row_count = 0;
            int cell_count = 0;
            while (RowIterator.hasNext()) {
                JSONObject RowObject = (JSONObject)RowIterator.next();
                JSONObject RowFormatting = (JSONObject)RowObject.get("row_formatting");
                TableRow row = rows.get(row_count);
                SetRowFormatting(RowFormatting, row);
                JSONArray CellsArrayObject = (JSONArray)RowObject.get("cells");
                Iterator CellIterator = CellsArrayObject.iterator();
                    cell_count = 0;
                while (CellIterator.hasNext()) {
                    JSONObject CellObject = (JSONObject)CellIterator.next();
                    TableCell cell = row.cells.get(cell_count);
                    cell.data=(String)CellObject.get("data");
                    JSONObject CellFormatting = (JSONObject)CellObject.get("cell_formatting");
                    SetCellFormatting(CellFormatting, cell);
                    cell_count++;
                }
                row_count++;
            }

            JSONObject TableDataObject = (JSONObject)JsonObj.get("table_data");
            JSONArray DataArray = (JSONArray)TableDataObject.get("data");
            Iterator DataArrayIterator = DataArray.iterator();
            cell_count = 0;
            while (DataArrayIterator.hasNext()) {
                TableRow row = rows.get(row_count);
                TableCell cell = row.cells.get(cell_count);
                cell.data=(String)DataArrayIterator.next();
                cell_count++;
                if (cell_count == column_length){
                    cell_count = 0;
                    row_count++;
                }
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

    }
    static void SetRowFormatting(JSONObject RowFormatting, TableRow row){
       if (RowFormatting !=null){
           if(RowFormatting.containsKey("color")){
               String temp = (String)RowFormatting.get("color");
               Color color;
               try {
                   Field field = Class.forName("java.awt.Color").getField(temp);
                   color = (Color)field.get(null);
               } catch (Exception e) {
                   color = null; // Not defined
               }
               row.formatting = new RowFormatting();
               row.formatting.Color = color;
            }
       }

    }
    static void SetTableFormatting(JSONObject TableFormatting){

    }
    static void SetCellFormatting(JSONObject CellFormatting, TableCell cell){
        if(CellFormatting.containsKey("horizontal_merge")){
            Long temp = (Long)CellFormatting.get("horizontal_merge");
            cell.formatting.HorizontalMerge = new Integer(temp.intValue());
        }
        if(CellFormatting.containsKey("vertical_merge")){
            Long temp = (Long)CellFormatting.get("vertical_merge");
            cell.formatting.VerticalMerge = new Integer(temp.intValue());
        }
    }
}
