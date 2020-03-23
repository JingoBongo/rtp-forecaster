package Utils.Deserialization;

public class Message {
    float temperature_sensor_1;
    float temperature_sensor_2;
    float humidity_sensor_1;
    float humidity_sensor_2;
    float wind_speed_sensor_1;
    float wind_speed_sensor_2;
    float atmo_pressure_sensor_1;
    float atmo_pressure_sensor_2;
    float light_sensor_1;
    float light_sensor_2;
    float unix_timestamp_us;

    public Message(){
        this.unix_timestamp_us = 1f;
    }

    @Override
    public String toString() {
        return "Message{" +
                "temperature_sensor_1=" + temperature_sensor_1 +
                ", temperature_sensor_2=" + temperature_sensor_2 +
                ", humidity_sensor_1=" + humidity_sensor_1 +
                ", humidity_sensor_2=" + humidity_sensor_2 +
                ", wind_speed_sensor_1=" + wind_speed_sensor_1 +
                ", wind_speed_sensor_2=" + wind_speed_sensor_2 +
                ", atmo_pressure_sensor_1=" + atmo_pressure_sensor_1 +
                ", atmo_pressure_sensor_2=" + atmo_pressure_sensor_2 +
                ", light_sensor_1=" + light_sensor_1 +
                ", light_sensor_2=" + light_sensor_2 +
                ", unix_timestamp_us=" + unix_timestamp_us +
                '}';
    }

    public float getTemperature_sensor_1() {
        return temperature_sensor_1;
    }

    public void setTemperature_sensor_1(float temperature_sensor_1) {
        this.temperature_sensor_1 = temperature_sensor_1;
    }

    public float getTemperature_sensor_2() {
        return temperature_sensor_2;
    }

    public void setTemperature_sensor_2(float temperature_sensor_2) {
        this.temperature_sensor_2 = temperature_sensor_2;
    }

    public float getHumidity_sensor_1() {
        return humidity_sensor_1;
    }

    public void setHumidity_sensor_1(float humidity_sensor_1) {
        this.humidity_sensor_1 = humidity_sensor_1;
    }

    public float getHumidity_sensor_2() {
        return humidity_sensor_2;
    }

    public void setHumidity_sensor_2(float humidity_sensor_2) {
        this.humidity_sensor_2 = humidity_sensor_2;
    }

    public float getWind_speed_sensor_1() {
        return wind_speed_sensor_1;
    }

    public void setWind_speed_sensor_1(float wind_speed_sensor_1) {
        this.wind_speed_sensor_1 = wind_speed_sensor_1;
    }

    public float getWind_speed_sensor_2() {
        return wind_speed_sensor_2;
    }

    public void setWind_speed_sensor_2(float wind_speed_sensor_2) {
        this.wind_speed_sensor_2 = wind_speed_sensor_2;
    }

    public float getAtmo_pressure_sensor_1() {
        return atmo_pressure_sensor_1;
    }

    public void setAtmo_pressure_sensor_1(float atmo_pressure_sensor_1) {
        this.atmo_pressure_sensor_1 = atmo_pressure_sensor_1;
    }

    public float getAtmo_pressure_sensor_2() {
        return atmo_pressure_sensor_2;
    }

    public void setAtmo_pressure_sensor_2(float atmo_pressure_sensor_2) {
        this.atmo_pressure_sensor_2 = atmo_pressure_sensor_2;
    }

    public float getLight_sensor_1() {
        return light_sensor_1;
    }

    public void setLight_sensor_1(float light_sensor_1) {
        this.light_sensor_1 = light_sensor_1;
    }

    public float getLight_sensor_2() {
        return light_sensor_2;
    }

    public void setLight_sensor_2(float light_sensor_2) {
        this.light_sensor_2 = light_sensor_2;
    }

    public float getUnix_timestamp_us() {
        return unix_timestamp_us;
    }

    public void setUnix_timestamp_us(float unix_timestamp_us) {
        this.unix_timestamp_us = unix_timestamp_us;
    }
}
