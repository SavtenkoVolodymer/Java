package org.example;

import org.example.Client.ClientDAO;
import org.example.Client.ClientDTO;
import org.example.Manager.ManagerDAO;
import org.example.Manager.ManagerDTO;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static List<Literature> sortByAuthors(List<Literature> list, String author) {
        List<Literature> literatureList = new ArrayList<>();
        for (Literature literature : list) {
            if (literature.getAuthor().equals(author)) {
                literatureList.add(literature);
            }
        }
        return literatureList;

    }

    public static List<Literature> sortByType(List<Literature> list, String type) {
        List<Literature> ListLiterature = new ArrayList<>();
        for (Literature literature : list) {
            if (literature.getType().equals(type)) {
                ListLiterature.add(literature);
            }
        }
        return ListLiterature;
    }

    public static List<Literature> sortByDate(List<Literature> list, String date) {
        List<Literature> ListLit = new ArrayList<>();
        for (Literature literature : list) {
            if (literature.getTakingDate().equals(date)) {
                ListLit.add(literature);
            }
        }
        return ListLit;
    }


    public static void main(String[] args) {

        Authorizer authorizer = new Authorizer();
        String password = "777";
        ManagerDTO managerDTO = new ManagerDTO(2, "Oleksandr", "2006-02-23", password.hashCode());
        ManagerDAO managerDAO =
                authorizer.managerAuthorization(managerDTO.getName(), password.hashCode());

//        Authorizer authorizer = new Authorizer();
//    String password = "777";
//    ClientDTO clientDTO = new ClientDTO(5,"Vasya","2003-01-13",password.hashCode());
//        ClientDAO clientDAO =
//    authorizer.clientAuthorization(clientDTO.getName(), password.hashCode());

        //Sort1
        List<ClientDAO> clientDAOList = new ArrayList<>();
        clientDAOList = managerDAO.getClientList();
        clientDAOList.stream().sorted(Comparator.comparingInt(ClientDAO::amountLiterature).reversed()).toList().forEach(System.out::println);
        System.out.println();
        //Sort2(1)
        List<Literature> literatureList = new ArrayList<>();
        literatureList = managerDAO.getLiteratureList();
        List<Literature> sortedByAuthors = sortByAuthors(literatureList, "Taras Shevchenko");
        sortedByAuthors.forEach(System.out::println);
        System.out.println();
        //Sort2(2)
        List<Literature> ListLiterature = new ArrayList<>();
        ListLiterature = managerDAO.getLiteratureList();
        List<Literature> sortedByType = sortByType(ListLiterature, "Fiction");
        sortedByType.forEach(System.out::println);
        System.out.println();
        //Sort2(3)
        List<Literature> ListLit = new ArrayList<>();
        ListLit = managerDAO.getLiteratureList();
        List<Literature> sortedByDate = sortByDate(ListLit, "1798-04-18");
        sortedByDate.forEach(System.out::println);
        System.out.println();

        List<ClientDAO> clientDAOList1 = new ArrayList<>();
        clientDAOList1 = managerDAO.getClientList();
        List<ClientDAO> clients = clientDAOList1.stream().sorted(Comparator.comparingInt(ClientDAO::amountLiterature).reversed()).toList();
        System.out.println(clients.getFirst());
    }
}





//        List<Literature> list = List.of(
//                new Literature(1,"Ivan Franko","Fiction","Kobzar","1912-02-23","1918-03-18"),
//                new Literature(2,"Taras Shevchenko","Nonfiction","Zapovit","1837-01-21","1847-03-12"),
//                new Literature(3,"Ivan Kotlyarevskyi","Fiction","Eneida","1780-02-23","1798-04-18")
//
//        );
////

