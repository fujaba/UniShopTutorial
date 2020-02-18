package kassel.shop;
import java.beans.PropertyChangeSupport;
import java.beans.PropertyChangeListener;

public class Customer  
{

   public static final String PROPERTY_name = "name";

   private String name;

   public String getName()
   {
      return name;
   }

   public Customer setName(String value)
   {
      if (value == null ? this.name != null : ! value.equals(this.name))
      {
         String oldValue = this.name;
         this.name = value;
         firePropertyChange("name", oldValue, value);
      }
      return this;
   }

   public static final String PROPERTY_address = "address";

   private String address;

   public String getAddress()
   {
      return address;
   }

   public Customer setAddress(String value)
   {
      if (value == null ? this.address != null : ! value.equals(this.address))
      {
         String oldValue = this.address;
         this.address = value;
         firePropertyChange("address", oldValue, value);
      }
      return this;
   }

   public static final java.util.ArrayList<Order> EMPTY_orders = new java.util.ArrayList<Order>()
   { @Override public boolean add(Order value){ throw new UnsupportedOperationException("No direct add! Use xy.withOrders(obj)"); }};

   public static final String PROPERTY_orders = "orders";

   private java.util.ArrayList<Order> orders = null;

   public java.util.ArrayList<Order> getOrders()
   {
      if (this.orders == null)
      {
         return EMPTY_orders;
      }

      return this.orders;
   }

   public Customer withOrders(Object... value)
   {
      if(value==null) return this;
      for (Object item : value)
      {
         if (item == null) continue;
         if (item instanceof java.util.Collection)
         {
            for (Object i : (java.util.Collection) item)
            {
               this.withOrders(i);
            }
         }
         else if (item instanceof Order)
         {
            if (this.orders == null)
            {
               this.orders = new java.util.ArrayList<Order>();
            }
            if ( ! this.orders.contains(item))
            {
               this.orders.add((Order)item);
               ((Order)item).setCustomer(this);
               firePropertyChange("orders", null, item);
            }
         }
         else throw new IllegalArgumentException();
      }
      return this;
   }

   public Customer withoutOrders(Object... value)
   {
      if (this.orders == null || value==null) return this;
      for (Object item : value)
      {
         if (item == null) continue;
         if (item instanceof java.util.Collection)
         {
            for (Object i : (java.util.Collection) item)
            {
               this.withoutOrders(i);
            }
         }
         else if (item instanceof Order)
         {
            if (this.orders.contains(item))
            {
               this.orders.remove((Order)item);
               ((Order)item).setCustomer(null);
               firePropertyChange("orders", item, null);
            }
         }
      }
      return this;
   }

   public static final String PROPERTY_vendor = "vendor";

   private Store vendor = null;

   public Store getVendor()
   {
      return this.vendor;
   }

   public Customer setVendor(Store value)
   {
      if (this.vendor != value)
      {
         Store oldValue = this.vendor;
         if (this.vendor != null)
         {
            this.vendor = null;
            oldValue.withoutCustomers(this);
         }
         this.vendor = value;
         if (value != null)
         {
            value.withCustomers(this);
         }
         firePropertyChange("vendor", oldValue, value);
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
      result.append(" ").append(this.getAddress());


      return result.substring(1);
   }

   public void removeYou()
   {
      this.setVendor(null);

      this.withoutOrders(this.getOrders().clone());


   }

}