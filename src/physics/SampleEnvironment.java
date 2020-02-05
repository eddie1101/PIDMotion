package physics;

public class SampleEnvironment extends Environment {

    public SampleEnvironment(float uFric, float g){
        super(uFric, g);
    }

    @Override
    public void update() {
        updateFrictionVectors();
    }
}
