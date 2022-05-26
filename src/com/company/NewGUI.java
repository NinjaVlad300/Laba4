package com.company;

import com.company.bdclass.DBBuilder;
import org.json.simple.parser.ParseException;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NewGUI extends JFrame{
    private JPanel panel1;
    private JPanel panel2;
    private JTree tree1;
    private JButton выбратьФайлButton;
    private JButton показатьДанныеButton;
    private JScrollPane ScrollPane1;
    private JButton показатьДеревоButton;
    private JTree tree2;
    private JScrollPane ScrollPane2;
    private JPanel panel3;
    private JTable table1;
    private JScrollPane ScrollPane3;
    private JScrollPane ScrollPane4;
    private JTable table2;
    private JScrollPane ScrollPane5;
    private JTable table3;
    private JButton поСтранамButton;
    private JPanel panel4;
    private JPanel panel5;
    private JButton поРегионамButton;
    private JButton поКомпаниямButton;
    private JButton выходButton;


    Reader reader = new Reader();
    ArrayList<Reactors> Reactors = new ArrayList<>();
    private JFileChooser fileChooser = new JFileChooser("C:\\Влад\\Мифи");
    DBBuilder builder = new DBBuilder("Lab3");


    public NewGUI() {
        DefaultMutableTreeNode treeNode1 = new DefaultMutableTreeNode("Reactors");
        tree1.setModel(new DefaultTreeModel(treeNode1));
        ScrollPane1.setViewportView(tree1);

        DefaultMutableTreeNode treeNode2 = new DefaultMutableTreeNode("Regions");
        tree2.setModel(new DefaultTreeModel(treeNode2));
        ScrollPane2.setViewportView(tree2);


        выбратьФайлButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int returnvalue = fileChooser.showOpenDialog(NewGUI.this);
                    if (returnvalue == JFileChooser.APPROVE_OPTION) {
                        File selectedFile = fileChooser.getSelectedFile();
                        try {
                            Reactors = reader.Read(fileChooser.getSelectedFile());
                        } catch (FileNotFoundException ex) {
                            Logger.getLogger(JFrame.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (ParseException ex) {
                            Logger.getLogger(JFrame.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                } catch (java.awt.HeadlessException HeadlessException) {
                    JOptionPane.showMessageDialog(null, "Not found", "Error", JOptionPane.PLAIN_MESSAGE);
                }
            }
        });


        показатьДанныеButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    reader.Tree(tree1, Reactors);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Данные о реакторах не записаны", "Ошибка", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        показатьДеревоButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    reader.FB(builder);
                    reader.Tree2(tree2, builder.getRegions(), builder.getCountries(), builder.getCompanies(), builder.getSites(), builder.getUnits());
                    reader.ForCompanies(table1, builder.getCompanies());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Данные о реакторах не загружены", "Ошибка", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });


        поСтранамButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame();
                frame.setContentPane(getJPanel3());
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);

                createTable1();

                ScrollPane3.setViewportView(table1);
                reader.ForCountries(table1, builder.getCountries());
            }
        });


        поРегионамButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame();
                frame.setContentPane(getJPanel4());
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);

                createTable2();

                ScrollPane4.setViewportView(table2);
                reader.ForRegions(table2, builder.getRegions());
            }
        });
        поКомпаниямButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame();
                frame.setContentPane(getJPanel5());
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);

                createTable3();

                ScrollPane5.setViewportView(table3);
                reader.ForCompanies(table3, builder.getCompanies());

            }
        });

                выходButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.exit(0);
                    }
                });


            }

            public JPanel getJPanel() {
                return panel1;
            }

            public JPanel getJPanel3() {
                return panel3;
            }

            public JPanel getJPanel4() {
                return panel4;
            }

            public JPanel getJPanel5() {
                return panel5;
            }

        private void createTable1(){
        table1.setModel(new DefaultTableModel(null,new String[]{"Страна", "Объем ежегодного потребления, т"}){
            @Override
            public boolean isCellEditable(int i, int k) {
                return false;}
            });
        }
        private void createTable2(){
        table2.setModel(new DefaultTableModel(null,new String[]{"Регион", "Объем ежегодного потребления, т"}){
            @Override
            public boolean isCellEditable(int i, int k) {
                return false;}
            });
        }

        private void createTable3(){
        table3.setModel(new DefaultTableModel(null,new String[]{"Компания", "Объем ежегодного потребления, т"}){
            @Override
            public boolean isCellEditable(int i, int k) {
                return false;}
            });
        }
}