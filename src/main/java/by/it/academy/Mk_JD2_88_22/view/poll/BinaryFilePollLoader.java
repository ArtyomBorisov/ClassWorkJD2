package by.it.academy.Mk_JD2_88_22.view.poll;

import by.it.academy.Mk_JD2_88_22.view.api.IPollLoader;
import by.it.academy.Mk_JD2_88_22.view.api.IPollService;
import by.it.academy.Mk_JD2_88_22.model.SavedPoll;

import java.io.*;
import java.nio.file.Path;
import java.util.List;

public class BinaryFilePollLoader implements IPollLoader {

    private final IPollService pollService;

    public BinaryFilePollLoader(IPollService pollService){
        this.pollService = pollService;
    }

    @Override
    public void load(String filePath) {
        try{
            File file = Path.of(filePath).toFile();

            if(file.exists()){
                if(pollService instanceof PollService) {
                    PollService service = (PollService) pollService;

                    try(ObjectInputStream reader = new ObjectInputStream(new FileInputStream(file))){
                        Object line = null;
                        while((line = reader.readObject()) != null){

                            service.createPoll((SavedPoll) line);
                        }
                    } catch (ClassNotFoundException e) {
                        throw new IllegalArgumentException("Мы не можем десериализовать объект", e);
                    } catch (EOFException ignored){
                        //всё ок, файл дочитался
                    }
                }
            }
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException("Невозможно открыть файл для загрузки состояния", e);
        } catch (IOException e) {
            throw new IllegalArgumentException("Невозможно считывать файл состояния", e);
        }
    }

    @Override
    public void unload(String filePath) {
        try{
            File file = Path.of(filePath).toFile();

            file.createNewFile();

            List<SavedPoll> polls = pollService.getPolls();

            try(ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(file))){

                for (SavedPoll savedPoll : polls) {

                    writer.writeObject(savedPoll);
                }
            }
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException("Невозможно открыть файл для загрузки состояния", e);
        } catch (IOException e) {
            throw new IllegalArgumentException("Невозможно считывать файл состояния", e);
        }
    }
}
