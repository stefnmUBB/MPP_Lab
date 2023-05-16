import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class MainFile {
    public static void main(String[] args){
        Properties props=new Properties();
        try {
            props.load(new FileReader("file.properties"));
            System.out.println((new File(".")).getAbsolutePath());

        } catch (IOException e) {
            System.out.println("Cannot find file.properties "+e);
        }

        DeviceRepository deviceRepo=new DeviceFileRepository(props);
        deviceRepo.add(new Device("SolidBook","Toshiba", 131678, 2007));
        System.out.println("Toate device-urile din db");
        for(var device:deviceRepo.findAll()){
            System.out.println(device);
        }

        String manufacturer="Lenovo";
        System.out.println("Deviceuri produse de "+manufacturer);
        for(var device:deviceRepo.findByManufacturer(manufacturer))
            System.out.println(device);
    }
}
