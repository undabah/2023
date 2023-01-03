package data_generator;

import lombok.Getter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GenerateModelFactory {

    @Getter
    List<GenerateModel> modelList = new ArrayList<>();

    public GenerateModelFactory(GenerateModel model, int count) throws Exception {
        for(int i=0; i< count; i++) {
            GenerateModel modelClone = (GenerateModel) model.clone();
            modelClone.generate();
            modelList.add(modelClone);
        }
    }
    public void export(String path) throws IOException {
        File outputFile = new File(path);
        if(!outputFile.exists())
            (new File(outputFile.getParent())).mkdir();
        try(FileWriter writer = new FileWriter(outputFile.getPath())) {
            writer.write(String.join(",",modelList.get(0).getTitles() + "\n"));
            for(int i=0 ; i < modelList.size(); i++){
                writer.write(String.join(",",modelList.get(i).getValues() + "\n"));
                writer.flush();
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

}
