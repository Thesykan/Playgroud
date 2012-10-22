//  Lamp
//  James E. Ames IV

import java.awt.*;
import java.awt.event.*;
import java.nio.*;

import javax.swing.*;
import javax.media.opengl.*;
import javax.media.opengl.awt.*;
import javax.media.opengl.glu.*;
import com.jogamp.opengl.util.*;

class PG implements GLEventListener, MouseListener, MouseMotionListener, KeyListener
{
   private PGDef lamp1;
   private GLU glu = new GLU();
   public int ex,ey,ez,lx,ly,lz;

   
    public static void main(String[] args)
    {
	// Window setup
    	
//        GLProfile.initSingleton(true);
        System.setProperty("sun.awt.noerasebackground", "true"); // sometimes necessary to avoid erasing the finished window
		
        JFrame frame = new JFrame("Cube");
        GLCanvas canvas = new GLCanvas();
        canvas.setPreferredSize(new Dimension(600,600));  // desired size, not guaranteed
		
        
        
        PG renderer = new PG();
        canvas.addKeyListener(renderer);
        canvas.addGLEventListener(renderer);
		
        frame.getContentPane().setLayout(new BorderLayout());
        frame.getContentPane().add(canvas, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack(); // make just big enough to hold objects inside
        frame.setVisible(true);
				
        Animator animator = new Animator(canvas);
        animator.start();
		
	
	}

    public void init(GLAutoDrawable drawable)
    {
	   // Initial drawing things
		GL2 gl = drawable.getGL().getGL2();
        gl.setSwapInterval(1); // for animation synchronized to refresh rate
        gl.glClearColor(0f,0f,0f,1f); // white background
		gl.glPointSize(2.0f);
		
       gl.glShadeModel(GL2.GL_SMOOTH);				// smooth or flat 		
       gl.glClearDepth(1.0f);			// depth handling routines	
       gl.glEnable(GL2.GL_DEPTH_TEST);	
       gl.glDepthFunc(GL2.GL_LEQUAL);
       //  How nice is the drawing?
       gl.glHint(GL2.GL_PERSPECTIVE_CORRECTION_HINT, GL2.GL_NICEST);
       
       
       
       ex = 15;
       ey = 4;
       ez = 25;
       lx = 0;
       ly = 5;
       lz = 9;










		
		
       lamp1 = new PGDef(gl);		// make a quadric
	}


    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height)
    {
	   GL2 gl = drawable.getGL().getGL2();

       if(height <= 0) height = 1;
       final float aspect = (float)width / (float)height;	// aspect
       
       gl.glMatrixMode(GL2.GL_PROJECTION);
       gl.glLoadIdentity();
       glu.gluPerspective(90.0f, 1, 0.5, 100.0);	//fov  angle in degrees of view,aspect near, far	
       gl.glMatrixMode(GL2.GL_MODELVIEW);
       gl.glLoadIdentity();

	}

    public void display(GLAutoDrawable drawable)
    {
		GL2 gl = drawable.getGL().getGL2();

		
		gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);
		gl.glLoadIdentity();
		glu.gluLookAt(ex,ey,ez, 		// eye location
						lx,ly,lz,			// point to look at (near middle)
					   0f,1f,0f); 		// the "up" direction (y)
		

		lamp1.draw(gl);
		
		// check for errors, at least once per frame
		int error = gl.glGetError();
		if (error != GL.GL_NO_ERROR)
			System.out.println("OpenGL Error: " );
	}

    
	public void dispose(GLAutoDrawable drawable) {
    }
	
    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged)
    {
    }

    public void mouseEntered(MouseEvent e)
    {
    }

    public void mouseExited(MouseEvent e)
    {
    }

    public void mousePressed(MouseEvent e)
    {
    }

    public void mouseReleased(MouseEvent e)
    {
    }

    public void mouseClicked(MouseEvent e)
    {
    }

    public void mouseDragged(MouseEvent e)
    {
    }

    public void mouseMoved(MouseEvent e)
    {
    }

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		int Key = e.getKeyCode();
		
		//System.out.println(Key);
		
		if (Key == 40) // up
		{
			ly-=1;
		}
		else if(Key == 38) //down
		{
			ly+=1;
		}
		
		
		/*if (Key == 100)
		{
			lx+=1;
		}
		else if(Key == 101)
		{
			lx-=1;
		}*/
		
		if (Key == 39) // Look Right
		{
			lz+=11;
		}
		else if(Key == 37) // Look Left
		{
			lz-=11;
		}
		
		
		if (Key == 103)
		{
			ey+=1;
		}
		else if(Key == 104)
		{
			ey-=1;
		}
		
		
		if (Key == 65) //left
		{
			ex+=1;
		}
		else if(Key == 68) //right
		{
			ex-=1;
		}
		
		if (Key == 83) //back
		{
			ez+=1;
		}
		else if(Key == 87) //foward
		{
			ez-=1;
		}
		
		
		if (Key == 32) //back
		{
			System.out.println("ex = "+ex+";");
			System.out.println("ey = "+ey+";");
			System.out.println("ez = "+ez+";");
			System.out.println("lx = "+lx+";");
			System.out.println("ly = "+ly+";");
			System.out.println("lz = "+lz+";");
			System.out.println("");
		}
		
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


}
