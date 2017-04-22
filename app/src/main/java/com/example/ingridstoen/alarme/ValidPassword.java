package com.example.ingridstoen.alarme;

/**
 * Created by aminaettayebi on 11.04.2017.
 */

import android.os.AsyncTask;
import java.sql.*;



public class ValidPassword  extends AsyncTask<Void, Void, String>{
    int student_id;
    public static String password;
    Connection connection;


    @Override
    protected String doInBackground(Void... arg0) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            System.err.println("Cannot create connection");
        }
        try {

            setConnection();

           // String sql = "SELECT user_password from Student WHERE student_id ='"+this.selectSutdent_id()+"'";
            String sql = "SELECT user_password from Student WHERE student_id =129";
            PreparedStatement stmt = connection.prepareStatement(sql);



            ResultSet rs;
            rs = stmt.executeQuery();


            /*while (rs.next()) {
                password= rs.getString("user_password");
            }*/

        } catch (Exception e) {
            System.err.println(e);

        }

        return password;
    }




    protected void onPostExecute(String auth2) {

    }


    public void setConnection() throws SQLException {
        String server = "sql11.freemysqlhosting.net";
        String database = "sql11163131";
        String user_name = "sql11163131";
        String pass_word = " wi4gXfVvT3";
        String connectionString = "jdbc:mysql://" + server + "/" + database + "?user=" + user_name + "&password=" + pass_word;
        connection = DriverManager.getConnection(connectionString);
        password= "c";
    }

    public int selectSutdent_id() throws SQLException {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            setConnection();
            Statement stmt = connection.createStatement();
            //String sql = "SELECT student_id from Student WHERE username = '"+this.username+"'";
            String sql = "SELECT student_id from Student WHERE username ='"+MainActivity.username+"'";
            ResultSet r= ((java.sql.Statement) stmt).executeQuery(sql);
            while(r.next()){
                this.student_id= r.getInt(1);

            }return  this.student_id;
        }catch(Exception e){
            System.out.println( "Her skjedde det noe feil:" + e);
        }return 0;


    }



}
