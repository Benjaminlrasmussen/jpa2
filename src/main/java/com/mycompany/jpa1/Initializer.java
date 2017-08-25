package com.mycompany.jpa1;

import java.util.HashMap;
import java.util.List;
import javax.persistence.Persistence;

public class Initializer
{
    public static void main(String[] args)
    {
        /////// Setup //////////////////
        HashMap puproperties = new HashMap();

        puproperties.put("javax.persistence.sql-load-script-source", "scripts/drop_all.sql");
        Persistence.generateSchema("jpaPU", puproperties);
        
        puproperties.remove("javax.persistence.sql-load-script-source");
        Persistence.generateSchema("jpaPU", puproperties);
        ////////////////////////////////
        
        Facade facade = new Facade(Persistence.createEntityManagerFactory("jpaPU"));
        
        EBook eBook = new EBook(5500666, "TheBook", "H.C Andersen", "www.downloadebooks.dk", 2.5);
        facade.createEBook(eBook);
        
        System.out.println("Book title is: " + facade.findBook(5500666, new EBook()).getTitle());
        
        System.out.println("Book price old: " + eBook.price);
        facade.updatePrice(5500666, eBook, 10);
        System.out.println("Book price new: " + facade.findBook(5500666, eBook).getPrice());
        
        PaperBook pBook = new PaperBook(2344500, "ThePaperBook", "H.C Ørsted", 1.2, true);
        facade.createPaperBook(pBook);
        
        List<Book> allBooks = facade.findAllBooks();
        for (int i = 0; i < allBooks.size(); i++)
        {
            System.out.println(allBooks.get(i).getTitle());
        }
        
        facade.removeBook(eBook);
    }
}
