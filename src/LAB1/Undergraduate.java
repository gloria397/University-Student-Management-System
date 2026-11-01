package LAB1;
public class Undergraduate extends Student{
    int registrationNumber;
    String programName;
    public Undergraduate(int id,String name,String email,double gpa) {
        super(id,name,email,gpa);
        this.registrationNumber = registrationNumber;
    }
    public int getRegistrationNumber() {
        return registrationNumber;
    }
    public String getProgramName() {
        return programName;
    }
    public void setRegistrationNumber(int registrationNumber) {
        this.registrationNumber = registrationNumber;
    }
    public void setProgramName(String programName) {
        this.programName = programName;
    }
    public double calculategpa(){
        return getGpa();
    }
    @Override
    public String toString(){
        return "{ registrationNumber=" + registrationNumber
                + ", programName=" + programName
                + ", gpa=" + calculategpa() + "}";
    }
}