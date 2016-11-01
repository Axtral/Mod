package test2;

/**
 * Created by Alexandre on 31/10/2016.
 */
public class CVecteur {

    private float[][] CVect;

    public CVecteur() {
        float[][] CVect = new float[1][3];
    }

    public float[][] getCVect() {
        return this.CVect;
    }

    public void setCVect(float[][] CVect) {
        this.CVect = CVect;
    }


    float GetXVect(){ return this.CVect[0][0];}

    float GetYVect() {return this.CVect[0][1];}

    float GetZVect() {return this.CVect[0][2];}
}
