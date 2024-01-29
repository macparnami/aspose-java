package com.jpmchase.cib.plugins;

import com.aspose.words.*;

import java.util.ArrayList;


/**
 * Example Table Footer
 *
 */
public class App
{
    private static CustomTableData CreateSampleData(){
        //3X3 table
        CustomTableData TableStructure = new CustomTableData();
        ArrayList<TableRow> rows = new ArrayList<TableRow>(3);

        TableRow R1 = new TableRow();
        TableRow R2 = new TableRow();
        TableRow R3 = new TableRow();

        ArrayList<TableCell> row1  = new ArrayList<TableCell>(3);
        ArrayList<TableCell> row2 = new ArrayList<TableCell>(3);
        ArrayList<TableCell> row3 = new ArrayList<TableCell>(3);
        //Heading
        TableCell h1 = new TableCell();
        h1.data = "h1";
        h1.formatting = new CellFormatting();
        h1.formatting.HorizontalMerge = CellMerge.FIRST;
        TableCell h2 = new TableCell();
        h2.data = "";
        h2.formatting = new CellFormatting();
        h2.formatting.HorizontalMerge = CellMerge.PREVIOUS;
        TableCell h3 = new TableCell();
        h3.data = "h3";
        h3.formatting = new CellFormatting();
        h3.formatting.VerticalMerge = CellMerge.FIRST;
        //Sub-Headings
        TableCell sh1 = new TableCell();
        sh1.data = "sh1";
        TableCell sh2 = new TableCell();
        sh2.data = "sh2";
        TableCell sh3 = new TableCell();
        sh3.data = "";
        sh3.formatting = new CellFormatting();
        sh3.formatting.VerticalMerge =  CellMerge.PREVIOUS;
        //columns
        TableCell c1 = new TableCell();
        c1.data = "c1";
        TableCell c2 = new TableCell();
        c2.data = "c2";
        TableCell c3 = new TableCell();
        c3.data = "c3";

        row1.add(h1);
        row1.add(h2);
        row1.add(h3);
        row2.add(sh1);
        row2.add(sh2);
        row2.add(sh3);
        row3.add(c1);
        row3.add(c2);
        row3.add(c3);

        R1.cells = row1;
        R2.cells = row2;
        R3.cells = row3;

        rows.add(R1);
        rows.add(R2);
        rows.add(R3);

        TableStructure.rows = rows;

        return TableStructure;
    }
    public static void main( String[] args ) throws Exception
    {
        //Start here
        Document doc = new Document();
        DocumentBuilder builder = new DocumentBuilder(doc);
        TableWrapper Wrapper = new TableWrapper(builder);
        CustomTableData DataForTable = CreateSampleData();
        Wrapper.CreateTable(DataForTable);

//        //Static Table Build
//        //Table Start here
//        builder.startTable();
//
//        // Set The Headers Row 1
//        builder.insertCell();
//        builder.getCellFormat().setHorizontalMerge(CellMerge.FIRST);
//        builder.write("Heading 1 Format Merged Column");
//
//        builder.insertCell();
//        builder.getCellFormat().setHorizontalMerge(CellMerge.NONE);
//        builder.getCellFormat().setHorizontalMerge(CellMerge.PREVIOUS);
//        builder.write("");
//        builder.insertCell();
//        builder.getCellFormat().setHorizontalMerge(CellMerge.NONE);
//        builder.getCellFormat().setVerticalMerge(CellMerge.FIRST);
//        builder.write("Heading 1 Format Single Col");
//        builder.endRow();
//
//        // Set the Headers Row 2
//        builder.insertCell();
//        builder.write("Heading 2 Format Split Column 1");
//        builder.insertCell();
//        builder.write("Heading 2 Format Split Column 2");
//
//        builder.insertCell();
//        builder.getCellFormat().setVerticalMerge(CellMerge.PREVIOUS);
//        builder.write("");
//        builder.endRow();
//
//        //Clear all formatting so it does not affect the data rows
//        builder.getParagraphFormat().clearFormatting();
//        builder.getCellFormat().setHorizontalMerge(CellMerge.NONE);
//        builder.getCellFormat().setVerticalMerge(CellMerge.NONE);
//
//        // Start Data Row 1 Put in loop if needed
//        builder.insertCell();
//        builder.write("Text Col 1");
//        builder.insertCell();
//        builder.write("Text Col 2 ");
//        builder.insertCell();
//        builder.write("Text Col 3 ");
//        builder.endRow();
//
//        //End Table
//        builder.endTable();
//
//        //Footer Start
//        builder.moveToHeaderFooter(HeaderFooterType.FOOTER_PRIMARY);
//        builder.getParagraphFormat().setAlignment(ParagraphAlignment.CENTER);
//
//        // Set font properties for Footer text.
//        builder.getFont().setName("ArialNarrow");
//        builder.getFont().setBold(true);
//        builder.getFont().setSize(8);
//        // Footer text
//        builder.write("JP. Morgan | ");
//        builder.insertField("PAGE", "");
//        builder.write(" of ");
//        builder.insertField("NUMPAGES", "");

        //Add directory path if needed Document Write , Multiple formats like .pdf .docx etc can be used
//        doc.save(Directory + "filename");
        doc.save("Tables.pdf");

    }


}
