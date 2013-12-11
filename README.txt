############################################################################################

Team Ra-Tet
EC327
FAll 2013 Android Project

LexID: The unique word finder

Whenever you need that edge in the word game you're playing, a certain word that you're 
looking for, or just love words in general; LexID is the app that's for you.

Unlike searching in a dictionary for all the words that you would like to find, LexID 
specifically searches for words based on the criteria you give it. It asks for two types
of constraints. 

On the first screen when running the app, the first type of input the 
user will be prompted to enter the SIZE of the word that (s)he is looking for. Currently, 
the sizes allowed for the word to be is between 3 and 15 letters long. 

On the second screen, the user will be required to enter a second type of input: 
CHARACTER CONSTRAINTS. Character constraints can be assigned by the user by 
replacing each of the buttons on the second screen with an alphabetical letter. 

The number of buttons that appear on the screen correspond to the SIZE of the word 
previously requested. The location of each button corresponds to the location it will 
be checking, ranging from 1 to SIZE; for example, the word "fewer" has 5 letters and
the letter 'e' in the third(3) position. If one was to run the program, enter 5 for the
size and 'e' for the third button, fewer would be one of the words that would fit
all the constraints.

On the last screen, the inputs will all be given to the program, which will randomly 
print out the first ten(10) words that match the two types of constraints from the user
input. If there are less than ten words printed, all remaining words that fulfill the 
constraints will be printed. Lastly, regardless if the words print out or not, there is 
an option to "reroll", or rerun the program with the same constraints, which may possibly
print out different words from the first printout.