

# Proiect - POO TV
### Name: Pop Andreea 
### Date: December 2022

## Implementation

* implementation/
  * NavigateSite - the entry point of the implementation, constructor of which is called in the Main class
  * StartNavigation - class that has the fields: currentUser, currentMovieList, currentPage.  For this class, I used the SINGLETON PATTERN so that the fields can be instantiated only once.
    The "start" method is called at the beginning of the navigation of the platform (at the beginning of each test) and it makes the current page "Homepage neautentificat", it instantiates the
    currentMovieList and, for each user in the array, it sets the "numFreePremium movies" variable to 15 and it instantiates all the arrays that should be in output.
  * ReadActions - the constructor of this class checks if action 'i' is of type 'on page' or 'change page' and acts accordingly.
  * WriteOutput - creates the output in JSON format for an action that require format or for an error.
* input/ - classes needed to read the test files in JSON format
* pages/ 
  * Page - interface with "action" method implemented by all classes made for all the pages that can be accessed in the platform
  * Login - the 'action' method of this class logs in a user if the username and password are correct and, if so, it changes the page in "Homepage autentificat" and sets the current user.
  * Register - the 'action' method of this class registers a new user if the username is not taken and, if so, it changes the page in "Homepage autentificat" and sets the current user.
  * Logout - it logs out the current user, changing the page in "Homepage neautentificat".
  * Movies - the 'action' method of this class creates the output in JSON format for when the page is changed in "movies". It also has the 'search' and 'filter' methods that implement the 
    actions of the same names.
  * SeeDetails - the 'action' method of this class creates the output in JSON format for when the page is changed in "see details". It also has the methods of the actions that can be done from this page.
  * Upgrades - it has the methods 'buyPremiumAccount' and 'buyTokens'
* actions/
  * ChangePage - the constructor of this class changes the page in the one given in input, if the current page is one that allows this action.
  * OnPage - the constructor of this class implements an action of the type 'on page', calling the methods from the suitable page class.





