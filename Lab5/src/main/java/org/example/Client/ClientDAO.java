package org.example.Client;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.example.ConnectorDB;
import org.example.Literature;
import org.example.ReaderTicket;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Setter
@Getter


public class ClientDAO {
    ClientDTO client;
    ReaderTicket readerTicket;

    public ClientDAO(ClientDTO client) {
        this.client = client;
        this.setReaderTicket();
    }

    public void addReadTicket(ReaderTicket readerTicket) {
        String configFile = "C:\\Users\\User\\Documents\\Java\\Lab5\\src\\main\\resources\\config.properties";
        try {
            Connection connection = ConnectorDB.getConnection(configFile);
            String query = "INSERT INTO readerticket (Client_idClient) VALUES (?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            try {
                preparedStatement.setInt(1, this.client.getIdClient());

                int result = preparedStatement.executeUpdate();
                System.out.println("Rows affected: " + result);
                preparedStatement.close();
                connection.close();

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            } finally {
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void takeTicket(ReaderTicket readerTicket) {
        String configFile = "C:\\Users\\User\\Documents\\Java\\Lab5\\src\\main\\resources\\config.properties";
        try {
            Connection connection = ConnectorDB.getConnection(configFile);
            String query = "SELECT * FROM readerticket ";
            ResultSet resultSet = connection.createStatement().executeQuery(query);
            try {
                while (resultSet.next()) {
                    if (resultSet.getInt(1) == readerTicket.getId()) {
                        this.readerTicket = readerTicket;
                    }
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            } finally {
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void cancelLiterature() {
        String configFile = "C:\\Users\\User\\Documents\\Java\\Lab5\\src\\main\\resources\\config.properties";
        try {
            Connection connection = ConnectorDB.getConnection(configFile);
            String query = "DELETE FROM literature WHERE idLiterature=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            for(Literature literature: readerTicket.getLiteratureList()){
                try{
                    preparedStatement.setInt(1,literature.getIdLiterature());
                }catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void setReaderTicket() {
        String configFile = "C:\\Users\\User\\Documents\\Java\\Lab5\\src\\main\\resources\\config.properties";
        try{
            Connection connection = ConnectorDB.getConnection(configFile);
            String query = "SELECT * FROM readerticket;";
            ResultSet resultSet = connection.createStatement().executeQuery(query);

            try{
                while (resultSet.next()){
                    if (resultSet.getInt(2)==this.getClient().getIdClient()) {
                        ReaderTicket readerTicket1 = new ReaderTicket(
                                resultSet.getInt(1),
                                new ArrayList<>()
                        );
                        readerTicket1.setLiterature();
                        this.readerTicket = readerTicket1;
                    }
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int amountLiterature() {
        if (readerTicket != null) {
            return readerTicket.getLiteratureList().size();
        } else {
            System.out.println("Reader ticket is not set.");
            return 0;
        }
    }


    public void showLiterature() {
        for (Literature literature : readerTicket.getLiteratureList()) {
            System.out.println(literature.getIdLiterature());
        }
    }

    @Override
    public String toString() {
        return client.toString();
    }
}
