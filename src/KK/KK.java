package KK;

public class KK {

    int id;
    String name;

    public KK(){}

    public KK(int id,String name){
        this.id=id;
        this.name=name;

    }


    @Override
    public String toString() {
        return "KK{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
