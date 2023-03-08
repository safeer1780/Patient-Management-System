package PMS;
public class Diseases
{
    int diseasesID;
    String diseaseName ;
    String diseDescription;

    public Diseases(int diseasesID , String diseaseName, String diseDescription)
    {
        this.diseasesID = diseasesID;
        this.diseaseName = diseaseName;
        this.diseDescription = diseDescription;
    }
    public void setDiseasesID(int disID)
    {
        diseasesID = disID;
    }
    public void setDiseaseName(String diseaseName1)
    {
        diseaseName = diseaseName1;
    }
    public void setDiseDescription(String diseDescription1)
    {
        diseDescription = diseDescription1;
    }
    public int getDiseasesID()
    {
        return diseasesID;
    }
    public String getDiseaseName()
    {
        return diseaseName;
    }
    public String getDiseDescription()
    {
        return diseDescription;
    }

}
