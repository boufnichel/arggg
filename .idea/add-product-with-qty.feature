Feature: Add product with qty to cart

#Scenario 1 : Add product with qty available in stock
When the customer adds 2 units of a product to the cart, having 100 units available in stock
Then the product is added with the requested qty and the stock level is decreased by 2


#Scenario 2: Add product with qty partially available in stock
When the customer adds 150 units of a product to the cart, having 100 units available in stock
Then only the qty available in stock 100 is added with a notification msg "The requested quantity has been reviewed according to the stock availability" and the stock level is decreased by 100

#Scenario 3: Add product with qty partially available in stock and max order qty
When the customer adds 150 units of a product to the cart, having 100 units available in stock, and a max order qty of 50
Then only the smallest qty (stock availability / max order qty) 50 is added with a notification msg "The requested quantity has been reviewed according to the stock availability and the maximum ordering quantity allowed" and the stock level is decreased by 50