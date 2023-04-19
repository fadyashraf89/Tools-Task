import javax.persistence.*;

@Entity
public class Calculation {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    private int FirstNum;
    private int SecondNum;
    private String Opern;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getOpern() {
        return Opern;
    }
    public void setOpern(String Opern) {
        this.Opern = Opern;
    }
    public int getFirstNum() {
        return FirstNum;
    }
    public void setFirstNum(int FirstNum) {
        this.FirstNum = FirstNum;
    }
    public int getSecondNum() {
        return SecondNum;
    }
    public void setSecondNum(int SecondNum) {
        this.SecondNum = SecondNum;
    }
   }