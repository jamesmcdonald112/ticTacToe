## Tic-Tac-Toe Game
A simple Java implementation of the classic Tic-Tac-Toe game for two players.

## How to Run
- Compile the Code: Navigate to the project directory and compile the Java files:
```bash
 cd ticTacToe/Simple\ Tic-Tac-Toe\ \(Java\)/task/src
javac tictactoe/*.java
```

## Start the Game:
```bash
java tictactoe/Main 
```

## How to Play
- The game is played on a 3x3 grid.
- Players take turns entering their move coordinates.
- Enter coordinates as two numbers between 1 and 3 (row and column), separated by a space (e.g., 1 2).

## Project Structure
- CreateTable.java: Creates and formats the game board.
- PlayGame.java: Contains the main game loop and manages player turns.
- AnalyseGame.java: Analyzes the game state to check for a win, draw, or ongoing game.
- GameState.java: Enum representing possible game states (e.g., X_WINS, DRAW).
- PrintTable.java: Handles displaying the game board.
- UserInput.java: Manages user input from the console.
