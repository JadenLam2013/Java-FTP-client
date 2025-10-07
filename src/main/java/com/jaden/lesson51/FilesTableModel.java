package com.jaden.lesson51;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.apache.commons.net.ftp.FTPFile;

public class FilesTableModel extends AbstractTableModel {

    public List<FTPFile> files = new ArrayList();

    @Override
    public int getRowCount() {
        return files.size();
    }

    @Override
    public int getColumnCount() {
        return 1;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        FTPFile file = files.get(rowIndex);
           return file.getName(); 
        
    }

    @Override
    public String getColumnName(int column) {
            return "";
    }

}
