package com.jaden.lesson51;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.apache.commons.net.ftp.FTPFile;

public class SrcTableModel extends AbstractTableModel {

    public List<File> files = new ArrayList();

    @Override
    public int getRowCount() {
        return files.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       File file = files.get(rowIndex);

        if (columnIndex == 0) {
            return file.getName();
        } else if (columnIndex == 1) {
            return file.getAbsoluteFile().length();
        } else {
            return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(file.lastModified());
        }
    }

    @Override
    public String getColumnName(int column) {
        if (column == 0) {
            return "File name";
        } else if (column == 1) {
            return "File size";
        } else {
            return "Last modified";
        }
    }
}
