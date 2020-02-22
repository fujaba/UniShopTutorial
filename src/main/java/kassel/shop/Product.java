package kassel.shop;
import java.beans.PropertyChangeSupport;
import java.beans.PropertyChangeListener;

public class Product  
{
   public double getItems() {
      double sum = 0.0;
      for (Pack pack : this.getPacks()) {
         sum += pack.getItems();
      }
      return sum;
   }

   public static final String PROPERTY_id = "id";

   private String id;

   public String getId()
   {
      return id;
   }

   public Product setId(String value)
   {
      if (value == null ? this.id != null : ! value.equals(this.id))
      {
         String oldValue = this.id;
         this.id = value;
         firePropertyChange("id", oldValue, value);
      }
      return this;
   }

   public static final String PROPERTY_description = "description";

   private String description;

   public String getDescription()
   {
      return description;
   }

   public Product setDescription(String value)
   {
      if (value == null ? this.description != null : ! value.equals(this.description))
      {
         String oldValue = this.description;
         this.description = value;
         firePropertyChange("description", oldValue, value);
      }
      return this;
   }

   public static final String PROPERTY_store = "store";

   private Store store = null;

   public Store getStore()
   {
      return this.store;
   }

   public Product setStore(Store value)
   {
      if (this.store != value)
      {
         Store oldValue = this.store;
         if (this.store != null)
         {
            this.store = null;
            oldValue.withoutProducts(this);
         }
         this.store = value;
         if (value != null)
         {
            value.withProducts(this);
         }
         firePropertyChange("store", oldValue, value);
      }
      return this;
   }

   public static final java.util.ArrayList<Pack> EMPTY___PACKS = new java.util.ArrayList<Pack>()
   { @Override public boolean add(Pack value){ throw new UnsupportedOperationException("No direct add! Use xy.withLots(obj)"); }};

   private java.util.ArrayList<Pack> packs = null;

   public java.util.ArrayList<Pack> getPacks()
   {
      if (this.packs == null)
      {
         return EMPTY_packs;
      }

      return this.packs;
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

   @Override
   public String toString()
   {
      StringBuilder result = new StringBuilder();

      result.append(" ").append(this.getId());
      result.append(" ").append(this.getDescription());


      return result.substring(1);
   }

   public void removeYou()
   {
      this.setStore(null);

      this.withoutPacks(this.getPacks().clone());


   }

   public static final java.util.ArrayList<Pack> EMPTY_packs = new java.util.ArrayList<Pack>()
   { @Override public boolean add(Pack value){ throw new UnsupportedOperationException("No direct add! Use xy.withPacks(obj)"); }};

   public static final String PROPERTY_packs = "packs";

   public Product withPacks(Object... value)
   {
      if(value==null) return this;
      for (Object item : value)
      {
         if (item == null) continue;
         if (item instanceof java.util.Collection)
         {
            for (Object i : (java.util.Collection) item)
            {
               this.withPacks(i);
            }
         }
         else if (item instanceof Pack)
         {
            if (this.packs == null)
            {
               this.packs = new java.util.ArrayList<Pack>();
            }
            if ( ! this.packs.contains(item))
            {
               this.packs.add((Pack)item);
               ((Pack)item).setProduct(this);
               firePropertyChange("packs", null, item);
            }
         }
         else throw new IllegalArgumentException();
      }
      return this;
   }

   public Product withoutPacks(Object... value)
   {
      if (this.packs == null || value==null) return this;
      for (Object item : value)
      {
         if (item == null) continue;
         if (item instanceof java.util.Collection)
         {
            for (Object i : (java.util.Collection) item)
            {
               this.withoutPacks(i);
            }
         }
         else if (item instanceof Pack)
         {
            if (this.packs.contains(item))
            {
               this.packs.remove((Pack)item);
               ((Pack)item).setProduct(null);
               firePropertyChange("packs", item, null);
            }
         }
      }
      return this;
   }

}
