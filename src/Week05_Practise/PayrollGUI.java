package Week05_Practise;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PayrollGUI extends JFrame {
    private JTextArea displayArea;
    private JButton processButton;
    private Payable[] payableObjects;

    public PayrollGUI() {
        super("Payroll System");

        // Initialize payable objects
        payableObjects = new Payable[]{
                new Invoice("01234", "seat", 2, 375.00),
                new Invoice("56789", "tire", 4, 79.95),
                new SalariedEmployee("John", "Smith", "111-11-1111", 800.00),
                new HourlyEmployee("Karen", "Price", "222-22-2222", 16.75, 40),
                new CommissionEmployee("Sue", "Jones", "333-33-3333", 10000, 0.06),
                new BasePlusCommissionEmployee("Bob", "Lewis", "444-44-4444", 5000, 0.04, 300)
        };

        // Set up GUI components
        displayArea = new JTextArea(20, 40);
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);

        processButton = new JButton("Process Payroll");
        processButton.addActionListener(new ProcessButtonListener());

        // Add components to the frame
        add(scrollPane, BorderLayout.CENTER);
        add(processButton, BorderLayout.SOUTH);

        // Set frame properties
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private class ProcessButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            displayArea.setText("Invoices and Employees processed polymorphically:\n\n");

            for (Payable currentPayable : payableObjects) {
                displayArea.append(currentPayable.toString() + "\n");

                if (currentPayable instanceof BasePlusCommissionEmployee) {
                    BasePlusCommissionEmployee employee = (BasePlusCommissionEmployee) currentPayable;
                    employee.setBaseSalary(1.10 * employee.getBaseSalary());
                    displayArea.append("new base salary with 10% increase is: $" + String.format("%.2f", employee.getBaseSalary()) + "\n");
                }

                displayArea.append("payment due: $" + String.format("%.2f", currentPayable.getPaymentAmount()) + "\n\n");
            }
        }
    }

    public static void main(String[] args) {
        new PayrollGUI();
    }
}
