package kr.ac.kopo.diet.vo;

import java.time.LocalDate;

/**
 * Diet record domain entity. Represents a meal entry for a user.
 */
public class DietRecordVO {

    private int id;
    private String memberId;
    private LocalDate date;
    private String mealType; // breakfast, lunch, dinner
    private String foodName;
    private int calories;
    private String imagePath;
    private String memo;

    public DietRecordVO() {
    }

    public DietRecordVO(int id, String memberId, LocalDate date, String mealType,
                        String foodName, int calories, String imagePath, String memo) {
        this.id = id;
        this.memberId = memberId;
        this.date = date;
        this.mealType = mealType;
        this.foodName = foodName;
        this.calories = calories;
        this.imagePath = imagePath;
        this.memo = memo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getMealType() {
        return mealType;
    }

    public void setMealType(String mealType) {
        this.mealType = mealType;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
}
