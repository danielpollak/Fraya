package com.example.fraya.com.example.fraya.tests;

import android.test.ActivityInstrumentationTestCase2;

import com.example.fraya.GameOfLife;
import com.example.fraya.Colony;
import com.example.fraya.Organism;

/**
 * Created by danieljonathan on 10/24/2015.
 */
public class GameOfLifeTest extends ActivityInstrumentationTestCase2<GameOfLife>{
    private GameOfLife gameOfLife;
    private Colony mColony;
    private Organism mOrganism;

    private Colony colony1x1;
    private Colony colony2x2;
    private Colony colony5x3;



    public GameOfLifeTest(){
        super(GameOfLife.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        setActivityInitialTouchMode(true);

        /*gameOfLife = getActivity();
        mColony = gameOfLife.getColony();

        colony1x1 = gameOfLife.getColony1x1();
        colony2x2 = gameOfLife.getColony2x2();
        colony5x3 = gameOfLife.getColony5x3();

        mOrganism = mColony.getOrg(0, 0);

    */
    }

    public void testPreconditions() {
        assertNotNull("gameOfLife is null", gameOfLife);
    }


    public void testGameOfLife_Colony_findRightOrganism(){
        //checks that the id of right organism is what it would be if we did findRightOrganism()
        //also validates that it organisms are being added bookwise
        //ids
        assertEquals(colony2x2.findRightOrg(colony2x2.getOrg(0, 0)).getId(),
                colony2x2.getOrg(0 + 1, 0).getId());
        //references
        assertEquals(colony2x2.getOrg(0, 1),
                colony2x2.findRightOrg(colony2x2.getOrg(0, 0)));
    }
    public void testGameOfLife_Colony_findLeftOrg(){}
    public void testGameOfLife_Colony_findLoLeOrg(){}
    public void testGameOfLife_Colony_findLoRiOrg(){}
    public void testGameOfLife_Colony_findUpLeOrg(){}
    public void testGameOfLife_Colony_findUpRiOrg(){}
    public void testGameOfLife_Colony_findUpperOrg(){}
    public void testGameOfLife_Colony_findLowerOrg(){}




}
