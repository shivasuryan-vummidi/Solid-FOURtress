public interface ConnectFour {
    
    //A ConnectFour game must be able to create a board and check for winner

    void create_board(int rows, int columns);
    
    void check_winner(Player p1, Player p2);

}
