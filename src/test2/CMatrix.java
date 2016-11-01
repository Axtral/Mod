package test2;

/**
 * Created by c14012299 on 14/10/2016.
 */
public class CMatrix {

    private float[][] CMat = new  float[4][4];

    private float[][] CVect = new float[1][4];


    /*public CMatrix(){

        float[][] CMat = new float[][];

    }// Crée la matrice qui sera utilisé pour la Translation et la Rotation*/

    //CREATION DE 2 FONCTIONS UNE POUR MATRICE DE ROTATION L'AUTRE POUR MATRICE DE TRANSLATION

    public void CreateCMatTranslation() { //
        /*
            ( 1 0 0 X)
            ( 0 1 0 Y)
            ( 0 0 1 Z)
            ( 0 0 0 W)
         */

        CMat [0][0] = 1;
        CMat [1][1] = 1;
        CMat [2][2] = 1;
    }

    public void CreateCMatRotation(double teta) { //
        /*
            ( cos  -sin   0  X)
            ( sin   cos   0  Y)
            (  0     0    1  Z)
            (  0     0    0  W)
         */

        float [][] MatriceRot = {{ (float)Math.cos(teta), (float)-Math.sin(teta), 0.0F, 0.0F },
                { (float)Math.sin(teta), (float)Math.cos(teta), 0.0F, 0.0F },
                { 0.0F, 0.0F, 1.0F, 0.0F },
                { 0.0F, 0.0F, 0.0F, 1.0F } };

        CMat = MatriceRot;
    }




    public float[][] getCMat(){
        return this.CMat;
    }

    public void setCMat(float[][] Mat) {
        this.CMat = Mat;
    }

    public float[][] getCVect() { return this.CVect;}

    public void setCVect(float[][] CVect) { this.CVect = CVect;}

    float GetX(){
        return this.CMat[0][0];
    }

    float GetY() {return this.CMat[1][0];}

    float GetZ() {return this.CMat[2][0];}

    public float[][] Rotation(){

        float[][] Rota = CMat;

        for ( int i = 0; i < 4; ++i){
            for (int j = 0 ; j < 4; ++j ){
                Rota[j][i] = getCMat()[j][i] * getCVect()[0][j];
            }
        }

        return Rota;


    }

    public float[][] Translation(){

        float[][] Trans = CVect;

        for ( int i = 0; i < 4; ++i){
            for (int j = 0 ; j < 4; ++j ){
                CMat[j][i] = getCMat()[j][i] * getCVect()[0][j];
            }
        }

        for (int i= 0; i < 4; ++i){

            Trans[0][i]= getCMat()[0][i] + getCMat()[1][i] + getCMat()[2][i] + getCMat()[3][i];
        }

        return Trans;
    }


    public void Afficher(){
        for (int i = 0 ; i< 4;++i){
            for (int j = 0; j < 4; ++j){
                if ( j == 3)
                    System.out.print(this.getCMat()[i][j]+ "\n" );
                else
                    System.out.print(this.getCMat()[i][j] + " " );
            }

        }
    }

    public static void main(String[] args){
        CMatrix Mat = new CMatrix();
        Mat.Afficher();




    }

}//Classe Matrice qui contiendras tt les fonction liée au mathématique
