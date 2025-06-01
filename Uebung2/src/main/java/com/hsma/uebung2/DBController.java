package com.hsma.uebung2;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;


public class DBController {
    private Connection connection;
    private ArrayList<Rezept> rezepte;
    private HashMap<Integer, Rezept> rezepteMap;


    public DBController() {
        String query = "SELECT * FROM Rezepte";
        rezepte = new ArrayList<>();
        rezepteMap = new HashMap<>();

        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:src/main/resources/static/Rezepte.db");
        } catch(Exception e) {
            e.printStackTrace();
        }

        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {

                Rezept rezept = new Rezept(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("zutaten").split(","),
                        rs.getString("zubereitung"),
                        rs.getString("Datum"),
                        rs.getString("Autor")
                );
                rezepte.add(rezept);

                for(Rezept p : rezepte) {
                    rezepteMap.put(p.getId(), p);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public HashMap<Integer, Rezept> getAllRezepte() {
        return rezepteMap;
    }

    public Rezept getRezept(int id) {
        return rezepteMap.get(id);
    }

}
