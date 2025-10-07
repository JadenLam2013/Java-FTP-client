package com.jaden.lesson51;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.apache.commons.net.ftp.FTPFile;

public class DestTableModel extends AbstractTableModel {

    public List<FTPFile> files = new ArrayList();

    @Override
    public int getRowCount() {
        return files.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        FTPFile file = files.get(rowIndex);

        if (columnIndex == 0) {
            return file.getName();
        } else if (columnIndex == 1) {
             if (file.getSize() < 0) {
                return "";
            } else {
                return file.getSize();
            }
            
        } else if (columnIndex == 2) {
            if (file.getTimestamp() == null) {
                return "";
            } else {
                return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(file.getTimestamp().getTime());
            }
        } else {
            return file.getUser() + " " + file.getGroup();
        }
    }

    @Override
    public String getColumnName(int column) {
        if (column == 0) {
            return "File name";
        } else if (column == 1) {
            return "File size";

        } else if (column == 2) {
            return "Last modified";
        } else {
            return "Owner/Group";
        }
    }

}
