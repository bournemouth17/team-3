/**
 * Created by Darryl on 2017-06-09.
 */
public class Event {

    private int eventID;
    private String eventName;
    private float lang;
    private float lat;
    private String description;

    public void setEventID(int id){
        eventID=id;
    }
    public void setEventName(String e){
        eventName=e;
    }

    public void setLang(float l){
        lang=l;
    }

    public void setLat(float l){
        lat=l;
    }

    public void setDescription(String des){
        description=des;
    }

    public int getEventID(){
        return eventID;
    }

    public String getEventName(){
        return eventName;
    }

    public float getLang(){
        return lang;
    }

    public float getLat(){
        return lat;
    }

    public String getDescription(){
        return description;
    }
}
