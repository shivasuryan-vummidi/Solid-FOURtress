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
1. Clone this repository if you haven't already. `git clone git@github.com:shivasuryan-vummidi/Solid-FOURtress.git`
2. Move to the Solid-FOURtress repository `cd Solid-FOURtress
3. Clear any preexisting class files if necessary. `rm *.java`
4. Compile the Driver class Woo `javac Woo.java`
5. Run the driver class `java Woo`
6. You will be presented with a welcome screen and will be asked to pick a board size:
   * 6 rows by 7 Columns
   * 7 rows by 8 Columns
   * 7 rows by 10 Columns
   * 8 rows by 8 Columns
7. You will be asked what kind of player Player 1 will be. You have these options:
   * a real person
   * an EasyComputer (random AI)
   * a MediumComputer (can block vertical wins)
   * a HardComputer (can block vertical and horizontal wins)
   * a TBM (can block vertical, horizontal, and diagonal wins)
8. If you choose a real person, you will be asked for your name and you need insert it. You may not choose from these reserved names:
   * EasyComputer
   * EasyComputer2
   * MediumComputer
   * MediumComputer2
   * HardComputer
   * HardComputer2
   * TBM
   * TBM2
9. You will be asked what token you want. You may not choose from these reserved characters:
   * C
   * E
   * H
   * M
   * T
   * hyphens (-)
   * underscore (_)
   * Note: You must ONLY pick 1 letter.
10. You will be aked what kind of player Player 2 will be. You have these options: 
   * a real person
   * an EasyComputer (random AI)
   * a MediumComputer (can block vertical wins)
   * a HardComputer (can block vertical and horizontal wins)
   * a TBM (can block vertical, horizontal, and diagonal wins)
   
11. If you select another player, a prompt will be shown asking for their name, and their token.
   * Two players may **not** have the same name or the same token, in order to reduce confusion while playing.
12. You proceed to play ConnectFour
13. After somebody wins, the winner will be presented or if there is a draw it will say there was a draw.
14. Repeat the instructions as necessary to play again.
