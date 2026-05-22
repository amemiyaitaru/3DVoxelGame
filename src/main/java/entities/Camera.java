package entities;

import org.joml.Vector3f;
import renderEngine.DisplayManager;

import static org.lwjgl.glfw.GLFW.*;


public class Camera {
    
    private Vector3f position = new Vector3f(0,0,0);
    private float pitch; //how high or low the camera is aimed
    private float yaw; //how much left or right the camera is aiming
    private float roll; //how much the camera is titled to one side

    public Camera(){}

    public void move(){
        if(DisplayManager.isKeyDown(GLFW_KEY_W)){
            position.z -= 0.02f;
        }
        if(DisplayManager.isKeyDown(GLFW_KEY_S)){
            position.z += 0.02f;
        }
        if(DisplayManager.isKeyDown(GLFW_KEY_D)){
            position.x += 0.02f;
        }
        if(DisplayManager.isKeyDown(GLFW_KEY_A)){
            position.x -= 0.02f;
        }
        if(DisplayManager.isKeyDown(GLFW_KEY_SPACE)){
            position.y += 0.02f;
        }
        if(DisplayManager.isKeyDown(GLFW_KEY_LEFT_SHIFT)){
            position.y -= 0.02f;
        }
    }

    public Vector3f getPosition() {
        return position;
    }

    public float getPitch() {
        return pitch;
    }

    public float getYaw() {
        return yaw;
    }

    public float getRoll() {
        return roll;
    }
}
