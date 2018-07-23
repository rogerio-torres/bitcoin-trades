# :dollar: bitcoin-trades :dollar:
A java skills test based on Bitcoin variations.
## Requirements
1. Maven;
2. Java 8+
## How to use
### To start the API
`mvn clean install spring-boot:run`
### To run the tests
`mvn test`
## Documentation
### Purchases API
`/api/v1/purchases`
#### Methods
1. `/top` find the top 5 purchases.
2. `/median` find the median value of the purchases price.
3. `/offset` find the standard deviation of the purchases price.
### Sales API
`/api/v1/sales`
#### Methods
1. `/top` find the top 5 sales.
2. `/median` find the median value of the sales price.
3. `/offset` find the standard deviation of the sales price.
### :shipit: That's all folks! :shipit:
