package lgsapp.helpers;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Secratary {
    Connection con;
    PreparedStatement ps;

    public PreparedStatement addsecretary(String fname, String lname, String wop, String office, String contact, String email, String gender, String bday, String fappdate, String upgradedate, String retdate, String incdate , String inc, String beg, String mid, String end, Blob image,String curyr)  {
        con = DbConnect.getConnection();

        String query = "INSERT INTO `secrataries`( `fname`, `lname`, `wop`, `office`, `contact`, `email`, `gender`, `bday`, `fappdate`, `upgdate`, `retdate`, `incdate`, `salinc`, `yrbeg`, `yrmid`, `yrend`, `imageid`, `curyr`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";



        try {
            ps = con.prepareStatement(query);
            ps.setString(1, fname);
            ps.setString(2, lname);
            ps.setString(3, wop);
            ps.setString(4, office);
            ps.setString(5, contact);
            ps.setString(6, email);
            ps.setString(7, gender);
            ps.setString(8, bday);
            ps.setString(9, fappdate);
            ps.setString(10, upgradedate);
            ps.setString(11, retdate);
            ps.setString(12, incdate);
            ps.setString(13, inc);
            ps.setString(14, beg);
            ps.setString(15, mid);
            ps.setString(16, end);
            ps.setBlob(17, image);
            ps.setString(18, curyr);




        } catch (SQLException e) {
            e.printStackTrace();
        }



        return ps;
    }

}
