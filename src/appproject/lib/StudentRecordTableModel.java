package appproject.lib;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class StudentRecordTableModel extends AbstractTableModel {
    private final ArrayList<StudentData> records;
    private final String[] columnNames = {"Student ID", "Full Name", "Age", "Program", "Scholarship Status"};

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
            case 0 -> record.id();
            case 1 -> record.fullName();
            case 2 -> record.age();
            case 3 -> record.program();
            case 4 -> record.isScholar();
            default -> null;
        };
    }

    public StudentData getSelectedRecord(int index) {
        return records.get(index);
    }

    public ArrayList<StudentData> getRecords() {
        return records;
    }

    public void addRecord(StudentData record) {
        records.add(record);
        fireTableRowsInserted(records.size() - 1, records.size() - 1);
        AppWindow.debugPrintln("Successfully added: " + record, "MESSAGE");
    }

    public void removeRecord(int index) {
        StudentData removedRecord = records.remove(index);
        fireTableRowsDeleted(index, index);
        AppWindow.debugPrintln("Successfully removed: " + removedRecord, "MESSAGE");
    }

    public void setRecord(StudentData record, int index) {
        records.set(index, record);
        fireTableRowsUpdated(index, index);
        AppWindow.debugPrintln("Successfully updated: " + record, "MESSAGE");
    }

    @Override
    public boolean isCellEditable(int row, int col) {
        return false;
    }
}
