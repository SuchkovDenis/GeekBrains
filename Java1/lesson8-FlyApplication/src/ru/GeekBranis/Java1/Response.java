package ru.GeekBranis.Java1;

public class Response {
    private boolean success;
    private String message;
    private Search search;
    private int client;
    private Result[] result;
    private int code;
    private float response_time;

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public Result[] getResult() {
        return result;
    }
}

class Search {
    private int adult;
    private int child;
    private int infant;
    private String service_class;
    private String client_key;
    private int meta_id;
    private int bol_hit_id;
    private Segments[] segments;
    private String search_id;
    private String type;
    private int client;
}

class Segments {
    private FromTo from;
    private FromTo to;
    private String date;
}

class FromTo {
    private String ccode;
    private String country;
    private String value;
    private String iata;
}

class Result implements Comparable{
    private String currency;
    private String id;
    private Amount amount;
    private ValidatingSupplier validating_supplier;
    private Route[] routes;
    private String ArrivalCity;

    public String getArrivalCity() {
        return ArrivalCity;
    }

    public Route[] getRoutes() {
        return routes;
    }

    public ValidatingSupplier getValidating_supplier() {
        return validating_supplier;
    }

    public Amount getAmount() {
        return amount;
    }

    public String getId() {
        return id;
    }

    public void setArrivalCity(String arrivalCity) {
        ArrivalCity = arrivalCity;
    }

    @Override
    public int compareTo(Object o) {
        return (this.getAmount().getRUB() - ((Result)o).getAmount().getRUB());
    }
}

class Amount {
    private int RUR, RUB;

    public int getRUB() {
        return RUB;
    }
}

class ValidatingSupplier {
    private String code;
    private String name;

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}

class Route {
    private int route_duration;
    private Segment[] segments;

    public Segment[] getSegments() {
        return segments;
    }

    public int getRoute_duration() {
        return route_duration;
    }
}

class Segment {
    private int allowed_seats;
    private String departure_time;
    private String arrival_time;

    public int getAllowed_seats() {
        return allowed_seats;
    }

    public String getDeparture_time() {
        return departure_time;
    }

    public String getArrival_time() {
        return arrival_time;
    }
}

