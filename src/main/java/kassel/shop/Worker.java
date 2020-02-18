package kassel.shop;
import java.beans.PropertyChangeSupport;
import java.beans.PropertyChangeListener;

public class Worker  
{

   public static final String PROPERTY_name = "name";

   private String name;

   public String getName()
   {
      return name;
   }

   public Worker setName(String value)
   {
      if (value == null ? this.name != null : ! value.equals(this.name))
      {
         String oldValue = this.name;
         this.name = value;
         firePropertyChange("name", oldValue, value);
      }
      return this;
   }

   public static final String PROPERTY_store = "store";

   private Store store;

   public Store getStore()
   {
      return store;
   }

   public Worker setStore(Store value)
   {
      if (value != this.store)
      {
         Store oldValue = this.store;
         this.store = value;
         firePropertyChange("store", oldValue, value);
      }
      return this;
   }

   public static final java.util.ArrayList<LogEntry> EMPTY_logEntries = new java.util.ArrayList<LogEntry>()
   { @Override public boolean add(LogEntry value){ throw new UnsupportedOperationException("No direct add! Use xy.withLogEntries(obj)"); }};

   public static final String PROPERTY_logEntries = "logEntries";

   private java.util.ArrayList<LogEntry> logEntries = null;

   public java.util.ArrayList<LogEntry> getLogEntries()
   {
      if (this.logEntries == null)
      {
         return EMPTY_logEntries;
      }

      return this.logEntries;
   }

   public Worker withLogEntries(Object... value)
   {
      if(value==null) return this;
      for (Object item : value)
      {
         if (item == null) continue;
         if (item instanceof java.util.Collection)
         {
            for (Object i : (java.util.Collection) item)
            {
               this.withLogEntries(i);
            }
         }
         else if (item instanceof LogEntry)
         {
            if (this.logEntries == null)
            {
               this.logEntries = new java.util.ArrayList<LogEntry>();
            }
            if ( ! this.logEntries.contains(item))
            {
               this.logEntries.add((LogEntry)item);
               ((LogEntry)item).setWorker(this);
               firePropertyChange("logEntries", null, item);
            }
         }
         else throw new IllegalArgumentException();
      }
      return this;
   }

   public Worker withoutLogEntries(Object... value)
   {
      if (this.logEntries == null || value==null) return this;
      for (Object item : value)
      {
         if (item == null) continue;
         if (item instanceof java.util.Collection)
         {
            for (Object i : (java.util.Collection) item)
            {
               this.withoutLogEntries(i);
            }
         }
         else if (item instanceof LogEntry)
         {
            if (this.logEntries.contains(item))
            {
               this.logEntries.remove((LogEntry)item);
               ((LogEntry)item).setWorker(null);
               firePropertyChange("logEntries", item, null);
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

      result.append(" ").append(this.getName());


      return result.substring(1);
   }

   public void removeYou()
   {
      this.withoutLogEntries(this.getLogEntries().clone());


   }

}