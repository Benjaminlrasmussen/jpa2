package com.mycompany.jpa1;

import java.io.Serializable;
import javax.persistence.Entity;

@Entity
public class EBook extends Book implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String downloadURL;
    private double sizeMB;
    
    public EBook()
    {
    }
    
    public EBook(long id, String title, String author, String downloadURL, double sizeMB)
    {
        super(id, title, author, 0);
        this.downloadURL = downloadURL;
        this.sizeMB = sizeMB;
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
        if (!(object instanceof EBook))
        {
            return false;
        }
        EBook other = (EBook) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
            return false;
        return true;
    }

    @Override
    public String toString()
    {
        return "com.mycompany.jpa1.EBook[ id=" + id + " ]";
    }

    public String getDownloadURL()
    {
        return downloadURL;
    }

    public void setDownloadURL(String downloadURL)
    {
        this.downloadURL = downloadURL;
    }

    public double getSizeMB()
    {
        return sizeMB;
    }

    public void setSizeMB(double sizeMB)
    {
        this.sizeMB = sizeMB;
    }
}
