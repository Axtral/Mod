package Projet;


/**
 * Created by c14012299 on 14/10/2016.
 */

public class CMatrix extends CVecteur{

    private float[][] CMat; //DECLARATION DE LA MATRICE

    public CMatrix(float[][] Matrice){ //CONSTRUCTEUR PAR DEFAUT

        this.CMat = Matrice;

    }//CMATRIX

    public void CreateCMatRotation(double teta) { //CREATION D'UNE MATRICE DE ROTATION
        /*
            ( cos  -sin   0  X)
            ( sin   cos   0  Y)
            (  0     0    1  Z)
            (  0     0    0  W)
         */

        float [][] MatriceRot = {
                { (float)Math.cos(teta), (float)-Math.sin(teta), 0.0F, 0.0F },
                { (float)Math.sin(teta), (float)Math.cos(teta), 0.0F, 0.0F },
                { 0.0F, 0.0F, 1.0F, 0.0F },
                { 0.0F, 0.0F, 0.0F, 1.0F } };

        CMat = MatriceRot;
    }//CREATECMATROTATION

    public float[][] getCMat(){
        return this.CMat;
    }

    public void setCMat(float[][] Mat) {
        this.CMat = Mat;
    }

    public float GetX(){
        return this.CMat[0][0];
    }

    public float GetY() {return this.CMat[1][0];}

    public float GetZ() {return this.CMat[2][0];}

    public float[][] Rotation(){//PERMET LA ROTATION D'UNE MATRICE
        float[][] Rota = CMat;
        for ( int i = 0; i < 4; ++i){
            for (int j = 0 ; j < 4; ++j ){
                Rota[j][i] = getCMat()[j][i] * getCVect()[0][j];
            }
        }
        return Rota;

    }//ROTATION

    public float[][] Multiply(CVecteur Vect) {//PERMET LA MULTIPLICATION D'UNE MATRICE PAR UN VECTEUR

        for ( int i = 0; i < Vect.GetLenght(); ++i){
            for (int j = 0 ; j < Vect.GetLenght(); ++j ){
                this.getCMat()[j][i] = this.getCMat()[j][i] * Vect.getCVect()[0][j];
            }
        }
        return this.getCMat();
    }//MULTIPLY

    public CVecteur Translation(CVecteur Vect){//PERMET LA TRANSFORMATION D'UNE MATRICE EN VECTEUR DE TRANSLATION

        this.setCMat(this.Multiply(Vect));
        for (int i= 0; i < 4; ++i){
            Vect.getCVect()[0][i]= this.getCMat()[0][i] + this.getCMat()[1][i] + this.getCMat()[2][i] + this.getCMat()[3][i];
        }
        return Vect;
    }//TRANSLATION

    public void Afficher(){
        for (int i = 0 ; i< 4;++i){
            for (int j = 0; j < 4; ++j){
                if ( j == 3)
                    System.out.print(this.getCMat()[i][j]+ "\n" );
                else
                    System.out.print(this.getCMat()[i][j] + " " );
            }
        }
    }//AFFICHER


}//CMATRIX
