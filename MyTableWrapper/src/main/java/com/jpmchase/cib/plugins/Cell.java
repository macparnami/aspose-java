package com.jpmchase.cib.plugins;

import lombok.Data;

@Data
public class Cell {
    public String data;
    public CellFormatting cellFormatting;
    public Table nestedTable;
}
