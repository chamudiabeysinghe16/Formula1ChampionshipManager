package com.company;
import java.util.*;

public class Sort implements Comparator<Formula1Driver>{

    @Override
    public int compare(Formula1Driver a, Formula1Driver b){

        int TotalPointsCompare=Integer.compare(a.getCurrentPoints(), b.getCurrentPoints());

        int FirstPosiCompare=Integer.compare(a.getFirstPositionCount(), b.getFirstPositionCount());

        return (TotalPointsCompare==0)? -FirstPosiCompare: -TotalPointsCompare;
    }

}
