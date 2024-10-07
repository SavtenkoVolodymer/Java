package org.example;

import org.example.Client.ClientDAO;
import org.example.Client.ClientDTO;
import org.example.Manager.ManagerDAO;
import org.example.Manager.ManagerDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Authorizer {

    public ClientDAO register(ClientDTO client) {
        String configFile = "C:\\Users\\User\\Documents\\Java\\Lab5\\src\\main\\resources\\config.properties";
        try {
            Connection connection = ConnectorDB.getConnection(configFile);
            String query = "INSERT INTO client(name,DateOfBirth,password)" +
                    " VALUES (?,?,?)";

            PreparedStatement preparedStatement = connection.prepareStatement(query);

            try {
                preparedStatement.setString(1, client.getName());
                preparedStatement.setString(2, client.getDateOfBirth());
                preparedStatement.setInt(3, client.getPassword());

                int result = preparedStatement.executeUpdate();
                System.out.println("Registration is done " + result);

                return new ClientDAO(client);

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public ManagerDAO managerAuthorization(String name, int password){
        String configFile = "C:\\Users\\User\\Documents\\Java\\Lab5\\src\\main\\resources\\config.properties";
        try{
            Connection connection = ConnectorDB.getConnection(configFile);
            String query = "SELECT * FROM manager ";
            ResultSet resultSet = connection.createStatement().executeQuery(query);

            try{
                while (resultSet.next()){
                    if (resultSet.getString("name") .equals(name)&&resultSet.getInt("password")==password) {
                        ManagerDTO managerDTO = new ManagerDTO(
                                resultSet.getInt(1),
                                resultSet.getString(2),
                                resultSet.getString(3),
                                resultSet.getInt(4)
                        );
                        System.out.println("You have authorized as manager");
                        return new ManagerDAO(managerDTO);
                    }
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public ClientDAO clientAuthorization(String name , int password){
        String configFile = "C:\\Users\\User\\Documents\\Java\\Lab5\\src\\main\\resources\\config.properties";
        try{
            Connection connection = ConnectorDB.getConnection(configFile);
            String query = "SELECT * FROM client";
            ResultSet resultSet = connection.createStatement().executeQuery(query);
            try{
                while(resultSet.next()){
                    if (resultSet.getString("name") .equals(name)&&resultSet.getInt("password")==password) {
                        ClientDTO clientDTO =  new ClientDTO(
                                resultSet.getInt(1),
                                resultSet.getString(2),
                                resultSet.getString(3),
                                resultSet.getInt(4)

                        );
                        System.out.println("You have authorized");
                        return new ClientDAO(clientDTO);

                    }
                }

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}
