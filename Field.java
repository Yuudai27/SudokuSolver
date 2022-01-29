import java.util.ArrayList;
/**
 * The class field defines a field of a 3*3 array, which contains the numbers from 1 to 9 for a single sudoku field
 * and provides functions for getting information about open possibles.
 */
public class Field {

    //array for holding the read values of the layout
    private final int[][] fieldNumbers = new int[3][3];

    //array for keeping the counts of possible numbers for each single field
    protected int[] sizeMarkers = new int[9];

    //array to log if a single field already got checked for double markers
    protected int[] checkedDouble = new int[9];

    //array list to hold the possible numbers for each single field
    private final ArrayList<ArrayList<Integer>> markers = new ArrayList<>(9);

    /**
     * Initializes the fieldNumbers with read numbers of the layout input.
     * @param fieldValues contains the read numbers of the layout.
     */
    protected void initializeField(int[][] fieldValues) {
        for(int x = 0; x < 3; x++) {
            for(int y = 0; y < 3; y++) {
                fieldNumbers[x][y] = fieldValues[x][y];
            }

        }
    }
    /**
     * This function checks if a number exists in the field and returns the number of the row.
     * @param number Contains the number searched for in the field.
     * @return The number of the row, where the searched number got found, will be returned.
     */
    protected int valueInRow(int number) {
        int result = 3;
        for(int x = 0; x < 3; x++) {
            for(int y = 0; y < 3; y++) {
                if (fieldNumbers[x][y] == number) {
                    result = x;
                    break;
                }
            }
            if(result != 3) {
                break;
            }
        }
        return result;
    }
    /**
     * This function checks if a number exists in the field and returns the number of the column.
     * @param number Contains the number searched for in the field.
     * @return The number of the column, where the searched number got found, will be returned.
     */
    protected int valueInColumn(int number) {
        int result = 3;
        for(int x = 0; x < 3; x++) {
            for(int y = 0; y < 3; y++) {
                if(fieldNumbers[x][y] == number) {
                    result = y;
                }
            }
        }
        return result;
    }
    /**
     * This function checks if the number 1 to 9 is already contained in the field.
     * If not the number will be added to the markers array of single field initialized with 0
     * and the sizeMarkers array will be increased for this single field.
     */
    protected void setMarks() {
        for(int z = 1; z < 10; z++) {
            int numberCount = 0;
            for(int x = 0; x < 3; x++) {
                for(int y = 0; y < 3; y++) {
                    if(fieldNumbers[x][y] == z) {
                        numberCount = 1;
                        break;
                    }
                }
                if(numberCount == 1) {
                    break;
                }
            }
            if(numberCount == 0) {
                for(int x = 0; x < 3; x++) {
                    for(int y = 0; y < 3; y++) {
                        if(fieldNumbers[x][y] == 0) {
                            markers.get(x+(y*3)).add(z);
                            sizeMarkers[x+(y*3)]++;
                        }
                    }
                }
            }
        }
    }
    /**
     * The checkAllMarks function checks if there is a single field with just one possible number in the field.
     * If there is one possible the number of the row, column and the number will be copied into the result array to
     * return it to the calling program. the found boolean will be set to true and breaking the for loop to
     * immediately stop the search.
     * @return The result array will be returned with the row, column and the number if found, otherwise it will just
     * contain zeros.
     */
    protected int[] checkAllMarks() {

        int[] result = {0,0,0};
        boolean found = false;
        for(int x = 0; x < 3; x++) {
            for(int y = 0; y < 3; y++) {
                if(fieldNumbers[x][y] == 0) {
                    if(sizeMarkers[x+(y*3)] == 1) {
                        result[0] = x;
                        result[1] = y;
                        result[2] = markers.get(x+(y*3)).get(0);
                        updateAllMarks(markers.get(x+(y*3)).get(0));
                        found = true;
                        break;
                    }
                }
            }
            if(found) {
                break;
            }
        }
        return result;
    }
    /**
     * The checkForSingleAppearingNumbers loops through every single fields markers and checks
     * which possible number is just noted a single time.
     * This number will be returned to the result array with row, column and number.
     * The markers for the single field, where this number is contained, will be cleared,
     * and it will be removed from the other single fields in the field.
     * @return Result array contains row, column and number.
     */
    protected int[] checkForSingleAppearingNumbers() {

        int[] checkSumNumbers = {0,0,0,0,0,0,0,0,0};
        int[] result = {0,0,0};
        for(int x = 1; x < 10; x++) {
            for(int y = 0; y < 9; y++) {
                if(markers.get(y).contains(x)) {
                    checkSumNumbers[x-1]++;
                }
            }
        }
        for(int x = 0; x < 9; x++) {
            if(checkSumNumbers[x] == 1) {
                for(int y = 0; y < 9; y++) {
                    if(markers.get(y).contains(x+1)) {
                        result[0] = y%3;
                        result[1] = y/3;
                        markers.get(y).clear();
                        sizeMarkers[y] = 0;
                        updateAllMarks(x+1);
                        break;
                    }
                }
                result[2] = x+1;
                break;
            }
        }
        return result;
    }
    /**
     * updateAllMarks functions removes the searched number from all single fields
     * with possible numbers. Each sizeMarkers counter gets decreased.
     * @param number Takes the number, which have to be removed from the field.
     */
    protected void updateAllMarks(int number) {
        for(int x = 0; x < 3; x++) {
            for(int y = 0; y < 3; y++) {
                if(fieldNumbers[x][y] == 0) {
                    if(markers.get(x+(y*3)).contains(number)) {
                        markers.get(x+(y*3)).remove(Integer.valueOf(number));
                        sizeMarkers[x+(y*3)]--;
                    }
                }
            }
        }
    }
    /**
     * updateAllMarksWithException function takes row and column and two possible numbers of a single field
     * and removes this two numbers from all other single field, except this one with given row and column.
     * @param xCt Takes the row number of the exception single field.
     * @param yCt Takes the column number of the exception single field.
     * @param num1 Takes the first possible number, which has to be removed.
     * @param num2 Takes the second possible number, which has to be removed.
     */
    protected void updateAllMarksWithException(int xCt, int yCt, int num1, int num2) {
        for(int x = 0; x < 3; x++) {
            for(int y = 0; y < 3; y++) {
                if(fieldNumbers[x][y] == 0) {
                    if(x+(y*3) != xCt && x+(y*3) != yCt){
                        if(markers.get(x+(y*3)).contains(num1)) {
                            markers.get(x+(y*3)).remove(Integer.valueOf(num1));
                            sizeMarkers[x+(y*3)]--;
                        }
                        if(markers.get(x+(y*3)).contains(num2)) {
                            markers.get(x+(y*3)).remove(Integer.valueOf(num2));
                            sizeMarkers[x+(y*3)]--;
                        }

                    }
                }
            }
        }
    }
    /**
     * the updateMarksInRow function is checking if the given number exists in the given row
     * and removes it in this case from these rows single fields.
     * @param number Takes the search number, which has to be removed.
     * @param row Takes the row and which will be checked.
     */
    protected void updateMarksInRow(int number, int row) {
        for(int y = 0; y < 3; y++) {
            if(fieldNumbers[row][y] == 0) {
                if(markers.get(row+(y*3)).contains(number)) {
                    markers.get(row+(y*3)).remove(Integer.valueOf(number));
                    sizeMarkers[row+(y*3)]--;
                }
            }
        }
    }
    /**
     * the updateMarksInRow function is checking if the given number exists in the given row
     * and removes it in this case from this rows single fields with exception to the given column.
     * @param number Takes the search number, which has to be removed.
     * @param row Takes the row and which will be checked.
     * @param column Takes the column which should be omitted while removing the number.
     */
    protected void updateMarksInRowWithException(int number, int row, int column) {
        for(int y = 0; y < 3; y++) {
            if(fieldNumbers[row][y] == 0) {
                if(markers.get(row+(y*3)).contains(number) && y != column) {
                    markers.get(row+(y*3)).remove(Integer.valueOf(number));
                    sizeMarkers[row+(y*3)]--;
                }
            }
        }
    }
    /**
     * the updateMarksInColumn function is checking if the given number exists in the given column
     * and removes it in this case from these columns single fields.
     * @param number Takes the search number, which has to be removed.
     * @param column Takes the column and which will be checked.
     */
    protected void updateMarksInColumn(int number, int column) {
        for(int x = 0; x < 3; x++) {
            if(fieldNumbers[x][column] == 0) {
                if(markers.get(x+(column*3)).contains(number)) {
                    markers.get(x+(column*3)).remove(Integer.valueOf(number));
                    sizeMarkers[x+(column*3)]--;
                }
            }
        }
    }
    /**
     * the updateMarksInColumn function is checking if the given number exists in the given column
     * and removes it in this case from these columns single fields.
     * @param number Takes the search number, which has to be removed.
     * @param column Takes the column and which will be checked.
     * @param row Takes the row, which should be omitted while removing.
     */
    protected void updateMarksInColumnWithException(int number, int column, int row) {
        for(int x = 0; x < 3; x++) {
            if(fieldNumbers[x][column] == 0) {
                if(markers.get(x+(column*3)).contains(number) && x != row) {
                    markers.get(x+(column*3)).remove(Integer.valueOf(number));
                    sizeMarkers[x+(column*3)]--;
                }
            }
        }
    }
    /**
     * The checkDoubleMarks function checks if a single field has exactly two possible numbers
     * and if there also exists another single field with the exactly two possible numbers only.
     * Fields with two possible numbers, which already got checked will be marked in checkedDouble array with 0.
     * The checkReset function will be invoked after the field got looped through one time.
     * @return The result array contains the id number of the first single field with this two possible numbers,
     * then the second id number, if there exists a second single field with these values.
     * Finally, the two possible numbers will also be transferred.
     */
    protected int[] checkDoubleMarks() {
        int[] result = {9,9,0,0};
        int var1, var2;
        for(int x = 0; x < 9; x++) {
            if(sizeMarkers[x] == 2 && checkedDouble[x] == 0) {
                var1 = markers.get(x).get(0);
                result[2] = var1;
                var2 = markers.get(x).get(1);
                result[3] = var2;
                result[0] = x;
                checkedDouble[x] = 1;
                for(int y = x +1; y < 9; y++) {
                    if(sizeMarkers[y] == 2) {
                        if(markers.get(y).contains(var1) && markers.get(y).contains(var2)) {
                            result[1] = y;
                            checkedDouble[y] = 1;
                            updateAllMarksWithException(x,y,var1,var2);
                            break;
                        }
                    }
                }
            }
            if(result[1] != 9) {
                break;
            }
        }
        checkReset();
        return result;
    }
    /**
     * The checkReset function counts first the number of single field with exactly two possibilities and then the number of already double-checked
     * single fields.
     * If these counters are equal, checkedDouble array will be reset.
     */
    private void checkReset() {
        int checkSum = 0;
        int sumSize = 0;
        for(int x = 0; x <9; x++) {
            if(sizeMarkers[x] == 2) {
                sumSize++;
                if(checkedDouble[x] == 1) {
                    checkSum++;
                }
            }
        }
        if(checkSum == sumSize) {
            for(int y = 0; y < 9; y++) {
                checkedDouble[y] = 0;
            }
        }
    }
    /**
     * The checkDoubleMarksInRow function checks if two possible numbers also exist in a row
     * of this field in a single field with just two possible markers.
     * @param pos Takes the row in which should be checked.
     * @param num1 Takes the first number of the possible ones.
     * @param num2 Takes the second number of the possible ones.
     * @return The result is of type boolean and returns true to the calling program, if the two
     * possible numbers got found in a single field with exactly two possibles.
     */
    protected boolean checkDoubleMarksInRow(int pos, int num1, int num2) {
        boolean result = false;
        int column;
        for(int y = 0; y < 3; y++) {
            if(sizeMarkers[(pos)+(y*3)] == 2) {
                if(markers.get((pos)+(y*3)).contains(num1) && markers.get((pos)+(y*3)).contains(num2)){
                    result = true;
                    column = y;
                    updateMarksInRowWithException(num1, pos, column);
                    updateMarksInRowWithException(num2, pos, column);
                }
            }
        }
        return result;
    }
    /**
     * The checkDoubleMarksInRow function checks if two possible numbers also exist in a column
     * of this field in a single field with just two possible markers.
     * @param pos Takes the column in which should be checked.
     * @param num1 Takes the first number of the possible ones.
     * @param num2 Takes the second number of the possible ones.
     * @return The result is of type boolean and returns true to the calling program, if the two
     * possible numbers got found in a single field with exactly two possibles.
     */
    protected boolean checkDoubleMarksInColumn(int pos, int num1, int num2) {
        boolean result = false;
        int row;
        for(int x = 0; x < 3; x++) {
            if(sizeMarkers[x+(pos)*3] == 2) {
                if(markers.get(x+((pos)*3)).contains(num1) && markers.get(x+((pos)*3)).contains(num2)){
                    result = true;
                    row = x;
                    updateMarksInColumnWithException(num1, pos, row);
                    updateMarksInColumnWithException(num2, pos, row);
                }
            }
        }
        return result;
    }

    /**
     * The fieldReady function loops through the sizeMarkers array and checks if all single field
     * already have 0 possible numbers, which means that the field is completely filled.
     * @return The result is a boolean and returns true, if there can't be any numbers filled in.
     */
    protected boolean fieldReady() {
        boolean result = false;
        int numberCounter = 0;
        for(int x = 0; x < 9; x++) {
            if(sizeMarkers[x] > 0) {
                numberCounter++;
            }
        }
        if(numberCounter == 0) {
            result = true;
        }
        return result;
    }

    /**
     * The Field constructor takes a 2 dimension integer array from the layout and initializes the whole
     * field first with just zeros.
     * Then the array list gets added another array list for every single ID to add and remove possible numbers more easy.
     * @param values Takes the read numbers of the layout.
     */
    public Field(int[][] values) {
        for(int x = 0; x < 3; x++) {
            for(int y = 0; y < 3; y++) {
                fieldNumbers[x][y] = 0;
            }
        }
        for(int x = 0; x < 9; x++) {
            markers.add(new ArrayList<>());
            sizeMarkers[x] = 0;
        }
        initializeField(values);
        setMarks();
    }
}
