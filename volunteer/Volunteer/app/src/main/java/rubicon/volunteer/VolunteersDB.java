package rubicon.volunteer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Darryl on 2017-06-09.
 */

public class MainActivity extends AppCompatActivity {

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
