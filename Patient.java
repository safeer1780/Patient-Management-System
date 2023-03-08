package PMS;
public class Patient
{
    int pID ;
    String pName;
    String sex[] = {"male","female"};
    int DOB;
    int doctorId;
    String diseasesHistory;
    String prescription;
    int sexOption;

    public Patient()
    {}
    public Patient(int pID,String pName,int DOB,int doctorId,String diseasesHistory,String prescription)
    {
        this.pID= pID;
        this.pName= pName;
        this.DOB = DOB;
        this.doctorId = doctorId;
        this.diseasesHistory=diseasesHistory;
        this.prescription = prescription;

    }
    public void setpID(int paID)
    {
        pID = paID;
    }
    public void setpName(String paName)
    {
        pName = paName;
    }
    public void setDOB(int DOBi)
    {
        DOB = DOBi;
    }
    public void setDoctorId(int doctorIdi)
    {
        doctorId = doctorIdi;
    }
    public void setDiseasesHistory(String diaseasesHistory)
    {
        diseasesHistory = diaseasesHistory;
    }
    public void setPrescription(String praescription)
    {
        prescription = praescription;
    }
    public void setSex(int option)
    {
        for(int i=0 ; i< sex.length ;i++)
        {
            if(option == 0)
            {
                sex[option] = sex[0];
                break;
            } else if (option ==1)
            {
                sex[option] = sex[1];
                break;
            }
        }
        sexOption = option;
    }
    public String getsex()
    {
        for(int i=0 ; i< sex.length ; i++)
        {
            if(sexOption == i)
            {
                sexOption = i;
            }
        }
        return sex[sexOption];
    }
    public int getpatientID()
    {
        return pID;
    }
    public String getPaName()
    {
        return pName;
    }
    public int getDOB()
    {
        return DOB;
    }
    public int getDoctorId()
    {
        return doctorId;
    }
    public String getDiseasesHistory()
    {
        return diseasesHistory;
    }
    public String getPrescription()
    {
        return prescription;
    }











}
