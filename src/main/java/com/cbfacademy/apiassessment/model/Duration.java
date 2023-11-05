package com.cbfacademy.apiassessment.model;


//?? Should I leave as strings instead of numbers?
//getYearsValue will be passed to the stickResource classes
//Should I convert them here or later?
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
    */

}
