# Recipe Maker #
*By Tracy Gan*
 
### Description #
>This application is a **food recipe application**. It takes in the ingredients that the user has in their fridge and produces different recipes that the user can make. This application would include dish preferences for *vegans*, *vegetarians*, *pescatarians* and *omnivores*.

>This application is intended to be used by people who are extremely indecisive on what to eat to prevent spending too much time on deciding what to cook for themselves. Moreover, with the grocery prices on the rise, I am interested in making this algorithm to hopefully help people who are on a budget, just like me, to cook a dish without having to spend on additional ingredients to cook another dish.


### User Stories ###

- As a user, I want to be able to add ingredients into my fridge. Then, from that list of ingredients, it which will inform me which recipes are possible for me to cook.
- As a user, I want to be able to view the RecipeBook which contains a list of food recipes that I can make.
- As a user, I want to be able to select the type of food recipes suitable for my needs (vegan, vegetarian, pescatarian, or omnivore).
- As a user, I want to be able to mark a food recipe as tried.
- As a user, I want to be able to remove the ingredients in my fridge after I have finished using all of it.
- As a user, I want to be able to reduce the quantity of ingredients in my fridge once using it.
- As a user, I want to be able to choose a food recipe that I have tried and rate it on a scale from 1 to 5 stars.
- As a user, once I have finished using the application, I want to be able to check the updated list of my ingredients in my fridge.
- As a user, when I start the application, I want to be able to load the ingredients I have in my fridge from file.
- As a user, I want to be able to save the ratings I have added for the recipes.


### Instructions for Grader ###
#### How to perform actions on GUI?

- You can generate the first required action related to adding Xs to Y by pressing the Add Ingredient button in Control Panel Functions. Another window of Ingredient name, Ingredient amount and units will be shown. You are only allowed to input the ingredients as shown on the window.
- You can generate the second required action related to adding Xs to Y by pressing the Reduce Ingredient button in Control Panel Functions. This can be handled to remove Xs from Y.
- You can locate my visual component after pressing the Save button in Add Ingredient or Remove Ingredient window.
- You can save the state of my application by pressing 'Save fridge to file' button in Control Panel Functions.
- You can reload the state of my application by pressing 'Load fridge from file' button in Control Panel Functions.


### Phase 4: Task 2
#### An example of the printed out console.
Tue Apr 04 14:30:39 PDT 2023
Added 2.0 whole of apple into fridge!


Tue Apr 04 14:30:43 PDT 2023
Added 1000.0 g of rice into fridge!


Tue Apr 04 14:30:49 PDT 2023
Reduced rice by 500.0g!


Tue Apr 04 14:30:58 PDT 2023
Removed 2.0 whole of apple from the fridge!


##### There are two representative samples of adding ingredients into the fridge because I want to demonstrate reducing the ingredient by a certain amount and removing the entire ingredient.

### Phase 4 : Task 3
#### How to improve on design?
To improve the design of my project, I would first start with separating my RecipeApp class in my UI package into different classes. This is because there are different methods available in this class are in charge of performing different actions, related to different objects. As an example, there is a method to deal with entering ingredients into a fridge [ findMethod() ]. However, in the same RecipeApp class, I have another method to deal with asking the user's ratings for recipes they have tried [ askTried() ]. Therefore, if I had more time to work on this project, I would start with refactoring the RecipeApp class in the UI package to adhere to the Single Responsibility Principle.

