package kassel.shop;
import org.fulib.service.Service;
import org.fulib.tables.ObjectTable;
import org.fulib.tables.doubleTable;

import java.beans.PropertyChangeSupport;
import java.beans.PropertyChangeListener;

public class StoreApp  
{
   private final StoreApp storeApp;
   private Store uniStore;
   private Worker worker;

   public static void main(String[] args)
   {
      Service.main(new String[]{StoreApp.class.getName()});
   }

   public StoreApp(){
      this.storeApp = this;
   }

   public void init() {
      this.setId("Store-app");
      this.setDescription("Store App");
      login();

      uniStore = new Store();
      uniStore.setWallTime("Wednesday 09:30");
      Product hoodieXL = new Product()
            .setId("HoodieXL")
            .setDescription("Hoody Black XL")
            .setStore(uniStore);

      new Lot().setId("l1201").setItems(20).setProduct(hoodieXL).setStore(uniStore);
      new Lot().setId("l1202").setItems(30).setProduct(hoodieXL).setStore(uniStore);
      new Lot().setId("l1203").setItems(25).setProduct(hoodieXL).setStore(uniStore);

      ObjectTable hoodieTable = new ObjectTable("product", hoodieXL);
      ObjectTable lotTable = hoodieTable.expandLink("lot", Product.PROPERTY_lots);
      doubleTable itemsTable = lotTable.expandDouble("items", Lot.PROPERTY_items);
      double sum = itemsTable.sum();

      System.out.println(hoodieTable);
      System.out.println(sum);
   }

   public void loginAction(String nextPage, String name, String password) {
      worker = new Worker().setName(name).setStore(this.uniStore);
      supply();
   }

   public void bookAction(String nextPage, String lotId, String productId, String itemsNum) {
      System.out.println(String.format("bookAction(%s, %s, %s)", lotId, productId, itemsNum));
      double items = Double.parseDouble(itemsNum);
      Product product = null;
      ObjectTable table = new ObjectTable("store", this.uniStore)
            .expandLink("product", Store.PROPERTY_products)
            .expandLink("id", Product.PROPERTY_id)
            .filter(id -> id.equals(productId));
      if (table.getTable().size() > 0 ) {
         product = (Product) table.getTable().get(0).get(1);
      }
      else {
         product = new Product().setId(productId).setDescription(productId).setStore(this.uniStore);
      }
      Lot lot = new Lot().setId(lotId).setProduct(product).setItems(items).setStore(this.uniStore);
      new LogEntry().setId("book_"+lotId).setLot(lot).setWorker(this.worker).setStore(this.uniStore);
   }

   public static final String PROPERTY_id = "id";

   private String id;

   public String getId()
   {
      return id;
   }

   public StoreApp setId(String value)
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

   public StoreApp setDescription(String value)
   {
      if (value == null ? this.description != null : ! value.equals(this.description))
      {
         String oldValue = this.description;
         this.description = value;
         firePropertyChange("description", oldValue, value);
      }
      return this;
   }

   public static final String PROPERTY_content = "content";

   private Page content = null;

   public Page getContent()
   {
      return this.content;
   }

   public StoreApp setContent(Page value)
   {
      if (this.content != value)
      {
         Page oldValue = this.content;
         if (this.content != null)
         {
            this.content = null;
            oldValue.setApp(null);
         }
         this.content = value;
         if (value != null)
         {
            value.setApp(this);
         }
         firePropertyChange("content", oldValue, value);
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
      result.append(" ").append(this.getDescription());


      return result.substring(1);
   }

   public void removeYou()
   {
      this.setContent(null);

   }

   public Page login() { 
      Page loginPage = new Page();
      loginPage.setId("Login-page");
      loginPage.setDescription("Login | button Supply | button Store");
      loginPage.setApp(this);
      Content nameIn = new Content();
      nameIn.setId("Name-in");
      nameIn.setDescription("input name?");
      nameIn.setPage(loginPage);
      Content passIn = new Content();
      passIn.setId("Pass-in");
      passIn.setDescription("input password?");
      passIn.setPage(loginPage);
      Content loginButton = new Content();
      loginButton.setId("Login-button");
      loginButton.setDescription("button login");
      loginButton.setAction("loginAction Name-in Pass-in Supply");
      loginButton.setPage(loginPage);
      return loginPage;
   }

   public void supply() { 
      Page bookSupplyPage = new Page();
      bookSupplyPage.setId("Book-supply-page");
      bookSupplyPage.setDescription("button Login | Supply | button Store");
      bookSupplyPage.setApp(this);
      Content lotIdIn = new Content();
      lotIdIn.setId("Lot-id-in");
      lotIdIn.setDescription("input lot id?");
      lotIdIn.setPage(bookSupplyPage);
      Content productIdIn = new Content();
      productIdIn.setId("Product-id-in");
      productIdIn.setDescription("input product id?");
      productIdIn.setPage(bookSupplyPage);
      Content itemsIn = new Content();
      itemsIn.setId("Items-in");
      itemsIn.setDescription("input number of items?");
      itemsIn.setPage(bookSupplyPage);
      Content bookButton = new Content();
      bookButton.setId("Book-button");
      bookButton.setDescription("button book");
      bookButton.setAction("bookAction Lot-id-in Product-id-in Items-in Supply");
      bookButton.setPage(bookSupplyPage);
   }

}
