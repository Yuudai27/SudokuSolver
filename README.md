# SudokuSolver
My most recent private project is a Sudoku solver program for sudoku puzzles from
difficulty easy to difficult.
As I like solving sudoku puzzles of every difficulty for years, I had a lot
of fun tracking down all the steps from start to end solving a puzzle.
Different techniques are needed and have to be combined to solve difficulties
from normal to difficult. Planning the necessary classes, functions, variables
and their relations is the most initial step. Java seemed to me to be the most useful
language for this job, as it works perfectly together with its objects and instances.
The scope modifiers ensured that just the necessary functions and variables are usable
to calling classes.

My way to solve the sudoku puzzles consists of 4 main steps
    1.) looping through the board and noting the possible numbers<br>
    2.) searching for fields with single notes, adding these to the board and updating the related
        columns, rows and fields around<br>
    3.) searching for fields in a 3x3 block, where a number is just noted one time and also adding
        these to the board and updating the related columns, rows and fields around<br>
    4.) searching for fields with 2 possible numbers and comparing these with related columns, rows
        and fields around. If 2 fields with the exact 2 possible numbers got detected, these get deleted
        from the related columns, rows and fields.
Step 2 to 4 will loop through until every single field in the board has a number written in it,
except the timer, which stops the solving time, reaches 15 seconds to prevent the program from
running infinitely.
   
After coding all the classes, functions and variables, I started to test their behavior
and results separately to finally connect them. Combining all single parts to the final
program, starting it and seeing it working just fine, felt great.
    
To check if the solved sudoku puzzle is valid, I added a function to validate it and
printing it on the GUI. Also, to add a bit more comfort to enter the numbers of the sudoku
you want to have solved, I enabled to jump between the single field on the board with
the arrow keys of the keyboard.
Seeing sudoku puzzles solved so fast by computing power is hilarious.
