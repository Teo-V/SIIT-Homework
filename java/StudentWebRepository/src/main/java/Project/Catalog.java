package Project;

public class Catalog {
    private int i1;
    private int i2;

    private int i3;
    private int i4;

    public Catalog(int a, int b, int c,int d) {
        this.i1=a;
        this.i2=b;
        this.i3=c;
        this.i4=d;
    }

    public String getFirstGrade(){
        return " "+ String.valueOf(i1);
    }
    public String getSecondGrade(){
        return" "+ String.valueOf(i2);
    }
    public String getThirdGrade(){
        return" "+ String.valueOf(i3);
    }
    public String getForthGrade(){
        return" "+ String.valueOf(i4);
    }

    public String getAverage(){
        int avg=(i1+i2+i3+i4)/4;
        return" Average: "+ avg;
    }
}
