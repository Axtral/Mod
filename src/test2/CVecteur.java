package test2;

/**
 * Created by Alexandre on 31/10/2016.
 */
public class CVecteur {

    private float[][] CVect = new float[1][4];

    public CVecteur() {
        CVect = new float[1][4];
    }

    public float[][] getCVect() {
        return this.CVect;
    }

    public void setCVect(float[][] CVect) {
        this.CVect = CVect;
    }
}
