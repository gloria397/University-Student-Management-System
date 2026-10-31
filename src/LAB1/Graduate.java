package LAB1;
public class Graduate extends Student{
    private String degreeName;
    private String thesistitle;
    public Graduate(int id,String name,String email,int gpa,String degreeName, String thesistitle) {
        super(id,name,email,gpa);
        this.degreeName = degreeName;
    }
    public String getDegreeName() {
        return degreeName;
    }
    public String getThesistitle() {
        return thesistitle;
    }
    public void setDegreeName(String degreeName) {
        this.degreeName = degreeName;
    }
    public void setThesistitle(String thesistitle) {
        this.thesistitle = thesistitle;
    }
    public double calculategpa(){
        return getGpa();
    }
    @Override
    public String toString() {
        return "{ degreename" + degreeName
                + ", thesistitle" + thesistitle
                + ",gpa= " + calculategpa() + "}";
    }
}