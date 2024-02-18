package com.jpmchase.cib.plugins;

import lombok.Data;

import java.util.List;

@Data
public class Table {
    TableFormatting tableFormatting = null;
    List<TableHeader> tableHeader = null;
    TableData tableData = null;
}
