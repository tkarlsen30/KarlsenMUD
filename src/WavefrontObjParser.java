import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;

public class WavefrontObjParser {

	private String filepath;

	private ArrayList<Float> tempVertices;
	private ArrayList<Float> tempNormals;
	private ArrayList<Integer> tempElements;
	
	private float[] vertices;
	private float[] normals;
	private int[] elements;
	
	public WavefrontObjParser ( String filepath ) {
		
		this.filepath = filepath;
		
		tempVertices = new ArrayList<Float> ();
		tempNormals = new ArrayList<Float> ();
		tempElements = new ArrayList<Integer> ();
		
		parseFile ();
		
	}
	
	public float[] getVertices () {
		
		return vertices;
		
	}
	
	public float[] getNormals () {
		
		return normals;
		
	}
	
	public int[] getElements () {
		
		return elements;
		
	}
	
	public int getNumElements () {
		
		return tempElements.size ();
		
	}
	
	private void parseFile () {
		
		try ( BufferedReader reader = new BufferedReader ( new FileReader ( filepath ) ) ) {
			
			String line;
			
			while ( ( line = reader.readLine () ) != null ) {
				
				if ( line.startsWith ( "v " ) ) {
					
					String[] tokens = line.split ( " " );
					
					tempVertices.add ( Float.parseFloat ( tokens[1] ) );
					tempVertices.add ( Float.parseFloat ( tokens[2] ) );
					tempVertices.add ( Float.parseFloat ( tokens[3] ) );
					
				} else if ( line.startsWith ( "vn" ) ) {
					
					String[] tokens = line.split ( " " );
					
					tempNormals.add ( Float.parseFloat ( tokens[1] ) );
					tempNormals.add ( Float.parseFloat ( tokens[2] ) );
					tempNormals.add ( Float.parseFloat ( tokens[3] ) );
					
				} else if ( line.startsWith ( "f" ) ) {
					
					String[] tokens = line.split ( " " );
					
					String[] subTokens = tokens[1].split ( "/" );
					
					tempElements.add ( Integer.parseInt ( subTokens[0] ) - 1 );
					
					subTokens = tokens[2].split ( "/" );
					
					tempElements.add ( Integer.parseInt ( subTokens[0] ) - 1 );
					
					subTokens = tokens[3].split ( "/" );
					
					tempElements.add ( Integer.parseInt ( subTokens[0] ) - 1 );
					
				}
				
			}
			
			vertices = new float[tempVertices.size ()];
			
			for ( int i = 0; i < tempVertices.size (); i++ ) {
				
				vertices[i] = tempVertices.get ( i );
				
			}
			
			normals = new float[tempNormals.size ()];
			
			for ( int i = 0; i < tempVertices.size (); i++ ) {
				
				vertices[i] = tempVertices.get ( i );
				
			}

			elements = new int[tempElements.size ()];
			
			for ( int i = 0; i < tempElements.size (); i++ ) {
				
				elements[i] = tempElements.get ( i );
				
			}
			
		} catch ( FileNotFoundException e ) {
			
			System.out.println ( "Error. File " + filepath + " not found." );
			
		} catch ( IOException e ) {
			
			System.out.println ( "Error. Problem encountered with IO stream." );
			
		}
		
	}
	
}