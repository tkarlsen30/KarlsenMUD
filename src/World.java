import java.nio.FloatBuffer;
import java.nio.IntBuffer;

import com.jogamp.common.nio.Buffers;

public class World {

	private WavefrontObjParser worldParser;
	
	private FloatBuffer worldVertices;
	private FloatBuffer worldNormals;
	private IntBuffer worldElements;
	
	private int numWorldElements;

	public World () {
		
		worldParser = new WavefrontObjParser ( "/Users/tyler/eclipse-workspace/KarlsenMUD/src/starter.obj" );
		
		worldVertices = Buffers.newDirectFloatBuffer ( worldParser.getVertices () );
		worldNormals = Buffers.newDirectFloatBuffer ( worldParser.getNormals () );
		worldElements = Buffers.newDirectIntBuffer ( worldParser.getElements () );
		
		numWorldElements = worldParser.getNumElements ();
		
	}
	
	public FloatBuffer getWorldVertices () {
		
		return worldVertices;
		
	}
	
	public FloatBuffer getWorldNormals () {
		
		return worldNormals;
		
	}
	
	public IntBuffer getworldElements () {
		
		return worldElements;
		
	}
	
	public int getNumWorldElements () {
		
		return numWorldElements;
		
	}
	
}
