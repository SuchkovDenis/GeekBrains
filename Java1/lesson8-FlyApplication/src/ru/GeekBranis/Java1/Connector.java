package ru.GeekBranis.Java1;

import java.net.*;
import java.io.*;

public class Connector {
    private URL url;
    public Connector() {

    }

    public void doGet1(int adult, int child, int infant, String from, String to, String date1, String date2) throws Exception{
        String getString =  "https://api.aviakassa.ru/?" +
                "adult=" + adult +
                "&child=" + child +
                "&infant="+ infant +
                "&service_class=economy&segments[0][from]=" + from +
                "&segments[0][to]=" + to +
                "&segments[0][date]=" + date1 +
                "&segments[1][from]=" + to +
                "&segments[1][to]=" + from +
                "&segments[1][date]=" + date2 +
                "&action=avia_search&lang=ru";
        url = new URL(getString);
    }
    public void doGet2(String searchId) throws Exception{
        url = new URL("https://api.aviakassa.ru/?action=avia_result&search_id=" + searchId + "&lang=ru");
    }

    public String getResponce() throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
        return in.readLine();
    }

}
