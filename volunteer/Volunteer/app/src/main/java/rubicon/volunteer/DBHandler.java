package rubicon.volunteer;

import java.sql.Array;
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

    public boolean insertSkillsets(final int UserID, final int Outside, final int Inside, final String intrests){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    String url = "jdbc:mysql://74.220.219.118:3306/kkmonlee_rubicon";
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection conn = DriverManager.getConnection(url, "kkmonlee_insert", "seatspace");
                    Statement statement = conn.createStatement();
                    String query = "INSERT INTO Interview (ID, Outdoor, Indoor,  ";
                    query += "Dat, Answering, Managing, Translating, Reception, InfoDi, InfoGa, Mapping, ";
                    query += "Transporting, Loading, Packing, Distributing, Making, Staffing, Cleaning,";
                    query += "Debris, Helping, Assisting) VALUES (" + UserID + ", " + Outside + ", " + Inside;
                    for (int i = 0; i < intrests.length(); i++) {
                        query += ", " + intrests.charAt(i);
                    }
                    query += ")";
                    statement.execute(query);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
        return true;
    }
    
    public ArrayList<Event> getEvents(){
        final ArrayList<Event> events= new ArrayList<>();
        final ArrayList<Integer> check= new ArrayList<>();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String url = "jdbc:mysql://74.220.219.118:3306/kkmonlee_rubicon";
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection conn = DriverManager.getConnection(url, "kkmonlee_insert", "seatspace");
                    Statement statement = conn.createStatement();
                    String query = "SELECT * FROM Events";
                    ResultSet rs = statement.executeQuery(query);
                    while (rs.next()) {
                        System.out.println("FOUND EVENTS");
                        Event ev = new Event();
                        ev.setEventID(rs.getInt(1));
                        ev.setEventName(rs.getObject(2).toString());
                        ev.setLat((float) rs.getObject(3));
                        ev.setLang((float) rs.getObject(4));
                        ev.setDescription(rs.getObject(5).toString());
                        events.add(ev);
                    }
                    check.add(1);
                    System.out.println("poop");
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        while(check.size()==0){
            System.out.print("");
        }
        return events;
    }

    public int insertData(final String fn, final String ln, final String ka, final int age, final String gen, final String eml, final String no,final String ad1, final String ad2, final String pc) {
        final ArrayList<Integer> a= new ArrayList<>();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
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
                    //ResultSet rs = statement.executeQuery("SELECT MAX(UserID) FROM Volunteers");
                    a.add(1);
                } catch (SQLException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        while(a.size()== 0){
            System.out.print("");
        }
        return a.get(0);
    }
}
