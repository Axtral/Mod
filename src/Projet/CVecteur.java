package Projet;

/**
 * Created by Alexandre on 31/10/2016.
 */
public class CVecteur {

    private float[][] CVect;

    public CVecteur() {
        float[][] CVect = new float[1][4];
    }
    public CVecteur(int a){
        float [][] CVect = new float[1][a];
    }

    public float[][] getCVect() {
        return this.CVect;
    }

    public void setCVect(float[][] CVect) {
        this.CVect = CVect;
    }

    public int GetLenght(){
        return CVect.length;
    }
    float GetXVect(){ return this.CVect[0][0];}

    float GetYVect() {return this.CVect[0][1];}

    float GetZVect() {return this.CVect[0][2];}
}
