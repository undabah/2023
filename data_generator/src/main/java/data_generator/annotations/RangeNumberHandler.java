package data_generator.annotations;

import java.util.Random;

public class RangeNumberHandler extends ExpressionHandler{

    Random random = new Random();

    @Override
    public int handle(int upperbound) {
        int int_random = random.nextInt(upperbound);
        return int_random;
    }

}
