import data_generator.GenerateModel;
import data_generator.GenerateModelFactory;
import data_generator.data.NeededData;
import org.junit.Test;

public class GenerateModelFactoryTest {

    @Test
    public void generateModelFactory() throws Exception {
        GenerateModel model = new NeededData();
        GenerateModelFactory factory = new GenerateModelFactory(model,10);
        factory.export("C:/Git_Projects/output.csv");
    }
}
