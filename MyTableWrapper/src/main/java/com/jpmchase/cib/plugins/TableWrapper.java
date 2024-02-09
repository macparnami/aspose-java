package com.jpmchase.cib.plugins;
import com.aspose.words.*;

import java.awt.*;
import java.util.ArrayList;

public class TableWrapper {
    static DocumentBuilder builder;
    public TableWrapper(DocumentBuilder builderObj){
        builder = builderObj;
    }
    public void CreateTable(CustomTableData tableData){
        //Table Start here
        builder.startTable();
        //Apply Table Formatting
        ApplyTableFormatting(tableData.formatting);
        //Create Rows
        for(int i=0; i<tableData.rows.size(); i++) {
            CreateRow(tableData.rows.get(i));
        }
        //End Table
        builder.endTable();
        FlushRowFormatting();
        FlushTableFormatting();
    }
    private static void CreateRow(TableRow row){
        //Reset previous Row Formatting
        FlushRowFormatting();
        //Apply Row Formatting
        ApplyRowFormatting(row.formatting);
        //Create cells
        for(int i=0; i<row.cells.size(); i++) {
            CreateCell(row.cells.get(i));
        }
        builder.endRow();
        //Remove formatting of Last Cell from loop
        FlushCellFormatting();


    }
    private static void CreateCell(TableCell cell){
        //Insert Cell Structure
        builder.insertCell();
        //Reset previous Cell Formatting, This need to be done after new Cell insert
        FlushCellFormatting();
        //Apply Cell Formatting for this cell
        ApplyCellFormatting(cell.formatting);
        //Insert Cell Data
        builder.write(cell.data);
    }
    private static void ApplyTableFormatting(TableFormatting format){

    }
    private static void FlushTableFormatting(){

    }
    private static void ApplyRowFormatting(RowFormatting format){
        if (format !=null) {
            if (format.Color !=null){
                builder.getCellFormat().getShading().setBackgroundPatternColor(format.Color);
            }
        }

    }
    private static void FlushRowFormatting(){
        builder.getCellFormat().getShading().clearFormatting();


    }
    private static void ApplyCellFormatting(CellFormatting format){
        if (format !=null) {
            if (format.HorizontalMerge > 0) {
                builder.getCellFormat().setHorizontalMerge(format.HorizontalMerge);
            }
            if (format.VerticalMerge >  0) {
                builder.getCellFormat().setVerticalMerge(format.VerticalMerge);
            }
        }
    }
    private static void FlushCellFormatting(){
        //Reset all teh setting values to default
        builder.getCellFormat().setHorizontalMerge(CellMerge.NONE);
        builder.getCellFormat().setVerticalMerge(CellMerge.NONE);
    }

}
