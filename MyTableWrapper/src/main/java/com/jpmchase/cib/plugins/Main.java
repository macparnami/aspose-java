package com.jpmchase.cib.plugins;

import com.aspose.words.Document;
import com.aspose.words.DocumentBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class Main {
    Table table;

    public static void main(String[] args) throws Exception{
        Main main = new Main();
        Document doc = new Document();
        DocumentBuilder builder = new DocumentBuilder(doc);
        main.generateDoc(builder, doc);
    }

    Table fetchAllJsonToFillTableHeaders(String jsonPath, Class className) throws Exception{
        table = new ObjectMapper().readValue(new File(jsonPath), Table.class);
        return table;
    }

    void generateDoc(DocumentBuilder builder, Document doc)throws Exception{
        Main main = new Main();
        TableWrapper wrapper = new TableWrapper(builder);
        String path = "test2.json";
        Table table = main.fetchAllJsonToFillTableHeaders(path.toString(), Table.class);
        wrapper.createTable(table);
        doc.save("Tables.pdf");
    }
}

