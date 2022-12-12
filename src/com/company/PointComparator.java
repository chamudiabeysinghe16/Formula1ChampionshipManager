package com.company;

import java.util.Comparator;

public class PointComparator implements Comparator<Formula1Driver> {
    //Point comparator to sort points DESCENDING order
    public int compare(Formula1Driver formula1Driver1, Formula1Driver formula1Driver2) {
        if (formula1Driver1.getCurrentPoints() > formula1Driver2.getCurrentPoints())
            return -1;
        else if (formula1Driver1.getCurrentPoints() < formula1Driver2.getCurrentPoints())
            return 1;
        else {

            if (formula1Driver1.getFirstPositionCount() > formula1Driver2.getFirstPositionCount()){
                return -1;
            }
            else if (formula1Driver1.getFirstPositionCount() < formula1Driver2.getFirstPositionCount()) {
                return 1;
            }
            else{
                return 0;
            }
        }
    }

}
