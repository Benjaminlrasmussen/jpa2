package com.mycompany.jpa1;

import java.io.Serializable;
import javax.persistence.Entity;

/**
 *
 * @author Bade
 */
@Entity
public class PaperBook extends Book implements Serializable
{
    
    private static final long serialVersionUID = 1L;

    private double shippingWeight;
    private boolean inStock;
    
    public PaperBook()
    {
    }

    public PaperBook(long id, String title, String author, double shippingWeight, boolean inStock)
    {
        super(id, title, author, 0);
        this.shippingWeight = shippingWeight;
        this.inStock = inStock;
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
        if (!(object instanceof PaperBook))
        {
            return false;
        }
        PaperBook other = (PaperBook) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
            return false;
        return true;
    }

    @Override
    public String toString()
    {
        return "com.mycompany.jpa1.PaperBook[ id=" + id + " ]";
    }

    public double getShippingWeight()
    {
        return shippingWeight;
    }

    public void setShippingWeight(double shippinWeight)
    {
        this.shippingWeight = shippinWeight;
    }

    public boolean isInStock()
    {
        return inStock;
    }

    public void setInStock(boolean inStock)
    {
        this.inStock = inStock;
    }
    
}
