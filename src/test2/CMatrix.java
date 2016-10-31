package test2;

/**
 * Created by c14012299 on 14/10/2016.
 */
public class CMatrix {

    private float[][] CMat = new  float[4][4]; // faut pas l'init juste la declarer normalement?


    public CMatrix(){



      //  CMat

    }// Crée la matrice qui sera utilisé pour la Translation et la Rotation


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

    public float[][] getCMat(){
        return this.CMat;
    }

    public void setCMat(float[][] Mat) {
        this.CMat = Mat;
    }

    float GetX(){
        return this.CMat[0][0];
    }

    public void Rotation(CMatrix Mat){

    }

    public void Translation(CMatrix Mat){

    }

    public static void main(String[] args){
        CMatrix Mat = new CMatrix();
        Mat.Afficher();




    }

}//Classe Matrice qui contiendras tt les fonction liée au mathématique
