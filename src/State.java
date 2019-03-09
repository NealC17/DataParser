import java.util.ArrayList;
import java.util.List;

public class State {
    private String state;
    private List<County> counties;

    public State(String state) {
        this.state = state;
        counties = new ArrayList<>();
    }


}
