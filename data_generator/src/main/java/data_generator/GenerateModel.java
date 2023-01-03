package data_generator;

import data_generator.annotations.Range;
import data_generator.annotations.RangeNumberHandler;
import lombok.Getter;

import java.lang.reflect.Field;

public class GenerateModel implements Cloneable{

    @Getter
    private String[] titles;

    @Getter
    private int[] values;

    public void generate() throws Exception {
        Class<?> clazz = this.getClass();

        titles = new String[clazz.getDeclaredFields().length];
        values = new int[clazz.getDeclaredFields().length];

        RangeNumberHandler rangeNumberHandler = new RangeNumberHandler();
        int index = 0;
        for(Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);

            if(field.isAnnotationPresent(Range.class)){
                String keyName = field.getAnnotation(Range.class).key();
                this.titles[index] = keyName;
                this.values[index] = rangeNumberHandler.handle(100);
            }
            index++;
        }
    }
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String[] getTitles() {
        return titles;
    }

    public int[] getValues() {
        return values;
    }
}
