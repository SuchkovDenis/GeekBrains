package ru.GeekBranis.Java1;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

import java.awt.*;
import java.awt.event.*;
import java.util.Collections;
import javax.swing.*;

public class FlyApp {
    private Parser parser;
    private Connector connector;
    private ArrayList<Result> results;
    private String city;
    private int adult = 2;
    private int child;
    private int infant;
    private ArrayList<String> cities;
    private ArrayList<String[]> dates;
    private String resultMessage;

    // окно программы
    private JFrame frame;
    private JPanel panelHeader1, panelHeader2, panelHeader3;
    private JPanel panelContent1, panelContent2, panelContent3;
    private JPanel panelFooter;
    private JButton start, addCityFrom, addCityTo, addDates;
    private JTextField cityFrom, cityTo, dateFrom, dateTo;
    private JLabel cityFromLabel, cityToLabel, dateFromLabel, dateToLabel;
    private JLabel adultLabel, childLabel, infantLabel;
    private JTextField adultText, childText, infantText;
    private JButton addAdult, addChild, addInfant;

    // Настройки экрана для комфортного отображения окна программы и объявление цветов
    private static final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private static final int sizeWidth = 1200;
    private static final int sizeHeight = 400;
    private static final int locationX = (screenSize.width - sizeWidth) / 2;
    private static final int locationY = (screenSize.height - sizeHeight) / 2;
    private static final Color YELLOW = new Color(254,221,44);
    private static final Color BLUE = new Color(43,115,197);
    private static final Color GRAY = new Color(115,122,130);


    public FlyApp() {
        connector = new Connector();
        results = new ArrayList<>();
        cities = new ArrayList<>();
        dates = new ArrayList<>();
        parser = new Parser();
    }

    public void start() {
        frame = new JFrame();
        frame.setBounds(locationX, locationY, sizeWidth, sizeHeight);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBackground(BLUE);
        //frame.setUndecorated(true);
        frame.setResizable(false);

        panelHeader1 = new JPanel();
        panelHeader1.setBackground(YELLOW);

        panelContent1 = new JPanel();
        panelContent1.setBackground(BLUE);

        panelHeader2 = new JPanel();
        panelHeader2.setBackground(YELLOW);

        panelContent2 = new JPanel();
        panelContent2.setBackground(BLUE);

        panelHeader3 = new JPanel();
        panelHeader3.setBackground(YELLOW);

        panelContent3 = new JPanel();
        panelContent3.setBackground(BLUE);

        panelFooter = new JPanel();
        panelFooter.setBackground(GRAY);

        cityFromLabel = new JLabel("Город отправления ");
        cityToLabel = new JLabel("Город прибытия ");
        dateFromLabel = new JLabel("Начало ");
        dateToLabel = new JLabel("Окончание ");

        cityFrom = new JTextField(8);
        cityTo = new JTextField(8);
        dateFrom = new JTextField(8);
        dateTo = new JTextField(8);

        addCityFrom = new JButton("Изменить");
        addCityTo = new JButton( "Добавить");
        addDates = new JButton("Добавить");

        adultLabel = new JLabel("Взрослые");
        adultText = new JTextField(Integer.toString(adult));
        childLabel = new JLabel("Дети до 12 лет");
        childText = new JTextField(Integer.toString(child));
        infantLabel = new JLabel("Дети до 2 лет");
        infantText = new JTextField(Integer.toString(infant));

        addAdult = new JButton("Изменить");
        addChild = new JButton("Изменить");
        addInfant = new JButton("Изменить");

        start = new JButton("ПОИСК");
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                start.setText("Подождите...");
                cityFrom.setEnabled(false);
                cityTo.setEnabled(false);
                dateFrom.setEnabled(false);
                dateTo.setEnabled(false);
                addCityTo.setEnabled(false);
                addCityFrom.setEnabled(false);
                addDates.setEnabled(false);
                start.setEnabled(false);

                adultText.setEnabled(false);
                childText.setEnabled(false);
                infantText.setEnabled(false);
                addAdult.setEnabled(false);
                addChild.setEnabled(false);
                addInfant.setEnabled(false);

                searchFly();

                cityFrom.setEnabled(true);
                cityTo.setEnabled(true);
                dateFrom.setEnabled(true);
                dateTo.setEnabled(true);
                addCityTo.setEnabled(true);
                addCityFrom.setEnabled(true);
                addDates.setEnabled(true);
                start.setEnabled(true);
                frame.setEnabled(true);

                adultText.setEnabled(true);
                childText.setEnabled(true);
                infantText.setEnabled(true);
                addAdult.setEnabled(true);
                addChild.setEnabled(true);
                addInfant.setEnabled(true);

                start.setText("ПОИСК");
            }
        });

        addCityFrom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                city = cityFrom.getText();
                if (parser.checkCity(city)&&!city.equals("")) {
                    JOptionPane.showMessageDialog(frame, "Город отправления " + city, "Город изменен", JOptionPane.DEFAULT_OPTION);
                    city = parser.returnIATA(city);
                }
                else {
                    JOptionPane.showMessageDialog(frame, "Город не найден" , "Город не найден", JOptionPane.DEFAULT_OPTION);
                }
                cityFrom.setText("");
            }
        });

        addCityTo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String city = cityTo.getText();
                if (parser.checkCity(city)&&!city.equals("")) {
                    JOptionPane.showMessageDialog(frame, "Город " + city + " добавлен", "Город добавлен", JOptionPane.DEFAULT_OPTION);
                    cities.add(parser.returnIATA(city));
                }
                else {
                    JOptionPane.showMessageDialog(frame, "Город не найден" , "Город не найден", JOptionPane.DEFAULT_OPTION);
                }
                cityTo.setText("");
            }
        });

        addDates.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] dateFromTo = {dateFrom.getText(), dateTo.getText()};
                dates.add(dateFromTo);
                dateFrom.setText("");
                dateTo.setText("");
            }
        });

        addAdult.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    adult = Integer.parseInt(adultText.getText());
                    adultText.setText(Integer.toString(adult));
                } catch (Exception ex) {

                }
            }
        });

        addChild.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    child = Integer.parseInt(childText.getText());
                    childText.setText(Integer.toString(child));
                } catch (Exception ex) {

                }
            }
        });

        addInfant.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    infant = Integer.parseInt(infantText.getText());
                    infantText.setText(Integer.toString(infant));
                } catch (Exception ex) {

                }
            }
        });

        panelHeader1.add(cityFromLabel);
        panelHeader1.add(cityFrom);
        panelHeader1.add(addCityFrom);

        panelHeader2.add(cityToLabel);
        panelHeader2.add(cityTo);
        panelHeader2.add(addCityTo);

        panelHeader3.add(dateFromLabel);
        panelHeader3.add(dateFrom);
        panelHeader3.add(dateToLabel);
        panelHeader3.add(dateTo);
        panelHeader3.add(addDates);

        panelContent1.add(panelHeader1);
        panelContent2.add(panelHeader2);
        panelContent3.add(panelHeader3);

        panelFooter.add(adultLabel);
        panelFooter.add(adultText);
        panelFooter.add(addAdult);
        panelFooter.add(childLabel);
        panelFooter.add(childText);
        panelFooter.add(addChild);
        panelFooter.add(infantLabel);
        panelFooter.add(infantText);
        panelFooter.add(addInfant);
        panelFooter.add(start);

        frame.getContentPane().add(panelFooter,BorderLayout.SOUTH);
        frame.getContentPane().add(panelContent1, BorderLayout.WEST);
        frame.getContentPane().add(panelContent2, BorderLayout.CENTER);
        frame.getContentPane().add(panelContent3, BorderLayout.EAST);

        frame.setVisible(true);
    }

    public void searchFly() {
        JOptionPane.showMessageDialog(frame, "Поиск может занять продолжительное время, пожалуйста подождите", "Идет поиск", JOptionPane.DEFAULT_OPTION);
        Result res = new Result();
        Response mySecond = new Response();
        for (String c : cities) {
            for (String[] d : dates) {
                try {
                    // первичный Get запрос и парсинг JSON ответа
                    connector.doGet1(adult, child, infant, city, c, d[0], d[1]);
                    GsonBuilder builder = new GsonBuilder();
                    Gson gson = builder.create();
                    FirstResponse myFirst = gson.fromJson(connector.getResponce(), FirstResponse.class);

                    // вторичный Get запрос и парсинг JSON ответа
                    connector.doGet2(myFirst.getSearch_id());
                    mySecond = gson.fromJson(connector.getResponce(), Response.class);

                    //
                    if (myFirst.isSuccess()) {
                        res = mySecond.getResult()[0];
                        res.setArrivalCity(c);
                        results.add(res);

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(frame, mySecond.getMessage(), "Поиск не дал результатов", JOptionPane.DEFAULT_OPTION);
                }
            }
        }
        Collections.sort(results);
        int i = 0;
        for (Result r: results) {
            resultMessage = parser.returnName(city) + " - " + parser.returnName(r.getArrivalCity()) + "\n" +
                    "Отправление: " + r.getRoutes()[0].getSegments()[0].getDeparture_time() +
                    " Прибытие: " + r.getRoutes()[0].getSegments()[0].getArrival_time() + "\n" +
                    parser.returnName(r.getArrivalCity()) + " - " + parser.returnName(city) + "\n" +
                    "Отправление: " + r.getRoutes()[1].getSegments()[0].getDeparture_time() +
                    " Прибытие: " + r.getRoutes()[1].getSegments()[0].getArrival_time() + "\n" +
                    "Цена: " + r.getAmount().getRUB() + " RUB";
            JOptionPane.showMessageDialog(frame, resultMessage, "Результаты", JOptionPane.DEFAULT_OPTION);
            i++;
            if (i>3) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        FlyApp application = new FlyApp();
        application.start();

    }

}
