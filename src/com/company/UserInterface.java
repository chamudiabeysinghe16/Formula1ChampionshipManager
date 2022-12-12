package com.company;


import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

import static com.company.Formula1ChampionshipManager.driversArray;


public class UserInterface extends Formula1Driver {

    static LinkedList<Formula1Driver> driverList = new <Formula1Driver>LinkedList();
    static LinkedList<Races> raceList = new <Races>LinkedList();
    static Races races=new Races();
    static Date date = new Date();
    static SimpleDateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");
    static DefaultTableModel tableModel3 = new DefaultTableModel();
    static JTable table2 = new JTable(tableModel3);
    private static JTextField searchField;


    static class MyWindowListener extends WindowAdapter {
        @Override
        public void windowClosing(WindowEvent e) {
            System.out.println("Closing window");
            System.exit(0);
        }

    }


    public static void main(String[] argv) {

        try {
            FileInputStream saveFile = new FileInputStream("/Users/chamudi/Desktop/CourseworkOOP(Intellij) 2 2 3 2 2/Championship Details.txt");
            ObjectInputStream save = new ObjectInputStream(saveFile);
            driverList = (LinkedList) save.readObject();
            raceList = (LinkedList) save.readObject();

            save.close();
        }
        catch (Exception exc) {
            System.out.println("<--- Error in loading file --->");
        }
        driverList.sort(new Sort());
        startMain();

    }


    public static void points ( int position,int i) {


        out:for (Formula1Driver formula1Driver : driverList) {

            if (driverList.indexOf(formula1Driver) == i) {
                if (position == 1) {
                    formula1Driver.setFirstPositionCount(formula1Driver.getFirstPositionCount() + 1);
                    formula1Driver.setCurrentPoints(formula1Driver.getCurrentPoints() + 25);
                    formula1Driver.setNoOfParticipatedRaces(formula1Driver.getNoOfParticipatedRaces()+1);


                    break out;

                }
                if (position == 2) {
                    formula1Driver.setSecondPositionCount(formula1Driver.getSecondPositionCount() + 1);
                    formula1Driver.setCurrentPoints(formula1Driver.getCurrentPoints() + 18);
                    formula1Driver.setNoOfParticipatedRaces(formula1Driver.getNoOfParticipatedRaces()+1);


                    break out;
                }

                if (position == 3) {
                    formula1Driver.setThirdPositionCount(formula1Driver.getThirdPositionCount() + 1);
                    formula1Driver.setCurrentPoints(formula1Driver.getCurrentPoints() + 15);
                    formula1Driver.setNoOfParticipatedRaces(formula1Driver.getNoOfParticipatedRaces()+1);

                    break out;
                }

                if (position == 4){
                    formula1Driver.setCurrentPoints(formula1Driver.getCurrentPoints() + 12);
                    formula1Driver.setNoOfParticipatedRaces(formula1Driver.getNoOfParticipatedRaces()+1);

                    break out;
                }

                if (position == 5){
                    formula1Driver.setCurrentPoints(formula1Driver.getCurrentPoints() + 10);
                    formula1Driver.setNoOfParticipatedRaces(formula1Driver.getNoOfParticipatedRaces()+1);

                    break out;
                }

                if (position == 6){
                    formula1Driver.setCurrentPoints(formula1Driver.getCurrentPoints() + 8);
                    formula1Driver.setNoOfParticipatedRaces(formula1Driver.getNoOfParticipatedRaces()+1);

                    break out;
                }

                if (position == 7){
                    formula1Driver.setCurrentPoints(formula1Driver.getCurrentPoints() + 6);
                    formula1Driver.setNoOfParticipatedRaces(formula1Driver.getNoOfParticipatedRaces()+1);

                    break out;
                }

                if (position == 8){
                    formula1Driver.setCurrentPoints(formula1Driver.getCurrentPoints() + 4);
                    formula1Driver.setNoOfParticipatedRaces(formula1Driver.getNoOfParticipatedRaces()+1);

                    break out;
                }

                if (position == 9){
                    formula1Driver.setCurrentPoints(formula1Driver.getCurrentPoints() + 2);
                    formula1Driver.setNoOfParticipatedRaces(formula1Driver.getNoOfParticipatedRaces()+1);

                    break out;
                }

                if (position == 10) formula1Driver.setCurrentPoints(formula1Driver.getCurrentPoints() + 1);{
                    formula1Driver.setNoOfParticipatedRaces(formula1Driver.getNoOfParticipatedRaces()+1);

                    break out;
                }
            }
        }
    }


    public static  void startMain() {
        DefaultTableModel tableModel = new DefaultTableModel();
        JTable table = new JTable(tableModel);
        tableModel.addColumn("Driver's Name");
        tableModel.addColumn("Team Name");
        tableModel.addColumn("First positions count");
        tableModel.addColumn("Second positions count");
        tableModel.addColumn("Third positions count");
        tableModel.addColumn("Current points");
        tableModel.addColumn("Participated races count");


        for (Formula1Driver formula1Driver : driverList) {
            tableModel.addRow(new Object[]{formula1Driver.getNameOfDriver(), formula1Driver.getCarManufacturer(), formula1Driver.getFirstPositionCount(), formula1Driver.getSecondPositionCount(), formula1Driver.getThirdPositionCount(), formula1Driver.getCurrentPoints(), formula1Driver.getNoOfParticipatedRaces()});
        }

        //StackOverflow example

        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.getColumnModel().getColumn(0).setPreferredWidth(120);
        table.getColumnModel().getColumn(1).setPreferredWidth(120);
        table.getColumnModel().getColumn(2).setPreferredWidth(140);
        table.getColumnModel().getColumn(3).setPreferredWidth(140);
        table.getColumnModel().getColumn(4).setPreferredWidth(140);
        table.getColumnModel().getColumn(5).setPreferredWidth(120);
        table.getColumnModel().getColumn(6).setPreferredWidth(160);




        JFrame frame = new JFrame();
        JPanel panel = new JPanel();

        frame.setContentPane(panel);
        frame.addWindowListener(new MyWindowListener());


        JButton button1 = new JButton(new AbstractAction("POINTS ASCENDING ORDER") {
            @Override
            public void actionPerformed(ActionEvent e) {
                driverList.sort(new Sort1());
                startMain();

            }
        });

        JButton button2 = new JButton(new AbstractAction("POINTS DESCENDING ORDER") {
            @Override
            public void actionPerformed(ActionEvent e) {
                driverList.sort(new Sort2());
                startMain();

            }
        });


        JButton button3 = new JButton( new AbstractAction("FIRST POSITION DESCENDING") {
            @Override
            public void actionPerformed( ActionEvent e ) {
                driverList.sort(new Sort());
                startMain();
            }
        });
        JButton button4 = new JButton( new AbstractAction("RANDOM RACE") {
            int y=9;
            @Override
            public void actionPerformed( ActionEvent e ) {

                tableModel.addColumn("<-- NEW POSITIONS -->");
                List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
                Collections.shuffle(list);
                for (int x = 0; x < 10; x++) {
                    int placing= list.get(x);


                    points(placing,x);

                    tableModel.setValueAt(placing,x,y);
                }


                y=y+1;
                driverList.sort(new Sort());
                startMain();

            }

        });



        JButton button5 = new JButton( new AbstractAction("ADD RACE") {
            @Override
            public void actionPerformed( ActionEvent e ) {
                List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
                Collections.shuffle(list);
                Collections.shuffle(driverList);
                for (int x = 0; x < list.size(); x++) {
                    int place= list.get(x);
                    points(place,x);
                    for (Formula1Driver formula1Driver : driverList) {
                        if (driverList.indexOf(formula1Driver) == x) {
                            Races races = new Races();
                            races.setDate(date);
                            races.setId(formula1Driver.getNameOfDriver());
                            races.setPlace(place);
                            raceList.add(races);
                        }}
                }

                DefaultTableModel tableModel3= new DefaultTableModel();
                JTable table2 = new JTable(tableModel3);
                tableModel3.addColumn("dates");
                tableModel3.addColumn("driver name");
                tableModel3.addColumn("place");
                frame.getContentPane().add(new JScrollPane(table2));
                raceList.sort(Comparator.comparing(Races::getDate));

                for (Races races : raceList) {

                    tableModel3.addRow(new Object[]{formatter.format(races.getDate()), races.getId(), races.getPlace()});

                }
                driverList.sort(new Sort());
                startMain();


            }


        });

        JButton button6 = new JButton( new AbstractAction("RACE-DATES") {
            @Override
            public void actionPerformed( ActionEvent e ) {


                DefaultTableModel tableModel2 = new DefaultTableModel();
                JTable table1 = new JTable(tableModel2);
                tableModel2.addColumn("Date");
                tableModel2.addColumn("Driver id");
                tableModel2.addColumn("Place");
                frame.getContentPane().add(new JScrollPane(table1));
                raceList.sort(Comparator.comparing(Races::getDate));

                for (Races races : raceList) {

                    tableModel2.addRow(new Object[]{formatter.format(races.getDate()), races.getId(), races.getPlace()});

                }


            }


        });

        //stack OverFlow

        JButton button7 = new JButton( new AbstractAction("SEARCH RACES") {
            @Override
            public void actionPerformed(ActionEvent e) {

                String value = searchField.getText();

                for (int row = 0; row <= table.getRowCount() - 1; row++) {

                    for (int col = 0; col <= table.getColumnCount() - 1; col++) {

                        if (value.equals(table.getValueAt(row, col))) {

                            // this will automatically set the view of the scroll in the location of the value
                            table.scrollRectToVisible(table.getCellRect(row, 0, true));

                            // this will automatically set the focus of the searched/selected row/value
                            table.setRowSelectionInterval(row, row);

                            for (int i = 0; i <= table.getColumnCount() - 1; i++) {

                                table.getColumnModel().getColumn(i).setCellRenderer(new HighlightRenderer());
                            }
                        }
                    }
                }
            }


        class HighlightRenderer extends DefaultTableCellRenderer {

            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

                // everything as usual
                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                // added behavior
                if(row == table.getSelectedRow()) {

                    // this will customize that kind of border that will be use to highlight a row
                    setBorder(BorderFactory.createMatteBorder(2, 1, 2, 1, Color.BLACK));
                }

                return this;
            }
        }
        });




        frame.getContentPane().add(button1);
        frame.getContentPane().add(button2);
        frame.getContentPane().add(button3);
        frame.getContentPane().add(button4);
        frame.getContentPane().add(button5);
        frame.getContentPane().add(button6);
        frame.getContentPane().add(button7);

       frame.getContentPane().add(new JScrollPane(table));

        frame.setSize(1500, 1000);
        frame.setTitle("Championship Race Information");
        frame.add(new JLabel(new ImageIcon("/Users/chamudi/Desktop/CourseworkOOP(Intellij) 2 2 3 2 2/src/com/company/car.jpeg")));
        frame.getContentPane().setBackground(new Color(140,150,220));
        table.setBackground(new Color(120,180,170));


        frame.setVisible(true);

    }
}

