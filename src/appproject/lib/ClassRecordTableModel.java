package appproject.lib;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class ClassRecordTableModel extends AbstractTableModel {
    private final ArrayList<ClassData> records;
    private final String[] columnNames = {"Code", "Class", "Name", "Program", "Units"};

    public ClassRecordTableModel(ArrayList<ClassData> records) {
        this.records = records;
    }

    @Override
    public int getRowCount() {
        return records.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ClassData record = records.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> record.code();
            case 1 -> record.class_title();
            case 2 -> record.class_name();
            case 3 -> record.program();
            case 4 -> record.units();
            default -> null;
        };
    }

    @Override
    public boolean isCellEditable(int row, int col) {
        return false;
    }
}
