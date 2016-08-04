 
package ydstest;

 
public class Questions {
    private int number;
    private String questionMark;

    public Questions(int number, String questionMark) {
        this.number = number;
        this.questionMark = questionMark;
    }

    public int getNumber() {
        return number;
    }

    public String getQuestionMark() {
        return questionMark;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setQuestionMark(String questionMark) {
        this.questionMark = questionMark;
    }
    
}
