package kassel.shop;
import java.beans.PropertyChangeSupport;
import java.beans.PropertyChangeListener;

public class Place  
{

   public static final String PROPERTY_id = "id";

   private String id;

   public String getId()
   {
      return id;
   }

   public Place setId(String value)
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

   public Place setStore(Store value)
   {
      if (this.store != value)
      {
         Store oldValue = this.store;
         if (this.store != null)
         {
            this.store = null;
            oldValue.withoutPlaces(this);
         }
         this.store = value;
         if (value != null)
         {
            value.withPlaces(this);
         }
         firePropertyChange("store", oldValue, value);
      }
      return this;
   }

   public static final java.util.ArrayList<Lot> EMPTY_lots = new java.util.ArrayList<Lot>()
   { @Override public boolean add(Lot value){ throw new UnsupportedOperationException("No direct add! Use xy.withLots(obj)"); }};

   public static final String PROPERTY_lots = "lots";

   private java.util.ArrayList<Lot> lots = null;

   public java.util.ArrayList<Lot> getLots()
   {
      if (this.lots == null)
      {
         return EMPTY_lots;
      }

      return this.lots;
   }

   public Place withLots(Object... value)
   {
      if(value==null) return this;
      for (Object item : value)
      {
         if (item == null) continue;
         if (item instanceof java.util.Collection)
         {
            for (Object i : (java.util.Collection) item)
            {
               this.withLots(i);
            }
         }
         else if (item instanceof Lot)
         {
            if (this.lots == null)
            {
               this.lots = new java.util.ArrayList<Lot>();
            }
            if ( ! this.lots.contains(item))
            {
               this.lots.add((Lot)item);
               ((Lot)item).setPlace(this);
               firePropertyChange("lots", null, item);
            }
         }
         else throw new IllegalArgumentException();
      }
      return this;
   }

   public Place withoutLots(Object... value)
   {
      if (this.lots == null || value==null) return this;
      for (Object item : value)
      {
         if (item == null) continue;
         if (item instanceof java.util.Collection)
         {
            for (Object i : (java.util.Collection) item)
            {
               this.withoutLots(i);
            }
         }
         else if (item instanceof Lot)
         {
            if (this.lots.contains(item))
            {
               this.lots.remove((Lot)item);
               ((Lot)item).setPlace(null);
               firePropertyChange("lots", item, null);
            }
         }
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

   @Override
   public String toString()
   {
      StringBuilder result = new StringBuilder();

      result.append(" ").append(this.getId());


      return result.substring(1);
   }

   public void removeYou()
   {
      this.setStore(null);

      this.withoutLots(this.getLots().clone());


   }

}