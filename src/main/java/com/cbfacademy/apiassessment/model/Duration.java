package com.cbfacademy.apiassessment.model;


public enum Duration {
    ONE_YEAR(1),
    FIVE_YEARS(5),
    TEN_YEARS(10);

    private int yearsValue;


    Duration(int yearsValue){
        this.yearsValue = yearsValue;
    }

    public int getYearsValue(){
        return yearsValue;
    }
}

    /* 
    public Duration setYearsValue(int yearsValue){
        switch(yearsValue){
            case 1: return Duration.ONE_YEAR;
            case 5: return Duration.FIVE_YEARS;
            case 10: return Duration.TEN_YEARS;
            default:
                return Duration.ONE_YEAR;
        }
    }
    

}

    public enum Duration {
        ONE,
        FIVE,
        TEN
    }

*/