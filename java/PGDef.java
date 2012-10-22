
//Simple Lamp

import javax.media.opengl.*;
import javax.media.opengl.awt.*;
import javax.media.opengl.glu.*;

import java.io.InputStream;
import java.io.IOException;
import java.io.*;

class PGDef
{
private GLUquadric quadric; 	// to control properties of quadric-based objects here

private GLCanvas canvas;    
private GLU glu = new GLU();
private float size;
private float rotateT = 0.0f;
private float rotateX = 45.0f;


public PGDef(GL2 gl) 
{
    this.canvas = canvas;
    quadric = glu.gluNewQuadric();
    glu.gluQuadricDrawStyle(quadric, GLU.GLU_FILL); // GLU_POINT, GLU_LINE, GLU_FILL, GLU_SILHOUETTE
    glu.gluQuadricNormals  (quadric, GLU.GLU_NONE); // GLU_NONE, GLU_FLAT, or GLU_SMOOTH
    glu.gluQuadricTexture  (quadric, false);        // use true to generate texture coordinates
}

public void draw(GL2 gl)
{
	/*
	 prototypes:
	 glu.gluSphere(quadric,  radius, slices, stacks)
	 glu.gluCylinder (quadric, base, top, height, slices, stacks)
	 glu.gluDisk(quadric, inner radius, outer radius, slices, stacks)
	 */
	//gl.glPushMatrix();
	//glu.gluSphere(quadric,2.5,10,10);
	//gl.glPopMatrix();
	
	
	
	/*gl.glColor3f(1f, .5f, .5f);
	gl.glPushMatrix();
	gl.glTranslatef(0f,0f,0f);
	gl.glRotatef(-90f, 1f, 0f, 0f); 			// stand upright (Y)
	glu.gluDisk(quadric, 0., 100, 10,10);
	gl.glPopMatrix();*/
	gl.glPushMatrix();
	// Rotation stuff
	gl.glRotatef(rotateX, 1.0f, 0.0f, 0.0f);
    gl.glRotatef(rotateT, 0.0f, 1.0f, 0.0f);
    gl.glRotatef(rotateT, 0.0f, 0.0f, 1.0f);
    rotateT += 0.2f;	// speed of rotation
	
	gl.glPushMatrix();
	gl.glTranslatef(-6f,-2f,-5f);
	Frame(gl);
	Swings(gl);
	Diskhandles(gl);
	Slide(gl);
	gl.glPopMatrix();
	gl.glPopMatrix();


	
}

public void Frame(GL2 gl){
	
	// Full Frame
	gl.glPushMatrix();
	//First A Frame
	gl.glPushMatrix();
	// A Frame Leg1
	gl.glColor3f(.8f, .5f, .1f);
	gl.glPushMatrix();
	gl.glRotatef(-45f, 1f, 0f, 0f); 			// stand upright (Y)
	glu.gluCylinder(quadric, .5, .5, 10., 10, 10);
	gl.glPopMatrix();

	// A Frame Leg2
	gl.glPushMatrix();
	gl.glTranslatef(0f, 0f,13.6f);
	gl.glRotatef(-135f, 1f, 0f, 0f); 			// stand upright (Y)
	glu.gluCylinder(quadric, .5, .5, 10., 10, 10);
	gl.glPopMatrix();
	
	// A Frame Support
	gl.glPushMatrix();
	gl.glTranslatef(0f, 3f,3f);
	//gl.glRotatef(0f, 1f, 0f, 0f); 			// stand upright (Y)
	glu.gluCylinder(quadric, .5, .5, 7.4, 10, 10);
	gl.glPopMatrix();
	gl.glPopMatrix();
	
	//Second A Frame
	gl.glPushMatrix();
	gl.glTranslatef(15f, 0f,0f);
	// A Frame Leg1
	gl.glPushMatrix();
	gl.glRotatef(-45f, 1f, 0f, 0f); 			// stand upright (Y)
	glu.gluCylinder(quadric, .5, .5, 10., 10, 10);
	gl.glPopMatrix();

	// A Frame Leg2
	gl.glPushMatrix();
	gl.glTranslatef(0f, 0f,13.6f);
	gl.glRotatef(-135f, 1f, 0f, 0f); 			// stand upright (Y)
	glu.gluCylinder(quadric, .5, .5, 10., 10, 10);
	gl.glPopMatrix();
	
	// A Frame Support
	gl.glPushMatrix();
	gl.glTranslatef(0f, 3f,3f);
	//gl.glRotatef(0f, 1f, 0f, 0f); 			// stand upright (Y)
	glu.gluCylinder(quadric, .5, .5, 7.4, 10, 10);
	gl.glPopMatrix();
	gl.glPopMatrix();

	
	gl.glPushMatrix();
	gl.glTranslatef(15f, 7f,7f);
	gl.glRotatef(-90f, 0f, 1f, 0f); 			// stand upright (Y)
	glu.gluCylinder(quadric, .5, .5, 15, 10, 10);
	gl.glPopMatrix();
	gl.glPopMatrix();
	
	
	
	
	
}

public void Swings(GL2 gl){
	
	gl.glPushMatrix();
	gl.glTranslatef(13.5f, 1.5f,7f);
	
	gl.glRotatef(-90f, 0f, 1f, 0f); 

	gl.glPushMatrix();
	gl.glColor3f(.7f, .7f, .7f);
	gl.glPushMatrix();
	gl.glRotatef(-90f, 1f, 0f, 0f); 			// stand upright (Y)
	glu.gluCylinder(quadric, .1, .1, 5., 10, 10);
	gl.glPopMatrix();
	gl.glPushMatrix();
	gl.glTranslatef(0f, 0f,2.5f);
	gl.glRotatef(-90f, 1f, 0f, 0f); 			// stand upright (Y)
	glu.gluCylinder(quadric, .1, .1, 5., 10, 10);
	gl.glPopMatrix();
	gl.glPushMatrix();
	gl.glTranslatef(.3f, 0f,1.3f);
	gl.glRotatef(-90f, 1f, 0f, 0f); 			// stand upright (Y)
	gl.glColor3f(.8f, .3f, .2f);
	glu.gluDisk(quadric, 0., 1.35, 10,10);
	gl.glPopMatrix();
	gl.glPopMatrix();
	gl.glPushMatrix();
	gl.glColor3f(.7f, .7f, .7f);
	gl.glTranslatef(0f, 0f,4f);
	gl.glPushMatrix();
	gl.glRotatef(-90f, 1f, 0f, 0f); 			// stand upright (Y)
	glu.gluCylinder(quadric, .1, .1, 5., 10, 10);
	gl.glPopMatrix();
	gl.glPushMatrix();
	gl.glTranslatef(0f, 0f,2.5f);
	gl.glRotatef(-90f, 1f, 0f, 0f); 			// stand upright (Y)
	glu.gluCylinder(quadric, .1, .1, 5., 10, 10);
	gl.glPopMatrix();
	gl.glPushMatrix();
	gl.glTranslatef(.3f, 0f,1.3f);
	gl.glRotatef(-90f, 1f, 0f, 0f); 			// stand upright (Y)
	gl.glColor3f(.8f, .3f, .2f);
	glu.gluDisk(quadric, 0., 1.35, 10,10);
	gl.glPopMatrix();
	gl.glPopMatrix();
	gl.glPopMatrix();
	
	
	
}

public void Diskhandles(GL2 gl){
	
	gl.glPushMatrix();
	gl.glTranslatef(2f,.8f,7.2f);
	gl.glScalef(.4f, .4f, .4f);
	
	
	gl.glPushMatrix();
	gl.glColor3f(.25f, .25f, .25f);
	gl.glTranslatef(0f,10f,0f);
	gl.glRotatef(-90f, 0f, 0f, 1f); 			// stand upright (Y)
	glu.gluDisk(quadric, 1., 2.5, 10,10);
	gl.glPopMatrix();
	
	gl.glPushMatrix();
	gl.glTranslatef(6.5f,10f,0f);
	gl.glRotatef(-90f, 0f, 0f, 1f); 			// stand upright (Y)
	glu.gluDisk(quadric, 1., 2.5, 10,10);
	gl.glPopMatrix();
	gl.glColor3f(.5f, .5f, .5f);
	gl.glPushMatrix();
	gl.glTranslatef(0f,12.5f,-.20f);
	gl.glRotatef(-90f, 1f, 0f, 0f); 
	glu.gluCylinder(quadric, .5, .5, 2.5, 10, 10);
	gl.glPopMatrix();
	
	gl.glPushMatrix();
	gl.glTranslatef(6.5f,12.5f,-.20f);
	gl.glRotatef(-90f, 1f, 0f, 0f); 
	glu.gluCylinder(quadric, .5, .5, 2.5, 10, 10);
	gl.glPopMatrix();
	gl.glPopMatrix();
}

public void Slide(GL2 gl){
	
	
	gl.glPushMatrix();
	gl.glTranslatef(-3.9f,-3f,6f);	
	
	
	gl.glColor3f(.5f, .25f, .12f);
	gl.glPushMatrix();
	gl.glTranslatef(0f,10f,0f);
	gl.glRotatef(45f, 1f, 0f, 0f); 			// stand upright (Y)
	glu.gluCylinder(quadric,.5,.5,10,10,10);
	gl.glPopMatrix();
	gl.glPushMatrix();
	gl.glTranslatef(1f,10f,0f);
	gl.glRotatef(45f, 1f, 0f, 0f); 			// stand upright (Y)
	glu.gluCylinder(quadric,.5,.5,10,10,10);
	gl.glPopMatrix();
	gl.glPushMatrix();
	gl.glTranslatef(2f,10f,0f);
	gl.glRotatef(45f, 1f, 0f, 0f); 			// stand upright (Y)
	glu.gluCylinder(quadric,.5,.5,10,10,10);
	gl.glPopMatrix();
	gl.glPushMatrix();
	gl.glTranslatef(3f,10f,0f);
	gl.glRotatef(45f, 1f, 0f, 0f); 			// stand upright (Y)
	glu.gluCylinder(quadric,.5,.5,10,10,10);
	gl.glPopMatrix();
	
	
	gl.glPushMatrix();
	gl.glTranslatef(3.5f,10f,0f);
	gl.glRotatef(-90f, 0f, 1f, 0f); 			// stand upright (Y)
	glu.gluCylinder(quadric,.5,.5,4,10,10);
	gl.glPopMatrix();
	gl.glPushMatrix();
	gl.glTranslatef(3.5f,10f,-1f);
	gl.glRotatef(-90f, 0f, 1f, 0f); 			// stand upright (Y)
	glu.gluCylinder(quadric,.5,.5,4,10,10);
	gl.glPopMatrix();
	gl.glPushMatrix();
	gl.glTranslatef(3.5f,10f,-2f);
	gl.glRotatef(-90f, 0f, 1f, 0f); 			// stand upright (Y)
	glu.gluCylinder(quadric,.5,.5,4,10,10);
	gl.glPopMatrix();
	gl.glPushMatrix();
	gl.glTranslatef(3.5f,10f,-3f);
	gl.glRotatef(-90f, 0f, 1f, 0f); 			// stand upright (Y)
	glu.gluCylinder(quadric,.5,.5,4,10,10);
	gl.glPopMatrix();
	gl.glPushMatrix();
	gl.glTranslatef(3.5f,10f,-4f);
	gl.glRotatef(-90f, 0f, 1f, 0f); 			// stand upright (Y)
	glu.gluCylinder(quadric,.5,.5,4,10,10);
	gl.glPopMatrix();
	
	//Supports
	gl.glPushMatrix();
	gl.glTranslatef(3.5f,3f,-4f);
	gl.glRotatef(-90f, 1f, 0f, 0f); 			// stand upright (Y)
	glu.gluCylinder(quadric,.5,.5,8,10,10);
	gl.glPopMatrix();
	gl.glPushMatrix();
	gl.glTranslatef(0f,3f,-4f);
	gl.glRotatef(-90f, 1f, 0f, 0f); 			// stand upright (Y)
	glu.gluCylinder(quadric,.5,.5,8,10,10);
	gl.glPopMatrix();
	
	//Ladder
	gl.glPushMatrix();
	gl.glTranslatef(3.5f,8f,-4f);
	gl.glRotatef(-90f, 0f, 1f, 0f); 			// stand upright (Y)
	glu.gluCylinder(quadric,.5,.5,4,10,10);
	gl.glPopMatrix();
	
	gl.glPushMatrix();
	gl.glTranslatef(3.5f,6f,-4f);
	gl.glRotatef(-90f, 0f, 1f, 0f); 			// stand upright (Y)
	glu.gluCylinder(quadric,.5,.5,4,10,10);
	gl.glPopMatrix();
	
	gl.glPushMatrix();
	gl.glTranslatef(3.5f,4f,-4f);
	gl.glRotatef(-90f, 0f, 1f, 0f); 			// stand upright (Y)
	glu.gluCylinder(quadric,.5,.5,4,10,10);
	gl.glPopMatrix();
	
	gl.glPopMatrix();
	
	
	
}


}
