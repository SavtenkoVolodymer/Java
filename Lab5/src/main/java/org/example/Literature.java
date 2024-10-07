package org.example;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Literature {
    private int idLiterature;
    private String author;
    private String type;
    private String name;
    private String ReturnDate;
    private String TakingDate;



    public Literature(int idLiterature, String author, String type, String name, String returnDate, String publicationDate) {
        this.idLiterature = idLiterature;
        this.author = author;
        this.type = type;
        this.name = name;
        this.ReturnDate = returnDate;
        this.TakingDate = publicationDate;
    }

    @Override
    public String toString() {
        return idLiterature + " " + author + " " + type + " " + name + " " + ReturnDate + " " + TakingDate;
    }
}

