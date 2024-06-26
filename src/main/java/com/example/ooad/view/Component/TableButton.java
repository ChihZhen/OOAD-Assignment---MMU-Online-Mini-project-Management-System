package com.example.ooad.view.Component;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

public class TableButton extends AbstractCellEditor implements TableCellEditor, TableCellRenderer {
    private static final long serialVersionUID = 5647725208335645741L;
    private Color color;

    public interface TableButtonPressedHandler {

        void onButtonPress(int row, int column);
    }

    private List<TableButtonPressedHandler> handlers;
    private Hashtable<Integer, JButton> buttons;

    public TableButton(Color color) {
        handlers = new ArrayList<TableButtonPressedHandler>();
        buttons = new Hashtable<Integer, JButton>();
        this.color = color;
    }

    public void addHandler(TableButtonPressedHandler handler) {
        if (handlers != null) {
            handlers.add(handler);
        }
    }

    public void removeHandler(TableButtonPressedHandler handler) {
        if (handlers != null) {
            handlers.remove(handler);
        }
    }

    public void removeRow(int row) {
        if (buttons.containsKey(row)) {
            buttons.remove(row);
        }
    }

    public void moveRow(int oldRow, int newRow) {
        if (buttons.containsKey(oldRow)) {
            JButton button = buttons.remove(oldRow);
            buttons.put(newRow, button);
        }
    }

    public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focus,
            final int row, final int column) {
        JButton button = null;
        if (buttons.containsKey(row)) {
            button = buttons.get(row);
        } else {
            button = new JButton();
            button.setBackground(this.color);
            button.setForeground(Color.white);
            if (value != null && value instanceof String) {
                button.setText((String) value);
            }
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (handlers != null) {
                        for (TableButtonPressedHandler handler : handlers) {
                            handler.onButtonPress(row, column);
                        }
                    }
                }
            });
            buttons.put(row, button);
        }

        return button;
    }

    public Component getTableCellEditorComponent(JTable table, Object value, boolean selected, int row, int column) {
        JButton button = null;
        if (buttons.containsKey(row)) {
            button = buttons.get(row);
        } else {
            button = new JButton();
            if (value != null && value instanceof String) {
                button.setText((String) value);
            }

            buttons.put(row, button);
        }

        return button;
    }

    public void setButtonText(int row, String text) {
        JButton button = null;
        if (buttons.containsKey(row)) {
            button = buttons.get(row);
            button.setText(text);
        }
    }

    public Object getCellEditorValue() {
        return null;
    }

    public void dispose() {
        if (handlers != null) {
            handlers.clear();
        }
    }
}
