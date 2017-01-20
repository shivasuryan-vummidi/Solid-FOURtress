# Solid-FOURtress

#####Project Description
This is a remake of Connect Four, but in Java.
Connect Four is a two-player, a player versus computer, or a computer versus computer turn-based game.
The players take turns dropping tokens onto a board.
The goal of the actual game is to connect four tokens in a row, be it horizontal, vertical, or diagonal.
However, if the board becomes full and nobody has yet to win, it is a draw.

#####Features:
 - 2 player
 - 1 player vs Computer
 - Computer vs Computer
 - Several Computer classes
   - Easy: Randomly places tokens into columns with no strategy
   - Medium: Only blocks vertical wins
   - Hard: Blocks both vertical and horizontal wins
   - **TBM**: The ultimate computer AI that can block vertical, horizontal, and diagonal wins.
 - **_Clean code_**
 - Implements Keyboard functionality, courtesy of authors Lewis and Loftus
 - Cool graphics

#####Launch Instructions:
1. Clear any preexisting class files if necessary.
2. javac Woo.java
3. java Woo
4. You will be presented with a welcome screen and will be asked to pick a board size:
   * 6 rows by 7 Columns
   * 7 rows by 8 Columns
   * 7 rows by 10 Columns
   * 8 rows by 8 Columns
5. You will be asked for your name and you need insert it.
6. You will be aksed what token you want. You may not choose from these reserved characters:
   * E
   * H
   * M
   * T
   * hyphens
   * underscore
   * Note: You must ONLY pick 1 letter.
7. You can choose who you would like to play as.
   * You can choose to run a computer vs computer simulation as well.
   * If you select another player, a prompt will be shown asking for their name, and their token.
     * Two players may **not** have the same name or the same token, in order to reduce confusion while playing.
   * If you select a computer and a real person, you will play against a computer.
8. After somebody wins, the winner will be presented or if there is a draw it will say there was a draw.
9. Repeat the instructions as necessary to play again.
