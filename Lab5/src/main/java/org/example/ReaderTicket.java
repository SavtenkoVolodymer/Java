package org.example;
import lombok.Getter;
import lombok.Setter;
import org.example.Client.ClientDAO;
import org.example.Client.ClientDTO;
import org.example.Manager.ManagerDAO;
import org.example.Manager.ManagerDTO;

import java.awt.print.Book;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ReaderTicket {
    private int id;
    private List<Literature> literatureList = new ArrayList<>();

    public ReaderTicket(int id, List<Literature> literatureList) {
        this.id = id;
        this.literatureList = literatureList;

    }



    public void setLiterature(){
        String configFile = "C:\\Users\\User\\Documents\\Java\\Lab5\\src\\main\\resources\\config.properties";
        try{
            Connection connection = ConnectorDB.getConnection(configFile);
            String query = "SELECT * FROM literature ";
            ResultSet resultSet = connection.createStatement().executeQuery(query);

            try{
                while (resultSet.next()){
                    if (resultSet.getInt(7) == this.id) {
                        Literature literature = new Literature(
                                resultSet.getInt(1),
                                resultSet.getString(2),
                                resultSet.getString(3),
                                resultSet.getString(4),
                                resultSet.getString(5),
                                resultSet.getString(6)
                        );
                        this.literatureList.add(literature);
                    }
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return id + " " + literatureList.toString();
    }
}
