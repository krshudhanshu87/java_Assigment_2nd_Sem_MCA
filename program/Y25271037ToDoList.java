// File: Y25271037ToDoList.java
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Y25271037ToDoList extends JFrame {
    private DefaultListModel<String> listModel;
    private JList<String> taskList;
    private JTextField taskField;
    private JButton addButton, deleteButton, resetButton;

    public Y25271037ToDoList() {
        setTitle("To-Do List Application");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Model + JList
        listModel = new DefaultListModel<>();
        taskList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(taskList);

        // Input field + Add button
        taskField = new JTextField(20);
        addButton = new JButton("Add Task");

        JPanel inputPanel = new JPanel(new FlowLayout());
        inputPanel.add(taskField);
        inputPanel.add(addButton);

        // Delete + Reset buttons
        deleteButton = new JButton("Delete Selected");
        resetButton = new JButton("Reset List");

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(deleteButton);
        buttonPanel.add(resetButton);

        // Add components to frame
        add(new JLabel("To-Do List", SwingConstants.CENTER), BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(inputPanel, BorderLayout.SOUTH);
        add(buttonPanel, BorderLayout.PAGE_END);

        // Action: Add task
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String task = taskField.getText().trim();
                if (!task.isEmpty()) {
                    listModel.addElement(task);
                    taskField.setText("");
                } else {
                    JOptionPane.showMessageDialog(Y25271037ToDoList.this,
                            "Task cannot be empty!", "Warning", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        // Action: Delete selected task
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = taskList.getSelectedIndex();
                if (selectedIndex != -1) {
                    listModel.remove(selectedIndex);
                } else {
                    JOptionPane.showMessageDialog(Y25271037ToDoList.this,
                            "Please select a task to delete!", "Warning", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        // Action: Reset list
        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                listModel.clear();
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Y25271037ToDoList().setVisible(true));
    }
}