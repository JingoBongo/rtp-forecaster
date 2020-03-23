package Utils.Deserialization;

public class Event {
    Message message;

    public Event(){
        this.message = new Message();
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Event{" +
                "message=" + message +
                '}';
    }
}
