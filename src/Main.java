


import java.sql.*;

import java.util.ArrayList;


public class Main {

    //"insert into customers(customerNumber,customerName,contactFirstName,contactLastName,phone,city,addressline1,country) values(101,'Halil Mert Develi','Halil','develi','05428789963','istanbul','fatih','Turkey'"
    public static void main(String[] args) {
        Connection connection = null;
        DbHelper dbHelper = new DbHelper();

        PreparedStatement statement = null;
        ResultSet resultset;


        try {
            connection = dbHelper.getConnection();
            String sql = "insert into customers(customernumber," +
                    "customerName,contactFirstName,contactLastName,phone,city," +
                    "addressline1,country) values(?,?,?,?,?,?,?,?)";
            statement = connection.prepareStatement(sql);
            statement.setInt(1,444);
            statement.setString(2,"Kemal Genc");
            statement.setString(3,"Kemal");
            statement.setString(4,"Genc");
            statement.setString(5,"0542519523");
            statement.setString(6,"Trabizon");
            statement.setString(7,"Hacihüsrev");
            statement.setString(8,"Turkey");

            int result =  statement.executeUpdate();
            System.out.println("Record has been added and effected row number = "+result);

        } catch (SQLException sqlException) {
            dbHelper.showSqlException(sqlException);
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

    }


    public static void selectDemo() {
        Connection connection = null;
        DbHelper dbHelper = new DbHelper();

        Statement statement = null;
        ResultSet resultset;

        try {
            connection = dbHelper.getConnection();
            statement = connection.createStatement();
            resultset = statement.executeQuery("select customerName,contactFirstName,phone,city from customers\n");
            ArrayList<Customer> customerList = new ArrayList<Customer>();
            while (resultset.next()) {
                customerList.add(new Customer(
                        resultset.getString("customerName"),
                        resultset.getString("contactFirstName"),
                        resultset.getString("phone"),
                        resultset.getString("city")
                ));
            }
            System.out.println(customerList.size());

        } catch (SQLException sqlException) {
            dbHelper.showSqlException(sqlException);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}