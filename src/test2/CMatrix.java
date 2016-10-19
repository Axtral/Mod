package test2;

/**
 * Created by c14012299 on 14/10/2016.
 */
public class CMatrix {

    private int[][] CMat = new  int[4][4];

    public CMatrix(){

        for(int i = 0 ; i < 4 ; ++i){
            for (int j = 0; j < 4 ; ++j){
                CMat[i][j] = 0;
            }
        }

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

    public int[][] getCMat(){
        return CMat;
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
