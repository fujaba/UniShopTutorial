package kassel.shop;
import java.beans.PropertyChangeSupport;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public class Store  
{

   private ArrayList<Label> labels = new ArrayList<>();

   public ArrayList<Label> getLabels()
   {
      return labels;
   }

   public static final String PROPERTY_wallTime = "wallTime";

   private String wallTime;

   public String getWallTime()
   {
      return wallTime;
   }

   public Store setWallTime(String value)
   {
      if (value == null ? this.wallTime != null : ! value.equals(this.wallTime))
      {
         String oldValue = this.wallTime;
         this.wallTime = value;
         firePropertyChange("wallTime", oldValue, value);
      }
      return this;
   }

   public static final java.util.ArrayList<Customer> EMPTY_customers = new java.util.ArrayList<Customer>()
   { @Override public boolean add(Customer value){ throw new UnsupportedOperationException("No direct add! Use xy.withCustomers(obj)"); }};

   public static final String PROPERTY_customers = "customers";

   private java.util.ArrayList<Customer> customers = null;

   public java.util.ArrayList<Customer> getCustomers()
   {
      if (this.customers == null)
      {
         return EMPTY_customers;
      }

      return this.customers;
   }

   public Store withCustomers(Object... value)
   {
      if(value==null) return this;
      for (Object item : value)
      {
         if (item == null) continue;
         if (item instanceof java.util.Collection)
         {
            for (Object i : (java.util.Collection) item)
            {
               this.withCustomers(i);
            }
         }
         else if (item instanceof Customer)
         {
            if (this.customers == null)
            {
               this.customers = new java.util.ArrayList<Customer>();
            }
            if ( ! this.customers.contains(item))
            {
               this.customers.add((Customer)item);
               ((Customer)item).setVendor(this);
               firePropertyChange("customers", null, item);
            }
         }
         else throw new IllegalArgumentException();
      }
      return this;
   }

   public Store withoutCustomers(Object... value)
   {
      if (this.customers == null || value==null) return this;
      for (Object item : value)
      {
         if (item == null) continue;
         if (item instanceof java.util.Collection)
         {
            for (Object i : (java.util.Collection) item)
            {
               this.withoutCustomers(i);
            }
         }
         else if (item instanceof Customer)
         {
            if (this.customers.contains(item))
            {
               this.customers.remove((Customer)item);
               ((Customer)item).setVendor(null);
               firePropertyChange("customers", item, null);
            }
         }
      }
      return this;
   }

   public static final java.util.ArrayList<Worker> EMPTY_workers = new java.util.ArrayList<Worker>()
   { @Override public boolean add(Worker value){ throw new UnsupportedOperationException("No direct add! Use xy.withWorkers(obj)"); }};

   public static final String PROPERTY_workers = "workers";

   private java.util.ArrayList<Worker> workers = null;

   public java.util.ArrayList<Worker> getWorkers()
   {
      if (this.workers == null)
      {
         return EMPTY_workers;
      }

      return this.workers;
   }

   public Store withWorkers(Object... value)
   {
      if(value==null) return this;
      for (Object item : value)
      {
         if (item == null) continue;
         if (item instanceof java.util.Collection)
         {
            for (Object i : (java.util.Collection) item)
            {
               this.withWorkers(i);
            }
         }
         else if (item instanceof Worker)
         {
            if (this.workers == null)
            {
               this.workers = new java.util.ArrayList<Worker>();
            }
            if ( ! this.workers.contains(item))
            {
               this.workers.add((Worker)item);
               firePropertyChange("workers", null, item);
            }
         }
         else throw new IllegalArgumentException();
      }
      return this;
   }

   public Store withoutWorkers(Object... value)
   {
      if (this.workers == null || value==null) return this;
      for (Object item : value)
      {
         if (item == null) continue;
         if (item instanceof java.util.Collection)
         {
            for (Object i : (java.util.Collection) item)
            {
               this.withoutWorkers(i);
            }
         }
         else if (item instanceof Worker)
         {
            if (this.workers.contains(item))
            {
               this.workers.remove((Worker)item);
               firePropertyChange("workers", item, null);
            }
         }
      }
      return this;
   }

   public static final java.util.ArrayList<Product> EMPTY_products = new java.util.ArrayList<Product>()
   { @Override public boolean add(Product value){ throw new UnsupportedOperationException("No direct add! Use xy.withProducts(obj)"); }};

   public static final String PROPERTY_products = "products";

   private java.util.ArrayList<Product> products = null;

   public java.util.ArrayList<Product> getProducts()
   {
      if (this.products == null)
      {
         return EMPTY_products;
      }

      return this.products;
   }

   public Store withProducts(Object... value)
   {
      if(value==null) return this;
      for (Object item : value)
      {
         if (item == null) continue;
         if (item instanceof java.util.Collection)
         {
            for (Object i : (java.util.Collection) item)
            {
               this.withProducts(i);
            }
         }
         else if (item instanceof Product)
         {
            if (this.products == null)
            {
               this.products = new java.util.ArrayList<Product>();
            }
            if ( ! this.products.contains(item))
            {
               this.products.add((Product)item);
               ((Product)item).setStore(this);
               firePropertyChange("products", null, item);
            }
         }
         else throw new IllegalArgumentException();
      }
      return this;
   }

   public Store withoutProducts(Object... value)
   {
      if (this.products == null || value==null) return this;
      for (Object item : value)
      {
         if (item == null) continue;
         if (item instanceof java.util.Collection)
         {
            for (Object i : (java.util.Collection) item)
            {
               this.withoutProducts(i);
            }
         }
         else if (item instanceof Product)
         {
            if (this.products.contains(item))
            {
               this.products.remove((Product)item);
               ((Product)item).setStore(null);
               firePropertyChange("products", item, null);
            }
         }
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

   public Store withLogEntries(Object... value)
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
               ((LogEntry)item).setStore(this);
               firePropertyChange("logEntries", null, item);
            }
         }
         else throw new IllegalArgumentException();
      }
      return this;
   }

   public Store withoutLogEntries(Object... value)
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
               ((LogEntry)item).setStore(null);
               firePropertyChange("logEntries", item, null);
            }
         }
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

   public static final java.util.ArrayList<Place> EMPTY_places = new java.util.ArrayList<Place>()
   { @Override public boolean add(Place value){ throw new UnsupportedOperationException("No direct add! Use xy.withPlaces(obj)"); }};

   public static final String PROPERTY_places = "places";

   private java.util.ArrayList<Place> places = null;

   public java.util.ArrayList<Place> getPlaces()
   {
      if (this.places == null)
      {
         return EMPTY_places;
      }

      return this.places;
   }

   public Store withPlaces(Object... value)
   {
      if(value==null) return this;
      for (Object item : value)
      {
         if (item == null) continue;
         if (item instanceof java.util.Collection)
         {
            for (Object i : (java.util.Collection) item)
            {
               this.withPlaces(i);
            }
         }
         else if (item instanceof Place)
         {
            if (this.places == null)
            {
               this.places = new java.util.ArrayList<Place>();
            }
            if ( ! this.places.contains(item))
            {
               this.places.add((Place)item);
               ((Place)item).setStore(this);
               firePropertyChange("places", null, item);
            }
         }
         else throw new IllegalArgumentException();
      }
      return this;
   }

   public Store withoutPlaces(Object... value)
   {
      if (this.places == null || value==null) return this;
      for (Object item : value)
      {
         if (item == null) continue;
         if (item instanceof java.util.Collection)
         {
            for (Object i : (java.util.Collection) item)
            {
               this.withoutPlaces(i);
            }
         }
         else if (item instanceof Place)
         {
            if (this.places.contains(item))
            {
               this.places.remove((Place)item);
               ((Place)item).setStore(null);
               firePropertyChange("places", item, null);
            }
         }
      }
      return this;
   }

   public static final java.util.ArrayList<Offer> EMPTY_offers = new java.util.ArrayList<Offer>()
   { @Override public boolean add(Offer value){ throw new UnsupportedOperationException("No direct add! Use xy.withOffers(obj)"); }};

   public static final String PROPERTY_offers = "offers";

   private java.util.ArrayList<Offer> offers = null;

   public java.util.ArrayList<Offer> getOffers()
   {
      if (this.offers == null)
      {
         return EMPTY_offers;
      }

      return this.offers;
   }

   public Store withOffers(Object... value)
   {
      if(value==null) return this;
      for (Object item : value)
      {
         if (item == null) continue;
         if (item instanceof java.util.Collection)
         {
            for (Object i : (java.util.Collection) item)
            {
               this.withOffers(i);
            }
         }
         else if (item instanceof Offer)
         {
            if (this.offers == null)
            {
               this.offers = new java.util.ArrayList<Offer>();
            }
            if ( ! this.offers.contains(item))
            {
               this.offers.add((Offer)item);
               ((Offer)item).setStore(this);
               firePropertyChange("offers", null, item);
            }
         }
         else throw new IllegalArgumentException();
      }
      return this;
   }

   public Store withoutOffers(Object... value)
   {
      if (this.offers == null || value==null) return this;
      for (Object item : value)
      {
         if (item == null) continue;
         if (item instanceof java.util.Collection)
         {
            for (Object i : (java.util.Collection) item)
            {
               this.withoutOffers(i);
            }
         }
         else if (item instanceof Offer)
         {
            if (this.offers.contains(item))
            {
               this.offers.remove((Offer)item);
               ((Offer)item).setStore(null);
               firePropertyChange("offers", item, null);
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

      result.append(" ").append(this.getWallTime());


      return result.substring(1);
   }

   public void removeYou()
   {
      this.withoutCustomers(this.getCustomers().clone());


      this.withoutWorkers(this.getWorkers().clone());


      this.withoutProducts(this.getProducts().clone());


      this.withoutLogEntries(this.getLogEntries().clone());


      this.withoutPacks(this.getPacks().clone());


      this.withoutPlaces(this.getPlaces().clone());


      this.withoutOffers(this.getOffers().clone());


   }

   public static final java.util.ArrayList<Pack> EMPTY_packs = new java.util.ArrayList<Pack>()
   { @Override public boolean add(Pack value){ throw new UnsupportedOperationException("No direct add! Use xy.withPacks(obj)"); }};

   public static final String PROPERTY_packs = "packs";

   public Store withPacks(Object... value)
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
               ((Pack)item).setStore(this);
               firePropertyChange("packs", null, item);
            }
         }
         else throw new IllegalArgumentException();
      }
      return this;
   }

   public Store withoutPacks(Object... value)
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
               ((Pack)item).setStore(null);
               firePropertyChange("packs", item, null);
            }
         }
      }
      return this;
   }

}
