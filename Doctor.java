package PMS;
public class Doctor
{
    int DoctorID ;
    String dName;
    String diseases;

    public Doctor(int DoctorID , String dName , String diseases)
    {
        this.DoctorID = DoctorID;
        this.dName = dName;
        this.diseases = diseases;
    }
    public void setDoctorID(int ID)
    {
        DoctorID = ID;
    }
    public void setdName(String docName)
    {
        dName = docName;
    }
    public void setDiseases(String diseases1)
    {
        diseases = diseases1;
    }
    public int getDoctorID()
    {
        return DoctorID;
    }
    public String getdName()
    {
        return dName;
    }
    public String getDiseases()
    {
        return diseases;
    }




}
