# Uni Kassel Shop Story	

// It is wednesday morning at the Uni Store. 
There is the Store UniStore.
The UniStore has the wall-time "Wednesday 09:30".

// Alice and Bob are on duty. 
There are Workers with name Alice and Bob. 
The UniStore has workers Alice and Bob. 

// We call buildStockData on StockApp.
There is a product with id HoodieXL and with description "Hoody Black XL".
HoodieXL has store and is one of the products of UniStore.
![UniStore](startSituation.svg)

// A new package of hoddies arrives.
There is a Stock-App with id Stock-app
and with description "Stock App".

We call login on Stock-app.
Login creates a page with id Login-page
and with description "Login | button Supply | button Store".
Login-page has app and is content of Stock-App.
Login creates a content with id Name-in and with description "input name?".
Name-in has page and is one of the content of Login-Page.
Login creates a content with id Pass-in and with description "input password?"
and with page Login-Page.
Login creates a content with id Login-button and with description "button login"
and with action "loginAction Name-in Pass-in Supply"
and with page Login-Page.
Login answers with Login-Page.

We call supply on Stock-app.
Supply creates a page with id Book-supply-page
and with description "button Login | Supply | button Store"
and with app Stock-app.
Supply creates a content with id Lot-id-in and with description "input lot id?"
and with page Book-supply-page.
Supply creates a content with id Product-id-in and with description "input product id?"
and with page Book-supply-page.
Supply creates a content with id Items-in and with description "input number of items?"
and with page Book-supply-page.
Supply creates a content with id Book-button and with description "button book"
and with action "bookAction Lot-id-in Product-id-in Items-in Supply"
and with page Book-supply-page.

We create a log-entry with id Supply0931 and with time "09:31" and 
with task book supply.
Supply0931 has store and is one of the log-entries of UniStore. 
Supply0931 has worker and is one of the log-entries of Alice. 
We create a lot with id Lot0931 and with 40.0 items.
Lot0931 has product and is one of the lots of HoodieXL.
Lot0931 has store and is one of the lots of UniStore.
Supply0931 has lot Lot0931.
![UniStore](hoodiesBooked.svg)

// Bob stores the hoodies on shelf 4 column 2 board 1.
We create a log-entry with id Stored0935 and with time "09:35" and 
with task store supply and with store UniStore and with lot Lot0931
and with worker Bob.
There is a place with id S4-c2-b1.
S4-c2-b1 has store and is one of the places of UniStore.
Lot0931 has place and is one of the lots of S4-c2-b1.
![UniStore](hoodiesStored.svg)

// Carli makes a special offer
There is a worker with name Carli and with store UniStore.
We create a log-entry with id Offered10 and with time "10:00" and 
with task offer product and with store UniStore and with worker Carli.
We create an offer with id Hoodies-special and with price 24.00
and with start-time "11:00" and with end-time "24:00".
Offered10 has offer HoodiesSpecial.
HoodiesSpecial has store and is one of the offers of UniStore. 
HoodiesSpecial has product HoodieXL. 
![UniStore](hoodiesOffered.svg)

// Dora buys a hoodie.
There is a customer with name Dora and with address "Great Barrier Reef 1".
Dora has vendor and is one of the customers of UniStore.
We create a log-entry with id Buy1101 and with time "11:01" and 
with task buy product and with store UniStore.
We create an order with id Order1101 and with time "11:01".
Order1101 has customer and is one of the orders of Dora. 
Order1101 has offer and is one of the orders of HoodiesSpecial. 
Buy1101 has order Order1101.
![UniStore](hoodieBought.svg)
![UniStore](hoodieBought.yaml)
![UniStore](hoodieBought.tables.html)


