package thread.race;

/**
 * Created by fanwei_last on 2017/11/10.
 */
public class LetOneStop implements StopCallBack{

    private Animal animal;

    public LetOneStop(Animal animal){
        this.animal = animal;
    }

    @Override
    public void win() {
        try {
            animal.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
