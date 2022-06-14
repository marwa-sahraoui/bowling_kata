import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class BowlingGameKataTest {

    private BowlingGameKata game;

    @BeforeEach
    public void setUp(){
    game = new BowlingGameKata();
    }

    @Test
    void worstGame() {
       game.roll(0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0);
    Assertions.assertThat(game.score()).isEqualTo(0);
}
    @Test
    void onePinPerRoll(){
   game.roll(1,1, 1,1, 1,1, 1,1, 1,1, 1,1, 1,1, 1,1, 1,1, 1,1);
    Assertions.assertThat(game.score()).isEqualTo(20);
}
   @Test
   void spareFollowedByThree(){
        game.roll(5,5, 3,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0);
       Assertions.assertThat(game.score()).isEqualTo(16);
   }
   @Test
    void strikeFollowedByThreeAndThree(){
       game.roll(10, 3,3, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0);
       Assertions.assertThat(game.score()).isEqualTo(22);
   }
    @Test
    void perfectGame(){
        game.roll(10, 10,10, 10, 10,10,10, 10, 10, 10,10,10 );
        Assertions.assertThat(game.score()).isEqualTo(300);
    }
    @Test
    void strikeAtTheEnd(){
        game.roll(0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 10, 3,3);
        Assertions.assertThat(game.score()).isEqualTo(16);
    }
    @Test
    void spareAtTheEnd() {
        game.roll(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 7, 3, 3);
        Assertions.assertThat(game.score()).isEqualTo(13);
    }
    @Test
    void exemple()  {
        game.roll(1); // frame1

        game.roll(4);

        game.roll(4); // frame2

        game.roll(5);

        game.roll(6); // frame3

        game.roll(4); // spare

        game.roll(5); // frame4

        game.roll(5); // spare

        game.roll(10); // frame5 // strike

        game.roll(0); // frame6

        game.roll(1);

        game.roll(7); // frame7

        game.roll(3); // spare

        game.roll(6); // frame8

        game.roll(4); // spare

        game.roll(10); // frame9 // strike

        game.roll(2); // frame10

        game.roll(8); // spare

        game.roll(6);

        Assertions.assertThat( game.score()).isEqualTo(133);

    }


}

