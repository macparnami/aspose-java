package com.jpmchase.cib.plugins;
import com.aspose.words.*;

import java.util.ArrayList;

public class TableWrapper {
    static DocumentBuilder builder;
    public TableWrapper(DocumentBuilder builderObj){
        builder = builderObj;
    }
    public void createTable(Table table)throws Exception{
        //Table Start here
        builder.startTable();
        //Apply Table Formatting
        ApplyTableFormatting(table.tableFormatting);
        //Create Rows
        for(int i=0; i<table.tableHeader.size(); i++) {
            createRow(table.tableHeader.get(i));
        }
        createDataRow(table.tableData);
        //End Table
        builder.endTable();
        FlushRowFormatting();
        FlushTableFormatting();
    }
    private static void createRow(TableHeader row) throws Exception{
        //Reset previous Row Formatting
        FlushRowFormatting();
        //Apply Row Formatting
        ApplyRowFormatting(row.rowFormatting);
        //Create cells
        for(int i=0; i<row.cells.size(); i++) {
            createCell(row.cells.get(i));
        }
        builder.endRow();
        //Remove formatting of Last Cell from loop
        FlushCellFormatting();


    }
    private static void createCell(Cell cell) throws Exception{
        //Insert Cell Structure
        builder.insertCell();
        //Reset previous Cell Formatting, This need to be done after new Cell insert
        FlushCellFormatting();
        //Apply Cell Formatting for this cell
        ApplyCellFormatting(cell.cellFormatting);
        //Insert Cell Data
        builder.write(cell.data);
//        if(cell.nestedTable !=null){
//            TableWrapper Wrapper = new TableWrapper(builder);
//            Wrapper.createTable(cell.nestedTable);
//        }
    }
    private static void createDataRow(TableData tableData) throws Exception{
        for(int i=0; i<tableData.data.size();i++){
            String[] temp = tableData.data.get(i);
            for(int j=0; j< temp.length; j++){
                builder.insertCell();
                builder.write(temp[j]);
            }
            builder.endRow();
        }
    }
    private static void ApplyTableFormatting(TableFormatting format){

    }
    private static void FlushTableFormatting(){

    }
    private static void ApplyRowFormatting(RowFormatting format){
//        if (format !=null) {
//            if (format.Color !=null){
//                builder.getCellFormat().getShading().setBackgroundPatternColor(format.Color);
//            }
//        }

    }
    private static void FlushRowFormatting(){
        builder.getCellFormat().getShading().clearFormatting();


    }
    private static void ApplyCellFormatting(CellFormatting format){
        if (format !=null) {
            if (format.horizontalMerge > 0) {
                builder.getCellFormat().setHorizontalMerge(format.horizontalMerge);
            }
            if (format.verticalMerge >  0) {
                builder.getCellFormat().setVerticalMerge(format.verticalMerge);
            }
//            if (format.padding !=null){
//                builder.getCellFormat().setPaddings(format.Padding[0],format.Padding[1],
//                        format.Padding[2],format.Padding[3]);
//            }
        }
    }
    private static void FlushCellFormatting(){
        //Reset all teh setting values to default
        builder.getCellFormat().setHorizontalMerge(CellMerge.NONE);
        builder.getCellFormat().setVerticalMerge(CellMerge.NONE);
    }

}
