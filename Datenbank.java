package Datenbanken;

import javax.sound.midi.Soundbank;
import java.sql.*;

public class Datenbank {

    // drivermanager -> connection
    // connection -> statement
    // statement -> ResultSet  / beim lesen

    //1 1. anmeldendaten
    static String url = "jdbc:mysql://localhost:3306/onlineshop";
    static String username = "root";
    static String password = "";

    static Connection connection = null;

    public static void Connect() {
        // Verbindung aufbauen
        try {
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connection established");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    //CRUD

    //Read
    public static void Read() {
        try {
            String query = "Select * from produkte";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int artikelnummer = resultSet.getInt("artikelnummer");
                String produktname = resultSet.getString("produktname");
                Double preise = resultSet.getDouble("preis");
                String beschreibung = resultSet.getString("beschreibung");
                int anzahl = resultSet.getInt("anzahl");

                System.out.println(artikelnummer + " | " + produktname + " | " + preise + " | " + beschreibung + " | " + anzahl);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    public static void Delete(int id) {
        try {
            String query = "Delete from produkte where id=?;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static Produkte GetProductById(int id) {
        Produkte produkt = null;

        try {
            String query = "SELECT * FROM produkte WHERE id=? ;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int pid = resultSet.getInt("id");
                int artikelnummer = resultSet.getInt("artikelnummer");
                String produktname = resultSet.getString("produktname");
                Double preise = resultSet.getDouble("preis");
                String beschreibung = resultSet.getString("beschreibung");
                int anzahl = resultSet.getInt("anzahl");
                Produkte prod = new Produkte(pid,artikelnummer,produktname,preise,beschreibung,anzahl);
                        return prod;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return produkt;
    }

    public static boolean CheckProductById(int id) {

        try {
            String query = "SELECT * FROM produkte WHERE id=? ;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
               return true;
            }


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return false;
    }


    public static void Insert(Produkte produkt) {
        try {

            String query = "CALL InsertPRPDUKT(?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, produkt.artikelnummer);
            preparedStatement.setString(2, produkt.produktname);
            preparedStatement.setDouble(3, produkt.preis);
            preparedStatement.setString(4, produkt.beschreibung);
            preparedStatement.setInt(5, produkt.anzahl);

            preparedStatement.executeQuery();
            System.out.println("Produkt wurde eingefügt!");
            //Datenbank.Read();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void UpdateProdukt(Produkte produkt1) {
        try {
            String query = "CALL UpdateProdukt(?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, produkt1.artikelnummer);
            preparedStatement.setString(2, produkt1.produktname);
            preparedStatement.setDouble(3, produkt1.preis);
            preparedStatement.setString(4, produkt1.beschreibung);
            preparedStatement.setInt(5, produkt1.anzahl);

            preparedStatement.setInt(6, produkt1.id);
            preparedStatement.executeQuery();
            System.out.println("Produkt wurde updated!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


}
