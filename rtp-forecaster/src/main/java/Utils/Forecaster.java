package Utils;

import Utils.Deserialization.Event;

public class Forecaster {
    public static String doMoneyMagic(Event e, String location){
        String result = "";
        if(location.contains("1"))
        result = location+"%%"+e.getMessage().getTemperature_sensor_1()
                +"%%"+e.getMessage().getHumidity_sensor_1()
                +"%%"+e.getMessage().getWind_speed_sensor_1()
                +"%%"+e.getMessage().getAtmo_pressure_sensor_1()
                +"%%"+e.getMessage().getLight_sensor_1();

        if(location.contains("2"))
            result = location+"%%"+e.getMessage().getTemperature_sensor_2()
                    +"%%"+e.getMessage().getHumidity_sensor_2()
                    +"%%"+e.getMessage().getWind_speed_sensor_2()
                    +"%%"+e.getMessage().getAtmo_pressure_sensor_2()
                    +"%%"+e.getMessage().getLight_sensor_2();
        return result;
    }

    public static String undoMoneyMagic(String location){
        String[] arr = location.split("%%");
        String result = "Weather in "+arr[0]+" is "+forecast(Float.valueOf(arr[1]),
                Float.valueOf(arr[2]),
                Float.valueOf(arr[3]),
                Float.valueOf(arr[4]),
                Float.valueOf(arr[5]));
        return result;
    }

    public static String forecast(float temperature, float humidity, float wind_speed, float atmo_pressure, float light){
        String result = "";
        if(temperature < -2 && light < 128 && atmo_pressure < 720 || temperature < -8) {
            result += " Snow ";
        }else if(temperature < -2 && light > 128 && atmo_pressure < 680) {
            result += " Wet snow ";
        }else if(temperature < -15 && wind_speed > 45) {
            result += " Blizzard ";
        }else if(temperature > 0 && atmo_pressure < 710 && humidity > 70 && wind_speed < 20) {
            result += " Slight rain ";
        }else if(temperature > 0 && atmo_pressure < 690 && humidity > 70 && wind_speed > 20) {
            result += " Heavy rain ";
        }else if(temperature > 30 && atmo_pressure < 770 && humidity > 80 && light > 192) {
            result += " Hot ";
        }else if(temperature > 30 && atmo_pressure < 770 && humidity > 50 && light > 192 && wind_speed > 35) {
            result += " Convection oven ";
        }else if(temperature > 25 && atmo_pressure < 750 && humidity > 70 && light < 192 && wind_speed < 10) {
            result += " Warm ";
        }else if(temperature > 25 && atmo_pressure < 750 && humidity > 70 && light < 192 && wind_speed > 10) {
            result += " Slight breeze ";
        }else if(light < 128) {
            result += " Cloudy ";
        }else if(temperature > 30 && atmo_pressure < 660 && humidity > 85 && wind_speed > 45) {
            result += " Monsoon ";
        } else {
            result = " just a normal everyday weather.\n";
        }

        


        return result;
    }
}
