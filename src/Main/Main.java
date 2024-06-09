package Main;

import Controller.MyConnection;
import Views.LoginForm;
import Views.MainJFrame;
import Views.NhanVienJPanel;
import com.sun.jdi.connect.spi.Connection;
import java.sql.*;
import Views.*;
//import com.sun.jdi.connect.spi.Connection;

/**
 *
 * @author nhanh
 */
public class Main {

    public static void main(String[] args) {
        new LoginForm().setVisible(true);
        //new NhanVienJPanel().setVisible(true);
    }
    
}
