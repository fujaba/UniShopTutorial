package kassel.shop;
import java.beans.PropertyChangeSupport;
import java.beans.PropertyChangeListener;

public class Pack  
{

   public static final String PROPERTY_id = "id";

   private String id;

   public String getId()
   {
      return id;
   }

   public Pack setId(String value)
   {
      if (value == null ? this.id != null : ! value.equals(this.id))
      {
         String oldValue = this.id;
         this.id = value;
         firePropertyChange("id", oldValue, value);
      }
      return this;
   }

   public static final String PROPERTY_store = "store";

   private Store store = null;

   public Store getStore()
   {
      return this.store;
   }

   public Pack setStore(Store value)
   {
      if (this.store != value)
      {
         Store oldValue = this.store;
         if (this.store != null)
         {
            this.store = null;
            oldValue.withoutPacks(this);
         }
         this.store = value;
         if (value != null)
         {
            value.withPacks(this);
         }
         firePropertyChange("store", oldValue, value);
      }
      return this;
   }

   public static final String PROPERTY_product = "product";

   private Product product = null;

   public Product getProduct()
   {
      return this.product;
   }

   public Pack setProduct(Product value)
   {
      if (this.product != value)
      {
         Product oldValue = this.product;
         if (this.product != null)
         {
            this.product = null;
            oldValue.withoutPacks(this);
         }
         this.product = value;
         if (value != null)
         {
            value.withPacks(this);
         }
         firePropertyChange("product", oldValue, value);
      }
      return this;
   }

   public static final String PROPERTY_place = "place";

   private Place place = null;

   public Place getPlace()
   {
      return this.place;
   }

   public Pack setPlace(Place value)
   {
      if (this.place != value)
      {
         Place oldValue = this.place;
         if (this.place != null)
         {
            this.place = null;
            oldValue.withoutPacks(this);
         }
         this.place = value;
         if (value != null)
         {
            value.withPacks(this);
         }
         firePropertyChange("place", oldValue, value);
      }
      return this;
   }

   protected PropertyChangeSupport listeners = null;

   public boolean firePropertyChange(String propertyName, Object oldValue, Object newValue)
   {
      if (listeners != null)
      {
         listeners.firePropertyChange(propertyName, oldValue, newValue);
         return true;
      }
      return false;
   }

   public boolean addPropertyChangeListener(PropertyChangeListener listener)
   {
      if (listeners == null)
      {
         listeners = new PropertyChangeSupport(this);
      }
      listeners.addPropertyChangeListener(listener);
      return true;
   }

   public boolean addPropertyChangeListener(String propertyName, PropertyChangeListener listener)
   {
      if (listeners == null)
      {
         listeners = new PropertyChangeSupport(this);
      }
      listeners.addPropertyChangeListener(propertyName, listener);
      return true;
   }

   public boolean removePropertyChangeListener(PropertyChangeListener listener)
   {
      if (listeners != null)
      {
         listeners.removePropertyChangeListener(listener);
      }
      return true;
   }

   public boolean removePropertyChangeListener(String propertyName,PropertyChangeListener listener)
   {
      if (listeners != null)
      {
         listeners.removePropertyChangeListener(propertyName, listener);
      }
      return true;
   }

   public void removeYou()
   {
      this.setStore(null);
      this.setProduct(null);
      this.setPlace(null);

   }

   public static final String PROPERTY_items = "items";

   private double items;

   public double getItems()
   {
      return items;
   }

   public Pack setItems(double value)
   {
      if (value != this.items)
      {
         double oldValue = this.items;
         this.items = value;
         firePropertyChange("items", oldValue, value);
      }
      return this;
   }

   @Override
   public String toString()
   {
      StringBuilder result = new StringBuilder();

      result.append(" ").append(this.getId());


      return result.substring(1);
   }

}
