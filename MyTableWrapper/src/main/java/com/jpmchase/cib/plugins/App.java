//package com.jpmchase.cib.plugins;
//
//import com.aspose.words.*;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;
//
//import java.io.FileReader;
//
//
///**
// * Example Table Footer
// *
// */
//public class App
//{
//    public static void main( String[] args ) throws Exception
//    {
//        //Start here
//        Document doc = new Document();
//        DocumentBuilder builder = new DocumentBuilder(doc);
//        TableWrapper Wrapper = new TableWrapper(builder);
//
//        JSONParser parser = new JSONParser();
//        try {
//            Object obj = parser.parse(new FileReader("test.json"));
//            JSONObject jsonObject = (JSONObject)obj;
////            JSONObject TableDataObject = (JSONObject)jsonObject.get("table_data");
////
////            Long temp1 = (Long)TableDataObject.get("column_length");
////            int column_length = new Integer(temp1.intValue());
////            Long temp2 = (Long)TableDataObject.get("row_length");
////            int row_length = new Integer(temp2.intValue());
//
//            CustomTableData DataForTable = new CustomTableData(jsonObject);
//            Wrapper.createTable(DataForTable);
//            doc.save("Tables.pdf");
//        } catch(Exception e) {
//            e.printStackTrace();
//        }
//
//
////        //Static Table Build
////        //Table Start here
////        builder.startTable();
////
////        // Set The Headers Row 1
////        builder.insertCell();
////        builder.getCellFormat().setVerticalMerge(CellMerge.FIRST);
////        builder.write("VHeading 1");
////
////        builder.insertCell();
////        builder.getCellFormat().setHorizontalMerge(CellMerge.FIRST);
////        builder.write("H2");
////        builder.insertCell();
////        builder.getCellFormat().setHorizontalMerge(CellMerge.PREVIOUS);
////        builder.insertCell();
////        builder.getCellFormat().setHorizontalMerge(CellMerge.PREVIOUS);
////
////        builder.insertCell();
////        builder.getCellFormat().setHorizontalMerge(CellMerge.FIRST);
////        builder.write("H3");
////        builder.insertCell();
////        builder.getCellFormat().setHorizontalMerge(CellMerge.PREVIOUS);
////        builder.insertCell();
////        builder.getCellFormat().setHorizontalMerge(CellMerge.PREVIOUS);
////        builder.endRow();
////
////        builder.insertCell();
////        builder.getCellFormat().setVerticalMerge(CellMerge.PREVIOUS);
////        builder.write("");
////
////        builder.insertCell();
////        builder.getCellFormat().setVerticalMerge(CellMerge.NONE);
////        builder.getCellFormat().setHorizontalMerge(CellMerge.NONE);
////        builder.getCellFormat().setHorizontalMerge(CellMerge.FIRST);
////        builder.write("SH2");
////        builder.insertCell();
////        builder.getCellFormat().setHorizontalMerge(CellMerge.PREVIOUS);
////        builder.insertCell();
////        builder.getCellFormat().setHorizontalMerge(CellMerge.PREVIOUS);
////
////        builder.insertCell();
////        builder.getCellFormat().setHorizontalMerge(CellMerge.FIRST);
////        builder.write("SH3");
////        builder.insertCell();
////        builder.getCellFormat().setHorizontalMerge(CellMerge.PREVIOUS);
////        builder.insertCell();
////        builder.getCellFormat().setHorizontalMerge(CellMerge.PREVIOUS);
////        builder.endRow();
////
////
////        builder.insertCell();
////        builder.getCellFormat().setVerticalMerge(CellMerge.NONE);
////        builder.getCellFormat().setHorizontalMerge(CellMerge.NONE);
////        builder.getCellFormat().setVerticalMerge(CellMerge.PREVIOUS);
////        builder.write("");
////
////        builder.insertCell();
////        builder.getCellFormat().setVerticalMerge(CellMerge.NONE);
////        builder.getCellFormat().setHorizontalMerge(CellMerge.NONE);
////        builder.write("SSH2");
////        builder.insertCell();
////        builder.insertCell();
////        builder.insertCell();
////        builder.write("SH3");
////        builder.insertCell();
////
////        builder.insertCell();
////        builder.endRow();
////        builder.endTable();
//
//
////        builder.write("Heading 1 Format Single Col");
////        builder.endRow();
////
////        // Set the Headers Row 2
////        builder.insertCell();
////        builder.write("Heading 2 Format Split Column 1");
////        builder.insertCell();
////        builder.write("Heading 2 Format Split Column 2");
////
////        builder.insertCell();
////        builder.getCellFormat().setVerticalMerge(CellMerge.PREVIOUS);
////        builder.write("");
////        builder.endRow();
////
////        //Clear all formatting so it does not affect the data rows
////        builder.getParagraphFormat().clearFormatting();
////        builder.getCellFormat().setHorizontalMerge(CellMerge.NONE);
////        builder.getCellFormat().setVerticalMerge(CellMerge.NONE);
////
////        // Start Data Row 1 Put in loop if needed
////        builder.insertCell();
////        builder.write("Text Col 1");
////        builder.insertCell();
////        builder.write("Text Col 2 ");
////        builder.insertCell();
////        builder.write("Text Col 3 ");
////        builder.endRow();
////
////        //End Table
////        builder.endTable();
////
////        //Footer Start
////        builder.moveToHeaderFooter(HeaderFooterType.FOOTER_PRIMARY);
////        builder.getParagraphFormat().setAlignment(ParagraphAlignment.CENTER);
////
////        // Set font properties for Footer text.
////        builder.getFont().setName("ArialNarrow");
////        builder.getFont().setBold(true);
////        builder.getFont().setSize(8);
////        // Footer text
////        builder.write("JP. Morgan | ");
////        builder.insertField("PAGE", "");
////        builder.write(" of ");
////        builder.insertField("NUMPAGES", "");
//
//        //Add directory path if needed Document Write , Multiple formats like .pdf .docx etc can be used
////        doc.save(Directory + "filename");
////        doc.save("Tables.pdf");
//
//
//    }
//
//
//}
