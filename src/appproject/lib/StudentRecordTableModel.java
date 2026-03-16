package appproject.lib;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class StudentRecordTableModel extends AbstractTableModel {
    private final ArrayList<StudentData> records;
    private final String[] columnNames = {"Full Name", "Age", "Program", "Scholarship Status"};

    public StudentRecordTableModel(ArrayList<StudentData> records) {
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
        StudentData record = records.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> record.fullName();
            case 1 -> record.age();
            case 2 -> record.program();
            case 3 -> record.isScholar();
            default -> null;
        };
    }

    @Override
    public boolean isCellEditable(int row, int col) {
        return false;
    }
}
