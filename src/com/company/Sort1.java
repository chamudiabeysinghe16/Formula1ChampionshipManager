package com.company;

import java.util.Comparator;

public class Sort1 implements Comparator<Formula1Driver> {



    @Override
    public int compare(Formula1Driver a, Formula1Driver b)
    {
        return a.getCurrentPoints() - b.getCurrentPoints();
    }

}
