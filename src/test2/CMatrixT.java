package test2;

/**
 * Created by b15010542 on 21/10/16.
 */
public class CMatrixT {
}

/*    */ //import java.io.PrintStream;
/*    */
/*    */ public class CMatrix {
    /*    */   private float[][] m_content;
    /*    */
/*  8 */   float[][] GetContent() { return this.m_content; }
    /*    */
/*    */   void SetContent(float[][] content)
/*    */   {
/* 12 */     this.m_content = content;
/*    */   }
    /*    */
/*    */   float GetX() {
/* 16 */     return this.m_content[0][0];
/*    */   }
    /*    */
/*    */   float GetY() {
/* 20 */     return this.m_content[1][0];
/*    */   }
    /*    */
/*    */   float GetZ() {
/* 24 */     return this.m_content[2][0];
/*    */   }
    /*    */
/*    */   public CMatrix(float[][] content)
/*    */   {
/* 29 */     this.m_content = content;
/*    */   }
    /*    */
/*    */   public CMatrix(float Tx, float Ty, float Tz) {
/* 33 */     this(new float[][] { { 1.0F, 0.0F, 0.0F, Tx }, { 0.0F, 1.0F, 0.0F, Ty }, { 0.0F, 0.0F, 1.0F, Tz }, { 0.0F, 0.0F, 0.0F, 1.0F } });
/*    */   }
/*    */
/*    */   public CMatrix Multiply(CMatrix Mat) {
/* 37 */     float[][] MatA = this.m_content;
/* 38 */     float[][] MatB = Mat.m_content;
/*    */
/*    */
/*    */
/*    */
/*    */
/* 44 */     if (MatA.length == MatB[0].length)
/*    */     {
/* 46 */       CMatrix Result = new CMatrix(new float[MatA.length][MatA[0].length]);
/* 47 */       float[][] MatR = Result.m_content;
/*    */
/* 49 */       for (int i = 0; i < MatR.length; i++)
/*    */       {
/* 51 */         float Case = 0.0F;
/*    */
/* 53 */         for (int j = 0; j < MatB[0].length; j++) {
/* 54 */           Case += MatA[j][0] * MatB[i][j];
/*    */         }
/*    */
/* 57 */         MatR[i][0] = Case;
/*    */       }
/*    */
/*    */
/* 61 */       Result.SetContent(MatR);
/* 62 */       return Result;
/*    */     }
/* 64 */     return null;
/*    */   }
    /*    */
/*    */   public void AfficherMat(float[][] mat, String Nom) {
/* 68 */     System.out.println(Nom + " :");
/* 69 */     for (int i = 0; i < mat.length; i++) {
/* 70 */       for (int j = 0; j < mat[i].length; j++)
/* 71 */         System.out.print(mat[i][j] + " ");
/* 72 */       System.out.println();
/*    */     }
/*    */   }
/*    */ }