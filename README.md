# intentIQ
This framework took approximately 32 hours to develop. 
The testing framework used TestNG 7.8.0 as a testing library and Selenium WebDriver 4.16.1 for the interaction with pages of the application.

The testing framework is divided into four layers:
* tests
* steps
* page objects
* page elements

The tests layer only interacts with the steps layer. This allows to make the tests short and readable. 
The steps layer interacts with the page objects layer and can contain additional logic for processing data received from the page objects.
Page objects layer interacts with DOM elements of pages and with page elements layer. 
Page elements layer interacts with DOM elements.

Classes in the page elements layer encapsulate common elements that are repeated on multiple pages 
or repeated multiple times on the same page, e.g. inputs, dropdowns, menu in the header and so on. 

Patterns used in the framework:
* Page Object
* Page element
* Chain of invocation
* Builder
* DTO
* Factory method
* Singleton

To run test in the console run command `mvn clean test`