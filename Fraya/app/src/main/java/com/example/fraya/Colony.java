package com.example.fraya;

import android.app.Activity;
import android.util.Log;

public class Colony {

    private static final String DEBUGTAG = "DJP";
    private Organism[][] Col;
    private int height;
    private int width;


    public Colony(int w, int h, Activity activity, int orgSize) {
// w is the number of columns, h is the number of rows.
        width = w;
        height = h;
        Col = new Organism[w][h];
        int id = 0;

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                //i is now the x value, j is the y value
                id++;
                Col[i][j] = new Organism(activity, i, j, orgSize);
                Col[i][j].addId(id);
                    if (i != 0)// if not the first column
                        Col[i][j].addOrgRuleL(findLeftOrganism(Col[i][j]));
                    else if (i == 0 && j != 0) // if not in first row and in first column
                        Col[i][j].addOrgRuleU(findUpperOrganism(Col[i][j]));
                    else
                        Col[i][j].addOrgRuleP();



            }
        }
    }


    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    /**
     * @return pointer to organism
     * */
    public Organism getOrg(int i, int j) {
        return Col[i][j];
    }
    public boolean isOnRight(Organism org) {return org.getCol() == width;}
    public boolean isOnLeft(Organism org) {return org.getCol() == 0;}
    public boolean isOnTop(Organism org) {return org.getRow() == 0;}
    public boolean isOnBottom(Organism org) {return org.getRow() == height;}

    public int findAdjacentOrgs(Organism org) {

        Log.d(DEBUGTAG, "row: " + org.getRow() + " col: " + org.getCol());
        int alive = 0;
            if (isOnLeft(org) && isOnTop(org)) {
                if (findRightOrg(org).isAlive())
                    alive++;
                if (findLoRiOrg(org).isAlive())
                    alive++;
                if (findLowerOrg(org).isAlive())
                    alive++;
            } else if (isOnRight(org) && isOnTop(org)) {
                if (findLeftOrg(org).isAlive())
                    alive++;
                if (findLoLeOrg(org).isAlive())
                    alive++;
                if (findLowerOrg(org).isAlive())
                    alive++;
            } else if (isOnLeft(org) && isOnBottom(org)) {
                if (findRightOrg(org).isAlive())
                    alive++;
                if (findUpperOrg(org).isAlive())
                    alive++;
                if (findUpRiOrg(org).isAlive())
                    alive++;
            } else if (isOnRight(org) && isOnBottom(org)) {
                if (findLeftOrg(org).isAlive())
                    alive++;
                if (findUpperOrg(org).isAlive())
                    alive++;
                if (findUpLeOrg(org).isAlive())
                    alive++;
            } else if (isOnLeft(org)) {
                if (findRightOrg(org).isAlive())
                    alive++;
                if (findUpperOrg(org).isAlive())
                    alive++;
                if (findUpRiOrg(org).isAlive())
                    alive++;
                if (findLoRiOrg(org).isAlive())
                    alive++;
                if (findLowerOrg(org).isAlive())
                    alive++;
            } else if (isOnRight(org)) {
                if (findLeftOrg(org).isAlive())
                    alive++;
                if (findUpperOrg(org).isAlive())
                    alive++;
                if (findUpLeOrg(org).isAlive())
                    alive++;
                if (findLoLeOrg(org).isAlive())
                    alive++;
                if (findLowerOrg(org).isAlive())
                    alive++;
            } else if (isOnBottom(org)) {
                if (findUpperOrg(org).isAlive())
                    alive++;
                if (findRightOrg(org).isAlive())
                    alive++;
                if (findLeftOrg(org).isAlive())
                    alive++;
                if (findUpLeOrg(org).isAlive())
                    alive++;
                if (findUpRiOrg(org).isAlive())
                    alive++;
            } else if (isOnTop(org)) {
                if (findLowerOrg(org).isAlive())
                    alive++;
                if (findLoRiOrg(org).isAlive())
                    alive++;
                if (findLoLeOrg(org).isAlive())
                    alive++;
                if (findRightOrg(org).isAlive())
                    alive++;
                if (findLeftOrg(org).isAlive())
                    alive++;
            } else {
                if (findUpperOrg(org).isAlive())
                    alive++;
                if (findRightOrg(org).isAlive())
                    alive++;
                if (findLeftOrg(org).isAlive())
                    alive++;
                if (findUpLeOrg(org).isAlive())
                    alive++;
                if (findUpRiOrg(org).isAlive())
                    alive++;
                if (findLoRiOrg(org).isAlive())
                    alive++;
                if (findLoLeOrg(org).isAlive())
                    alive++;
                if (findLowerOrg(org).isAlive())
                    alive++;
            }
        return alive;
    }


// RETURNS REFERENCES TO ORGANISMS
    // for methods below, return null if its at the edge somewhere. One organism
    // may return null for more than one of these methods.

    public Organism findRightOrg(Organism org){
        return Col[org.getCol() + 1][org.getRow()]; //WORKS
    }

    public Organism findLeftOrg(Organism org){
        return Col[org.getCol() - 1][org.getRow()]; //WORKS

    }

    public Organism findUpperOrg(Organism org){
        return Col[org.getCol()][org.getRow() - 1]; //WORKS
    }

    public Organism findUpRiOrg(Organism org) {
        return Col[org.getCol() + 1][org.getRow() - 1];
    } // upper right
    //use a try catch statement where the catch has a switch statement where e.getMessage() equals certain cases, and you deal with it appropriately

    public Organism findLoRiOrg(Organism org) {
        //             g Right               Low
        return Col[org.getCol() + 1][org.getRow() + 1];
    }// bottom right

    public Organism findLowerOrg(Organism org) {
        return Col[org.getCol()][org.getRow() + 1];
    } //lower

    public Organism findLoLeOrg(Organism org) {
        return Col[org.getCol() - 1][org.getRow() + 1];
    } // bottom left

    public Organism findUpLeOrg(Organism org) {
        return Col[org.getCol() - 1][org.getRow() - 1];
    } // upper left
    // *****************************************************************************************************************************************************88
    // RETURNs ID OF ORGANISMS

    public int[] findAdjacentOrganisms(Organism org) {
        // returns an array whose order is: Left, Right, Upper, Lower
        int[] arr = {findLeftOrganism(org), findRightOrganism(org),
                findUpperOrganism(org), findLowerOrganism(org),
                findLoLeOrganism(org), findLoRiOrganism(org),
                findUpLeOrganism(org), findUpRiOrganism(org)};
        return arr;
    }

    public Integer findLeftOrganism(Organism org) {
        if (org.getCol() != 0)
            return Col[org.getCol() - 1][org.getRow()].getId();
        else
            return null;
    }

    public Integer findRightOrganism(Organism org) {
        if (org.getCol() != width - 2)
            return Col[org.getCol() + 1][org.getRow()].getId();//which is the highest index
        else
            return null;
    }

    public Integer findUpperOrganism(Organism org) {
        if (org.getRow() != 0)
            return Col[org.getCol()][org.getRow() - 1].getId();
        else
            return null;
    }

    public Integer findLowerOrganism(Organism org) {
        if (org.getRow() != height - 2)//which is the highest index
            return Col[org.getCol()][org.getRow() + 1].getId();
        else
            return null;
    }

    // upper right
    public Integer findUpRiOrganism(Organism org) {
        if (org.getCol() != width - 2 && org.getRow() != 0)//which is the highest index
            return Col[org.getCol() + 1][org.getRow() - 1].getId();
        else
            return null;
    }

    // upper left
    public Integer findUpLeOrganism(Organism org) {
        if (org.getCol() != 0 && org.getRow() != 0)//which is the highest index
            return Col[org.getCol() - 1][org.getRow() - 1].getId();
        else
            return null;
    }

    // bottom right
    public Integer findLoRiOrganism(Organism org) {
        if (org.getCol() != width - 2 && org.getRow() != height - 2)//which is the highest index
            return Col[org.getCol() + 1][org.getRow() + 1].getId();
        else
            return null;
    }

    // bottom left
    public Integer findLoLeOrganism(Organism org) {
        if (org.getCol() != 0 && org.getRow() != height - 2)//which is the highest index
            return Col[org.getCol() - 1][org.getRow() + 1].getId();
        else
            return null;
    }
}