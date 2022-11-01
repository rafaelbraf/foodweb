package com.mycompany.foodweb.Model;

import com.mycompany.foodweb.View.Home;
import com.mycompany.foodweb.View.Login;

public class Main {
    
    public static void main(String[] args) {
        
        System.setProperty("file.encoding", "UTF-8");
        
        Login frameLogin = new Login();
        frameLogin.setVisible(true);
        frameLogin.setLocationRelativeTo(null);

    }
    
}
