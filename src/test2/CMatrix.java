package test2;

/**
 * Created by c14012299 on 14/10/2016.
 */
public class CMatrix {

    private float[][] CMat = new  float[4][4];
    private float[][] CVect = new float[0][4];


    public CMatrix(){


    }// Crée la matrice qui sera utilisé pour la Translation et la Rotation




    public float[][] getCMat(){
        return this.CMat;
    }

    public void setCMat(float[][] Mat) {
        this.CMat = Mat;
    }

    float GetX(){
        return this.CMat[0][0];
    }

    float GetY() {return this.CMat[1][0];}

    float GetZ() {return this.CMat[2][0];}

    public CMatrix Rotation(CMatrix Mat, float Angle){


    }

    public CMatrix Translation(CMatrix Mat, CMatrix Vect){

        for ( float i = 0; i < 4; ++i){
            for (float j = 0 ; j < 4; ++j ){
                Mat[j][i] = Mat[j][i] * Vect[0][j];
            }
        }

        return Mat;
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
