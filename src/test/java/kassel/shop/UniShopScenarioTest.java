package kassel.shop;
import org.fulib.FulibTools;
import org.fulib.scenarios.MockupTools;
import org.fulib.tables.ObjectTable;
import org.fulib.tables.StringTable;
import org.fulib.tables.doubleTable;
import org.junit.Test;

public class UniShopScenarioTest  
{

   @Test
   public void uniKasselShopStory() { 
      // It is wednesday morning at the Uni Store.
      Store uniStore = new Store();
      uniStore.setWallTime("Wednesday 09:30");
      // Alice and Bob are on duty.
      Worker alice = new Worker();
      Worker bob = new Worker();
      alice.setName("Alice");
      bob.setName("Bob");
      uniStore.withWorkers(alice, bob);
      // We call buildStockData on StoreApp.
      Product hoodieXL = new Product();
      hoodieXL.setId("HoodieXL");
      hoodieXL.setDescription("Hoody Black XL");
      hoodieXL.setStore(uniStore);
      FulibTools.objectDiagrams().dumpSVG("src/main/scenarios/kassel/shop/startSituation.svg", uniStore);
      // A new package of hoddies arrives.
      StoreApp storeApp = new StoreApp();
      storeApp.setId("Store-app");
      storeApp.setDescription("Store App");
      Page loginPage = storeApp.login();
      storeApp.supply();
      LogEntry supply0931 = new LogEntry();
      supply0931.setId("Supply0931");
      supply0931.setTime("09:31");
      supply0931.setTask("book supply");
      supply0931.setStore(uniStore);
      supply0931.setWorker(alice);
      Pack pack0931 = new Pack();
      pack0931.setId("Pack0931");
      pack0931.setItems(40.0);
      pack0931.setProduct(hoodieXL);
      pack0931.setStore(uniStore);
      supply0931.setPack(pack0931);
      FulibTools.objectDiagrams().dumpSVG("src/main/scenarios/kassel/shop/hoodiesBooked.svg", uniStore);
      // Bob stores the hoodies on shelf 4 column 2 board 1.
      LogEntry stored0935 = new LogEntry();
      stored0935.setId("Stored0935");
      stored0935.setTime("09:35");
      stored0935.setTask("store supply");
      stored0935.setStore(uniStore);
      stored0935.setPack(pack0931);
      stored0935.setWorker(bob);
      Place s4C2B1 = new Place();
      s4C2B1.setId("S4-c2-b1");
      s4C2B1.setStore(uniStore);
      pack0931.setPlace(s4C2B1);
      FulibTools.objectDiagrams().dumpSVG("src/main/scenarios/kassel/shop/hoodiesStored.svg", uniStore);
      // Carli makes a special offer
      Worker carli = new Worker();
      carli.setName("Carli");
      carli.setStore(uniStore);
      LogEntry offered10 = new LogEntry();
      offered10.setId("Offered10");
      offered10.setTime("10:00");
      offered10.setTask("offer product");
      offered10.setStore(uniStore);
      offered10.setWorker(carli);
      Offer hoodiesSpecial = new Offer();
      hoodiesSpecial.setId("Hoodies-special");
      hoodiesSpecial.setPrice(24.0);
      hoodiesSpecial.setStartTime("11:00");
      hoodiesSpecial.setEndTime("24:00");
      offered10.setOffer(hoodiesSpecial);
      hoodiesSpecial.setStore(uniStore);
      hoodiesSpecial.setProduct(hoodieXL);
      FulibTools.objectDiagrams().dumpSVG("src/main/scenarios/kassel/shop/hoodiesOffered.svg", uniStore);
      // Dora buys a hoodie.
      Customer dora = new Customer();
      dora.setName("Dora");
      dora.setAddress("Great Barrier Reef 1");
      dora.setVendor(uniStore);
      LogEntry buy1101 = new LogEntry();
      buy1101.setId("Buy1101");
      buy1101.setTime("11:01");
      buy1101.setTask("buy product");
      buy1101.setStore(uniStore);
      Order order1101 = new Order();
      order1101.setId("Order1101");
      order1101.setTime("11:01");
      order1101.setCustomer(dora);
      order1101.setOffer(hoodiesSpecial);
      buy1101.setOrder(order1101);
      FulibTools.objectDiagrams().dumpSVG("src/main/scenarios/kassel/shop/hoodieBought.svg", uniStore);
      FulibTools.objectDiagrams().dumpYaml("src/main/scenarios/kassel/shop/hoodieBought.yaml", uniStore);
      MockupTools.htmlTool().dump("src/main/scenarios/kassel/shop/hoodieBought.tables.html", uniStore);
   }

   @Test
   public void demoModelQueries() {
      Store uniStore = new Store().setWallTime("Uni Store 9:00");

      Product tShirt = new Product().setId("tShirt").setDescription("Uni Shirt").setStore(uniStore);
      Product mug = new Product().setId("mug").setDescription("Coffee Mug").setStore(uniStore);

      new Pack().setId("p1").setProduct(tShirt).setItems(42).setStore(uniStore);
      new Pack().setId("p2").setProduct(tShirt).setItems(23).setStore(uniStore);
      new Pack().setId("p3").setProduct(mug).setItems(25).setStore(uniStore);

      ObjectTable storeTable = new ObjectTable("store", uniStore);
      ObjectTable productTable = storeTable.expandLink("product", Store.PROPERTY_products);
      ObjectTable packTable = productTable.expandLink("pack", Product.PROPERTY_packs);
      doubleTable doubleTable = packTable.expandDouble("items", Pack.PROPERTY_items);
      productTable.filter(o -> ((Product) o).getId().equals("tShirt"));
      System.out.println(productTable);
      System.out.println(doubleTable.sum());
   }

}
