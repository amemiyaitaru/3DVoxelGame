package renderEngine;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.system.MemoryUtil.NULL;

public class DisplayManager {

    private static final int WIDTH = 1280;
    private static final int HEIGHT = 720;
    private static final int FPS_CAP = 1000;
    private static final String title = "3D Voxel Game";

    private static long window;
    private static boolean isVsyncEnabled = true;


    public static void createDisplay(){
        if(!glfwInit()){
            throw new Error("Unable to initialize GLFW");
        }

        glfwWindowHint(GLFW_CONTEXT_VERSION_MAJOR, 3);
        glfwWindowHint(GLFW_CONTEXT_VERSION_MINOR, 2);
        glfwWindowHint(GLFW_OPENGL_PROFILE, GLFW_OPENGL_CORE_PROFILE);
        glfwWindowHint(GLFW_OPENGL_FORWARD_COMPAT, GLFW_TRUE);

        glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE);

        window = glfwCreateWindow(WIDTH, HEIGHT, title, NULL, NULL);
        if (window == NULL){
            throw new RuntimeException("Failed to create the GLFW window");
        }

        glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE);

        glfwMakeContextCurrent(window);
        GL.createCapabilities();


        glfwSetFramebufferSizeCallback(window, (win, width, height) -> {
            GL11.glViewport(0, 0, width, height);
        });

        glfwSwapInterval(isVsyncEnabled ? 1 : 0);
        glfwShowWindow(window);
    }

    public static void toggleVSync(){
        isVsyncEnabled = !isVsyncEnabled;
        glfwSwapInterval(isVsyncEnabled ? 1 : 0);
    }

    public static void updateDisplay(){
    glfwSwapBuffers(window);
    glfwPollEvents();
    }

    public static void closeDisplay(){
    glfwDestroyWindow(window);
    glfwTerminate();
    }

    public static boolean isCloseRequested() {
        return glfwWindowShouldClose(window);
    }

    public static int getWidth() {
        return WIDTH;
    }

    public static int getHeight() {
        return HEIGHT;
    }

    public static boolean isKeyDown(int keycode) {
        return glfwGetKey(window, keycode) == GLFW_PRESS;
    }

}
