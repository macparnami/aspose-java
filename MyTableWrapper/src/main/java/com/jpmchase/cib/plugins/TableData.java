package com.jpmchase.cib.plugins;

import lombok.Data;

import java.util.ArrayList;

@Data
public class TableData {
    private int columnLength;
    private int rowLength;
    public ArrayList<String[]> data;
}
