package com.mycompany.jpa1;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Book implements Serializable
{

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "isbn")
    protected Long id;
    protected String title;
    protected String author;
    protected double price;

    public Book()
    {
    }
    
    public Book(Long id, String title, String author, double price)
    {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
    }
    
    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Book))
        {
            return false;
        }
        Book other = (Book) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
            return false;
        return true;
    }

    @Override
    public String toString()
    {
        return "com.mycompany.jpa1.Book[ id=" + id + " ]";
    }

    public Long getIsbn()
    {
        return id;
    }

    public void setIsbn(Long id)
    {
        this.id = id;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getAuthor()
    {
        return author;
    }

    public void setAuthor(String author)
    {
        this.author = author;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }
}
