package test.test_1;


/**
 * Created by root(Tristan) on 31/10/16.
 */


public class MatriceRot {

    private float[][] MatriceRot;

    public float GetX() {
        return MatriceRot[0][3];
    }//GetX

    public float GetY() {
        return MatriceRot[1][3];
    }//GetY

    public float GetZ() {
        return MatriceRot[2][3];
    }//GetZ

    public void SetMatriceRot(double teta) {
        //Initialise la matrice à 1 dans sa diagonale
        float [][] MatriceRotation = {{ (float)Math.cos(teta), (float)-Math.sin(teta), 0.0F, 0.0F },
        { (float)Math.sin(teta), (float)Math.cos(teta), 0.0F, 0.0F },
        { 0.0F, 0.0F, 1.0F, 0.0F },
        { 0.0F, 0.0F, 0.0F, 1.0F } };
    }//SetMatrice

    public void SetXYZ(float x, float y, float z) {
        MatriceRot [0][3] = x;
        MatriceRot [1][3] = y;
        MatriceRot [2][3] = z;
    }//SetXYZ

    public void Multiplier(float X, float Y, float Z) {
        MatriceRot [0][3] = MatriceRot [0][3] * X;
        MatriceRot [1][3] = MatriceRot [1][3] * Y;
        MatriceRot [2][3] = MatriceRot [2][3] * Z;



    }


}
