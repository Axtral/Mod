package test.test_1;

/**
 * Created by a14010387 on 20/10/16.
 */
import java.awt.DisplayMode;

import javax.swing.JFrame;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.util.FPSAnimator;

public class TestDomino {

    public static DisplayMode dm, dm_old;
    private GLU glu = new GLU();
    private float rquad = 0.0f;
    private float rchute = 0.0f; //CHUTE

    @Override
    public void display( GLAutoDrawable drawable ) {

        final GL2 gl = drawable.getGL().getGL2();
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT );
        gl.glLoadIdentity();
        gl.glTranslatef( 0f, 0f, -12 ); // ZOOM

        // Rotate The Cube On X, Y & Z
        gl.glRotatef(50f, -5f,0f, 1f);//ORIENTATION CAMERA
        gl.glRotatef(rquad, 0f, 0f, 1f);	 // ROTATION (rquad décrémentée)



        gl.glRotatef(rchute, -1f, 0f, 0f);// CHUTE


        // PLACER CENTRE GRAVITE DU DOMINO EN BAS ET NON AU CENTRE /!\

        //giving different colors to different sides
        gl.glBegin(GL2.GL_QUADS); // Start Drawing The Cube
        gl.glColor3f(1f,0f,0f); //red color
        gl.glVertex3f( 1f, 0f,-0.5f); // Top Right Of The Quad (Top)
        gl.glVertex3f(-1f, 0f,-0.5f); // Top Left Of The Quad (Top)
        gl.glVertex3f(-1f, 0f, 2.5f ); // Bottom Left Of The Quad (Top)
        gl.glVertex3f( 1f, 0f, 2.5f ); // Bottom Right Of The Quad (Top)

        gl.glColor3f( 0f,1f,0f ); //green color
        gl.glVertex3f( 1f, -1f,  2.5f ); // Top Right Of The Quad
        gl.glVertex3f(-1f, -1f,  2.5f ); // Top Left Of The Quad
        gl.glVertex3f(-1f, -1f, -0.5f ); // Bottom Left Of The Quad
        gl.glVertex3f( 1f, -1f, -0.5f ); // Bottom Right Of The Quad

        gl.glColor3f( 0f,0f,1f ); //blue color
        gl.glVertex3f( 1f,  0f, 2.5f ); // Top Right Of The Quad (Front)
        gl.glVertex3f(-1f,  0f, 2.5f ); // Top Left Of The Quad (Front)
        gl.glVertex3f(-1f, -1f, 2.5f ); // Bottom Left Of The Quad
        gl.glVertex3f( 1f, -1f, 2.5f ); // Bottom Right Of The Quad

        gl.glColor3f( 1f,1f,0f ); //yellow (red + green)
        gl.glVertex3f( 1f,  0f, -0.5f ); // Bottom Left Of The Quad
        gl.glVertex3f(-1f,  0f, -0.5f ); // Bottom Right Of The Quad
        gl.glVertex3f(-1f, -1f, -0.5f ); // Top Right Of The Quad (Back)
        gl.glVertex3f( 1f, -1f, -0.5f ); // Top Left Of The Quad (Back)

        gl.glColor3f( 1f,0f,1f ); //purple (red + green)
        gl.glVertex3f(-1f,  0f,  2.5f ); // Top Right Of The Quad (Left)
        gl.glVertex3f(-1f,  0f, -0.5f ); // Top Left Of The Quad (Left)
        gl.glVertex3f(-1f, -1f, -0.5f ); // Bottom Left Of The Quad
        gl.glVertex3f(-1f, -1f,  2.5f ); // Bottom Right Of The Quad

        gl.glColor3f( 0f,1f, 1f ); //sky blue (blue +green)
        gl.glVertex3f(1f,  0f, -0.5f ); // Top Right Of The Quad (Right)
        gl.glVertex3f(1f,  0f,  2.5f ); // Top Left Of The Quad
        gl.glVertex3f(1f, -1f,  2.5f ); // Bottom Left Of The Quad
        gl.glVertex3f(1f, -1f, -0.5f ); // Bottom Right Of The Quad
        gl.glEnd(); // Done Drawing The Quad
        gl.glFlush();

        rquad -= 0.6f;	// INCREMENTATION ROTATION
        if (rchute != 100) rchute += 1; // CHUTE
        //if (rchute ==100) rchute = 0; REINIT ROTATION CHUTE
    }
    @Override
    public void dispose( GLAutoDrawable drawable ) {
        // TODO Auto-generated method stub
    }

    @Override
    public void init( GLAutoDrawable drawable ) {

        final GL2 gl = drawable.getGL().getGL2();
        gl.glShadeModel( GL2.GL_SMOOTH );
        gl.glClearColor( 0f, 0f, 0f, 0f );
        gl.glClearDepth( 1.0f );
        gl.glEnable( GL2.GL_DEPTH_TEST );
        gl.glDepthFunc( GL2.GL_LEQUAL );
        gl.glHint( GL2.GL_PERSPECTIVE_CORRECTION_HINT, GL2.GL_NICEST );
    }

    @Override
    public void reshape( GLAutoDrawable drawable, int x, int y, int width, int height ) {

        // TODO Auto-generated method stub
        final GL2 gl = drawable.getGL().getGL2();
        if( height == 0 )
            height = 1;

        final float h = ( float ) width / ( float ) height;
        gl.glViewport( 0, 0, width, height );
        gl.glMatrixMode( GL2.GL_PROJECTION );
        gl.glLoadIdentity();

        glu.gluPerspective( 45.0f, h, 1.0, 20.0 );
        gl.glMatrixMode( GL2.GL_MODELVIEW );
        gl.glLoadIdentity();
    }

    public static void main( String[] args ) {

        final GLProfile profile = GLProfile.get( GLProfile.GL2 );
        GLCapabilities capabilities = new GLCapabilities( profile );

        // The canvas
        final GLCanvas glcanvas = new GLCanvas( capabilities );
        Cube cube = new Cube();

        glcanvas.addGLEventListener( cube );
        glcanvas.setSize( 400, 400 );

        final JFrame frame = new JFrame ( " Multicolored cube" );
        frame.getContentPane().add( glcanvas );
        frame.setSize( frame.getContentPane().getPreferredSize() );
        frame.setVisible( true );
        final FPSAnimator animator = new FPSAnimator(glcanvas, 300,true);

        animator.start();
    }

}
}
