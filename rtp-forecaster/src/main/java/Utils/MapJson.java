package Utils;

import Utils.Deserialization.Event;
import Utils.Deserialization.Message;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MapJson {
    public static Event mapJson(String text) throws JsonProcessingException {

        try {
            ObjectMapper om = new ObjectMapper();
            Event car = om.readValue(text, Event.class);
            return car;
        }catch (Exception e){
            return null;
        }

    }
}
