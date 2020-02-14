package com.javarush.task.task18.task1815;

import java.util.List;

/* 
Таблица
*/

public class Solution {
    public class TableInterfaceWrapper implements TableInterface {
        private TableInterface realTableInterface;

        public TableInterfaceWrapper(TableInterface realTableInterface) {
            this.realTableInterface = realTableInterface;
        }

        @Override
        public void setModel(List rows) {
            System.out.println(rows.size());
            realTableInterface.setModel(rows);
        }

        @Override
        public String getHeaderText() {
            return realTableInterface.getHeaderText().toUpperCase();
        }

        @Override
        public void setHeaderText(String newHeaderText) {
            realTableInterface.setHeaderText(newHeaderText);
        }
    }

    public interface TableInterface {
        void setModel(List rows);

        String getHeaderText();

        void setHeaderText(String newHeaderText);
    }

    public static void main(String[] args) {
    }
}