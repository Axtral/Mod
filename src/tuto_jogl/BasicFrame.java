package tuto_jogl;

import com.jogamp.graph.geom.Triangle;
import com.jogamp.nativewindow.util.*;
import com.jogamp.opengl.*;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.nativewindow.util.Dimension;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;


import javax.swing.JFrame;
import java.awt.*;

/**
 * Created by Alexandre on 04/10/2016.
 */
public class BasicFrame implements GLEventListener {


    @Override
    public void init(GLAutoDrawable arg0) {
    }

    @Override
    public void dispose(GLAutoDrawable arg0) {

    }

    @Override
    public void display(GLAutoDrawable drawable) {
        final GL2 gl = drawable.getGL().getGL2();

        gl.glBegin(GL2.GL_QUADS);

        gl.glVertex3f( 0.0f,0.75f,0);
        gl.glVertex3f(-0.75f,0f,0);
        gl.glVertex3f(0f,-0.75f,0);
        gl.glVertex3f(0.75f,0f,0);

        gl.glEnd();


    }

    @Override
    public void reshape(GLAutoDrawable arg0, int arg1, int arg2, int arg3, int arg4) {

    }

    public static void main( String[] args ){

        final GLProfile profile = GLProfile.get( GLProfile.GL2 );
        GLCapabilities capabilities = new GLCapabilities( profile );


        final GLCanvas glcanvas = new GLCanvas( capabilities );


        BasicFrame b = new BasicFrame();
        //GLEventListener Interface;
        glcanvas.addGLEventListener( b);
        glcanvas.setSize( 400 , 400 );

        final JFrame frame  = new JFrame ( "Faire une ligne");

        frame.getContentPane().add( glcanvas);
        frame.setSize(frame.getContentPane().getPreferredSize());
        //frame.setSize( 640, 400);

        frame.setVisible( true);


    }//main

}
