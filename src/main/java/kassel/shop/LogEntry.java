package kassel.shop;
import java.beans.PropertyChangeSupport;
import java.beans.PropertyChangeListener;

public class LogEntry  
{

   public static final String PROPERTY_id = "id";

   private String id;

   public String getId()
   {
      return id;
   }

   public LogEntry setId(String value)
   {
      if (value == null ? this.id != null : ! value.equals(this.id))
      {
         String oldValue = this.id;
         this.id = value;
         firePropertyChange("id", oldValue, value);
      }
      return this;
   }

   public static final String PROPERTY_time = "time";

   private String time;

   public String getTime()
   {
      return time;
   }

   public LogEntry setTime(String value)
   {
      if (value == null ? this.time != null : ! value.equals(this.time))
      {
         String oldValue = this.time;
         this.time = value;
         firePropertyChange("time", oldValue, value);
      }
      return this;
   }

   public static final String PROPERTY_task = "task";

   private String task;

   public String getTask()
   {
      return task;
   }

   public LogEntry setTask(String value)
   {
      if (value == null ? this.task != null : ! value.equals(this.task))
      {
         String oldValue = this.task;
         this.task = value;
         firePropertyChange("task", oldValue, value);
      }
      return this;
   }

   public static final String PROPERTY_lot = "lot";

   private Lot lot;

   public Lot getLot()
   {
      return lot;
   }

   public LogEntry setLot(Lot value)
   {
      if (value != this.lot)
      {
         Lot oldValue = this.lot;
         this.lot = value;
         firePropertyChange("lot", oldValue, value);
      }
      return this;
   }

   public static final String PROPERTY_offer = "offer";

   private Offer offer;

   public Offer getOffer()
   {
      return offer;
   }

   public LogEntry setOffer(Offer value)
   {
      if (value != this.offer)
      {
         Offer oldValue = this.offer;
         this.offer = value;
         firePropertyChange("offer", oldValue, value);
      }
      return this;
   }

   public static final String PROPERTY_order = "order";

   private Order order;

   public Order getOrder()
   {
      return order;
   }

   public LogEntry setOrder(Order value)
   {
      if (value != this.order)
      {
         Order oldValue = this.order;
         this.order = value;
         firePropertyChange("order", oldValue, value);
      }
      return this;
   }

   public static final String PROPERTY_store = "store";

   private Store store = null;

   public Store getStore()
   {
      return this.store;
   }

   public LogEntry setStore(Store value)
   {
      if (this.store != value)
      {
         Store oldValue = this.store;
         if (this.store != null)
         {
            this.store = null;
            oldValue.withoutLogEntries(this);
         }
         this.store = value;
         if (value != null)
         {
            value.withLogEntries(this);
         }
         firePropertyChange("store", oldValue, value);
      }
      return this;
   }

   public static final String PROPERTY_worker = "worker";

   private Worker worker = null;

   public Worker getWorker()
   {
      return this.worker;
   }

   public LogEntry setWorker(Worker value)
   {
      if (this.worker != value)
      {
         Worker oldValue = this.worker;
         if (this.worker != null)
         {
            this.worker = null;
            oldValue.withoutLogEntries(this);
         }
         this.worker = value;
         if (value != null)
         {
            value.withLogEntries(this);
         }
         firePropertyChange("worker", oldValue, value);
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
      result.append(" ").append(this.getTime());
      result.append(" ").append(this.getTask());


      return result.substring(1);
   }

   public void removeYou()
   {
      this.setStore(null);
      this.setWorker(null);

   }

}