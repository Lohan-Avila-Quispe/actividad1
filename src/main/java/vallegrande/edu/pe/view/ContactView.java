package vallegrande.edu.pe.view;

import vallegrande.edu.pe.controller.ContactController;
import vallegrande.edu.pe.model.Contact;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ContactView extends JFrame {
    private final ContactController controller;
<<<<<<< HEAD
    private final JTable table;
    private final DefaultTableModel tableModel;
    private final JTextField idField, nameField, emailField, phoneField;

    public ContactView(ContactController controller) {
        this.controller = controller;
        setTitle("Gestión de Contactos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 400);
        setLocationRelativeTo(null);

        // Panel contenedor con sombreado
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBackground(new Color(245, 245, 245)); // gris claro de fondo general
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

        JPanel contentPanel = new JPanel(new BorderLayout(10, 10));
        contentPanel.setBackground(Color.WHITE);
        contentPanel.setBorder(BorderFactory.createCompoundBorder(
                new MatteBorder(0, 0, 4, 4, new Color(200, 200, 200)), // sombra simulada
                new EmptyBorder(15, 15, 15, 15)
        ));

        // Panel de formulario
        JPanel formPanel = new JPanel(new GridLayout(2, 4, 10, 10));
        formPanel.setBackground(Color.WHITE);

        idField = new JTextField();
        nameField = new JTextField();
        emailField = new JTextField();
        phoneField = new JTextField();

        JLabel idLabel = new JLabel("ID:");
        JLabel nameLabel = new JLabel("Nombre:");
        JLabel emailLabel = new JLabel("Email:");
        JLabel phoneLabel = new JLabel("Teléfono:");

        Font labelFont = new Font("SansSerif", Font.BOLD, 14);
        idLabel.setFont(labelFont);
        nameLabel.setFont(labelFont);
        emailLabel.setFont(labelFont);
        phoneLabel.setFont(labelFont);

        formPanel.add(idLabel);
        formPanel.add(nameLabel);
        formPanel.add(emailLabel);
        formPanel.add(phoneLabel);
        formPanel.add(idField);
        formPanel.add(nameField);
        formPanel.add(emailField);
        formPanel.add(phoneField);

        contentPanel.add(formPanel, BorderLayout.NORTH);

        // Tabla
        String[] columnNames = {"ID", "Nombre", "Email", "Teléfono"};
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        contentPanel.add(scrollPane, BorderLayout.CENTER);

        // Botones
        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 15, 10));
        buttonsPanel.setBackground(Color.WHITE);

        JButton addButton = createStyledButton("Agregar", new Color(72, 201, 176));
        JButton deleteButton = createStyledButton("Eliminar", new Color(231, 76, 60));
        JButton refreshButton = createStyledButton("Actualizar", new Color(52, 152, 219));

        addButton.addActionListener(e -> {
            String id = idField.getText();
            String name = nameField.getText();
            String email = emailField.getText();
            String phone = phoneField.getText();
            controller.create(id, name, email, phone);
            refreshTable();
            clearFields();
        });

        deleteButton.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow >= 0) {
                String id = (String) tableModel.getValueAt(selectedRow, 0);
                controller.delete(id);
                refreshTable();
            }
        });

        refreshButton.addActionListener(e -> refreshTable());

        buttonsPanel.add(addButton);
        buttonsPanel.add(deleteButton);
        buttonsPanel.add(refreshButton);

        contentPanel.add(buttonsPanel, BorderLayout.SOUTH);

        mainPanel.add(contentPanel, BorderLayout.CENTER);
        setContentPane(mainPanel);

        refreshTable();
    }

    private JButton createStyledButton(String text, Color color) {
        JButton button = new JButton(text);
        button.setBackground(color);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setFont(new Font("SansSerif", Font.BOLD, 13));
        button.setBorder(BorderFactory.createEmptyBorder(8, 15, 8, 15));
        return button;
    }

    private void refreshTable() {
        tableModel.setRowCount(0);
        for (Contact c : controller.list()) {
            tableModel.addRow(new Object[]{c.getId(), c.getName(), c.getEmail(), c.getPhone()});
        }
    }

    private void clearFields() {
        idField.setText("");
        nameField.setText("");
        emailField.setText("");
        phoneField.setText("");
    }
}
=======
    private DefaultTableModel tableModel;
    private JTable table;

    public ContactView(ContactController controller) {
        super("Agenda MVC Swing - Vallegrande");
        this.controller = controller;
        initUI();
        loadContacts();
    }

    private void initUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Inicia maximizado a pantalla completa
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        // Fuente base para toda la ventana
        Font baseFont = new Font("Segoe UI", Font.PLAIN, 16);

        // Configuramos layout principal con espacio y márgenes
        JPanel contentPanel = new JPanel(new BorderLayout(10, 10));
        contentPanel.setBorder(new EmptyBorder(15, 15, 15, 15));
        setContentPane(contentPanel);

        // Tabla con modelo y estilo
        tableModel = new DefaultTableModel(new String[]{"ID", "Nombre", "Email", "Teléfono"}, 0) {
            @Override public boolean isCellEditable(int row, int column) { return false; }
        };
        table = new JTable(tableModel);
        table.setFont(baseFont);
        table.setRowHeight(30);
        table.getTableHeader().setFont(baseFont.deriveFont(Font.BOLD, 18f));
        table.setForeground(new Color(33, 33, 33));
        table.setBackground(Color.WHITE);

        JScrollPane scrollPane = new JScrollPane(table);
        contentPanel.add(scrollPane, BorderLayout.CENTER);

        // Panel para botones alineados a la derecha
        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 15, 10));
        buttonsPanel.setBackground(Color.WHITE); // fondo blanco limpio

        // Botón "Agregar" con estilo moderno
        JButton addBtn = new JButton("Agregar");
        styleButton(addBtn, new Color(0, 123, 255)); // azul vibrante

        // Botón "Eliminar" con estilo moderno
        JButton deleteBtn = new JButton("Eliminar");
        styleButton(deleteBtn, new Color(220, 53, 69)); // rojo vibrante

        buttonsPanel.add(addBtn);
        buttonsPanel.add(deleteBtn);

        contentPanel.add(buttonsPanel, BorderLayout.SOUTH);

        // Eventos botones
        addBtn.addActionListener(e -> showAddContactDialog());
        deleteBtn.addActionListener(e -> deleteSelectedContact());
    }

    /**
     * Aplica estilos modernos y hover a los botones.
     */
    private void styleButton(JButton button, Color baseColor) {
        button.setFont(new Font("Segoe UI", Font.BOLD, 16));
        button.setForeground(Color.WHITE);
        button.setBackground(baseColor);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        button.setOpaque(true);
        button.setContentAreaFilled(true);
        button.setBorderPainted(false);

        // Cambio de color al pasar mouse (hover)
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(baseColor.darker());
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(baseColor);
            }
        });
    }

    private void loadContacts() {
        tableModel.setRowCount(0);
        List<Contact> contacts = controller.list();
        for (Contact c : contacts) {
            tableModel.addRow(new Object[]{c.id(), c.name(), c.email(), c.phone()});
        }
    }

    private void showAddContactDialog() {
        AddContactDialog dialog = new AddContactDialog(this, controller);
        dialog.setVisible(true);
        if (dialog.isSucceeded()) {
            loadContacts();
        }
    }

    private void deleteSelectedContact() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un contacto para eliminar.", "Atención", JOptionPane.WARNING_MESSAGE);
            return;
        }
        String id = (String) tableModel.getValueAt(selectedRow, 0);
        int confirm = JOptionPane.showConfirmDialog(this, "¿Seguro que desea eliminar este contacto?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            controller.delete(id);
            loadContacts();
        }
    }
}
>>>>>>> 26ff65823feccc654001c7e7531c693fdcf683cc
