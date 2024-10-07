package org.example.Manager;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.example.Client.ClientDAO;
import org.example.Client.ClientDTO;
import org.example.ConnectorDB;
import org.example.Literature;
import org.example.ReaderTicket;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor

public class ManagerDAO {
   ManagerDTO manager;

   public void addLiterature(Literature literature, ReaderTicket readerTicket) {
      String configFile = "C:\\Users\\User\\Documents\\Java\\Lab5\\src\\main\\resources\\config.properties";
         try {
            Connection connection = ConnectorDB.getConnection(configFile);
            String query = "INSERT INTO literature (author,type, name, ReturnDate, PublicationDate, ReaderTicket_idReaderTicket) VALUES (?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            try{
               preparedStatement.setString(1, literature.getAuthor());
               preparedStatement.setString(2, literature.getType());
               preparedStatement.setString(3, literature.getName());
               preparedStatement.setString(4, literature.getReturnDate());
               preparedStatement.setString(5, literature.getTakingDate());
               preparedStatement.setInt(6, readerTicket.getId());
               int result = preparedStatement.executeUpdate();
               System.out.println("Rows affected: " + result);
               preparedStatement.close();
               connection.close();

            }catch (SQLException e){
               System.out.println(e.getMessage());
            }finally {
               connection.close();
            }
         } catch (SQLException e) {
            System.out.println(e.getMessage());
         }
   }

   public void ChangeDate(Literature literature, String date) {
      String configFile = "C:\\Users\\User\\Documents\\Java\\Lab5\\src\\main\\resources\\config.properties";
      try {
         Connection connection = ConnectorDB.getConnection(configFile);
         String query = "UPDATE literature SET ReturnDate=? WHERE idLiterature=?";
         PreparedStatement preparedStatement = connection.prepareStatement(query);
         try{
            preparedStatement.setString(1,date);
            preparedStatement.setInt(2, literature.getIdLiterature());
         }catch (SQLException e){
            System.out.println(e.getMessage());
         }

      }catch (SQLException e){
         System.out.println(e.getMessage());
      }
   }

   public List<ClientDAO> getClientList(){
      String configFile = "C:\\Users\\User\\Documents\\Java\\Lab5\\src\\main\\resources\\config.properties";
      List<ClientDAO> clientList = new ArrayList<>();
      try{
         Connection connection = ConnectorDB.getConnection(configFile);
         String query = "SELECT * FROM client";
         ResultSet resultSet = connection.createStatement().executeQuery(query);
         try{
            while(resultSet.next()){
                  ClientDTO clientDTO =  new ClientDTO(
                          resultSet.getInt(1),
                          resultSet.getString(2),
                          resultSet.getString(3),
                          resultSet.getInt(4)

                  );
                  ClientDAO clientDAO = new ClientDAO(clientDTO);
                  clientList.add(clientDAO);
            }
            return clientList;
         } catch (SQLException e) {
            System.out.println(e.getMessage());
         }

      }
      catch(Exception e){
         System.out.println(e.getMessage());
      }
      return null;
   }

   public List<Literature> getLiteratureList(){
      String configFile = "C:\\Users\\User\\Documents\\Java\\Lab5\\src\\main\\resources\\config.properties";
      List<Literature> literatureList = new ArrayList<>();
      try{
         Connection connection = ConnectorDB.getConnection(configFile);
         String query = "SELECT * FROM literature";
         ResultSet resultSet = connection.createStatement().executeQuery(query);
         try{
            while(resultSet.next()){
               Literature literature =  new Literature(
                       resultSet.getInt(1),
                       resultSet.getString(2),
                       resultSet.getString(3),
                       resultSet.getString(4),
                       resultSet.getString(5),
                       resultSet.getString(6)


               );
               literatureList.add(literature);
            }
            return literatureList;
         } catch (SQLException e) {
            System.out.println(e.getMessage());
         }

      }
      catch(Exception e){
         System.out.println(e.getMessage());
      }
      return null;
   }

   @Override
   public String toString() {
      return manager.toString();
   }
}


