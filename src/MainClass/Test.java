/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MainClass;

import Util.InitalConn;
import Dao.DataBase;
import View.LoginPage;
/**
 *
 * @author root
 */
public class Test {
    public static void main(String[] args) {
        DataBase call = new DataBase();
        System.out.println("Database Created");
        LoginPage lg = new LoginPage();
        lg.show();
    }
}
