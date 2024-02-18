package com.jpmchase.cib.plugins;

import lombok.Data;

import java.util.ArrayList;

@Data
public class TableHeader {
    public RowFormatting rowFormatting;
    public ArrayList<Cell> cells;
}
