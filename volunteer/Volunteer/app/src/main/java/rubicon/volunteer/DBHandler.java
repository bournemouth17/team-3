package rubicon.volunteer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by Manav on 09/06/2017.
 */

public class DBHandler {

    public ArrayList<Event> getEvents(){
        ArrayList<Event> events= new ArrayList<>();
        try {
            String url = "jdbc:mysql://74.220.219.118:3306/kkmonlee_rubicon";
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, "kkmonlee_insert", "seatspace");
            Statement statement = conn.createStatement();
            String query="SELECT * FROM Events";
            ResultSet rs=statement.executeQuery(query);
            while(rs.next()){
                Event ev=new Event();
                ev.setEventID(rs.getInt(1));
                ev.setEventName(rs.getObject(2).toString());
                ev.setLat((float)rs.getObject(3));
                ev.setLang((float)rs.getObject(4));
                ev.setDescription(rs.getObject(5).toString());
                events.add(ev);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return events;

    }

    public boolean insertData(String fn, String ln, String ka, int age, String gen, String eml, String no, String ad1, String ad2, String pc) throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://74.220.219.118:3306/kkmonlee_rubicon";
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection(url, "kkmonlee_insert", "seatspace");
        Statement statement = conn.createStatement();
        String query = "INSERT INTO Volunteers(Forename, Lastname, KnownAs, Age, Gender, Email, PhoneNumber, Address1, Address2, Postcode) VALUES ";
        query += "(";
        query += "\"" + fn + "\", ";
        query += "\"" + ln + "\", ";
        query += "\"" + ka + "\", ";
        query += age + ", ";
        query += "\"" + gen + "\", ";
        query += "\"" + eml + "\", ";
        query += "\"" + no + "\", ";
        query += "\"" + ad1 + "\", ";
        query += "\"" + ad2 + "\", ";
        query += "\"" + pc + "\"";
        query += ")";
        statement.execute(query);
        return true;
    }

}
