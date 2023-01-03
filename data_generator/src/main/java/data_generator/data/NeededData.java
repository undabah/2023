package data_generator.data;

import data_generator.GenerateModel;
import data_generator.annotations.Range;

public class NeededData extends GenerateModel {
    @Range(key = "Id")
    private String ID;
    @Range(key = "Number")
    private String Number;
}
